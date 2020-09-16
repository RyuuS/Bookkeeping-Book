package gui.frame;

import javax.swing.*;
import gui.panel.MainPanel;
/**
 * 界面入口(测试)
 * @setContentPane直接将MainPanel替换了JFrame界面为初始界面
 */
public class Bookkeeping extends JFrame{
    public static Bookkeeping instance = new Bookkeeping();
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(500,400);
        jf.setLocationRelativeTo(null);
        jf.setContentPane(MainPanel.instance);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * main下的测试代码放到构造里
     */
    public Bookkeeping(){
        this.setSize(500,450);
        this.setTitle("账本");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
