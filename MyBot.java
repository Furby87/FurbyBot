package FurbyPackage;

import java.util.*;

import org.jibble.pircbot.*;

public class MyBot extends PircBot {
	
	public static String donateurl;
	public int rngNumber;
  	public Random randomint;
  	public String[] moderatoren = {"furby1987","furbybot"};
  	
//	 public String balluser1;
//	 public String balluser2;
	
	
	 public boolean WelcomeMessage;
	 	 
	 
	 Timer wmsgtimer = new Timer();
	 
	 
	 
    public MyBot() {
        this.setName("FurbyBot");
        WelcomeMessage = false;
        rngNumber = 0;
        randomint = new Random();
        
        
//		balluser1 = null
//		balluser2 = null
        
                
        
        welcomemessageactivator();
    }
        
// Start WelcomeMessageTimer
    
    public void welcomemessageactivator(){
    	
	    wmsgtimer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	
	        	WelcomeMessage = true;
	        	
// Kill Timer	        	
	        	wmsgtimer.cancel();
	        	wmsgtimer.purge();
	        	
	        	
	        }
	        
	        
	}, 10*1000, 10*1000);
}
    
    
// Custom Commands
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
    	    	
        if (message.equalsIgnoreCase("!time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
        
                
    	if (message.equalsIgnoreCase("!teamspeak")) {    		
    			sendMessage (channel, ":Join our Teamspeak at: www.FurbyTS.tk");   		
    	}
        
        if (message.equalsIgnoreCase("!ts")) {
        		sendMessage (channel, ":Besuche uns doch im Teamspeak unter: www.FurbyTS.tk oder klicke einfach auf: ts3server://www.furbyts.tk");
        }
        
        if (message.equalsIgnoreCase("!steam")) {
         		sendMessage (channel, ":Willst du mit Furby's Community zocken? Tritt doch einfach unserer Steamgruppe bei unter: http://steamcommunity.com/groups/furby87");       
    	}

    	if (message.equalsIgnoreCase("!fb")) {
    			sendMessage (channel, ":Du findest Furby auch auf Facebook: www.facebook.com/furbystream");
    	}
    	
    	if (message.equalsIgnoreCase("!facebook")) {
    			sendMessage (channel, ":Du findest Furby auch auf Facebook: www.facebook.com/furbystream");
       	}
    	
    	if (message.equalsIgnoreCase("!twitter")) {
    			sendMessage (channel, ":Furby ist auch auf Twitter: https://twitter.com/furby240487");
    	}
    	
    	if (message.equalsIgnoreCase("!donate")) {
    			sendMessage (channel, ":Du möchtest den Stream unterstützen und Spenden? dann klicke einfach auf: https://www.donation-tracker.com/u/furby");
 	
    	}
    	
    	if (message.equalsIgnoreCase("!donatecheck")) {

				try {
					DonatorChecker.main();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    		sendMessage(channel,"Furbys Link output: "+donateurl);
    	}
    	
//Fun-Commands
    	
    	if (message.equalsIgnoreCase("!chabo")) {
    			sendMessage(channel, sender + " ruft: Chabos wisse wer de Babo isch");
    	}
    	
    	if (message.equalsIgnoreCase("!highfiveme")) {
    			sendMessage(channel, " highfive "+sender+"!");
    	}
    	
    	
    	//////////////////////////////////
    	//         Blockergame          //
    	//////////////////////////////////
    	
    	if (message.equalsIgnoreCase("!testmeright")) {
    		if(randomNumber(2) == 0){
    			sendMessage(channel, sender + " BLOCK!");
       		}else{
       			sendMessage(channel, sender + " DEATH!");
       		}
    	}else if (message.equalsIgnoreCase("!testmeleft")) {
    		if(randomNumber(2) == 2){
    			sendMessage(channel, sender + " BLOCK!");   			
    		}else{
    			sendMessage(channel, sender + " DEATH!");
    		}
       	}else if (message.equalsIgnoreCase("!testmefront")) {
       		if(randomNumber(2) == 1){
       			sendMessage(channel, sender + " BLOCK!");
       		}else{
       			sendMessage(channel, sender + " DEATH!");
       		}
    	}
    	
    	
    	///////////////////////////////////////////////////
    	//////////  Spiel Ballwerfen by Yeroise  //////////
    	///////////////////////////////////////////////////
//    	
//    	if (message.equalsIgnoreCase("!ballspiel")) {
//				if(balluser1 == null){
//    			sendMessage(channel, sender + " sucht einen Mitspieler für das Ballspiel!");
//    			balluser1 = sender;
//    			}else{
//    			balluser2 = sender;
//    			BallGenerator(channel);
//    			}
//    	}
    	
    	
    	////////////////////////////////////////////
    	////          BEFEHLE (!CMD)            ////
    	///////////////////////////////////////////
    	
    	for(int i = 0; i < moderatoren.length; i++){    		
    		if (message.equalsIgnoreCase("!CMD")){
    			String senderholder = sender;
    			
    			if (senderholder.equals(moderatoren[i])){
		   			sendMessage (channel, "!time, !ts, !teamspeak, !steam, !fb, !facebook, !twitter, !donate, !chabo, !highfiveme, !testmeleft, !testmeright, !testmefront, !donatecheck");
	    		break;
    			}else{   			
		    		sendMessage(channel, "!time, !ts, !steam, !fb, !facebook, !twitter, !donate, !chabo, !highfiveme, !testmeleft, !tesmeright, !testmefront");
    			break;
    			}
    		}
    	}
    }
	    
    
    public int randomNumber(int range){
    	rngNumber = randomint.nextInt(range);
    	return rngNumber;
    	
    }
// WelcomeMessage  
    
    public void onJoin(String channel, String sender, String login, String hostname){
    	
 		if(WelcomeMessage){
 			sendMessage(channel,"Willkommen in unserem Channel,"+sender+"!! Viel Spass beim zuschauen!!");	
 		}
	}
}






