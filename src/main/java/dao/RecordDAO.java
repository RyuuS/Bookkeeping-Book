package dao;

import entity.Record;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDAO implements DAO<Record>{
    @Override
    public void add(Record record) {
        String sql = "insert into record values (null,?,?,?,?)";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,record.spend);
            ps.setInt(2,record.cid);
            ps.setString(3,record.comment);
            ps.setString(4,record.date);
            ps.execute();
            //修改加入新对象的ID
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                record.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Record record) {
        //sql语法还未测试
        String sql = "update record set cid = ?,spend=?,comment=?,date=? where id=?";
        try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,record.cid);
            ps.setInt(2,record.spend);
            ps.setString(3,record.comment);
            ps.setString(4,record.date);
            ps.setInt(5,record.id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql = "delete from record where id="+ id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Record get(int id) {
        Record record = new Record();
        String sql = "select * from record where id=?";
        try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.execute(sql);
            //测试PreparedStatement下的getResultSet和executeQuery
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                record.cid = rs.getInt("cid");
                record.spend = rs.getInt("spend");
                record.comment = rs.getString("comment");
                record.date = rs.getString("date");
                record.id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Record> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Record> list(int start, int count) {
        List<Record> records = new ArrayList<>();
        Record record = new Record();
        String sql = "select * from record order by id desc limit ?,?";
        try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,start);
            ps.setInt(2,count);
            ps.execute(sql);
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                record.id = rs.getInt("id");
                record.cid = rs.getInt("cid");
                record.spend = rs.getInt("spend");
                record.comment = rs.getString("comment");
                record.date = rs.getString("date");
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Record> list(int cid) {
        List<Record> records = new ArrayList<Record>();

        String sql = "select * from record where cid = ?";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, cid);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Record record = new Record();
                int id = rs.getInt("id");
                int spend = rs.getInt("spend");

                String comment = rs.getString("comment");
                String date = rs.getString("date");

                record.spend=spend;
                record.cid=cid;
                record.comment=comment;
                record.date=date;
                record.id = id;
                records.add(record);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return records;
    }
}
