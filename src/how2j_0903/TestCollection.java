package how2j_0903;
/*
ArrayList
使用数组的局限性
如果要存放多个对象,可以使用数组,但是数组有局限性
比如声明长度是10的数组,不用的数组就浪费了,超过10的个数,又放不下
为了解决数组的局限性,引入容器类的概念
最常见的容器类就是ArrayList
容器的容量"capacity"会随着对象的增加自动增长
只需要不断往容器里增加对象即可,不用担心会出现数组的边界问题
 */

import java.util.ArrayList;


public class TestCollection {
    public static void main(String[] args) {
        //容器类ArrayList,用于存放对象
        ArrayList heros = new ArrayList();
        heros.add(new Hero("盖伦"));
        System.out.println(heros.size());

        //容器的容量capacity,会随着对象的增加,自动增长
        //只需要不断往容器里增加英雄即可,不需要担心数组的边界问题
        heros.add(new Hero("timo"));
        System.out.println(heros.size());
    }
}
