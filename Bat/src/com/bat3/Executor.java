package com.bat3;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import com.bat.common.StringUtil;
import com.bat.log.LogManager;

public class Executor implements Runnable {
	private static LogManager LOG = LogManager.getLogManager(Executor.class);
	private boolean flag = true;
	private int cnt = 0;

	@Override
	public void run() {
		String pidName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println(pidName);
		String pid = pidName.split("@")[0];
		System.out.println("pid : " + pid);
		LOG.debug("pid : " + pid);
		// FIX-linux环境下 使用jsvc方式启动项目获取路径不正确
		String path = null;
		try {
			path = StringUtil.getJavaLibraryPath();
			if(path==null) {
				path = "./temp";
			}
			File parent = new File(path);
			path = parent.getParent();
			System.out.println("PATH : " + path);
		} catch (IOException e1) {
		}
		path = path + File.separator + "temp";
		File fileParent = new File(path);
		if (!fileParent.exists()) {
			fileParent.mkdirs();
		}
		while (flag) {
			String name = path + File.separator + cnt++ + ".project";
			System.out.println("make file : " + name);
			LOG.debug("make file : " + name);
			File file = new File(name);
			try {
				Thread.sleep(2000);
				file.createNewFile();
			} catch (Exception e) {
			}
		}
	}

	public void shutdown() {
		flag = false;
	}
}
