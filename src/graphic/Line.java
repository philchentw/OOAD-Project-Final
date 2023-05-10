package graphic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Line extends Graphic {
	protected Port startPort, endPort;
	protected Point startPoint, endPoint;
	protected boolean isDashed = false;
	
	public Line(Port sPort, Port ePort) {
		startPort = sPort;
		endPort = ePort;
		startPoint = sPort.getCenter();
		endPoint = ePort.getCenter();
	}
	
	public static double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen) {
		double mathsstr[] = new double[2];
        // 秖臂锣ㄧ计把计瞇竡だ琌xだ进yだ进臂锣à琌э跑穝
        double vx = px * Math.cos(ang) - py * Math.sin(ang);
        double vy = px * Math.sin(ang) + py * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathsstr[0] = vx;
            mathsstr[1] = vy;
        }
        return mathsstr;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		if (!isDashed) {
			g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		}
		else {
			Graphics2D g2d = (Graphics2D) g;
			float[] dashes = {5f, 5f};
			g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dashes, 0));
			g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		}
	}
	
	public double calculateSin() {
		double sin = (startPoint.y - endPoint.y) / calculateDistance();
		return sin;
	}

	public double calculateCos() {
		double cos = (endPoint.x - startPoint.x) / calculateDistance();
		return cos;
	}

	public double calculateDistance() {
		double distance = Math.sqrt(Math.pow((startPoint.x - endPoint.x), 2) + Math.pow((startPoint.y - endPoint.y), 2));
		return distance;
	}
}
