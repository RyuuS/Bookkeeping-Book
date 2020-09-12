package gui.panel;

import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class Backup extends WorkingPanel{
    public static Backup instance = new Backup();
    JButton b = new JButton("备份");
    public Backup() {
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
