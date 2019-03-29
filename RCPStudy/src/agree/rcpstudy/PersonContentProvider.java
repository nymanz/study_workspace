package agree.rcpstudy;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;



public class PersonContentProvider implements IStructuredContentProvider {

	PersonModel input;
	ListViewer viewer;

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		/*if (input != null) {
			input.setListener(null);
		}
		input = null;*/
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		this.viewer = (ListViewer) viewer;
		this.input = (PersonModel) newInput;
		/*input.setListener(this);*/
	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return input.elements().toArray();
	}

	public void add(Person p) {
		viewer.add(p);
	}

	public void remove(Person p) {
		viewer.remove(p);
	}

}
