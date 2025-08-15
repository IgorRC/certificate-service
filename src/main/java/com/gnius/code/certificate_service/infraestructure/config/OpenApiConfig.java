package com.gnius.code.certificate_service.infraestructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI (Swagger) configuration.
 *
 * <p>Provides API documentation metadata and enables Swagger UI at
 * {@code /swagger-ui/index.html}.</p>
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI certificateServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Certificate Management API")
                        .description("API documentation for managing companies, certificates, and users.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Igor Ramos Cruzado")
                                .email("igor.ramos.cruzado.w@gmail.com")
                                .url("www.linkedin.com/in/igor-rc"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                        .termsOfService("https://tuempresa.com/terms")
                );
    }
}
