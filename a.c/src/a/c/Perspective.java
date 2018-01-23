package a.c;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.addView("a.c.view3", IPageLayout.RIGHT, 0.2f, editorArea);
		layout.addView("a.c.view4", IPageLayout.BOTTOM, 0.2f, editorArea);
	}
}
