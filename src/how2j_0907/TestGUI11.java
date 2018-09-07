package how2j_0907;
/*
练习-模态与大小变化
首先设计一个JFrame,上面有一个按钮，文字是 "打开一个模态窗口"。
点击该按钮后，随即打开一个模态窗口。
在这个模态窗口中有一个按钮，文本是 "锁定大小", 点击后，这个模态窗口的大小就被锁定住，不能改变。 再次点击，就回复能够改变大小
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestGUI11 {
    public static void main(String[] args) {

        //普通的窗体，带最大和最小化按钮
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("打开一个模态窗口");
        b.setBounds(50, 50, 280, 30);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog d = new JDialog(f);
                d.setTitle("这是一个模态窗口");
                d.setModal(true);
                d.setSize(200, 150);
                d.setLocationRelativeTo(f);

                JButton b = new JButton("锁定大小");
                d.add(b);
                b.addActionListener(new ActionListener() {
                    boolean resizable = false;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        d.setResizable(resizable);
                        resizable = !resizable;
                        b.setText(resizable ? "解锁大小" : "锁定大小");
                    }
                });

                d.setVisible(true);
            }
        });

        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}