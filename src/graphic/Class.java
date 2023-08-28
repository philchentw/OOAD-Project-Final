package graphic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Class extends BasicObject {
	public Class(int ID, MouseEvent e) {
		width = 80;
		height = 100;
		graphicID = ID;
		graphicName = "Class " + ID;
		graphicPoint = new Point(e.getPoint());
		attachPort();
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		if (highlight) {
			draw(g, Color.lightGray);
			for (int i = 1; i <= 4; i++) {
				portArray[i].draw(g);
			}
		}
		else {
			draw(g, Color.white);
		}
	}
	
	public void draw(Graphics g, Color color) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(color);
		g2.fillRect(graphicPoint.x, graphicPoint.y, width, height);
		g2.setStroke(new BasicStroke(1.5f));
		g2.setColor(Color.black);
		g2.drawRect(graphicPoint.x, graphicPoint.y, width, height);
		g2.drawString(graphicName, graphicPoint.x + width / 10, graphicPoint.y + height / 5);
		g2.drawLine(graphicPoint.x, graphicPoint.y + height / 3, graphicPoint.x + width, graphicPoint.y + height / 3);
	    g2.drawLine(graphicPoint.x, graphicPoint.y + (height / 3) * 2, graphicPoint.x + width, graphicPoint.y + (height / 3) * 2);
	    g2.dispose();
	}
}
