package how2j_09052;

/*
多线程同步的问题指的是多个线程同时修改一个数据的时候,可能导致的问题
多线程问题又叫Concurrency问题

演示同步问题
假设盖伦有1000滴血,并且在基地里,同时又被对方多个英雄攻击
就是有多个线程在减少盖伦的hp
同时又有多个线程在回复盖伦的hp
假设线程的数量是一样的,并且每次改变的值都是1,那么所有线程结束后,盖伦应该还是10000滴血
但多次运行后,有个别情况下,值不为10000
原因是增加线程正在修改hp值,减少进程来了,得到一个错误的值(脏数据)

解决思路:
在增加线程访问hp期间.其他线程不可以访问hp
1.增加线程获取到的hp的值,并进行运算
2.在运算期间,减少线程师徒来获取hp的值,但是不被允许
3.增加线程运算结束,并成功修改hp的值未10001
4.减少线程在增加线程做完后,才能方位hp的值,即10001
5.减少线程运算,并得到新的值10000

 */
public class TestThread9 {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;

        System.out.printf("盖伦的初始血量是%.0f %n", gareen.hp);

        //多线程同步问题指的是多个线程同时修改一个数据的时候,导致的问题
        //假设盖伦有10000点血,并且在基地里,同时又被多个英雄攻击
        //用Java代码来表示,就是有多少个线程减少盖伦的hp
        //同时又有多个线程在恢复盖伦的hp
        //n个线程增加盖伦的hp

        int n = 10000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                public void run() {
                    gareen.recover();
                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;

        }
        //n个线程减少盖伦的hp
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                public void run() {
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;

        }
        //等待所有增加线程结束
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //等待所有减少线程结束
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //代码执行到这里,所有线程结束
        //增加和减少的线程数量是一样的,每次都增加,减少1
        //那么所有线程结束后,盖伦的hp应该还是初始值
        //但是事实上贯彻到的是

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了%.0f%n", n, n, gareen.hp);

    }


}
