package com.sparrow.config;

import com.alibaba.druid.util.DruidPasswordCallback;
import com.sparrow.utility.StringUtility;

import java.util.Properties;


public class DruidCustomPasswordCallback extends DruidPasswordCallback {

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String envPasswordKey = "mysql_sparrow_password";
        String password = System.getenv(envPasswordKey);
        if (!StringUtility.isNullOrEmpty(password)) {
            this.setPassword(password.toCharArray());
        }
    }
}
