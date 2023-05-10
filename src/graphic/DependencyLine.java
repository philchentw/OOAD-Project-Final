package graphic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DependencyLine extends Line {
	int[] xPoints = new int[3];
	int[] yPoints = new int[3];
	
	public DependencyLine(Port sPort, Port ePort) {
		super(sPort, ePort);
		width = 8;
		height = 8;
		isDashed = true;
		calulateArrowPoints();
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		// arrow
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g2d.setColor(Color.white);
		g2d.fillPolygon(xPoints, yPoints, 3);
		g2d.setColor(Color.black);
		g2d.drawPolygon(xPoints, yPoints, 3);
	}
	
	private void calulateArrowPoints() {
		double arrowheadAngle = Math.atan(width / height); // angle of arrowhead
        double arrowheadLength = Math.sqrt(width * width + height * height); // length of arrowhead
        double[] arrXY_1 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, arrowheadAngle, true, arrowheadLength);
        double[] arrXY_2 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, -arrowheadAngle, true, arrowheadLength);

        xPoints[0] = (int) (endPoint.x - arrXY_1[0]);
        xPoints[1] = (int) (endPoint.getX());
        xPoints[2] = (int) (endPoint.x - arrXY_2[0]);

        yPoints[0] = (int) (endPoint.y - arrXY_1[1]);
        yPoints[1] = (int) (endPoint.getY());
        yPoints[2] = (int) ((endPoint.y - arrXY_2[1]));
        
	}
}
