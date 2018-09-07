package how2j_0907;
/*
参考练习-百万富翁，把 网页版的复利计算器 改成swing来做

复利公式：
F = p* ( (1+r)^n );
F 最终收入
p 本金
r 年利率
n 存了多少年

假设情景一：
p = 10000
r = 0.05
n = 1

解读：
本金是10000
年利率是5%
存了一年 1次
复利收入 10000*( (1+0.05)^1 ) = 10500

假设情景二：
p = 10000
r = 0.05
n = 2

解读：
本金是10000
年利率是5%
存了两年
复利收入 10000*( (1+0.05)^2 ) = 11025
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class TestGUI43 {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setLayout(null);

        f.setSize(400, 400);
        f.setLocation(200, 200);
        int gap = 10;
        JPanel pInput = new JPanel();
        pInput.setLayout(new GridLayout(4, 6, gap, gap));
        pInput.setBounds(gap, gap, 375, 120);

        JLabel lInit = new JLabel("起始资金");
        JLabel lRate = new JLabel("每年收益");
        JLabel lYear = new JLabel("复利年数");
        JLabel lInverst = new JLabel("每年追加资金");

        JTextField tfInit = new JTextField("12000");
        JTextField tfRate = new JTextField("20");
        JTextField tfYear = new JTextField("2");
        JTextField tfInvest = new JTextField("12000");

        JLabel lInitSign = new JLabel("￥");
        JLabel lRateSign = new JLabel("%");
        JLabel lYearSign = new JLabel("年");
        JLabel lInvestSign = new JLabel("￥");

        pInput.add(lInit);
        pInput.add(tfInit);
        pInput.add(lInitSign);

        pInput.add(lRate);
        pInput.add(tfRate);
        pInput.add(lRateSign);

        pInput.add(lYear);
        pInput.add(tfYear);
        pInput.add(lYearSign);

        pInput.add(lInverst);
        pInput.add(tfInvest);
        pInput.add(lInvestSign);

        JPanel pResult = new JPanel();
        pResult.setLayout(new GridLayout(4, 6, gap, gap));

        JLabel lBaseSum = new JLabel("本金和");
        JLabel lInterestSum = new JLabel("利息和");
        JLabel lTotalSum = new JLabel("本息和");

        JTextField tfBaseSum = new JTextField();
        JTextField tfInterestSum = new JTextField();
        JTextField tfTotalSum = new JTextField();

        JLabel lBaseSumSign = new JLabel("￥");
        JLabel lInterestSumSign = new JLabel("￥");
        JLabel lTotalSumSign = new JLabel("￥");

        pResult.add(lBaseSum);
        pResult.add(tfBaseSum);
        pResult.add(lBaseSumSign);

        pResult.add(lInterestSum);
        pResult.add(tfInterestSum);
        pResult.add(lInterestSumSign);

        pResult.add(lTotalSum);
        pResult.add(tfTotalSum);
        pResult.add(lTotalSumSign);

        JButton b = new JButton("计算");
        b.setBounds(150, 120 + 30, 80, 30);
        pResult.setBounds(gap, 150 + 60, 375, 120);

        f.add(pInput);
        f.add(b);
        f.add(pResult);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        b.addActionListener(new ActionListener() {

            boolean checkedpass = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                checkedpass = true;
                check(tfInit, "起始资金");
                check(tfRate, "每年收益");
                check(tfYear, "复利年数");
                check(tfInvest, "每年追加资金");

                if (checkedpass) {
                    int init = Integer.parseInt(tfInit.getText());
                    int rate = Integer.parseInt(tfRate.getText());
                    int year = Integer.parseInt(tfYear.getText());
                    int invest = Integer.parseInt(tfInvest.getText());

                    int baseSum = (year - 1) * invest + init;
                    int totalSum = (int) (invest * fuli((1 + (double) rate / 100), (year - 1)) + init * Math.pow((1 + (double) rate / 100), year));
                    int interestSum = totalSum - baseSum;

                    tfBaseSum.setText(String.format("%,d", baseSum));

                    tfInterestSum.setText(String.format("%,d", interestSum));
                    tfTotalSum.setText(String.format("%,d", totalSum));
                }
            }

            private int fuli(double rate, int year) {
                int result = 0;
                for (int i = year; i > 0; i--) {
                    result += Math.pow(rate, i);
                }
                return result;
            }

            private void check(JTextField tf, String msg) {
                if (!checkedpass)
                    return;
                String value = tf.getText();
                if (0 == value.length()) {
                    JOptionPane.showMessageDialog(f, msg + " 不能为空");
                    tf.grabFocus();
                    checkedpass = false;
                    return;
                }
                try {
                    Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(f, msg + " 必须是整数");
                    tf.grabFocus();
                    checkedpass = false;
                }
            }
        });
    }

}