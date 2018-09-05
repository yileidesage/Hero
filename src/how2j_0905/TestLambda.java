package how2j_0905;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
假设一个场景,找出满足条件的Hero
从普通方法\匿名类\以及Lambda这几种方式,逐渐引入Lambda的概念
使用一个普通方法,在for循环便利中进行条件判断,筛选出满足条件的数据
hp>100&&damage<50
 */
public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));

        }
        System.out.println("初始化后的集合:");
        System.out.println(heros);
        System.out.println("筛选出hp>100&&damage<50的英雄:");
        filter(heros);
    }

    private static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if (hero.hp > 100 && hero.damage < 50)
                System.out.print(hero);
        }
    }

}
