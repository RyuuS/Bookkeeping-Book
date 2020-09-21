package gui.listener;

import gui.panel.CategoryPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("触发了CategoryPanel事件");
        CategoryPanel p = CategoryPanel.instance;
        if(p.newName.getActionCommand().equals("newName")){
            //点击新增按钮，新弹出一个窗口
        }else if(p.newName.getActionCommand().equals("edit")){
            //点击编辑按钮

        } else if(p.newName.getActionCommand().equals("del")){
            //点击删除按钮
        }
    }
}
