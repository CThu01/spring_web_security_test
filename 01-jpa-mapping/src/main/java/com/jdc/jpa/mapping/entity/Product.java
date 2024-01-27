package com.jdc.jpa.mapping.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;

	@MapKeyEnumerated(EnumType.STRING)
	@ElementCollection
	@Column(name = "priceLevel",length = 40)
	private Map<PriceType, Integer> price;

	@ElementCollection
	@CollectionTable(name = "PRODUCT_Tag")
	private List<String> tags;

	public enum PriceType {
		SEPICAL, AGENT, PURCHASE
	}
	
	@ElementCollection
	@CollectionTable(name = "ProductFeature")
	private List<Feature> featureList;
	
	
	
	
	

	public List<Feature> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(List<Feature> featureList) {
		this.featureList = featureList;
	}

	public Map<PriceType, Integer> getPrice() {
		return price;
	}

	public void setPrice(Map<PriceType, Integer> price) {
		this.price = price;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
