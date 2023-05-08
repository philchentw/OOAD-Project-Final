package mode;

import java.awt.event.MouseEvent;

import controller.EditController;
import graphic.AssociationLine;
import graphic.Graphic;
import graphic.Port;

public class AssociationMode extends LineMode {
	
	public AssociationMode() {
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
			tempLine = new AssociationLine(startPort, endPort);
			EditController.getInstance().addGraphic(tempLine, e);
			EditController.canvas.repaint();
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
			EditController.getInstance().addGraphic(new AssociationLine(startPort, endPort), e);
		}
		EditController.canvas.repaint();
	}
}
