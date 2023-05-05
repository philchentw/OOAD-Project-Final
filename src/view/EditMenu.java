package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditMenu extends JMenu {
	private JMenuItem group = new JMenuItem("Group");
	private JMenuItem ungroup = new JMenuItem("UnGroup");
	private JMenuItem changeObjectName = new JMenuItem("Change Object Name");
	
	public EditMenu() {
		setText("Edit");
		add(group);
		add(ungroup);
		add(changeObjectName);		
	}
}
