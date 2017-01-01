/*
 * Created by: Pillows-SL
 */

package internetAccess;

import java.io.IOException;
import java.text.DecimalFormat;

import other.Variables;

public class StatisticRetrieval {
	
	private String givenWebsiteSource;
	
	public StatisticRetrieval() {
		
	}
	
	public StatisticRetrieval(String givenWebsiteSource) {
		this.givenWebsiteSource = givenWebsiteSource;
	}
	
	public void SetAllPlayerStats() throws IOException {
		
		// Player Gear Statistics
		Variables.playerRetrievedName = RetrievePlayerName();
		Variables.playerRetrievedLevel = RetrievePlayerLevel();
		Variables.playerHP = RetrievePlayerHP();
		Variables.playerMP = RetrievePlayerMP();
		Variables.playerMainHandAttack = RetrievePlayerMHAttack();
		Variables.playerMainHandAccuracy = RetrievePlayerMHAccuracy();
		Variables.playerMainHandCritStrike = RetrievePlayerMHCritStrike();
		Variables.playerOffHandAttack = RetrievePlayerOHAttack();
		Variables.playerOffHandAccuracy = RetrievePlayerOHAccuracy();
		Variables.playerOffHandCritStrike = RetrievePlayerOHCritStrike();
		Variables.playerAttackSpeed = RetrievePlayerAttackSpeed();
		Variables.playerMovementSpeed = RetrievePlayerMovementSpeed();
		Variables.playerMagicBoost = RetrievePlayerMagicBoost();
		Variables.playerMagicAccuracy = RetrievePlayerMagicAccuracy();
		Variables.playerMagicResist = RetrievePlayerMagicResist();
		Variables.playerHealBoost = RetrievePlayerHealBoost();
		Variables.playerCastSpeed = RetrievePlayerCastSpeed();
		Variables.playerPhysicalDefence = RetrievePlayerPhysicalDefence();
		Variables.playerBlock = RetrievePlayerBlock();
		Variables.playerParry = RetrievePlayerParry();
		Variables.playerEvasion = RetrievePlayerEvasion();
		Variables.playerCritSpell = RetrievePlayerCritSpell();
		Variables.playerCritResist = RetrievePlayerCritResist();
		Variables.playerCritFortitude = RetrievePlayerCritFortitude();
		Variables.playerSpellResist = RetrievePlayerSpellResist();
		Variables.playerSpellFortitude = RetrievePlayerSpellFortitude();

		// Player Abyss Statistics
		
	}
	
	public void ResetAllPlayerStats() throws IOException {
		
		// Player Gear Statistics
		Variables.playerRetrievedName = "";
		Variables.playerRetrievedLevel = "";
		Variables.playerHP = "";
		Variables.playerMP = "";
		Variables.playerMainHandAttack = "";
		Variables.playerMainHandAccuracy = "";
		Variables.playerMainHandCritStrike = "";
		Variables.playerOffHandAttack = "";
		Variables.playerOffHandAccuracy = "";
		Variables.playerOffHandCritStrike = "";
		Variables.playerAttackSpeed = "";
		Variables.playerMovementSpeed = "";
		Variables.playerMagicBoost = "";
		Variables.playerMagicAccuracy = "";
		Variables.playerMagicResist = "";
		Variables.playerHealBoost = "";
		Variables.playerCastSpeed = "";
		Variables.playerPhysicalDefence = "";
		Variables.playerBlock = "";
		Variables.playerParry = "";
		Variables.playerEvasion = "";
		Variables.playerCritSpell = "";
		Variables.playerCritResist = "";
		Variables.playerCritFortitude = "";
		Variables.playerSpellResist = "";
		Variables.playerSpellFortitude = "";
		
		// Player Abyss Statistics
		
	}
	
	public String RetrievePlayerSpellFortitude() throws IOException {
		String spellFortitudeResult = fixString("<th colspan=\"2\">Spell Fortitude</th>", "</td>", "<th colspan=\"2\">Spell Fortitude</th>");

		return fixSpaces(completeFormatting(spellFortitudeResult));
	}
	
