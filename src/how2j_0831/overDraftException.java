package how2j_0831;

public class overDraftException extends Exception{
    private double deficit;
    public double getDeficit(){
        return deficit;
    }
    public overDraftException(String msg,double deficit){
        super(msg);
        this.deficit=deficit;
    }
}
