package how2j_0907;

public class Hero {
    //增加id属性
    public int id;
    public String name;
    public float hp;
    public int damage;
    static String copyright;
    static{
        System.out.printf("获取类对象会导致静态属性被初始化,而且只会执行一次%n（除了直接使用 Class c = Hero.class 这种方式，这种方式不会导致静态属性被初始化）%n");
        copyright="版权由Riot Games公司所有";
    }
    @Override
    public String toString(){

        return  name;
    }
}
