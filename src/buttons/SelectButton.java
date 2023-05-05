package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.EditController;

public class SelectButton extends ModeButton {
	public SelectButton() {
		super();
		setIcon(new ImageIcon("image/cursor.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		EditController.currentMode = EditController.selectMode;
	}
	
}
