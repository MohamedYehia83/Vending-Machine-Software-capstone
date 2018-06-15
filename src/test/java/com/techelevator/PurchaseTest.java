package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.view.Menu;

public class PurchaseTest {

	@Test
	public void feedMoneyTest() {
		Menu menu = new Menu(System.in, System.out);
		Purchase purchase = new Purchase(menu);
		purchase.run();
	}

}
