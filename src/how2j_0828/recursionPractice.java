package how2j_0828;

import static how2j_0828.TestNumber7.randomString;

public class recursionPractice {
    public static boolean found=false;
    public static void main(String[] args) {
        String  password=randomString(3);
        System.out.println("初始密码是："+password);
        char[]guessPassword=new char[password.length()];
        generatePassword(guessPassword,password);// 这句什么意思？
    }
    public static void generatePassword(char[] guessPassword,String password){
        generatePassword(guessPassword,0,password);//这个方法的声明没看懂
    }
    public static void generatePassword(char[] guessPassword,int index,String password){
        if (found)
                return;
        for (short i = '0'; i <'z' ; i++) {
            char c=(char)i;
            if(!Character.isLetterOrDigit(c))
                continue;
            guessPassword[index]=c;//index没有初始值，如何运行的，初始默认0？
            if(index!=guessPassword.length-1){
                generatePassword(guessPassword,index+1,password);
            }
            else{
                String guess=new String(guessPassword);
                System.out.println("穷举出来的密码是："+guess);
                if(guess.equals(password)){
                    System.out.println("找到了，密码是："+guess);
                    System.out.println("初始密码是："+password);
                    found=true;
                    return;
                }
            }

        }



    }
}
