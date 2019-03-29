package agree.rcpstudy;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import agree.rcpstudy.actions.Action1;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction action1;

	/* private Action2 action2; */
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		action1 = new Action1(window);
		action1.setText("第一个菜单栏");
		action1.setId("agree.rcpstudy.action.action1");
		register(action1);
		/*
		 * action2 = new Action2(window); action2.setText("第二个菜单栏");
		 * action2.setId("agree.rcpstudy.action.action1"); register(action2);
		 */
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager newMenu = new MenuManager("第一个菜单",
				"agree.rcpstudy.firstmenu");
		menuBar.add(newMenu);
		newMenu.add(action1);
		/*
		 * MenuManager newMenu2 = new
		 * MenuManager("第二个菜单","agree.rcpstudy.firstmenu");
		 * menuBar.add(newMenu2); newMenu2.add(action1); newMenu2.add(action2);
		 */
	}

}
