package org.openapitools.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "org.openapitools.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Système de gestion de tickets - UQAC")
                                .description("API REST pour la gestion de tickets (Lab 4 - Architecture des logiciels). Permet aux utilisateurs de créer, consulter, et mettre à jour des tickets, et aux administrateurs de les assigner, commenter ou fermer. ")
                                .version("1.0.0")
                )
        ;
    }
}