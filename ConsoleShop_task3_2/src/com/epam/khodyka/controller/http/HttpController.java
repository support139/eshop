package com.epam.khodyka.controller.http;

import java.net.ServerSocket;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.ServiceManager;

public class HttpController extends Thread {

	private Model model;
	private ServiceManager manager;
	private int port;

	public HttpController(Model model, ServiceManager manager, int port) {
		this.model = model;
		this.manager = manager;
		this.port = port;
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				new HttpHandler(serverSocket.accept(), model, manager);
			}
		} catch (Exception e) {
			System.err.println("Server socket init error!");
		}
	}
}