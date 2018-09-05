package how2j_0904;
/*
ArrayList与HashSet的区别
ArrayList有顺序
HashSet无顺序

List中的数据可以重复
Set中的数据不可以重复
重复的判断标准是

首先看hashcode是否相同
如果hashcode不同,则认为是不同数据
如果hashcode相同,再比较equals,如果equals相同,则是相同数据,否则是不同数据
 */

import java.util.ArrayList;
import java.util.HashSet;

public class TestCollection4 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        //List中的数据按照插入顺序存放
        System.out.println("----------List----------");
        numberList.add(9);
        numberList.add(5);
        numberList.add(1);
        System.out.println("List按照顺序存放数据:");
        System.out.println(numberList);

        System.out.println("----------Set----------");
        HashSet<Integer> numberSet = new HashSet<>();
        //Set中的数据不是按照顺序存放
        numberSet.add(9);
        numberSet.add(5);
        numberSet.add(1);
        System.out.println("Set不是按照顺序存放数据:");
        System.out.println(numberSet);

        //重复
        System.out.println("在两个容器中都插入9,结果比较如下:");
        numberList.add(9);
        System.out.println("ArrayList:\n" + numberList);
        numberSet.add(9);
        System.out.println("Set:\n" + numberSet);

    }
}
