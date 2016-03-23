package com.dhnhan;

import java.io.IOException;
import java.net.UnknownHostException;

import com.dhnhan.socket.SendMBean;

public class App2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		SendMBean bean = new SendMBean("localhost",5555);
		bean.sendMBean("Nhancxzcx");
	}
}
