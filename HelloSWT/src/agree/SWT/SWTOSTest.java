package agree.SWT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.MSG;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.RECT;
import org.eclipse.swt.internal.win32.SHELLEXECUTEINFO;
import org.eclipse.swt.internal.win32.TCHAR;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTOSTest {
	private Shell sShell = null; // @jve:decl-index=0:visual-constraint="10,10"
	private Composite composite = null;
	private RECT pRect  = new RECT();
	private RECT rect  = new RECT();
	static int notepadHwnd = 0;
	static int childHwnd = 0;
	static int childHwnd1 = 0;
	static int childHwnd2= 0;
	static int childHwnd3 = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		SWTOSTest thisClass = new SWTOSTest();

		thisClass.createSShell();
		thisClass.sShell.open();
		thisClass.translate();
		
		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private void translate() {
	
		String msg = "王欲鸿";
		String msgpsw = "123456";
		int childHwnd = OS.GetWindow(notepadHwnd, OS.GW_CHILD);
		OS.GetWindowRect(notepadHwnd, pRect);
		OS.GetWindowRect(childHwnd, rect);
		while(childHwnd1==0||childHwnd2==0||childHwnd3==0){
			 if(rect.left-pRect.left==18&&rect.top-pRect.top==16&&rect.right-pRect.left==248&&rect.bottom-pRect.top==51){
				 childHwnd1 = childHwnd; 
			 }
			 else if(rect.left-pRect.left==18&&rect.top-pRect.top==66&&rect.right-pRect.left==248&&rect.bottom-pRect.top==101){
				 childHwnd2 = childHwnd;
			 }
			 else if(rect.left-pRect.left==18&&rect.top-pRect.top==116&&rect.right-pRect.left==218&&rect.bottom-pRect.top==146){
				 childHwnd3 = childHwnd;
			 }
			childHwnd = OS.GetWindow(childHwnd, OS.GW_HWNDNEXT);
			OS.GetWindowRect(childHwnd, rect);
		}
		 OS.SendMessage(childHwnd1, OS.WM_SETTEXT, 0,
				new TCHAR(0, msg, true));
		 OS.SendMessage(childHwnd2, OS.WM_SETTEXT, 0,
				new TCHAR(0, msgpsw, true));
		 int sendMessage =OS.SendMessage(childHwnd3, OS.WM_LBUTTONDOWN, 0, 0);
		System.out.println("sendMessage:" + sendMessage);
	}

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setLayout(new FillLayout());

		composite = new Composite(sShell, SWT.NONE);
		composite.setBounds(0, 0, 800, 600);
		composite.setBackground(sShell.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		composite.setLayout(new FillLayout());
		composite.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				if (notepadHwnd != 0) {
					Rectangle cRect = ((Composite) (e.widget)).getClientArea();
					// 全屏
					OS.SetWindowPos(notepadHwnd, 0, 0, 0, cRect.width,
							cRect.height, OS.SWP_NOZORDER | OS.SWP_NOACTIVATE
									| OS.SWP_ASYNCWINDOWPOS);
					// 居中

					/*
					 * RECT sRect = new RECT(); OS.GetClientRect(notepadHwnd,
					 * sRect); int w = sRect.right - sRect.left; int h =
					 * sRect.bottom - sRect.top; OS.SetWindowPos(notepadHwnd, 0,
					 * (cRect.width - w) / 2,(cRect.height - h) / 2, w, h - 20,
					 * OS.SWP_NOZORDER | OS.SWP_NOACTIVATE |
					 * OS.SWP_ASYNCWINDOWPOS);
					 */
				}
			}
		});
		sShell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				if (notepadHwnd != 0) {
					OS.SendMessage(notepadHwnd, OS.WM_CLOSE, 0, 0);
				}
			}
		});

		try {
			startNotePad();
			sShell.layout(); // 窗口布局生效
			sShell.open();
		} catch (Exception e) {
		}

	}

	private boolean executeProg(String fileName) throws Exception {
		int hHeap = OS.GetProcessHeap();
		TCHAR buffer = new TCHAR(0, fileName, true);
		int byteCount = buffer.length() * TCHAR.sizeof;
		/**
		 * 用来在指定的堆上分配内存，并且分配后的内存不可移动
		 * 
		 * @return 当前数据地址
		 */
		int lpFile = OS.HeapAlloc(hHeap, OS.HEAP_ZERO_MEMORY, byteCount);
		/**
		 * 复制内存(目的数据的地址,来源数据的地址,复制数据的字节数)
		 */
		OS.MoveMemory(lpFile, buffer, byteCount);
		SHELLEXECUTEINFO info = new SHELLEXECUTEINFO();
		info.cbSize = SHELLEXECUTEINFO.sizeof;
		info.lpFile = lpFile;
		// 隐藏启动
		info.nShow = OS.SW_HIDE;
		boolean result = OS.ShellExecuteEx(info);
		if (lpFile != 0)
			OS.HeapFree(hHeap, 0, lpFile);
		return result;
	}

	protected void startNotePad() throws Exception {
		// "notepad.exe"为待启动的程序名
		executeProg("C:\\Users\\赵乾泽\\Desktop\\HelloSWT.exe");

		// "Notepad"为被嵌套程序窗口的ClassName(Win32级别)，可以使用Spy++等工具查看
		while (notepadHwnd == 0) {
			notepadHwnd = OS.FindWindow(new TCHAR(0, "SWT_Window0", true),
					new TCHAR(0, "Hello SWT", true)); // Notepad,rsedc_wclass
			Thread.sleep(10);
		}

		// &~WS_BORDER去掉内嵌程序边框，这样看起来更像一个内嵌的程序。如果需要显示边框，则将这两行代码删除
		int oldStyle = OS.GetWindowLong(notepadHwnd, OS.GWL_STYLE);
		OS.SetWindowLong(notepadHwnd, OS.GWL_STYLE, oldStyle & ~OS.WS_BORDER);

		// composite为承载被启动程序的控件
		OS.SetParent(notepadHwnd, composite.handle);
		// 窗口最大化
		OS.SendMessage(notepadHwnd, OS.WM_SYSCOMMAND, OS.SC_MAXIMIZE, 0);
		OS.SendMessage(notepadHwnd, OS.WM_CHANGEUISTATE, 0, 0);

		
	}
}
