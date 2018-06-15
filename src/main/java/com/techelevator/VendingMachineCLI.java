package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.midi.Soundbank;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE , MAIN_MENU_OPTION_EXIT};
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws IOException {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				Inventory inventory = new Inventory();
				inventory.displayInventory();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				Purchase purchase = new Purchase(menu);
				purchase.run();
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				Purchase purchase = new Purchase(menu);
				Candy candy = new Candy();
				Gum gum = new Gum();
				Chips chips = new Chips();
				Drinks drinks = new Drinks();
				System.out.println('\n' +"SALES REPORT");
				System.out.println("---------------------------------");
				System.out.println("Potato Crisps " + (5-chips.getPotatoCrispsLeft()));
				System.out.println("Stackers " + (5-chips.getStackersLeft()));
				System.out.println("Grain Waves "+ (5-chips.getGrainWavesLeft()));
				System.out.println("Cloud Popcorn "+ (5-chips.getCloudPopcornLeft()));
				System.out.println("Moonpie "+ (5-candy.getMoonpiesLeft()));
				System.out.println("Cowtales "+ (5-candy.getCowtalesLeft()));
				System.out.println("Wonka Bar "+ (5-candy.getWonkaBarsLeft()));
				System.out.println("Crunchie "+ (5-candy.getCrunchiesLeft()));
				System.out.println("Cola "+ (5-drinks.getColaLeft()));
				System.out.println("Dr. Salt "+ (5-drinks.getDrSaltLeft()));
				System.out.println("Mountain Melter "+ (5-drinks.getMountainMelterLeft()));
				System.out.println("Heavy "+ (5-drinks.getHeavyLeft()));
				System.out.println("U-Chews " + (5-gum.getuChewsLeft()));
				System.out.println("Little Leauge Chew "+ (5-gum.getLittleLeaugeChewLeft()));
				System.out.println("Chiclets "+ (5-gum.getChicletsLeft()));
				System.out.println("Triplement "+ (5-gum.getTriplemintLeft()));
				
				System.out.printf('\n' +"*** Total Sales *** = $" + "%.2f" , purchase.getTotalSales());
				return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
	
	
}
