package com.analytiq.jobportalunnati.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class CloudApiRouteLocatorConfiguration {
	
	@Autowired
	private AuthenticationFilter filter;
	
	@Autowired
	RouteDefinitionLocator locator;

	
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
        		// Mention here all service name along with root url only i.e. @RequestMapping(" what is written here")on the top of class name which are in micro service project
                .route("applicant-service", auth -> auth.path("/auth/**","/rolebasedaccess/**","/api/posts/**","/users/**").filters(f -> f.filter(filter)).uri("lb://applicant-service"))
                .route("hr-service", student -> student.path("/hr/**").filters(f -> f.filter(filter)).uri("lb://hr-service"))
                .route("payment-service", teacher -> teacher.path("/payment/**").filters(f -> f.filter(filter)).uri("lb://payment-service"))
                .route("notification-service", teacher -> teacher.path("/notification/**").filters(f -> f.filter(filter)).uri("lb://notification-service"))
                .route("chat-service", teacher -> teacher.path("/chat/**").filters(f -> f.filter(filter)).uri("lb://chat-service"))
                .build();
        
    }
	
	

}
