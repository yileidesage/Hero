package how2j_0905;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
匿名类实现条件筛选
首先准备一个接口HeroChecker,提供一个test(Hero)方法
然后通过匿名类的方式,实现这个接口

HeroChecker checker=new HeroChecker(){
public boolean test(Hero){
return (h.hp>100&&h.damage<50);
} }

接着调用filter,传递这个checker进去进行判断,这种方式很想通过Collections.sort在对一个Hero集合排序,
需要传一个Comparator的匿名类对象进去一样
 */
public class TestLambda2 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));

        }
        System.out.println("初始化后的集合:");
        System.out.println(heros);
        System.out.println("使用匿名类的方式,筛选出hp>100&damage<50的英雄");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };
        filter(heros, checker);
    }

    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }
}
