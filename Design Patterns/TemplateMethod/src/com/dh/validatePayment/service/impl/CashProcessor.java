package com.dh.validatePayment.service.impl;

import com.dh.validatePayment.service.Card;

import java.time.LocalDate;

public class CashProcessor extends Card {
    public Double availableExpense;

    public CashProcessor(Double amountToWithdraw, String mainNumber, String securityCode, LocalDate expirationDate, Double availableExpense) {
        super(amountToWithdraw, mainNumber,  securityCode, expirationDate);
        this.availableExpense = availableExpense;
    }


    @Override
    protected String cardProcessor(){
        String result;
        if(!hasExpired){
            if(availableExpense > amountToWithdraw){
                result = "Approved";
            }else{
                result = "You don't have enough balance.";
            }
        }else {
            result = "Your cash card has expired";
        }
        System.out.println(result);
        return result;

    }
}
