import javax.swing.*;
import java.awt.event.*;

public class ActionTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(null);
        jf.setTitle("LOL");
        jf.setSize(400,500);
        ImageIcon img = new ImageIcon("shana.png");
        final JLabel l = new JLabel();
        l.setIcon(img);
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
                    l.setLocation(l.getX()+10,l.getY());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

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
                }else {
                    b.setText("fuck me");
                    flag = 0;
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
