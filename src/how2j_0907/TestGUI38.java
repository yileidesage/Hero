package how2j_0907;
/*
练习-按照eclipse的风格显示多个java文件
参考eclipse的风格，借助TabbedPanel显示一个包下所有的java文件
假设包 jdbc 中有如下java文件
ConnectionPool.java
DAO.java
HeroDAO.java
TestConnectionPool.java
TestDAO.java
TestJDBC.java


首先准备一个JavaFilePane 专门用于显示文件内容的Panel

然后在TestGUI中遍历e:/project/j2se/jdbc 下的文件，并根据这些文件生成JavaFilePane 。

接着把这些JavaFilePane 插入到TabbedPanel中即可
 */

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TestGUI38 {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);

        f.setLayout(null);

        File folder = new File("E:/project/j2se/src/jdbc");
        File[] fs = folder.listFiles();
        JTabbedPane tp = new JTabbedPane();
        ImageIcon icon = new ImageIcon("e:/project/j2se/j.png");
        for (int i = 0; i < fs.length; i++) {
            JavaFilePane jfp = new JavaFilePane(fs[i]);
            tp.add(jfp);
            tp.setIconAt(i, icon);
            tp.setTitleAt(i, shortName(fs[i].getName()));
        }

        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static String shortName(String name) {
        int length = 6;
        if (name.length() > length) {
            return name.substring(0, length) + "...";
        }
        return name;

    }
}