	public String RetrievePlayerSpellResist() throws IOException {
		String spellResistResult = fixString("<th colspan=\"2\">Spell Resist</th>", "</td>", "<th colspan=\"2\">Spell Resist</th>");

		return fixSpaces(completeFormatting(spellResistResult));
	}
	
	public String RetrievePlayerCritFortitude() throws IOException {
		String critFortitudeResult = fixString("<th colspan=\"2\">Crit Fortitude</th>", "</td>", "<th colspan=\"2\">Crit Fortitude</th>");

		return fixSpaces(completeFormatting(critFortitudeResult));
	}
	
	public String RetrievePlayerCritResist() throws IOException {
		String critResistResult = fixString("<th colspan=\"2\">Crit Resist</th>", "</td>", "<th colspan=\"2\">Crit Resist</th>");

		return fixSpaces(completeFormatting(critResistResult));
	}
	
	public String RetrievePlayerCritSpell() throws IOException {
		String critSpellResult = fixString("<th colspan=\"2\">Crit Spell</th>", "</td>", "<th colspan=\"2\">Crit Spell</th>");
		
		return fixSpaces(completeFormatting(critSpellResult));
	}
	
	public String RetrievePlayerEvasion() throws IOException {
		String evasionResult = fixString("<th colspan=\"2\">Evasion</th>", "</td>", "<th colspan=\"2\">Evasion</th>");
		
		return fixSpaces(completeFormatting(evasionResult));
	}
	
	public String RetrievePlayerParry() throws IOException {
		String parryResult = fixString("<th colspan=\"2\">Parry</th>", "</td>", "<th colspan=\"2\">Parry</th>");
		
		return fixSpaces(completeFormatting(parryResult));
	}
	
	public String RetrievePlayerBlock() throws IOException {
		String blockResult = fixString("<th colspan=\"2\">Block</th>", "</td>", "<th colspan=\"2\">Block</th>");
		
		return fixSpaces(completeFormatting(blockResult));
	}
	
	public String RetrievePlayerPhysicalDefence() throws IOException {
		String physicalDefenceResult = fixString("<th colspan=\"2\">Physical Def</th>", "</td>", "<th colspan=\"2\">Physical Def</th>");
		
		return fixSpaces(completeFormatting(physicalDefenceResult));
	}
	
