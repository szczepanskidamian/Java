package zestaw4.cw3;

public class Program
{
    public static void main(String[] args)
    {
        Osoba o1 = new Osoba ("Tomasz", "Gorniak");
        Osoba o2 = new Osoba("Krystian", "Szpak");
        Osoba o3 = new Osoba ("Jan", "Gorniak");
        Dokument[] bazaDanych={new Paszport(o1),new DowodOsobisty(o3),new Paszport(o2)};

        Dokument z;
        String wzorzec="Gorniak";

        for(int i=0;i<bazaDanych.length;i++) {
            z = bazaDanych[i];
            if (z.czyPasuje(wzorzec)) System.out.println("znaleziono: " + z);
            else {
                System.out.println("Dokument niezgodny ze wzorcem: " + z);

            }
        }
    }
}
