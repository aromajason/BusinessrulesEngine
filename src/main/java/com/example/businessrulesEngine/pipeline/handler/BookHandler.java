package com.example.businessrulesEngine.pipeline.handler;

import com.example.businessrulesEngine.model.CategoryType;
import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.pipeline.Handler;

public class BookHandler implements Handler<PaymentRequest, PaymentRequest> {

    @Override
    public PaymentRequest process(PaymentRequest input) {
        if (CategoryType.BOOK.equals(input.getCategoryType())) {
            System.out.println(input.getCategoryType() + " - create a duplicate packaging slip for the royalty" +
                    "department");
        }
        return input;
    }
}
