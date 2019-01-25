package zestaw7.cw1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Demo implements ActionListener
{
    JTextField t1;
    JButton b1;
    JButton b2;
    JButton plus;
    JButton rowna_sie;
    int tmp;

    public void actionPerformed(ActionEvent e)
    {
        Object target = e.getSource();
        if(target==b1||target==t1)
        {
            try {
                int k = Integer.parseInt(t1.getText());
                t1.setText(Integer.toString(k * k));
                t1.requestFocus();
            }
            catch(NumberFormatException f){
                System.out.println("ERROR: Błedny format");
                t1.setText("ERROR");
            }

        }
        else if (target==b2)
        {
            t1.setText("");
            tmp = 0;
            t1.requestFocus();
        }
        else if (target==plus){
            int k = Integer.parseInt((t1.getText()));
            tmp += k;
            t1.setText("");
            t1.requestFocus();
        }
        else if (target==rowna_sie){
            int k = Integer.parseInt((t1.getText()));
            tmp += k;
            t1.setText(""+String.valueOf(tmp));
            t1.requestFocus();
            tmp = 0;
        }
    }

    void init()
    {
        t1=new JTextField(6);
        b1=new JButton("^2");
        plus=new JButton("+");
        rowna_sie=new JButton("=");
        b2=new JButton("clear");

        JPanel p=new JPanel();
        p.add(t1);
        p.add(b1);
        p.add(b2);
        p.add(plus);
        p.add(rowna_sie);

        t1.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        plus.addActionListener(this);
        rowna_sie.addActionListener(this);

        JFrame f=new JFrame();
        Container c=f.getContentPane();
        c.add(p);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        //do wersji 1.4
        //new Demo().init();

        //od wersji 1.5
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Demo().init();
            }
        });
    }
}
