package com.ilan.config;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class LiquibaseConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LiquibaseConfig.class);


   /* @Bean
    @ConfigurationProperties(prefix = "spring.liquibase")
    public SpringLiquibase springLiquibase(DataSource dataSource) {
        return new SpringLiquibase();
    }*/
}
