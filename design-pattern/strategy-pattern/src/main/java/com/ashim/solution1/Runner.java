package com.ashim.solution1;

import java.util.HashMap;
import java.util.Map;

public class Runner {
	public static void main(String[] args) {

		Map<String, String> test = new HashMap<>();
		test.put("test", "test");
		System.out.println("test.get(\"test\") = " + test.get("test"));
		"test".equals("test");


//		Booking cashBooking = new Booking(new CashPayment());
//		Booking cardBooking = new Booking(new CardPayment());
//		Booking netBooking = new Booking(new NetBanking());
//
//		cashBooking.makePayment();
//		cardBooking.makePayment();
//		netBooking.makePayment();
	}
}
