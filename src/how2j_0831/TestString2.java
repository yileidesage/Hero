package how2j_0831;

/*
String和StringBuffer的性能区别

生成10位长度的随机字符串
先使用String的+,连接10000个随机字符串,计算消耗的时间
再使用StringBuffer连接10000个随机字符串,计算消耗的时间

使用System.currentTimeMills()获取当前时间

1.定义随机字符串生成的方法
2.通过该方法生成长度为10的字符串
3.for循环,用String的+,将一个空字符串,加10000次长度为10的随机字符串
4.循环开始前后,分别统计当前的毫秒时间
5.时间的差值就是程序运行的消耗时间
6.用StringBuffer的append方法,重复一次
7.分别输出:通过XX方法,连续XX次,耗时XX毫秒%n

 */
public class TestString2 {
    public static void main(String[] args) {
        String s=randomString(10);
        System.out.println(s);

        int total=10000;
        StringBuffer sb=new StringBuffer();

        String str1="";
        long start=System.currentTimeMillis();
        for (int i = 0; i <total ; i++) {
            str1+=s;

        }
        long end=System.currentTimeMillis();
        System.out.printf("使用字符串连接+的方式,连续%d次,耗时%d毫秒%n",total,end-start);

         total*=100;
        long start2=System.currentTimeMillis();
        for (int i = 0; i <total ; i++) {
            sb.append(s);

        }
        long end2=System.currentTimeMillis();
        System.out.printf("使用StringBuffer的方式,连接%d次,耗时%d毫秒%n",total,end2-start2);

        int total2=3000000;

        MyStringBuffer msb=new MyStringBuffer();
        StringBuffer sb2=new StringBuffer();

        start=System.currentTimeMillis();
        for (int i = 0; i <total2 ; i++) {
            sb2.append(s);
        }
        end=System.currentTimeMillis();
        System.out.printf("使用StringBuffer的方式,连接%d次,耗时%d毫秒%n",total2,end-start);

        start=System.currentTimeMillis();
        for (int i = 0; i <total2 ; i++) {

        }
        end=System.currentTimeMillis();
        System.out.printf("使用MyStringBuffer的方式,连接%d次,耗时%d毫秒%n",total2,end-start);
        //当次数为两百万次及以下的时候,MyStringBuffe的性能要优于StringBuffer
        //超过三百万次,则相反StringBuffer的性能会优于MyStringBuffer



    }




    public static String randomString(int length){
        String pool="";
        for (short i = '0'; i <'9' ; i++) {
            pool+=(char)i;

        }
        for (short i = 'a'; i <'z' ; i++) {
            pool+=(char)i;

        }
        for (short i = 'A'; i <'Z' ; i++) {
            pool+=(char)i;

        }
        char[] cs=new char[length];
        for (int i = 0; i <cs.length ; i++) {
            int index=(int)(Math.random()*pool.length());
            cs[i]=pool.charAt(index);

        }
        String result=new String(cs);
        return result;


    }
}
