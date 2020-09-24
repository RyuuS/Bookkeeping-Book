package gui.listener;

import entity.Category;
import entity.Record;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.RecoverPanel;
import service.RecordService;
import util.GuiUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("触发了RecordPanel事件");
        RecordPanel p = RecordPanel.instance;
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
        record.setDate(p.dateText.getText());
        record.setComment(p.remarksText.getText());
        new RecordService().add(record);
    }
}
