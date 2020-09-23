package gui.panel;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import service.RecordService;
import util.GuiUtil;
import static util.GuiUtil.showPanel;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
public class RecordPanel extends WorkingPanel{
    /**
     * 这个面板采用BorderLayout 分为北面和中间。
     * 北面是一个JPanel，中间也是一个JPanel。
     * 北面的JPanel使用4行2列的 GridLayout。
     *
     * 中间的JPanel使用默认的FlowLayout,
     */
    public static RecordPanel instance = new RecordPanel();
    public JLabel cost = new JLabel("花费($）");
    public JTextField costText = new JTextField("");
    public JLabel category = new JLabel("分类");
    //下拉框
    //public String[] menu = new String[] { "餐饮", "交通","旅游" };这个是没连接数据库测试用的
    //JComboBox cb = new JComboBox(menu);
    public JLabel remarks = new JLabel("备注");
    public JTextField remarksText = new JTextField("");
    public JLabel date = new JLabel("日期");
    //日期
    public JTextField dateText = new JTextField(String.valueOf(new Date()));
    //public JXDatePicker dateText = new JXDatePicker(new Date());
    public JButton b = new JButton("记一笔");
    JPanel north = new JPanel();
    JPanel south = new JPanel();
    //更新功能，创建下拉框。创建CategoryComboBoxModel对象
    public CategoryComboBoxModel ccbm = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(ccbm);
    public RecordPanel() {
        init();
    }
    public void init(){
        //直接在操作，未使用this，当前效果是一样的
        add();
        setLayout(new BorderLayout());
        add(north,BorderLayout.NORTH);
        add(south,BorderLayout.SOUTH);
        addListener();
    }
    public void add(){
        north.setLayout(new GridLayout(4,2));
        north.add(cost);
        north.add(costText);
        north.add(category);
        north.add(cbCategory);
        north.add(remarks);
        north.add(remarksText);
        north.add(date);
        north.add(dateText);
        south.setLayout(new FlowLayout());
        south.add(b);
    }
    public static void main(String[] args) {
        showPanel(RecordPanel.instance);
    }

    @Override
    public void updateData() {
        //获取数据库表中的数据(category的分类)
        ccbm.cs = new CategoryService().list();
        cbCategory.updateUI();
        resetInput();
        costText.grabFocus();
    }
    //这个应该是获取当前
    public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();//获取下拉框的即Category对象
    }
    public void resetInput(){
        costText.setText("0");
        remarksText.setText("");
        if(0!=ccbm.cs.size())
            cbCategory.setSelectedIndex(0);
        //dateText.setDate(new Date());没有下载JXDatePicker包，直接将默认值设置为当前日期
    }
    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();
        b.addActionListener(listener);
    }
}
