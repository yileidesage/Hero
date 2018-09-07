package how2j_0907;
/*
事件监听
ActionListener 按钮监听
创建一个匿名类实现ActionListener接口,当按钮被点击时,actionPerformed方法会被调用
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("/Users/apple/Downloads/编程素材/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);
        //给按钮增加监听
        b.addActionListener(new ActionListener() {
            @Override
            //当按钮被点击时,会触发ActionEvent事件,导致图片不可见
            //actionPerformed 方法就会执行
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
