package com.example.howtodoinjava.springbootsoapservice;

import com.howtodoinjava.xml.school.StudentDetailsResponse;

public class TestSoap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       SoapClient soapClient = new SoapClient();
       StudentDetailsResponse studentResp = soapClient.getStudent("Luke");
       System.out.println(studentResp.toString());
	}

}
