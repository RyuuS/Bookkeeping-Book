import javax.swing.*;
import java.awt.*;

public class CentTest extends JPanel{
    private double rate;//拉伸比例
    private JComponent c; //显示的组件
    private boolean strech; //是否拉伸

//    public CenterPanel(double rate,boolean strech) {
//        this.setLayout(null);
//        this.rate = rate;
//        this.strech = strech;
//    }
    public static void main(String[] args) {
        JFrame f =  new JFrame();
        Cen cen = new Cen();
        f.setLayout(null);
        f.setSize(500,500);
        f.setContentPane(cen);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Cen extends JPanel{
    public Cen() {
        show(new JLabel("123"));
        add(new JLabel("456"));
        show(new JButton("fgh"));
    }
    public void show(JComponent p){
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }
        add(p);
    }
}
