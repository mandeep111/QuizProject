package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class RoleBasedSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder());
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder());

		auth.authenticationProvider(provider);

		auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("adminPass"))
				.credentialsExpired(false).accountExpired(false).accountLocked(false).authorities("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				.antMatchers("/user/**").hasAnyAuthority("USER","ADMIN").antMatchers("/admin/**").hasAuthority("ADMIN")
				.antMatchers("/", "/registration", "/addUser").permitAll().anyRequest().authenticated().and()
				.formLogin().permitAll().and().logout().logoutUrl("/j_spring_security_logout")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID")

				.and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
		http.headers().frameOptions().disable();

	}

}
