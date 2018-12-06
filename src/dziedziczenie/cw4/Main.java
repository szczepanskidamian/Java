//package dziedziczenie.cw4;
//import java.math.BigInteger;
//import java.lang.String;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        Dokument[] bazaDanych={new Paszport(new Osoba("Kazimierz", "Deyna")),
//                new DowodOsobisty(new Osoba("Edyta", "Gorniak")),
//                new Paszport(new Osoba("Tadeusz", "Gorniak"))};
//        Dokument z;
//        String wzorzec="Gorniak";
//        for(int i=0;i<bazaDanych.length;i++)
//        {
//            z=bazaDanych[i];
//            if(z.czyPasuje(wzorzec))System.out.println("znaleziono: "+z);
//        }
//
//        System.out.println("\n\n\n\nKonta bankowe:\n");
//        KontoStudenckie konto_stud = new KontoStudenckie(new BigInteger("1000"));
//        System.out.println("Poczatkowy stan Konto studenckie: "+konto_stud+"\n");
//        System.out.println("24 miesiacach: "+konto_stud.zyskPoCzasie(24).toString()+"\n");
//        KontoNowoczesne konto_now = new KontoNowoczesne(new BigInteger("56784"));
//        System.out.println("Poczatkowy stan Konto Nowoczesne: "+konto_now+"\n");
//        System.out.println("24 miesiacach: "+konto_now.zyskPoCzasie(24).toString()+"\n");
//    }
//}
