package com.epam.khodyka.commands.implementation;

import com.epam.khodyka.builders.BuildRunner;
import com.epam.khodyka.builders.BuilderFactory;
import com.epam.khodyka.builders.reflection.exception.InstrumentCreatorException;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.StorageService;
import com.epam.khodyka.view.ViewName;

public class CreateProductCommand extends Command {

	private String productName;
	private StorageService storageService;

	public CreateProductCommand(String productName,
			StorageService storageService) {
		this.productName = productName;
		this.storageService = storageService;
	}

	@Override
	public String execute(Model model) {
		BuildRunner runner = BuilderFactory.getInstance().getBuilderRunner();
		if (runner == null) {
			model.put("errorMessage", "Choose builder type first!");
			return ViewName.ERROR_VIEW;
		}
		MusicalInstrument instrument;
		try {
			instrument = runner.run(productName);
		} catch (InstrumentCreatorException e) {
			model.put("errorMessage", "Exception " + e);
			return ViewName.ERROR_VIEW;
		}
		if (!storageService.addProduct(instrument)) {
			model.put("errorMessage", "Product with that id already in use!");
			return ViewName.ERROR_VIEW;
		}
		model.put("createdProduct", instrument);
		return ViewName.SUCCESSFUL_CREATE_PRODUCT_VIEW;
	}
}
