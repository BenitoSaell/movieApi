package com.benitosaell.movieapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.benitosaell.movieapi.service.IUsersService;

@Configuration
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, status from users where username=?")
		.authoritiesByUsernameQuery("select username, rol from authorities where username=?")
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
        //HTTP Basic authentication
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/api/publico/**").permitAll()
        .antMatchers("/api/comentarios/**").hasRole("USER")
        .antMatchers("/api/peliculas/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();*/
		
		http.authorizeRequests()
		.antMatchers("/api/publico/**")
		.permitAll()
		.antMatchers("/api/peliculas/**","/api/comentarios/**", "/api/usuarios/**").authenticated()
		.and().formLogin();
	}

	//BCryptPasswordEncoder bCryptPasswordEncoder;

	// Crea el encriptador de contraseñas
	@Bean
	public static PasswordEncoder passwordEncoder() {
	      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
