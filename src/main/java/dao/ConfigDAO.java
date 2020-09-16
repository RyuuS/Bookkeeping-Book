package dao;
import entity.Config;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAO implements DAO<Config>{
    public static void main(String[] args) {

    }

    @Override
    public void add(Config config) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql = "insert into config values(null " + config.key + config.value + ")";
            s.execute(sql);
            ResultSet rs = s.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                config.id = id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Config config) {
        String sql = "update config set id= ?, value=? where key = ?";
        try (Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,config.id);
            ps.setString(2,config.key);
            ps.setString(3,config.value);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection c = DBUtil.getConnection();Statement s = c.createStatement()){
            String sql = "delete from config where id="+id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Config get(int id) {
        Config config = null;
        try (Connection c = DBUtil.getConnection();Statement s = c.createStatement()){
            String sql = "select * from config where id="+id;
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                config = new Config();
                String key = rs.getString(2);
                String value = rs.getString(3);
                config.key = key;
                config.value = value;
                config.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }
    //这个不太懂，全部显示？
    @Override
    public List<Config> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Config> list(int start, int count) {
        List<Config> configs = new ArrayList<Config>();
        String sql = "select * from config order by id desc limit ?,?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,start);
            ps.setInt(2,count);
            //ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                Config config = new Config();
                config.id = rs.getInt(1);
                config.key = rs.getString(2);
                config.value = rs.getString(3);
                configs.add(config);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
