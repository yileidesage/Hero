package how2j_0831;

public class MyStringBuffer implements IStringBuffer{
    int capacity=16;
    int length=0;
    char[] value;

    //无参构造方法
    //value:用户存放字符的数组
    //capacity:容量

    public MyStringBuffer(){
        value=new char[capacity];//初始化一个字符数组,数组的长度等于指定的容量
    }

    //有参构造方法
    /*public MyStringBuffer(String str){
        if(null!=str)
            value =str.toCharArray();

        length = value.length;

        if(capacity<value.length)
            capacity  = value.length*2;

    }*/
    //
    public MyStringBuffer(String str){
        this();
        if(null==str)
            return;
        if(capacity<str.length()){
            capacity=value.length*2;
            value=new char[capacity];
        }
        if(capacity>=str.length()){
            System.arraycopy(str.toCharArray(),0,value,0,str.length());
        }
        length=str.length();
    }
    /*
    插入insert和append

    首先要进行边界条件判断:插入的位置是否合法,插入的字符串是否为空

    其次是扩容
    1.判断是否需要扩容,如果插入的字符串加上已经存在的内容的总长度,超过了容量,那么就需要扩容
    2.数组的长度是固定的,不能改变的,数组本身不支持扩容,我们使用变通的方式来解决这个问题
    3.根据需要插入的字符串的长度和已经存在的内容的长度,计算出一个新的容量,
    然后根据这个容量,创建一个新的数组,接着把原来的数组的内容,复制到这个新的数组中来
    并且让value这个引用,指向新的数组,从而达到扩容的效果

    插入字符串
    1.找到要插入字符串的位置,从这个位置开始,把原数据看成两段,把后半段向后移动一个距离,
    向后移动的距离,刚好是要插入的字符串的长度
    2.然后把要插入的字符串,插入这个挪出来的,刚刚好的位置里

    修改length的值
    最后修改length的值,是原来的值加上插入字符串的长度

    insert(int,char)
    参数是字符的insert方法,通过调用insert(int,String)也就实现了

    append
    追加,就是在最后位置插入,所以不需要单独开发方法,直接调用insert方法,就能达到最后插入的效果

     */

    //追加字符串
    public void append(String str)throws IndexIsNagetiveException,IndexIsOutOfRangeException{
        insert(length,str);
    }

    //追加字符
    public void append(char c)throws IndexIsNagetiveException,IndexIsOutOfRangeException{
        append(String.valueOf(c));
    }

    //指定位置插入字符
    public void insert(int pos,char b)throws IndexIsNagetiveException,IndexIsOutOfRangeException{
        insert(pos,String.valueOf(b));
    }

    //指定位置插入字符串
    public void insert(int pos,String b)throws IndexIsNagetiveException,IndexIsOutOfRangeException{
        //边界条件判断
        if(pos<0){
            throw new IndexIsNagetiveException();
        }
        if(pos>length){
            throw new IndexIsOutOfRangeException();
        }
        if(null==b){
            throw new NullPointerException();
        }
        //扩容以及将原来的数组复制到新数组,再将原来的数组指向新数组
        while(length+b.length()>capacity){
            capacity=(int)((length+b.length())*1.5f);
            char[] newValue=new char[capacity];
            System.arraycopy(value,0,newValue,0,length);
            value=newValue;
        }
        //把要插入的字符串变成字符串的数组
        char[]cs=b.toCharArray();

        //把已经存在的数组往后移动一段距离,移动的距离等于要插入的字符串的长度
        //移动的起点为插入的位置
        System.arraycopy(value,pos,value,pos+cs.length,length-pos);

        //把要插入的数据插入到指定位置
        System.arraycopy(cs,0,value,pos,cs.length);
        //修改length的值
        length=length+cs.length;

   }

    //从指定位置开始,删除剩下的
    public void delete(int start)throws IndexIsNagetiveException,IndexIsOutOfRangeException{
        delete(start,length);
    }

