package how2j_0907;
/*
步骤 7 : 练习-黄鹤     顶 折 纠 问  Or    姿势不对,事倍功半! 点击查看做练习的正确姿势
把练习-黄鹤改成Swing来完成

要有为空和数字判断

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

public class TestGUI42 {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 400);
        f.setLocation(200, 200);
        int gap = 10;
        JPanel pInput = new JPanel();
        pInput.setLayout(new GridLayout(4, 3, gap, gap));

        JLabel lLocation = new JLabel("地名：");
        JTextField tfLocation = new JTextField("");

        JLabel lType = new JLabel("公司类型：");
        JTextField tfType = new JTextField("");

        JLabel lCompanyName = new JLabel("公司名称：");
        JTextField tfCompanyName = new JTextField("");

        JLabel lBossName = new JLabel("老板名称：");
        JTextField tfBossName = new JTextField("");

        JLabel lMoney = new JLabel("金额：");
        JTextField tfMoney = new JTextField("");

        JLabel lProduct = new JLabel("产品：");
        JTextField tfProduct = new JTextField("");

        JLabel lUnit = new JLabel("价格计量单位");
        JTextField tfUnit = new JTextField("");

        pInput.add(lLocation);
        pInput.add(tfLocation);
        pInput.add(lType);
        pInput.add(tfType);
        pInput.add(lCompanyName);
        pInput.add(tfCompanyName);
        pInput.add(lBossName);
        pInput.add(tfBossName);
        pInput.add(lMoney);
        pInput.add(tfMoney);
        pInput.add(lProduct);
        pInput.add(tfProduct);
        pInput.add(lUnit);
        pInput.add(tfUnit);

        f.setLayout(null);
        pInput.setBounds(gap, gap, 375, 120);

        JButton b = new JButton("生成");
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);

        b.setBounds(150, 120 + 30, 80, 30);
        ta.setBounds(gap, 150 + 60, 375, 120);

        f.add(pInput);
        f.add(b);
        f.add(ta);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        b.addActionListener(new ActionListener() {

            boolean checkedpass = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                checkedpass = true;
                checkEmpty(tfLocation, "地址");
                checkEmpty(tfType, "公司类型");
                checkEmpty(tfCompanyName, "公司名称");
                checkEmpty(tfBossName, "老板姓名");
                checkNumber(tfMoney, "金额");
                checkEmpty(tfProduct, "产品");
                checkEmpty(tfUnit, "价格计量单位");

                String location = tfLocation.getText();
                String type = tfType.getText();
                String companyName = tfCompanyName.getText();
                String bossName = tfBossName.getText();
                String money = tfMoney.getText();
                String product = tfProduct.getText();
                String unit = tfUnit.getText();

                if (checkedpass) {
                    String model = "%s最大%s%s倒闭了，王八蛋老板%s吃喝嫖赌，欠下了%s个亿，"
                            + "带着他的小姨子跑了!我们没有办法，拿着%s抵工资!原价都是一%s多、两%s多、三%s多的%s，"
                            + "现在全部只卖二十块，统统只要二十块!%s王八蛋，你不是人!我们辛辛苦苦给你干了大半年，"
                            + "你不发工资，你还我血汗钱，还我血汗钱!";
                    String result = String.format(model, location, type, companyName, bossName, money, product, unit, unit, unit, product, bossName);
                    ta.setText("");
                    ta.append(result);
                }
            }

            private void checkNumber(JTextField tf, String msg) {
                if (!checkedpass)
                    return;
                String value = tf.getText();
                try {
                    Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(f, msg + " 必须是整数");
                    tf.grabFocus();
                    checkedpass = false;
                }
            }

            private void checkEmpty(JTextField tf, String msg) {
                if (!checkedpass)
                    return;
                String value = tf.getText();
                if (0 == value.length()) {
                    JOptionPane.showMessageDialog(f, msg + " 不能为空");
                    tf.grabFocus();
                    checkedpass = false;
                }
            }
        });
    }

}
