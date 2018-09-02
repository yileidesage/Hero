package how2j_0828;
//统计一千万以内有多少个质数

public class TestNumber4 {
    public static void main(String[] args) {
        int max=1000*10000;
        int count=0;
        for (int i = 1; i <=max ; i++) {
            if(isPrime(i)){
                count++;
            }

        }
        System.out.println("一千万以内的质数有："+count);

    }
    public static boolean isPrime(int i){
        for (int j = 2; j <=Math.sqrt(i) ; j++) {
            if(0==i%j)
                return false;

        }
        return true;
    }
}
//错误有两处：i的初始值应为1，j的最大值应小于等于，而不是小于