package com.sparrow.boot;

import com.sparrow.datasource.DataSourceValidChecker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.sql.DataSource;

@RestController
@RequestMapping("health")
public class HealthController {
    @Inject
    private DataSource dataSource;
    @RequestMapping("ds")
    public String dataSourceCheck() {
        DataSourceValidChecker connectionValidChecker = new ConnectionValidCheckerAdapter();
        try {
            connectionValidChecker.isValid(dataSource);
            return "OK";
        } catch (Exception e) {
            return this.dataSource.toString();
        }
    }
}
