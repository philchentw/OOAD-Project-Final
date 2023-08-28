package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import graphic.BasicObject;
import graphic.CompositeObject;
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
	
	public MainFrame mainFrame;
	public ToolBar toolBar;
	public MenuBar menuBar;
	public Canvas canvas;
	
	public BaseMode currentMode = null;
	public final SelectMode selectMode = new SelectMode();
	public final AssociationMode associationMode = new AssociationMode();
	public final GeneralizationLineMode generalizationLineMode = new GeneralizationLineMode();
	public final CompositionLineMode compositionLineMode = new CompositionLineMode();
	public final DependencyLineMode dependencyLineMode = new DependencyLineMode();
	public final ClassMode classMode = new ClassMode();
	public final UseCaseMode useCaseMode = new UseCaseMode();
	
	public Vector<Graphic> graphicArray = new Vector<>();
	
	public int classCounter = 0;
	public int useCaseCounter = 0;
	public int compositionCounter = 0;
	
	public EditController() {
		mainFrame = new MainFrame();
		toolBar = new ToolBar();
		menuBar = new MenuBar();
		canvas = new Canvas();
		
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
	
	public Graphic getToppestGraphic(MouseEvent e) {
		Graphic toppestGraphic = null;
		int depth = 100;
		for (int i = 0; i < graphicArray.size(); i++) {
			Graphic temp = EditController.getInstance().graphicArray.get(i);
			if (temp.isSelected(e)) {
				if (temp.getDepth() <= depth) {
					depth = temp.getDepth();
					toppestGraphic = temp;
				}
			}
		}
		
		return toppestGraphic;
	}
	
	public void group() {
		Vector<Graphic> selectedGraphics = new Vector<>();
		for (Graphic graphic : EditController.getInstance().graphicArray) {
			if (graphic.getGraphicPoint() == null) continue;
			if (graphic.isHighlighed() == true) {
				selectedGraphics.add(graphic);
			}
		}
		
		CompositeObject groupObject = new CompositeObject();
		for (Graphic graphic : selectedGraphics) {
			groupObject.addGraphic(graphic);
		}
		EditController.getInstance().graphicArray.add(groupObject);
		
		graphicArray.removeIf(graphic -> selectedGraphics.contains(graphic));
		
		menuBar.setGroup(false);
		mainFrame.repaint();
	}
	
	public void ungroup() {
		Vector<Graphic> selectedGraphics = new Vector<>();
		for (Graphic graphic : EditController.getInstance().graphicArray) {
			if (graphic.getGraphicPoint() == null) continue;
			if (graphic.isHighlighed() == true) {
				selectedGraphics.add(graphic);
			}
		}
		
		if (selectedGraphics.size() == 1) {
			ArrayList<Graphic> groupList = selectedGraphics.get(0).getGroupList(); 
			if (groupList != null) {
				for (Graphic basicObject: groupList) {
					EditController.getInstance().graphicArray.add(basicObject);
				}
				EditController.getInstance().graphicArray.remove(selectedGraphics.get(0));
				EditController.getInstance().menuBar.setUngroup(false);
				EditController.getInstance().mainFrame.repaint();
			}
		}
	}
	
	public void rename() {
		for (Graphic graphic : EditController.getInstance().graphicArray) {
			if (graphic.getGraphicPoint() != null && graphic.isHighlighed()) {
				String name = JOptionPane.showInputDialog("Please input name:");
				if (name != null) {
					graphic.setName(name);
				}
			}
		}
		
		EditController.getInstance().mainFrame.repaint();
	}
	
	public static void main(String[] args) {
		EditController.getInstance();
	}
}
