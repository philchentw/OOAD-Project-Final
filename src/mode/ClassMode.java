package mode;

import java.awt.event.MouseEvent;

import controller.EditController;
import graphic.Class;

public class ClassMode extends BaseMode {
	public ClassMode() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		EditController.getInstance().classCounter++;
		EditController.getInstance().addGraphic(new Class(EditController.getInstance().classCounter, e), e);
		EditController.getInstance().canvas.repaint();
	}
}
