/*
 * Created by: Pillows-SL
 */

package frameComponents;

import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class FrameDragListener extends MouseAdapter {

    private final JFrame frame;
    private Point mouseDownCompCoords = null;

    public FrameDragListener(JFrame frame) {
        this.frame = frame;
    }

    public void mouseReleased(MouseEvent e) {
    	if(!onlyLMB(e))
    		return;
    	
        mouseDownCompCoords = null;
    }

    public void mousePressed(MouseEvent e) {
    	if(!onlyLMB(e))
    		return;
    	
        mouseDownCompCoords = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
    	if(!onlyLMB(e))
    		return;
    	
    	Point currCoords = e.getLocationOnScreen();
		frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
    
    private boolean onlyLMB(MouseEvent e) {
    	int modifiers = e.getModifiers();
    	if ((modifiers & InputEvent.BUTTON1_MASK) != InputEvent.BUTTON1_MASK) {
    		return false;
    	}
    	return true;
    }
}
