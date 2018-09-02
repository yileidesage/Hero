/*
1. 该类必须包含String属性来存宠物的名字。
2. 定义一个构造器，它使用String参数指定猫的名字；该构造器必须调用超类构造器来指明所有的猫都是四条腿。
3. 另定义一个无参的构造器。该构造器调用前一个构造器（用this关键字）并传递一个空字符串作为参数
4. 实现Pet接口方法。
5. 实现eat方法。
出错的位置
public Cat(){
        this(name);
出错的原因
超类构造器是指调用父类构造器，调用的时候需要返回父类构造器要的参数：字符串，而不是返回属性所以出错

 */

package how2j_0827;

public class Cat extends Animal implements Pet{
    String name;
    public Cat(String name){
        super(4);
        this.name=name;
    }
    public Cat(){
        this("");

    }
    public String getName(String name){
        System.out.println("猫的名字是"+name);
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void play(){
        System.out.println("猫喜欢玩毛线");
    }
    public void eat(){
        System.out.println("猫吃鱼");
    }

}
