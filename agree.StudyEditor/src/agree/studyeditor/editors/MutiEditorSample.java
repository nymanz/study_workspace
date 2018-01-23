package agree.studyeditor.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

public class MutiEditorSample extends MultiPageEditorPart{
	public static final String ID="agree.StudyEditor.MutiEditorSample";
	private JsEditor page1;//编辑器对象
	private JsEditor page2;//编辑器对象
	private Label control1;//标签对象
	//父类中抽象方法
	@Override
	protected void createPages() {
		// TODO Auto-generated method stub
		page1 = new JsEditor();
		page2 = new JsEditor();
		control1 = new Label(getContainer(),SWT.NONE);
		control1.setText("这是一个标签");
		try{
			//添加第一页
			addPage(page1,new JsEditorInput("One"));
			//设置选项卡的名称
			setPageText(0,"One");
			//添加第二页
			addPage(page2,new JsEditorInput("Two"));
			setPageText(1,"Two");
			//添加第三页
			addPage(control1);
			setPageText(2,"Three");
		}catch(PartInitException e){
			e.printStackTrace();
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
