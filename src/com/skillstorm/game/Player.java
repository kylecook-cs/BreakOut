package com.skillstorm.game;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private int securityLevel;
	private int healthPoints;
	private int strength;
	private int intellegence;
	private ArrayList<String> inventory = new ArrayList<String>(5);
	
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

