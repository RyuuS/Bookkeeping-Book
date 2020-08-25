package gui.panel;

import javax.swing.*;

public class SpendPanel {
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
}
