package com.jdc.jpa.mapping.entity;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	private String loginId;
	private String password;
	

	@Override
	public int hashCode() {
		return Objects.hash(loginId, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(loginId, other.loginId) && Objects.equals(password, other.password);
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
