package com.bat3;

public class Service implements Runnable {
	private boolean isRunning = false;
	private Start start;

	@Override
	public void run() {
		isRunning = true;
		start = new Start();
		start.run();
		while (isRunning) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		isRunning = false;
		if (start != null) {
			start.shutdown();
		}
	}

}
