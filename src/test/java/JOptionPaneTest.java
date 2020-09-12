import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JOptionPaneTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("弹窗");
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        JLabel user = new JLabel("用户名");
        JLabel psw = new JLabel("密码");
        JTextField inputU = new JTextField("");
        inputU.setPreferredSize(new Dimension(100,25));
        JPasswordField inputP = new JPasswordField();
        inputP.setPreferredSize(new Dimension(100,25));
        JButton b = new JButton("登录");
        f.add(user);
        f.add(inputU);
        f.add(psw);
        f.add(inputP);
        f.add(b);
        f.setVisible(true);
        //JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
        //int option = JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                char[] tmp = inputP.getPassword();
                String str = String.valueOf(tmp);
                char[] empty = {};
                System.out.println(inputU.getText());
                System.out.println(inputP.getPassword());
                inputU.setFocusable(true);
                if(inputU.getText()== "1"){
                    JOptionPane.showMessageDialog(f,"账号或密码不得为空");
                }
                else if (str.equals("123456")){
                    JOptionPane.showMessageDialog(f,"登录成功");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
