import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class ActionTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setFocusable(true);//将控件设置成可获取焦点状态,防止键盘监听与按钮监听冲突
        jf.setLayout(null);
        jf.setTitle("LOL");
        jf.setSize(400,500);
        ImageIcon img = new ImageIcon("shana.png");
        //建立label对象，存储图片
        final JLabel l = new JLabel();
        l.setIcon(img);
        //长宽可以设置为图片的像素
        l.setBounds(50, 200, img.getIconWidth(), img.getIconHeight());
        JButton b = new JButton("fuck me");
        b.setBounds(50,50,100,100);
        jf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 68){
                    System.out.println("移动");
                    l.setLocation(l.getX()+30,l.getY());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        l.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Random random = new Random();
                int x = random.nextInt(jf.getWidth() - l.getWidth());
                int y = random.nextInt(jf.getHeight() - l.getHeight());
                l.setLocation(x, y);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        b.addMouseListener(new MouseListener() {
            int flag = 0;
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (flag == 0){
                    b.setText("fuck you");
                    flag = 1;
                    l.setVisible(false);
                }else {
                    b.setText("fuck me");
                    flag = 0;
                    l.setVisible(true);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jf.add(b);
        jf.add(l);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
