package biblioteki;
import java.awt.*;

public class Program {
    public static void main(String[] args){
        Rectangle obj = new Rectangle(0,0,4,3);
        obj.translate(1,-1);
        System.out.println(obj);
        System.out.println(obj.contains(new Rectangle(0,-1,3,2)));
        obj.grow(2,2);
        System.out.println("obj " + obj);

        Rectangle obj1, obj2, obj3;
        obj1 = new Rectangle(0,0,4,3);
        obj2 = new Rectangle(1,1,4,3);
        obj3 = new Rectangle(obj1.intersection(obj2));
        System.out.println("obj1 " + obj1);
        System.out.println("obj2 " + obj2);
        System.out.println("obj3 intersection " + obj3);

        obj1 = new Rectangle(1,1,4,5);
        obj2 = new Rectangle(2,0,2,3);
        System.out.println("obj1 " + obj1);
        System.out.println("obj2 " + obj2);
        System.out.println("Obj1 zawiera sie w Obj2? " + obj2.contains(obj1));

        obj = new Rectangle(-3,0,6,3);
        System.out.println("obj " + obj);
        Point pkt = new Point(2,-1);
        System.out.println("obj zawiera punkt " + pkt + "? " + obj1.contains(pkt));

        obj1 = new Rectangle(1,1,4,5);
        obj2 = new Rectangle(4,-3,4,3);
        System.out.println("obj1 " + obj1);
        System.out.println("obj2 " + obj2);
        System.out.println("obj1 przecina obj2? " + obj1.intersects(obj2));

        Prostokat prostokat = new Prostokat(4,6,new Punkt(-3,2));
        prostokat.save("/Projekty/Java/src/biblioteki/plik.txt");
    }
}
