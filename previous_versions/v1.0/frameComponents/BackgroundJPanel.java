/*
 * Created by: Pillows-SL
 */

package frameComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import other.Variables;

@SuppressWarnings("serial")
public class BackgroundJPanel extends JPanel {
	
	// Preset Text Variables
    //Color backgroundBorderColor = new Color((212.2f/255.2f), (206.2f/255.2f), (187.2f/255.2f), 1.0f);
	Color backgroundColor = new Color((250.2f/255.2f), (250.2f/255.2f), (252.2f/255.2f), 1.0f);
    Color outsideXHandColor = new Color((220.2f/255.2f), (220.2f/255.2f), (222.2f/255.2f), 1.0f);
    Color insideXHandColor = new Color((233.2f/255.2f), (233.2f/255.2f), (235.2f/255.2f), 1.0f);
    Color textColor = new Color((102.2f/255.2f), (102.2f/255.2f), (104/255.2f), 1.0f);
    Color healthColor = new Color((222.2f/255.2f), (66.2f/255.2f), (105.2f/255.2f), 1.0f);
    Color manaColor = new Color((65.2f/255.2f), (183.2f/255.2f), (231.2f/255.2f), 1.0f);
    Font textFont = new Font("Tahoma", Font.PLAIN, 11);
    
	// Header Variables
	int playerLevelX = 12;
	int playerLevelY = 94;
	int playerNameX = playerLevelX - 5;
	int playerNameY = playerLevelY + 20;
	
	// Other Variables
    int borderWidth = 289;
    int borderHeight = 530;
    int borderOffsetX = 2;
    int borderOffsetY = 30;
    int backgroundMHHeight = 23;
    int backgroundOHHeight = 73;
    final int LINE_AMOUNT = 23;
    final int TEXT_X_OFFSET = 7;
    final int TEXT_Y_OFFSET = 110;
    final int TEXT_Y_DIVIDER = 24;
    final int TEXT_STATISTIC_Y_OFFSET = 0;
    final int TEXT_STATISTIC_X_OFFSET = 140;
    final int TEXT_STATISTIC_RESULT_X_OFFSET = 190;
    
	public void paintComponent(Graphics g) {
		// Preset variables
		super.paintComponent(g);
		g.setFont(textFont);
		
		// Background color change
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Variables.frameWidth, Variables.frameHeight);
		
		// Main/Off Hand background
		g.setColor(outsideXHandColor);
		g.fillRect(borderOffsetX, ((TEXT_Y_OFFSET / 4) - 4) + 166, borderWidth, backgroundMHHeight); // MH/OH background
		g.setColor(insideXHandColor);
		g.fillRect(borderOffsetX, ((TEXT_Y_OFFSET / 4) - 4) + 189, borderWidth, backgroundOHHeight); // MH/OH stats background
		
