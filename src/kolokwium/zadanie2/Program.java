package kolokwium.zadanie2;

public class Program {

    public static void main(String [] args)
    {
        Punkt p = new Punkt(0,0);
        System.out.println(p);
        p.przesun(3,4);
        System.out.println(p);


        Prostokat prostokat = new Prostokat(3,4, new Punkt(0,0));
        Prostokat prostokat1 = new Prostokat(1,2,new Punkt(1,1));
        Prostokat prostokat2 = new Prostokat(5,4, new Punkt(6,6));
        System.out.println("Srodek ciezkosci prostokata " + prostokat + " to " +prostokat.srodekCiezkosci());

        System.out.println(prostokat.zawiera(prostokat1));
        System.out.println(prostokat1.zawiera(prostokat));

        System.out.println(prostokat.przecina(prostokat1));
        System.out.println(prostokat.przecina(prostokat2));
    }


}
