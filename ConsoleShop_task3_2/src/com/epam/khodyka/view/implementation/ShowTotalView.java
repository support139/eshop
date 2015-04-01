package com.epam.khodyka.view.implementation;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowTotalView implements View {

	@Override
	public void show(Model model) {
		double totalPrice = (Double) model.get("totalPrice");
		System.err.println("total price: " + totalPrice);
	}
}
