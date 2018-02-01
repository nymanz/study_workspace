package agree.SWT;

import org.eclipse.swt.internal.Callback;
import org.eclipse.swt.internal.win32.MSG;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.PAINTSTRUCT;
import org.eclipse.swt.internal.win32.RECT;
import org.eclipse.swt.internal.win32.TCHAR;
import org.eclipse.swt.internal.win32.WNDCLASS;

public class TestSwt {
	 static TCHAR DialogClass = new TCHAR(0, OS.IsWinCE ? "Dialog" : "#32770", true);  
	    static int /* long */DialogProc;  
	    static String [] eventTable = null;  
	    static {  
	          
	        eventTable = new String[8];  
	        eventTable[0] = "BN_CLICKED";  
	        eventTable[1] = "BN_PAINT";  
	        eventTable[2] = "BN_HILITE/BN_PUSHED";  
	        eventTable[3] = "BN_UNHILITE/BN_UNPUSHED";  
	        eventTable[4] = "BN_DISABLE";  
	        eventTable[5] = "BN_DOUBLECLICKED/BN_DBLCLK";  
	        eventTable[6] = "BN_SETFOCUS";  
	        eventTable[7] = "BN_KILLFOCUS";  
	    }  
	      
	    static TCHAR [] buttons = null;  
	    static int [] btnHandlers = null;  
	    static {  
	          
	        buttons = new TCHAR[10];  
	        buttons[0] = new TCHAR(0, "PUSHBUTTON", true);  
	        buttons[1] = new TCHAR(0, "DEFPUSHBUTTON", true);  
	        buttons[2] = new TCHAR(0, "CHECKBOX", true);  
	        buttons[3] = new TCHAR(0, "AUTOCHECKBOX", true);  
	        buttons[4] = new TCHAR(0, "RADIOBUTTON", true);  
	        buttons[5] = new TCHAR(0, "3STATE", true);  
	        buttons[6] = new TCHAR(0, "AUTO3STATE", true);  
	        buttons[7] = new TCHAR(0, "GROUPBOX", true);  
	        buttons[8] = new TCHAR(0, "AUTORADIO", true);  
	        buttons[9] = new TCHAR(0, "OWNERDRAW", true);  
	        btnHandlers = new int[buttons.length];  
	    }  
	      
	    static int cxChar, cyChar;  
	    static RECT rect = new RECT();    
	      
	    public static void main(String[] args) {  
	        TCHAR wndClassName = new TCHAR(0, "SWT_WINDOW", true);  
	        WNDCLASS wndClass = new WNDCLASS();  
	        wndClass.hInstance = OS.GetModuleHandle(null);  
	        wndClass.lpfnWndProc = new Callback(TestSwt.class, "windowProc", 4).getAddress();  
	        wndClass.style = OS.CS_HREDRAW | OS.CS_VREDRAW;  
	        wndClass.hCursor = OS.LoadCursor(0, OS.IDC_ARROW);  
	        wndClass.hbrBackground = OS.GetStockObject(OS.WHITE_BRUSH);  
	        wndClass.lpszClassName = OS.HeapAlloc(OS.GetProcessHeap(), OS.HEAP_ZERO_MEMORY, wndClassName.length() * 2);  
	          
	        OS.MoveMemory(wndClass.lpszClassName, wndClassName, wndClassName.length() * 2);  
	        OS.RegisterClass(wndClass);  
	        int hWnd = OS.CreateWindowEx(0, wndClassName, new TCHAR(0, "测试窗体", true), OS.WS_OVERLAPPEDWINDOW, OS.CW_USEDEFAULT, OS.CW_USEDEFAULT,  
	                OS.CW_USEDEFAULT, OS.CW_USEDEFAULT, 0, 0, OS.GetModuleHandle(null), null);  
	        OS.ShowWindow(hWnd, OS.SW_SHOW);  
	        OS.UpdateWindow(hWnd);  
	        MSG lpMsg = new MSG();  
	        while (OS.GetMessage(lpMsg, 0, 0, 0)) {  
	            OS.TranslateMessage(lpMsg);  
	            OS.DispatchMessage(lpMsg);  
	        }  
	          
	    }  
	    static int windowProc(int /* long */hwnd, int /* long */msg, int /* long */wParam, int /* long */lParam) {  
	        switch ((int) msg) {  
	            case OS.WM_CREATE:  
	                //创建一个按钮  
	                TCHAR ButtonClass = new TCHAR (0, "BUTTON", true);  
	                  
	                cxChar = OS.LOWORD (OS.GetDialogBaseUnits ()) ;  
	                cyChar = OS.HIWORD (OS.GetDialogBaseUnits ()) ;  
	                for (int i = 0; i < buttons.length; i++) {  
	                    btnHandlers[i] = OS.CreateWindowEx(0, ButtonClass, buttons[i], OS.WS_CHILD | OS.WS_VISIBLE | i, cxChar, cyChar * (1 + 2 * i),  
	                            20 * cxChar, 7 * cyChar / 4, hwnd, 0, OS.GetModuleHandle(null), null);  
	                }  
	                  
	                return 0;  
	            case OS.WM_DESTROY:  
	                System.exit(wParam);  
	            case OS.WM_COMMAND :  
	                //处理button事件  
	                int childId = OS.LOWORD (wParam);  
	                int eventId = OS.HIWORD (wParam);  
	                if ( eventId < TestSwt.eventTable.length) {  
	                    System.out.println("event: " + TestSwt.eventTable[eventId]);  
	                } else {  
	                    System.out.println("unknown event: " + eventId);  
	                }  
	            case OS.WM_SIZE:  
	                rect.left           = 24 * cxChar ;  
	                rect.top            =  2 * cyChar ;  
	                rect.right          = OS.LOWORD (lParam) ;  
	                rect.bottom         = OS.HIWORD (lParam) ;  
	                return 0 ;  
	            case OS.WM_PAINT :  
	                final PAINTSTRUCT lpPaint = new PAINTSTRUCT();  
	                OS.InvalidateRect (hwnd, rect, true) ;  
	            
	                int hdc = OS.BeginPaint (hwnd, lpPaint) ;  
	                OS.SelectObject (hdc, OS.GetStockObject (OS.SYSTEM_FONT)) ;  
	                OS.SetBkMode (hdc, OS.TRANSPARENT) ;  
	        }  
	        return OS.DefWindowProc(hwnd, (int) /* 64 */msg, wParam, lParam);  
	    }  
}
