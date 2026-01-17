package com.testleaf.matschie.booker.step.definitions;

import com.testleaf.booker.services.BookingService;

import io.restassured.builder.RequestSpecBuilder;

public class BookingSteps {
	
	private BookingService bookingService = new BookingService();
	private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

}