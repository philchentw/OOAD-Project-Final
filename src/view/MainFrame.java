package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import constant.Constant;
import controller.EditController;

public class MainFrame extends JFrame {
	private JMenuBar menuBar;
	private ToolBar toolBar;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("UML editor");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(screenSize.getWidth()/2 - Constant.WINDOW_WIDTH/2), (int)(screenSize.getHeight()/2 - Constant.WINDOW_HEIGHT/2), Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		EditController.getInstance().menuBar.repaint();
		EditController.getInstance().toolBar.repaint();
		EditController.getInstance().canvas.repaint();
	}
}
