package how2j_0831;

public class Account {

    protected double balance;

    public Account(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    public double deposit(double amt){
        this.balance=this.balance+amt;
        return  balance;

    }
    public void withdraw(double amt) throws overDraftException{
        if(this.balance<amt){
            throw new overDraftException("余额不足",amt-this.balance);

        }
        this.balance-=amt;
    }

    public static void main(String[] args) {
        Account a=new Account(1000);
        a.deposit(1000);
        System.out.println(a.getBalance());
        try{
            a.withdraw(1000);
        }catch(overDraftException e){
            System.err.println("透支金额:"+e.getDeficit());
            e.printStackTrace();
        }

        }
    }

