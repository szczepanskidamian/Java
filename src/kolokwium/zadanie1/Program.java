package kolokwium.zadanie1;

public class Program {
    public static void main(String [] args)
    {
        WielomianKwadratowy w = new WielomianKwadratowy(1,8,1);
        System.out.println(w);
        System.out.println("Delta: "+w.delta());
        System.out.println("x1 = " + w.pierwiastek1());
        System.out.println("x2 = " + w.pierwiastek2());
        w.drukuj();
    }
}
