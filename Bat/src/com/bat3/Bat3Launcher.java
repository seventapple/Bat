package com.bat3;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

public class Bat3Launcher implements Daemon {
	public static Bat3Launcher launcher;
	private Service service;

	private Bat3Launcher() {};

	// 程序启动入口
	public void run() {
		service = new Service();
		try {
			Thread thread = new Thread(service);
			thread.setDaemon(true);
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
			;
		}
	}

	// 程序关闭入口
	public void terminate() {
		if (service != null) {
			service.stop();
		}
	}

	/* for windows commons Daemon */
	public static void startService() {
		launcher = new Bat3Launcher();
		launcher.run();
	}

	public static void stopService() {
		if (launcher != null) {
			launcher.terminate();
		}
	}

	/* for linux jsvc */
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
		launcher = new Bat3Launcher();
		launcher.run();
	}

	@Override
	public void stop() throws Exception {
		if (launcher != null) {
			launcher.terminate();
		}
	}

	public static void main(String[] args) {
		launcher = new Bat3Launcher();
		launcher.run();
		return;
	}
}
