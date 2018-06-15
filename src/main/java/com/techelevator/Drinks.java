package com.techelevator;

public class Drinks extends Snack {
	

	
	private double price;
	private static int colaLeft =5;
	private static int drSaltLeft =5;
	private static int mountainMelterLeft =5;
	private static int heavyLeft =5;

	public Drinks() {
		
		
	}
	
	
	public double getColaPrice() {
		return 1.25;
	}
	
	public double getDrSaltPrice() {
		return 1.50;
	}
	
	public double getMountainMelterPrice() {
		return 1.50;
		
	}
	
	public double getHeavyPrice() {
		return 1.50;
	}
	
	public void completeDrinksPurchase(String item) {
		if(item.equals("Cola")) {
			colaLeft--;
		}else if(item.equals("Dr. Salt")) {
			drSaltLeft--;
		}else if(item.equals("Mountain Melter")) {
			mountainMelterLeft--;
		}else if(item.equals("Heavy")) {
			heavyLeft--;
		}
	}


	public int getColaLeft() {
		return colaLeft;
	}


	public int getDrSaltLeft() {
		return drSaltLeft;
	}


	public int getMountainMelterLeft() {
		return mountainMelterLeft;
	}


	public int getHeavyLeft() {
		return heavyLeft;
	}

}
