package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	private JMenu file, edit;
	
	public MenuBar() {
		file = new FileMenu();
		edit = new EditMenu();
		
		add(file);
		add(edit);
	}
}
