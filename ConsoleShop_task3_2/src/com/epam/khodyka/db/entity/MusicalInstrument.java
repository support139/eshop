package com.epam.khodyka.db.entity;

import java.io.Serializable;

import com.epam.khodyka.builders.anno.Setter;
import com.epam.khodyka.builders.anno.Product;

@Product
public abstract class MusicalInstrument implements Serializable {

	private static final long serialVersionUID = 2229720364359653928L;

	private long id;
	private String name;
	private double price;

	public MusicalInstrument(long id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public MusicalInstrument() {
	}

	public long getId() {
		return id;
	}

	@Setter(name = "product_id")
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Setter(name = "product_name")
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	@Setter(name = "product_price")
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicalInstrument other = (MusicalInstrument) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MusicalInstruments [id=" + id + ", name=" + name + ", price="
				+ price + "]";
	}

}
