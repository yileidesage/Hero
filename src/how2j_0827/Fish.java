/*
1. 创建Fish类，它继承Animal类
2. 重写Animal的walk方法以表明鱼不能走且没有腿。
3. 实现Pet接口
4. 无参构造方法
5. 提供一个private 的name属性
 */
package how2j_0827;

public class Fish extends Animal implements Pet{
    private String name;
    public void walk(){
        System.out.println("因为鱼只有"+legs+"条腿，所以不能走路");
    }
    public void eat(){
        System.out.println("鱼吃虾米");
    }
    public String getName(String name){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void play(){
        System.out.println("fish is playing");
    }
    public Fish(){
        super(0);
    }
}
