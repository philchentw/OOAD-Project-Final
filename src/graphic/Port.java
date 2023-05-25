package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Port extends Graphic {
	private Graphic connectedGraphic;
	private Point center = new Point();
	
	public Port(Graphic graphic) {
		connectedGraphic = graphic;
		width = 8;
		height = 8;
		graphicPoint = new Point();
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		draw(g, Color.cyan);
	}
	
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(graphicPoint.x, graphicPoint.y, width, height);
		g.setColor(Color.black);
		g.drawRect(graphicPoint.x, graphicPoint.y, width, height);
	}
	
	public void setX(int x) {
		this.graphicPoint.x = x;
	}
	
	public int getX() {
		return graphicPoint.x;
	}
	
	public void setY(int y) {
		this.graphicPoint.y = y;
	}
	
	public int getY() {
		return graphicPoint.y;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public Point getCenter() {
		center.x = graphicPoint.x + width / 2;
		center.y = graphicPoint.y + height / 2;
		return center;
	}
	
	@Override
	public boolean isSelected(MouseEvent e) {
		Point current = e.getPoint();
		if (current.x >= graphicPoint.x && current.x <= graphicPoint.x + width
				&& current.y >= graphicPoint.y && current.y <= graphicPoint.y + height) {
			return true;
		}
		return false;
	}
}
