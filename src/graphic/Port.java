package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Port extends Graphic {
	private int x, y;
	private int width = 8;
	private int height = 8;
	private Graphic connectedGraphic;
	
	public Port(Graphic graphic) {
		connectedGraphic = graphic;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		draw(g, Color.cyan);
	}
	
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
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
	
	public Point getCenter() {
		return new Point(x + width / 2, y + height / 2);
	}
}
