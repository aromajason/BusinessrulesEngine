package com.example.businessrulesEngine.pipeline.handler;

import com.example.businessrulesEngine.model.CategoryType;
import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.model.ProductType;
import com.example.businessrulesEngine.pipeline.Handler;

public class EmailHandler implements Handler<PaymentRequest, PaymentRequest> {
    @Override
    public PaymentRequest process(PaymentRequest input) {

        if (ProductType.MEMBERSHIP.equals(input.getProductType()) || ProductType.UPGRADE_MEMBERSHIP.equals(input.getProductType())) {
            System.out.println(input.getCategoryType() + " - send email");
        }
        return input;
    }
}
