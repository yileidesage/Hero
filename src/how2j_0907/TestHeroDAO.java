package how2j_0907;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
DAO:Data Access Object
数据库访问对象
实际上就刚刚习题中的思路,把数据库相关的操作,都封装在这个类里面,其他地方看不到JDBC的代码
1.编写DAO接口
2.HeroDAO
设计类HeroDAO,实现接口DAO
这个HeroDAO和习题答案很相近,做了几个改进:
1.把驱动的初始化放在了构造方法HeroDAO李
因为驱动初始化只需要执行一次,所以放在这里更合适,其他地方也不需要写了,代码更简洁

 */
public class TestHeroDAO implements HeroInterface {
    public TestHeroDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "123456");

    }

    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("total" + total);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }


    public void add(Hero hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Hero hero) {
        String sql = "update hero set name=?,hp=?,damage=?where id=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(4, hero.id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from hero where id=" + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Hero get(int id) {
        Hero hero = null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from hero where id=" + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getInt("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<Hero> list() {
        return list(9, Short.MAX_VALUE);
    }

    @Override
    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<Hero>();
        String sql = "select * from hero order by id desc limit?,?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
                heros.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }
}
