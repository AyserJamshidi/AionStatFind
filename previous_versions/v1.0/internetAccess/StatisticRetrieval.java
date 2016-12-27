/*
 * Created by: Pillows-SL
 */

package internetAccess;

import java.io.IOException;

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
	}
	
	public String RetrievePlayerSpellFortitude() throws IOException {
		String spellFortitudeResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Spell Fortitude</th>") + 36, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Spell Fortitude</th>")));

		spellFortitudeResult = spellFortitudeResult.replaceAll("<td colspan=\"2\">", "");
		spellFortitudeResult = FixSpaces(spellFortitudeResult);
		
		return spellFortitudeResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerSpellResist() throws IOException {
		String spellResistResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Spell Resist</th>") + 33, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Spell Resist</th>")));

		spellResistResult = spellResistResult.replaceAll("<td colspan=\"2\">", "");
		spellResistResult = FixSpaces(spellResistResult);
		
		return spellResistResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerCritFortitude() throws IOException {
		String critFortitudeResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Crit Fortitude</th>") + 35, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Crit Fortitude</th>")));

		critFortitudeResult = critFortitudeResult.replaceAll("<td colspan=\"2\">", "");
		critFortitudeResult = FixSpaces(critFortitudeResult);
		
		return critFortitudeResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerCritResist() throws IOException {
		String critResistResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Crit Resist</th>") + 32, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Crit Resist</th>")));

		critResistResult = critResistResult.replaceAll("<td colspan=\"2\">", "");
		critResistResult = FixSpaces(critResistResult);
		
		return critResistResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerCritSpell() throws IOException {
		String critSpellResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Crit Spell</th>") + 31, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Crit Spell</th>")));

		critSpellResult = critSpellResult.replaceAll("<td colspan=\"2\">", "");
		critSpellResult = critSpellResult.replaceAll(" ", "");
		critSpellResult = critSpellResult.replace("\u0009", ""); // \u2202 is unicode for the Tab button/character
		
		return critSpellResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerEvasion() throws IOException {
		String evasionResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Evasion</th>") + 28, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Evasion</th>")));

		evasionResult = evasionResult.replaceAll("<td colspan=\"2\">", "");
		evasionResult = FixSpaces(evasionResult);
		
		return evasionResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerParry() throws IOException {
		String parryResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Parry</th>") + 26, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Parry</th>")));

		parryResult = parryResult.replaceAll("<td colspan=\"2\">", "");
		parryResult = FixSpaces(parryResult);
		
		return parryResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerPhysicalDefence() throws IOException {
		String physicalDefenceResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Physical Def</th>") + 33, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Physical Def</th>")));

		physicalDefenceResult = physicalDefenceResult.replaceAll("<td colspan=\"2\">", "");
		physicalDefenceResult = FixSpaces(physicalDefenceResult);
		
		return physicalDefenceResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerBlock() throws IOException {
		String blockResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Block</th>") + 26, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Block</th>")));
		
		blockResult = blockResult.replaceAll("<td colspan=\"2\">", "");
		blockResult = FixSpaces(blockResult);
		
		return blockResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerHealBoost() throws IOException {
		String healBoostResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Healing Boost</th>") + 34, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Healing Boost</th>")));
		
		healBoostResult = healBoostResult.replaceAll("<td colspan=\"2\">", "");
		healBoostResult = FixSpaces(healBoostResult);
		
		return healBoostResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerCastSpeed() throws IOException {
		String castSpeedResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Casting Speed</th>") + 34, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Casting Speed</th>")));

		castSpeedResult = castSpeedResult.replaceAll("<td colspan=\"2\">", "");
		castSpeedResult = FixSpaces(castSpeedResult);
		
		return String.format("(+%.2f)", Float.parseFloat(castSpeedResult));
	}
	
	public String RetrievePlayerMagicBoost() throws IOException {
		String magicBoostResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Magic Boost</th>") + 32, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Magic Boost</th>")));
		
		magicBoostResult = magicBoostResult.replaceAll("<td colspan=\"2\">", "");
		magicBoostResult = FixSpaces(magicBoostResult);
		
		return magicBoostResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerMagicAccuracy() throws IOException {
		String magicAccuracyResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Magical Accuracy</th>") + 37, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Magical Accuracy</th>")));
		
		magicAccuracyResult = magicAccuracyResult.replaceAll("<td colspan=\"2\">", "");
		magicAccuracyResult = FixSpaces(magicAccuracyResult);
		
		return magicAccuracyResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerMagicResist() throws IOException {
		String magicResistResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Magic Resist</th>") + 33, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Magic Resist</th>")));
		
		magicResistResult = magicResistResult.replaceAll("<td colspan=\"2\">", "");
		magicResistResult = FixSpaces(magicResistResult);
		
		return magicResistResult.replaceAll("\\(", " \\(");
	}
	
	public String RetrievePlayerMovementSpeed() throws IOException {
		String movementSpeedResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Speed</th>") + 26, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Speed</th>")));

		movementSpeedResult = movementSpeedResult.replaceAll("<td colspan=\"2\">", "");
		movementSpeedResult = FixSpaces(movementSpeedResult);
		
		String[] movementSpeedResultArray = movementSpeedResult.split("\\(\\+");
		if(movementSpeedResultArray.length > 1) {
			movementSpeedResultArray[1] = movementSpeedResultArray[1].replace(")", "");
			return String.format(movementSpeedResultArray[0] + " (+%.2f)", Float.parseFloat(movementSpeedResultArray[1]));
		}
		
		return movementSpeedResult;
	}
	
	public String RetrievePlayerAttackSpeed() throws IOException {
		String attackSpeedResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th colspan=\"2\">Atk Speed</th>") + 30, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th colspan=\"2\">Atk Speed</th>")));

		attackSpeedResult = attackSpeedResult.replaceAll("<td colspan=\"2\">", "");
		attackSpeedResult = FixSpaces(attackSpeedResult);
		
		return attackSpeedResult;
	}
	
	public String RetrievePlayerName() throws IOException {
		String nameResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("</em>") + 6, 
				givenWebsiteSource.indexOf("</span>", givenWebsiteSource.indexOf("<em>")));
		
		return nameResult;
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
		String mainHandAttackResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th>Attack</th>") + 15, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th>Attack</th>")));
		
		mainHandAttackResult = mainHandAttackResult.replaceAll("<td class=\"bRight\">", "");
		
		return FixTabs(mainHandAttackResult);
	}
	
	public String RetrievePlayerOHAttack() throws IOException {
		String offHandAttackResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th>Attack</th>") + 15, 
				givenWebsiteSource.indexOf("<tr class=", givenWebsiteSource.indexOf("<th>Attack</th>")));
		
		offHandAttackResult = offHandAttackResult.substring(offHandAttackResult.indexOf("<td>") + 4, 
				offHandAttackResult.indexOf(("</td>"), offHandAttackResult.indexOf("<th>Attack</th>")));

		return FixTabs(offHandAttackResult);
	}
	
	public String RetrievePlayerMHAccuracy() throws IOException {
		String mainHandAccuracyResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th>Accuracy</th>") + 17, 
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th>Accuracy</th>")));
		
		mainHandAccuracyResult = mainHandAccuracyResult.replaceAll("<td class=\"bRight\">", "");
		
		return FixTabs(mainHandAccuracyResult);
	}
	
	public String RetrievePlayerOHAccuracy() throws IOException {
		String offHandAccuracyResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th>Accuracy</th>") + 17, 
				givenWebsiteSource.indexOf("<tr class=", givenWebsiteSource.indexOf("<th>Accuracy</th>")));
		
		offHandAccuracyResult = offHandAccuracyResult.substring(offHandAccuracyResult.indexOf("<td>") + 4, offHandAccuracyResult.indexOf(("</td>"), offHandAccuracyResult.indexOf("<th>Accuracy</th>")));
		
		return FixTabs(offHandAccuracyResult);
	}
	
	public String RetrievePlayerMHCritStrike() throws IOException {
		String mainHandCritStrikeResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th>Crit Strike</th>") + 20,
				givenWebsiteSource.indexOf("</td>", givenWebsiteSource.indexOf("<th>Crit Strike</th>")));
		
		mainHandCritStrikeResult = mainHandCritStrikeResult.replaceAll("<td class=\"bRight\">", "");
		
		return FixTabs(mainHandCritStrikeResult);
	}
	
	public String RetrievePlayerOHCritStrike() throws IOException {
		String offHandCritStrikeResult = givenWebsiteSource.substring(givenWebsiteSource.indexOf("<th>Crit Strike</th>") + 20, 
				givenWebsiteSource.indexOf("</tr>", givenWebsiteSource.indexOf("<th>Crit Strike</th>") + 20));
		
		offHandCritStrikeResult = offHandCritStrikeResult.replace("\u0009", ""); // \u2202 is unicode for the Tab button/character
		offHandCritStrikeResult = offHandCritStrikeResult.substring(offHandCritStrikeResult.indexOf("<td>") + 4, offHandCritStrikeResult.indexOf(("</td>"), offHandCritStrikeResult.indexOf("<th>Crit Strike</th>")));
		
		return offHandCritStrikeResult;
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
	
	@SuppressWarnings("unused")
	private String RemoveTabCharacter(String givenText) {
		//TODO Remove unicode tab character from given text then return.
		return "";
	}
	
	private String FixTabs(String givenText) {
		givenText = givenText.replace("\u0009", ""); // \u2202 is unicode for the Tab button/character
		return givenText;
	}
	
	private String FixSpaces(String givenText) {
		givenText = givenText.replaceAll(" ", "");
		givenText = givenText.replace("\u0009", ""); // \u2202 is unicode for the Tab button/character
		return givenText;
	}
}
