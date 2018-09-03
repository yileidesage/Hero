package how2j_0903;
/*
遍历
用for循环遍历
通过size() get(),分别获得指定元素的位置,结合for循环,就可以遍历出ArrayList的内容

使用迭代器Iterator遍历集合中的元素
迭代器,从空的位置开始判断,hasNext判断是否有下一个,如果有,就取出来,然耨指针往下移
指导移动到最后一个位置,hasNext返回false,表示后面没有数据了额,迭代完毕

 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCollection5 {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        //放5个对象进容器
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero name" + i));

        }
        //第一种遍历 for循环
        System.out.println("for循环");
        for (int i = 0; i < heros.size(); i++) {
            Hero h = heros.get(i);
            System.out.println(h);

        }

        //第二种遍历,使用迭代器遍历
        System.out.println("迭代器:");
        Iterator<Hero> it = heros.iterator();
        //从最开始的位置判断"下一个"位置是否有数据
        //如果有,就通过next取出来,并且把指针往下移
        //直到下一个位置没有数据
        //迭代器的while写法
        while (it.hasNext()) {
            Hero h = it.next();
            System.out.println(h);
        }
        //迭代器的for写法
        System.out.println("使用for的iterator");
        for (Iterator<Hero> iterator = heros.iterator(); iterator.hasNext(); ) {
            Hero hero = (Hero) iterator.next();
            System.out.println(hero);
        }
        //增强型for循环可以非常方便的遍历ArrayList中的元素,这是很多开发人员的首选
        //不过增强型for循环也有不足:无法用来进行ArrayList的初始化
        //以及无法得知当前是第几个元素了,比如只需要打印单数元素的时候,就做不到了,必须再自定义下标变量
        System.out.println("增强型for循环");
        for (Hero h : heros) {
            System.out.println(h);
        }
    }


}
