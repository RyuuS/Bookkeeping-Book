package util;

import gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 比较重要的一个类，继承JPanel，主要是用于working区域的显示
 * @repaint重绘此组件。必须要有，虽然没有被调用？(删除之后working区域将变成空白)
 * @show组件的更新，先用c存储并显示此次显示的组件，在下一次调用时将其删除??
 */
public class CenterPanel extends JPanel {
    private  double rate;//拉伸比例
    private  boolean strech;//是否拉伸
    private JComponent c; //显示的组件
//repaint()重绘此组件
    public void repaint() {
        if (null != c) {
            Dimension containerSize = this.getSize();
            Dimension componentSize= c.getPreferredSize();
            if(strech)
                c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            else
                c.setSize(componentSize);
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
        }
        super.repaint();
    }
    public CenterPanel(double rate,boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    public CenterPanel(double rate) {
        this(rate,true);
    }


    public void show(JComponent p) {
        this.c = p;
        System.out.println(p);
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }
        add(p);
        if (p instanceof WorkingPanel)
            ((WorkingPanel) p).updateData();
        this.updateUI();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(0.85);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b  =new JButton("abc");
        cp.show(b);
    }
}
