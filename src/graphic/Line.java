package graphic;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Line extends Graphic {
	protected Port startPort, endPort;
	protected Point startPoint, endPoint;
	
	public Line() {
		
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
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}
}
