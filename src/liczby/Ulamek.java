package liczby;

public class Ulamek
{
    private int licznik;
    private int mianownik;

    public Ulamek (int licznik, int mianownik){
        if (mianownik == 0) this.mianownik = 1;
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    double rozwDziesietne (){
        int a = licznik;
        int b = mianownik;
        return (double)a/(double)b;
    }

    private int NWD(int a, int b){
        if (b == 0){
            return a;
        }
        else {
            return NWD(b, a%b);
        }
    }

    private int NWW(int a, int b){
        return (a*b)/NWD(a,b);
    }

     Ulamek plus(Ulamek obj){
        int nww = this.NWW(this.mianownik, obj.mianownik);
        return new Ulamek(this.licznik*(nww/this.mianownik)+obj.licznik*(nww/obj.mianownik), nww);
    }

    Ulamek minus(Ulamek obj){
        int nww = this.NWW(this.mianownik, obj.mianownik);
        return new Ulamek(this.licznik*(nww/this.mianownik)-obj.licznik*(nww/obj.mianownik), nww);
    }

    Ulamek razy(Ulamek obj){
        return new Ulamek(this.licznik*obj.licznik, this.mianownik*obj.mianownik);
    }

    void odwroc(){
        int tmp;
        tmp = this.licznik;
        this.licznik = this.mianownik;
        this.mianownik = tmp;
    }

    void skroc(){
        int nwd = NWD(this.licznik, this.mianownik);
        this.licznik = this.licznik/nwd;
        this.mianownik = this.mianownik/nwd;
    }

    public String toString() {
        return licznik + "/" + mianownik;
    }
}
