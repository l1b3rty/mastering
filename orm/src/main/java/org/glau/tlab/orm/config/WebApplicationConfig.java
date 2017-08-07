package org.glau.tlab.orm.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(value = {
    PersistenceConfig.class
})
@ComponentScan(value = "org.glau.tlab.orm")
@PropertySource("classpath:application.properties")
@EnableWebMvc
@EnableTransactionManagement
class WebApplicationConfig { }
