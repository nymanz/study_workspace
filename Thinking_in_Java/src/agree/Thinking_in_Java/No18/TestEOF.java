package com.agree.Thinking_in_JAVA_eighteen;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("TestEOF.java")));
		while(in.available()!=0){
			System.out.println((char)in.readByte());
		}
	}
}
