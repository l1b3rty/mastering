package org.glau.tlab.webapp.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

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
    @Autowired
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL91Dialect");

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("org.glau.tlab.webapp.model");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(DataSource dataSource,
                                                                   SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource);
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }

}
