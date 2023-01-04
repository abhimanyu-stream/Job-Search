package com.analytiq.jobportalunnati.core.configuration;


import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
      info = @Info(
    		  title = "payment-service API", 
    		  version = "${api.version}",
              contact = @Contact(name = "Abhimanyu", email = "abhimanyu@analytiq.com", url = "https://www."),
              license = @License(name = "analytiq", url = "https://www.analytiq.com/licenses/LICENSE-2.0"), 
              termsOfService = "${tos.uri}",
              
              description = "${api.description}"),
      
      servers = {
              @Server(url = "http://localhost:9091", description = "payment-service Development[ Dev mode/profile]"),
              @Server(url = "${api.server.url.prod}", description = "Production mode descriptions"),
              @Server(url = "${api.server.url.qa}", description = "QA mode descriptions"),
              @Server(url = "${api.server.url.dev}", description = "Dev mode descriptions")
              })

@Configuration
public class OpenAPI30Configuration {
	
	/**Configure the OpenAPI components. @return Returns fully configure OpenAPI object @see OpenAPI*/
	/*
	 * @Bean public OpenAPI customizeOpenAPI() {
	 * 
	 * final String securitySchemeName = "Bearer Authentication"; return new
	 * OpenAPI() .addSecurityItem(new
	 * SecurityRequirement().addList(securitySchemeName)) .components(new
	 * Components().addSecuritySchemes(securitySchemeName, new SecurityScheme()
	 * .name(securitySchemeName) .type(SecurityScheme.Type.HTTP)//The supported
	 * security schemes are APIKey, HTTP Authentication (Basic and Bearer), OAuth2,
	 * and OpenID Connect. .scheme("bearer")
	 * .description("Provide the JWT token. JWT token can be obtained from the Login API."
	 * ) .bearerFormat("JWT")));
	 * 
	 * 
	 * }
	 */

}
