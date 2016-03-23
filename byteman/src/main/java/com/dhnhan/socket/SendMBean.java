package com.dhnhan.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendMBean {
	private String host;
	private int port;

	public SendMBean(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void sendMBean(String message) throws UnknownHostException,
			IOException {
		Socket client = new Socket(this.host, this.port);
		OutputStream outToServer = client.getOutputStream();
		DataOutputStream out = new DataOutputStream(outToServer);
		out.writeUTF(message);
		client.close();
	}

}
