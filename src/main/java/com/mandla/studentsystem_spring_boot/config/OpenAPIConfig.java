/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author mlots
 */

@Configuration
public class OpenAPIConfig {
    @Value("$mandla.openapi.dev-url")
    private String devUrl;
    
    @Bean
    public OpenAPI OpenAPI(){
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development Environment");
        
        Contact contact = new Contact();
        contact.setEmail("mmlotshwa@gmail.com");
        contact.setName("Mandla Mlotshwa");
        
        License license = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
        Info info = new Info()
                .title("Student System APIs")
                .version("1.0")
                .contact(contact)
                .description("This API exposes all endpoints for the Student System")
                .license(license);
        
        return new OpenAPI().info(info);
    }
}
