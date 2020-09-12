package gui.panel;

import javax.swing.*;
import java.awt.*;


import static util.GuiUtil.showPanel;

/**
 * 本面板同样采用BorderLayout,分居中和南面。
 * 居中使用的是JScrollPane，其中放着JTable。
 * 南面使用一个JPanel，里面放3个按钮。
 */
public class CategoryPanel extends WorkingPanel{
    public static CategoryPanel instance = new CategoryPanel();
    public JPanel center = new JPanel();
    public JPanel south = new JPanel();
    public JButton newName = new JButton("新增");
    public JButton edit = new JButton("编辑");
    public JButton del = new JButton("删除");
    public CategoryPanel() {
        add();
    }
    public void add(){
        String[] columnNames = new String[] { "分类名称","消费次数" };
        String[][] name = new String[][] { { "交通", "0" },
                { "住宿", "2"}, { "话费", "1" } };
        JTable table = new JTable(name,columnNames);
        JScrollPane sp = new JScrollPane(table);
        center.setLayout(new BorderLayout());
        center.add(sp);
        south.setLayout(new FlowLayout());
        south.add(newName);
        south.add(edit);
        south.add(del);
        setLayout(new BorderLayout());
        add(center,BorderLayout.CENTER);
        add(south,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        showPanel(instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
