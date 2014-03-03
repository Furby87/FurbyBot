package FurbyPackage;

import java.util.*;
import org.jibble.pircbot.*;

public class MyBot extends PircBot {
	
//	static GUI currentGUI = new GUI();	
	public static String donateurl;
	public static String donatetop5;
  	public Random randomint;
  	public String[] moderatoren = {"furby1987","furbybot"};	// Moderatoren
  	public int rngNumber;
  	public int randomhighfive;
  	public int coinflip;
  	public String user1;
  	public String user2;
  	    	
//	 public String balluser1;
//	 public String balluser2;
		
	 public boolean WelcomeMessage;	 		//load boolean for WelcomeMessage
	 Timer wmsgtimer = new Timer();			//load WelcomeMessageTimer
	 	 	 
    public MyBot() {
//    	currentGUI.ShowComponents();
        this.setName("FurbyBot");
        WelcomeMessage = false;
        rngNumber = 0;
        randomint = new Random();
        randomhighfive = 0;
        user1 = null;
        user1 = null;
        coinflip = 0;
        this.setMessageDelay(1800);                        
//		balluser1 = null
//		balluser2 = null                                
        welcomemessageactivator();
    }
        
// Start WelcomeMessageTimer    
    public void welcomemessageactivator(){    	
	    wmsgtimer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	
	        	WelcomeMessage = true;	        	
//	Kill WelcomeMessageTimer	//
	        	wmsgtimer.cancel();	
	        	wmsgtimer.purge();	        		        	
	        }	        	        
	    }, 10*1000, 10*1000);
    }
	//////////////////////        
	// Custom Commands  //
	//////////////////////    
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
    	if (message.equalsIgnoreCase("!spenden")) {
    			sendMessage (channel, ":Möchtest du mich und den Channel unterstützen? Alle Spenden werden in neues Gear + Games sowie Giveaways und anderes für die Community und den Channel investiert. Spenden kannst du hier: https://www.donation-tracker.com/u/furby");
    	}
    	if (message.equalsIgnoreCase("!follow")) {
    			sendMessage (channel, "If you're new to the stream and enjoy my show, please feel free to hit that follow button! <3");
    			sendMessage (channel, "Wenn dir der Stream gefällt und du den Channel unterstützen möchtest, kannst du ja den follow/Folgen Button anklicken! Vielen Dank <3");
    	}
    	
    	
    	
    	
//    	// Donatecheck Befehle    	
//    	if (message.equalsIgnoreCase("!donatecheck")) {
//				try {
//					DonatorChecker.main();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();				}
//    		sendMessage(channel,"Link output: "+donateurl);
//    	}    	
//    	if (message.equalsIgnoreCase("!top5")) {
//				try {
//					DonatorChecker.top5();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();				}
//    		sendMessage(channel,"Link output Top5 Donater: "+donatetop5);
//    	}
  	
    	
    	
