package other;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import internetAccess.StatisticRetrieval;

public class ConfirmButtonThread extends Thread {
	JTextField pLegionTF, pNameTF, pServerTF;
	JTextArea textArea;
	JFrame mainFrame;
	
	public ConfirmButtonThread(JFrame mainFrame, JTextArea textArea, JTextField pNameTF, JTextField pLegionTF, JTextField pServerTF) {
		this.mainFrame = mainFrame;
		this.textArea = textArea;
		this.pNameTF = pNameTF;
		this.pLegionTF = pLegionTF;
		this.pServerTF = pServerTF;
	}
	
	protected void resetTextArea(String text) {
		textArea.setText(null);
		System.out.print(text);
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
	
	protected void pageFromCharID(String mainWebsite) {
		try {
			System.out.print("A character page was found.");
		    Variables.finalCharacterURL = mainWebsite;
			String mainWebsiteSource = internetAccess.Internet.GetURLSource(mainWebsite);
			new internetAccess.StatisticRetrieval(mainWebsiteSource).SetAllPlayerStats();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public void run() {
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
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Variables.alreadySearching = false;
	}
}