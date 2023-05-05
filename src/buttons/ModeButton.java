package buttons;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.EditController;
import mode.BaseMode;

public class ModeButton extends JButton implements ActionListener {
	
	public ModeButton() {
		this.addActionListener(this);
	    this.setRequestFocusEnabled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EditController.getInstance().toolBar.initializeIcon();
		setOpaque(true);
		setBackground(Color.LIGHT_GRAY);
	}
	
}
