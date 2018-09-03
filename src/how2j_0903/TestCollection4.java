package how2j_0903;

import java.util.ArrayList;
import java.util.List;

/*
泛型Generic
不指定泛型的容器,可以存放任何元素
指定了泛型的容器,只能存放指定类型的元素及其子类
 */
public class TestCollection4 {
    public static void main(String[] args) {
        //对于不使用泛型的容器,可以往里面放英雄,也可以往里面放物品
        List heros = new ArrayList();
        heros.add(new Hero("盖伦"));

        //本来用于放英雄的容器,也可以用来放物品了
        heros.add(new Item("冰杖"));

        //对象转型会出现问题
        Hero h1 = (Hero) heros.get(0);
        //尤其是在容器里放的对象太多的时候,就不清楚哪个位置放的是哪个类型的对象了
        //Hero h2=(Hero)heros.get(1);

        //引入泛型Generic
        //声明容器的时候,就指定了这种容器,只能放Hero,放其他的就会出错
        List<Hero> genericheros = new ArrayList<Hero>();
        genericheros.add(new Hero("盖伦"));
        //如果不是Hero类型,就放不进去
        //genericheros.add(new Item("冰杖"));

        //除此之外,还能存放Hero的子类
        genericheros.add(new APHero("teemo"));

        //并且在取出数据的时候,不需要再进行转型了,因为里面放的坑定是Hero或者其子类
        Hero h = genericheros.get(0);

        //为了不使编译器出现警告,需要前后都使用泛型,像这样:
        List<Hero> heros2 = new ArrayList<Hero>();
        //JDK7提供给了一个可以缩略减少代码量的泛型简写方式
        List<Hero> heros3 = new ArrayList<>();

    }
}
