package com.dh.validatePayment;

import com.dh.validatePayment.service.impl.CashProcessor;
import com.dh.validatePayment.service.impl.CreditProcessor;
import com.dh.validatePayment.service.Card;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Card validcreditCard = new CreditProcessor(455000.00, "364839", "390", LocalDate.of(2030, 12, 12), 1000000.00, 300000.00);
        Card validcashCard = new CashProcessor(20000.00, "436434", "280", LocalDate.of(2030, 12, 12), 35000.00);
        Card invalidcreditCard = new CreditProcessor(455000.00, "45846", "233", LocalDate.of(2022, 12, 12), 1000000.00, 300000.00);
        Card invalidcashCard = new CashProcessor(20000.00, "373634", "133", LocalDate.of(2022, 12, 12), 35000.00);
        Card nocreditCard = new CreditProcessor(455000.00, "4575", "856", LocalDate.of(2030, 12, 12), 1000000.00, 600000.00);
        Card nocashCard = new CashProcessor(20000.00, "436434", "280", LocalDate.of(2030, 12, 12), 19000.00);

        System.out.println("____________");
        validcreditCard.processor();
        System.out.println("____________");
        validcashCard.processor();
        System.out.println("____________");
        invalidcreditCard.processor();
        System.out.println("____________");
        invalidcashCard.processor();
        System.out.println("____________");
        nocreditCard.processor();
        System.out.println("____________");
        nocashCard.processor();
    }
}
