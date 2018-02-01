package agree.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SWTBrowserTest {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		FillLayout layout = new FillLayout();
		shell.setLayout(layout);

		Group group = new Group(shell, SWT.SHADOW_ETCHED_OUT); // 在当前窗口中创建分组
		group.setText("Group（组）"); // 组名
		group.setLayout(new FillLayout(SWT.VERTICAL)); // 为分组设置布局
		/*final Button radio1 = new Button(group, SWT.RADIO); // 在当前分组中创建单按钮 1
		radio1.setText("First Button"); // 按钮 1 说明
		Button radio2 = new Button(group, SWT.RADIO); // 在当前分组中创建单按钮 2
		radio2.setText("Second Button"); // 按钮 2 说明
*/		
		final Label label1 = new Label(group,SWT.NONE);
		label1.setText("用户名：");
		final Text userName = new Text(group,SWT.SINGLE);	
		
		final Label  label2= new Label(group,SWT.NONE);
		label2.setText("密码：");
		final Text password = new Text(group,SWT.SINGLE);
	
		final Button button = new Button(group, SWT.PUSH); // 在当前窗口创建普通按钮
		button.setText("Common Button"); // 普通按钮说明
		button.setBounds(0, 0, 20, 10);
		
		group.layout(); // 分组布局生效

		// Browser browser = new Browser(shell, SWT.NONE);
		// Browser browser = new Browser(shell, SWT.MOZILLA);
		final Browser browser = new Browser(shell, SWT.FILL);
		browser.addTitleListener(new TitleListener() {
			public void changed(TitleEvent event) {
				shell.setText(event.title);
			}
		});
		browser.setUrl("F:\\软件工程\\Java\\javaweb\\JavaWeb基础知识\\CSSJS8\\test8.html");
		button.addListener(SWT.MouseUp, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				if (userName.getText().equals("王欲鸿")&&password.getText().equals("123456")) {
					browser.setUrl("F:\\软件工程\\Java\\javaweb\\JavaWeb基础知识\\CSSJS8\\test7.html");
				}
				else{
					browser.setUrl("F:\\软件工程\\Java\\javaweb\\JavaWeb基础知识\\CSSJS8\\test8.html");
				}
			}

		});
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}
}
