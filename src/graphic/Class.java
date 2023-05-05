package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Class extends BaseObject {
	public Class(int ID, MouseEvent e) {
		width = 80;
		height = 100;
		objectID = ID;
		objectName = "Class " + ID;
		graphicPoint = new Point(e.getPoint());
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		
		if (isSelected) {
			draw(g, Color.lightGray);
		}
		else {
			draw(g, Color.white);
		}
	}
	
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(graphicPoint.x, graphicPoint.y, width, height);
		g.setColor(Color.black);
		g.drawRect(graphicPoint.x, graphicPoint.y, width, height);
		g.drawString(objectName, graphicPoint.x + width / 10, graphicPoint.y + height / 5);
		g.drawLine(graphicPoint.x, graphicPoint.y + height / 3, graphicPoint.x + width, graphicPoint.y + height / 3);
	    g.drawLine(graphicPoint.x, graphicPoint.y + (height / 3) * 2, graphicPoint.x + width, graphicPoint.y + (height / 3) * 2);
	}
}
