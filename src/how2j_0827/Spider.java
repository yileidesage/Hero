/*
1. Spider继承Animal类。
2. 定义默认构造器，它调用父类构造器来指明所有蜘蛛都是8条腿。
3. 实现eat方法
定义默认构造器的时候出错了，写的是
public void Spider(int legs){
        legs=8;
        this.legs=legs;
    }
需要联系super的用法

*/

package how2j_0827;

public class Spider extends Animal {
    @Override
    public void eat() {
        System.out.println("蜘蛛吃蚊子");

    }
    public Spider(){
        super(8);
    }

}





