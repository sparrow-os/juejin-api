//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sparrow.boot;

import com.sparrow.datasource.DataSourceValidChecker;
import com.sparrow.utility.JDBCUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionValidCheckerAdapter implements DataSourceValidChecker {
    private static Logger logger = LoggerFactory.getLogger(ConnectionValidCheckerAdapter.class);

    public ConnectionValidCheckerAdapter() {
    }

    public boolean isValid(DataSource dataSource, String query, int validationQueryTimeout) throws Exception {
        if (query != null && query.length() != 0) {
            Statement stmt = null;
            ResultSet rs = null;
            Connection connection = null;

            boolean var7;
            try {
                connection = dataSource.getConnection();
                logger.info("used datasource" + dataSource);
                stmt = connection.createStatement();
                if (validationQueryTimeout > 0) {
                    stmt.setQueryTimeout(validationQueryTimeout);
                }

                rs = stmt.executeQuery(query);
                var7 = true;
            } finally {
                JDBCUtils.close(rs);
                JDBCUtils.close(stmt);
            }

            return var7;
        } else {
            return true;
        }
    }

    public boolean isValid(DataSource dataSource) throws Exception {
        logger.info("before valid datasource {}", dataSource);
        boolean isValid = this.isValid(dataSource, "select 1", 3000);
        logger.info("is valid {}", isValid);
        return isValid;
    }
}
