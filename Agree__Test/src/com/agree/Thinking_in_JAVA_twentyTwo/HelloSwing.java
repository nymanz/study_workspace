package com.agree.Thinking_in_JAVA_twentyTwo;

import javax.swing.JFrame;

public class HelloSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Swing");//填写标题
		//该方法指定用户执行关闭操作是应该做些什么
		//EXIT_ON_CLOSE告诉它要退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//以像素为单位设置视窗大小
		frame.setSize(300, 200);
		//使视图窗口可视
		frame.setVisible(true);
	}
}