	public String RetrievePlayerCastSpeed() throws IOException {
		String castSpeedResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Casting Speed</th>") + 34, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Casting Speed</th>")));

		castSpeedResult = castSpeedResult.replaceAll("<td colspan=\"2\">", "");
		castSpeedResult = fixSpaces(castSpeedResult);
		
		return String.format("(+%.2f)", Float.parseFloat(castSpeedResult));
	}
	
	public String RetrievePlayerHealBoost() throws IOException {
		String healBoostResult = fixString("<th colspan=\"2\">Healing Boost</th>", "</td>", "<th colspan=\"2\">Healing Boost</th>");
		
		return fixSpaces(completeFormatting(healBoostResult));
	}
	
	public String RetrievePlayerMagicResist() throws IOException {
		String magicResistResult = fixString("<th colspan=\"2\">Magic Resist</th>", "</td>", "<th colspan=\"2\">Magic Resist</th>");
		
		return fixSpaces(completeFormatting(magicResistResult));
	}
	
	public String RetrievePlayerMagicAccuracy() throws IOException {
		String magicAccuracyResult = fixString("<th colspan=\"2\">Magical Accuracy</th>", "</td>", "<th colspan=\"2\">Magical Accuracy</th>");
		
		return fixSpaces(completeFormatting(magicAccuracyResult));
	}
	
	public String RetrievePlayerMagicBoost() throws IOException {
		String magicBoostResult = fixString("<th colspan=\"2\">Magic Boost</th>", "</td>", "<th colspan=\"2\">Magic Boost</th>");
		
		return fixSpaces(completeFormatting(magicBoostResult));
	}
	
	public String RetrievePlayerMovementSpeed() throws IOException {
		String movementSpeedResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Speed</th>") + 26, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Speed</th>")));

		movementSpeedResult = movementSpeedResult.replaceAll("<td colspan=\"2\">", "");
		movementSpeedResult = fixSpaces(movementSpeedResult);
		
		String[] movementSpeedResultArray = movementSpeedResult.split("\\(\\+");
		if(movementSpeedResultArray.length > 1) {
			movementSpeedResultArray[1] = movementSpeedResultArray[1].replace(")", "");
			return String.format(movementSpeedResultArray[0] + " (+%.2f)", Float.parseFloat(movementSpeedResultArray[1]));
		}
		
		return movementSpeedResult;
	}
	
	public String RetrievePlayerAttackSpeed() throws IOException {
		String attackSpeedResult = fixString("<th colspan=\"2\">Atk Speed</th>", "</td>", "<th colspan=\"2\">Atk Speed</th>");
		
		return fixSpaces(completeFormatting(attackSpeedResult));
	}
	
	public String RetrievePlayerName() throws IOException {
		return fixString("</em>", "</span>", "<em>");
	}
	
	public String RetrievePlayerLevel() throws IOException {
		String levelResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<em>") + 4, 
				givenWebsiteSource.indexOf("</em>"));
		
		return levelResult;
	}
	
	public String RetrievePlayerHP() throws IOException {
		String hitpointResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("class=\"hp\">") + 11, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("class=\"hp\">")));
		
		return hitpointResult;
	}
	
	public String RetrievePlayerMP() throws IOException {
		String manaResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("class=\"mp\">") + 11, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("class=\"mp\">")));
		
		return manaResult;
	}
	
	public String RetrievePlayerMHAttack() throws IOException {
		String mainHandAttackResult = fixString("<th>Attack</th>", "</td>", "<th>Attack</th>");
		mainHandAttackResult = mainHandAttackResult.replaceAll("<td class=\"bRight\">", "");
		
		return fixSpaces(completeFormatting(mainHandAttackResult));
	}
	
	public String RetrievePlayerOHAttack() throws IOException {
		String offHandAttackResult = fixString("<th>Attack</th>", "<tr class=", "<th>Attack</th>");

		offHandAttackResult = offHandAttackResult.substring(offHandAttackResult.indexOf("<td>") + 4, 
				offHandAttackResult.indexOf(("</td>"), offHandAttackResult.indexOf("<th>Attack</th>")));
		
		return fixSpaces(completeFormatting(offHandAttackResult));
	}
	
	public String RetrievePlayerMHAccuracy() throws IOException {
		String mainHandAccuracyResult = fixString("<th>Accuracy</th>", "</td>", "<th>Accuracy</th>");
		mainHandAccuracyResult = mainHandAccuracyResult.replaceAll("<td class=\"bRight\">", "");
		
		return fixSpaces(completeFormatting(mainHandAccuracyResult));
	}
	
	public String RetrievePlayerOHAccuracy() throws IOException {
		String offHandAccuracyResult = fixString("<th>Accuracy</th>", "<tr class=", "<th>Accuracy</th>");

		offHandAccuracyResult = offHandAccuracyResult.substring(offHandAccuracyResult.indexOf("<td>") + 4, 
				offHandAccuracyResult.indexOf(("</td>"), offHandAccuracyResult.indexOf("<th>Accuracy</th>")));
		
		return fixSpaces(completeFormatting(offHandAccuracyResult));
	}
	
	public String RetrievePlayerMHCritStrike() throws IOException {
		String mainHandCritStrikeResult = fixString("<th>Crit Strike</th>", "</td>", "<th>Crit Strike</th>");
		mainHandCritStrikeResult = mainHandCritStrikeResult.replaceAll("<td class=\"bRight\">", "");
		
		return fixSpaces(completeFormatting(mainHandCritStrikeResult));
	}
	
	public String RetrievePlayerOHCritStrike() throws IOException {
		String offHandCritStrikeResult = fixString("<th>Crit Strike</th>", "</tr>", "<th>Crit Strike</th>");

		offHandCritStrikeResult = offHandCritStrikeResult.substring(offHandCritStrikeResult.indexOf("<td>") + 4, 
				offHandCritStrikeResult.indexOf(("</td>"), offHandCritStrikeResult.indexOf("<th>Crit Strike</th>")));
		
		return fixSpaces(completeFormatting(offHandCritStrikeResult));
	}
	
	public String RetrievePlayerRace() {
		/*
		 * race_1 = Asmo
		 * 	race_1_0 = Asmo Male
		 * 	race_1_1 = Asmo Female
		 * race_0 = Elyos
		 * 	race_0_0 = Elyos Male
		 * 	race_0_1 = Elyos Female
		 */
		
		String shorterSource = givenWebsiteSource.substring(givenWebsiteSource.indexOf("race_"), givenWebsiteSource.indexOf(".jpg", givenWebsiteSource.indexOf("race_")));
		Boolean raceResult = shorterSource.contains("race_0");

		//TODO Return the player's race
		if(raceResult) { // True == Elyos
			System.out.println("Elyos");
			if(shorterSource.contains("_0_0")) { // True == Male
				// return URL for male Elyos
			} else { // False == Female
				// return URL for female Elyos
			}
		} else { // False == Asmo
			System.out.println("Asmo");
			if(shorterSource.contains("_1_0")) { // True == Male
				// return URL for male Asmo
			} else { // False == Female
				// return URL for female Asmo
			}
		}
		
		return shorterSource;
	}
	
	public String RetrievePlayerLegion() { // Done
		String legionRoughResult = givenWebsiteSource.substring(givenWebsiteSource.toLowerCase().indexOf("guildid") + 7, 
				givenWebsiteSource.indexOf("</a>", givenWebsiteSource.toLowerCase().indexOf("guildid") + 7));
		String legionFinalResult = legionRoughResult.substring(legionRoughResult.indexOf("\">") + 2);
		return legionFinalResult;
	}
	
	public String RetrievePlayerClass() {
		//TODO Return the player's class
		return "";
	}
	
	public String RetrievePlayerDailyAP() {
		//TODO Return the player's daily AP
		return "";
	}
	
	public String RetrievePlayerDailyKills() {
		//TODO Return the player's daily kills
		return "";
	}
	
	public String RetrievePlayerWeeklyAP() {
		//TODO Return the player's weekly AP
		return "";
	}
	
	public String RetrievePlayerWeeklyKills() {
		//TODO Return the player's weekly kills
		return "";
	}
	
	public String RetrievePlayerTotalKills() { // Done
		String killsRoughResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("Total Kills: <strong>") + 21, 
				givenWebsiteSource.indexOf("</strong>", givenWebsiteSource.indexOf("Total Kills: <strong>") + 21));
		return killsRoughResult;
	}
	
	public String RetrievePlayerHighestAbyssRank() {
		return "";
	}
	
	public String RetrievePlayerAbyssRank() {
		//TODO Return a player's current Abyss rank
		return "";
	}
	
	public String RetrievePlayerAbyssPoints() {
		//TODO Return a player's current AP
		return "";
	}
	
	/*
	 * Other methods to fix returning statistic
	 */
	
	/*private String removeTabCharacter(String givenText) {
		//TODO Remove unicode tab character from given text then return.
		return "";
	}
	
	private String fixTabs(String givenText) {
		givenText = givenText.replace("\u0009", "");
		return givenText;
	}*/
	
	private String fixSpaces(String givenText) {
		givenText = givenText.replaceAll(" ", "");
		givenText = givenText.replace("\u0009", "");
		return givenText;
	}
	
	private String completeFormatting(String givenString) {
		DecimalFormat formatter = new DecimalFormat("#,###");
		
		// Ignore this disgusting tree, it's comprehensible to me.
		return formatter.format(
					Double.parseDouble(
						fixParenthesis(fixSpaces(givenString.replaceAll("<td colspan=\"2\">", ""))).replaceAll("\\(.*?\\)", "")
					)
				).toString();
		//return fixParenthesis(fixSpaces(givenString.replaceAll("<td colspan=\"2\">", ""))).replaceAll("\\(.*?\\)", "");
	}
	
	private String fixString(String arg0, String arg1, String arg2) {
		String createdResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf(arg0) + arg0.length(), 
				givenWebsiteSource.indexOf(arg1, givenWebsiteSource.indexOf(arg2)));
		return createdResult;
	}
	
	private String fixParenthesis(String givenText) {
		return givenText.replaceAll("\\(", " \\(");
	}
}
