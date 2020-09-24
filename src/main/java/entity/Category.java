package entity;

/**
 * 消费分类
 * id 主键，每个表都有一个主键 类型是 int
 * name分类的名称，类型是varchar(255)
 * 新加入recordNumber
 */
public class Category {
    public int id;
    public String name;
    public int recordNumber;

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

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

    //这里需要toString。因为下拉框获取的是当前对象的toString的返回值
    @Override
    public String toString() {
        return name;
    }
}
