package Recursion;
/*
有三根细柱ABC,A柱上套着6个圆盘,圆盘的大小都不一样,它们按照从大到小的顺序,自下而上的摆放
现在我们需要把A柱上的圆盘全部移动到B柱上去,并且在移动过程中,有如下约定

1.一次只能移动柱子最上端的一个圆盘
2.小圆盘上不能放大圆盘
此时约定,将一个圆盘从一根柱子,移动到另一根柱子算移动一次,
那么将6个圆盘全部从A移动到B,需要移动多少次?

假设圆盘数量为n,移动次数为H(n)
边界条件:当n=0时,H(n)=0
递归关系:H(n)=2H(n-1)+1
总:moveCount=H(n)+2H(n-1)+1

 */

public class HanoiRecursion {
    public void hannoi(int n, char x, char y, char z) {//n,汉诺塔的层数,xyz代表ABC柱,帮助思考
        //H(0)=0
        if (n == 0) {
            //什么也不做
        } else {
            //递推公式:H(n)=2H(n-1)+1
            hannoi(n - 1, x, y, z);
            System.out.println(x + "->" + y);
            hannoi(n - 1, x, y, z);
        }

    }

    public int hanoiCount(int n, char x, char y, char z) {
        int moveCount = 0;
        if (n == 0) {
            return 0;
        } else {
            moveCount = moveCount + 2 * hanoiCount(n - 1, x, y, z) + 1;
            return moveCount;
        }
    }

    //测试
    public static void main(String[] args) {
        HanoiRecursion hanoi1 = new HanoiRecursion();
        System.out.println("moveCount=" + hanoi1.hanoiCount(6, 'A', 'B', 'C'));

    }
}
