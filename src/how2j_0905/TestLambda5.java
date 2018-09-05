package how2j_0905;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
方法引用
引用静态方法

首先为TestLambda 添加一个静态方法:
public static boolean test(Hero){
return h.hp>100&&h.damage<50;}

Lambda表达式:
filter(heros,h->h.hp>100&&h.damage<50);

在Lambda表达式中调用这个静态方法
filter(heros,h->TestLambda.testHero(h))

调用静态方法还可以改写为:
filter(heros,TestLambda::testHero)
这种方式就叫引用静态方法

//引用对象方法,与引用静态方法很类似,只是传递方法的时候,需要一个对象的存在
TestLambda5 testLambda=new TestLambda();
filter(heros,testLambda::testHero);
 */
public class TestLambda5 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));

        }
        System.out.println("初始化后的集合:");
        System.out.println(heros);
        HeroChecker c = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };
        System.out.println("使用你名气类过滤");
        filter(heros, c);
        System.out.println("使用Lambda表达式");
        filter(heros, h -> h.hp > 100 && h.damage < 50);
        System.out.println("在Lambda表达式中使用静态方法");
        filter(heros, h -> TestLambda5.testHero(h));
        System.out.println("直接引用静态方法");
        filter(heros, TestLambda5::testHero);

        //引用对象方法,与引用静态方法很类似,只是传递方法的时候,需要一个对象的存在
        TestLambda5 testLambda = new TestLambda5();
        System.out.println("引用对象的方法的过滤结果,(注意对象的方法不能是静态方法)");
        filter(heros, testLambda::testHero2);

    }

    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }

    public static boolean testHero(Hero h) {
        return h.hp > 100 && h.damage < 50;
    }

    public boolean testHero2(Hero h) {
        return h.hp > 100 && h.damage < 50;
    }
}

