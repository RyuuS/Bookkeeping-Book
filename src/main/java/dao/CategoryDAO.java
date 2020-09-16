package dao;

import entity.Category;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements DAO<Category> {
    @Override
    public void add(Category category) {
        String sql ="insert into category values (null,?)";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,category.name);
            //ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                category.id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        String sql ="update category set name = ? where id = ?";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,category.name);
            ps.setInt(2,category.id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        //测试
        String sql ="delete from category where id = ?";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        return null;
    }

    @Override
    public List<Category> list() {
        return null;
    }

    @Override
    public List<Category> list(int start, int count) {
        return null;
    }
}
