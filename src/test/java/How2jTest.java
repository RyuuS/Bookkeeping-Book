
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
public class How2jTest {
    public static void openWindows() {
        JFrame jf = new JFrame();
        jf.setSize(500,400);
        int[] pos = readPos();
        //窗口位置
        jf.setLocation(pos[0],pos[1]);
        jf.setLayout(null);//组件设置为绝对定位
        JButton b = new JButton("just do it");
        ImageIcon img = new ImageIcon("shana.png");
        b.setBounds(150, 200, 100, 30);
        //图像放入Jlabel对象中
        final JLabel l = new JLabel();
        l.setIcon(img);
        l.setBounds(50, 50, img.getIconWidth(), img.getIconHeight());
        //按钮添加监听
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    //当按钮被点击时，就会触发 ActionEvent事件
                    // actionPerformed 方法就会被执行
                    l.setVisible(false);
                }
            }
        });
        //键盘监听
        jf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override//键盘按下
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 68){
                    l.setLocation(l.getX()+10,l.getY());
                }
            }

            @Override//键盘弹起
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 68){
                    l.setLocation(l.getX()+10,l.getY());
                }
            }
        });
        jf.add(l);
        jf.add(b);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //线程
        Thread th = new Thread(()->{
            try {
                //创建文件输出流
                FileOutputStream out = new FileOutputStream("position.txt");
                while (true) {
                    Thread.sleep(200);
                    String x = jf.getX() + "";
                    String y = jf.getY() + "";
                    //写入坐标开头加一个空格，可供read读取，分行
                    out.write(new String(" "+ x + "&&" + y+ "\r").getBytes());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        });
        //th.start();
    }
    public static int[] readPos(){
        int[] ans = new int[2];
        try {
            //读取文本
            BufferedReader in = new BufferedReader(new FileReader("position.txt"));
            String line = "0&&0";//设置默认位置，y的默认值实际应该是高的值
            //read读1个字符，读完自动指向下一个
            while ( in.read() != -1) {
                line = in.readLine();
                System.out.println(line);
            }
            //保存至数组
            String[] xyStr = line.split("&&");
            ans[0] = Integer.parseInt(xyStr[0]);
            ans[1] = Integer.valueOf(xyStr[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }
    public static void main(String[] args) {
        //练习-在上次关闭位置启动窗口
//        readPos();
        openWindows();

    }
}
