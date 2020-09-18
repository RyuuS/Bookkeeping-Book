package gui.listener;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GuiUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("触发了ConfigPanel事件");
        ConfigPanel p  = ConfigPanel.instance;
        //checkEmpty方法设置了弹窗。触发之后此次事件结束
        if(GuiUtil.checkEmpty(p.budText,"本月预算")){
            return;
        }
        String mysqlPath = p.srcText.getText();
        if(mysqlPath.length() != 0){
            File commandFile = new File(mysqlPath,"bin/mysql.exe");
            if(!commandFile.exists()){
                JOptionPane.showMessageDialog(p, "路径不正确");
                p.srcText.grabFocus();
                return;
            }
        }
        ConfigService cs = new ConfigService();
        //System.out.println(p.budText.getText());
        cs.update(ConfigService.budget, p.budText.getText());
        cs.update(ConfigService.mysqlPath, mysqlPath);
        JOptionPane.showMessageDialog(p, "修改成功");
    }
}
