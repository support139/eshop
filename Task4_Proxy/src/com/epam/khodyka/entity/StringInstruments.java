package com.epam.khodyka.entity;

public class StringInstruments extends MusicalInstrument {

	private static final long serialVersionUID = 4071829669382349117L;

	private String stringType;

	public StringInstruments(long id, String name, double price,
			String stringType) {
		super(id, name, price);
		this.stringType = stringType;
	}

	public StringInstruments() {
	}

	public String getStringType() {
		return stringType;
	}

	public void setStringType(String stringType) {
		this.stringType = stringType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((stringType == null) ? 0 : stringType.hashCode());
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
		StringInstruments other = (StringInstruments) obj;
		if (stringType == null) {
			if (other.stringType != null)
				return false;
		} else if (!stringType.equals(other.stringType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StringInstruments [stringType=" + stringType + ", toString()="
				+ super.toString() + "]";
	}

}
