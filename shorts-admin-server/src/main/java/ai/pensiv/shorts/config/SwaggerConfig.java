package shorts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ConfigurationProperties("swagger")
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.api.title}")
    private String API_TITLE;

    @Value("${swagger.api.description}")
    private String API_DESCRIPTION;

    @Value("${swagger.api.url}")
    private String API_URL;

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ai.pensiv.shorts.controller"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build();
//                .securitySchemes(Collections.singletonList(new BasicAuth("xBasic")))
//                .securityContexts(Collections.singletonList(xBasicSecurityContext()))
//                .apiInfo(apiInfo());
    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title(API_TITLE)
//                .description(API_DESCRIPTION)
//                .termsOfServiceUrl(API_URL)
//                .build();
//    }
//
//    private SecurityContext xBasicSecurityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Collections.singletonList(new SecurityReference("xBasic", new AuthorizationScope[0])))
//                .build();
//    }

}
