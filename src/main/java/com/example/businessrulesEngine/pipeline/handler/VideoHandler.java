package com.example.businessrulesEngine.pipeline.handler;

import com.example.businessrulesEngine.model.CategoryType;
import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.model.ProductType;
import com.example.businessrulesEngine.pipeline.Handler;

public class VideoHandler implements Handler<PaymentRequest, PaymentRequest> {

    public static final String VIDEO_NAME = "Learning to ski";
    @Override
    public PaymentRequest process(PaymentRequest input) {
        if (CategoryType.VIDEO.equals(input.getCategoryType())) {
            if (VIDEO_NAME.equals(input.getProductName()))
            System.out.println(input.getCategoryType() + " - add a free first aid video to the  packing slip " +
                    "(the result of a court decision in 1997)" );
        }
        return input;
    }
}
