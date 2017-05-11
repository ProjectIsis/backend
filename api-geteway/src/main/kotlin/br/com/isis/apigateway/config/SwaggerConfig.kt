package br.com.isis.apigateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by gaspar on 10/05/2017.
 */
@EnableSwagger2
@Configuration
class SwaggerConfig {

    @Bean
    fun newsApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("ProjectIsis")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Gateway Service with Swagger")
                .description("Documentation of all endpoints of the gateway service")
                .version("1.0")
                .build()
    }

}