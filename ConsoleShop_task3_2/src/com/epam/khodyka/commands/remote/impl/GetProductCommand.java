package com.epam.khodyka.commands.remote.impl;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.StorageService;
import com.epam.khodyka.view.ViewName;

public class GetProductCommand extends Command {

	private StorageService storageService;
	private long productId;
	private boolean isHttp;

	public GetProductCommand(StorageService storageService, long productId,
			boolean isHttp) {
		this.storageService = storageService;
		this.productId = productId;
		this.isHttp = isHttp;
	}

	@Override
	public String execute(Model model) {
		MusicalInstrument instrument = storageService.getProductById(productId);
		model.put("product", instrument);
		if (isHttp) {
			return ViewName.SHOW_PRODUCT_HTTP_VIEW;
		}
		return ViewName.SHOW_PRODUCT_TCP_VIEW;
	}
}