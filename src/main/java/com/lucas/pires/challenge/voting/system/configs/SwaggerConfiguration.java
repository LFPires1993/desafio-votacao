package com.lucas.pires.challenge.voting.system.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SwaggerConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public OpenAPI openAPI() {
        String contactName = environment.getProperty("springdoc.documentation.swagger.v2.api.info.contact.name");
        String contactEmail = environment.getProperty("springdoc.documentation.swagger.v2.api.info.contact.email");
        Contact contact = new Contact()
                .name(contactName)
                .email(contactEmail)
                .url("");

        return new OpenAPI()
                .info(new Info()
                        .title(environment.getProperty("springdoc.documentation.swagger.v2.api.info.title"))
                        .description(environment.getProperty("springdoc.documentation.swagger.v2.api.info.description"))
                        .contact(contact)
                        .version(environment.getProperty("springdoc.documentation.swagger.v2.api.info.version")));
    }
}
