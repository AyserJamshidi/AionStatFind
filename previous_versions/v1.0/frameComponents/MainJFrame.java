/*
 * Created by: Pillows-SL
 */

package frameComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import internetAccess.StatisticRetrieval;
import other.Variables;

@SuppressWarnings("serial")
public class MainJFrame extends JFrame {
	JFrame mainFrame;
	JTextField pNameTF, pServerTF, pLegionTF;
	JTextArea textArea;
	
	public void JFrame() {
		
		// Variables
		int labelLocX = 3;
		int labelLocY = 12;
		int labelWidth = 39;
		int labelHeight = 14;
		
		// Initialize/create basic frame components
		Label pNameLabel = null;
		Label pServerLabel = null;
		Label pLegionLabel = null;
		pNameTF = new JTextField();
		pServerTF = new JTextField();
		pLegionTF = new JTextField();
		textArea = new JTextArea();
		
		// Initialize and set properties for mainFrame
		mainFrame = new JFrame();
        mainFrame.setResizable(false);
        mainFrame.setUndecorated(true); // Removes standard OS frame
        mainFrame.setSize(Variables.frameWidth, Variables.frameHeight);
        mainFrame.setLocation(Variables.frameLocationX, Variables.frameLocationY);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the frame when closed
	    mainFrame.getContentPane().setBackground(Variables.frameBackgroundColor);
	    BackgroundJPanel panel = new BackgroundJPanel();

        FrameDragListener frameDragListener = new FrameDragListener(mainFrame);
        mainFrame.addMouseListener(frameDragListener);
        mainFrame.addMouseMotionListener(frameDragListener);
        
        
	    // Player Name
	    createLabel(pNameLabel, "Player", labelLocX, (labelLocY * 1) + 15, labelWidth, labelHeight);
	    createTextBox(pNameTF, "", 48, 10 + 15, 100, 20);
	    
	    // Player Server
	    createLabel(pServerLabel, "Server", labelLocX * 50, (labelLocY * 1) + 15, labelWidth, labelHeight);
	    createTextBox(pServerTF, "", labelLocX * 65, ((labelLocY * 1) - 2) + 15, 70, 20);
	    
	    // Player Legion
	    createLabel(pLegionLabel, "Legion", labelLocX, (labelLocY * 3) + 15, labelWidth, labelHeight);
	    createTextBox(pLegionTF, "", 48, ((labelLocY * 3) - 2) + 15, 100, 20);

	    // System output console
	    createTextArea(textArea, labelLocX, Variables.frameHeight - 90, 288, 87); // Magic numbers, because fuck you.
	    
	    // Frame handler buttons
	    setFrameButtonLAF(0); // Sets the Look And Feel to look flat
		createMinimizeButton(Variables.frameWidth - 80, 0, 30, 20);
	    createCloseButton(Variables.frameWidth - 40, 0, 30, 20);
	    setFrameButtonLAF(3); // Sets the Look And Feel to look similar to windows
	    
	    // Confirm Button
	    confirmButtonHandler(labelLocX * 65, ((labelLocY * 3) - 2) + 15, 70, 20);

	    // Frame handler buttons
	    //createMinimizeButton(Variables.frameWidth - 80, 0, 30, 20);
	    //createCloseButton(Variables.frameWidth - 40, 0, 30, 20);
	    
	    mainFrame.add(panel);
	    mainFrame.setVisible(true);
	    pNameTF.requestFocus(); // Sets focus to the name box
	    
		if(internetAccess.Internet.checkVersion().equals(Variables.versionString)) {
			System.out.print("Your version is the most recent. ");
		} else {
			System.out.print("You have an out of date verion."
					+ "\nCurrent version: " + Variables.versionString
					+ "\nRecent version: " + internetAccess.Internet.checkVersion());
		}
	}

