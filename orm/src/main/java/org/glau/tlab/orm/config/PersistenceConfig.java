package org.glau.tlab.orm.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
class PersistenceConfig {

    @Value("${app.persistence.jdbc.driverClassName}")
    private String driverClass;
    @Value("${app.persistence.jdbc.url}")
    private String url;
    @Value("${app.persistence.jdbc.username}")
    private String username;
    @Value("${app.persistence.jdbc.password}")
    private String password;
    @Value("${app.persistence.pool.initialSize:3}")
    private int poolInitialSize;
    @Value("${app.persistence.pool.maxActiveConnections:3}")
    private int poolMaxActiveConnections;
    @Value("${app.persistence.pool.maxIdleConnections:1}")
    private int poolMaxIdleConnections;

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClass);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(url);
        basicDataSource.setInitialSize(poolInitialSize);
        basicDataSource.setMaxActive(poolMaxActiveConnections);
        basicDataSource.setMaxIdle(poolMaxIdleConnections);

        return basicDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setDataSource(dataSource());
        emfb.setPackagesToScan("org.glau.tlab.orm");
        emfb.setJpaProperties(jpaVendorProperties());

        return emfb;
    }

    private Properties jpaVendorProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL91Dialect");
        properties.setProperty("show_sql", "true");
        return properties;
    }

}
