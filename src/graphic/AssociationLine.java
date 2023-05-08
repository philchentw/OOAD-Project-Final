package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class AssociationLine extends Line {
	ArrayList<Point> arrowPoints = new ArrayList<>();
	
	public AssociationLine(Port sPort, Port ePort) {
		startPort = sPort;
		endPort = ePort;
		width = 8;
		height = 8;
		startPoint = startPort.getCenter();
		endPoint = endPort.getCenter();
		calulateArrowPoints();
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
        g.setColor(Color.black);
        // arrow
        for (int i = 0 ; i < arrowPoints.size() - 1; i++) {
        	g.drawLine(arrowPoints.get(i).x, arrowPoints.get(i).y, arrowPoints.get(i+1).x, arrowPoints.get(i+1).y);
        }
	}
	
	private void calulateArrowPoints() {
		double arrowheadAngle = Math.atan(width / height); // angle of arrowhead
        double arrowheadLength = Math.sqrt(width * width + height * height); // length of arrowhead
        double[] arrXY_1 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, arrowheadAngle, true, arrowheadLength);
        double[] arrXY_2 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, -arrowheadAngle, true, arrowheadLength);

        Point up = new Point((int) (endPoint.x - arrXY_1[0]), (int) (endPoint.y - arrXY_1[1]));
        Point down = new Point((int) (endPoint.x - arrXY_2[0]), (int) (endPoint.y - arrXY_2[1]));
        
        arrowPoints.add(up);
        arrowPoints.add(endPoint);
        arrowPoints.add(down);
	}
}
