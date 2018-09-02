package how2j_0830;

/*
Throwable
Throwable 是类，Exceptionhe Error都继承了该类
所以在捕捉的时候，也可以使用throwable进行捕捉

在方法声明上，可以抛出指定的异常，比如FileNotFoundException
那么能否抛出Throwable这个类？
这个方法的调用者又该如何处理？

可以抛出Throwable,并且在调用时必须进行catch处理，但是这样的设计方法做不好
因为不知道抛出的类型到底是哪种具体问题，无法针对性的处理

自定义异常
假设以下场景：LOL中，一个英雄攻击另一个英雄的时候，如果发现另一个英雄已经挂了
就会抛出：EnemyHeroIsDeadException

创建一个类 EnemyHeroIsDeadException,并继承Exception
提供两个构造方法
1.无参的构造方法
2.带参的构造方法，并调用父类的对应的构造方法

在Hero的attack方法中，当发现地方英雄的血量为0时，抛出该异常
1.创建一个EnemyHeroIsDeadException实例
2.通过throw抛出该异常
3.当前方法通过throws抛出该异常
在外部调用attack方法的时候，就需要进行捕捉，并且捕捉的时候
可以通过e.getMessage()获取当时出错的具体原因

 */
public class TestException7 {
    public String name;
    protected float hp;
    public void attackHero(TestException7 h) throws EnemyHeroIsDeadException{
        if(h.hp==0){
            throw new EnemyHeroIsDeadException(h.name+"已经挂了，不需要释放技能");

        }
    }
    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        TestException7 garen=new TestException7();
        garen.name="盖伦";
        garen.hp=616;

        TestException7 teemo=new TestException7();
        teemo.name="name";
        teemo.hp=0;

        try{
            garen.attackHero(teemo);
        }
        catch(EnemyHeroIsDeadException e){
            System.out.println("异常的具体原因："+e.getMessage());
            e.printStackTrace();
        }
    }
}
