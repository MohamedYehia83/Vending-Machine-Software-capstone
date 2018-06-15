package com.techelevator;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.sound.midi.Soundbank;

import org.junit.Test;

import com.techelevator.view.Menu;

public class PurchaseTest {

	@Test
	public void feedMoneyTest() throws IOException {
		Menu menu = new Menu(System.in, System.out);
		Purchase purchase = new Purchase(menu);
		System.out.println("Enter 60");
		purchase.feedMoney();
		assertEquals("Exected Value is 60", 60 ,purchase.getCurrentBalance(), 0);
		System.out.println("Enter 60");
		purchase.feedMoney();
		assertEquals("Exected Value is 120", 120 ,purchase.getCurrentBalance(), 0);
		System.out.println("Enter in -1");
		purchase.feedMoney();
		assertEquals("Expected to stay at 120",120,purchase.getCurrentBalance(),0);
	}
	
	@Test
	public void finishTransactionTest() throws IOException {
		Menu menu = new Menu(System.in, System.out);
		Inventory inventory = new Inventory();
		Purchase purchase = new Purchase(menu);
		System.out.println("Enter 10");
		purchase.feedMoney();
		purchase.finishTransaction();
		assertEquals("Change should be 10" , 10, purchase.getChange(),0);
		assertEquals("Balance should return to 0",0,purchase.getCurrentBalance(),0);
		System.out.println("Enter in 2");
		purchase.feedMoney();
		System.out.println("Enter B1");
		purchase.selectProduct(inventory);
		
		purchase.finishTransaction();
		assertEquals("Change should be 0.20" , 0.20, purchase.getChange(),0.1);
		
		
		
	}
	
	@Test
	public void selectProductTest() throws IOException {
		Menu menu = new Menu(System.in, System.out);
		Inventory inventory = new Inventory();
		Purchase purchase = new Purchase(menu);
		System.out.println("Enter 10");
		purchase.feedMoney();
		System.out.println("Enter in B1");
		purchase.selectProduct(inventory);
		assertEquals("Key should be B1" , "B1" , purchase.getItemKey());
		assertEquals("Item should be Moonpie" ,"Moonpie", purchase.getItemSelected());
		assertEquals("Type should be candy" , "Candy" , purchase.getItemType());
		purchase.finishTransaction();
		
		System.out.println("Enter in 10");
		purchase.feedMoney();
		
		System.out.println("Enter in B5");
		purchase.selectProduct(inventory);
		assertEquals("Key should be null" , null , purchase.getItemKey());
		assertEquals("Item should be null" , null , purchase.getItemSelected());
		assertEquals("Type should be null" , null , purchase.getItemType());
		
		
		
	}
	
	
	@Test
	public void amountLeftTest() throws IOException {
		Menu menu = new Menu(System.in, System.out);
		Inventory inventory = new Inventory();
		Purchase purchase = new Purchase(menu);
		Candy candy = new Candy();
		Gum gum = new Gum();
		Chips chips = new Chips();
		Drinks drinks = new Drinks();
		
		System.out.println("Enter in 25");
		purchase.feedMoney();
		
		System.out.println("Enter in A3");
		purchase.selectProduct(inventory);

		System.out.println("Enter in B3");
		purchase.selectProduct(inventory);

		System.out.println("Enter in C3");
		purchase.selectProduct(inventory);

		System.out.println("Enter in D3");
		purchase.selectProduct(inventory);
		
		assertEquals("Should be 4 left" , 4 , chips.getGrainWavesLeft());
		assertEquals("Should be 4 left" , 4 , candy.getWonkaBarsLeft());
		assertEquals("Should be 4 left" , 4 , drinks.getMountainMelterLeft());
		assertEquals("Should be 4 left" , 4 , gum.getChicletsLeft());
		
		purchase.finishTransaction();
		
		System.out.println("Enter in 60");
		purchase.feedMoney();
		
		System.out.println("Enter in A3");
		purchase.selectProduct(inventory);

		System.out.println("Enter in A3");
		purchase.selectProduct(inventory);

		System.out.println("Enter in A3");
		purchase.selectProduct(inventory);

		System.out.println("Enter in A3");
		purchase.selectProduct(inventory);
		
		System.out.println("Enter in A3");
		purchase.selectProduct(inventory);
		
		System.out.println("Enter in A3");
		purchase.selectProduct(inventory);
		
		assertEquals("Should be 0, item sold out" , 0 , chips.getGrainWavesLeft());
		
	}
	@Test
	public void makeChangeTest() throws IOException {
		Menu menu = new Menu(System.in, System.out);
		Inventory inventory = new Inventory();
		Purchase purchase = new Purchase(menu);
		System.out.println("Enter 1.90");
		purchase.feedMoney();
		
		purchase.finishTransaction();
		
		assertEquals("Quarters should be 7" , 7 , purchase.getQuarters());
		assertEquals("Dimes should be 1 " , 1 , purchase.getDimes());
		assertEquals("Nickels should be 1" , 1 , purchase.getNickels());
		
		
		
	}

}
