import java.sql.*;

/**
 * 把一个Hero对象插入到数据库中
 * public static void add(Hero h)
 * 把这个Hero对象对应的数据删除掉
 * public static void delete(Hero h)
 * 更新这条Hero对象
 * public static void update(Hero h)
 * 把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
 * public static List<Hero> list();
 */
public class ORMJDBC {
    public static void main(String[] args) {
        new JDBC();
        Hero spider = new Hero(1,"蜘蛛侠",500.0,1000);
        Hero.add(spider);
    }

}
class Hero {
    public int id;
    public String name;
    public double hp;
    public double damage;
    //hero对象插入数据库中
    public static void add(Hero h) {
        JDBC.insert(h);
    }

    public Hero(int id, String name, double hp, double damage) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
}
class JDBC {
    public JDBC() {
        init();
    }
    static Connection c = null;
    static void init(){
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
    static void insert(Hero h){
        try {
            String sql = "insert into hero values(null,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,h.name);
            ps.setDouble(2,h.hp);
            ps.setDouble(3,h.damage);
            ps.execute(sql);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            while(rs.next()){
                id = rs.getInt(1);
            }
            System.out.println("新加入英雄" + h.name + "ID是：" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
