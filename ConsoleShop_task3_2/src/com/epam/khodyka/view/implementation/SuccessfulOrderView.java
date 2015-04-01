package com.epam.khodyka.view.implementation;

import java.util.Date;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;
/**
 * Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class SuccessfulOrderView implements View {
	@Override
	public void show(Model model) {
		Date orderDate = (Date) model.get("orderDate");
		System.err.println("Order ¹: " + orderDate
				+ " has been successfully created");
	}
}
