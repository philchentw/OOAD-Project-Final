package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.EditController;

public class MenuBar extends JMenuBar implements ActionListener {
	private JMenu file, edit;
	private JMenuItem group = new JMenuItem("Group");
	private JMenuItem ungroup = new JMenuItem("UnGroup");
	private JMenuItem reanme = new JMenuItem("Change Object Name");
	
	public MenuBar() {
		file = new JMenu();
		edit = new JMenu();
		
		file.setText("File");
		
		edit.setText("Edit");
		group.setEnabled(false);
		ungroup.setEnabled(false);
		reanme.setEnabled(false);
		
		group.addActionListener(this);
		ungroup.addActionListener(this);
		reanme.addActionListener(this);
		
		edit.add(group);
		edit.add(ungroup);
		edit.add(reanme);
		
		add(file);
		add(edit);
	}
	
	public JMenu getFile() {
		return file;
	}
	
	public JMenu getEdit() {
		return edit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == group) {
			EditController.getInstance().group();
		}
		else if (e.getSource() == ungroup) {
			EditController.getInstance().ungroup();
		}
		else if (e.getSource() == reanme) {
			EditController.getInstance().rename();
		}
	}
	
	public void setGroup(boolean b) {
		group.setEnabled(b);
	}
	
	public void setUngroup(boolean b) {
		ungroup.setEnabled(b);
	}
	
	public void setChangeObjectName(boolean b) {
		reanme.setEnabled(b);
	}
}
