package com.example.payments;

public class RecurlyGateway implements Gateway {
    public boolean createReocurringPayment(int paymentMonthlyAmount){
        System.out.println("################ in createReocurringPayment");
        return true;
    }
}
