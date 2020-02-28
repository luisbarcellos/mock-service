package br.com.sgq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiIncidente() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .consumes(getContentType())
                .produces(getContentType())
                .apiInfo(apiInfo());
    }

    private Set<String> getContentType() {
        final HashSet<String> mediaType = new HashSet<>();
        mediaType.add(MediaType.APPLICATION_JSON_UTF8_VALUE);
        return mediaType;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Documentação do serviço de incidentes e problemas.",
                null,
                "API 1.0.0",
                null,
                null,
                null,
                null,
                Collections.emptyList()
        );
    }
}