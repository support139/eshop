package com.epam.khodyka.commands.remote.impl;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.StorageService;
import com.epam.khodyka.view.ViewName;

public class GetCountCommand extends Command {

	private StorageService storageService;
	private boolean isHttp;

	public GetCountCommand(StorageService storageService, boolean isHttp) {
		this.storageService = storageService;
		this.isHttp = isHttp;
	}

	@Override
	public String execute(Model model) {
		int productCount = storageService.getProductCount();
		model.put("count", productCount);
		if (isHttp) {
			return ViewName.GET_COUNT_HTTP_VIEW;
		}
		return ViewName.GET_COUNT_TCP_VIEW;
	}
}
