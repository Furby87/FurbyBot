package FurbyPackage;

import java.util.*;

import org.jibble.pircbot.*;



public class MyBot extends PircBot {	
static GUI currentGUI = new GUI();
	

	public static String donateurl;
	public static String donatetop5;
  	public Random randomint;
  	public String[] moderatoren = {"furby1987","furbybot"};	// Moderatoren
  	public int rngNumber;
  	public int randomhighfive;
  	public int coinflip;
  	public String user1;
  	public String user2;
    public int timedmsgcounter;				//load TimedMessageCounter
//	 public String balluser1;
//	 public String balluser2;		
	public boolean WelcomeMessage;	 		//load boolean for WelcomeMessage
	
	

	
	Timer wmsgtimer = new Timer();			//load WelcomeMessageTimer
	Timer msgtimer1 = new Timer();			//load MessageTimer
	
	
	
	
    public MyBot() {
    	currentGUI.ShowComponents();
        this.setName("FurbyBot");
        WelcomeMessage = false;
        rngNumber = 0;
        randomint = new Random();
        randomhighfive = 0;
        user1 = null;
        user1 = null;
        coinflip = 0;
        this.setMessageDelay(1800);        
        timedmsgcounter = 0;
//		balluser1 = null
//		balluser2 = null                                
        welcomemessageactivator();
        messagetimer();
    }
		////////////////////////////////
		////     Timed Messages     ////
		////////////////////////////////
    
    public void messagetimer(){    	
	    msgtimer1.scheduleAtFixedRate(new TimerTask() {
	        public void run() {       
	        switch (timedmsgcounter){
	        case 0: sendMessage ("#furby1987", "Hallo, ich bin Furbybot! Meine Befehle könnt ihr über !cmd abrufen <3");
	        	break;
	        case 1: sendMessage ("#furby1987", "Wenn dir der Stream gefällt und du den Channel unterstützen möchtest, kannst du ja den follow/Folgen Button anklicken! Vielen Dank <3");
	        	break;
	        case 2: sendMessage ("#furby1987", "Willst du mit Furby's Community zocken? Tritt doch einfach unserer Steamgruppe bei unter: http://steamcommunity.com/groups/furby87");
	        	break;
	        case 3: sendMessage ("#furby1987", "Ich befinde mich noch in der AlphaPhase und werde von Furby1987 entwickelt <3");
					sendMessage ("#furby1987", "für allfällige Tipps, Bugs oder Verbesserungsvorschläge einfach Twitchnachricht an Furby1987");
				break;
	        }
	        
	        timedmsgcounter = timedmsgcounter+1;   			
	        if (timedmsgcounter >= 3){
	        	timedmsgcounter = 0;	// Counter nach Durchgang auf 0 zurücksetzen
	        	}
	        }	        	        
	    }, 15*60*1000, 15*60*1000);		// Verzögerung Nachrichtenausgabe Default: 10*60*1000 = 10min
    }
    
    
    ///////////////////////////////////////////
    ////   Timer WelcomeMessageActivator   ////
    ///////////////////////////////////////////
    
