import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;

public class CopyTest extends JFrame{
    //面板和button
    JPanel panel = new JPanel();
    JTextField fromText = new JTextField(25);
    JTextField targetText = new JTextField(25);
    JProgressBar pb = new JProgressBar();
    JButton start = null;
    JButton src = null;
    JButton tar =null;
    JOptionPane op = null;

    public static void main(String[] args) {
        new CopyTest();
    }
    public void addComponent(){
        //panel.setBounds(50,50,400,30);
        panel.add(new JLabel("源文件地址"));
        panel.add(fromText);
        pb.setMaximum(100);
        pb.setStringPainted(true);
        // 创建监听器
        Action listener=new Action(this);
        src = new JButton("浏览");
        src.setActionCommand("src");
        src.addActionListener(listener);
        panel.add(src);
        panel.add(new JLabel("复制到:     "));
        panel.add(targetText);
        start = new JButton("start");
        start.setActionCommand("start");
        start.addActionListener(listener);
        tar = new JButton("浏览");
        tar.setActionCommand("tar");
        tar.addActionListener(listener);
        panel.add(tar);
        panel.add(start);
        panel.add(pb);
        this.add(panel);
    }
    public CopyTest(){
        this.setLocation(500,200);
        this.setSize(500,500);
        pb.setPreferredSize(new Dimension(350,50));
        addComponent();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class ProBar extends Thread{
    Action action = new Action();
    String src=null;
    String tar=null;
    public ProBar(String src,String tar) {
        this.src = src;
        this.tar = tar;
    }
    @Override
    public void run() {
        action.getLongth(src);
        System.out.println(action.getLongth(src));
        action.copyDir(src,tar);
    }
}
class Action implements ActionListener {
    CopyTest cp = null;
    String src=null;
    String tar=null;
    long len = 0;
    int precent;
    public Action(CopyTest copyTest) {
        //如果是copyd对象直接复制，cp也只是会被赋值一个对象。
        this.cp = copyTest;
    }
    public Action(){}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("start")){
            getLongth(src);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    copyDir(src, tar);
                }
            }).start();
        }//当选择浏览源目录时触发次事件。src为文件路径。
        else if(e.getActionCommand().equals("src")){
            //文件选择器组件JFileChoose中f_a_d对应的是打开文件或文件夹返回int
            src = getSelectFileName(JFileChooser.FILES_AND_DIRECTORIES );
            cp.fromText.setText(src);
            //System.out.println(src);
        }
        else if(e.getActionCommand().equals("tar")){
            tar = getSelectFileName(JFileChooser.FILES_AND_DIRECTORIES );
            cp.targetText.setText(tar);
        }
    }

    private String getSelectFileName(int mode ) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(mode);
        jfc.showDialog(new JLabel(),"选择");
        File file = jfc.getSelectedFile();
        if (file==null) return null;
        return file.getAbsolutePath();
    }
    //复制文件
    public void copyFiles(String newSrc,String newTar) {
        try{
            File fromFile = new File(newSrc);
            File toFile = new File(newTar);
            FileInputStream inputStream = new FileInputStream(fromFile);
            FileOutputStream outputStream = new FileOutputStream(toFile);
            byte[] bytes = new byte[1024];
            int num = 0;
            int n;
            //将 n字节从位于偏移量 off的指定字节数组写入此文件输出流
            while ((n = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,n);
                num += n;
                precent = (int) ((num/len)*100);
                cp.pb.setValue(100);
            }
            inputStream.close();
            inputStream.close();
        } catch (IOException e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(cp,"路径有误,copy失败");

        }

    }
    //复制文件夹
    public void copyDir(String src,String des){
        File srcFile = new File(src);
        File desFile = new File(des);
        //判定文件or文件夹
        if (srcFile.isFile()) copyFiles(srcFile.toString(),desFile.toString());
        else {
            // 获取源文件夹下的文件夹或文件
            File[] fs = srcFile.listFiles();
            for (File file:fs){
                File tmpTar = new File(desFile.getAbsolutePath() + File.separator + file.getName());
                //如果srcFiles是文件夹
                if(file.isDirectory()){
                    if(!tmpTar.exists()) {
                        tmpTar.mkdir();
                        System.out.println("新建文件夹" + tmpTar.getName());
                    }
                    String newSrc = file.getAbsolutePath();
                    String newTar = tmpTar.getAbsolutePath();
                    copyDir(newSrc,newTar);
                }
                else if (file.isFile()){
                    System.out.println("文件" + file.getName());
                    File tarFile = new File(desFile.getAbsolutePath() + File.separator + file.getName());
                    copyFiles(file.toString(),tarFile.toString());
                }
            }
        }
    }
    //获取总文件及文件夹的大小
    public long getLongth(String src){
        File srcFile = new File(src);
        if (srcFile.isFile()) return srcFile.length();
        File[] fs = srcFile.listFiles();
        for (File file:fs){
            if (srcFile.isFile()){
                len += file.length();
            }else{
                len += getLongth(file.getAbsolutePath());
            }
        }
        return len;
    }
}

