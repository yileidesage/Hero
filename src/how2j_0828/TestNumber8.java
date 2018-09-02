package how2j_0828;

import static how2j_0828.TestNumber7.randomString;

/*
1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码
2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码

要求： 分别使用多层for循环 和 递归解决上述问题
 */
/*
调用随机生成字符串的办法，生成随机长度3的随机字符串
将字符串拆分为3个字符组成的数组
用for循环来匹配数组的第一个字符，然后第二个，第三个，for循环重复3遍
生成所有的长度为3的字符串，与字符串匹配，相同就停止
递归的办法不清楚
 */
public class TestNumber8 {
    public static void main(String[] args) {
        String password=randomString(3);
        System.out.println("初始密码是："+password);
        char[] guessPassword=new char[3];
        outloop:
        for (short i = '0'; i <'z' ; i++) {
            for (short j = '0'; j <'z' ; j++) {
                for (short k = '0'; k <'z' ; k++) {
                    if(!isLetterOrDigit(i,j,k))
                        continue;
                    guessPassword[0]=(char)i;
                    guessPassword[1]=(char)j;
                    guessPassword[2]=(char)k;
                    String guess=new String(guessPassword);
                    System.out.println("穷举出来的密码是"+guess);

                    if(guess.equals(password)){
                        System.out.println("找到了，密码是："+guess);
                        break outloop;
                    }
                }

            }

        }
        System.out.println("初始密码是："+password);

    }
    public static boolean isLetterOrDigit(short i,short j,short k){
        return Character.isLetterOrDigit(i)&&Character.isLetterOrDigit(k)&&Character.isLetterOrDigit(j);
    }
}
