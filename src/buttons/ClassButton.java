package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.EditController;

public class ClassButton extends ModeButton {
	public ClassButton() {
		super();
		setIcon(new ImageIcon("image/class.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		EditController.getInstance().currentMode = EditController.getInstance().classMode;
	}
}
