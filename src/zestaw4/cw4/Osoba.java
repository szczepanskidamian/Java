package zestaw4.cw4;
import java.io.*;


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