package br.com.isis.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer
@EnableOAuth2Sso
public class ServiceDiscoveryApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryApplication.class, args);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.logout()
				.and().authorizeRequests()
				.antMatchers("/").authenticated()
				.anyRequest().permitAll()
				.and().csrf().disable();
		// @formatter:on
	}
}
