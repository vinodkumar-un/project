package com.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jamonapi.MonKey;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import com.jamonapi.proxy.MonProxyFactory;

@Component
public class PerformanceUtil {

	// Monitor monitor = null;

	/*
	 * public void performanceCheck() { try { for (int i = 0; i < 10; i++) {
	 * 
	 * monitor = perform(i, monitor); } } catch (InterruptedException e) {
	 * e.printStackTrace(); } }
	 */

	public static Monitor performanceCheck(int i, Monitor monitor)
			throws InterruptedException {

		// Monitor monitor = MonitorFactory.start("java monitor");
		// monitor.start();
		// MonProxyFactory.monitor(monitor);
		// monitor.stop();
		return monitor;
	}

}
