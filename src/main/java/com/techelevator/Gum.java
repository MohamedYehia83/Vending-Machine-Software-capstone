package com.techelevator;

public class Gum extends Snack{


	
	private double price;
	private static int uChewsLeft =5;
	private static int littleLeaugeChewLeft =5;
	private static int chicletsLeft =5;
	private static int triplemintLeft =5;

	public Gum() {
		
		
	}
	
	
	public double getUChewsPrice() {
		return 0.85 ;
	}
	public double getLittleLeaugeChewPrice() {
		return 0.95;
	}
	
	public double getChicletsPrice() {
		return 0.75;
		
	}
	
	public double getTriplemintPrice() {
		return 0.75;
	}
	
	public void completeGumPurchase(String item) {
		if(item.equals("U-Chews")) {
			uChewsLeft--;
		}else if(item.equals("Little League Chew")) {
			littleLeaugeChewLeft--;
		}else if(item.equals("Chiclets")) {
			chicletsLeft--;
		}else if(item.equals("Triplement")) {
			triplemintLeft--;
		}
	}
	
	public int getuChewsLeft() {
		return uChewsLeft;
	}


	public int getLittleLeaugeChewLeft() {
		return littleLeaugeChewLeft;
	}


	public int getChicletsLeft() {
		return chicletsLeft;
	}


	public int getTriplemintLeft() {
		return triplemintLeft;
	}


	

}
