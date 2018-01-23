package cn.com.agree.OleTest;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleEvent;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.OleListener;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TestOCX {
	private static final String OCX_ID = "KING.TestOCX";  
    private int width = 500;  
    private int height = 500;  
    private Display display;  
    private Shell shell;  
    private OleAutomation automation;  
    private HashMap<Integer,String> events;  
      
    public TestOCX()  
    {  
        this.events = new HashMap<Integer,String>();  
        this.events.put(1, "onEvent1");  
        this.events.put(2, "onEvent2");  
        this.events.put(3, "onEvent2");  
    }  
      
    private void createShell()  
    {  
        this.display = Display.getDefault();  
        this.shell = new Shell(this.display);  
        this.shell.setSize(this.width,this.height);  
        this.shell.setText("TestOCX");  
    }  
    private void createOCX()  
    {  
        OleFrame frame = new OleFrame(this.shell,SWT.Expand);  
        frame.setSize(this.width,this.height);  
        OleControlSite site = new OleControlSite(frame,SWT.NONE,TestOCX.OCX_ID);  
        site.doVerb(OLE.OLEIVERB_SHOW);  
        OleListener listener = new OleListener()  
        {  
            @Override  
            public void handleEvent(OleEvent arg0)  
            {  
                System.out.println("handleEvent("+TestOCX.this.events.get(arg0.type)+")");  
            }  
        };  
        for(Object event : this.events.keySet().toArray())  
        {  
            System.out.println(event);  
            site.addEventListener((Integer)(event),listener);  
        }  
        this.automation = new OleAutomation(site);  
    }  
    private int operationOCX()  
    {  
        int[] ids = this.automation.getIDsOfNames(new String[] {"func1"});  
        Variant[] args = new Variant[1];  
        args[0] = new Variant(1);  
        Variant result = this.automation.invoke(ids[0],args);  
        return result.getInt();  
    }  
    public void run()  
    {  
        this.createShell();  
        this.createOCX();  
        this.shell.open();  
        while(!this.shell.isDisposed())  
        {  
            if(!this.display.readAndDispatch())  
            {  
                this.display.sleep();  
            }  
        }  
        this.display.close();  
    }  
    public static void main(String[] args)   
    {  
        TestOCX ocx = new TestOCX();  
        ocx.run();  
    }  
}
