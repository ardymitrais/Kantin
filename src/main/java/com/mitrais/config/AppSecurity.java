package com.mitrais.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mitrais.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MyUserDetailService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/*","/js/*","/images/*","/node/*").permitAll()
		.antMatchers("/home").authenticated()
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/pelanggan/**").hasAuthority("PELANGGAN")
		.and()
		.formLogin()
		.loginPage("/login").defaultSuccessUrl("/kantin/home").failureUrl("/login?error=true")
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll()
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").and().exceptionHandling()
		.accessDeniedPage("/access-denied");;
	}
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	}
}
