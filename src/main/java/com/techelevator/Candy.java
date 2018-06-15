package com.techelevator;



public class Candy extends Snack {
	
	private double price;
	private static int crunchiesLeft =5;
	private static int wonkaBarsLeft =5;
	private static int cowtalesLeft = 5;
	private static int moonPiesLeft = 5;

	public Candy() {
		
		
	}
	
	
	public double getMoonPiePrice() {
		return 1.80;
	}
	
	public double getCrunchiesPrice() {
		return 1.75;
	}
	
	public double getCowtalesPrice() {
		return 1.50;
		
	}
	
	public double getWonkaBarsPrice() {
		return 1.50;
	}
	
	public void completeCandyPurchase(String item) {
		if(item.equals("Moonpie")) {
			moonPiesLeft--;
		}else if(item.equals("Wonka Bar")) {
			wonkaBarsLeft--;
		}else if(item.equals("Crunchie")) {
			crunchiesLeft--;
		}else if(item.equals("Cowtales")) {
			cowtalesLeft--;
		}
	}
	
	
	public  int getCrunchiesLeft() {
		return crunchiesLeft;
	}


	public int getWonkaBarsLeft() {
		return wonkaBarsLeft;
	}


	public int getCowtalesLeft() {
		return cowtalesLeft;
	}


	public int getMoonpiesLeft() {
		return moonPiesLeft;
	}
	
	
	

}
