package gui.panel;

import util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * 报表
 */
public class ReportPanel extends WorkingPanel{
    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        ImageIcon icon= new ImageIcon(new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        });
        l.setIcon(icon);
        this.add(l);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
