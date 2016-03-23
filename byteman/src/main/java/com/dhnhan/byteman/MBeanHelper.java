package com.dhnhan.byteman;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.UnknownHostException;

import org.jboss.byteman.rule.Rule;
import org.jboss.byteman.rule.helper.Helper;

import com.dhnhan.socket.SendMBean;

public class MBeanHelper extends Helper {
	static SendMBean sendMBean = null;

	protected MBeanHelper(Rule rule) {
		super(rule);
	}

	public static void activated() {
		System.out
				.println("actived ++++++++++++++++++++++++++++++++++++++++++++++++++");
		sendMBean = new SendMBean("localhost", 5555);
	}

	public void sendData() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					if (sendMBean != null) {
						try {
							sendMBean.sendMBean(ManagementFactory.getRuntimeMXBean().getName());
							System.out.println("sent......");
							Thread.sleep(5000);
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		thread.start();
	}

	public static void deactivated() {

	}
}
