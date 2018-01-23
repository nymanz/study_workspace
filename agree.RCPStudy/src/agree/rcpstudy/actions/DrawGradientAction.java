package agree.rcpstudy.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import agree.rcpstudy.views.CanvasView;

public class DrawGradientAction implements IWorkbenchWindowActionDelegate {

	IWorkbenchWindow window;

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		IViewReference[] vfs = window.getActivePage().getViewReferences();
		IViewPart vw;
		for (int i = 0; i < vfs.length; i++) {
			vw = vfs[i].getView(false);
			if (vw.getTitle().equals("画图板")) {
				GC gc = new GC(((CanvasView) vw).canvas);
				gc.setBackground(window.getShell().getDisplay()
						.getSystemColor(SWT.COLOR_BLUE));
				gc.fillGradientRectangle(80, 200, 100, 100, false);
				gc.dispose();
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		this.window = window;
	}

}
