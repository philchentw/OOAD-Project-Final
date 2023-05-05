package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.EditController;

public class DependencyButton extends ModeButton {
	public DependencyButton() {
		super();
		setIcon(new ImageIcon("image/dependency.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		EditController.currentMode = EditController.dependencyLineMode;
	}
	
}
