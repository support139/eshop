package com.epam.khodyka.view.remote;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.view.RemoteView;
import com.epam.khodyka.view.ViewName;
import com.epam.khodyka.view.remote.impl.ErrorCommandView;
import com.epam.khodyka.view.remote.impl.GetCountHttpView;
import com.epam.khodyka.view.remote.impl.GetCountView;
import com.epam.khodyka.view.remote.impl.GetProductHttpView;
import com.epam.khodyka.view.remote.impl.GetProductView;

public class RemoteViewFactory {

	private static RemoteViewFactory factory;
	private static Map<String, RemoteView> views = new HashMap<>();

	static {
		views.put(ViewName.GET_COUNT_TCP_VIEW, new GetCountView());
		views.put(ViewName.SHOW_PRODUCT_TCP_VIEW, new GetProductView());
		views.put(ViewName.GET_COUNT_HTTP_VIEW, new GetCountHttpView());
		views.put(ViewName.SHOW_PRODUCT_HTTP_VIEW, new GetProductHttpView());
		views.put(ViewName.ERROR_REMOTE_VIEW, new ErrorCommandView());
	}

	private RemoteViewFactory() {
	}

	public static RemoteViewFactory getInstance() {
		if (factory == null) {
			factory = new RemoteViewFactory();
		}
		return factory;
	}

	public RemoteView getView(String viewName) {
		// if (!views.containsKey(viewName)) {
		// return new NoCommandView();
		// }
		return views.get(viewName);

	}
}
