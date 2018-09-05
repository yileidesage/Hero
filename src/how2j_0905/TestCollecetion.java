package how2j_0905;

import java.sql.SQLOutput;
import java.util.*;
import java.util.Comparator;

public class TestCollecetion {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            //通过随机值实例化hero的hp和damage
            //r.nextInt(int a) 范围0-100以内随机取整
            heros.add(new Hero("hero" + i, r.nextInt(100), r.nextInt(100)));
            System.out.println("初始化后的集合:");
            System.out.println(heros);

            //直接调用sort会出现编译类错误,因为Hero有各种属性
            //到底按照哪种属性排序,Collections也不确定,所以没法排
            //Collections.sort(heros)无法对属性类排序

            //引入Comparator.指定比较算法
            /*Comparator<Hero> c=new Comparator<Hero>() {
                @Override
                public int compare(Hero h1, Hero h2) {
                    //按照hp排序
                    if(h1.hp>=h2.hp)
                    return 1;//整数表示h1比h2大
                    else
                        return -1;
                }
            };
            Collections.sort(heros,c);
            System.out.println("按照血量排序后的集合:");
            System.out.println(heros);*/

            //Hero类实现了接口Comparable,即自带比较信息
            //Collections直接进行排序,无须额外的Comparator

            Collections.sort(heros);
            System.out.println("按照伤害高低排序后的集合");
            System.out.println(heros);


        }
    }
}
