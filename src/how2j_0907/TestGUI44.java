package how2j_0907;
/*
步骤 11 : 练习-进度条     顶 折 纠 问  Or    姿势不对,事倍功半! 点击查看做练习的正确姿势
设计一个线程，每隔100毫秒，就把进度条的进度+1。

从0%一直加到100%

刚开始加的比较快，以每隔100毫秒的速度增加，随着进度的增加，越加越慢，让处女座的使用者，干着急

变得多慢，根据你们和处女座同学，朋友的相处体验，自己把控
 */

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class TestGUI44 {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);

        f.setLayout(new FlowLayout());

        JProgressBar pb = new JProgressBar();

        pb.setMaximum(100);
        pb.setValue(0);
        pb.setStringPainted(true);

        new Thread() {
            public void run() {
                int sleep = 100;
                for (int i = 0; i < 100; i++) {
                    pb.setValue(i + 1);
                    try {

                        Thread.sleep(sleep + i * 10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        f.add(pb);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
