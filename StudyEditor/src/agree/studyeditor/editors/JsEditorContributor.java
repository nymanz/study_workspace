package agree.studyeditor.editors;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorActionBarContributor;

public class JsEditorContributor  extends EditorActionBarContributor {
	private Action action1;
	private Action action2;
	public JsEditorContributor(){
		super();
		makeActions();
	}
	private void makeActions() {
		// TODO Auto-generated method stub
		action1 = new Action(){
			public void run(){
				
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 toopltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_DEF_VIEW));
		action2 = new Action(){
			public void run(){
				
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_WARN_TSK));
	}
	public void contributeToMenu(IMenuManager menuManager){
		MenuManager editMenu = new MenuManager("编辑器菜单");
		editMenu.add(action1);
		editMenu.add(action2);
		menuManager.add(editMenu);
	}
	public void contributeToToolBar(IToolBarManager toolBarManager){
		toolBarManager.add(action1);
		toolBarManager.add(action2);
	}
	@Override
	public void init(IActionBars bars, IWorkbenchPage page) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActiveEditor(IEditorPart targetEditor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
