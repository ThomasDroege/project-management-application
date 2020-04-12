package com.thomas.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.usersByUsernameQuery("select username, password, enabled " +
		"from user_accounts where username = ?")
		.authoritiesByUsernameQuery("select username, role "+
		"from user_accounts where username = ?")
		.dataSource(dataSource)
		.passwordEncoder(bCryptEncoder);
		
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		// hasRole: the same like hasAuthority, with the difference that you need to write role = 'ROLE_ADMIN' instead of
		// role = 'ADMIN' as SQL Statement
		//.antMatchers("/projects/new").hasRole("ADMIN")
		
		
		.antMatchers("/projects/new").hasAuthority("ADMIN")
		.antMatchers("/projects/save").hasAuthority("ADMIN")
		.antMatchers("/employees/new").hasAuthority("ADMIN")
		.antMatchers("/employees/save").hasAuthority("ADMIN")
		.antMatchers("/","/**").permitAll()
		.and()
		.formLogin();
		
		
		http.csrf().disable();
	}
}
