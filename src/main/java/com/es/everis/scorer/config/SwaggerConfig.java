package com.es.everis.scorer.config;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.es.everis.scorer.utils.RestConstants;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("TicTacToe").apiInfo(apiInfo())
        .select().paths(regex(".*" + RestConstants.APPLICATION_NAME + "/.*")).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("TicTacToe").description("TicTacToe Api")
        .termsOfServiceUrl("https://www.everis.com").license("everis")
        .licenseUrl("https://www.everis.com").version("1.0").build();
  }
}
