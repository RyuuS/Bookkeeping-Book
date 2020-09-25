package gui.listener;

import entity.Category;
import entity.Record;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import service.RecordService;
import util.GuiUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("触发了RecordPanel事件");
        RecordPanel p = RecordPanel.instance;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(0 == p.ccbm.cs.size()){
            JOptionPane.showMessageDialog(null,"暂无分类信息");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
        Category c = p.getSelectedCategory();
        if(!GuiUtil.checkZero(p.costText,"花费金额")){
            return;
        }
        System.out.println("加入成功xx");
        Record record = new Record();
        //Category c = p.getSelectedCategory();
        record.setSpend(Integer.parseInt(p.costText.getText()));
        System.out.println(c.name);
        record.setCid(c.id);
        try {
            System.out.println(p.dateText.getText());
            //这里需要吧String转sql date
            java.util.Date d = simpleDateFormat.parse(p.dateText.getText());
            java.sql.Date date = new java.sql.Date(d.getTime());
            record.setDate(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        record.setComment(p.remarksText.getText());
        new RecordService().add(record);
    }
}
