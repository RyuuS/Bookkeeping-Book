package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 工具包，里边主要包含放置图像和显示模块的功能
 * @setImageIcon主要在MainPanel里使用
 * @showPanel用于加载模块
 */
public class GuiUtil {
    private static String imageFolder = "img";
    //放置图像
    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
    public static void setColor(Color color, JComponent... cs) {
        for (JComponent c : cs) {
            c.setForeground(color);
        }
    }
    public static boolean checkEmpty(JTextField tf,String input){
        String text = tf.getText().trim();
        if (text.length() == 0){
            JOptionPane.showMessageDialog(null,input + "不能为空");
            tf.grabFocus();
            return true;
        }
        return false;
    }
    public static void showPanel(JPanel p,double strechRate) {
        //GuiUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        //设置窗口相对于指定组件的位置为 null，则此窗口将置于屏幕的中央
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strechRate);
        //把cp设置为内容面板
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }
    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }
}
