package com.skillstorm.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BreakOut {
	
	static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) throws InterruptedException {
		
		Random randomGen = new Random();
		ArrayList<Integer> scenes = new ArrayList<Integer>();
		
		println("*****BREAKOUT!*****");
		println("\nHere you are sitting in back of the police car, questioning your life decisions.");
		println("You are wondering how you got in this position but no matter how much you replay what you have done");
		println("you know that it doesn't matter now. You are headed to your new home.");
		
		println("\nCop: You thought you'd get away with it huh? Sike! Now look at you, you're headed to prison.");
		println("Cop: Good Luck, the Java State Prison is no joke.");
		println("Cop: But you know what they say, don't do the crime if you can't do the time");
		
		println("\nYou arrive at the prison and are escorted to the processing unit.\n");
		println("************************************************");
		
		Player inmate = admin();
	
		println("Admin: Processing is now complete. Enjoy your stay Prisoner " + inmate.getName());
		println("\nDay1 Night1....\n Day2 Night2....\n  Day3 Night3...\n");
		
		println("After spending 3 days in the Java State Prison, you realize this isn't the place for you");
		println("Of course you believe you shouldn't be there in the first place, since we \"we all know your innocent\".");
		println("But understanding you only have one real option to get out, and that's to BREAKOUT.");
		println("You decide tomorrow will be the day you'll escape from the Java State Prison.");
		
		Scenes gameScene = new Scenes();
		println("********** NEXT DAY **********");
		while (scenes.size() < 5) {
			int random = randomGen.nextInt(5);
			if (!scenes.contains(random)) {
				scenes.add(random);
			}
		}
		for (int num : scenes) {
			if (num == 0) {
				gameScene.cell();
			} else if (num == 1) {
				gameScene.kitchen();
			} else if (num == 2) {
				gameScene.dayroom();
			} else if (num == 3) {
				gameScene.laundry();
			} else if (num == 4) {
				gameScene.yard();
			}
		}	
	}
	public static void print(Object string) {
		System.out.print(string);
	}
	public static void println(Object string) {
		System.out.println(string);
	}
	public static int getRandom(int max) {
		return (int) (Math.random()*max); 
		} 
	public static int getRandomInteger(int maximum, int minimum) {
		return ((int) (Math.random()*(maximum - minimum))) + minimum;
		}
	public static Player admin() {
		
		String username;
		int securityLevel;
		
		println("Admin: Welcome to the Java State Prison");
		println("Admin: This is the processing unit, I will need just a couple pieces of information from you.");
		do {
			print("Admin: May I have your name?: ");
			username = in.nextLine();
		} while (username.trim().equals(""));
		do {
			println("\nAdmin: Thank you, Prisoner " + username);
			try {
				print("Admin: Now can you tell me what your security level is "
						+ "(1: minimum, 2: average, 3: maximum): ");
				securityLevel = in.nextInt();
			} catch(InputMismatchException e) {
				securityLevel = 100;
				in.nextLine();
			}
		} while (securityLevel != 1 && securityLevel != 2 && securityLevel != 3);
		
		if (securityLevel == 1) {
			println("\nAdmin: Level 1 security... Hmmmm interesting, you must have just forgot a ; somewhere, so I'll put in your file"
					+ " that you fall under the soft catergory.");
			Player user = new Player(username, securityLevel, 5, 2, 5);
			return user;
		} else if (securityLevel == 2) {
			println("\nAdmin: Level 2 security you say, you must have used the wrong data type? I'll be sure to note that.");
			Player user = new Player(username, securityLevel, 5, 3, 3);	
			return user;
		} else {
			println("\nAdmin: Level 3 Yikeees! You must be an infinite looper! Remind me to stay out of your code...");
			Player user = new Player(username, securityLevel, 10, 5, 1);
			return user;
		}
	}
}
