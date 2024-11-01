package tpspring.tpbanque.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tpspring.tpbanque.Controller.CompteRestController;

@Configuration
public class MyConfig {
    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestController.class);
        return  jerseyServlet ;
    }
}
