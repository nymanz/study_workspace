package com.agree.Thinking_in_JAVA_eighteen;

import java.io.File;

public class DirectoryDemo {
	public static void main(String[] args) {
		PPrint.pprint(Directory.walk(".").dirs);
		for(File file : Directory.local(".", "T.*"))
			System.out.print(file);
		System.out.println("------------------------");
		for(File file: Directory.walk(".","T.*\\.java"))
			System.out.println(file);
		System.out.println("========================");
		for(File file:Directory.walk(".",".*[Zz].*\\.class"))
			System.out.println(file);
	}
}
