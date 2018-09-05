package how2j_0904;
/*
HashMap存储数据的方式是---键值对

对于HashMap而言,key是唯一的,不可以充足的
所以,以相同的key把不同的value插入到Map中会导致就元素被覆盖,只留下最后插入的元素
不过,同一个对象可以作为值,插入到Map中,只要对应的key不一样
 */

import how2j_0903.Hero;

import java.util.HashMap;

public class TestCollection {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("abc", "物理英雄");
        dictionary.put("apc", "魔法英雄");
        dictionary.put("t", "坦克");

        System.out.println(dictionary.get("t"));

        HashMap<String, Hero> heroMap = new HashMap<>();
        heroMap.put("garen", new Hero("green1"));
        System.out.println(heroMap);

        //key为gareen已经有value了,再以gareen为key放入数据,会导致原value被覆盖
        //不会增加新的元素到Map中
        heroMap.put("garen", new Hero("gereen2"));
        System.out.println(heroMap);

        //清空Map
        heroMap.clear();
        Hero garen = new Hero("gareen");

        //同一个对象可以作为值插入到map中,只要对应的key不一样
        heroMap.put("hero1", garen);
        heroMap.put("hero2", garen);

        System.out.println(heroMap);
    }

}
