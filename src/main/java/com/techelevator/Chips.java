package com.techelevator;

public class Chips extends Snack{
	
	
	
	private double price;
	private static int potatoCrispsLeft =5 ;
	private static int stackersLeft =5;
	private static int grainWavesLeft =5;
	private static int cloudPopcornLeft =5;

	public Chips() {
	
	}
	
	public double getPotatoCrispsPrice() {
		return 3.05;
	}
	
	public double getStackersPrice() {
		return 1.45;
	}
	
	public double getGrainWavesPrice() {
		return 2.75;
		
	}
	
	public double getCloudPopcornPrice() {
		return 3.65;
	}
	
	public void completeChipsPurchase(String item) {
		if(item.equals("Potato Crisps")) {
			potatoCrispsLeft--;
		}else if(item.equals("Stackers")) {
			stackersLeft--;
		}else if(item.equals("Grain Waves")) {
			grainWavesLeft--;
		}else if(item.equals("Cloud Popcorn")) {
			cloudPopcornLeft--;
		}
	}
	

	public int getPotatoCrispsLeft() {
		return potatoCrispsLeft;
	}

	public  int getStackersLeft() {
		return stackersLeft;
	}

	public int getGrainWavesLeft() {
		return grainWavesLeft;
	}

	public int getCloudPopcornLeft() {
		return cloudPopcornLeft;
	}

}
