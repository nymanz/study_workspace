package agree.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloSWT extends Shell{
	private static Text text;
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
		text = new Text(shell,SWT.BORDER);
		text.setText("SWT是Eclipse平台使用的图形工具箱");
		text.setBounds(10, 8, 230, 35);
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
	}
}