    public void welcomemessageactivator(){    	
	    wmsgtimer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	WelcomeMessage = true;		// WelcomeMessage aktivieren
	        	wmsgtimer.cancel();	
	        	wmsgtimer.purge();	       	// Timer Killen
	        }	        	        
	    }, 18*1000, 18*1000);				// Zeit bis Aktivierung WelcomeMessage Default: 15*1000 = 15 Sekunden
    }  	
    
    ////////////////////////////////
    ////     WelcomeMessage     ////
    ////////////////////////////////
    public void onJoin(String channel, String sender, String login, String hostname){
    	
 		if(WelcomeMessage){
 			sendMessage(channel,"Willkommen in unserem Channel,"+sender+"!! Viel Spass beim zuschauen!!");	// Willkommensnachricht
 		}
	}



    public void onMessage(String channel, String sender,
    		String login, String hostname, String message) { 
    	
	    	///////////////////////////////////////////////
	    	///////									///////
	    	//   //      Simple Command Outputs     //   //
	    	///////									///////
	    	///////////////////////////////////////////////
    	
        if (message.equalsIgnoreCase("!time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        } 
    // 	Soziallinks und Teamspeak
    	if (message.equalsIgnoreCase("!teamspeak")) {    		
    			sendMessage (channel, ":Join our Teamspeak at: www.FurbyTS.tk");   		
    	}  
    	
        if (message.equalsIgnoreCase("!ts")) {
        		sendMessage (channel, ":Besuche uns doch im Teamspeak unter: www.FurbyTS.tk oder klicke einfach auf: ts3server://www.furbyts.tk");
        } 
        
        if (message.equalsIgnoreCase("!youtube")) {
    		sendMessage (channel, ": Furby hat auch einen eigenen Youtube-Channel: https://www.youtube.com/user/FurbCraft");
        }
        
        if (message.equalsIgnoreCase("!yt")) {
    		sendMessage (channel, ": Furby hat auch einen eigenen Youtube-Channel: https://www.youtube.com/user/FurbCraft");
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
    			sendMessage (channel, ": Furby ist auch auf Twitter: https://twitter.com/furby240487");
    	} 
    	if (message.equalsIgnoreCase("!battletag")) {
			sendMessage (channel, "Furbys's Battletag: Furby#2699 <3");
    	}
   	//	PartnerLinks
//    	if (message.equalsIgnoreCase("!mmoga")) {
//    			sendMessage (channel, "Du bestellst öfters über MMOGA und möchtest Furby mit deinen Einkäufen unterstützen? Dann nutz doch einfach unseren REF-Link!");
//    	}
//    	if (message.equalsIgnoreCase("!f2p")) {
//				sendMessage (channel, "Du bestellst öfters über Fast2Play und möchtest PestNation mit deinen Einkäufen unterstützen? Dann nutz doch einfach unseren REF-Link! http://www.fast2play.de/7en/pestxinf2pde");
//		}
//		if (message.equalsIgnoreCase("!fast2play")) {
//				sendMessage (channel, "Du bestellst über Fast2Play und möchtest PestNations's Channel mit deinen Einköufen unterstützen? Dann nutze doch einfach unseren Partnerlink: http://www.fast2play.de/7en/pestxinf2pde | vielen Dank");
//		}
    	if (message.equalsIgnoreCase("!randyrun")) {
    			sendMessage (channel, "Du bestellst über RandyRun und möchtest Furby's Channel mit deinen Einköufen unterstützen? Dann nutze doch einfach unseren Partnerlink: http://bit.ly/1g8nckF | vielen Dank");
    	}
    	if (message.equalsIgnoreCase("!amazon")) {
			sendMessage (channel, "Du bestellst über Amazon und möchtest Furby's Channel mit deinen Einkäufen unterstützen? Dann nutze doch einfach unseren Partnerlink: http://amzn.to/1fMWVxa");
    	}
    	if (message.equalsIgnoreCase("!ahrtos")) {
			sendMessage (channel, "Besuch doch auch unseren Sponsor: http://www.ahrtos.de/");
    	}
    	if (message.equalsIgnoreCase("!ahrtos-live")) {
			sendMessage (channel, "Hier findest du auch noch andere viele coole Streams: http://www.ahrtos-live.de/");
    	}
    	if (message.equalsIgnoreCase("!twitty")) {
			sendMessage (channel, "Besuch doch auch mal Twitty: http://www.twitty.de/");
    	}
    	if (message.equalsIgnoreCase("!germanonlinestreams")) {
			sendMessage (channel, "Du suchst noch andere coole, deutsche Streamer? http://germanonlinestreams.de/");
    	}
    	
    //	andere Befehle
    	if (message.equalsIgnoreCase("!donate")) {
    			sendMessage (channel, ": Du möchtest den Stream unterstützen und Spenden? dann klicke einfach auf: http://bit.ly/1dnHo4z");
    	}
    	
    	if (message.equalsIgnoreCase("!spenden")) {
    			sendMessage (channel, ":Möchtest du mich und den Channel unterstützen? Alle Spenden werden in neues Gear + Games sowie Giveaways und anderes für die Community und den Channel investiert. Spenden kannst du hier: http://bit.ly/1dnHo4z");
    	}
    	if (message.equalsIgnoreCase("!sub")) {
    			sendMessage (channel, ": Would you support me and the channel? All donations will be invested in new Gear + games and giveaways and other things for the community and the channel. You can donate here: http://bit.ly/1dnHo4z");
    			sendMessage (channel, ": Möchtest du mich und den Channel unterstützen? Alle Spenden werden in neues Gear + Games sowie Giveaways und anderes für die Community und den Channel investiert. Spenden kannst du hier : http://bit.ly/1dnHo4z");
    	}
    	if (message.equalsIgnoreCase("!follow")) {
    			sendMessage (channel, "If you're new to the stream and enjoy my show, please feel free to hit that follow button! <3");
    			sendMessage (channel, "Wenn dir der Stream gefällt und du den Channel unterstützen möchtest, kannst du ja den follow/Folgen Button anklicken! Vielen Dank <3");
    	}
    	if (message.equalsIgnoreCase("!bot")) {
			sendMessage (channel, "Ich befinde mich noch in der AlphaPhase und werde von Furby1987 entwickelt <3");
			sendMessage (channel, "für allfällige Tipps, Bugs oder Verbesserungsvorschläge einfach Twitchnachricht an Furby1987");
    	}
    	if (message.equalsIgnoreCase("!furbybot")) {
			sendMessage (channel, "Ich befinde mich noch in der AlphaPhase und werde von Furby1987 entwickelt <3");
			sendMessage (channel, "für allfällige Tipps, Bugs oder Verbesserungsvorschläge einfach Twitchnachricht an Furby1987");
    	}
    	
    	//////////////////////////////////////
    	///   //    Fun-Commandos     //   ///
    	//////////////////////////////////////
    	
    	if (message.equalsIgnoreCase("!chabo")) {
    			sendMessage(channel, sender + " ruft: Chabos wisse wer de Babo isch");
		}
		if (message.equalsIgnoreCase("!yellow")) {
				sendMessage(channel, "My english is not the yellow from the egg xD <3");
		}
		if (message.equalsIgnoreCase("!hearthtracker")) {
			sendMessage(channel, "https://www.dropbox.com/s/rj7kpkgpbuv6gke/HearthTracker-v1.2.1.rar <3");
		}
		if (message.equalsIgnoreCase("!reallife")) {
			sendMessage(channel, "http://www.real-life-link.de xD <3");
		}
    	
    	/////////////////////////////////
		////     DonaterAbfragen     ////
    	/////////////////////////////////
    	
		if (message.equalsIgnoreCase("!donatecheck")) {
				try {
					DonatorChecker.main();
				} catch (Exception e) {
					e.printStackTrace();				
					}
    		sendMessage(channel,"Link output: "+donateurl);
    		}  
	    	
    	if (message.equalsIgnoreCase("!top5")) {
				try {
					DonatorChecker.top5();
				} catch (Exception e) {
					e.printStackTrace();				
					}
    		sendMessage(channel,"Link output Top5 Donater: "+donatetop5);
    		}


			    	
			    ////////////////////////////////////////////
			   	////		ModeratorenBefehle			////
			   	////////////////////////////////////////////

    	if (message.equalsIgnoreCase("!highfivetest")) {
		    	List<String> moderatorenListe = Arrays.asList(moderatoren);
		    	if (moderatorenListe.contains(sender)) {
		    	    sendMessage (channel, "!highfive");
		    	} else {
		    	    sendMessage(channel, "Nur eingetragene Moderatoren haben Zugriff auf diesen Befehl. Sry <3");
		    	}
    	}
//    	if (message.startsWith("!op")) {
//    		List<String> moderatorenListe = Arrays.asList(moderatoren);
//    		if (moderatorenListe.contains(sender)) {
//    			try {
//    	    		String username = message.split(" ")[1];
//    	    		
//    	    			sendMessage(channel, "/mod"+username+"");
//    	    			sendMessage(channel, "Viewer "+username+" erfolgreich zum OP ernannt!");
//
//    	    		} catch (Exception e) {
//    	    	}
//    	}
    	
    	////////////////////////////////////////////
    	////          BEFEHLE (!CMD)            ////
    	////////////////////////////////////////////

    	if (message.equalsIgnoreCase("!cmd")) {
    			List<String> moderatorenListe = Arrays.asList(moderatoren);
    		if (moderatorenListe.contains(sender)) {
    				sendMessage (channel, "!time, !twitty, !furbybot, !reallife, !ts, !battletag, !teamspeak, !steam, !ahrtos, !fb, !facebook, !ahrtos-life, !hearthtracker, !lmgtfy [Suchbegriff], !google [Suchbegriff], !amazon, !twitter, !donate, !spenden, !chabo, !highfive, highfiveme!, !münzwurf, !testmeleft, !testmeright, !testmefront, !donatecheck, !top5, !bot, !bar");
    				sendMessage (channel, "Mod-Befehle: !highfivetest, !reconnect, /ban Username, /unban username");
    		} else {
    				sendMessage(channel, "!time, !ts, !twitty, !furbybot, !reallife, !teamspeak, !battletag, !ahrtos, !steam, !ahrtos-life, !hearthtracker, !fb, !facebook, !twitter, !amazon, !lmgtfy [Suchbegriff], !google [Suchbegriff], !donate, !spenden, !chabo, !highfive, highfiveme!, !münzwurf, !testmeleft, !tesmeright, !testmefront, !donatecheck, !top5, !bot, !bar");
    		}
    	}

    		//////////////////////////////////
    		//		Alte Funktion !CMD		//
    		//////////////////////////////////
//    	for(int i = 0; i < moderatoren.length; i++){    		
//    		if (message.equalsIgnoreCase("!CMD")){
//    			String senderholder = sender;
//
//    			if (senderholder.equals(moderatoren[i])){
//		   			sendMessage (channel, "!time, !ts, !teamspeak, !steam, !fb, !facebook, !twitter, !donate, !spenden, !chabo, !highfive, !highfiveme, !münzwurf, !testmeleft, !testmeright, !testmefront, !donatecheck, !top5,");
//		   			sendMessage (channel, "Mod-Befehle: !reconnect, /ban Username, /unban username");
//	    		break;
//    		}else{   			
//		    		sendMessage(channel, "!time, !ts, !teamspeak, !steam, !fb, !facebook, !twitter, !donate, !spenden, !chabo, !highfive, !highfiveme, !münzwurf, !testmeleft, !tesmeright, !testmefront, !donatecheck, !top5");
//    			break;
//    			}
//    		}
//    	}
    		////////////////////////////////////////////////////
    		////	  Partnerlinks Game Finder Query		////
    		////////////////////////////////////////////////////
    	
    	if (message.startsWith("!mmoga")) {
    		try {
    		String gamename = message.split("!mmoga ")[1];
    		String mmogalink = gamename.replaceAll("\\s","+");

    			sendMessage(channel, "http://www.mmoga.de/advanced_search.php?keywords="+mmogalink+"");
    	//		sendMessage(channel, "http://www.mmoga.de/advanced_search.php?keywords="+gamename+"&ref=0000");

    		} catch (Exception e) {
   		}
   	}
    	if (message.startsWith("!randyrun")) {
    		try {
    		String gamename = message.split("!randyrun ")[1];
    		String randyrunlink = gamename.replaceAll("\\s","+");

//    			sendMessage(channel, "http://www.randyrun.de/advanced_search_result.php?keywords="+randyrunlink+"");
    			sendMessage(channel, "http://www.randyrun.de/advanced_search_result.php?keywords="+randyrunlink+"&searchsubmit=?ref=148&affiliate_banner_id=23");

    		} catch (Exception e) {
    	}
    }
    	if (message.startsWith("!rr")) {
    		try {
    		String gamename = message.split("!rr ")[1];
    		String randyrunlink = gamename.replaceAll("\\s","+");

//    			sendMessage(channel, "http://www.randyrun.de/advanced_search_result.php?keywords="+randyrunlink+"");
    			sendMessage(channel, "http://www.randyrun.de/advanced_search_result.php?keywords="+randyrunlink+"&searchsubmit=?ref=148&affiliate_banner_id=23");

    		} catch (Exception e) {
    	}
    }

    	
//	Games  

		/////////////////////////////////
		////        Highfiver        ////
		/////////////////////////////////
		if (message.equalsIgnoreCase("highfiveme!")) {
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
		

		//////////////////////////////////
		//         Blockergame          //
		//////////////////////////////////
		if (message.equalsIgnoreCase("!"))
		
		
		if (message.equalsIgnoreCase("!testmeright")) {
			if(randomNumber(3) == 0){
				sendMessage(channel, sender + " BLOCK!");
				}else{
				sendMessage(channel, sender + " DEATH!");
				}
			}else 	
				
		if (message.equalsIgnoreCase("!testmeleft")) {
			if(randomNumber(3) == 2){
				sendMessage(channel, sender + " BLOCK!");   			
				}else{
				sendMessage(channel, sender + " DEATH!");
				}
			}else 
				
		if (message.equalsIgnoreCase("!testmefront")) {
			if(randomNumber(3) == 1){
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
			}else 
			
			if(coinflip >= 49 && coinflip <= 97){
				sendMessage(channel, sender + " wirft seine Münze und auf dem Boden liegt.... Kopf!");
			}else
			
			if(coinflip == 98){
				sendMessage(channel, sender + " wirft seine Münze und auf dem Boden liegt.... Die Münze auf dem Rand! UNGLAUBLICH!");
			}
		}
	
	////////////////////////////////
	////           Bar	        ////
	////////////////////////////////
		if (message.equalsIgnoreCase("!bar")) {
			List<String> moderatorenListe = Arrays.asList(moderatoren);
		if (moderatorenListe.contains(sender)) {
				sendMessage(channel, "/me reicht "+sender+" mit einem freundlichen lächeln die Getränkeliste:");
				sendMessage(channel, " -!bier, -!cola, -!milch, -!limonade, -!wodka, -!met, -!absinth | ModCommands: !keller");
		} else {
				sendMessage(channel, "/me reicht "+sender+" mit einem freundlichen lächeln die Getränkeliste:");
				sendMessage(channel, " -!bier, -!cola, -!milch, -!limonade, -!wodka, -!met, -!absinth");
		}
	}		
		//	Keller
		if (message.equalsIgnoreCase("!keller")) {
			List<String> moderatorenListe = Arrays.asList(moderatoren);
		if (moderatorenListe.contains(sender)) {
				sendMessage(channel, "/me verlässt die Bar und geht, auf Anweisung von "+sender+", in den Keller neue Getränke holen... Bis Gleich! ");
				sendMessage(channel, " -!bier, -!cola, -!milch, -!limonade, -!wodka, -!met, -!absinth | ModCommands: !keller");
		} /* else {
				sendMessage(channel, "/me reicht "+sender+" mit einem freundlichen lächeln die Getränkeliste:");
				sendMessage(channel, " -!bier, -!cola, -!milch, -!limonade, -!wodka, -!met, -!absinth");
			} */
		}
	
	
			////////////////////////
			////	Getränke	////
			////////////////////////
	
		if (message.equalsIgnoreCase("!bier")) {
				sendMessage(channel, "/me reicht "+sender+" ein kühles Bier."+sender+" setzt die Flasche an, trinkt sie leer und wirft einen lauten Rülpser durch die Runde! PROST!");
		}
		if (message.equalsIgnoreCase("!cola")) {
				sendMessage(channel, "/me hohlt aus dem Kühlschrank eine kühle Dose CocaCola und reicht sie "+sender+", der es genussvoll trinkt. Plötzlich beginnt "+sender+"s Magen zu rumoren... Dä hätte "+sender+" wohl vorher besser keine Mentos geschluckt Kappa");
		}
		if (message.equalsIgnoreCase("!milch")) {
				sendMessage(channel, "sry "+sender+", noch keine Nachricht fetsgelegt. "+sender+"s Antwort: MUUUH! xD");
		}
		if (message.equalsIgnoreCase("!limonade")) {
				sendMessage(channel, "sry "+sender+", noch keine Nachricht fetsgelegt.");
		}
		if (message.equalsIgnoreCase("!wodka")) {
				sendMessage(channel, "/me reicht "+sender+" ein Glas russischen Wodka. Nastrovje "+sender+" Kappa");
		}
		if (message.equalsIgnoreCase("!met")) {
				sendMessage(channel, "sry "+sender+", noch keine Nachricht fetsgelegt.");
		}
		if (message.equalsIgnoreCase("!absinth")) {
				sendMessage(channel, "sry "+sender+", noch keine Nachricht fetsgelegt.");
		}
	
	///////////////////////////////////////////////////
	//////////  Spiel Ballwerfen by Yeroise  //////////
	///////////////////////////////////////////////////

//		if (message.equalsIgnoreCase("!ballspiel")) {
//			if(balluser1 == null){
//				sendMessage(channel, sender + " sucht einen Mitspieler für das Ballspiel!");
//			balluser1 = sender;
//		}else{
//			balluser2 = sender;
//		BallGenerator(channel);
//			}
//		}
	
}

    
    
    
    
    
     
    public int randomNumber(int range){
   		rngNumber = randomint.nextInt(range);
   		return rngNumber;
    	}
    ///////////////////////////////////
    ////     HighFiveGenerator     ////
    ///////////////////////////////////
    
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
		case 7: sendMessage(channel, user2+" streckt seine Hand aus für einen Highfive."+user1+" bemerkt dies und zögert zuerst, weil er sich fragt: Warum liegt hier überhaupt Stroh rum!");
			break;
    	}
    	user1 = null;
    	user2 = null;
    }

    
    
    
    
    
    
    
    
    @SuppressWarnings("static-access")
	@Override
    public void log(String line) {
         currentGUI.ChatLog.append(line + "\n");
         currentGUI.ChatLog.setCaretPosition(currentGUI.ChatLog.getText().length());
    }
}
