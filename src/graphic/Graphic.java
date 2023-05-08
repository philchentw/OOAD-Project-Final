package graphic;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Graphic {
	protected int width, height;
	protected int depth = 90;
	protected Point graphicPoint;
	protected boolean highlight = false;
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
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
}
