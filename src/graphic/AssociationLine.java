package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class AssociationLine extends Line {
	ArrayList<Point> arrowPoints;
	
	public AssociationLine(Port sPort, Port ePort) {
		super(sPort, ePort);
		width = 8;
		height = 8;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
        
        // arrow
        calulateArrowPoints();
        for (int i = 0 ; i < arrowPoints.size() - 1; i++) {
        	g.drawLine(arrowPoints.get(i).x, arrowPoints.get(i).y, arrowPoints.get(i+1).x, arrowPoints.get(i+1).y);
        }
	}
	
	private void calulateArrowPoints() {
		arrowPoints = new ArrayList<>();
		double arrowheadAngle = Math.atan(width / height); // angle of arrowhead
        double arrowheadLength = Math.sqrt(width * width + height * height); // length of arrowhead
        double[] arrXY_1 = rotateVec(endPort.getCenter().x - startPort.getCenter().x, endPort.getCenter().y - startPort.getCenter().y, arrowheadAngle, true, arrowheadLength);
        double[] arrXY_2 = rotateVec(endPort.getCenter().x - startPort.getCenter().x, endPort.getCenter().y - startPort.getCenter().y, -arrowheadAngle, true, arrowheadLength);

        Point up = new Point((int) (endPort.getCenter().x - arrXY_1[0]), (int) (endPort.getCenter().y - arrXY_1[1]));
        Point down = new Point((int) (endPort.getCenter().x - arrXY_2[0]), (int) (endPort.getCenter().y - arrXY_2[1]));
        
        arrowPoints.add(up);
        arrowPoints.add(endPort.getCenter());
        arrowPoints.add(down);
	}
}
