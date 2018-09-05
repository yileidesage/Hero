package how2j_0905;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
使用Lambda方式筛选出数据
filter(heros,(h)->h,hp>100&&h.damage<50);

同样是调用filter方法,从上一步的传递匿名类对象,变成了传递一个Lambda表达式进去

h->h.hp>100&&h.damage<50
 */
public class TestLambda3 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));

        }
        System.out.println("初始化后的集合:");
        System.out.println(heros);
        System.out.println("使用Lambda的方式,筛选出hp>100&damage<50的英雄");
        filter(heros, h -> h.hp > 100 && h.damage < 50);
    }

    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }
}
