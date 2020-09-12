package gui.panel;

import util.GuiUtil;
import static util.GuiUtil.showPanel;
import javax.swing.*;
import java.awt.*;

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
    public String[] menu = new String[] { "餐饮", "交通","旅游" };
    JComboBox cb = new JComboBox(menu);
    public JLabel remarks = new JLabel("备注");
    public JTextField remarksText = new JTextField("");
    public JLabel date = new JLabel("日期");
    //日期
    public JTextField dateText = new JTextField("yyyy-MM-dd");
    JButton b = new JButton("记一笔");
    JPanel north = new JPanel();
    JPanel south = new JPanel();
    public RecordPanel() {
        init();
    }
    public void init(){
        //直接在操作，未使用this，当前效果是一样的
        add();
        setLayout(new BorderLayout());
        add(north,BorderLayout.NORTH);
        add(south,BorderLayout.SOUTH);
    }
    public void add(){
        north.setLayout(new GridLayout(4,2));
        north.add(cost);
        north.add(costText);
        north.add(category);
        north.add(cb);
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

    }

    @Override
    public void addListener() {

    }
}
