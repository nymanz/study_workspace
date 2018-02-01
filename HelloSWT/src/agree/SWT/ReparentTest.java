package agree.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ReparentTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Test dialog");
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		shell.setLayout(layout);
		
		Button button = new Button(shell,SWT.None);
		button.setLayoutData(new GridData());
		button.setText("Test");
		NativeControl control = new NativeControl(shell,SWT.NONE);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = 200;
		data.heightHint = 200;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		control.setLayoutData(data);
		control.setStartParameters
		    ("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","Chrome_WidgetWin_1");
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
	}
}
