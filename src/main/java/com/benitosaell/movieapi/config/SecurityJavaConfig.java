package com.benitosaell.movieapi.config;


/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/


public class SecurityJavaConfig /*extends WebSecurityConfigurerAdapter*/ {
	/*@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("user").password("password").roles("USER"); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		 
         
		 http.httpBasic().and().csrf().disable() 
		    .authorizeRequests().antMatchers("/api/**").permitAll()
		    .and().formLogin().permitAll() 
		    .and().logout().permitAll().logoutUrl("/logout") 
		    .logoutSuccessUrl("/"); 
	}
	
	@Override 
    @Bean 
    public AuthenticationManager authenticationManagerBean() throws Exception { 
    return super.authenticationManagerBean(); 
    } 
	 
	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}*/
}
