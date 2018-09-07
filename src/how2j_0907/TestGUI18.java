package how2j_0907;
/*
JAVA的图形界面下有两组控件，一组是awt,一组是swing。
一般都是使用swing

Label用于显示文字

 */

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGUI18 {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JLabel l = new JLabel("LOL文字");
        //文字颜色
        l.setForeground(Color.red);
        l.setBounds(50, 50, 280, 30);

        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
