package com.kimyoji.study.ex4;

public class CustomerTest {

	public static void main(String[] args) {
		
		Customer c1 = new Customer();
		
		Buy buyer = c1;
		buyer.buy();
		
		Sell seller = c1;
		seller.sell();
		
		if(seller instanceof Customer) {
			Customer c2 = (Customer)seller;
			c2.buy();
			c2.sell();
		}
	}
}
