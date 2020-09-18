package entity;

/**
 * 配置信息Config类与配置信息表config相对应
 * id 主键
 * key 键
 * value 值
 */
public class Config {
    public int id;
    public String key;
    public String value;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
