package com.dhnhan;

import java.io.IOException;

import com.dhnhan.socket.SocketServerMBean;

public class App {
	public static void main(String[] args) throws IOException {
		Thread thread = new SocketServerMBean(5555);
		thread.start();
	}
}
