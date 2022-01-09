package com.example.businessrulesEngine.pipeline.handler;

import com.example.businessrulesEngine.model.CategoryType;
import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.model.ProductType;
import com.example.businessrulesEngine.pipeline.Handler;

public class CommissionPaymentHandler implements Handler<PaymentRequest, PaymentRequest> {
    @Override
    public PaymentRequest process(PaymentRequest input) {
        if (CategoryType.BOOK.equals(input.getCategoryType()) || ProductType.PHYSICAL.equals(input.getProductType())) {
            System.out.println(input.getCategoryType() + " - generate a commission payment to the agent");
        }
        return input;
    }
}