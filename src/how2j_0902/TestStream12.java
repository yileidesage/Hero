package how2j_0902;

import java.io.UnsupportedEncodingException;

/*
一 编码概念
计算机存放数据只能存放数字,所有的字符都会被转换为不同的数字.
就像一个棋盘一样,不同的字,处于不同的位置,而不同的位置,有不同的数字编号.
有的棋盘很小,只能放英文和数组(ISO-8859-1)
有的大一点,还能放中文(GBK)
有的足够大,能够放下世界人民所有使用的所有文字和符号(UNICODE)

应为字符A在素有的棋盘里,位置都差不多
中文字符在不同的棋盘,位置不同,而且小的棋盘放不下中文

二 常见编码
工作后经常接触的编码方式有如下几种:
ISO-8859-1 ASCII 数字和西欧字母(其中ISO-8859-1 包含 ASCII)
GBK GB212 BIG5 中文 (GB2312是简体中文 BIG5是繁体中文,GBK同时包含简体\繁体\日文)
UNICODE (统一码,万国码,包含所有文字,世界所有文字

三 UTF和UNICODE
根据前面的学习,我们了解到不同的编码方式对应不同的棋盘,而UNICODE因为要存放所有的数据
所以它的棋盘是最大的
不仅如此,棋盘里每个数字都是很长的(4个字节),因为不仅需要标识字母,还要表示汉字等.

如果完全按照UNICODE的方式来存储数据,就会有很大的浪费
比如在ISO-8859-1中,a字符对应的数字是0x61
而UNICODE中对应的数字是0x00000061,如果一篇文章大部分都是英文字母,
那么按照UNICODE的方式进行数据存储就会消耗很多空间

在这种情况下,就出现了UNICODE的各种减肥子编码, 比如UTF-8对数字和字母就使用1个字节
而对汉字,就是用3个字节,从而达到了减肥还能保证健康的效果
UTF-8,UTF-16和UFT-32,针对不同类型的数据有不同的减肥效果
一般UTF-8是比较常用的方式

四 Java采用的是Unicode
写在Java源代码中的汉字,在执行之后,都会变成JVM中的字符.
而这些中文字符采用的编码方式,都是使用UNICODE.
"中"字对应的UNICODE是4E2D,所以在内存中,实际保存的数据就是16进制的0x4E2D
也就是十进制的20013
一个汉字在不同的编码方式中的表现是不同的

 */
public class TestStream12 {
    public static void main(String[] args) {
        String str = "中";
        showCode(str);
    }

    private static void showCode(String str) {
        String[] encodes = {"UNICODE", "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
        for (String encode : encodes) {
            showCode(str, encode);
        }

    }

    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b & 0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }
}


