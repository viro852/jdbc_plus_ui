package ru.ibs.framework.managers;

import ru.ibs.framework.utils.PropConsts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static DBManager dbManager = null;

    private PropManager propManager = PropManager.getPropManager();

    private DBManager(){

    }

    public static DBManager getDbManager(){
        if (dbManager==null){
            dbManager=new DBManager();
        }
        return dbManager;
    }

    public Connection getConnectionToDB() {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(
                    propManager.getProperty(PropConsts.DB_URL),
                    propManager.getProperty(PropConsts.DB_LOGIN),
                    propManager.getProperty(PropConsts.DB_PASSWORD)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
