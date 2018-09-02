/*1. 创建Animal类，它是所有动物的抽象父类。
2. 声明一个受保护的整数类型属性legs，它记录动物的腿的数目。
3. 定义一个受保护的构造器，用来初始化legs属性。
4. 声明抽象方法eat。
5. 声明具体方法walk来打印动物是如何行走的（包括腿的数目）。
作业点评：
与标准答案的差距是构造方法没有填写参数
当调用方法涉时涉及到传递仅在方法内生效的参数时，需要设定参数，方便调用方法时正确反映方法的特性
*/

package how2j_0827;

public abstract class Animal {
    protected int legs;
    protected Animal(int legs){
        this.legs=legs;
    }
    public abstract void eat();
    public void walk(){
        System.out.println("这个动物是用"+legs+"条腿走路");
    }
}


