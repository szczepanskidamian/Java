package dziedziczenie;

import java.awt.*;

public class Program
{
    public static void main(String[] args)
    {

        Prostokat a=new Prostokat(3,4);
        a.info();

        Prostokat b=new Prostokat(2,2);
        b.info();



        if(a.intersects(b))
        {
            System.out.println("-- przecinaja sie --\n");
        }
        else
        {
            System.out.println("-- NIE przecinaja sie --\n");
        }



        a.translate(5,3);
        a.info();

        if(a.intersects(b))
        {
            System.out.println("-- przecinaja sie --\n");
        }
        else
        {
            System.out.println("-- NIE przecinaja sie --\n");
        }


        a = new Prostokat(new Point(1,2),4,3);
        a.info();
        b = new Prostokat(new Point(5,2), 2, 3);

        System.out.println(a.saPrzylegle(b));
    }
}
