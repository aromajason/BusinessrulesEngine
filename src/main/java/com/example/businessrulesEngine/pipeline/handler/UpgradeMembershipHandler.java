package com.example.businessrulesEngine.pipeline.handler;

import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.model.ProductType;
import com.example.businessrulesEngine.pipeline.Handler;

public class UpgradeMembershipHandler implements Handler<PaymentRequest, PaymentRequest> {
    @Override
    public PaymentRequest process(PaymentRequest input) {
        if (ProductType.UPGRADE_MEMBERSHIP.equals(input.getProductType())) {
            System.out.println(input.getCategoryType() + " - apply the upgrade" );
        }
        return input;
    }
}
