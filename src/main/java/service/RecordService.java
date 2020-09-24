package service;

import dao.RecordDAO;
import entity.Record;

import java.util.List;

public class RecordService {
    RecordDAO recordDAO = new RecordDAO();
    public void add(Record record){
        recordDAO.add(record);
    }
}
