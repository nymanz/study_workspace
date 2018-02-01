package agree.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloSWT extends Shell{
/*	static{
		System.loadLibrary("reparent");
	}*/
	public static native int startAndReparent(int parentWnd,
	            String command,String wndClass);
	private static Text text1,text2;
	private static Button swtButton;
	private static Button swingButton;
	private static Button awtButton;
	private static Group group;
	private static Button button;
	private static Label benefitOfSwtLabel;
	private static List list;
	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setSize(260,283);
		shell.open();
		text1 = new Text(shell,SWT.BORDER);
		text1.setBounds(10, 8, 230, 35);
		text2 = new Text(shell,SWT.BORDER);
		text2.setBounds(10, 58, 230, 35);
		button = new Button(shell,SWT.NONE);
		button.setBounds(10, 108, 200, 30);
		button.setText("登陆");
		benefitOfSwtLabel = new Label(shell,SWT.NONE );
		benefitOfSwtLabel.setBounds(10, 158, 230, 35);
		button.addListener(SWT.MouseDown, new Listener(){

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				if(text1.getText().equals("王欲鸿")&&text2.getText().equals("123456"))
				benefitOfSwtLabel.setText("登陆成功");
				else
					benefitOfSwtLabel.setText("登录失败");
			}
			
		});
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
	}
}
