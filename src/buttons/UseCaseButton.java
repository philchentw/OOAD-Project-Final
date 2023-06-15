package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.EditController;

public class UseCaseButton extends ModeButton {
	public UseCaseButton() {
		super();
		setIcon(new ImageIcon("image/case.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		EditController.getInstance().currentMode = EditController.getInstance().useCaseMode;
	}
	
	
}
