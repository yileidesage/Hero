package how2j_09052;
/*
测试自建的线程池
创造一个情景,每个任务执行的时间都是一秒
然后开始时,是间隔一秒向线程池中添加任务

然后间隔时间越来越短,执行任务的线程还没有来得及结束,新的任务又来了.
就会观察到线程池里其他线程被唤醒来执行这些任务
 */

public class TestThread19 {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;
        while (true) {
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep > 100 ? sleep - 100 : sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
