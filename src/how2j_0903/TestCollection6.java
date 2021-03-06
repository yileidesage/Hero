package how2j_0903;

import java.util.LinkedList;

/*
LinkedList
序列分先进先出FIFO,先进后出FILO
FIFO在Java中又叫Queue队列
FILO在Java中又叫Stack栈

LinkedList与List接口
与ArrayList一样,LinkedList也实现了List接口,诸如add,remove,contains等等方法
详细使用,请参考ArrayList常用方法.
除了实现List接口外,LinkedList还实现了双向链表结构Deque,可以很方便在头尾插入删除数据

什么是链表结构:与数组结构相比较,数组结构,就好像是电影院,每个位置有标识,每个位置之间的间隔都是一样的
而链表就相当于佛珠,每个珠子,只连接前一个和后一个,不用关心除此之外的其他佛珠在哪里


 */
public class TestCollection6 {
    public static void main(String[] args) {
        //LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll = new LinkedList<Hero>();

        //可以很方便的在头部和尾部插入数据
        //在尾部插入新的对象
        ll.addLast(new Hero("hero1"));
        ll.addLast(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);

        //在前面插入新的对象
        ll.addFirst(new Hero("heroX"));
        System.out.println(ll);

        //查看最前面的对象
        System.out.println(ll.getFirst());

        //查看最后面的对象
        System.out.println(ll.getLast());

        //查看不会导致对象被删除
        System.out.println(ll);

        //取出最前面的对象
        System.out.println(ll.removeFirst());

        //取出最后面的对象
        System.out.println(ll.removeLast());

        //取出会导致对象被删除
        System.out.println(ll);
    }
}
