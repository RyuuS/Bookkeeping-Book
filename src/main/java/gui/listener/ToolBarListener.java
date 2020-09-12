package gui.listener;

import gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 主界面的一个事件类，主要处理对应主界面的7个按钮(有一个报表模块没有写)
 */
public class ToolBarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.home){
            p.workingPanel.show(SpendPanel.instance);
        }
        if (b == p.record){
            p.workingPanel.show(RecordPanel.instance);
        }
        if (b == p.category){
            p.workingPanel.show(CategoryPanel.instance);
        }
        if (b == p.config){
            p.workingPanel.show(ConfigPanel.instance);
        }
        if (b == p.backup){
            p.workingPanel.show(Backup.instance);
        }
        if (b == p.restore){
            p.workingPanel.show(RecoverPanel.instance);
        }
        
    }
}
