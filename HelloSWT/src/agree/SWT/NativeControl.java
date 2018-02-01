package agree.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class NativeControl extends Canvas {
	private int childWnd = 0;
	private String startCommand = null;
	private String wndClassName = null;

	private boolean isCreatingNative = false;

	public NativeControl(Composite parent, int style) {
		super(parent, style);
		this.addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent arg0) {
				this.addPaintListener(new PaintListener() {

					public void paintControl(PaintEvent arg0) {
						if (childWnd == 0 && !isCreatingNative) {
							isCreatingNative = true;
							Thread thread = new Thread() {
								public void run() {
									childWnd = HelloSWT.startAndReparent(
											NativeControl.this.handle,
											startCommand, wndClassName);

								}
							};
							thread.start();
						}
					}
				});
			}

			private void addPaintListener(PaintListener paintListener) {
				// TODO Auto-generated method stub
				
			}
		});
		this.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent arg0) {
				if (childWnd != 0) {
					OS.SendMessage(childWnd, OS.WM_CLOSE, 0, 0);
				}
			}

		});
		this.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent arg0) {
				if (childWnd != 0) {
					OS.SetForegroundWindow(childWnd);
				}
			}

			public void focusLost(FocusEvent arg0) {

			}

		});
		this.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent arg0) {

			}

			public void keyReleased(KeyEvent arg0) {

			}

		});

		this.addControlListener(new ControlListener() {

			public void controlMoved(ControlEvent arg0) {

			}

			public void controlResized(ControlEvent arg0) {
				if (childWnd != 0) {
					Rectangle rect = ((Composite) (arg0.widget))
							.getClientArea();
					OS.SetWindowPos(childWnd, 0, rect.x, rect.y, rect.width,
							rect.height, OS.SWP_NOZORDER | OS.SWP_NOACTIVATE
									| OS.SWP_ASYNCWINDOWPOS);
				}
			}

		});
	}
	public void setStartParameters(String startCommand,String wndClassName){
		this.startCommand = startCommand;
		this.wndClassName = wndClassName;
	}

	public String getStartCommand() {
		return startCommand;
	}



	public void setStartCommand(String startCommand) {
		this.startCommand = startCommand;
	}



	public String getWndClassName() {
		return wndClassName;
	}



	public void setWndClassName(String wndClassName) {
		this.wndClassName = wndClassName;
	}

}
