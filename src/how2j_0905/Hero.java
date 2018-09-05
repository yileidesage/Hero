package how2j_0905;
/*
假设Hero有三个属性:name,hp,damage
一个集合存放10个Hero,通过Collections.sort对这10个进行排序
那么到底是hp小的放前面,还是damage小的放前面?
Collections.sort也无法确定
所以要知道到底按照那种属性进行排序
这里就需要提供一个Comparator给定如何进行两个对象之间的大小比较
 */

public class Hero implements Comparable<Hero> {
    public String name;
    public float hp;
    public int damage;

    public Hero() {

    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public int compareTo(Hero anotherHero) {
        if (damage < anotherHero.damage)
            return 1;
        else
            return -1;
    }

    public String toString() {
        return "Hero[name=" + name + ",hp=" + hp + ",damage=" + damage + "]\r\n";
    }
}
