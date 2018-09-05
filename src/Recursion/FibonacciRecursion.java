package Recursion;
/*
假设一种兔子,它出生两天后,开始以每天1只的速度繁殖后代,
假设第一天有第一只这样的兔子,第3天开始繁殖后代,那么第11天,总共有多少只?
该数列的结果就是斐波那契数列
假设为第n天,第n天总计有f(n)只兔子
初始条件:
n=0,f(n)=0,
n=1,f(n)=1,
n=2,f(n)=1
递归关系:f(n)=f(n-1)+f(n-2)
总和:account=f(n)+f(n-1)+f(n-2)....+1

*/

public class FibonacciRecursion {
    public int fibonacci(int day) {
        if (day == 0) {
            return 0;
        } else if (day == 1 || day == 2) {
            return 1;
        } else {
            int n = fibonacci(day - 1) + fibonacci(day - 2);
            return n;
        }
    }

    //更简洁的写法
    public long fib(int day) {
        return day == 0 ? 0 : (day == 1 || day == 2 ? 1 : fib(day - 1) + fib(day - 2));
    }

    //测试
    public static void main(String[] args) {
        FibonacciRecursion f1 = new FibonacciRecursion();
        System.out.println("第11天的动物数量为:" + f1.fibonacci(11));
        System.out.println("第11天的动物数量为:" + f1.fib(11));
    }
}
