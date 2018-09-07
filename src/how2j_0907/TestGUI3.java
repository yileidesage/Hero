package how2j_0907;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
键盘监听
键盘监听器:KeyListener
keyPressed代表 键被按下
keyReleased 代表键被弹起
keyTyped 代表一个按下弹起的组合
keyEvent.getKeyCode() 可以获取当前点下了哪个键
 */
public class TestGUI3 {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("/Users/apple/Downloads/编程素材/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
        //增加键盘监听
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            //键盘被弹起
            public void keyReleased(KeyEvent e) {
                //39代表按下了右键
                if (e.getKeyCode() == 39) {
                    //图片向右移动(y坐标不变,x坐标增加)
                    l.setLocation(l.getX() + 10, l.getY());
                }

            }
        });
        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
