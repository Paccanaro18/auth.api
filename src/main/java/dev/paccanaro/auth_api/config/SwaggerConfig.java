package dev.paccanaro.auth_api.config;

import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters() {
        SwaggerUiConfigParameters config = new SwaggerUiConfigParameters(new SwaggerUiConfigProperties());
        config.setSupportedSubmitMethods(List.of());
        return config;
    }
}
