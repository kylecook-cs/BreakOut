package com.skillstorm.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scene { // scenes object

	static Scanner in = new Scanner(System.in); // Scanner object that this class can use
	public Scene () {}
	// this method is where game really begins and creates the user's player object
	public static Player admin() {
		String username; // holds user's input for name
		int securityLevel; // holds user's input from player's security level
		ArrayList<String> starterInventory = new ArrayList<String>(); // creates an initial player's inventory ArrayList 
		starterInventory.add("toothbrush"); // add toothbrush to inventory
		Player user; // declare a player object
		int mode;
		do {
			try {
				println("\nThere are 3 difficulty levels -");
				println("Easy (1) / Medium (2) / Hard (3)");
				print("Please enter a difficulty level (1 / 2 / 3 ): ");
				mode = in.nextInt();
			} catch(InputMismatchException e) {
				mode = 5;
				in.nextLine();
			}
		} while (mode != 1 && mode != 2 && mode != 3 );
		if (mode == 1 ) {
			println("You have choosen easy mode");
		} else if (mode == 2) {
			println("You have choosen medium mode");
		} else {
			println("You have choosen hard mode");
		}

		// beginning of Admin Scene

		println("\n***** ADMIN *****");
		println("ADMIN: Welcome to the Java State Prison.");
		println("ADMIN: This is the processing unit, I will need just a couple pieces of information from you.");
		do {
			print("\nADMIN: May I have your name?: "); // prompt user for name
			username = in.next();

		} while (username.trim().equals("")); // checks if user entered any input
		do {
			println("\nADMIN: Thank you, Prisoner " + username); // username was accepted
			try {
				print("\nADMIN: Now can you tell me what your security level is "
						+ "(1: minimum, 2: average, 3: maximum): "); // prompt user for their player's security level
				securityLevel = in.nextInt();
			} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
				securityLevel = 100;
				in.nextLine();
			}
		} while (securityLevel != 1 && securityLevel != 2 && securityLevel != 3);
		// security level was accepted
		if (securityLevel == 1) { // if security level == 1
			if (mode == 1) {
				println("\nADMIN: Level 1 security... Hmmmm interesting, you must have just forgot a ; somewhere,"
						+ "\n\tso I'll put in your file that you fall under the weak catergory.\n");
				user = new Player(username, securityLevel, 7, 2, 5, starterInventory, 1); // create weak player on easy
				println(user); // display player stats
			} else if (mode == 2) {
				println("\nADMIN: Level 1 security... Hmmmm interesting, you must have just forgot a ; somewhere,"
						+ "\n\tso I'll put in your file that you fall under the weak catergory.\n");
				user = new Player(username, securityLevel, 5, 2, 5, starterInventory, 2); // create weak player on medium
				println(user); // display player stats
			} else {
				println("\nADMIN: Level 1 security... Hmmmm interesting, you must have just forgot a ; somewhere,"
						+ "\n\tso I'll put in your file that you fall under the weak catergory.\n");
				user = new Player(username, securityLevel, 3, 2, 5, starterInventory, 3); // create weak player on hard 
				println(user); // display player stats
			}
		} else if (securityLevel == 2) { // if security level == 2
			if (mode == 1) {
				println("\nADMIN: Level 2 security you say, you must have used the wrong data type? I'll be sure to note that.\n");
				user = new Player(username, securityLevel, 8, 3, 3, starterInventory, 1);	// create average player on easy
				println(user); // display player stats
			} else if (mode == 2) {
				println("\nADMIN: Level 2 security you say, you must have used the wrong data type? I'll be sure to note that.\n");
				user = new Player(username, securityLevel, 6, 3, 3, starterInventory, 2);	// create average player on medium
				println(user); // display player stats
			} else {
				println("\nADMIN: Level 2 security you say, you must have used the wrong data type? I'll be sure to note that.\n");
				user = new Player(username, securityLevel, 4, 3, 3, starterInventory, 3);	// create average player on hard
				println(user); // display player stats
			}
		} else { // if security level == 3
			if (mode == 1) {
				println("\nADMIN: Level 3 Yikeees! You must be an infinite looper! Remind me to stay out of your code...\n");
				user = new Player(username, securityLevel, 10, 5, 1, starterInventory, 1); // create strong player on easy
				println(user); // display player stats
			} else if (mode == 2) {
				println("\nADMIN: Level 3 Yikeees! You must be an infinite looper! Remind me to stay out of your code...\n");
				user = new Player(username, securityLevel, 7, 5, 1, starterInventory, 2); // create strong player on medium
				println(user); // display player stats
			} else {
				println("\nADMIN: Level 3 Yikeees! You must be an infinite looper! Remind me to stay out of your code...\n");
				user = new Player(username, securityLevel, 4, 5, 1, starterInventory, 3); // create strong player on hard
				println(user); // display player stats
			}
		}
		println("ADMIN: Processing is now complete. Enjoy your stay Prisoner " + user.getName());
		println("\nDay1 Night1....\n Day2 Night2....\n  Day3 Night3....\n");
		println("After spending 3 days in the Java State Prison, you realize this isn't the place for you");
		println("Of course you believe you shouldn't be there in the first place, "
				+ "since \"we all know your innocent\". \nBut you understand you only have one real option"
				+ " to get out, and that's to BREAKOUT. \nYou decide tomorrow will be the day you'll escape"
				+ " from the Java State Prison.");

		println("\n********** NEXT DAY **********");
		return user; // returns the user's new player and exits admin scene
	}
	// cell scene
	public boolean cell(Player user){
		int answer = 0; // initialize user's answer for prompts in this scene

		println("\n**** CELL ****"); // beginning of cell scene
		println(user); // display player stats
		println("You find yourself in your cell contemplating on what your next move should be.");
		println("This cell reminds of you of every reason why you don't want to be here.");
		do { 
			try {
				println("\nYou can't waste any more time! You decide that you will:");
				println("1: You look around your cell");
				println("2: You exit the cell" );
				println("3: You try to escape the prison");
				print("Please enter the corresponding number (1 / 2 / 3): "); // prompt user for answer
				answer = in.nextInt();
			} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
				answer = 100;
				in.nextLine();
			}
		} while(answer != 1 && answer != 2 && answer != 3); 
		// user prompt was accepted
		if (answer == 1) { // if answer == 1 look around the cell
			println("\nYou start searching around your cell.");
			println("You're not having any luck when you see a weird discoloration on the wall.");
			println("It appears to be a false brick so you take your standard issued toothbrush\n"
					+ "and begin to brush away the dust from the fake brick. It starts to crumble as\n"
					+ "you do so. Then your cell mate comes rushing in, yelling about what you are doing.");
			println("\nYou can't bring attention to the situation! You decide the best solution is to");
			println("fight your cell mate to keep him quiet.");
			println("\nYou and your cell mate start to throw down!!!");
			if (user.getSecurityLevel() == 3) { // checks security level and reacts accordingly
				println("Before the fight you cell mate remembers you are a level 3 inmate!");
				println("They cower in front of you and willingly grab the fake brick revealing it's contents");
				println("It's a grappling hook that they were planning to use in their own escape.");
				println("Grappling hook now added to your inventory.");
				user.setInventory(user.getInventory(), "grappling hook"); // add grappling hook to inventory
				println(user); // display player stats
				println("It's time to leave the cell.");
			} else if (user.getSecurityLevel() == 2) {
				println("After a back and forth battle you end up winning the fight but you took some damage.");
				println("Lumps... Health - 1");
				user.setHealthPoints(user.getHealthPoints()-1); // health damage
				if (!checkHealth(user)) { // check if user has enough health to continue
					return false; // returns false, game ends
				}
				println("Your cell mate has gained respect for you and decides to give you the contents inside"
						+ "\nof the fake brick. ");
				println("It's a grappling hook that they were planning to use in their own escape.");
				println("Grappling hook now added to your inventory.");
				user.setInventory(user.getInventory(), "grappling hook"); // add grappling hook to inventory
				println(user); // display player stats
				println("Now you continue on with the rest of your plan.");
			} else {
				println("The word got around the prison that you were soft.");
				println("You end up getting beat up pretty badly, your cell mate kicks you out of the cell.");
				println("Bad Idea... Health - 2");
				user.setHealthPoints(user.getHealthPoints()-3); // health damage
				if (!checkHealth(user)) { // check if user has enough health to continue
					return false; // returns false, game ends
				}
			}
		} else if (answer == 2) {
			println("You leave you cell."); // next
		} else {
			return escape(user); // user chose to escape, returns if successful or not
		}
		return true; // return true to continue game
	}
	// kitchen scene
	public boolean kitchen(Player user) {
		int answer = 0; // initialize user's answer for prompts in this scene
		println("\n**** Kitchen ****");
		println(user); // display user stats
		println("You are in the kitchen. This room does not have much to offer since everything is either tethered down or \n"
				+ "too heavy to carry on your person.\n");	
		do { 
			try {
				println("\nYou decide to: ");
				println("1: look around anyways");
				println("2: leave the kitchen");
				println("3: you try to escape the prison");
				print("Please enter the corresponding number (1 / 2 / 3): ");  // prompt user for answer
				answer = in.nextInt();
			} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
				answer = 100;
				in.nextLine();
			}
		} while(answer != 1 && answer != 2 && answer!= 3);
		// user prompt was accepted
		if (answer == 1) {
			println("\nWhile searching around the kitchen, you find a snack and decide to eat it to get some more energy.");
			println("Eating... Health + 1");
			user.setHealthPoints(user.getHealthPoints()+1); // health increase
			println(user); // display user stats
			if (user.getGameMode() == 1) { // if game mode is easy then users will get certain inventory item
				println("You notice a box behind the drawer the snack was in. You take it out and look inside");
				if (user.getSecurityLevel() == 1) {
					println("You have found a grappling hook!");
					println("A grappling hook was added to your inventory.");
					user.setInventory(user.getInventory(), "grappling hook");
					println(user);
				} else if (user.getSecurityLevel() == 2) {
					if(!user.getInventory().contains("sheets")) {
						println("You have found some sheets!");
						println("Some sheets were added to your inventory.");
						user.setInventory(user.getInventory(), "sheets");
						println(user);
					} else {
						println("The box was empty");
					}
				} else {
					println("You have found a disguise!");
					println("A disguise was added to your inventory.");
					user.setInventory(user.getInventory(), "disguise");
					println(user);
				}
			}
			println("There's nothing else here so you leave the kitchen");
		} else if (answer == 2){
			println("Leaving the kitchen");
		} else {
			return escape(user); // user chose to escape, returns if successful or not
		}
		return true; // return true to continue game
	}
	// dayroom scene
	public boolean dayroom(Player user) {
		int answer = 0; // initialize user's answer for prompts in this scene
		println("\n**** Dayroom ****");
		println(user);
		println("You find yourself in the Dayroom.");
		println("Just a bunch of tvs and tables around. Some other inmates are located in different parts"
				+ " of this room. \nBest to be quiet and not let too many know of your plan.");
		do { 
			try {
				println("\nAfter analyzing your options, you decide that you will:");
				println("1: You decide to talk to another inmate");
				println("2: You exit the dayroom" );
				println("3: You try to escape the prison");
				print("Please enter the corresponding number (1 / 2 / 3): ");  // prompt user for answer
				answer = in.nextInt();
			} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
				answer = 100;
				in.nextLine();
			}
		} while(answer != 1 && answer != 2 && answer != 3);
		// user prompt was accepted
		if (answer == 1) {
			println("\nYou begin conversating with another inmate...");
			println("They tell you they work in maintenance, and stashed a electrician outfit they found.");
			println("A light bulb goes off and you realize its the perfect disguise for you.");
			do { 
				try {
					println("\nIn the least suspicious way you");
					println("1: inform them of your plan and ask them for it");
					println("2: don't share your plans and leave the conversation" );
					print("Please enter the corresponding number (1 / 2): "); // prompt user for answer
					answer = in.nextInt();
				} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
					answer = 100;
					in.nextLine();
				}
			} while(answer != 1 && answer != 2);
			// user prompt was accepted
			if (answer == 1) {
				println("\nYou talk to them about what your intentions are."); // uses intelligence level to gauge result
				if (user.getIntellegence() == 5) {
					println("They realize how smart you are. The inmate makes a deal with you that they will give\n"
							+ "you the uniform in exchange of you helping them beat their case when you get free.");
					println("A disguise was added to your inventory.");
					user.setInventory(user.getInventory(), "disguise"); // add disguise to inventory
					println(user); // display player stats
					println("It's time to leave the dayroom.");
				} else if (user.getIntellegence() == 3) {
					println("The inmate decides they don't know whether to trust you or not\n"
							+ "so in order to receieve the diguise you must trade for it.");
					if (user.getInventory().contains("sheets")) {
						user.getInventory().remove("sheets"); // trade sheets, inventory updated
						println("You traded your sheets for the uniform..");
						println("A disguise was added to your inventory.");
						user.setInventory(user.getInventory(), "disguise");
						println(user); // display player stats
					} else {
						user.getInventory().remove("toothbrush"); // trade toothbrush, inventory updated
						println("You traded away your toothbrush");
						println("A disguise was added to your inventory.");
						user.setInventory(user.getInventory(), "disguise"); // add disguise to inventory
						println(user); // display player stats
					}
					println("It's time to leave the dayroom");
				} else {
					println("Everyone knows what level inmate you are");
					println("The inmate figures you are not the brightest so they can't trust you. ");
					println("They tell you no you can't have it. This makes you incredibly angry. You grab\n"
							+ "the inmate by the collar but before you can harm them a correctional officer\n"
							+ "peppersprays the both of you. This stings your eyes and you release him.\n");
					println("Spicy.. Health - 2");
					user.setHealthPoints(user.getHealthPoints()-2); // health damage
					if (!checkHealth(user)) { // check if user has enough health to continue
						return false; // returns false, game ends
					}
					println("The C.O. tells you to scram so you do.");
				}
			} else {
				println("\nYou walk away from the inmate and leave the dayroom."); // next
			}
		} else if (answer == 2) {
			println("\nYou are leaving the dayroom"); // next
		} else {
			return escape(user); // user chose to escape, returns if successful or not
		}
		return true; // return true to continue game
	}
	// laundry scene
	public boolean laundry(Player user) {
		int answer = 0;
		println("\n**** Laundry Room ****");
		println(user);
		println("You are now in the Laundry Room.");
		println("The room is just full of washers and dryers.\n");
		do { 
			try {
				println("\nYou've always hated doing your own laundry so\n"
						+ "you want to get out of here as fast as possible,\nyou decide that you will:");
				println("1: Explore the laundry room");
				println("2: You exit the laundry room" );
				println("3: You try to escape the prison");
				print("Please entering the corresponding number (1 / 2 / 3): ");  // prompt user for answer
				answer = in.nextInt();
			} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
				answer = 100;
				in.nextLine();
			}
		} while(answer != 1 && answer != 2 && answer != 3);
		// user prompt was accepted
		if (answer == 1) {
			println("\nYou began going through all the washers and dryers to see what you can find.");
			println("They all seem to be empty so no luck getting what you need here.");
			println("You realize there is a dryer pushed up against a utility closet door.");
			do { 
				try {
					println("\nYou decide to");
					println("1: push the dryer out of the way");
					println("2: ignore the door" );
					print("Please enter the corresponding number (1 / 2): ");  // prompt user for answer
					answer = in.nextInt();
				} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
					answer = 100;
					in.nextLine();
				}
			} while(answer != 1 && answer != 2);
			// user prompt was accepted
			if (answer == 1) {
				println("\nYou begin to push the dryer out of the way"); // strength level is used to gauge result
				if (user.getStrength() == 2) {
					println("You must of forgot that you are a weakling. You push with all your\n"
							+ "might but the dryer doesn't budge at all. You end of slipping and hurting your hand.");
					println("Ouch.. Health - 1");
					user.setHealthPoints(user.getHealthPoints()-1); // health damage
					println(user); // display player stats
					if (!checkHealth(user)) { // check if user has enough health to continue
						return false; // returns false, game ends
					}
					println("While on the ground grasping at your hand, another inmate walks in and tells you to get"
							+ " up \nand wash their sheets, they'll be back in 1 hour. ");
					println("Sheets added to your inventory");
					user.setInventory(user.getInventory(), "sheets"); // add sheets to inventory
					println(user); // display player stats
					println("It's time to leave the laundry room before they're back.");
				} else if (user.getStrength() == 3) {
					println("You push and push but you can't move the dryer. You realize "
							+ "\nit is not worth the energy to keep trying so you just leave.");
				} else {
					println("You push the dryer out of the way with ease");
					println("You open up the door to find sheets inside");
					println("Sheets added to your inventory");
					user.setInventory(user.getInventory(), "sheets"); // add sheets to inventory
					println(user); // display player stats
					println("You leave the laundry room since there is nothing else for you in here.");
				}
			} else {
				println("You leave the laundry room."); // next
			}	
		} else if (answer == 2) {
			println("You are leaving the laundry room"); // next
		} else {
			return escape(user); // user chose to escape, returns if successful or not
		}
		return true; // return true to continue game
	}
	// yard scene
	public boolean yard(Player user) {
		int answer = 0; // initialize user's answer for prompts in this scene
		println("\n**** The Yard ****");
		println(user);
		println("You are now in the Yard.");
		println("It's not time to enjoy the outdoors tho, you can do that when you're free!\n");
		println("The yard is full of areas for different activites and other inmates.");
		do { 
			try {
				println("1: Explore the basktball courts");
				println("2: Look around the gym equipment" );
				println("3: Talk to other inmates");
				println("4: Leave the yard");
				println("5: You try to escape the prison");
				print("Please entering the corresponding number (1 / 2 / 3 / 4 / 5): ");  // prompt user for answer
				answer = in.nextInt();
			} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
				answer = 100;
				in.nextLine();
			}
		} while(answer != 1 && answer != 2 && answer != 3 && answer != 4 && answer != 5);
		// user prompt was accepted
		if (answer == 1) {
			println("\nIt's not time to hoop. There's nothing here");
			yard(user);

		} else if (answer == 2) {
			println("\nThe gym has a lot of potentially good escape items.");
			println("You are weighing the potential of each item you come across..");
			println("weights.. um no");
			println("barbells.. um no help...");
			println("what's this ... a rope");
			println("Now a rope would make for a greate escape item.");
			println("Another inmate approaches you.");
			println("OTHER INMATE: Hey I wanted to use that. Give it here.\n");
			do { 
				try {
					if (!user.getInventory().contains("rope")) { // checks if you already have a rope
						println("\nYou have to decide whether you");
						println("1: stand your ground");
						println("2: give up the rope" );
						print("Please entering the corresponding number (1 / 2 ): ");  // prompt user for answer
						answer = in.nextInt();
					} else {
						println("You already have a rope.");
						answer = 2;
					}
				} catch(InputMismatchException e) { // catch exception if user did not enter correct prompt format
					answer = 100;
					in.nextLine();
				}
			} while(answer != 1 && answer != 2);
			// user prompt was accepted
			if (answer == 1) {
				if (user.getSecurityLevel() == 1) {
					println("\nYou try to stand your ground but its no use, the other inmate punks you,\n"
							+ "takes the rope and yanks it out of your hand.");
					println("Rope burn... Health - 1");
					user.setHealthPoints(user.getHealthPoints()-1); // health damage
					if (!checkHealth(user)) { // check if user has enough health to continue
						return false; // returns false, game ends
					}
					yard(user); // go back to beginning of yard scene
				} else if (user.getSecurityLevel() == 2) {
					println("\nIt is the smartest idea to fight in the yard?");
					println("It's not worth your time so you leave the gym area without the rope.\n");
					yard(user);	// go back to beginning of yard scene
				} else {
					println("\nOTHER INMATE: (cowers in fear) Oh I am so sorry, I didnt realize that was you.\n"
							+ "I don't need the rope after all.");
					println("A rope was added to your inventory");
					user.setInventory(user.getInventory(), "rope");
					println(user); // display player stats
				}
			} else if (answer == 2) {
				println("It's not worth your time so you leave the gym area");
				yard(user); // go back to beginning of yard scene
			}		
		} else if (answer == 3) {
			println("\nYou talk to inmates about your plan. They decide to help and give you a rope.");
			if (user.getInventory().contains("rope")) { // checks if user already has rope in inventory
				println("OTHER INMATE: No need to be stingy you already have one, give ours back.");
			} else {
				println("A rope was added to your inventory");
				user.setInventory(user.getInventory(), "rope"); // rope added to inventory
				println(user); // display player stats
			}
		} else if (answer == 4) {
			println("You are now leaving the yard"); // next
		} else {
			return escape(user); // user chose to escape, returns if successful or not
		}
		return true; // return true to continue game
	}
	// escape method to check if user successfully escapes 
	public boolean escape(Player user) {
		println("\n**** ESCAPE ****");
		println("\nThe guards seem to be busy and distracted. You see the opening you have been waiting for."
				+ "\nYou make your way outside and notice that the electric fence is off. You approach the"
				+ "\nperimeter fence. You check your inventory and begin your escape plan.");
		println(user); // display player stats
		if (user.getInventory().contains("grappling hook") &&
				user.getInventory().contains("rope") && 
				user.getInventory().contains("disguise") &&
				user.getInventory().contains("sheets")) { // checks if user has all required items in inventory
			println("You take your disguise and put it on. Now you take your grappling hook and rope"
					+ "\nand throw it to the top of the fence. You easily climb to the top of the fence."
					+ "\nThe guards see that you are up there but assume you are a maintenance worker. You then"
					+ "\ntake the sheets and place them over the barbed wire to keep yourself from getting"
					+ "\nsliced up. You climb over and repel down sucessfully onto the other side of freedom!");
			gameOver(true);
			return true;
		}else {
			if (!user.getInventory().contains("grappling hook")) { // user doesn't have a grappling hook
				println("You don't have a grappling hook. You slip from the fence and hurt yourself!");
				println("Ouch.. Health - 2");
				user.setHealthPoints(user.getHealthPoints() - 2); // health damage
				if (!checkHealth(user)) { // check if user has enough health to continue
					return false;
				}
			}
			if (!user.getInventory().contains("rope")) { // user doesn't have a rope
				println("You don't have a rope. It's hard to grip the fence and you hurt yourself!");
				println("Hand Cramps.. Health - 2");
				user.setHealthPoints(user.getHealthPoints() - 2); // health damage
				if (!checkHealth(user)) { // check if user has enough health to continue
					return false;
				} 
			}
			if (!user.getInventory().contains("disguise")) { // user doesn't have a disguise
				println("You don't have a disguise. The guards notice you climbing and turn on the electric fence!");
				println("Extra Crispy.. Health - 3");
				user.setHealthPoints(user.getHealthPoints() - 3); // health damage
				if (!checkHealth(user)) { // check if user has enough health to continue
					return false;
				};
			}
			if (!user.getInventory().contains("sheets")) { // user doesn't have sheets
				println("You don't have sheets. You cut yourself on the barbed wire!");
				println("Sliced.. Health - 2");
				user.setHealthPoints(user.getHealthPoints() - 3); // health damage
				if (!checkHealth(user)) { // check if user has enough health to continue
					return false;
				}
			}
			// user has enough health after escaping
			println("You find yourself on the other side of the fence. You may have gotten hurt in the process"
					+ "\nbut the end result is freedom! Everything that you went through today was worth it.");
			gameOver(true);
			return false;	// returns false to continue game
		}
	}
	// method to check user's health and see if game ends
	public boolean checkHealth(Player user) {
		if (user.getHealthPoints() < 1) { // check if user's health is low
			user.setHealthPoints(0); // if health is negative set to 0
			println(user); // display user stats
			println("\nYou are critically injured. You were sent to the infirmary."
					+ "Looks like your escape plans are on hold.");
			gameOver(false); // game over, print lose message
			return false; // game over return false
		}
		println(user); // display user stats
		return true; // return true to continue game
	}	
	// game over prompts
	public void gameOver(boolean over) {
		if (over) { // win message
			println("You successfully broke out of the Java State Prison!! Good luck to you!"
					+ "\nMake sure to debug in the future so you don't end up back here!"
					+ "\nEnjoy your life on the run, you may be free now but at what cost.");
		} else { // lose message
			println("Seems like your plan was as well executed as the code that got you put here"
					+ "\nin the first place. Better luck time! Oh yeah and enjoy the added time"
					+ "\nto your sentence. ");
		}	
	}
	// this method is just to have more convenient print method
	public static void print(Object string) {
		System.out.print(string);
	}
	// this method is just to have more convenient println method
	public static void println(Object string) {
		System.out.println(string);
	}
}
