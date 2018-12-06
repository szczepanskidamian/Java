package dziedziczenie.cw3;

public class Osoba {
    String imie;
    String nazwisko;

    Osoba(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    String getNazwisko(){
        return this.nazwisko;
    }
}
