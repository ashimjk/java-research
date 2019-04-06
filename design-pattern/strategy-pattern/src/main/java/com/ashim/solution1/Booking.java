package com.ashim.solution1;

public class Booking {

	public Payment payment;

	public Booking(Payment payment) {
		this.payment = payment;
	}

	public void makePayment() {
		payment.makePayment();
	}
}
