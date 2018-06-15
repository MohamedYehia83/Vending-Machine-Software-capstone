package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;

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
