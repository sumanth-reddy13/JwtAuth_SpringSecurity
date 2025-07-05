package com.example.SpringSecurityDemo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(                                    // Provides general information about the API.
                contact = @Contact(
                        name = "Alibou",
                        email = "contact@aliboucoding.com",
                        url = "https://aliboucoding.com/course"
                ),
                description = "OpenApi documentation for Spring Security",
                title = "OpenApi specification - Alibou",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {                                     // Specifies the servers where the API is hosted.
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://aliboucoding.com/course"
                )
        },
        security = {                                    // Security requirements for the API
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(                                        // Defines the security scheme details in the API.
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
