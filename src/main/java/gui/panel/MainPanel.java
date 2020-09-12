package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
//    static {
//        //美化用？？？
//        GuiUtil.useLNF();
//    }

    public static MainPanel instance = new MainPanel();
    JToolBar tb = new JToolBar();
    public JButton backup = new JButton();
    public JButton category = new JButton();
    JButton config = new JButton();
    JButton home = new JButton();
    JButton record = new JButton();
    JButton report = new JButton();
    JButton restore = new JButton();
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
    }
    public static void main(String[] args) {
        GuiUtil.showPanel(MainPanel.instance);
    }
}
