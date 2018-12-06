package kolokwium.zadanie3;

public class Program
{
    public static void main(String[] args)
    {
        Figura z=new Okrag(2);
        z.info();

        Figura[] a={new Prostokat(4,7),new Okrag(9), new Trojkat(3,4,5)};

        Figura x;
        double suma=0;

        for(int i=0;i<a.length;i++)
        {
            x=a[i];
            x.info();
            suma=suma+x.pole();
        }

        System.out.println("suma pol figur: "+suma);
    }
}
