package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class GeneralizationLine extends Line {
	int[] xPoints = new int[3];
	int[] yPoints = new int[3];
	
	public GeneralizationLine(Port sPort, Port ePort) {
		super(sPort, ePort);
		width = 8;
		height = 8;
		calulateArrowPoints();
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		// arrow
		g.setColor(Color.white);
		g.fillPolygon(xPoints, yPoints, 3);
		g.setColor(Color.black);
		g.drawPolygon(xPoints, yPoints, 3);
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
