package com.skillstorm.game;

public class Player {
	
	private String name;
	private int securityLevel;
	private int healthPoints;
	private int strength;
	private int intellegence;
	
	public Player(String name,
				 int securityLevel, 
				 int healthPoints, 
				 int strength, 
				 int intellegence) {
		
		this.name = name;
		this.healthPoints = healthPoints;
		this.securityLevel = securityLevel;
		this.strength = strength;
		this.intellegence = intellegence;
		
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
}
