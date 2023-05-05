package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.util.Vector;

import graphic.Graphic;
import mode.AssociationMode;
import mode.BaseMode;
import mode.ClassMode;
import mode.CompositionLineMode;
import mode.DependencyLineMode;
import mode.GeneralizationLineMode;
import mode.SelectMode;
import mode.UseCaseMode;
import view.Canvas;
import view.MainFrame;
import view.MenuBar;
import view.ToolBar;

public class EditController {
	private static EditController _instance = null;
	
	public static MainFrame mainFrame;
	public static ToolBar toolBar;
	public static MenuBar menuBar;
	public static Canvas canvas;
	
	public static BaseMode currentMode = null;
	public static SelectMode selectMode;
	public static AssociationMode associationMode;
	public static GeneralizationLineMode generalizationLineMode;
	public static CompositionLineMode compositionLineMode;
	public static DependencyLineMode dependencyLineMode;
	public static ClassMode classMode;
	public static UseCaseMode useCaseMode;
	
	public Vector<Graphic> graphicArray = new Vector<>();
	
	public int classCounter = 0;
	public int useCaseCounter = 0;
	public int compositionCounter = 0;
	
	public EditController() {
		mainFrame = new MainFrame();
		toolBar = new ToolBar();
		menuBar = new MenuBar();
		canvas = new Canvas();
		selectMode = new SelectMode();
		associationMode = new AssociationMode();
		generalizationLineMode = new GeneralizationLineMode();
		compositionLineMode = new CompositionLineMode();
		dependencyLineMode = new DependencyLineMode();
		classMode = new ClassMode();
		useCaseMode = new UseCaseMode();
		
		Container content = mainFrame.getContentPane();
		content.setBackground(Color.white);
		content.add(toolBar, BorderLayout.WEST);
		content.add(canvas, BorderLayout.EAST);
		
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setVisible(true);
	}
	
	public static EditController getInstance() {
		if (_instance == null) {
			_instance = new EditController();
		}
		return _instance;
	}
	
	public void addGraphic(Graphic graphic, MouseEvent e) {
		EditController.getInstance().graphicArray.add(graphic);
	}
	
	public static void main(String[] args) {
		EditController.getInstance();
	}
}
