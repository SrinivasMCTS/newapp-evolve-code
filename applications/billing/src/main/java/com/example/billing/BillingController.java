package com.example.billing;

import com.example.payments.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BillingController {
    @Autowired
    private Gateway paymentGateway;

    public BillingController(Gateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @RequestMapping(value = "/reoccurringPayment", method = RequestMethod.POST)
    public ResponseEntity<Object> reoccurringPayment(@RequestBody int paymentMonthlyAmount) {
        System.out.println("################ in reoccurringPayment() - "+ paymentMonthlyAmount);
        if (paymentGateway.createReocurringPayment(paymentMonthlyAmount)) {
            System.out.println("################ payment success");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            List<String> errors = new ArrayList<>();
            System.out.println("################ payment failed");
            return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
        }

    }

}
