package how2j_0903;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
队列Queue
LinkedList除了实现List和Deque以外,还实现了Queue接口(队列)
Queue是先进先出队列FIFO,常用方法:
offer,在最后添加元素
poll,取出第一个元素
peek,查看第一个元素
 */
public class TestCollection7 {
    public static void main(String[] args) {
        //和ArrayList一样,LinkedList也实现了List接口
        List ll = new LinkedList<Hero>();
        //LinkedList相比于ArrayList,还实现了Deque,进而实现了Queue这个接口
        //Queue代表FIFO先进先出的队列
        Queue<Hero> q = new LinkedList<Hero>();

        //加在队列最后面
        System.out.printf("队列初始化:\t");
        q.offer(new Hero("hero1"));
        q.offer(new Hero("hero2"));
        q.offer(new Hero("hero3"));
        q.offer(new Hero("hero4"));
        System.out.println(q);
        System.out.printf("把第一个元素poll()出来:\t");
        //取出第一个Hero,FIFO先进先出
        Hero h = q.poll();
        System.out.println(h);
        System.out.printf("取出第一个元素之后的队列:\t");
        System.out.println(q);
        //把第一个拿出来看一看,但是不取出来
        h = q.peek();
        System.out.printf("查看peek()第一个元素:\t");
        System.out.println(h);
        System.out.printf("查看并不比导致第一个元素被取出来:");
        System.out.println(q);
        ;
    }
}
