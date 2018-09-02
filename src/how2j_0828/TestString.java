package how2j_0828;
/*
给出一句英文句子： "let there be light"
得到一个新的字符串，每个单词的首字母都转换为大写
解析：先依据空格符号进行分隔，分隔成多个字符串，再将字符串的首字母提取出来，转换成大写字母
转换后的大写字母与字符串的第一个字母替换，替换后的新的字符串组成首字母大写的英文句子
StringName.split(" ")

String a=a+new String(b)
 */
public class TestString {
    public static void main(String[] args) {
        String str="let there be light";
        String[] subStr=str.split(" ");
        for (int i = 0; i <subStr.length ; i++) {
            String words=subStr[i];
            char upperCaseFirstWords=Character.toUpperCase(words.charAt(0));
            String rest=words.substring(1);
            String CapitalizedWords=upperCaseFirstWords+rest;
            subStr[i]=CapitalizedWords;


        }
        String result="";
        for(String word:subStr){
            result+=word+" ";
        }
        result=result.trim();
        System.out.println(result);


    }
}
