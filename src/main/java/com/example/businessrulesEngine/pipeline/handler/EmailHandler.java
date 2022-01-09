package com.example.businessrulesEngine.pipeline.handler;

import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.pipeline.Handler;

public class EmailHandler implements Handler<PaymentRequest, PaymentRequest> {
    @Override
    public PaymentRequest process(PaymentRequest input) {
        return null;
    }
}
