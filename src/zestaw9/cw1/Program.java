package zestaw9.cw1;

import javax.swing.*;

public class Program
{
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Board p;
                p=new Board();
                p.setFocusable(true);

                JFrame jf=new JFrame();
                jf.add(p);

                jf.setTitle("Arkanoid");
                jf.setSize(400,400);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }
        });
    }
}
