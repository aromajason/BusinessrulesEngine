package com.example.businessrulesEngine;

import com.example.businessrulesEngine.model.CategoryType;
import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.model.ProductType;
import com.example.businessrulesEngine.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringBootTest
@RunWith(SpringRunner.class)
class BusinessrulesEngineApplicationTests {

	@Autowired
	PaymentService paymentService;

	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	public void SetUp() {
		System.setOut(new PrintStream(outputStream));
	}


	@Test
	public void testPaymentForPhysicalProduct() {
		PaymentRequest request = new PaymentRequest("Membership",
				ProductType.MEMBERSHIP, CategoryType.SERVICE);
		paymentService.processPayment(request);
		Assertions.assertEquals("SERVICE - send email\r\n"
				+ "SERVICE - activate membership",
				outputStream.toString().trim());
	}

}
