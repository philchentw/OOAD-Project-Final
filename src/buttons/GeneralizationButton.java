package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.EditController;

public class GeneralizationButton extends ModeButton {
	public GeneralizationButton() {
		super();
		setIcon(new ImageIcon("image/generalization_line.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		EditController.getInstance().currentMode = EditController.getInstance().generalizationLineMode;
	}
	
}
