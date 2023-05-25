package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import controller.EditController;

public class CompositeObject extends Graphic {
	ArrayList<Graphic> groupList = new ArrayList<>();
	
	public CompositeObject() {
		width = 0;
		height = 0;
		EditController.getInstance().compositionCounter++;
		graphicID = EditController.getInstance().compositionCounter;
		graphicName = "Composite " + graphicID;
	}
	
	public void addGraphic(Graphic object) {
		groupList.add(object);
		setRange(object);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.red);
		g.drawRoundRect(graphicPoint.x - 5, graphicPoint.y - 5, width + 10, height + 10, 10, 10);
		g.drawString(graphicName, graphicPoint.x, graphicPoint.y - 10);
		for (Graphic graphic : groupList) {
			graphic.draw(g);
		}
	}
	
	@Override
	public void setPosition(int dx, int dy) {
		super.setPosition(dx, dy);
		for (Graphic graphic : groupList) {
			graphic.setPosition(dx, dy);
		}
	}
	
	@Override
	public void enableHighlight() {
		for(int i = 0; i< groupList.size(); i++) {
			((Graphic) groupList.get(i)).enableHighlight();
		}
		this.highlight = true;
		
		EditController.menuBar.setUngroup(true);
	}
	
	@Override
	public void disableHighlight() {
		for(int i = 0; i< groupList.size(); i++) {
			((Graphic) groupList.get(i)).disableHighlight();
		}
		this.highlight = false;
		
		EditController.menuBar.setUngroup(false);
	}
	
	@Override
	public boolean isSelected(MouseEvent e) {
		int currentX = e.getX();
		int currentY = e.getY();
		int widthUpperBound = graphicPoint.x + width - 1;
		int widthLowerBound = graphicPoint.x;
		int heightUpperBound = graphicPoint.y + height - 1;
		int heightLowerBound = graphicPoint.y;
		
		if ((currentX >= widthLowerBound) && (currentX <= widthUpperBound) && 
				(currentY >= heightLowerBound) && (currentY <= heightUpperBound)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public ArrayList<Graphic> getGroupList() {
		return groupList;
	}
	
	private void setRange(Graphic object) {
		if (graphicPoint == null) {
			graphicPoint = new Point(object.graphicPoint.x, object.graphicPoint.y);
			width = object.width;
			height = object.height;
		}
		else {
			Point leftUp = new Point(graphicPoint);
			Point rightBottom = new Point(graphicPoint.x + width, graphicPoint.y + height);
			if (object.graphicPoint.x < graphicPoint.x) {
				leftUp.x = object.graphicPoint.x;
			}
			if (object.graphicPoint.y < graphicPoint.y) {
				leftUp.y = object.graphicPoint.y;
			}
			if ((object.graphicPoint.x + object.width) > (graphicPoint.x + width)) {
				rightBottom.x = object.graphicPoint.x + object.width;
			}
			if ((object.graphicPoint.y + object.height) > (graphicPoint.y + height)) {
				rightBottom.y = object.graphicPoint.y + object.height;
			}
			
			graphicPoint = leftUp;
			width = rightBottom.x - leftUp.x;
			height = rightBottom.y - leftUp.y;
		}
	}
}
