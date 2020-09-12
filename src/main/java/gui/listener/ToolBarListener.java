package gui.listener;

import gui.panel.MainPanel;
import gui.panel.SpendPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.backup)
            System.out.println("验证");
            p.workingPanel.show(SpendPanel.instance);
        
    }
}
