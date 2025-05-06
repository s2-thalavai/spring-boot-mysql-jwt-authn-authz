package com.sivasankar.spring_boot_mysql_jwt_authn_authz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sivasankar.spring_boot_mysql_jwt_authn_authz.security.filter.JwtFilter;
import com.sivasankar.spring_boot_mysql_jwt_authn_authz.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;

	// Defines a UserDetailsService bean for user authentication
	@Bean
	UserDetailsService userDetailsService() {
		return new UserService();
	}

	private static final String[] PUBLIC_URLS = { "/admin/register", "/admin/verify", "/admin/login",
			"/employee/register", "/employee/verify", "/employee/login", "/vendor/register", "/vendor/verify",
			"/vendor/login" };

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.cors(Customizer.withDefaults()) // Apply CORS
				.csrf(csrf -> csrf.disable()) // Disable CSRF protection
				.authorizeHttpRequests(
						requests -> requests.requestMatchers("/actuator/**").authenticated().anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider()) // Register the authentication provider
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Add the JWT filter before
				.build();
	}

	// Creates a DaoAuthenticationProvider to handle user authentication
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	// Defines a PasswordEncoder bean that uses bcrypt hashing by default for
	// password encoding
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	// Defines an AuthenticationManager bean to manage authentication processes
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}