package how2j_0828;
//把 lengendary 改成间隔大写小写模式，即 LeNgEnDaRy

public class TestString2 {
    public static void main(String[] args) {
        String str="lengendary";
        char[] cs=str.toCharArray();
        for (int i = 0; i <cs.length ; i++) {
            if(0!=i%2)
                continue;
                char c=Character.toUpperCase(cs[i]);
                cs[i]=c;

        }
        String str2=new String(cs);
        System.out.println(str2);
    }
}
