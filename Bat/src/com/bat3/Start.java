package com.bat3;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import com.bat.common.StringUtil;

public class Start {
	private volatile Executor thread = null;

	public void run() {
		if (thread == null) {
			thread = new Executor();
			new Thread(thread).start();
		}
	}
	public void shutdown() {
		if (thread != null) {
			thread.shutdown();
		}
	}
}
