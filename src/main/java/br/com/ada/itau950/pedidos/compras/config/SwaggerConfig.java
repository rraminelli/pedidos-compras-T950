package br.com.ada.itau950.pedidos.compras.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pedidos Compras API")
                        .description("Lets Code - Itau T950")
                        .version("v0.0.1")
                );
    }

}
