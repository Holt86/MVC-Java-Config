package ru.mvc.configuration;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * Created by User on 30.01.2019.
 */

@Configuration
//@ComponentScan(basePackages = {"ru.mvc.configuration"})
public class DBConfiguration {

    @Autowired
    private DataSource dataSource;

    @Profile("h2")
    @Bean(name = "dataSource")
    public DataSource getDataSourceH2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // определяем конфигурацию подключения
        dataSource.setUrl("jdbc:h2:file:D:/temp/H2/Jooq-H2");
        dataSource.setDriverClassName("org.h2.Driver");
        return dataSource;
    }

    @Profile("postgres")
    @Bean(name = "dataSource")
    public DataSource getDataSourcePostgres() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // определяем конфигурацию подключения
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Joog");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(getDataSourcePostgres());
    }

    @Bean(name = "transactionAwareDataSource")
    public TransactionAwareDataSourceProxy getTransactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(getDataSourcePostgres());
    }

    @Bean(name = "connectionProvider")
    public DataSourceConnectionProvider getConnectionProvider() {
        return new DataSourceConnectionProvider(getTransactionAwareDataSource());
    }

    @Bean(name = "dslConfig")
    public org.jooq.Configuration getDslConfig() {
        DefaultConfiguration config = new DefaultConfiguration();
        // используем диалект SQL СУБД Firebird
        config.setSQLDialect(SQLDialect.H2);
        config.setConnectionProvider(getConnectionProvider());
//        DefaultExecuteListenerProvider listenerProvider = new DefaultExecuteListenerProvider(getExceptionTranslator());
//        config.setExecuteListenerProvider(listenerProvider);
        return config;
    }

    @Bean(name = "dsl")
    public DSLContext getDsl() {
        org.jooq.Configuration config = this.getDslConfig();
        return new DefaultDSLContext(config);
    }


}
