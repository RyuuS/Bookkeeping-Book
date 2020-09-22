package gui.listener;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("触发了CategoryPanel事件");
        CategoryPanel p = CategoryPanel.instance;
        JButton b =(JButton) e.getSource();
        if(b == p.newName){
            //点击新增按钮
            System.out.println("触发了add事件");
            String name = JOptionPane.showInputDialog(null);
            if(0 == name.length()){
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
            new CategoryService().add(name);
        }else if(p.edit == b){
            //点击编辑按钮
            System.out.println("触发了edit事件");
            Category c = p.getSelectedCategory();
            int id = c.id;
            String name = JOptionPane.showInputDialog("修改分类名称",c.name);
            if(0 == name.length()){
                JOptionPane.showMessageDialog(p,"分类名称不能为空");
                return;
            }
            new CategoryService().update(id,name);

        } else if(p.del == b){
            //点击删除按钮
            System.out.println("触发了del事件");
            Category c = p.getSelectedCategory();
            int id = c.id;
            JOptionPane.showConfirmDialog(p, "是否删除？" + c.name);
            new CategoryService().del(id);
        }
        p.updateData();

    }
}
