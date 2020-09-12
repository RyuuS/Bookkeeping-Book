import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 搜索文件名的demo
 * 搜索名为空时，将会遍历文件目录下的所以文件，注意！
 *
 */
public class SearchT {
    public static void main(String[] args) {
        new JF();
    }
}
class JF extends JFrame{
    Listening listening = new Listening(this);
    JPanel panel = new JPanel();
    JButton b1 = new JButton("浏览");
    JButton b2 = new JButton("查找");
    JTextField textField = new JTextField();
    JLabel label = new JLabel("输入路径");
    public JF() {
        this.setSize(500,500);
        this.setLocation(500,300);
        init();
    }
    public void init(){
        textField.setPreferredSize(new Dimension(260,25));
        label.setPreferredSize(new Dimension(400,25));
        add();
        addAction();
        this.setVisible(true);
        this.setDefaultCloseOperation(JF.EXIT_ON_CLOSE);
    }
    //加入组件
    public void add(){
        panel.add(b1);
        panel.add(textField);
        panel.add(b2);
        panel.add(label);
        this.add(panel);
    }
    //加入监听事件
    public void addAction(){
        b1.addActionListener(listening);
        b1.setActionCommand("浏览");
        b2.addActionListener(listening);
        b2.setActionCommand("检索");
    }
}
class Listening implements ActionListener {
    static JF jf = null;
    String src = null;
    int count = 0;
    JFileChooser fc = new JFileChooser();
    @Override
    public void actionPerformed(ActionEvent e) {
        //jf.label.setText("wdnmd");
        if (e.getActionCommand().equals("浏览")) {
            count = 0;
            src = getSrc();
            System.out.println(src);
            jf.label.setText(src);
            SwingWorker<Void,Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    //jf.label.setText(tmp);
                    return null;
                }
            };
            worker.execute();
        }
        if (e.getActionCommand().equals("检索")) {
            count = 0;
            SwingWorker<Void,Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    searchFolder(src);
                    System.out.println(count);
                    JOptionPane.showMessageDialog(jf,"共找到文件"+count);
                    return null;
                }
            };
            worker.execute();
        }
    }
    public Listening(JF f) {
        this.jf = f;

    }
    //搜索文件名称
    public void search(String str) {
        jf.label.setText(str);
        if(jf.label.getText().contains(jf.textField.getText())) {
            count+=1;
            System.out.println(jf.label.getText());
        }
    }
    //如果是文件夹，则递归
    public void searchFolder(String s) {
        File file = new File(s);
        if (file.isFile())  search(s);
        else {
            File[] fs = file.listFiles();
            for(File f:fs){
                jf.label.setText(f.getAbsolutePath());
                if (f.isFile()) search(f.getAbsolutePath());
                else searchFolder(f.getAbsolutePath());
            }
        }
    }
    //获取src路径
    public String getSrc(){
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.showDialog(new JLabel(),"选择");
        System.out.println(fc.getSelectedFile());
        File f = fc.getSelectedFile();
        if(f==null) return null;
        return f.getAbsolutePath();
    }
}