package com.epam.khodyka.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.epam.khodyka.GuitarInterface;

public class MapProxyTest {

	private ProxyManager manager = new ProxyManager();
	private GuitarInterface mapProxy = manager.getMapProxy();

	@Test
	public void shouldBeSuccessWhenInvokedSetters() {
		mapProxy.setFretsNum(1);
	}

	@Test
	public void receivedValueShouldBeEqualToPastedValue() {
		mapProxy.setName("test");
		String expected = "test";
		String actual = mapProxy.getName();
		assertEquals(expected, actual);
	}

}
