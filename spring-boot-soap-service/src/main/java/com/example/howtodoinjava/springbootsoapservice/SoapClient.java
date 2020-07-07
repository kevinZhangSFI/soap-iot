package com.example.howtodoinjava.springbootsoapservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;

public class SoapClient extends WebServiceGatewaySupport {
	@Autowired
	private WebServiceTemplate webServiceTemplate;
	private static final Logger log = LoggerFactory.getLogger(SoapClient.class);

	public StudentDetailsResponse getStudent(String student) {

		StudentDetailsRequest request = new StudentDetailsRequest();
		request.setName(student);

		log.info("Requesting location for " + student);

		StudentDetailsResponse response = (StudentDetailsResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/service/studentDetailsWsdl.wsdl", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		return response;
	}

}