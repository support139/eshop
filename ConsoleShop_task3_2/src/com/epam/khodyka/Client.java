package com.epam.khodyka;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException,
			IOException {

		InetAddress address = InetAddress.getLocalHost();
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				String message = scanner.nextLine();
				Socket socket = new Socket(address, 3000);
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();
				DataOutputStream dataOutputStream = new DataOutputStream(out);
				DataInputStream dataInputStream = new DataInputStream(in);
				dataOutputStream.writeUTF(message);
				System.out.println(dataInputStream.readUTF());
				socket.close();
			}
		} catch (IOException e) {
			System.err.println("Client IOException!");
		}
	}
}
