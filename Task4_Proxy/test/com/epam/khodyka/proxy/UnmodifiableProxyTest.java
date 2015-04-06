package com.epam.khodyka.proxy;

import static org.junit.Assert.*;

import javax.xml.ws.ServiceMode;

import org.junit.Before;
import org.junit.Test;

import com.epam.khodyka.GuitarInterface;

public class UnmodifiableProxyTest {

	private ProxyManager manager = new ProxyManager();
	private GuitarInterface unmodProxy = manager.getUnmodifiableProxy();

	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowExceptionWhenInvokedSetters() {
		unmodProxy.setFretsNum(1);
	}

	@Test
	public void shouldBeSuccessWhenIndokedGetters() {
		unmodProxy.getFretsNum();
	}
}
