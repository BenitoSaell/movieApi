package com.benitosaell.movieapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers("/api/publico/peliculas","/api/publico/ver/**","/api/publico/comentarios/**")
		.permitAll()
		.antMatchers("/api/publico/crear", "/login")
		.permitAll()
		.antMatchers("/api/peliculas/peliculas","/api/peliculas/crear","/api/peliculas/ver/**","/api/peliculas/eliminar/**","/api/comentarios/**", "/api/usuarios/**","/api/admin/user","/api/admin/salir").authenticated()
		.and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	// Crea el encriptador de contraseñas
	@Bean
	public static PasswordEncoder passwordEncoder() {
	      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	    return source;
	  }
}
