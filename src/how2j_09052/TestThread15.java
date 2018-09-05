package how2j_09052;
/*
当业务比较复杂,多线程应用里有可能会放生死锁

演示死锁
1.线程1,首先占有对象1,接着试图占有对象2
2.线程2,首先占着对象2,接着试图占有对象1
3.线程1等待着线程2释放对象2
4.同时线程2等着线程1释放对象1
就产生死锁
 */

public class TestThread15 {
    public static void main(String[] args) {
        final Hero ahri = new Hero();
        ahri.name = "九尾妖狐";
        final Hero annie = new Hero();
        annie.name = "安妮";

        Thread t1 = new Thread() {
            public void run() {
                //占有九尾妖狐
                synchronized (ahri) {
                    System.out.println("t1已占有九尾妖狐");
                    try {
                        //停顿1000毫秒,另一个线程有足够的时间占有安妮
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 试图占有安妮");
                    System.out.println("t1等待中......");
                    synchronized (annie) {
                        System.out.println("t1占领安妮成功");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                //占有安妮
                synchronized (annie) {
                    System.out.println("t2已占有安妮");
                    try {
                        //停顿1000毫秒,等待t1有足够的时间占领九尾妖狐
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2试图占有九尾妖狐");
                    System.out.println("t2等待中........");
                    synchronized (ahri) {
                        System.out.println("t2占领九尾妖狐成功");
                    }
                }

            }
        };
        t2.start();
    }
}
