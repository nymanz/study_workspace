package agree.rcpstudy.views;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import agree.rcpstudy.PersonContentProvider;
import agree.rcpstudy.PersonLabelProvider;
import agree.rcpstudy.PersonModel;

public class View1 extends ViewPart  implements  ISelectionProvider{

	ListViewer viewer;
	private ISelection selection;
	 ArrayList myListeners  =   new  ArrayList();
	 
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		viewer = new ListViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new PersonContentProvider());
		viewer.setLabelProvider(new PersonLabelProvider());
		viewer.setInput(new PersonModel());

		//将视图中具体的Viewer上想要发生的事件，注册到这个Provider上。 
		viewer.addSelectionChangedListener( new  ISelectionChangedListener() {
            public   void  selectionChanged(SelectionChangedEvent event)  {
                  ISelection selection2  =  event.getSelection();
                  setSelection(selection2);
           } 
       } );    
		 this .getSite().setSelectionProvider( this );
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		// TODO Auto-generated method stub
		if(!myListeners.contains(listener))
			myListeners.add(listener);
	}

	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		// TODO Auto-generated method stub
		myListeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		// TODO Auto-generated method stub
		 this .selection  =  selection;
	       SelectionChangedEvent event2  =   new  SelectionChangedEvent(viewer, selection);
	        for  (Iterator i  =  myListeners.iterator(); i.hasNext();)  {
	              ISelectionChangedListener object  =  (ISelectionChangedListener) i.next();
	              object.selectionChanged(event2);
	       } 
	}

}