// Fun-Commands
    	
    	if (message.equalsIgnoreCase("!chabo")) {
    			sendMessage(channel, sender + " ruft: Chabos wisse wer de Babo isch");
    	}
    	if (message.equalsIgnoreCase("!yellow")) {
    			sendMessage(channel, "My english is not the yellow from the egg xD <3");
    	}
    	
    		/////////////////////////////////
    		////        Highfiver        ////
    		/////////////////////////////////
    	if (message.equalsIgnoreCase("!highfiveme")) {
    			sendMessage(channel, " !highfive "+sender+"!");
    	}
    	
    	if (message.equalsIgnoreCase("!highfive")) {
    		if(user1 == null){
    			user1 = sender;
    		}else{
    			user2 = sender;	
    			highfiveGenerator(channel);    			
    			}
    	}
    	if (message.equalsIgnoreCase("!highfivetest")) {
    		sendMessage(channel, "!highfive");
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
    	
        //////////////////////////////////////////////////
        //  //              Münzwurf                //  //
        //////////////////////////////////////////////////
        if (message.equalsIgnoreCase("!münzwurf")) {
        	coinflip = randomNumber(99);
        	if(coinflip <= 48){
        		sendMessage(channel, sender + " wirft seine Münze und auf dem Boden liegt.... Zahl!");
        	}else if(coinflip >= 49 && coinflip <= 97){
        		sendMessage(channel, sender + " wirft seine Münze und auf dem Boden liegt.... Kopf!");
        	}else if(coinflip == 98){
        		sendMessage(channel, sender + " wirft seine Münze und auf dem Boden liegt.... Die Münze auf dem Rand! UNGLAUBLICH!");
        	}
        }
    	
    	///////////////////////////////////////////////////
    	//////////  Spiel Ballwerfen by Yeroise  //////////
    	///////////////////////////////////////////////////
    	
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
		   			sendMessage (channel, "!time, !ts, !teamspeak, !steam, !fb, !facebook, !twitter, !donate, !spenden, !chabo, !highfive, !highfiveme, !münzwurf, !testmeleft, !testmeright, !testmefront, !donatecheck, !top5");
	    		break;
    			}else{   			
		    		sendMessage(channel, "!time, !ts, !teamspeak, !steam, !fb, !facebook, !twitter, !donate, !spenden, !chabo, !highfive, !highfiveme, !münzwurf, !testmeleft, !tesmeright, !testmefront, !donatecheck, !top5");
    			break;
    			}
    		}
    	}
    }
	    
    
    public int randomNumber(int range){
    	rngNumber = randomint.nextInt(range);
    	return rngNumber;
    	
    }
    
    // HighfiveGenerator
    
    public void highfiveGenerator (String channel){
    	randomhighfive = randomNumber(8);
    	switch(randomhighfive){
    	case 0: sendMessage(channel, user2+" nähert sich in einem, mit sich langsam erhebender Hand und feshen Bewegungsstil "+user1+", der daraufhin gelassen zum Highfive ansetzt. Kashizzle! Cool five!");
	   		break;
	   	case 1: sendMessage(channel, user2+" lässt es sich nicht nehmen und marschiert geradewegs auf "+user1+" zu um dann einen sehr stilvollen Highfive zu praktizieren. Echt stark!");
	       	break;
	   	case 2: sendMessage(channel, user2+" pfeift "+user1+" hinterher welcher sich kurz darauf umdrehte. Ein Blick sprach Bände. Beide liefen in einer Film-reifen Slowmotion einander entgegen und vollzogen einen traumhaften Handschlag. WoW Echt Toll!");
	   		break;
	   	case 3: sendMessage(channel, user2+" bemerkt "+user1+" in der Schulklasse wie dieser aufdringlich die Hand hebt um eine Frage zu stellen."+user2+" lässt es sich nicht nehmen und steht auf, springt über die Schul-pulte und schlägt mit einer enormen Kraft zum High-Five zu. Das werden die beiden bestimmt morgen noch spüren, Autschi.");
		   	break;
	   	case 4: sendMessage(channel, user1+" Erblickt freudig "+user2+" in Hoffnung dass dieser mit Ihm einen traditionellen Highfive praktiziert. "+user2+" hingegen ruft "+user1+" spöttisch hinterher - Sorry, ich bin zu Cool für den Kram!");
			break;
	   	case 5: sendMessage(channel, user2+" ergreift die Chance für einen Highfive und rennt fokussiert richtung "+user1+" um mit diesem den Highfive zu vollziehen. Leider bemerkte "+user2+" zu spät dass der Schnürsenkel von dessen Schuhs sich gelöst hatte was darin resultiert dass "+user2+" sich übelst auf die Schnauze legt. Schade, dass "+user1+" nun keinen Highfiver erhält.");
	   		break;
		case 6: sendMessage(channel, user2+" strotzt voller Liebe und würde nichts lieber tun als die ganze Welt zu umarmen. Da dies aber nicht geht muss der sich in der nähe befindende "+user1+" her halten dachte er sich. "+user2+" läuft mit offenen Armen auf "+user1+" zu und erkennt aus der ferne dass dieser die Hand hebt um gegebenenfalls einen Highfive zu vollziehen. Leider war dies eine Fehlinterpretation und "+user1+" ballte in Wirklichkeit die Faust um "+user2+" eine reinzuhaün weil dessen Liebesgefühle Ihm auf die Nerven gingen. Aua.");
			break;
		case 7: sendMessage(channel, user2+"streckt seine Hand aus für einen Highfive."+user1+" bemerkt dies und zögert zuerst, weil er sich fragt: Warum liegt hier überhaupt Stroh rum!");
			break;
    	}
    	user1 = null;
    	user2 = null;
    }
// WelcomeMessage  
    
    public void onJoin(String channel, String sender, String login, String hostname){
    	
 		if(WelcomeMessage){
 			sendMessage(channel,"Willkommen in unserem Channel,"+sender+"!! Viel Spass beim zuschauen!!");	// Willkommensnachricht
 		}
	}
    
    
//    @Override
//    public void log(String line) {
//         currentGUI.ChatLog.append(line + "\n");
//         currentGUI.ChatLog.setCaretPosition(currentGUI.ChatLog.getText().length());
//    }
}






