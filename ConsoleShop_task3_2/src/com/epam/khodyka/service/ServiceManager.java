package com.epam.khodyka.service;

import com.epam.khodyka.db.AdvertisingRepository;
import com.epam.khodyka.db.BasketRepository;
import com.epam.khodyka.db.OrderRepository;
import com.epam.khodyka.db.StorageRepository;

public class ServiceManager {

	private BasketRepository basketRepository;
	private StorageRepository storageRepository;
	private OrderRepository orderRepository;
	private AdvertisingRepository advertisingRepository;

	private BasketService basketService;
	private OrderService orderService;
	private StorageService storageService;
	private AdvertisingService advertisingService;
	private ResourceBundleService bundleService;

	public ServiceManager() {
		basketRepository = new BasketRepository();
		storageRepository = new StorageRepository();
		// TODO Uncomment to init default data
		// storageRepository.initDefaultData();
		orderRepository = new OrderRepository();
		advertisingRepository = new AdvertisingRepository();

		basketService = new BasketService(basketRepository, storageRepository);
		orderService = new OrderService(basketRepository, storageRepository,
				orderRepository);
		storageService = new StorageService(storageRepository);
		advertisingService = new AdvertisingService(advertisingRepository,
				storageRepository);
		bundleService = new ResourceBundleService();
	}

	public BasketService getBasketService() {
		return basketService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public StorageService getStorageService() {
		return storageService;
	}

	public AdvertisingService getAdvertisingService() {
		return advertisingService;
	}

	public ResourceBundleService getResourceBundleService() {
		return bundleService;
	}

}
