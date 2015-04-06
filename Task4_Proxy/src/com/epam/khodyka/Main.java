package com.epam.khodyka;

import com.epam.khodyka.proxy.ProxyManager;

public class Main {
	public static void main(String[] args) {

		ProxyManager manager = new ProxyManager();
		GuitarInterface unmodProxy = manager.getUnmodifiableProxy();
		unmodProxy.setFretsNum(1);

		GuitarInterface mapProxy = (GuitarInterface) manager.getMapProxy();
		mapProxy.setFretsNum(1);
		System.out.println(mapProxy.getFretsNum());

	}
}
