package agree.rcpstudy;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		// 添加视图（视图id，位置，大小，可编译位置）
		layout.addView("agree.RCPStudy.view3", IPageLayout.LEFT, 0.5f,
				editorArea);
		layout.addView("agree.RCPStudy.view2", IPageLayout.RIGHT, 0.2f,
				editorArea);
		// CanvasView  
        layout.addView("agree.RCPStudy.views.CanvasView", IPageLayout.RIGHT, 0.5f,  
                editorArea);  
	}
}
