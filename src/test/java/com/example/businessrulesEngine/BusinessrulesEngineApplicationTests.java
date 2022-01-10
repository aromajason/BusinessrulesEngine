package com.example.businessrulesEngine;

import com.example.businessrulesEngine.model.CategoryType;
import com.example.businessrulesEngine.model.PaymentRequest;
import com.example.businessrulesEngine.model.ProductType;
import com.example.businessrulesEngine.pipeline.handler.VideoHandler;
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
		PaymentRequest request = new PaymentRequest("Macbook",
				ProductType.PHYSICAL, CategoryType.TECH);
		paymentService.processPayment(request);

		Assertions.assertEquals("TECH - generate a packaging slip for shipping\r\n" +
						"TECH - generate a commission payment to the agent",
				outputStream.toString().trim());
	}

	@Test
	public void testPaymentForBook() {
		PaymentRequest request = new PaymentRequest("Book",
				ProductType.PHYSICAL, CategoryType.BOOK);
		paymentService.processPayment(request);

		Assertions.assertEquals("BOOK - generate a packaging slip for shipping\r\n" +
						"BOOK - create a duplicate packaging slip for the royaltydepartment\r\n" +
						"BOOK - generate a commission payment to the agent",
				outputStream.toString().trim());
	}

	@Test
	public void testPaymentForMembership() {
		PaymentRequest request = new PaymentRequest("Membership",
				ProductType.MEMBERSHIP, CategoryType.SERVICE);
		paymentService.processPayment(request);
		Assertions.assertEquals("SERVICE - send email\r\n"
				+ "SERVICE - activate membership",
				outputStream.toString().trim());
	}

	@Test
	public void testPaymentForUpgradeMembership() {
		PaymentRequest request = new PaymentRequest("Upgrade Membership",
				ProductType.UPGRADE_MEMBERSHIP, CategoryType.SERVICE);
		paymentService.processPayment(request);
		Assertions.assertEquals("SERVICE - send email\r\n" +
						"SERVICE - apply the upgrade",
				outputStream.toString().trim());
	}

	@Test
	public void testPaymentForVideo() {
		PaymentRequest request = new PaymentRequest(VideoHandler.VIDEO_NAME,
				ProductType.VIRTUAL, CategoryType.VIDEO);
		paymentService.processPayment(request);
		Assertions.assertEquals("VIDEO - add a free first aid video to the  packing slip " +
						"(the result of a court decision in 1997)",
				outputStream.toString().trim());
	}

}
