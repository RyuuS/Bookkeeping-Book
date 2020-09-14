package dao;
import entity.Config;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigDAO {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        try (Connection c = dbUtil.getConnection();
             Statement s = c.createStatement()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
