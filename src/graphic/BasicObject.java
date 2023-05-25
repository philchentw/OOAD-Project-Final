package graphic;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class BasicObject extends Graphic {
	protected Port[] portArray = new Port[5];
	
	public BasicObject() {
		for (int i = 1; i <= 4; i++) {
			portArray[i] = new Port(this);
		}
	}
	
	public void attachPort() {
		// top -> right -> bottom -> left
		portArray[1].setX(graphicPoint.x + (width / 2) - (portArray[1].getWidth() / 2));
		portArray[1].setY(graphicPoint.y - (portArray[1].getHeight() / 2));
//		portArray[1].setCenter(new Point(portArray[1].getX() + portArray[1].getWidth() / 2, portArray[1].getY() + portArray[1].getHeight() / 2));
		
		portArray[2].setX(graphicPoint.x + width - (portArray[2].getWidth() / 2));
		portArray[2].setY(graphicPoint.y + (height / 2) - (portArray[2].getHeight() / 2));
//		portArray[2].setCenter(new Point(portArray[2].getX() + portArray[2].getWidth() / 2, portArray[2].getY() + portArray[2].getHeight() / 2));
		
		portArray[3].setX(graphicPoint.x + (width / 2) - (portArray[3].getHeight() / 2));
		portArray[3].setY(graphicPoint.y + height - (portArray[3].getHeight() / 2));
//		portArray[3].setCenter(new Point(portArray[3].getX() + portArray[3].getWidth() / 2, portArray[3].getY() + portArray[3].getHeight() / 2));
		
		portArray[4].setX(graphicPoint.x - (portArray[4].getWidth() / 2));
		portArray[4].setY(graphicPoint.y + (height / 2) - (portArray[4].getHeight() / 2));
//		portArray[4].setCenter(new Point(portArray[4].getX() + portArray[4].getWidth() / 2, portArray[4].getY() + portArray[4].getHeight() / 2));
	}
	
	public Port[] getPortArray() {
		return portArray;
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
	public Port getNearestPort(MouseEvent e) {
		Point currentMouse = e.getPoint();
		double min = currentMouse.distance((Point2D) portArray[1].getCenter());
		Port res = portArray[1];
		
		for (int i = 2; i <= 4; i++) {
			double dist = currentMouse.distance(portArray[i].getCenter());
			if (dist < min) {
				min = dist;
				res = portArray[i];
			}
		}
		
		return res;
	}
	
	@Override
	public void setPosition(int dx, int dy) {
		super.setPosition(dx, dy);
		for (int i = 1; i <= 4; i++) {
			portArray[i].setPosition(dx, dy);
		}
	}
}
