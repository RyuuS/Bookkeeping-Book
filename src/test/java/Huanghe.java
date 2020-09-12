import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Huanghe {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(500,500);
        f.setLayout(new BorderLayout());//布局上中下
        f.setResizable(false);
        f.setLocation(500,430);
        HhLayout hhLayout = new HhLayout();
        f.add(BorderLayout.NORTH,hhLayout.north());
        JScrollPane sp = new JScrollPane(hhLayout.south());
        f.add(BorderLayout.CENTER,sp);
        hhLayout.act();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class HhLayout extends JPanel{
    //上面布局是网格布局器
    JLabel location = new JLabel("地名：");
    JTextField localText = new JTextField("");
    JLabel type = new JLabel("公司类型：");
    JTextField typeText = new JTextField("");
    JLabel comName = new JLabel("公司名称：");
    JTextField comNameText = new JTextField("");
    JLabel bossName = new JLabel("老板名称：");
    JTextField bossNameext = new JTextField("");
    JLabel money = new JLabel("金额：");
    JTextField moneyText = new JTextField("");
    JLabel product = new JLabel("产品：");
    JTextField productName = new JTextField("");
    JButton b = new JButton("生成");
    public JPanel north(){
        JPanel p = new JPanel();
        //p.setBounds(50,50,300,300);
        p.setLayout(new GridLayout(4,4));
        p.add(location);
        p.add(localText);
        p.add(type);
        p.add(typeText);
        p.add(comName);
        p.add(comNameText);
        p.add(bossName);
        p.add(bossNameext);
        p.add(money);
        p.add(moneyText);
        p.add(product);
        p.add(productName);
        p.add(b);
        return p;
    }
    //中间按钮
//    public JPanel center(){
//        p2.add(b);
//        return p2;
//
//    }

    //底部
    //创建JScrollPane，把组件作为参数传进去
    JTextArea ta = new JTextArea();
    public JTextArea south(){
        ta.append("Text...");
        ta.setLineWrap(true);
        return ta;
    }
    public void act(){
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append(localText.getText());
                ta.append("最大的");
                ta.append(typeText.getText());
                ta.append("倒闭了");
            }
        });
    }
}
