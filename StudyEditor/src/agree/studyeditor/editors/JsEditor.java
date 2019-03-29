package agree.studyeditor.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class JsEditor extends EditorPart {
	//对应plugin.xml
	public static final String ID="agree.StudyEditor.editor1";
	public Text text;
	//编辑器中的内容是否被修复的标志
	private boolean bDirty = false;
	public JsEditor(){
		super();
	}

	//创建编辑器中的控件
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		text = new Text(parent,SWT.NONE);
		//当文本框修改时，设定内容被修改过
		text.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				if(!isDirty()){//如果未修改
					setDirty(true);//设置修改
					firePropertyChange(IEditorPart.PROP_DIRTY);
				}
			}

			private void setDirty(boolean b) {
				// TODO Auto-generated method stub
				bDirty = b;
			}
			
		});
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		//将保存状态显示在状态栏中
		try{
			monitor.beginTask("保存文件。。。", 100);
			for(int i = 0;i<10&&!monitor.isCanceled();i++){
				Thread.sleep(500);
				monitor.worked(10);
				double d = (i+1)/10d;
				monitor.subTask("已完成"+d*100+"%");//显示任务状态
			}
			monitor.done();
			if(monitor.isCanceled())
				throw new InterruptedException("取消保存");
		}catch(InterruptedException e )
		{
			;
		}
	}
	
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return bDirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSaveOnCloseNeeded() {
		// TODO Auto-generated method stub
		return false;
	}
	//初始化编辑器
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		this.setSite(site);//设置site
		this.setInput(input);//设置输入的IEditorInput对象
		this.setPartName(input.getName());//设置编辑器上方显示的名字
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
