package agree.studyeditor;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import agree.studyeditor.editors.OpenEditorView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
	String editorArea = layout.getEditorArea();
	layout.addStandaloneView(OpenEditorView.ID, true, IPageLayout.RIGHT, 0.3f, editorArea);
	}
}
