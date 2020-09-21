package entity;

/**
 * 消费分类
 * id 主键，每个表都有一个主键 类型是 int
 * name分类的名称，类型是varchar(255)
 */
public class Category {
    public int id;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
