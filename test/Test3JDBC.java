import java.sql.*;
import java.util.Scanner;

public class Test3JDBC {
    static Connection c = null;
    public static void main(String[] args) {
        init();
        String sql = "insert into hero values(null,?,?,?)";
        //getID(sql);
        deleteTen();
    }
    //数据库连接
    public static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
            c = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.134:3306/bookkeeping?characterEncoding=UTF-8&useSSL=false"
                    , "root", "root");
            System.out.println("连接成功，获取连接对象： " + c);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除表中前10条数据
     * 是否要删除数据(Y/N)
     * 如果用户输入Y，则删除
     * 如果输入N则不删除。
     * 如果输入的既不是Y也不是N，则重复提示
     */
    public static void deleteTen(){
        String sql = "DELETE FROM hero ORDER BY id ASC LIMIT 1";
        try {
            Statement s = c.createStatement();
            s.execute("select id from hero order by id asc limit 0,10 ");
            ResultSet rs = s.getResultSet();
            while (rs.next()){
                System.out.println("试图删除" + rs.getInt("id"));
            }
            c.setAutoCommit(false);
            s.execute(sql);
            System.out.println("是否要删除数据(Y/N)");
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String input = sc.next();
                if(input.equals("Y")) {
                    c.commit();
                    System.out.println("已删除");
                    break;
                }
                else if(input.equals("N")) {
                    System.out.println("表未发生改变");
                    break;
                }
                else{
                    System.out.println("是否要删除数据(Y/N)");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 当插入一条数据之后，通过获取自增长id，得到这条数据的id，比如说是55.
     * 删除这条数据的前一条，54.
     * 如果54不存在，则删除53，以此类推直到删除上一条数据。
     *
     */
    public static void getID(String sql){
        try {
            Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "船长");
            ps.setFloat(2, 3130f);
            ps.setInt(3, 100);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("刚刚插入数据的id是:" + id);
            }
            int temp = id - 1;
            String sql_delete = "delete from hero where id =" + temp;
            while (true) {
                // 查询上一条数据是否存在
                ResultSet rs1 = s.executeQuery("select id from hero where id =" + temp);
                if (rs1.next()) {
                    System.out.println("id = " + temp + "数据存在");
                    s.execute(sql_delete);
                    System.out.println("id = " + temp + "该数据已删除");
                    break;
                } else
                    temp--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
