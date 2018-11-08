package liczby;

public class BigLiczba {

    private int a;

    public BigLiczba(int a){
        this.a = a;
    }

    public String toString(){
        return ""+a;
    }

    boolean czyPodzielna(int b){
        if (this.a % b == 0){
            return true;
        }
        else {
            return false;
        }
    }

    boolean czyPierwsza(){
        boolean pierwsza = true;
        for (int i = 2; i <= Math.sqrt(this.a); i++){
            if (this.a % i == 0){
                pierwsza = false;
            }
        }
        return pierwsza;
    }
}
