package com.epam.khodyka.view.impl;

import java.util.Date;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class SuccessfulOrderView implements View {
	@Override
	public void show(Model model) {
		Date orderDate = (Date) model.get("orderDate");
		System.err.println("Order �: " + orderDate
				+ " has been successfully created");
	}
}
