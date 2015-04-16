package com.epam.khodyka.commands.remote.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.khodyka.controller.tcp.TcpController;
import com.epam.khodyka.db.entity.Guitar;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.ServiceManager;
import com.epam.khodyka.service.StorageService;

public class TcpCommandsTest {

	private static Model model;
	private static ServiceManager manager;
	private static TcpController controller;
	private static StorageService storageService;
	private static int testPort = 3002;

	@BeforeClass
	public static void setup() {
		model = new Model();
		manager = Mockito.mock(ServiceManager.class);
		storageService = Mockito.mock(StorageService.class);
		controller = new TcpController(model, manager, testPort);
	}

	@Test
	public void receivedCountShouldBeEqualToExpected() throws IOException {
		Mockito.when(manager.getStorageService()).thenReturn(storageService);
		Mockito.when(storageService.getProductCount()).thenReturn(10);
		Socket socket = new Socket("localhost", testPort);
		DataOutputStream dataOutputStream = new DataOutputStream(
				socket.getOutputStream());
		DataInputStream dataInputStream = new DataInputStream(
				socket.getInputStream());
		dataOutputStream.writeUTF("gcount");
		String expected = "Amount of products: 10";
		Assert.assertEquals(expected, dataInputStream.readUTF());
		socket.close();
	}

	@Test
	public void receivedItemShouldBeEqualToExpected() throws IOException {
		Guitar testGuitar = new Guitar(1, "Test", 1, "Test", "Test", 24);
		Mockito.when(manager.getStorageService()).thenReturn(storageService);
		Mockito.when(storageService.getProductById(1)).thenReturn(testGuitar);
		Socket socket = new Socket("localhost", testPort);
		DataOutputStream dataOutputStream = new DataOutputStream(
				socket.getOutputStream());
		DataInputStream dataInputStream = new DataInputStream(
				socket.getInputStream());
		dataOutputStream.writeUTF("gprod 1");
		String expected = "Test | 1.0";
		Assert.assertEquals(expected, dataInputStream.readUTF());
		socket.close();
	}

}
