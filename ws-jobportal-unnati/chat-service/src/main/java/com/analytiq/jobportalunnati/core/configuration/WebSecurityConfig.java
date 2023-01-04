package com.analytiq.jobportalunnati.core.configuration;



import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{




	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests(configurer -> configurer.antMatchers("/chat/**", "/swagger-ui.html", "/swagger-ui/**", "/swagger-ui/index.html", "/v3/api-docs").permitAll()
		.anyRequest().authenticated())
		
		.exceptionHandling().authenticationEntryPoint((request, response, ex) -> { response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());});
	}
	
	//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
   // .and()
   // .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
    //.exceptionHandling(exceptions -> exceptions
          //  .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
          //  .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
         //   .and())
   // .build();
	
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui/**", "/v3/api-docs/**");
    }
	
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public static BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	

}
