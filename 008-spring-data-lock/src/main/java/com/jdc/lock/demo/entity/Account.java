package com.jdc.lock.demo.entity;

import java.util.Map;

import com.jdc.lock.demo.entity.Address.Type;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.LockModeType;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.QueryHint;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(
		name = "Account.findByRole",
		query = "select a from Account a where a.email=?1",
		lockMode = LockModeType.PESSIMISTIC_WRITE,
		hints = {
				@QueryHint(name = "jakarta.persistence.lock.scope",value = "EXTENDED")
		}
		)
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	@NonNull
	@Column(nullable = false)
	@Nonnull
	private String email;
	@NonNull
	@Column(nullable = false)
	private String password;
	@NonNull
	@Column(nullable = false)
	private Role role;
	
	@Version
	private Integer version;
	
	@OneToOne(mappedBy = "account")
	private Profile profile;
	
	@OneToMany(mappedBy = "account")
	@MapKeyColumn(name = "AddressType")
	@MapKeyEnumerated
	private	Map<Type, Address> address;
	
	public enum Role{
		Admin,Member
	}
}
