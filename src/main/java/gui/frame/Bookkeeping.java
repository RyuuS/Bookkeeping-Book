package gui.frame;

import javax.swing.*;

import gui.panel.MainPanel;
import util.GuiUtil;
import gui.panel.MainPanel;
import java.awt.*;

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
