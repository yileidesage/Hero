package how2j_0907;
/*
 SWING 的容器
Java的图形界面中，容器是用来存放 按钮，输入框等组件的。

窗体型容器有两个，一个是JFrame,一个是JDialog

JFrame
JFrame是最常用的窗体型容器，默认情况下，在右上角有最大化最小化按钮
详见练习TestGUI

JDialog
JDialog也是窗体型容器，右上角没有最大和最小化按钮
 */

import javax.swing.JButton;
import javax.swing.JDialog;

public class TestGUI8 {
    public static void main(String[] args) {

        //普通的窗体，带最大和最小化按钮
        JDialog d = new JDialog();
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);

        d.add(b);

        d.setVisible(true);
    }
}
