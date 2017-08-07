package org.glau.tlab.webapp.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(value = {
    PersistenceConfig.class
})
@ImportResource("WEB-INF/test.xml")
@ComponentScan(value = "org.glau.tlab.webapp")
@PropertySource("classpath:application.properties")
@EnableWebMvc
@EnableTransactionManagement
class WebApplicationConfig {

    @Bean
    public String uselessBean() {
        return "Dumb--------";
    }

    @Bean String anotherUselessBean() {
        return "123";
    }



}
