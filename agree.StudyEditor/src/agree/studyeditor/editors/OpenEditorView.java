package agree.studyeditor.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.part.NullEditorInput;
import org.eclipse.ui.part.ViewPart;

public class OpenEditorView extends ViewPart{
	public static final String ID = "agree.StudyEditor.view2";
	public List list;
	public OpenEditorView(){
		super();
	}
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		list = new List(parent,SWT.NONE);
		list.add("Editor");
		list.add("MutiPage Editor");
		list.add("Form Editor");
		list.add("Master/Detail Page");
		list.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				String select = list.getSelection()[0];
				IWorkbenchPage page = getViewSite().getWorkbenchWindow().getActivePage();
				try{
					if(select.equals("Editor")){
						JsEditorInput editor = new JsEditorInput(select);
						page.openEditor(editor, JsEditor.ID);
					}else if(select.equals("MutiPage Editor")){
						page.openEditor(new NullEditorInput(), MutiEditorSample.ID);
					}
				}catch(PartInitException ee){
					ee.printStackTrace();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});


	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		list.setFocus();
	}

}
