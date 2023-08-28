package graphic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class UseCase extends BasicObject {
	public UseCase(int ID, MouseEvent e) {
		width = 120;
		height = 60;
		
		graphicID = ID;
		graphicName = "Use Case " + graphicID;
		graphicPoint = new Point(e.getPoint());
		attachPort();
	}
	
	@Override
	public void draw(Graphics g) {
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
		g2.fillOval(graphicPoint.x, graphicPoint.y, width, height);
		g2.setStroke(new BasicStroke(1.5f));
		g2.setColor(Color.black);
		g2.drawOval(graphicPoint.x, graphicPoint.y, width, height);
		g2.drawString(graphicName, graphicPoint.x + width / 4, graphicPoint.y + height / 2);
		g2.dispose();
	}
}
