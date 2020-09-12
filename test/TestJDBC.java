import java.sql.*;

public class TestJDBC {
    static Connection c = null;
    static Statement s = null;

    public static void main(String[] args) {
        //初始化驱动
        init();
        try {
            /**
             * 插入
             *          * execute("insert into category values(null,'酒店')");
             *          * 查询
             *          *         String sql = "select * from category";
             * 打印数据表
             *             ResultSet rs = s.executeQuery(create_sql);
             *             while (rs.next()){
             *                 int id = rs.getInt("id");
             *                 String name = rs.getString(2);
             *                 System.out.printf("%d\t%s%n", id, name);
             */

            String name = "ryu";
            String password = "88480";

            String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
            String count = "select count(*) from hero";
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            if(rs.next())
                System.out.println("账号密码正确");
            else
                System.out.println("账号密码错误");
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void init () {
        try {
            //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.0.8-bin.jar中
            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
            /**
             建立与数据库的Connection连接
             这里需要提供：
             数据库所处于的ip:192.168.1.134 (ubuntu)
             数据库的端口号： 3306 （mysql专用端口号）
             数据库名称 bookkeeping
             编码方式 UTF-8
             账号 ryu
             密码 123
             */
            System.out.println("数据库驱动加载成功");
            c = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.134:3306/bookkeeping?characterEncoding=UTF-8&useSSL=false"
                    , "root", "root");
            System.out.println("连接成功，获取连接对象： " + c);
            // 注意：使用的是 java.sql.Statement
            s = c.createStatement();
            System.out.println("连接成功，获取连接对象： " + c);
            // 注意：使用的是 java.sql.Statement
            s = c.createStatement();
            System.out.println("获取 Statement对象： " + s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void execute(String sql){
        // 准备sql语句
        // 注意： 字符串要用单引号'
        //String sql = "insert into category values(null,'旅行')";
        //删除
        //String sql = "delete from category where id=15";
        //更新
        //sql = "update category set name='吃喝'where id=16";
        //执行sql语句
        try {
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

