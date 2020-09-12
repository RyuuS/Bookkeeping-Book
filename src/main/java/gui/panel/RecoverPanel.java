package gui.panel;

import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class RecoverPanel extends WorkingPanel{
    public static RecoverPanel instance = new RecoverPanel();
    JButton b = new JButton("恢复");
    public RecoverPanel() {
        setLayout(new FlowLayout());
        add(b);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }
    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
