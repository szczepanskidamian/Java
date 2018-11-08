package liczby;

public class LiczbaZespolona {

    private int a;
    private int b;

    public LiczbaZespolona(int a, int b){
        this.a =a;
        this.b =b;
    }

    public String toString() {
        if (b >=0) {
            return a + " + " + b + "i";
        }
        else {
            return a + " " + b + "i";
        }
    }

    LiczbaZespolona plus(LiczbaZespolona liczba){
        return new LiczbaZespolona(this.a + liczba.a, this.b + liczba.b);
    }

    LiczbaZespolona minus(LiczbaZespolona liczba){
        return new LiczbaZespolona(this.a - liczba.a, this.b - liczba.b);
    }

    LiczbaZespolona razy(LiczbaZespolona liczba){
        return new LiczbaZespolona(this.a*liczba.a - this.b*liczba.b, this.a*liczba.b + this.b*liczba.a);
    }

    double modul(){
        return Math.sqrt(this.a*this.a + this.b*this.b);
    }
}
