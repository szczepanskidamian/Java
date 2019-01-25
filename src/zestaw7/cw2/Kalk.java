package zestaw7.cw2;

import com.sun.deploy.util.ArrayUtil;
import sun.invoke.empty.Empty;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class Kalk implements ActionListener, KeyListener, WindowListener
{
    JTextField t1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    JButton bplus,brow, bminus, bmul, bdiv, bdot, bpow, bsqrt, bclear, bperc, bmemory, bmemoryplus, bmemoryminus, bsetmemory, bclearmemory, undo;
    JButton[] liczby = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b0};
    String operacja = "";
    boolean by_zero_division = false;
    int poprzedni = 2;
    double x,buf, memory;
    boolean percent;
    FileWriter file;
    String historia = "";

    Kalk(){
        try {
            file = new FileWriter("src/zestaw7/cw2/rejestr.txt");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



    public void actionPerformed(ActionEvent e)
    {
        Object target = e.getSource();

        for (int i = 0; i < liczby.length; i++){
                if (target==liczby[i]){
                    t1.setText(t1.getText()+((JButton)target).getText());
                    t1.requestFocus();
                }
        }
        if (target==b0){
            if (!t1.getText().startsWith("0") || t1.getText().startsWith("0.")) {
                t1.setText(t1.getText() + ((JButton) target).getText());
                t1.requestFocus();
            }
        }

        else if(target==bplus)
        {
            operacja = "+";
            buf=Double.parseDouble(t1.getText());
            historia += t1.getText()+operacja;
            t1.setText("");
            t1.requestFocus();
        }

        else if(target==bminus){
            operacja = "-";
            if (t1.getText().isEmpty()){
                t1.setText("-");
                t1.requestFocus();
            }
            else {
                buf = Double.parseDouble(t1.getText());
                historia += t1.getText()+operacja;
                t1.setText("");
                t1.requestFocus();
            }
        }

        else if(target==bmul){
            operacja = "*";
            buf=Double.parseDouble(t1.getText());
            historia += t1.getText()+operacja;
            t1.setText("");
            t1.requestFocus();
        }

        else if(target==bdiv){
            operacja = "/";
            buf=Double.parseDouble(t1.getText());
            historia += t1.getText()+operacja;
            t1.setText("");
            t1.requestFocus();
        }

        else if(target==bpow){
            operacja = "pow";
            buf=Double.parseDouble(t1.getText());
            historia += t1.getText()+"^";
            t1.setText("");
            t1.requestFocus();
        }

        else if(target==bsqrt){
            x=Double.parseDouble(t1.getText());
            if (x<0){
                t1.setText("ERROR");
                t1.requestFocus();
            }
            else {
                x = Math.sqrt(x);
                historia += "\u221A"+t1.getText()+"="+x+"\n";
                t1.setText(Double.toString(x));
                t1.requestFocus();
            }
        }

        else if(target==bperc){
            percent = true;
            if(operacja.equals("*") || operacja.equals("/")){
                x = (Double.parseDouble(t1.getText())/100);
            }
            else if (operacja.equals("+") || operacja.equals("-")){
                x = buf*(Double.parseDouble(t1.getText())/100);
            }
            historia += t1.getText()+"%";
            t1.setText(Double.toString(x));
            t1.requestFocus();
        }

        else if(target==bmemory) {
            t1.setText(Double.toString(memory));
        }

        else if(target==bsetmemory) {
            memory = Double.parseDouble(t1.getText());
        }

        else if(target==bclearmemory) {
            memory = 0;
        }

        else if(target==bmemoryplus) {
            memory = memory + Double.parseDouble(t1.getText());
        }

        else if(target==bmemoryminus) {
            memory = memory - Double.parseDouble(t1.getText());
        }

        else if(target==bdot){
            if (!t1.getText().contains(".")) {
                t1.setText(t1.getText() + ".");
                t1.requestFocus();
            }
        }

        else if (target==bclear){
            buf = 0;
            x = 0;
            t1.setText("");
            t1.requestFocus();
        }


        else if(target==brow||target==t1)
        {
            if(!t1.getText().isEmpty()) {
                if (percent == false) {
                    x = Double.parseDouble(t1.getText());
                    if (x == 0) {
                        by_zero_division = true;
                    }

                    historia += t1.getText();
                }
                if (operacja.equals("+")) {
                    x = buf + x;
                } else if (operacja.equals("-")) {
                    x = buf - x;
                } else if (operacja.equals("*")) {
                    x = buf * x;
                } else if (operacja.equals("/")) {
                    x = buf / x;
                } else if (operacja.equals("pow")) {
                    x = Math.pow(buf, x);
                }

                percent = false;
                if (operacja.equals("/") && by_zero_division) {
                    t1.setText("ERROR");
                    t1.requestFocus();
                    by_zero_division = false;
                } else {
                    t1.setText(Double.toString(x));
                    t1.requestFocus();
                    historia += "=" + t1.getText() + "\n";
                    poprzedni = 2;
                }
            }
        }
        else if (target==undo){
            try {
                String[] oper = historia.split("\n");
                oper = oper[oper.length-poprzedni++].split("=");
                t1.setText(oper[oper.length-1]);

            }
            catch (ArrayStoreException a){
                a.printStackTrace();
            }
        }

    }

    void init()
    {
        JFrame f=new JFrame();
        f.setFocusable(true);
        f.addWindowListener(this);
        Container c=f.getContentPane();

        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        c.setLayout(gbl);

        t1=new JTextField(15);
        t1.addActionListener(this);
        t1.addKeyListener(this);
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t1.setEnabled(true);
        t1.setEditable(false);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=8;
        gbc.ipadx=0;
        gbc.ipady=5;
        gbc.insets=new Insets(5,5,0,5);
        gbl.setConstraints(t1,gbc);
        c.add(t1);



        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                liczby[i*3+j]=new JButton(Integer.toString(i*3+j+1));
                liczby[i*3+j].addActionListener(this);
                liczby[i*3+j].setFocusable(false);
                liczby[i*3+j].setBackground(new Color(200,200,0));
                liczby[i*3+j].setForeground(Color.BLACK);
                gbc.gridx=j+1;
                gbc.gridy=i+1;
                gbc.gridwidth=1;
                gbc.ipadx=0;
                gbc.ipady=0;
                gbc.insets=new Insets(5,5,0,0);
                gbl.setConstraints(liczby[i*3+j],gbc);
                c.add(liczby[i*3+j]);
            }
        }


        b0=new JButton("0");
        b0.addActionListener(this);
        b0.setFocusable(false);
        b0.setBackground(new Color(200,200,0));
        b0.setForeground(Color.black);
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=3;
        gbc.ipadx=0;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,0,0);
        gbl.setConstraints(b0,gbc);
        c.add(b0);


        bplus=new JButton("+");
        bplus.addActionListener(this);
        bplus.setFocusable(false);
        bplus.setToolTipText("dodawanie");
        bplus.setBackground(Color.darkGray);
        bplus.setForeground(Color.WHITE);
        gbc.gridx=4;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,0,5);
        gbl.setConstraints(bplus,gbc);
        c.add(bplus);

        bminus=new JButton("-");
        bminus.addActionListener(this);
        bminus.setFocusable(false);
        bminus.setToolTipText("odejmowanie");
        bminus.setBackground(Color.darkGray);
        bminus.setForeground(Color.WHITE);
        gbc.gridx=5;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,0,5);
        gbl.setConstraints(bminus,gbc);
        c.add(bminus);

        bmul=new JButton("*");
        bmul.addActionListener(this);
        bmul.setFocusable(false);
        bmul.setToolTipText("mnozenie");
        bmul.setBackground(Color.darkGray);
        bmul.setForeground(Color.WHITE);
        gbc.gridx=4;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,0,5);
        gbl.setConstraints(bmul,gbc);
        c.add(bmul);

        bdiv=new JButton("/");
        bdiv.addActionListener(this);
        bdiv.setFocusable(false);
        bdiv.setToolTipText("dzielenie");
        bdiv.setBackground(Color.darkGray);
        bdiv.setForeground(Color.WHITE);
        gbc.gridx=5;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,0,5);
        gbl.setConstraints(bdiv,gbc);
        c.add(bdiv);


        brow=new JButton("=");
        brow.addActionListener(this);
        brow.setFocusable(false);
        brow.setToolTipText("wykonaj działanie");
        brow.setBackground(new Color(150));
        brow.setForeground(Color.WHITE);
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=3;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(brow,gbc);
        c.add(brow);

        undo=new JButton("UNDO");
        undo.addActionListener(this);
        undo.setFocusable(false);
        undo.setToolTipText("wykonaj działanie");
        undo.setBackground(new Color(200,70,0));
        undo.setForeground(Color.WHITE);
        gbc.gridx=3;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(undo,gbc);
        c.add(undo);

        bdot=new JButton(".");
        bdot.addActionListener(this);
        bdot.setFocusable(false);
        bdot.setToolTipText("kropka");
        bdot.setBackground(Color.gray);
        bdot.setForeground(Color.WHITE);
        gbc.gridx=4;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bdot,gbc);
        c.add(bdot);

        bpow=new JButton("pow");
        bpow.addActionListener(this);
        bpow.setFocusable(false);
        bpow.setToolTipText("potegowanie");
        bpow.setBackground(Color.darkGray);
        bpow.setForeground(Color.WHITE);
        gbc.gridx=4;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bpow,gbc);
        c.add(bpow);

        bsqrt=new JButton("sqrt");
        bsqrt.addActionListener(this);
        bsqrt.setFocusable(false);
        bsqrt.setToolTipText("pierwiastek kwadratowy");
        bsqrt.setBackground(Color.darkGray);
        bsqrt.setForeground(Color.WHITE);
        gbc.gridx=5;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bsqrt,gbc);
        c.add(bsqrt);

        bclear=new JButton("CLEAR");
        bclear.addActionListener(this);
        bclear.setFocusable(false);
        bclear.setToolTipText("clear");
        bclear.setBackground(new Color(200,70,0));
        bclear.setForeground(Color.WHITE);
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.gridwidth=2;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bclear,gbc);
        c.add(bclear);

        bperc=new JButton("%");
        bperc.addActionListener(this);
        bperc.setFocusable(false);
        bperc.setToolTipText("procent");
        bperc.setBackground(Color.gray);
        bperc.setForeground(Color.WHITE);
        gbc.gridx=3;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bperc,gbc);
        c.add(bperc);

        bmemory=new JButton("MR");
        bmemory.addActionListener(this);
        bmemory.setFocusable(false);
        bmemory.setToolTipText("pamiec");
        bmemory.setBackground(Color.gray);
        bmemory.setForeground(Color.WHITE);
        gbc.gridx=5;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bmemory,gbc);
        c.add(bmemory);

        bsetmemory=new JButton("MS");
        bsetmemory.addActionListener(this);
        bsetmemory.setFocusable(false);
        bsetmemory.setToolTipText("przechowaj w pamieci");
        bsetmemory.setBackground(Color.gray);
        bsetmemory.setForeground(Color.WHITE);
        gbc.gridx=4;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bsetmemory,gbc);
        c.add(bsetmemory);

        bclearmemory=new JButton("MC");
        bclearmemory.addActionListener(this);
        bclearmemory.setFocusable(false);
        bclearmemory.setToolTipText("wyczysc pamiec");
        bclearmemory.setBackground(Color.gray);
        bclearmemory.setForeground(Color.WHITE);
        gbc.gridx=5;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bclearmemory,gbc);
        c.add(bclearmemory);

        bmemoryplus=new JButton("+MR");
        bmemoryplus.addActionListener(this);
        bmemoryplus.setFocusable(false);
        bmemoryplus.setToolTipText("dodaj do pamieci");
        bmemoryplus.setBackground(Color.gray);
        bmemoryplus.setForeground(Color.WHITE);
        gbc.gridx=4;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bmemoryplus,gbc);
        c.add(bmemoryplus);

        bmemoryminus=new JButton("-MR");
        bmemoryminus.addActionListener(this);
        bmemoryminus.setFocusable(false);
        bmemoryminus.setToolTipText("odejmij od pamieci");
        bmemoryminus.setBackground(Color.gray);
        bmemoryminus.setForeground(Color.WHITE);
        gbc.gridx=5;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.ipadx=30;
        gbc.ipady=0;
        gbc.insets=new Insets(5,5,5,0);
        gbl.setConstraints(bmemoryminus,gbc);
        c.add(bmemoryminus);

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Kalkulator");
        f.setVisible(true);

    }

    public static void main(String[] args)
    {
        //do wersji 1.4fa
        //new Kalk().init();

        //od wersji 1.5
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Kalk().init();
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() >=48 && e.getKeyCode() <= 57){
            t1.setText(t1.getText()+(e.getKeyCode()-48));
            t1.requestFocus();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            file.write(historia);
            file.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
