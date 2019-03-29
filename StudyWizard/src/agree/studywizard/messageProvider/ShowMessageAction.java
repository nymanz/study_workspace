package agree.studywizard.messageProvider;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;


public class ShowMessageAction extends Action implements IWorkbenchWindowActionDelegate{
	
	 IWorkbenchWindow workbenchWindow;

	public ShowMessageAction(){}
	
	public void run(IAction action){
		//访问插件注册表
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		//参数填写扩展点，获取扩展点
		IExtensionPoint ep = reg.getExtensionPoint("agree.studyWizard.messages");
		//获取扩展元素
		IExtension[] extensions = ep.getExtensions();
		//遍历获取到的扩展元素
		for(int i = 0;i<extensions.length;i++){
			IExtension ext = extensions[i];
			//扩展元素的第一个参数
			IConfigurationElement ce = ext.getConfigurationElements()[0];
			if(!"impl".equals(ce.getName()))
				return;
			try{
				String name = ce.getAttribute("name");
				Object obj =ce.createExecutableExtension("class");
				IMessageProvider provider = (IMessageProvider)obj;
				MessageDialog.openInformation(workbenchWindow.getShell(), "From"+name+":"+provider.getTitle(), provider.getMessage());
			}catch(CoreException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		this.workbenchWindow = window;
	}
}
