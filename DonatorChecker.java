package FurbyPackage;

import java.net.*;
import java.io.*;


public class DonatorChecker {

		public static String inputLine;
		
	    public static void main() throws Exception {
	        URL urlholder = new URL("https://www.donation-tracker.com/api?mode=3&channel=furby&api_key=xxxxxxxxxxxxxxxxxx&api_lang=de");
	        URLConnection yc = urlholder.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));

	        while ((inputLine = in.readLine()) != null) 
	        	MyBot.donateurl = inputLine;

	        in.close();
	    }
	}
