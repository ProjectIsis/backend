package br.com.isis.apigateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

/**
 * Created by gaspar on 08/05/2017.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
class ApiGetewayApplication

    fun main(args: Array<String>) {
        SpringApplication.run(ApiGetewayApplication::class.java, *args)
    }
