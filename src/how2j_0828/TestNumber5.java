package how2j_0828;
/*
创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
提示：
数字和字符之间可以通过转型互相转换
char c = 'A';
short s = (short) c;
通过这个手段就能够知道字符 a-z A-Z 0-9 所对应的数字的区间了

 */


import java.util.Scanner;

public class TestNumber5 {
    public static void main(String[] args) {
    /*   Scanner s=new Scanner(System.in);
       String str=s.nextLine();
       char[] str1=str.toCharArray();
       for (int i = 0; i <str1.length ; i++) {
            short c=(short)str1[i];
            System.out.print(c+" ");
        }
        */
        //没有能够限制输入字符串的长度，无法限定字符串长度5，答错
        //以下是参考答案
        char[] cs=new char[5];
       short start='0';
       short end='z'+1;
        for (int i = 0; i < cs.length; i++) {
            while(true){
                char c=(char)((Math.random()*(end-start)+start));
                //Math.random的取值范围是0.0~0.999999，【0.1）
                //
                if(Character.isDigit(c)||Character.isLetter(c)){
                    cs[i]=c;
                    break;//如果没有这个break，会没有结果输出，为什么？
                    //因为如果碰到c是字母或者数字的时候，if语句的条件判断始终为true，则会一直循环执行下去

                }
            }

        }
        String result=new String(cs);
        System.out.println(result);

        //方法二
        String pool="";
        for (short i = '0'; i <='9' ; i++) {
            pool=pool+(char)i;

        }
        for (short i = 'a'; i <='z' ; i++) {
            pool=pool+(char)i;

        }
        for (short i = 'A'; i <='Z' ; i++) {
            pool=pool+(char)i;

        }
        System.out.println(pool);
        char[] cs3=pool.toCharArray();
        char cs2[]=new char[5];
        for (int i = 0; i <cs2.length ; i++) {
            int index=(int)(Math.random()*cs3.length);
            cs2[i]=cs3[index];

        }
        System.out.println(new String(cs2));

    }

}
//pool,charAT(index)也可以实现字符串中取字符