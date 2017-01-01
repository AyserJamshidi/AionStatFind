/*
 * Created by: Pillows-SL
 */

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import frameComponents.MainJFrame;

public class AionStatFind {
	
	public static void main(String arg[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		// Creates the main frame
		MainJFrame frame = new frameComponents.MainJFrame();
        UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[3].getClassName());
		frame.JFrame();
	}
}

/*
 * TODO
 * -Make textArea JTextArea have a scroll bar while auto-scrolling to the bottom
 * -Make the playerURL in the jTextArea a clickable hyperlink
 */