	private void setFrameButtonLAF(int num) {
		try {
			UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[num].getClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createMinimizeButton(int x1, int y1, int x2, int y2) {
		JButton jButton = new JButton("\u2014");
		jButton.setBorder(null);
		jButton.setFocusable(false);
		jButton.setBackground(Variables.frameBackgroundColor);
		jButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Variables.frameBorderColor));
		
		jButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainFrame.setState(Frame.ICONIFIED);
			}
		});
		
	    mainFrame.add(jButton);
	    jButton.setBounds(x1, y1, x2, y2);
	}
	
	private void createCloseButton(int x1, int y1, int x2, int y2) {
		JButton jButton = new JButton("X");
		Font frameFont = new Font("Arial", Font.PLAIN, 11);
		jButton.setFont(frameFont);
		jButton.setBorder(null);
		jButton.setFocusable(false);
		jButton.setBackground(Variables.frameBackgroundColor);
		jButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Variables.frameBorderColor));
		
		jButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	    mainFrame.add(jButton);
	    jButton.setBounds(x1, y1, x2, y2);
	}

	private void confirmButtonHandler(int x1, int y1, int x2, int y2) {
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFocusable(false);
	    confirmButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				String mainWebsite;
				String totalWords = pLegionTF.getText() + " " + pNameTF.getText() + " " + pServerTF.getText();
				boolean hasNonAlpha = totalWords.matches("^.*[^a-zA-Z ].*$");
				
				if(!hasNonAlpha) {
					System.out.print("Searching, please wait. ");
					try {
						mainWebsite = internetAccess.Internet.GoogleSearch(pLegionTF.getText(), pNameTF.getText(), pServerTF.getText());
						resetTextArea("");
						if(mainWebsite != null && mainWebsite.toLowerCase().contains("http")) {
							if(mainWebsite.toLowerCase().contains("aiononline")) {
								if(mainWebsite.toLowerCase().contains("guildid")) {
									pageFromGuildID(pNameTF.getText(), mainWebsite);
								} else if(mainWebsite.toLowerCase().contains("charid")) {
									pageFromCharID(mainWebsite);
								} else {
									System.out.print("We've found an aiononline page, but it's not a legion or character page. "
											+ "Please enter more accurate information.");
								}
								System.out.print("\nPlayer URL: " + Variables.finalCharacterURL);
							} else {
								resetTextArea("We've found a page, but it wasn't for aion. "
										+ "Please enter more accurate information.");
							}
						} else {
							new internetAccess.StatisticRetrieval().ResetAllPlayerStats();
							resetTextArea("We couldn't find a proper website. "
									+ "Please enter more accurate information.");
						}
					} catch (IOException e1) {
						try {
							new internetAccess.StatisticRetrieval().ResetAllPlayerStats();
						} catch (IOException e2) {
							e2.printStackTrace();
						};
						resetTextArea("Something internally broke.  Please tell the developer. ");
						e1.printStackTrace();
					}
				} else {
					try {
						new internetAccess.StatisticRetrieval().ResetAllPlayerStats();
					} catch (IOException e1) {
						e1.printStackTrace();
					};
					resetTextArea("Please remove any characters that are not alphabetical. "
					    + "Numeric and special characters are not allowed.");
				}
				Variables.finalCharacterURL = null;
				mainFrame.repaint();
		    }
	    });
	    
	    mainFrame.add(confirmButton);
	    confirmButton.setBounds(x1, y1, x2, y2);
	}

	protected void resetTextArea(String text) {
		textArea.setText(null);
		System.out.print(text);
	}

	protected void pageFromCharID(String mainWebsite) {
		try {
			System.out.print("A character page was found.");
		    Variables.finalCharacterURL = mainWebsite;
			String mainWebsiteSource = internetAccess.Internet.GetURLSource(mainWebsite);
			new internetAccess.StatisticRetrieval(mainWebsiteSource).SetAllPlayerStats();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		//mainFrame.repaint();
	}

	protected void pageFromGuildID(String givenName, String givenWebsiteURL) {
		try {
			System.out.print("A legion page was found. ");
			String mainWebsiteSource;
				mainWebsiteSource = internetAccess.Internet.GetURLSource(givenWebsiteURL);
			
			String playerPageURL = internetAccess.Internet.FindCharacterInLegion(givenName, givenWebsiteURL, mainWebsiteSource);
			
			if(playerPageURL != null) {
				mainWebsiteSource = internetAccess.Internet.GetURLSource(playerPageURL);
			    Variables.finalCharacterURL = playerPageURL;
				StatisticRetrieval stat = new internetAccess.StatisticRetrieval(mainWebsiteSource);
				stat.SetAllPlayerStats();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void createTextArea(JTextArea givenTextArea, int x1, int y1, int x2, int y2) {
		Font textAreaFont = new Font("Monospaced", Font.PLAIN, 11);
	    Color backgroundColor = new Color((233.2f/255.2f), (233.2f/255.2f), (235.2f/255.2f), 1.0f);
	    Color textColor = new Color((102.2f/255.2f), (102.2f/255.2f), (104/255.2f), 1.0f);
	    
	    mainFrame.add(givenTextArea);
	    givenTextArea.setFocusable(true);
	    givenTextArea.setFont(textAreaFont);
	    givenTextArea.setSelectedTextColor(textColor);
	    givenTextArea.setBackground(backgroundColor);
	    givenTextArea.setBounds(x1, y1, x2, y2);
	    givenTextArea.setLineWrap(true);
	    givenTextArea.setWrapStyleWord(true);
	    givenTextArea.setEditable(false);
	    PrintStream printStream = new PrintStream(new frameComponents.CustomOutputStream(givenTextArea));
	    System.setOut(printStream);
	}

	private void createTextBox(JTextField jTextFieldName, String givenText, int x1, int y1, int x2, int y2) {
		mainFrame.add(jTextFieldName);
		jTextFieldName.setBorder(BorderFactory.createBevelBorder(1));
		jTextFieldName.setHorizontalAlignment(JTextField.CENTER);
		jTextFieldName.setText(givenText);
		jTextFieldName.setBounds(x1, y1, x2, y2);
	}

	private void createLabel(Label jLabelName, String givenText, int x1, int y1, int x2, int y2) {
		Font frameFont = new Font("Tahoma", Font.PLAIN, 11);
		
		jLabelName = new Label();
		jLabelName.setFont(frameFont);
	    mainFrame.add(jLabelName);
	    jLabelName.setAlignment(Label.RIGHT);
	    jLabelName.setText(givenText);
	    jLabelName.setBounds(x1, y1, x2, y2);
	}
}