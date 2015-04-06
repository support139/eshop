package com.epam.khodyka;

public class GuitarImpl implements GuitarInterface {

	private int id;
	private int fretsNum;
	private String name;
	private String woodType;
	private String stringType;
	private double price;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getFretsNum() {
		return fretsNum;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getStringType() {
		return stringType;
	}

	@Override
	public String getWoodType() {
		return woodType;
	}

	@Override
	public void setFretsNum(int fretsNum) {
		this.fretsNum = fretsNum;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setStringType(String stringType) {
		this.stringType = stringType;
	}

	@Override
	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}
}
