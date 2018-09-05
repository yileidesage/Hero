package Recursion;

/*
用递归计算阶乘
边界条件:n=0,n!=1
递归关系:n!=n*(n-1)!
总和:n!

代码出错总结:一定要把边界条件写进去,哪怕初始值与边界条件无关
因为递归一定会到边界条件值,如果不设定,则一定会出错
 */
public class FactorialRecursion {
    public static int factoria(int a) {
        if (a == 1) {
            return 1;
        }

        int n = a * factoria(a - 1);
        return n;
    }

    public static void main(String[] args) {
        int num = factoria(5);

        System.out.println(num);
    }
}
