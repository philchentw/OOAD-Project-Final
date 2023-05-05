package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;

import buttons.AssociationButton;
import buttons.ClassButton;
import buttons.CompositionButton;
import buttons.DependencyButton;
import buttons.GeneralizationButton;
import buttons.ModeButton;
import buttons.SelectButton;
import buttons.UseCaseButton;
import constant.Constant;
import mode.BaseMode;

public class ToolBar extends JPanel {
	private ArrayList<ModeButton> buttons = new ArrayList<>();
	
	public ToolBar() {
		setBackground(Color.gray);
		setPreferredSize(new Dimension(Constant.TOOLBAR_WIDTH, Constant.TOOLBAR_HEIGHT));
		setVisible(true);
		setLayout(new GridLayout(7, 1));
		
		buttons.add(new SelectButton());
		buttons.add(new AssociationButton());
		buttons.add(new GeneralizationButton());
		buttons.add(new CompositionButton());
		buttons.add(new DependencyButton());
		buttons.add(new ClassButton());
		buttons.add(new UseCaseButton());
		
		for (ModeButton button : buttons) {
			add(button);
		}
		
		setVisible(true);
	}
	
	public void initializeIcon() {
		for (ModeButton button : buttons) {
			button.setBackground(UIManager.getColor("Button.background"));
			button.setOpaque(false);
		}
	}
}
