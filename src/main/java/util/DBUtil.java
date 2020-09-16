package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 在每个DAO里自行创建Connnection，在这个项目里有多个DAO里都需要获取数据库的连接，
 * 并且在本项目中都是一样的数据库连接。 所以就可以把获取数据库连接的代码重构到一个类里。
 * 记得导入mysql数据连接包
 */
public class DBUtil {
    static Connection c = null;
    static String ip = "192.168.1.134";
    static String port = "3306";
    static String dbName = "bookkeeping";
    static String encode = "characterEncoding=UTF-8";
    static String loginName = "root";
    static String password = "root";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        //连接数据库
        //useSSL=false连接非本地数据库使用这个命令避免报错
        String url = String.format(
                "jdbc:mysql://%s:%s/%s?%s&useSSL=false",ip,port,dbName,encode);
        return DriverManager.getConnection(url,loginName,password);
    }
}
