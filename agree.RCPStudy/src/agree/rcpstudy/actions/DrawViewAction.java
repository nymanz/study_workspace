package agree.rcpstudy.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;

public class DrawViewAction implements IWorkbenchWindowActionDelegate{
	IWorkbenchWindow window;
	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		//获得当前页面
				if(window == null){
					return;
				}
				IWorkbenchPage page = window.getActivePage();
				if(page == null){
					return;
				}
				try{
					//打开地址本视图
					page.showView("agree.rcpstudy.views.CanvasView");
				}catch(PartInitException e ){
					MessageDialog.openError(window.getShell(), "地址本插件", "打不开地址本视图");
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
