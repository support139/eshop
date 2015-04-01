package com.epam.khodyka.db.entity;

public class Percussion extends MusicalInstrument {

	private static final long serialVersionUID = -7080068533073955992L;

	private String materialType;

	public Percussion(long id, String name, double price, String materialType) {
		super(id, name, price);
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
		return "Percussion [materialType=" + materialType + ", toString()="
				+ super.toString() + "]";
	}

}
