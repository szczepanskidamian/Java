package zestaw2;


public class Main
{
    public static void main(String[] args)
    {
        Ulamek obj = new Ulamek(6,8);
        Ulamek obj2 = new Ulamek(3,7);
        System.out.println("Ulamki\n");
        System.out.println("ulamek " + obj);
        double x = obj.rozwDziesietne();
        System.out.println("rozwiniecie dziesietne " + x);

        Ulamek obj3 = obj.plus(obj2);
        System.out.println("plus " + obj3);
        Ulamek obj4 = obj.minus(obj2);
        System.out.println("minus " + obj4);
        Ulamek obj5 = obj.razy(obj2);
        System.out.println("razy " + obj5);
        obj.odwroc();
        System.out.println("odwroc " + obj);
        obj5.skroc();
        System.out.println("skroc " + obj5);
        System.out.println("\nLiczby zespolone\n");

        LiczbaZespolona lz = new LiczbaZespolona(3,5);
        System.out.println(lz);

        LiczbaZespolona liczba, liczba2;
        liczba = new LiczbaZespolona(5,2);
        liczba2 = new LiczbaZespolona(3,-7);
        System.out.println("Dodawanie " + liczba + " + " + liczba2 + " = " + liczba.plus(liczba2));
        System.out.println("Odejmowanie " + liczba + " - " + liczba2 + " = " + liczba.minus(liczba2));
        System.out.println("Mnozenie (" + liczba + ") * (" + liczba2 + ") = " + liczba.razy(liczba2));
        System.out.println("Modul " + liczba.modul());

        System.out.println("\nWektory\n");
        Wektor w1, w2;
        w1 = new Wektor(5,3,4);
        w2 = new Wektor(2, -1, 3);
        System.out.println("w1: " + w1 + "\tw2: " + w2);
        System.out.println("Dodawanie: " + w1.plus(w2));
        System.out.println("Odejmowanie: " + w1.minus(w2));
        System.out.println("Iloczyn wektorowy: " + w1.iloczynWektorowy(w2));
        System.out.println("Iloczyn skalarny: " + w1.iloczynSkalarny(w2));
        System.out.println("\nWielomiany\n");
        WielomianKwadratowy wielomian1, wielomian2;
        wielomian1 = new WielomianKwadratowy(2,3,1);
        wielomian2 = new WielomianKwadratowy(-1,2,4);
        System.out.println(wielomian1 + "\t|\t" + wielomian2);
        System.out.println("Dodawanie " + wielomian1.plus(wielomian2));
        System.out.println("Miejsca zerowe: " + wielomian2.miejscaZerowe());

        System.out.println("\nBigLiczba\n");
        BigLiczba bl = new BigLiczba(7);
        System.out.println(bl + " jest podzielne przez " + 5 + "?\t" + bl.czyPodzielna(5));
        System.out.println(bl + " to liczba pierwsza?\t" + bl.czyPierwsza());
    }
}
