package buttons;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.EditController;

public class CompositionButton extends ModeButton {
	public CompositionButton() {
		super();
		setIcon(new ImageIcon("image/com_line.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		EditController.getInstance().currentMode = EditController.getInstance().compositionLineMode;
	}
	
}
