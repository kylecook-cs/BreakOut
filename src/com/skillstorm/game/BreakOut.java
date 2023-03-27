package com.skillstorm.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BreakOut {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args){
			playAgain(); // calls this method to play game until user doesn't want to	
	}
	// this method starts the game, sets the scenes, and finishes game. Then asks user if they want to replay
	public static void playAgain(){
		Random randomGen = new Random(); // random generator
		ArrayList<Integer> scenes = new ArrayList<Integer>(); // arrayList to store the scene order
		boolean playAgain; // play again flag
		String again; // declare user input for playing again
		do {
			// beginning of game
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
			println("********************************************************************************");

			Scenes gameScene = new Scenes(); // create scenes object
			Player inmate = Scenes.admin(); // creates an player object for user

			while (scenes.size() < 5) { // gets a random order of scenes
				int random = randomGen.nextInt(5);
				if (!scenes.contains(random)) { // checks if that random int is already in scenes ArrayList
					scenes.add(random); // if not then add that scene
				}
			}

			scenes.add(10); // add the escape scene at the end
			levels: // label for looping through scenes
				for(int num : scenes ) { // foreach to loop through each scene
					if (num == 0) {
						if (!gameScene.yard(inmate)) {
							break levels; // break out of for loop because game ending scenario happened
						}
					} else if (num == 1) {
						if (!gameScene.cell(inmate)) {
							break levels;
						}
					} else if (num == 2) {
						if (!gameScene.laundry(inmate)) {
							break levels;
						}
					} else if (num == 3) {
						if (!gameScene.kitchen(inmate)) {
							break levels;
						}
					} else if (num == 4) {
						if (!gameScene.dayroom(inmate)) {
							break levels;
						}
					} else {
						gameScene.escape(inmate);
					}
				}
			do {
				print("\nWould you like to play again? (Y/N): "); // prompt user on whether to play again
				again = in.nextLine();
				if (again.equalsIgnoreCase("y")) {
					playAgain = true; // yes play again
				} else {
					playAgain = false; // no don't play again
				}
			} while (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n")); // enforce user to enter accepted response only
		} while (playAgain);
		println("Have a good one! See you next time.");
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
