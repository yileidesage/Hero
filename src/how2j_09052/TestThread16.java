package how2j_09052;
/*
交互
线程之间有交互通知的需求,考虑如下情况
有两个线程,处理同一个英雄
一个加血,一个减血
减血的进程,发现血量=1,就停止减血,指导加血的英雄加了血,才可以继续减血

考虑解决方案如下
首先故意设计减血线程的频率更高,盖伦的血量迟早会达到1
减血过程中使用while循环判断是否是1,如果血量是1,就不同的循环,指导加血线程回复了血量
这是不好的解决方式,因为会大量占用CPU,拖慢性能

 */

public class TestThread16 {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    //因为减血更快,所以盖伦的血量迟早会达到1
                    //使用while循环判断是否是1,如果是1,就不停的循环
                    //直到加血线程回了血量
                    while (gareen.hp == 1) {
                        continue;
                    }
                    gareen.hurt();
                    System.out.printf("t1为%s减血1点,减少血后%s的血量是%.0f%n", gareen.name, gareen.name, gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    gareen.recover();
                    System.out.printf("t2为%s回血1点,增加血后,%s的血量是%.0f%n", gareen.name, gareen.name, gareen.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}
