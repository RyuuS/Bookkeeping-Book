package gui.frame;

import javax.swing.*;
import gui.panel.MainPanel;

/**
 * 程序入口
 * @setContentPane直接将MainPanel替换了JFrame界面为初始界面
 */
public class Bookkeeping {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(500,400);
        jf.setLocationRelativeTo(null);
        jf.setContentPane(MainPanel.instance);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
