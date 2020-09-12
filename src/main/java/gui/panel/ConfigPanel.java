package gui.panel;

import javax.swing.*;
import java.awt.*;
import static util.GuiUtil.showPanel;

/**
 * 本面板使用BorderLayout，分北面和居中。
 *
 * 北面是一个JPanel，里面放4个组件，使用4行1列的GridLayout的布局
 * 居中是一个JPanel,就放了一个按钮
 */
public class ConfigPanel extends WorkingPanel{
    public static ConfigPanel instance = new ConfigPanel();
    public JPanel north = new JPanel();
    public JPanel south = new JPanel();
    public JLabel budget = new JLabel("预算");
    public JTextField budText = new JTextField();
    public JLabel src = new JLabel("mysql安装路径");
    public JTextField srcText = new JTextField();
    public JButton b = new JButton("更新");
    public void add(){
        setLayout(new BorderLayout());
        north.setLayout(new GridLayout(4,1));
        north.add(budget);
        north.add(budText);
        north.add(src);
        north.add(srcText);
        south.setLayout(new FlowLayout());
        south.add(b);
        add(north,BorderLayout.NORTH);
        add(south,BorderLayout.SOUTH);
    }

    public ConfigPanel() {
        add();
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
