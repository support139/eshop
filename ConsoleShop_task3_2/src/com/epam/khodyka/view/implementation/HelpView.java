package com.epam.khodyka.view.implementation;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class HelpView implements View {

	private static final String HELP_MESSAGE_SPROD = "sprod - show all products";
	private static final String HELP_MESSAGE_SBACKET = "sbas - show backet contant";
	private static final String HELP_MESSAGE_ADD = "add {product id}{amount} - adding product to backet";
	private static final String SHOW_ADVERTISING = "sadv - show advertising";
	private static final String MAKE_ORDER = "mkord {day.month.year hh:mm} - make order";
	private static final String SHOW_ORDER = "sord {day.month.year hh:mm} - show order";
	private static final String SHOW_NEXT_ORDER = "snord {day.month.year hh:mm} - show next order";
	private static final String CHOOSE_BUILDER = "cbuild {random/console} - choose builder";
	private static final String CREATE_PRODUCT = "create {product type} - create product";

	@Override
	public void show(Model model) {
		System.err.println(HELP_MESSAGE_SPROD);
		System.err.println(HELP_MESSAGE_SBACKET);
		System.err.println(HELP_MESSAGE_ADD);
		System.err.println(SHOW_ADVERTISING);
		System.err.println(MAKE_ORDER);
		System.err.println(SHOW_ORDER);
		System.err.println(SHOW_NEXT_ORDER);
		System.err.println(CHOOSE_BUILDER);
		System.err.println(CREATE_PRODUCT);
	}
}
