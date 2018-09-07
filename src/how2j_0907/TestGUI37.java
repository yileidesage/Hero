package how2j_0907;
/*
练习-SplitPanel
设计一个像SplitPanel的左右风格的SplitPanel
左边放3个按钮，上面的文字分别是: 盖伦，提莫，安妮
右边默认显示盖伦
当左边按钮点击的时候，右边就会显示对应的图片

需要的头像可以下载区 下载pics.rar
 */


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class TestGUI37 {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);

        f.setLayout(null);

        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);

        pLeft.setBackground(Color.LIGHT_GRAY);

        pLeft.setLayout(new FlowLayout());

        JButton b1 = new JButton("盖伦");
        JButton b2 = new JButton("提莫");
        JButton b3 = new JButton("安妮");

        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);

        JPanel pRight = new JPanel();
        JLabel lPic = new JLabel("");

        ImageIcon i = new ImageIcon("/Users/apple/Downloads/编程素材/pics/gareen.jpg");
        lPic.setIcon(i);

        pRight.add(lPic);

        pRight.setBackground(Color.lightGray);
        pRight.setBounds(10, 150, 300, 60);

        // 创建一个水平JSplitPane，左边是p1,右边是p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // 设置分割条的位置
        sp.setDividerLocation(80);

        // 把sp当作ContentPane
        f.setContentPane(sp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        switchPic(b1, "gareen", lPic);
        switchPic(b2, "teemo", lPic);
        switchPic(b3, "annie", lPic);
    }

    private static void switchPic(JButton b1, String fileName, JLabel lPic) {
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("/Users/apple/Downloads/编程素材/pics/" + fileName + ".jpg");
                lPic.setIcon(i);
            }
        });

    }
}
