package com.epam.khodyka.commands.implementation;

import java.util.Map;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.StorageService;
import com.epam.khodyka.view.ViewName;

public class ShowProductsCommand extends Command {

	private StorageService storageService;

	public ShowProductsCommand(StorageService storageService) {
		this.storageService = storageService;
	}

	@Override
	public String execute(Model model) {
		Map<Long, MusicalInstrument> map = storageService.getAllProduct();
		model.put("products", map);
		return ViewName.SHOW_PRODUCT_VIEW;
	}
}
