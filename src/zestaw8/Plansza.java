package zestaw8;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Plansza extends JPanel
{
    Shape[] figura;

    Plansza(Shape[] figura)
    {
        this.figura=figura;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;

        Point2D.Float punkt = new Point2D.Float(150,150);
//        for (int i=0; i<figura.length; i++) {
//            g2d.draw(figura[i]);
//        }


//        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//        g.setColor(Color.RED);
//        if (figura[1].intersects((Rectangle2D) figura[0])) {
//            g.drawString("PRZECINAJA SIE", 50, 25);
//        }
//        else{
//            g.drawString("NIE PRZECINAJA SIE", 50, 25);
//        }
//        if (figura[1].contains((Rectangle2D) figura[0])){
//            g.drawString("Prostokat zawiera sie w elipsie", 50, 50);
//        }
//        else{
//            g.drawString("Prostokat nie zawiera sie w elipsie", 50, 50);
//        }
//        if (figura[0].contains((Point2D) punkt)){
//            g.drawString("Punkt zawiera sie w prostokacie", 50, 75);
//        }
//        else{
//            g.drawString("Punkt nie zawiera sie w prostokacie", 50, 75);
//        }


//        g2d.setColor(Color.DARK_GRAY);
//        g2d.fillRect(100,100,100,150);

//        GradientPaint redtowhite = new GradientPaint(100,100, Color.RED, 250,100, Color.WHITE);
//        g2d.setPaint(redtowhite);
//        g2d.fill(new Ellipse2D.Float(100,100,150,75));

//        float[] dist = {0.0f, 0.9f};
//        Color[] colors = {Color.YELLOW, Color.BLACK};
//        RadialGradientPaint blacktoyellow = new RadialGradientPaint(150, 150, 150, dist, colors);
//        g2d.setPaint(blacktoyellow);
//        g2d.fill(new Ellipse2D.Float(50,50,200, 200));

        String plik="water.jpg";
        try
        {
            BufferedImage img;
            File f=new File(plik);
            img=ImageIO.read(f);
//            g2d.setPaint(new TexturePaint(img,new Rectangle2D.Float(100,100,800,600)));
//            g2d.fill(new Rectangle.Float(100,100,200, 200));

//            AlphaComposite a = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f);
//            g2d.setComposite(a);
//            g2d.setPaint(Color.orange);
//            g2d.fill(new Ellipse2D.Float(40,70,200,125));
//            g2d.setPaint(Color.MAGENTA);
//            g2d.fill(new Ellipse2D.Float(170,70,200,125));


            g2d.draw(new Arc2D.Double(200,200,150,80,90,135,Arc2D.OPEN));

            g2d.draw(new Line2D.Float(10,10,200,200));
        }
        catch(IOException e)
        {
            System.err.println("Problem z plikiem");
        }


    }
}
