package cn.com.agree.OleTest;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class Player {
	protected Shell shell; 
    private String file;
    private MenuItem[] fileItem;	
    WMP composite ;
  
    /**  
     * Launch the application  
     * 开始应用
     * @param args  
     */  
    public static void main(String[] args)   
    {   
        try  
        {   
            Player window = new Player();   
            window.open();   
        }   
        catch (Exception e)   
        {   
            e.printStackTrace();   
        }   
    }   
  
    /**  
     * Open the window  
     */  
    public void open()   
    {   
        final Display display = Display.getDefault();   
        createContents();   
        shell.open();   
        shell.layout();   
        while (!shell.isDisposed())   
        {   
            if (!display.readAndDispatch())   
                display.sleep();   
        }   
    }   
  
    /**  
     * Create contents of the window  
     */  
    protected void createContents()   
    {   
        shell = new Shell();   
        shell.setLayout(new FillLayout());   
        shell.setSize(500, 375);   
        shell.setText("模板播放");   
        createMenu();
        composite= new WMP(shell, SWT.NONE);    
       
    }
	private void createMenu() {
		Menu main = new Menu(shell, SWT.BAR);
		//这个类的实例代表一个可选的用户界面对象，它在按下和释放时发出通知
		MenuItem file = new MenuItem(main, SWT.CASCADE);
		file.setText("文件(&F)");
		Menu fileMenu = new Menu(file);
		fileItem = new MenuItem[2];
		fileItem[0] = new MenuItem(fileMenu, SWT.PUSH);
		fileItem[0].setText("打开");
		file.setMenu(fileMenu);
		shell.setMenuBar(main);
		//在“打开”文件目录中添加查询监听器，查询要打开的文件是否存在，
		//若存在则打开文件
		fileItem[0].addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(shell, SWT.OPEN);
				//过滤文件，只留下.doc文件
				dialog.setFilterExtensions(new String[] { "*.wmv", "*.*" });
				String file = dialog.open();
				setFile(file);
				composite.play(getFile());   
			}
		});
	}
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }  
}
