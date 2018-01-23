package agree.rcpstudy.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import agree.rcpstudy.FirstDialog;

public class Action1 extends Action implements IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;

	public Action1(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		this.workbenchWindow = window;
	}

	public void run() {
		if (workbenchWindow != null) {
			FirstDialog dg = new FirstDialog(workbenchWindow.getShell());
			dg.open();
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		workbenchWindow = null;
	}

}
