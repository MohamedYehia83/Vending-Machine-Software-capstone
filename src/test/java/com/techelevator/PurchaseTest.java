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

}
