package gui.panel;

import util.CenterPanel;
import util.CircleProgressBar;
import util.ColorUtil;
//函数方法调用
import static util.GuiUtil.setColor;
import static util.GuiUtil.showPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 核心模块
 * 继承workingPanel，work区域放在中间，点击其他按钮，work区域发生变化
 * 首先把整体是一个BorderLayerout
 * 中间是一个Panel，采用的BorderLayerout.CENTER
 * 下面也是一个Panel，采用的BorderLayerout.SOUTH
 */
//
public class SpendPanel extends WorkingPanel{
    public static SpendPanel instance = new SpendPanel();
    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTodaySpend = new JLabel("今日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");

    JLabel vMonthSpend = new JLabel("3000");
    JLabel vTodaySpend = new JLabel("500");
    JLabel vAvgSpendPerDay = new JLabel("300");
    JLabel vMonthAvailable = new JLabel("1890");
    JLabel vDayAvgAvailable = new JLabel("70");
    JLabel vMonthLeftDay = new JLabel("10天");
    CircleProgressBar bar;
    public SpendPanel() {
        this.setLayout(new BorderLayout());
        bar = new CircleProgressBar();
        bar.setBackgroundColor(Color.BLUE);
        setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        this.add(center(),BorderLayout.CENTER);
        this.add(south(),BorderLayout.SOUTH);
    }
    //中间panel的图
    private JPanel center(){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(),BorderLayout.WEST);
        p.add(east());
        return p;
    }
    private Component east(){
        return bar;
    }
    private Component west(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }
    private Component south(){
        //南面这部分使用的是GridLayerout分布，2行4列的网格布局器
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,4));
        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthLeftDay);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
        return p;
    }

    public static void main(String[] args) {
        showPanel(SpendPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
