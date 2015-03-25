package com.epam.khodyka.view;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.view.implementation.ErrorPageView;
import com.epam.khodyka.view.implementation.HelpView;
import com.epam.khodyka.view.implementation.NoCommandView;
import com.epam.khodyka.view.implementation.ShowAdvertisingView;
import com.epam.khodyka.view.implementation.ShowBasketView;
import com.epam.khodyka.view.implementation.ShowOrderView;
import com.epam.khodyka.view.implementation.ShowProductView;
import com.epam.khodyka.view.implementation.ShowTotalView;
import com.epam.khodyka.view.implementation.SuccessfulAddedView;
import com.epam.khodyka.view.implementation.SuccessfulOrderView;

public class ViewFactory {
	private static ViewFactory factory;
	private static Map<String, View> views = new HashMap<>();

	static {
		views.put(ViewName.SHOW_PRODUCT_VIEW, new ShowProductView());
		views.put(ViewName.SHOW_HELP_VIEW, new HelpView());
		views.put(ViewName.SHOW_BASKET_VIEW, new ShowBasketView());
		views.put(ViewName.SHOW_TOTAL_ORDER_VIEW, new ShowTotalView());
		views.put(ViewName.SUCCESSFUL_ADDED_VIEW, new SuccessfulAddedView());
		views.put(ViewName.SHOW_ADVERTISING_VIEW, new ShowAdvertisingView());
		views.put(ViewName.SUCCESSFUL_ORDER_VIEW, new SuccessfulOrderView());
		views.put(ViewName.SHOW_ORDER_VIEW, new ShowOrderView());
		views.put(ViewName.ERROR_VIEW, new ErrorPageView());
	}

	private ViewFactory() {
	}

	public static ViewFactory getInstance() {
		if (factory == null) {
			factory = new ViewFactory();
		}
		return factory;
	}

	public View getView(String viewName) {
		if (!views.containsKey(viewName)) {
			return new NoCommandView();
		}
		return views.get(viewName);

	}
}
