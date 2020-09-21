package gui.panel;

import dao.CategoryDAO;
import entity.Category;

import javax.swing.*;
import java.awt.*;
import java.util.List;


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
//        String[] columnNames = new String[] { "分类名称","消费次数" };
//        String[][] name = new String[][] { { "交通", "0" },
//                { "住宿", "2"}, { "话费", "1" } };
//        JTable table = new JTable(name,columnNames);
//        JScrollPane sp = new JScrollPane(table);
        //按钮设置命令监听
        newName.setActionCommand("newName");
        edit.setActionCommand("edit");
        del.setActionCommand("del");
        JScrollPane sp = null;
        display(sp);
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
    //显示内容数据库中的分类名称和消费次数
    public void display(JScrollPane sp){
        CategoryDAO dao = new CategoryDAO();
        String[] colName = new String[]{"分类名称","消费次数"};
        String[][] col = new String[dao.getRow()][2];
        List<Category> list = dao.list(0,10);
        int j = 0;
        if(!list.isEmpty()){
            for(Category x:list){
                col[j][0] = x.name;
                col[j][1] = String.valueOf(dao.getCount(x.id));
            }
        }
        JTable table = new JTable(col,colName);
        sp = new JScrollPane(table);
    }
}
