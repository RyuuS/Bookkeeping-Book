import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FrameTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(450,500);
        jf.setTitle("bookkeeping");
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户关闭时的响应动作
        JToolBar tb = new JToolBar();
        JButton bConsum = new JButton("消费");
        JButton bRecord = new JButton("记录");
        JButton bCategory = new JButton("分类");
        JButton bReport = new JButton("月🈷️报表");
        JButton bSetting = new JButton("设置");
        JButton bBackup = new JButton("备份");
        JButton bRecover = new JButton("恢复");
        tb.add(bConsum);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bSetting);
        tb.add(bBackup);
        tb.add(bRecover);
        jf.setVisible(true);
        jf.setLayout(new BorderLayout());//设置布局
        jf.add(tb,BorderLayout.NORTH);
        jf.add(new JPanel(),BorderLayout.CENTER);
        jf.setResizable(true);
        bConsum.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {

            }
        } );
    }
}
