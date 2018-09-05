package how2j_09052;
/*
synchronized关键字的意义
如下代码:
Object someObject=new Object();
synchronized(someObject){
//此处的代码只有只有了someObject才可以运行
}
synchronized表示当前线程,独占对象someObject
当线程独占了对象someObject,如果有其他线程试图占有对象someObject,就会等待,直到当前此线程释放对someObject的占用
为了达到tongue效果,必须使用同一个同步对象

释放同步对象的方式:synchronized块自然结束,或者有异常抛出
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread10 {
    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String args) {
        final Object someObject = new Object();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    System.out.println(now() + "t1 线程已经运行");
                    System.out.println(now() + this.getName() + "试图占有对象:someObject");
                    synchronized (someObject) {
                        System.out.println(now() + this.getName() + "占有对象:someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + "释放对象:someObject");
                    }
                    System.out.println(now() + "t1 线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                try {
                    System.out.println(now() + "t2 线程已经运行");
                    System.out.println(now() + this.getName() + "试图占有对象:someObject");
                    synchronized (someObject) {
                        System.out.println(now() + this.getName() + "占有对象:someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + "释放对象:someObject");
                    }
                    System.out.println(now() + "t2 线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName("t2");
        t2.start();

    }
}
