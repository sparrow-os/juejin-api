package com.sparrow.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sparrow.utility.StringUtility;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    @Bean
    public DruidCustomPasswordCallback passwordCallback() {
        return new DruidCustomPasswordCallback();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    // @ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setPasswordCallback(passwordCallback());
        return druidDataSource;
    }
}