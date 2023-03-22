package com.skillstorm.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BreakOut {
	
	static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) {
		playAgain();
	}
	
	public static void playAgain() {
		Random randomGen = new Random();
		ArrayList<Integer> scenes = new ArrayList<Integer>();
		boolean playAgain;
		String again = "";
		do {
			println("*****BREAKOUT!*****");
			
			println("\nHere you are sitting in back of the police car, questioning your life decisions.");
			println("You are wondering how you got in this position but no matter how much you replay "
					+ "\nwhat you have done you know that it doesn't matter now. You are headed to your "
					+ "\nnew home.");
			
			println("\nCOP: You thought you'd get away with it huh? Sike! Now look at you, you're headed"
					+ " to prison.");
			println("COP: Good Luck, the Java State Prison is no joke.");
			println("COP: But you know what they say, don't do the crime if you can't do the time");
			
			println("\nYou arrive at the prison and are escorted to the processing unit.\n");
			println("***********************************************************************************");
			println("\n***** ADMIN *****");
			
			Scenes gameScene = new Scenes();
			Player inmate = Scenes.admin();
	
//			while (scenes.size() < 5) {
//				int random = randomGen.nextInt(5);
//				if (!scenes.contains(random)) {
//					scenes.add(random);
//				}
//			}
//			scenes.add(0);
//			scenes.add(1);
//			scenes.add(2);
//			scenes.add(3);
//			scenes.add(4);
			
			
			gameScene.yard(inmate);
			
			do {
				print("Would you like to play again? (Y/N): ");
				again = in.nextLine();
				if (again.equalsIgnoreCase("y")) {
				playAgain = true;
				} else {
					playAgain = false;
				}
			} while (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n"));
		} while (playAgain);
	}	
	public static void print(Object string) {
		System.out.print(string);
	}
	public static void println(Object string) {
		System.out.println(string);
	}
	
}
