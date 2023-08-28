package mode;

import java.awt.event.MouseEvent;

import controller.EditController;
import graphic.AssociationLine;
import graphic.CompositionLine;
import graphic.Port;

public class CompositionLineMode extends LineMode {
	public CompositionLineMode() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		endPort = new Port(null);
		endPort.setX(e.getX());
		endPort.setY(e.getY());
		if (startPort != null) {
			EditController.getInstance().graphicArray.remove(tempLine);
			tempLine = new CompositionLine(startPort, endPort);
			EditController.getInstance().addGraphic(tempLine, e);
			EditController.getInstance().canvas.repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		EditController.getInstance().graphicArray.remove(tempLine);
		
		endGraphic = EditController.getInstance().getToppestGraphic(e);
		if (endGraphic != null && startPort != null && endGraphic != startGraphic) {
//			System.out.println("has endGraphic");
			endPort = endGraphic.getNearestPort(e);
			if (endPort != null)
				EditController.getInstance().addGraphic(new CompositionLine(startPort, endPort), e);
		}
		EditController.getInstance().canvas.repaint();
	}
}
