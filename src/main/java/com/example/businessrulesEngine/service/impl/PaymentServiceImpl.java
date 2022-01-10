package com.example.businessrulesEngine.service.impl;

import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.pipeline.Pipeline;
import com.example.businessrulesEngine.pipeline.handler.*;
import com.example.businessrulesEngine.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void processPayment(PaymentRequest paymentRequest) {
        var filters = new Pipeline<>(new PhysicalProductHandler())
                .addHandler(new BookHandler())
                .addHandler(new CommissionPaymentHandler())
                .addHandler(new EmailHandler())
                .addHandler(new MembershipHandler())
                .addHandler(new UpgradeMembershipHandler())
                .addHandler(new VideoHandler());
        filters.execute(paymentRequest);
    }
}
