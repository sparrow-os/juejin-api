package com.sparrow.config;
import com.alibaba.druid.pool.DruidDataSource;
import com.sparrow.utility.StringUtility;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.SQLException;
 
@Configuration
public class DataSourceConfig {
    /** 
     * 使用此配置类向容器中添加了 Druid 数据源对象。
     * 
     * 我们一般不建议使用下面方式 将数据源属性硬编码到代码中
     *   druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tyut");
     *   druidDataSource.setUsername("root");
     *   druidDataSource.setPassword("root");
     *   druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
     * 建议使用注解@ConfigurationProperties与配置文件中进行绑定
     * 它将配置文件中 spring.datasource 开头的配置与数据源中的属性进行绑定
     * 
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        String envPasswordKey = "mysql_sparrow_password";
        String password = System.getenv(envPasswordKey);
        if(StringUtility.isNullOrEmpty(password)) {
            druidDataSource.setPassword(password);
        }
        return druidDataSource;
    }
}