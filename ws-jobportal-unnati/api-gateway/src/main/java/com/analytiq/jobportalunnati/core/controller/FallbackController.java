package com.analytiq.jobportalunnati.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	// Mention fallback method handlers  for all of services if it is down or not currently available in microservice project
	// Please go through immediate failure and cascading failure of services and how/what to implement as best practices
	// Time in seconds is mentioned in application.yml of cloudapi-gateway like 
	//hystrix:
	  //command:
		    //fallbackcmd:
		      //execution:
		        //isolation:
		          //thread:
		           //timeoutInMilliseconds: 4000
    @GetMapping("/hrServiceFallBack")
    public String userFallback() {
        return "HR service is not available";
    }

    @GetMapping("/paymentServiceFallBack")
    public String teacherServiceFallBack() {
        return "Payment service is not available";
    }
    @GetMapping("/notificationServiceFallBack")
    public String departmentServiceFallBack() {
        return "Notification service is not available";
    }
    @GetMapping("/applicantServiceFallBack")
    public String applicantServiceFallBack() {
        return "Applicant service is not available";
    }
    @GetMapping("/chatServiceFallBack")
    public String chatServiceFallBack() {
        return "Chat service is not available";
    }
}
