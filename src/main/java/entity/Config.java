package entity;

/**
 * 配置信息Config类与配置信息表config相对应
 * id 主键
 * key 键
 * value 值
 */
public class Config {
    public int id;
    public String ket;
    public String value;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
