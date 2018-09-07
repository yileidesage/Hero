package how2j_0907;

import java.sql.*;

/*
PrepareStatement能防止SQL注入式攻击
而Statement不能
假设name是用户提交来的数据
String name=" '盖伦'OR 1=1 ";
使用Statement就需要进行字符串拼接
拼接出来的话语就是:
select * from hero where name='盖伦'OR1=1
因为1=1是恒成立的
那么就会把所有的英雄都查出来,而不只是盖伦
如果Hero表里的数据是海量的,比如几百万条,把这个表里的数据全部查出来
会让数据库负载变高,CPU100%,内存消耗光,响应变得极其缓慢
而PrepareStatement使用的是参数设置,就不会有这个问题
 */
public class TestJDBC2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "select *from hero where name=?";

        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "123456"
        );
             Statement s = c.createStatement();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            //假设name是用户用来提交的数据
            String name = "'盖伦' OR 1=1";
            String sql0 = "select*from hero where name=" + name;
            //拼接出来的sql语句就是
            //select * from hero where name='盖伦' OR 1=1
            //因为有OR 1=1,所以恒成立
            //那么就会把所有的英雄都查出来,而不知道是盖伦
            //如果hero表里的数据是海量的,比如几百万条,把这个表里的数据全部查出来
            //会让数据库负载变高,CPU100%,内存消耗光,相应变得极其缓慢
            System.out.println(sql0);
            ResultSet rs0 = s.executeQuery(sql0);
            while (rs0.next()) {
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }
            s.execute(sql0);
            //使用预编译Statement就可以杜绝SQL注入
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            //查不出数据来
            while (rs0.next()) {
                String heroName = rs0.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
