package dao;

import entity.Category;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
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
        Category category = null;
        String sql = "select * from category where id =" + id;
        try (Connection c = DBUtil.getConnection(); Statement s = c.prepareStatement(sql)){
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                category.id = rs.getInt(1);
                category.name = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Category> list(int start, int count) {
        List<Category> categories = new ArrayList<>();
        Category category = null;
        String sql = "select * from categories order by id desc limit ?,?";
        try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.getResultSet();
            /**
             * 测试区别
             * Category category1 = new Category();与Category category = null;
             * 只有使用new引用才能对对象进行操作。否则会空指针异常
             */
            while (rs.next()){
                category = new Category();
                category.id = rs.getInt(1);
                category.name = rs.getString(2);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
