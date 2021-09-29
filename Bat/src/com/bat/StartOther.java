package com.bat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.imageio.stream.FileImageOutputStream;

//利用ProcessBuilder调用其他程序
public class StartOther {

	public static void main(String[] args) {
		BufferedReader br = null;
		Process process = null;
		try {
			ProcessBuilder builder = null;
			String projectPath = System.getProperty("user.dir");
			String osName = System.getProperty("os.name").toLowerCase();
			String targetPath = System.getenv("TEST_BAT1");
			System.out.println("user.dir = " + projectPath);
			System.out.println("os.name = " + osName);
			System.out.println("TEST_BAT1 = " + targetPath);
			if (osName.startsWith("windows")) {
				System.out.println("Windows!!!");
				String desk = targetPath.substring(0, 1);
				builder = new ProcessBuilder("cmd", "/c", desk + ":", "&&", "cd", targetPath, "&&", "bat1.bat");
			} else {
				System.out.println("Linus!!!");
				builder = new ProcessBuilder("sh", targetPath + File.separator + "bat1.sh");
			}
			if (args != null) {
				List<String> command = builder.command();
				for (String str : args) {
					command.add(str);
				}
				for(String com:command) {
					System.out.println("command = "+com);
				}
				builder.command(command);
			}
			process = builder.start();
			br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String msg;
			while ((msg = br.readLine()) != null) {
				System.out.println("msg = " + msg);
			}
			System.out.println("waitfor result = " + process.waitFor());
			System.out.println("exit result = " + process.exitValue());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					;
				}
			}
			if (process != null) {
				process.destroy();
			}
		}
	}

}
