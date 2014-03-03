package FurbyPackage;

import java.net.*;
import java.io.*;


public class DonatorChecker {

		public static String inputLine;
		public static String top5;
		
	    public static void main() throws Exception {
	        URL urlholder = new URL("https://www.donation-tracker.com/api?mode=4&channel=furby&api_key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxS&api_lang=de");
	        URLConnection yc = urlholder.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));

	        while ((inputLine = in.readLine()) != null) 
	        	MyBot.donateurl = inputLine;

	        in.close();
	    }
	    public static void top5() throws Exception {
	    	URL urlholder = new URL ("https://www.donation-tracker.com/api?mode=6&channel=furby&api_key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxS&api_lang=de)");
	    	URLConnection yc = urlholder.openConnection();
	    	BufferedReader in = new BufferedReader(
	    						new InputStreamReader(
	    						yc.getInputStream()));
	    	
	    	while ((top5 = in.readLine()) != null)
	    		MyBot.donatetop5 = top5;
	    	
	    	in.close();
	    } 

	}
