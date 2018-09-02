package how2j_0830;

/*
异常分类，3类：
可查异常、运行异常、错误
其中运行时异常和错误又叫非可查异常
可查异常：CheckedException
可查异常即必须进行处理的异常，要么try catch住，要么往外抛，谁调用，谁处理
比如：FileNotFoundException
如果不处理，编译器就不让你通过

运行时异常RuntimeException指：不是必须进行try catch的异常
常见运行时异常
1.除数不能为0异常：ArithmeticException
2.下标越界异常：ArrayIndexOutOfBoundsException
3.空指针异常：NullPointerException
在代码编写的时候，依然可以try catch throws进行处理，与可查异常不同之处在于：
即便不进行try catch，也不会有编译错误
Java之所以会设计运行时异常的原因之一，是因为下标越界，空指针这些运行时异常，太过于普遍，
如果都需要进行捕捉，代码的可读性就会变得很糟糕

错误Error,指的是系统级别的异常,通常是内存用光了
在默认设置下，一般Java程序启动的时候，最大可以使用16m的内存
如例不停的歌StringBuffer追加字符，很快就把内存用光了，抛出OutOfMemoryError
与运行时异常一样，错误也是不要求强制捕捉的
 */
public class TestException5 {
    public static void main(String[] args) {
        //任何除数不能为0：ArithmeticException
       // int k=5/0;
        //下标越界异常：ArrayIndexOutOfBoundsException
        int[] j=new int[5];
       // j[10]=10;
        //空指针异常：NullPointerException
        //String str=null;
       // str.length();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <6; i++) {
            sb.append('a');

        }
    }
}