    //从开始位置删除结束结束位置-1;
    /*
    1.边界判断,开始位置不能小于0,结束位置不能小于0,开始位置不能超过长度,结束位置不能超过长度,开始值不能超过结束的值
    2.将数组分为两部分,从开始删除的位置,到删除结束的位置,将删除结束的位置及后面的所有的数组,复制到开始的位置
    3.将数组的长度变为删除后的长度
     */
    public void delete(int start,int end) throws IndexIsNagetiveException,IndexIsOutOfRangeException{
        if(start<0)
            throw new IndexIsNagetiveException();
        if(start>length)
            throw new IndexIsOutOfRangeException();
        if(end<0)
            throw new IndexIsNagetiveException();
        if(end>length)
            throw new IndexIsOutOfRangeException();
        if(start>=end)
            throw new IndexIsOutOfRangeException();
        System.arraycopy(value,end,value,start,length-end);
        length-=end-start;
    }

    //反转
    //将位置i的字符和total-i-1的字符互换,直到一半的位置
    //如果总数是偶数个,就如此处理,如果是奇数个,则最后一个不能取,所以只能小于一半,不能小于等于一半
    public void reverse(){
        for (int i = 0; i <length/2 ; i++) {
            char temp=value [i];
            value [i]=value [length-i-1];
            value[length-i-1]=temp;

        }

    }

    //返回长度
    public int length(){
        //TODO Auto-generated method stub
        return length;
    }
    public String toString(){   //为什么要重写toString? 因为打印输出的时候,输出的是字符串表达式,需要更改为它的字符串面值.
        char[] realValue=new char[length];
        System.arraycopy(value,0,realValue,0,length);
        return new String(realValue);
    }

    public static void main(String[] args) {
       try {
           MyStringBuffer sb = new MyStringBuffer("there light");
           System.out.println(sb);
           sb.insert(0, "let ");
           System.out.println(sb);
           sb.insert(10, "be ");
           System.out.println(sb);
           sb.insert(0, "God Say:");
           System.out.println(sb);
           sb.append("!");
           System.out.println(sb);
           sb.append("?");
           System.out.println(sb);
           sb.reverse();
           System.out.println(sb);
           sb.reverse();
           System.out.println(sb);
           sb.delete(0, 4);
           System.out.println(sb);
           sb.delete(4);
           System.out.println(sb);
       }
       catch (IndexIsNagetiveException e){
           e.printStackTrace();
       }
       catch (IndexIsOutOfRangeException e){
           e.printStackTrace();
       }



    }



}
//什么是构造方法
//例子中,带参构造方法和步骤5的构造方法不同,是哪些不同,为什么用带参构造方法例子中的构造方法,运行会报错?
/*
public MyStringBuffer(String str){
        if(null!=str)        //如果传入的字符串不是空,则value指向字符串转变的数组

            value =str.toCharArray();//已经完成了数组的赋值

        length = value.length;//长度为重新定义

        if(capacity<value.length) //如果传入字符串数组的长度,超过容量,则重新定义容量为value的长度的两倍
            capacity  = value.length*2;//需要重新赋值
    }

    public MyStringBuffer(String str){
        this();                      //调用不带参数的构造方法,value=new char[capacity];
        if(null==str)                //如果传入的字符串值为空,则不执行后面的语句
            return;
        if(capacity<str.length()){   //如果传入的字符串的长度大于容量(数组的长度),数组的长度翻倍
            capacity=value.length*2;
            value=new char[capacity];// 数组改为长度改为原来的两倍的新数组,但是数组的指还是为空
        }
        if(capacity>=str.length()){ //直到value数组的长度大于等于传入字符串数组的长度
            System.arraycopy(str.toCharArray(),0,value,0,str.length());//将传入字符串数组复制到长度加倍的新数组中
        }
        length=str.length(); //修改数组的长度为字符串数组的长度
       }                 总结,第一种有参构造方法完成了数组的赋值后,再去修改容量,是不可行的,需要重新定义一个新的容量更长的数组,赋值后再指向


 */