import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddDemo extends JFrame{
    private static JTextField aTextField;
    private static JTextField bTextField;
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        JButton b = new JButton("点我");
        String[] columnNames = new String[] { "分类名称","消费次数" };
        String[][] name = new String[][] { { "交通", "0" },
                { "住宿", "2"}, { "话费", "1" } };
        DefaultTableModel tableModel = new DefaultTableModel(name,columnNames);
        JTable table = new JTable(tableModel);
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //获得选中行索引
                Object oa = tableModel.getValueAt(selectedRow, 0);
                Object ob = tableModel.getValueAt(selectedRow, 1);
                aTextField.setText(oa.toString());  //给文本框赋值
                bTextField.setText(ob.toString());
            }
        });
        JScrollPane sp = new JScrollPane(table);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String []rowValues = {aTextField.getText(),bTextField.getText()};
                tableModel.addRow(rowValues);
            }
        });
        f.add(sp);
        f.add(b);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
