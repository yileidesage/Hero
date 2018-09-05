package how2j_09052;
/*
线程安全的类
如果一个类,其方法都是有synchronized的,那么该类就叫做线程安全的类
同一时间,只有一个线程能够进入这种累的一个实例去修改数据,进而保证实例中的数据的安全
(不会同时被多线程修改而变成脏数据)

HashMap和Hashtable的区别
HashMap和Hashtable都实现了Map接口,都是键值对保存数据的方式
区别1:
HashMap可以存放null
Hashtable不可以存放null
键值和值都是的

区别2:
HashMap不是线程安全的类
Hashtable是线程安全的类

StringBuffer和StringBuilder的区别
StringBuffer是线程安全的
StringBuilder是非线程安全的
所以当进行大量字符串拼接操作的时候,如果是单线程就用StringBuilder会快一些,
如果是多线程,就需要使用StringBuffer保证数据的安全性
非线程安全类不需要同步,省略了些时间

ArrayList和Vector的区别

Vector是线程安全的类,而ArrayList是非线程安全的
换句话说,多个线程可以同时进入一个ArrayList对象的add方法
借助Collections.synchronizedList,可以把ArrayList转化为非线程安全的List
与此类似的,还有HashSet,LinkedList,HashMap等等非线程安全的类,都通过工具类Collections转换未线程安全类

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestThread14 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Collections.synchronizedList(list1);
    }
}

