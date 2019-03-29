package agree.studyeditor.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import agree.studyeditor.Activator;

public class JsEditorInput implements IEditorInput{
	//输入的字符
	private String input;
	public JsEditorInput(String input){
		this.input = input;
	}
	//返回与该输入相关的类的对象
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}
	//是否将编辑器保存在最近访问记录中
	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return Activator.getImageDescriptor("icons/samples.gif");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return input;
	}
	//是否可以持久化该编辑器
	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}
	//设置编辑器标签中显示提示信息
	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return input;
	}

}
