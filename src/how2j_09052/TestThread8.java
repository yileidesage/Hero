package how2j_09052;
/*
守护线程
当一个线程里,所有线程都是守护线程的时候,结束当前线程
就好像一个公司有销售部,生产部这些和业务挂钩的部门
除此之外还有后勤行政等部门
如果一家公司的销售部\生产部都结算了,那么只剩下后勤和行政,那么这家公司就可以解散了
守护线程相当于支持部门,如果一个进程只剩下守护线程,那么线程就会自动结束
守护线程通常会被用来做日志,性能统计等工作
 */

public class TestThread8 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                int seconds = 0;

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经连续撸码 %d秒%n", seconds++);
                }
            }
        };

        t1.setDaemon(true);
        t1.start();

    }
}
