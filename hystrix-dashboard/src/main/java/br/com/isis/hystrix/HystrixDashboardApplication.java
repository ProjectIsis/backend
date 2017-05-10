package br.com.isis.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableOAuth2Sso
@Controller
public class HystrixDashboardApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "forward:/hystrix";
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.logout()
				.and().authorizeRequests()
				.anyRequest().authenticated()
				.and().csrf().disable();
		// @formatter:on
	}
}
