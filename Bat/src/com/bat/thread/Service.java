package com.bat.thread;

import java.io.File;
import java.lang.management.ManagementFactory;

public class Service implements Runnable {
	private boolean flag = true;
	private int cnt = 0;

	@Override
	public void run() {
		String pidName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println(pidName);
		String pid = pidName.split("@")[0];
		System.out.println("pid : " + pid);
		// TODO:linux环境下 使用jsvc方式启动项目获取路径不正确
//		String projectPath = System.getProperty("user.dir");
		String projectPath = "/home/wang/test/bat3";
		System.out.println("PATH : " + projectPath);
		String pathParent = projectPath + File.separator + "temp";
		File fileParent = new File(pathParent);
		if (!fileParent.exists()) {
			fileParent.mkdirs();
		}
		while (flag) {
			String name = pathParent + File.separator + cnt++ + ".project";
			System.out.println("make file : " + name);
			File file = new File(name);
			try {
				Thread.sleep(2000);
				file.createNewFile();
			} catch (Exception e) {
			}
		}
	}

	public void shutdown() {
		this.flag = false;
	}

}
