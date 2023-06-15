package graphic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Graphic {
	protected Port startPort, endPort;
	protected boolean isDashed = false;
	
	public Line(Port sPort, Port ePort) {
		startPort = sPort;
		endPort = ePort;
	}
	
	public static double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen) {
		double mathsstr[] = new double[2];
        // �V�q�����ơA�ѼƲ[�q���O�Ox�����By�����B���ਤ�B�O�_���ܪ��סB�s����
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
		super.draw(g);
		Graphics2D g2d = (Graphics2D) g;
		if (startPort.isHighlighed() || endPort.isHighlighed()) {
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(Color.cyan);
		}
		else {
			g2d.setStroke(new BasicStroke(1));
			g2d.setColor(Color.black);
		}
		if (!isDashed) {
			g2d.drawLine(startPort.getCenter().x, startPort.getCenter().y, endPort.getCenter().x, endPort.getCenter().y);
		}
		else {
			float[] dashes = {5f};
			g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dashes, 0));
			g2d.drawLine(startPort.getCenter().x, startPort.getCenter().y, endPort.getCenter().x, endPort.getCenter().y);
		}
	}
	
	public double calculateSin() {
		double sin = (startPort.getCenter().y - endPort.getCenter().y) / calculateDistance();
		return sin;
	}

	public double calculateCos() {
		double cos = (endPort.getCenter().x - startPort.getCenter().x) / calculateDistance();
		return cos;
	}

	public double calculateDistance() {
		double distance = Math.sqrt(Math.pow((startPort.getCenter().x - endPort.getCenter().x), 2) + Math.pow((startPort.getCenter().y - endPort.getCenter().y), 2));
		return distance;
	}
}
