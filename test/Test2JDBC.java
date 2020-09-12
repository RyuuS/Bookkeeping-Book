import java.sql.*;

/**
 * 分别插入5000条数据
 * 数据库驱动加载成功
 * 连接成功，获取连接对象： com.mysql.jdbc.JDBC4Connection@46fbb2c1
 * ps插入数据耗时199s
 * s插入数据耗时231s
 */
public class Test2JDBC {
    static Connection c = null;
    public static void main(String[] args) {
        init();
        String sql = "insert into hero values(null,?,?,?)";
        //list(0,5);
        //insert(sql);
        inf();

    }
    //tart 表示开始页数，count表示一页显示的总数
    //list(0,5) 表示第一页，一共显示5条数据
    //list(10,5) 表示第三页，一共显示5条数据
    public static void list(int start, int count){
        try {
            //两种sql，分别用Statement和PreparedStatement
            String psQuery = "select * from hero limit ?,?";
            String sQuery = "select * from hero limit " + start + "," + count;
            //ps使用executeQueryq获取返回数据
            PreparedStatement ps = c.prepareStatement(psQuery);
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                double dem = rs.getDouble(4);
                System.out.printf("%d\t%s\t%f\t%f\t",id,name,hp,dem);
                System.out.println();
            }
            //Statement使用execute+getResultSet获取返回数据
            System.out.println("另一种方式");
            Statement s2 = c.createStatement();
            s2.execute(sQuery);
            ResultSet rs_2 = s2.getResultSet();
            while (rs_2.next()) {
                int id = rs_2.getInt(1);
                String name = rs_2.getString(2);
                float hp = rs_2.getFloat(3);
                double dem = rs_2.getDouble(4);
                System.out.printf("%d\t%s\t%f\t%f\t",id,name,hp,dem);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //插入语句
    public static void insert(String sql){

        try {
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"钢铁侠");
            ps.setFloat(2,500.0f);
            ps.setFloat(3,45.0f);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取表的元数据
    public static void inf(){
        DatabaseMetaData dbmd = null;
        try {
            dbmd = c.getMetaData();
            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());

            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();

            while (rs.next()) {
                System.out.println("数据库名称:\t"+rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
            c = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.134:3306/bookkeeping?characterEncoding=UTF-8&useSSL=false"
                    , "root", "root");
            System.out.println("连接成功，获取连接对象： " + c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //数据插入，PreparedStatement插入
    public static String exeSql(String sql){
        long start = System.currentTimeMillis();
        // 根据sql语句创建PreparedStatement
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            for (int i = 0; i < 5000 ; i++) {
                ps.setString(1,"ps英雄" + i);
                ps.setFloat(2,313.0f);
                ps.setFloat(3,45.0f);
                ps.execute();
            }
        long end = System.currentTimeMillis();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return "ps插入数据耗时" + (end-start)/1000 + "s";
    }
    //数据插入,Statement插入
    public static String sInsert() throws SQLException {
        long start = System.currentTimeMillis();
        String sql = "insert into hero values(null,'s英雄',234.0,66)";
        Statement s = c.createStatement();
        for (int i = 0; i < 5000; i++) {
            s.execute(sql);
        }
        long end = System.currentTimeMillis();
        return "s插入数据耗时" + (end-start)/1000 + "s";

    }
}
