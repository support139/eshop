package com.epam.khodyka.part1;

/**
 * Class Guitar represents Guitar entity
 * 
 * @author Andrii_Khodyka
 *
 */
public class Guitar extends StringInstruments {

	private String woodType;
	private int fretsNum;

	public Guitar(String name, double price, String description,
			String stringType, String woodType, int fretsNum) {
		super(name, price, description, stringType);
		this.woodType = woodType;
		this.fretsNum = fretsNum;
	}

	public Guitar() {
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public int getFretsNum() {
		return fretsNum;
	}

	public void setFretsNum(int fretsNum) {
		this.fretsNum = fretsNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + fretsNum;
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
		Guitar other = (Guitar) obj;
		if (fretsNum != other.fretsNum)
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
		return "Guitar [woodType=" + woodType + ", fretsNum=" + fretsNum
				+ ", getStringType()=" + getStringType() + ", getName()="
				+ getName() + ", getPrice()=" + getPrice()
				+ ", getDescription()=" + getDescription() + "]";
	}

}
