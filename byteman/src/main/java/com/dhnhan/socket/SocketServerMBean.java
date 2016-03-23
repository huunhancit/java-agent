package com.dhnhan.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerMBean extends Thread {
	private ServerSocket serverSocket;

	public SocketServerMBean(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port "
						+ serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to "
						+ server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(
						server.getInputStream());
				System.out.println("Message: " + in.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
