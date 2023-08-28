package graphic;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Graphic {
	protected int width, height;
	protected int depth = 90;
	protected int graphicID;
	protected boolean highlight = false;
	protected Point graphicPoint = null;
	protected String graphicName;
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setGraphicPoint(Point point) {
		graphicPoint = point;
	}
	
	public void setGraphicPoint(int x, int y) {
		graphicPoint.x = x;
		graphicPoint.y = y;
	}
	
	public Point getGraphicPoint() {
		return graphicPoint;
	}
	
	public void setName(String name) {
		graphicName = name;
	}
	
	public boolean isSelected(MouseEvent e) {
		return false;
	}
	
	public void enableHighlight() {
		highlight = true;
	}
	
	public void disableHighlight() {
		highlight = false;
	}
	
	public Port getNearestPort(MouseEvent e) {
		return null;
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void setPosition(int dx, int dy) {
		graphicPoint.x += dx;
		graphicPoint.y += dy;
	}
	
	public boolean isHighlighed() {
		return highlight;
	}
	
	public ArrayList<Graphic> getGroupList() {
		return null;
	}
}
