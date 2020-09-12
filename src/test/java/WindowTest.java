import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowTest {
    public static void main(String[] args) {
        JFrame jd = new JFrame();
        jd.setTitle("LOL");
        jd.setLayout(null);//默认布局是BorderLayout
        jd.setSize(500,500);
        jd.setLocation(500,500);
        JDialog jdIn = new JDialog(jd);
        jdIn.setModal(true);
        jdIn.setSize(250,250);
        jdIn.setLayout(null);
        JButton b = new JButton("打开JD");
        b.setBounds(50, 50, 100, 30);
        jd.add(b);
        jd.setFocusable(true);
        JButton b2 = new JButton("关闭");
        b2.setBounds(50, 50, 100, 30);
        jdIn.add(b2);
        jd.setVisible(true);
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jdIn.setVisible(true);
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
        b2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jdIn.setVisible(false);
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
        jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
