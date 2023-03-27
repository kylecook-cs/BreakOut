package com.skillstorm.game;

import java.util.ArrayList;

public class Player { // player object

	private String name; // user's name
	private int securityLevel; // player's security level, this determines the player's other properties
	private int healthPoints; // player's health
	private int strength; // player's strength
	private int intellegence; // player's intelligence
	private ArrayList<String> inventory = new ArrayList<String>(5); // an ArrayList to hold the player's items 
	
	public Player() {}
	// constructor for player object
	public Player(String name,
			int securityLevel, 
			int healthPoints, 
			int strength, 
			int intellegence,
			ArrayList<String> inventory) {

		this.name = name;
		this.healthPoints = healthPoints;
		this.securityLevel = securityLevel;
		this.strength = strength;
		this.intellegence = intellegence;
		this.inventory = inventory;
	}

	// getter and setter methods for player's properties
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntellegence() {
		return intellegence;
	}
	public void setIntellegence(int intellegence) {
		this.intellegence = intellegence;
	}
	public ArrayList<String> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<String> inventory, String item) {	
		this.inventory = inventory;
		this.inventory.add(item);
	}
	// override method to print the player's properties
	@Override
	public String toString() {
		String inventoryList = "";
		for (String inv : inventory) {
			inventoryList += (inv + " ");
		}
		return String.format("============================ PLAYER STATS ============================\n"
				+ "\nPrisoner %s  "
				+ "Security Level:%d  "
				+ "Health:%d  "
				+ "Stength:%d  "
				+ "Intelligence:%d  " 
				+ "Inventory: %s\n",
				name,
				securityLevel,
				healthPoints,
				strength,
				intellegence,
				inventoryList);
	}	
}

