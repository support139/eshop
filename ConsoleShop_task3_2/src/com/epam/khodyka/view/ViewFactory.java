package com.epam.khodyka.view;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.view.impl.ErrorPageView;
import com.epam.khodyka.view.impl.HelpView;
import com.epam.khodyka.view.impl.NoCommandView;
import com.epam.khodyka.view.impl.ShowAdvertisingView;
import com.epam.khodyka.view.impl.ShowBasketView;
import com.epam.khodyka.view.impl.ShowOrderView;
import com.epam.khodyka.view.impl.ShowProductView;
import com.epam.khodyka.view.impl.ShowTotalView;
import com.epam.khodyka.view.impl.SuccessfulAddedView;
import com.epam.khodyka.view.impl.SuccessfulChangedLocaleView;
import com.epam.khodyka.view.impl.SuccessfulCreateBuilderView;
import com.epam.khodyka.view.impl.SuccessfulCreateProductView;
import com.epam.khodyka.view.impl.SuccessfulOrderView;

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
		views.put(ViewName.SUCCESSFUL_CREATE_PRODUCT_VIEW,
				new SuccessfulCreateProductView());
		views.put(ViewName.SUCCESSFUL_CREATE_BUILDER_VIEW,
				new SuccessfulCreateBuilderView());
		views.put(ViewName.SUCCESSFUL_CHANGED_LOCALE_VIEW,
				new SuccessfulChangedLocaleView());
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
