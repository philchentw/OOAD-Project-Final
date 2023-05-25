package mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import controller.EditController;
import graphic.BasicObject;
import graphic.CompositeObject;
import graphic.Graphic;
import graphic.Port;
import graphic.Range;

public class SelectMode extends BaseMode {
	Graphic targetGraphic;
	MouseEvent startMouseEvent, endMouseEvent;
	Range range;
	Port selectedPort;
	int targetPortNum = 0;
	
	public SelectMode() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		targetGraphic = EditController.getInstance().getToppestGraphic(e);
		selectThisGraphic();
		if (targetGraphic instanceof BasicObject) {
			EditController.getInstance().menuBar.setChangeObjectName(true);
		}
		EditController.getInstance().canvas.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		targetGraphic = EditController.getInstance().getToppestGraphic(e);
		startMouseEvent = e;
		if (targetGraphic == null) {
			range = new Range(e.getX(), e.getY());
			selectThisGraphic();
			
			EditController.getInstance().menuBar.setGroup(false);
			EditController.getInstance().menuBar.setUngroup(false);
			EditController.getInstance().menuBar.setChangeObjectName(false);
		}
		else if (targetGraphic.isHighlighed() && targetGraphic instanceof BasicObject){
			selectedPort((BasicObject)targetGraphic);
			System.out.println(targetPortNum);
		}
		else if (selectedPort != null) {
			selectedPort.disableHighlight();
			selectedPort = null;
			EditController.getInstance().canvas.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if (targetGraphic == null) {
			endMouseEvent = e;
			selectRange();
			EditController.getInstance().graphicArray.remove(range);
		}
		EditController.canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
//		System.out.println("mouse Dragged");
		endMouseEvent = e;
		if (targetGraphic != null) {
			if (targetPortNum == 0) {
				int offsetX = endMouseEvent.getX() - startMouseEvent.getX();
				int offsetY = endMouseEvent.getY() - startMouseEvent.getY();
				startMouseEvent = endMouseEvent;
				targetGraphic.setPosition(offsetX, offsetY);
			}
		}
		else {
			int x = Math.min(endMouseEvent.getX(), startMouseEvent.getX());
			int y = Math.min(endMouseEvent.getY(), startMouseEvent.getY());
			range.setGraphicPoint(x, y);
			range.setWidth(Math.abs(endMouseEvent.getX() - startMouseEvent.getX()));
			range.setHeight(Math.abs(endMouseEvent.getY() - startMouseEvent.getY()));
			EditController.getInstance().graphicArray.remove(range);
			EditController.getInstance().graphicArray.add(range);
		}
		EditController.canvas.repaint();
	}
	
	private void selectThisGraphic() {
		int SIZE = EditController.getInstance().graphicArray.size();
		for (int i = 0; i < SIZE; i++) {
			if (EditController.getInstance().graphicArray.get(i) != targetGraphic) {
				EditController.getInstance().graphicArray.get(i).disableHighlight();
			}
		}
		
		if (targetGraphic != null) {
			targetGraphic.enableHighlight();
		}
	}
	
	private void selectRange() {
		ArrayList<Graphic> selectedGraphic = new ArrayList<>();
		
		Graphic temp = null;
		int SIZE = EditController.getInstance().graphicArray.size();
		for (int i = 0; i < SIZE; i++) {
			temp = EditController.getInstance().graphicArray.get(i);
			if (!(temp instanceof BasicObject) && !(temp instanceof CompositeObject))
				continue;
			
			if ((range.getGraphicPoint().x <= temp.getGraphicPoint().x) && 
				(range.getGraphicPoint().y <= temp.getGraphicPoint().y) && 
				((temp.getGraphicPoint().x + temp.getWidth()) <= (range.getGraphicPoint().x + range.getWidth())) &&
				((temp.getGraphicPoint().y + temp.getHeight() <= (range.getGraphicPoint().y + range.getHeight())))
				) {
				temp.enableHighlight();
//				System.out.println(temp.getClass().getSuperclass().getName());
				selectedGraphic.add(temp);
			}
		}
		
		if (selectedGraphic.size() == 1 && selectedGraphic.get(0) instanceof BasicObject) {
			EditController.menuBar.setChangeObjectName(true);
		}
		
		if (selectedGraphic.size() >= 2) {
//			System.out.println("set group true");
			EditController.menuBar.setGroup(true);
		}
	}
	
	private void selectedPort(BasicObject basicObject) {
		Port[] portArray = basicObject.getPortArray();
		for (int i = 1; i <= 4; i++) {
			if (portArray[i].isSelected(startMouseEvent)) {
				portArray[i].enableHighlight();
				selectedPort = portArray[i];
				return;
			}
		}
		selectedPort = null;
	}
}
