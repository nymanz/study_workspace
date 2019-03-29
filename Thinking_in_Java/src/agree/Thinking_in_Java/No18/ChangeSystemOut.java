package com.agree.Thinking_in_JAVA_eighteen;

import java.io.PrintWriter;

public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello world!");
	}
}
