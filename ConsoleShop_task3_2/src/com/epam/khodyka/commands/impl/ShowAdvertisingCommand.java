package com.epam.khodyka.commands.impl;

import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.AdvertisingService;
import com.epam.khodyka.view.ViewName;

public class ShowAdvertisingCommand extends Command {

	private AdvertisingService advertisingService;

	public ShowAdvertisingCommand(AdvertisingService advertisingService) {
		this.advertisingService = advertisingService;
	}

	@Override
	public String execute(Model model) {
		List<MusicalInstrument> advertisingList = advertisingService
				.getTheLatestFivePurchases();
		model.put("advertisingList", advertisingList);
		return ViewName.SHOW_ADVERTISING_VIEW;
	}
}
