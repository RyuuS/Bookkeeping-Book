package menu;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTest {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(500,500);
        f.setLocation(500,300);
        f.setLayout(new FlowLayout());
        JMenuBar mb = new JMenuBar();
        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        // 分隔符
        mHero.addSeparator();
        mHero.add(new JMenuItem("所有-All"));
        //工具栏
        JButton b1 = new JButton("在事件调度线程中执行长耗时任务");
        JButton b2 = new JButton("使用SwingWorker执行长耗时任务");
        JLabel label = new JLabel("任务执行结果");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
                try {
                    label.setText("开始执行任务...");
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                label.setText("任务执行完毕");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void,Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("(SW)执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
                        label.setText("开始执行任务...");
                        Thread.sleep(1000);
                        label.setText("绝对瞄准已部署");
                        Thread.sleep(1000);
                        label.setText("目标已锁定");
                        Thread.sleep(1000);
                        label.setText("进入倒计时");
                        for (int i = 5; i > 0 ; i--) {
                            Thread.sleep(1000);
                            label.setText("" + i);
                        }
                        label.setText("失去目标..");
                        Thread.sleep(1000);
                        label.setText("任务终止");
                        return null;
                    }
                };
                worker.execute();
            }
        });
        f.add(b1);
        f.add(b2);
        f.add(label);
        f.setJMenuBar(mb);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.isEventDispatchThread();

    }
}
