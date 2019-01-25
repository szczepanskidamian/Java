package zestaw8;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Program
{
    public static void main(String[] args)
    {
        Shape obj1;
        obj1=new Rectangle2D.Float(100,100,80,90);
        Shape obj2;
        obj2 = new Ellipse2D.Float(80, 40, 150,170);


        Shape[] figura = {obj1, obj2};

        Plansza p;
        p=new Plansza(figura);

        JFrame jf=new JFrame();
        jf.add(p);

        jf.setTitle("Test grafiki");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
