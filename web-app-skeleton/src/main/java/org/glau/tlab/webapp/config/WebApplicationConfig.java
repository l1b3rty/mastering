package org.glau.tlab.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(value = {
    PersistenceConfig.class
})
@ComponentScan(value = "org.glau.tlab.webapp")
@PropertySource("classpath:application.properties")
@EnableWebMvc
@EnableTransactionManagement
class WebApplicationConfig { }
