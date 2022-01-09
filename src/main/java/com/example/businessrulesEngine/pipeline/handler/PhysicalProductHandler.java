package com.example.businessrulesEngine.pipeline.handler;

import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.model.ProductType;
import com.example.businessrulesEngine.pipeline.Handler;

public class PhysicalProductHandler implements Handler<PaymentRequest, PaymentRequest> {
    @Override
    public PaymentRequest process(PaymentRequest input) {
        if (ProductType.PHYSICAL.equals(input.getProductType())) {
            System.out.println(input.getCategoryType() + " - generate a packaging slip for shipping" );
        }
        return input;
    }
}
