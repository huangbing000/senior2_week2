/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Goods.java 
 * @Prject: huangbing-senior2-week2
 * @Package: com.huangbing.senior2.week2.domain 
 * @Description: TODO
 * @author: lenovo   
 * @date: 2019年10月14日 上午8:51:12 
 * @version: V1.0   
 */
package com.huangbing.senior2.week2.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/** 
 * @ClassName: Goods 
 * @Description: TODO
 * @author: lenovo
 * @date: 2019年10月14日 上午8:51:12  
 */
public class Goods implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private BigDecimal price;
	private double bfb;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the bfb
	 */
	public double getBfb() {
		return bfb;
	}
	/**
	 * @param bfb the bfb to set
	 */
	public void setBfb(double bfb) {
		this.bfb = bfb;
	}
	
	
	/** 
	 * @Title:Goods
	 * @Description:TODO 
	 * @param id
	 * @param name
	 * @param price
	 * @param bfb 
	 */
	public Goods(String id, String name, BigDecimal price, double bfb) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.bfb = bfb;
	}
	/** 
	 * @Title:Goods
	 * @Description:TODO  
	 */
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non Javadoc) 
	 * @Title: toString
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", bfb=" + bfb + "]";
	}
	/* (non Javadoc) 
	 * @Title: hashCode
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Object#hashCode() 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bfb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	/* (non Javadoc) 
	 * @Title: equals
	 * @Description: TODO
	 * @param obj
	 * @return 
	 * @see java.lang.Object#equals(java.lang.Object) 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (Double.doubleToLongBits(bfb) != Double.doubleToLongBits(other.bfb))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	

}
