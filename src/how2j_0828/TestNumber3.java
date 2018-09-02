package how2j_0828;
/*
借助Math的方法，计算自然对数，找出自己计算与Math.E区别
 */
public class TestNumber3 {
    public static void main(String[] args) {
        System.out.println(Math.E);
        int n=Integer.MAX_VALUE;
        System.out.println(Math.pow(1+1d/n,n   ));
        System.out.println(Math.pow(1+1/n,n   ));
        //1+1/n，两个整数相加，结果强制成int所以：1+1/n=1
        System.out.println(1+1/5);//结果为1
        System.out.println(1+1d/5);//结果为1.2
        //通过在数字后面加f或者d，使某个整数转换成浮点数，
        // 从而加减后得浮点数结果，否则只能强制得到整数的结果
        long[] maxN=new long[]{Byte.MAX_VALUE,Short.MAX_VALUE,Integer.MAX_VALUE,Long.MAX_VALUE};
        for (long m:maxN
             ) {
            double e=Math.pow(1+1d/m,m);
            System.out.println(e);

        }


    }
}
/*
 */