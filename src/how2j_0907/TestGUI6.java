package how2j_0907;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
练习:切换显示
把按钮监听中的按钮上的文字从“隐藏图片” 改为 "显示图片"。

第一次点击的时候，会使得图片隐藏，第二次点击的时候，会使得图片显示，如此循环下去。

一旦点击了"隐藏图片"，按钮上的文字就要变成“显示图片” 。。。 如此循环

提示： 调用JButton对象的setText改变按钮上的文字
 */

public class TestGUI6 {


    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("/Users/apple/Downloads/编程素材/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

        // 给按钮 增加 监听
        b.addActionListener(new ActionListener() {

            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            boolean hide = false;

            public void actionPerformed(ActionEvent e) {
                l.setVisible(hide);
                hide = !hide;
                b.setText(hide ? "显示图片" : "隐藏图片");
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
