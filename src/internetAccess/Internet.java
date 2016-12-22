/*
 * Created by: Pillows-SL
 */

package internetAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Internet {
	public static String GoogleSearch(String legionName, String playerName, String serverName) throws UnsupportedEncodingException, IOException {
		System.out.print("Searching now. ");
		String searchParam = playerName + " " + legionName + " Aion Online Legion charid " + serverName;
		String userAgent = "PillowsSL Aion Search Bot (+http://example.com/bot)"; // Name and bot homepage!
		
		if(legionName.length() > 1) {
			searchParam = legionName + " Aion Online Legion guildid " + serverName;
		}
		
		Elements links = Jsoup.connect("http://www.google.com/search?q=" + URLEncoder.encode(searchParam, "UTF-8")).userAgent(userAgent).get().select(".g>.r>a");
		
		for (Element link : links) {
		    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
		    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

		    if (!url.startsWith("http")) {
		        continue; // Ads/news/etc.
		    }

		    return url;
		}
		System.out.print("Could not find an aion page with the information entered. ");
		return null;
	}
	
	public static String GetURLSource(String givenWebsite) throws IOException {
		URL newConnect = new URL(givenWebsite);
        URLConnection connectedPage = newConnect.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connectedPage.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        
        in.close();
		return a.toString();
	}

	public static String FindCharacterInLegion(String givenPlayerName, String givenWebsite, String givenWebsiteSource) throws IOException {
		boolean playerFound = false;
		boolean similarNameFound = false;
		String fixedPlayerName = givenPlayerName.toLowerCase() + "<";
		String playerFoundURL = null;
		String currentSource = givenWebsiteSource;
		int maxPages = FindMaxNum("javascript:goPage", currentSource) + 1;
		int currentPage = 1;
		
		while(!playerFound && currentPage <= maxPages) {
			if(!currentSource.toLowerCase().contains(fixedPlayerName) || similarNameFound) {
				similarNameFound = false;
				currentSource = internetAccess.Internet.GetURLSource(givenWebsite + "&currentPage=" + currentPage);

				currentPage++;
			} else {
				if(currentSource.toLowerCase().indexOf(fixedPlayerName) != -1) {
					String fixedSource = currentSource.substring(currentSource.toLowerCase().indexOf(fixedPlayerName), 
							currentSource.toLowerCase().indexOf("</a>", currentSource.toLowerCase().indexOf(fixedPlayerName)));

					if(fixedSource.toLowerCase().equals(givenPlayerName.toLowerCase())) {
						playerFoundURL = GetPlayerURL(currentSource, givenPlayerName);
					}
					playerFound = true;
				} else {
					similarNameFound = true;
				}
			}
		}
		
		if(playerFoundURL != null && currentPage <= 10) {
			return playerFoundURL;
		}
		
		System.out.print("This player could not be found in the legion. ");
		return null;
	}
	
	public static String checkVersion() {
		URL versionURL;
		try {
			versionURL = new URL("http://pastebin.com/raw/0kAN4sC6");
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(versionURL.openStream()));

	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    return inputLine;
	                }
	                in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "0.0";
	}
	
	private static int FindMaxNum(String searchForString, String searchWithString) {
		int lastIndex = 0;
		int maxPages = 1;
		
		while(lastIndex != -1){
			lastIndex = searchWithString.indexOf(searchForString,lastIndex);
	
		    if(lastIndex != -1){
		        maxPages++;
		        lastIndex += searchForString.length();
		    }
		}
		return maxPages;
	}
	
	private static String GetPlayerURL(String givenSource, String givenName) {
		givenSource = givenSource.toLowerCase();
		givenName = givenName.toLowerCase();
		String playerURLResult = givenSource.substring(givenSource.indexOf(givenName) - 100, 
				givenSource.indexOf(givenName, givenSource.indexOf(givenName) - 100));
		
		playerURLResult = playerURLResult.substring(playerURLResult.indexOf("<a href=\"") + 9, 
				playerURLResult.indexOf("\">", playerURLResult.indexOf("<a href=\"") + 9));
		
		playerURLResult = playerURLResult.replaceAll("serverid", "serverID");
		playerURLResult = playerURLResult.replaceAll("charid", "charID");
		
		return "http://na.aiononline.com" + playerURLResult;
	}
}
