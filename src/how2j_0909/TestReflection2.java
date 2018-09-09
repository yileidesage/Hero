package how2j_0909;

/**
 * 在对象方法前，加上修饰符synchronized ，同步对象是当前实例。
 * 那么如果在类方法前，加上修饰符 synchronized，同步对象是什么呢？
 * 当synchronized修饰静态方法的时候， 同步对象就是这个类的类对象。
 * 如代码中的例子，当第一个线程进入method1的时候，需要占用TestReflection.class才能执行。
 * 第二个线程进入method2的时候进不去，只有等第一个线程释放了对TestReflection.class的占用，才能够执行。
 * 反推过来，第二个线程也是需要占用TestReflection.class。 那么TestReflection.class就是method2的同步对象。
 * 换句话说，静态方法被修饰为synchronized的时候，其同步对象就是当前类的类对象。
 * 编写代码进行验证
 */
public class TestReflection2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(){
            public void run(){
                //调用method1
                TestReflection2.method1();
            }
        };
        t1.setName("第一个线程");
        t1.start();

        //保证第一个线程先调用method1
        Thread.sleep(1000);

        Thread t2= new Thread(){
            public void run(){
                //调用method2
                TestReflection2.method2();
            }
        };
        t2.setName("第二个线程");
        t2.start();
    }

    public static void method1() {

        synchronized (TestReflection.class) {
            // 对于method1而言，同步对象是TestReflection.class，只有占用TestReflection.class才可以执行到这里
            System.out.println(Thread.currentThread().getName() + " 进入了method1方法");
            try {
                System.out.println("运行5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public static synchronized void method2() {
        // 对于mehotd2而言，必然有个同步对象，通过观察发现，当某个线程在method1中，占用了TestReflection.class之后
        // 就无法进入method2，推断出，method2的同步对象，就是TestReflection.class
        System.out.println(Thread.currentThread().getName() + " 进入了method2方法");
        try {
            System.out.println("运行5秒");
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}
