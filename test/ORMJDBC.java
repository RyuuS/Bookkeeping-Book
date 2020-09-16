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
        Hero spider = new Hero("蜘蛛侠",300.0,500.0);
        //Hero.add(spider);
        //Hero.delete(10598);
        Hero.sel(10555);
    }
}
class Hero {
    //自增ID，所以id不需要了
    public int id;
    public String name;
    public double hp;
    public double damage;
    //hero对象插入数据库中
    public static void add(Hero h) {
        System.out.println("正则新加入英雄：" + h.name);
        JDBC.insert(h);
        JDBC.count();
    }
    //把这个Hero对象对应的数据删除掉
    public static void delete(int id){
        System.out.println("正在删除英雄ID: " + id);
        JDBC.del(id);
        JDBC.count();
    }
    //查找ID
    public static void sel(int id){
        System.out.println("正在查找英雄ID: " + id);
        JDBC.sel(id);
    }
    //更新
    public static void update(){

    }
    public Hero(String name, double hp, double damage) {
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
    static Statement ste;
    static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("数据库驱动加载成功");
            c = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.134:3306/bookkeeping?characterEncoding=UTF-8&useSSL=false"
                    , "root", "root");
            //System.out.println("连接成功，获取连接对象： " + c);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *PreparedStatement 无法处理多条sql语句
     *
     */
    static void insert(Hero h){
        try {
            String sql = "insert into hero values(null,?,?,?)";
            String check = "select * from hero t where t.id=(select last_insert_id())";//最后自增长的ID
            PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            Statement s = c.createStatement();
            ps.setString(1,h.name);
            ps.setDouble(2,h.hp);
            ps.setDouble(3,h.damage);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            h.id  = 0;
            if(rs.next()){
                h.id = rs.getInt(1);
                System.out.println("新加入英雄\"" + h.name + "\"ID是：" + h.id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //当前表中的数据总数
    static void count(){
        String sql = "select count(*) from hero";
        try {
            Statement s = c.createStatement();
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            if (rs.next()) System.out.println("当前一共有"+ rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除表中的数据
    static void del(int id){
        String sql = "delete from hero where id=" + id;
        try {
            Statement s = c.createStatement();
            s.execute(sql);
            System.out.println("删除ID：" + id + "英雄");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查找
    static void sel(int id){
        String sql = "select * from hero where id="+ id;
        try {

            ste = c.createStatement();
            ste.execute(sql);
            ResultSet rs = ste.getResultSet();
            while (rs.next()){
                int heroId = rs.getInt(1);
                String heroName = rs.getString(2);
                double heroHp = rs.getDouble(3);
                double heroDem = rs.getDouble(4);
                System.out.printf("ID: %d\n英雄：%s\n血量：%f\n伤害：%f",heroId,heroName,heroHp,heroDem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
