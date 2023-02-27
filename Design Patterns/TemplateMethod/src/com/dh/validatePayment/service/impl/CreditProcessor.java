package com.dh.validatePayment.service.impl;

import com.dh.validatePayment.service.Card;

import java.time.LocalDate;

public class CreditProcessor extends Card {
    public Double limit;
    public Double expense;

    public CreditProcessor(Double amountToWithdraw, String mainNumber, String securityCode, LocalDate expirationDate, Double limit, Double expense) {
        super(amountToWithdraw, mainNumber,  securityCode, expirationDate);
        this.limit = limit;
        this.expense = expense;
    }
    @Override
    protected String cardProcessor(){
        String result;

        if(!hasExpired){
            if((amountToWithdraw + expense) < limit){
                result = "Approved";
            }else{
                result = "You try to exceed your credit limit";
            }
        }else{
            result = "Your credit card has expired";
        }
        System.out.println(result);
        return result;
    }
}
