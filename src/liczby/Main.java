package liczby;


public class Main
{
    public static void main(String[] args)
    {
        Ulamek obj = new Ulamek(6,8);
        Ulamek obj2 = new Ulamek(3,7);

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

        LiczbaZespolona lz = new LiczbaZespolona(3,5);
        System.out.println(lz);
    }
}
