package agree.rcpstudy.views;

import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import agree.rcpstudy.Person;

public class FirstView extends ViewPart implements ISelectionListener {

	private Table table;
	private Text text_1;
	private Text text;
	public static final String ID = "a.c.views.FirstView"; //$NON-NLS-1$
	ListViewer viewer;
	@SuppressWarnings("unchecked")
	ArrayList myListeners;

	public FirstView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

		Composite container = new Composite(parent, SWT.NONE);

		final Label label = new Label(container, SWT.NONE);
		label.setText("姓名：");
		label.setBounds(56, 42, 38, 20);

		text = new Text(container, SWT.BORDER);
		text.setBounds(98, 38, 78, 20);

		final Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("性别：");
		label_1.setBounds(212, 41, 30, 20);

		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(252, 38, 80, 20);

		final TableViewer tableViewer = new TableViewer(container, SWT.BORDER);

		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setBounds(56, 75, 374, 143);
		table.setItemCount(0);
		table.setLinesVisible(true);
		final TableColumn uname = new TableColumn(table, SWT.NONE);
		uname.setWidth(100);
		uname.setText("姓名");
		final TableColumn sex = new TableColumn(table, SWT.NONE);
		sex.setWidth(100);
		sex.setText("性别");
		final TableColumn condition  = new TableColumn(table, SWT.NONE);
		condition .setWidth(100);
		condition .setText("病情");
		final TableColumn afterCondition  = new TableColumn(table, SWT.NONE);
		afterCondition .setWidth(100);
		afterCondition .setText("病情");
		
		/*final Image image = new Image();*/
		this.getSite().getPage().addSelectionListener(this);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		table.removeAll();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object obj = structuredSelection.getFirstElement();
		Person tempPerson = (Person) obj;
		if (tempPerson != null) {
			text.setText(tempPerson.getName());
			text_1.setText(tempPerson.getSex());
			TableItem Myitem = new TableItem(table, 0);
			
			String[] alist = new String[10];
			int i = 0;
			for (String a : tempPerson.getList()) {
				alist[i++]=a;
			}
			Myitem.setText(alist);
		}
	}
}
