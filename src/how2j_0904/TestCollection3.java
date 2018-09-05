package how2j_0904;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Collection是一个接口
是Set List Queue和Deque的接口
Queue:先进先出队列
Deque:双向链表

Collections是一个类,容器的工具类,就如同Arrays是数组的工具类

reverse 反转
是List中的数据发生反转
 */
public class TestCollection3 {
    public static void main(String[] args) {
        //初始化集合numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        //集合中的数据
        System.out.println("集合中的数据:");
        System.out.println(numbers);

        Collections.reverse(numbers);

        System.out.println("反转后集合中的数据:");
        System.out.println(numbers);

        //shuffle 混淆List中数据的顺序
        //每次执行后的结果都不一样

        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);

        //sort 对List中的数据进行排序
        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);

        //swap 交换两个数据的位置

        Collections.swap(numbers, 0, 5);
        System.out.println("交换下标0和5的数据后,集合中的数据:");
        System.out.println(numbers);

        //rotate 把List中的数据,向右滚动指定单位的长度
        Collections.rotate(numbers, 2);
        System.out.println("把集合向右滚动2个单位后,集合中的数据:");
        System.out.println(numbers);

    }
}
