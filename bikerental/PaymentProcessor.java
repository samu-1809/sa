package com.bikerental;

public class PaymentProcessor {

    public void processPayment(Customer customer, double amount) {
        System.out.println("Procesando pago con tarjeta de crédito de " + String.format("%.2f", amount) + " para " + customer.getName());
	}
}