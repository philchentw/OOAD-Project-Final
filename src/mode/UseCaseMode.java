package mode;

import java.awt.event.MouseEvent;

import controller.EditController;
import graphic.UseCase;

public class UseCaseMode extends BaseMode {
	public UseCaseMode() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		EditController.getInstance().useCaseCounter++;
		EditController.getInstance().addGraphic(new UseCase(EditController.getInstance().useCaseCounter, e), e);
		EditController.getInstance().canvas.repaint();
	}
}
