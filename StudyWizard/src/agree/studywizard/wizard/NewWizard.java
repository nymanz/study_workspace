package agree.studywizard.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewWizard extends Wizard implements INewWizard{
	private NewItemWizardPage newItemPage;
	private EditListsConfigWizardPage editListsConfigPage;
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		
	}
	
	public void addPages(){
		newItemPage = new NewItemWizardPage();
		addPage(newItemPage);
		editListsConfigPage  = new EditListsConfigWizardPage();
		addPage(editListsConfigPage);
	}
	
	private void addPage(NewItemWizardPage newItemPage2) {
		// TODO Auto-generated method stub
		
	}

	private void addPage(EditListsConfigWizardPage editListsConfigPage2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		try{
			getContainer().run(true,true,new IRunnableWithProgress(){
				public void run(IProgressMonitor monitor)throws InvocationTargetException,InterruptedException{
					doFinish(monitor);
				}	
			});
		}catch(InvocationTargetException e){
			e.printStackTrace();
			return false;
		}
		catch(InterruptedException e){
			return false;
		}
		return false;
	}
	private void doFinish(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

}
