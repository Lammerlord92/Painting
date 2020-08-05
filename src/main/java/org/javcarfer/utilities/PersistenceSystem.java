package org.javcarfer.utilities;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public interface PersistenceSystem {
    public final String DBName = "painting";
}
