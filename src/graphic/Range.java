package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Range extends Graphic {
	
	public Range(int x, int y) {
		graphicPoint = new Point();
		graphicPoint.x = x;
		graphicPoint.y = y;
		width = 0;
		height = 0;
	}
	
	@Override
	public void draw(Graphics g) {
		if (width != 0 && height != 0) {
			g.setColor(Color.blue);
			g.drawRect(graphicPoint.x, graphicPoint.y, width, height);
			g.drawString("Select Range", graphicPoint.x, graphicPoint.y - 5);
		}
	}
}
