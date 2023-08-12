package com.springboot.springboottransactiondemo.exception;

public class PaymentException extends RuntimeException{

    public PaymentException(String msg){
        super(msg);
    }
}
