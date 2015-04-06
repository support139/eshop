package com.epam.khodyka.db.entity;

import com.epam.khodyka.builders.anno.Setter;

public class Violin extends StringInstruments {

	private static final long serialVersionUID = 6181175491075989307L;

	private String woodType;
	private double scaleLenght;

	public Violin(long id, String name, double price, String stringType,
			String woodType, double scaleLenght) {
		super(id, name, price, stringType);
		this.woodType = woodType;
		this.scaleLenght = scaleLenght;
	}

	public Violin() {
	}

	public String getWoodType() {
		return woodType;
	}

	@Setter(name = "wood_type")
	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public double getScaleLenght() {
		return scaleLenght;
	}

	@Setter(name = "scale_length")
	public void setScaleLenght(double scaleLenght) {
		this.scaleLenght = scaleLenght;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(scaleLenght);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((woodType == null) ? 0 : woodType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Violin other = (Violin) obj;
		if (Double.doubleToLongBits(scaleLenght) != Double
				.doubleToLongBits(other.scaleLenght))
			return false;
		if (woodType == null) {
			if (other.woodType != null)
				return false;
		} else if (!woodType.equals(other.woodType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getId() + " " + getName() + ", woodType: " + getWoodType()
				+ ", stringType: " + getStringType() + ", scaleLenght: "
				+ getScaleLenght() + ", price: " + getPrice();
	}

}
