package FurbyPackage;

import org.jibble.pircbot.PircBot;

@SuppressWarnings("unused")



public class MyBotMain {
	    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        MyBot bot = new MyBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        bot.setEncoding("UTF-8");
        
        // Connect to the IRC server.
        bot.connect("199.9.253.199", 6667, "oauth:xxxxxxxxxxxxxxx");

        // Join the #pircbot channel.
        bot.joinChannel("#furby1987");
        bot.joinChannel("#furbybot");

    }
    
}
