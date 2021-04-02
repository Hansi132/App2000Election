package com.app2000.electionbackend.util;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class AppConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
        webServerFactoryCustomizer() {
        return factory -> factory.setDisplayName("");
    }
}
