import sun.tools.jps.Jps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOL");
        f.setSize(500,500);
        JPanel pLeft = new JPanel();
        JPanel pRight = new JPanel();
        pLeft.setBounds(0,0,150,500);
        //pLeft.setPreferredSize(new Dimension(150,500));
        //pLeft.setLayout(new FlowLayout());
        pRight.setBounds(150,0,350,500);
        pLeft.setBackground(Color.RED);
        //pRight.setLayout(new BorderLayout());
        ImageIcon annie = new ImageIcon("./img/annie.jpg");
        ImageIcon gareen = new ImageIcon("./img/gareen.jpg");
        ImageIcon teemo = new ImageIcon("./img/teemo.jpg");
        JLabel p1 = new JLabel();
        JLabel p2 = new JLabel();
        JLabel p3 = new JLabel();
        p1.setIcon(annie);
        p2.setIcon(gareen);
        p3.setIcon(teemo);
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        pRight.add(p1);
        pRight.add(p2);
        pRight.add(p3);
        JButton b1 = new JButton("annie");
        JButton b2 = new JButton("gareen");
        JButton b3 = new JButton("teemo");
        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pLeft,pRight);
        sp.setDividerLocation(80);
        f.setContentPane(sp);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //事件
        f.setFocusable(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(true);
                p2.setVisible(false);
                p3.setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p2.setVisible(true);
                p3.setVisible(false);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(true);
            }
        });
    }
}
