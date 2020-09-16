package startup;

import gui.frame.Bookkeeping;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 完成jdbc。
 * 为程序添加功能。创建startup包。这个类将是程序入口。
 */

/**
 * 接下来是由多个模块组成的项目，各个模块之间是相互依赖的，有的模块不完成，其他模块就无法工作。比如
 * 要"记一笔" 就必须要先有"消费分类数据"
 * 要"消费一览” 就必须先在设置里预先设置预算
 * 要备份和恢复，也必须先在设置里预先设置mysql的安装路径
 * 所以需要按照依赖的关系先开发一些模块，然后再是其他的
 */
public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                Bookkeeping.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
