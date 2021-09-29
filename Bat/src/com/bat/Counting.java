package com.bat;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

import com.bat.thread.Service;

public class Counting implements Daemon {

	private Service service;

	@Override
	public void destroy() {
		System.out.println("destory()");
	}

	@Override
	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		System.out.println("init()");
	}

	@Override
	public void start() throws Exception {
		service = new Service();
		new Thread(service).start();
	}

	@Override
	public void stop() throws Exception {
		if (service != null) {
			service.shutdown();
		}
	}

	public static void main(String[] args) {
		try {
			new Counting().start();
		} catch (Exception e) {
		}
	}

}
