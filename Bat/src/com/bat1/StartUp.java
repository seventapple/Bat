package com.bat1;

public class StartUp {

	private int reflxInt = 3;

	public static void main(String[] args) {
		System.out.println("run bat1 successful.");
		if (args.length != 0) {
			int i = 1;
			for (String str : args) {
				System.out.println("param" + (i++) + ":" + str);
			}
			System.exit(0);
		} else {
			System.out.println("no params");
			System.exit(1);
		}
	}

}