		// Thin lines
		g.setColor(Variables.frameBorderColor);
		for(int x = 0; x < LINE_AMOUNT; x++) {
			if(x == 3 || x == 4 || x == 5 || x == 6 || x == 7)
				continue;
			g.drawLine(borderOffsetX + 1, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * x) + 8, 
					borderWidth + 1, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * x) + 8);
		}
		
		// Thin border - Main/Off Hand
		g.drawRect(2, 2, Variables.frameWidth - 5, Variables.frameHeight - 5); // Outside frame border
		g.drawRect(borderOffsetX, ((TEXT_Y_OFFSET / 4) - 5) + 166, borderWidth, 73 + 23); // MH/OH frame border
		g.drawLine(147, ((TEXT_Y_OFFSET / 4) - 5) + 166, 147, 261 + backgroundMHHeight); // Center line
		
		// Draw Player Name/Level
		g.setColor(textColor);
		g.drawString("Level " + Variables.playerRetrievedLevel, TEXT_X_OFFSET, TEXT_Y_OFFSET +  (TEXT_Y_DIVIDER * 0));
		g.drawString("Name " + Variables.playerRetrievedName, TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 1));
		
		// Draw Statistic Names
		g.drawString("HP", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 2));
		g.drawString("MP", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 3));
		
		// ------------
		// Main Hand
		g.drawString("Main Hand", TEXT_X_OFFSET + 40, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 4));
		g.drawString("Attack", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 5));
		g.drawString("Accuracy", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 6));
		g.drawString("Crit Strike", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 7));
		// Off Hand
		g.drawString("Off Hand", TEXT_X_OFFSET + 145 + 42, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 4));
		g.drawString("Attack", TEXT_X_OFFSET + 145, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 5));
		g.drawString("Accuracy", TEXT_X_OFFSET + 145, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 6));
		g.drawString("Crit Strike", TEXT_X_OFFSET + 145, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 7));
		// ------------

		g.drawString("Attack Speed", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 8));
		g.drawString("Move Speed", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 9));
		g.drawString("Magic Boost", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 10));
		g.drawString("Magic Accuracy", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 11));
		g.drawString("Magic Resist", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 12));
		g.drawString("Heal Boost", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 13));
		g.drawString("Cast Speed", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 14));
		g.drawString("Physical Defense", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 15));
		g.drawString("Block", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 16));
		g.drawString("Parry", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 17));
		g.drawString("Evasion", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 18));
		g.drawString("Crit Spell", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 19));
		g.drawString("Crit Resist", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 20));
		g.drawString("Crit Fortitude", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 21));
		g.drawString("Spell Resist", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 22));
		g.drawString("Spell Fortitude", TEXT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 23));
		
		// Draw Actual Statistics
		// Health
		g.setColor(healthColor);
		g.drawString(Variables.playerHP, TEXT_X_OFFSET + TEXT_STATISTIC_X_OFFSET - 20, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 2));
		
		// Mana
		g.setColor(manaColor);
		g.drawString(Variables.playerMP, TEXT_X_OFFSET + TEXT_STATISTIC_X_OFFSET - 20, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 3));

		g.setColor(textColor);
		// ------------
		// Main Hand
		g.drawString(Variables.playerMainHandAttack, TEXT_X_OFFSET + 63, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 5));
		g.drawString(Variables.playerMainHandAccuracy, TEXT_X_OFFSET + 63, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 6));
		g.drawString(Variables.playerMainHandCritStrike, TEXT_X_OFFSET + 63, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 7));
		// Off Hand
		g.drawString(Variables.playerOffHandAttack, TEXT_X_OFFSET + 147 + 60, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 5));
		g.drawString(Variables.playerOffHandAccuracy, TEXT_X_OFFSET + 147 + 60, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 6));
		g.drawString(Variables.playerOffHandCritStrike, TEXT_X_OFFSET + 147 + 60, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 7));
		// ------------
		
		// Standard
		g.drawString(Variables.playerAttackSpeed, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 8));
		g.drawString(Variables.playerMovementSpeed, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 9));
		g.drawString(Variables.playerMagicBoost, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 10));
		g.drawString(Variables.playerMagicAccuracy, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 11));
		g.drawString(Variables.playerMagicResist, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 12));
		g.drawString(Variables.playerHealBoost, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 13));
		g.drawString(Variables.playerCastSpeed, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 14));
		g.drawString(Variables.playerPhysicalDefence, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 15));
		g.drawString(Variables.playerBlock, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 16));
		g.drawString(Variables.playerParry, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 17));
		g.drawString(Variables.playerEvasion, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 18));
		g.drawString(Variables.playerCritSpell, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 19));
		g.drawString(Variables.playerCritResist, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 20));
		g.drawString(Variables.playerCritFortitude, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 21));
		g.drawString(Variables.playerSpellResist, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 22));
		g.drawString(Variables.playerSpellFortitude, TEXT_X_OFFSET + TEXT_STATISTIC_RESULT_X_OFFSET, TEXT_Y_OFFSET + (TEXT_Y_DIVIDER * 23));
	}
}