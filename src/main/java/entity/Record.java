package entity;

import java.util.Date;

/**
 * 消费记录表 record 有如下字段：
 * id 主键，每个表都有一个主键 类型是 int
 * spend 本次花费，类型是int
 * cid 对应的消费分类表的中记录的id, 类型是int
 * comment 备注，比如分类是娱乐，但是你希望记录更详细的内容，啪啪啪，那么就存放在这里。
 * date 日期，本次记录发生的时间
 */
public class Record {
    public int id;
    public int spend;
    public int cid;
    public String comment;
    public Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpend() {
        return spend;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
