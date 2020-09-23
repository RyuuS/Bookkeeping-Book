package service;

import dao.RecordDAO;
import entity.Record;

import java.util.List;

public class RecordService {
    RecordDAO recordDAO = new RecordDAO();
    public List<Record> list(){
        List<Record> records = recordDAO.list();
        return records;
    }
    public void add(Record record){
//        record.setSpend(record.cid);
//        record.setSpend(record.spend);
//        record.setComment(record.comment);
//        record.setDate(record.date);
        recordDAO.add(record);
    }
}
