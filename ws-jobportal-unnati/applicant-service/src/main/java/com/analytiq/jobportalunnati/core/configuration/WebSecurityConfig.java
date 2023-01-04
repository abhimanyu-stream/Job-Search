package com.analytiq.jobportalunnati.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.analytiq.jobportalunnati.core.filter.JwtTokenSecurityFilter;
import com.analytiq.jobportalunnati.core.service.CustomUserDetailsService;



@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private JwtTokenSecurityFilter jwtTokenSecurityFilter;

	
	
	

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
		http
		.cors().and().csrf().disable()
		
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests(configurer -> configurer
								.antMatchers("/users/signup", "/users/login","/users/refreshtoken", "/swagger-ui.html", "/swagger-ui/**", "/swagger-ui/index.html", "/v3/api-docs")
								.permitAll()
								.anyRequest().authenticated());
								
								
		http.addFilterBefore(jwtTokenSecurityFilter, UsernamePasswordAuthenticationFilter.class);
		//http.headers().frameOptions().sameOrigin();

		return http.build();
    }
	
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * http .cors() .and().csrf().disable()
	 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	 * .and() .authorizeRequests(configurer ->
	 * configurer.antMatchers("/users/signup", "/users/login", "/swagger-ui.html",
	 * "/swagger-ui/**", "/swagger-ui/index.html", "/v3/api-docs").permitAll()
	 * .anyRequest().authenticated()) .addFilterBefore(jwtTokenSecurityFilter,
	 * UsernamePasswordAuthenticationFilter.class).oauth2ResourceServer(
	 * OAuth2ResourceServerConfigurer::jwt) .exceptionHandling()
	 * .authenticationEntryPoint((request, response, ex) -> {
	 * response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());})
	 * .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
	 * .accessDeniedHandler(new BearerTokenAccessDeniedHandler());
	 * 
	 * 
	 * http.headers().frameOptions().sameOrigin();
	 * 
	 * return http.build(); }
	 */
	 
	   
	
		
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
       return (web) ->  web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**", "/swagger-ui/**", "/v3/api-docs/**");
    }
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean public static BCryptPasswordEncoder encoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	

}
