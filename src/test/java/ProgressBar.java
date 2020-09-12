import sun.tools.jstat.Jstat;

import javax.swing.*;
import java.awt.*;

public class ProgressBar {
    static JFrame f = new JFrame();
    static JProgressBar pb = new JProgressBar();
    public static void main(String[] args) {
        set();
        PbTheard theard = new PbTheard(pb);
        theard.start();
    }
    public static void set(){
        f.setSize(500,500);
        f.setLocation(500,200);
        f.setLayout(new FlowLayout());
        pb.setMaximum(100);
        pb.setStringPainted(true);
        f.add(pb);
        pb.setValue(0);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class PbTheard extends Thread{
    public int progress = 0;
    JProgressBar progressbar ;
    @Override
    public void run() {
        int sleeptime = 50;
        while (true){
            try {
                this.progress += 1;
                sleeptime += 50;
                progressbar.setValue(this.progress);
                Thread.sleep(sleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public PbTheard(JProgressBar pb) {
        progressbar = pb;
    }
}