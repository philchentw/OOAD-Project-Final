package graphic;

import java.awt.Color;
import java.awt.Graphics;

public class CompositionLine extends Line {
	private int[] xPoints = new int[4];
	private int[] yPoints = new int[4];
	private int arrowSize = 10;
	
	public CompositionLine(Port sPort, Port ePort) {
		super(sPort, ePort);
//		calculateDiamondPoints();
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		calculateDiamondPoints();
		g.setColor(Color.white);
		g.fillPolygon(xPoints, yPoints, 4);
		if (startPort.isHighlighed() || endPort.isHighlighed())
			g.setColor(Color.cyan);
		else
			g.setColor(Color.black);
		g.drawPolygon(xPoints, yPoints, 4);
	}
	
	private void calculateDiamondPoints() {
		int correctX, correctY;
		correctX = (int) (arrowSize * calculateSin());
		correctY = (int) (arrowSize * calculateCos());
		int x, y;
		x = endPort.getX() + (endPort.getWidth()/2) - (int) (arrowSize * calculateCos());
		y = endPort.getY() + (endPort.getHeight()/2) + (int) (arrowSize * calculateSin());
		
		xPoints[0] = x - correctX;
		xPoints[1] = x - correctY;
		xPoints[2] = x + correctX;
		xPoints[3] = x + correctY;

		yPoints[0] = y - correctY;
		yPoints[1] = y + correctX;
		yPoints[2] = y + correctY;
		yPoints[3] = y - correctX;
	}
}
