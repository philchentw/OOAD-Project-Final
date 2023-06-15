package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import constant.Constant;
import controller.EditController;
import graphic.Graphic;
import graphic.Range;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
	
	public Canvas() {	
		setBackground(Color.white);
		setBorder(BorderFactory.createTitledBorder("Canvas"));
		setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(Constant.CANVAS_WIDTH, Constant.CANVAS_HEIGHT));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (EditController.getInstance().currentMode != null) {
			EditController.getInstance().currentMode.mouseDragged(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (EditController.getInstance().currentMode != null) {
			EditController.getInstance().currentMode.mouseMoved(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (EditController.getInstance().currentMode != null) {
			EditController.getInstance().currentMode.mouseClicked(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (EditController.getInstance().currentMode != null) {
			EditController.getInstance().currentMode.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (EditController.getInstance().currentMode != null) {
			EditController.getInstance().currentMode.mouseReleased(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (EditController.getInstance().currentMode != null) {
			EditController.getInstance().currentMode.mouseEntered(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (EditController.getInstance().currentMode != null) {
			EditController.getInstance().currentMode.mouseExited(e);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int SIZE = EditController.getInstance().graphicArray.size();
		for (int i = 0; i < SIZE; i++) {
			Graphic graphic = EditController.getInstance().graphicArray.get(i);
			graphic.draw(g);
		}
	}
}
