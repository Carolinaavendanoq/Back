package com.dh.validatePayment.service;

import java.time.LocalDate;
/**
 * @since 31-01-2023
 * @author Carolina Avendaño
 * */
public abstract class Card {
    public String mainNumber;
    public String securityCode;
    public LocalDate expirationDate;
    public Double amountToWithdraw;
    public Boolean hasExpired;

    public Card(Double amountToWithdraw, String mainNumber, String securityCode, LocalDate expirationDate){
        this.amountToWithdraw = amountToWithdraw;
        this.mainNumber = mainNumber;
        this.securityCode =securityCode;
        this.expirationDate = expirationDate;
    }

    public void processor(){
        validateExpirationDate();
        cardProcessor();
    }

    protected abstract String cardProcessor();
    /**
     * Description:
     * @param
     * @return result
     * */
    public String validateExpirationDate(){
        LocalDate currentDate =  LocalDate.now();
        String result = null;
        if(currentDate.isBefore(expirationDate)){
            result = "Initiating transaction to... " + mainNumber;
            hasExpired = false;
        }else {
            result= "Sorry! your card has expired";
            hasExpired = true;
        }
        System.out.println(result);
        System.out.println("Card has expired " + hasExpired);
        return result;
    }
}
