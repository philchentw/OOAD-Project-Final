package mode;

import java.awt.event.MouseEvent;

import controller.EditController;
import graphic.Graphic;
import graphic.Port;

public class LineMode extends BaseMode {
	protected Port startPort, endPort;
	protected Graphic tempLine;
	protected Graphic startGraphic, endGraphic;
	
	public LineMode() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		startGraphic = EditController.getInstance().getToppestGraphic(e);
		
		if (startGraphic != null) {
			startPort = startGraphic.getNearestPort(e);
		}
		else {
			startPort = null;
		}
	}
}
