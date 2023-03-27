package gov.iti.jets.ecommerce.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@OpenAPIDefinition
@Configuration
public class SpringDocConfig {


    @Bean
    public OpenAPI baseOpenApi() {
        return new OpenAPI()
                .info(new Info().title("E-commerce doc")
                        .version("1.0.0")
                        .description("spring doc"));
    }
}