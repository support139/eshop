package com.epam.khodyka.commands.implementation;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.AdvertisingService;
import com.epam.khodyka.service.BasketService;
import com.epam.khodyka.service.StorageService;
import com.epam.khodyka.view.ViewName;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class AddProductCommand extends Command {

	private BasketService basketService;
	private StorageService storageService;
	private AdvertisingService advertisingService;

	private long productId;
	private int amount;

	public AddProductCommand(BasketService basketService,
			StorageService storageService,
			AdvertisingService advertisingService, long productId, int amount) {
		this.basketService = basketService;
		this.storageService = storageService;
		this.advertisingService = advertisingService;
		this.productId = productId;
		this.amount = amount;
	}

	public AddProductCommand(BasketService basketService,
			StorageService storageService,
			AdvertisingService advertisingService, long productId) {
		this(basketService, storageService, advertisingService, productId, 1);
	}

	@Override
	public String execute(Model model) {
		if (!basketService.addProduct(productId, amount)) {
			model.put("errorMessage", "Add error");
			return ViewName.ERROR_VIEW;
		}
		MusicalInstrument instrument = storageService.getProductById(productId);
		Map<MusicalInstrument, Integer> purchase = new HashMap<>();
		purchase.put(instrument, amount);
		model.put("purchase", purchase);
		advertisingService.add(productId, instrument);
		return ViewName.SUCCESSFUL_ADDED_VIEW;
	}
}
