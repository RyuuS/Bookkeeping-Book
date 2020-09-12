package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * MainPanel 是主窗体的ContentPanel，采用的是BorderLayerout的布局方式。
 * 北边是一个工具条
 * 中间是一个空白的Panel，用于将来显示不同的功能面板
 * 中间的为working区域，每次点击主界面按钮，working发生相应改变
 */
public class MainPanel extends JPanel{

    public static MainPanel instance = new MainPanel();
    public JToolBar tb = new JToolBar();
    public JButton backup = new JButton();
    public JButton category = new JButton();
    public JButton config = new JButton();
    public JButton home = new JButton();
    public JButton record = new JButton();
    public JButton report = new JButton();
    public JButton restore = new JButton();
    public CenterPanel workingPanel;
    private MainPanel(){
        GuiUtil.setImageIcon(home,"home.png","消费一览");
        GuiUtil.setImageIcon(record,"record.png","记一笔");
        GuiUtil.setImageIcon(category,"category2.png","消费分类");
        GuiUtil.setImageIcon(report,"report.png","消费报表");
        GuiUtil.setImageIcon(config,"config.png","设置");
        GuiUtil.setImageIcon(backup,"backup.png","备份");
        GuiUtil.setImageIcon(restore,"restore.png","恢复");

        tb.add(home);
        tb.add(record);
        tb.add(category);
        tb.add(report);
        tb.add(config);
        tb.add(backup);
        tb.add(restore);
        //设置 floatable属性，必须为 true才能使用户移动工具栏。
        tb.setFloatable(false);
        workingPanel = new CenterPanel(0.85);
        //初始将SpendPanel加入到working
        //workingPanel.add(SpendPanel.instance);
        //workingPanel.add(new JLabel("123"));
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
        addListener();
    }
    //为主界面按钮添加事件
    private void addListener(){
        ToolBarListener listener = new ToolBarListener();
        home.addActionListener(listener);
        record.addActionListener(listener);
        category.addActionListener(listener);
        config.addActionListener(listener);
        backup.addActionListener(listener);
        restore.addActionListener(listener);
    }
    public static void main(String[] args) {
        GuiUtil.showPanel(MainPanel.instance);
    }
}
