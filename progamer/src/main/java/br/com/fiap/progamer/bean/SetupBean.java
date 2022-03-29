package br.com.fiap.progamer.bean;

import java.math.BigDecimal;

import javax.inject.Named;

@Named
public class SetupBean {
	
	private String name = "Meu Setup";
	private String description;
	private BigDecimal price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	

}
