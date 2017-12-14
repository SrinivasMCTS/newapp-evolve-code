package com.example.billing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class BillingClient {

//    private String url = "";

    private RestOperations restTemplate;


    @Autowired
    public BillingClient(RestOperations restTemplate) {
        System.out.println("################ in BillingClient() with url - ");
//        this.url = url;
        this.restTemplate = restTemplate;
    }

    public void billUser(String userId, int billAmount) {
        System.out.println("################ in bill user () with url - ");
//        Map<String, Integer> params = new HashMap<>();
//        params.put("billAmount", 100);
        //String url = restTemplate.getForObject("http://billing", String.class);
        //System.out.println("################ got url - " + url);
        restTemplate.postForEntity("http://billing/reoccurringPayment", billAmount, String.class);
        System.out.println("################ rest template called -");
    }
}
