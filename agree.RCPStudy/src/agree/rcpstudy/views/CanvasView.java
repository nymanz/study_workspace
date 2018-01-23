package agree.rcpstudy.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class CanvasView extends ViewPart {
	public Canvas canvas;

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		canvas = new Canvas(parent, SWT.NONE);
		// 增加Paint监听器，避免窗口变化后绘图消失
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				// 画椭圆
				e.gc.drawOval(80, 50, 100, 100);
				// 画矩形
				e.gc.drawRectangle(280, 50, 100, 100);
				// 画渐变矩形
				e.gc.setBackground(PlatformUI.getWorkbench().getDisplay()
						.getSystemColor(SWT.COLOR_BLUE));
				e.gc.fillGradientRectangle(80, 200, 100, 100, false);
				// 画图形
				Image img = new Image(PlatformUI.getWorkbench().getDisplay(),
						"F:\\1.png");
				e.gc.drawImage(img, 280, 200);
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
