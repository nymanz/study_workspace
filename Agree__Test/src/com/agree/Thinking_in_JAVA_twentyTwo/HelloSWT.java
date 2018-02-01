package com.agree.Thinking_in_JAVA_twentyTwo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSWT {
	public static void main(String[] args) {
		//Display管理SWT和底层操作系统之间的连接
		Display display = new Display();
		//Shell是顶层主窗口
		Shell shell = new Shell(display);
		//窗口标题栏上的标签
		shell.setText("Hi there,SWT!");
		//为显示窗口以及这样的应用程序
		shell.open();
		//循环检查shell是否被释放
		while(!shell.isDisposed()){
			//如果在事件队列中存在更多的事件在等待处理，那么readAndDispatch方法将返回true
			if(!display.readAndDispatch()){
				//display被悬挂
				display.sleep();
			}
		}
		//程序结束必须显示调用dispose方法，释放资源
		display.dispose();
	}
}
