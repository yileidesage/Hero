package how2j_0905;

/*
从匿名类演变成Lambda表达式
Lambda表达式可以看出是匿名类一点点演变过来的

1.匿名类的正常写法
HeroChecker checker=new HeroChecker(){
public boolean tests(Hero h){
return(h.hp>100&&damage<50); }}

2.把外面的壳子去掉,只保留方法参数和方法体
参数和方法体之间加上符号:->
HeroCheck c2=(Hero h)->{
return h.hp>100&&h.damage<50;}

3.把return和{}去掉
HeroCheck.c3=(Hero h)->h.hp>100&&h.damage<50;

4.把参数类型和圆括号去掉(只有一个参数的时候,才可以去掉圆括号)
HeroCheck.c4=h->h.hp>100&&h.damage<50;

5.把c4作为参数传递进去
filter(heros,c4)

6.直接把表达式传递进去
filter(heros,h->h.hp>100&&h.damage<50;)

与匿名类概念向比较,Lambda其实就是匿名方法,这是一种把方法作为参数进行传递的思想
虽然代码是这么写
但是Java会在背后,悄悄地,把这些都还原成匿名类方式
引入Lambda表达式,会是的代码更加紧凑,而不是各类接口和匿名类到处飞.

Lambda表达式虽然带来了代码的间接,但是也有其局限性
1.可读性差,与啰嗦的但是清洗的匿名类代码结构比较起来,Lambda表达式一旦变得比较差,就难以理解
2.不便于调试,很难再Lambda表达式中增加调试信息,比如日志
3.版本支持,Lambda表达式在JDK8版本中才开始支持,如果使用的是以前的版本,考虑系统稳定性等原因,而不愿意升级,那么久无法使用

Lambda比价适合用在简短的业务代码中,并不适合在复杂的系统中,会加大维护成本.



 */
public class TestLambda4 {
}
