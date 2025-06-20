package com.ilan.config;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@ConditionalOnProperty(prefix = "spring", name = "enabled", havingValue = "true")
public class LiquibaseConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LiquibaseConfig.class);


    @Bean
    @ConditionalOnProperty(prefix = "spring", name = "liquibase.change-log")
    public SpringLiquibase liquibase(DataSource dataSource, @Value("spring.liquibase.change-log") String changeLogPath) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(changeLogPath);
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}
