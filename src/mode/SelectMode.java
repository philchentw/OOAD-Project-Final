package mode;

import java.awt.event.MouseEvent;

import controller.EditController;
import graphic.Graphic;

public class SelectMode extends BaseMode {
	Graphic targetGraphic;
	
	public SelectMode() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		targetGraphic = EditController.getInstance().getToppestGraphic(e);
		selectThisGraphic();
		EditController.canvas.repaint();
	}
	
	private void selectThisGraphic() {
		int SIZE = EditController.getInstance().graphicArray.size();
		for (int i = 0; i < SIZE; i++) {
			if (EditController.getInstance().graphicArray.get(i) != targetGraphic) {
				EditController.getInstance().graphicArray.get(i).disableHighlight();
			}
		}
		
		if (targetGraphic != null) {
			targetGraphic.enableHighlight();
		}
	}
}
