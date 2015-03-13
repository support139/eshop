package com.epam.khodyka.part1;

public class Percussion extends MusicalInstruments {
	private String materialType;

	public Percussion(String name, double price, String description,
			String materialType) {
		super(name, price, description);
		this.materialType = materialType;
	}

	public Percussion() {
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((materialType == null) ? 0 : materialType.hashCode());
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
		Percussion other = (Percussion) obj;
		if (materialType == null) {
			if (other.materialType != null)
				return false;
		} else if (!materialType.equals(other.materialType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Percussion [materialType=" + materialType + ", getName()="
				+ getName() + ", getPrice()=" + getPrice()
				+ ", getDescription()=" + getDescription() + "]";
	}

}
