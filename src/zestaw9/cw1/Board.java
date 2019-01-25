package zestaw9.cw1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

class Board extends JPanel implements MouseMotionListener, KeyListener
{
    Bar b;
    Ball a;
    BallEngine s;
    ArrayList<Brick> bricks = new ArrayList<Brick>();
    int points = 0;
    boolean stop = false;
    boolean lose = false;
    boolean win = false;
    boolean hold = false;
    private Point a_start =new Point(100, 290);
    private double dx_start = 1.5;
    private double dy_start = -2;
    private int b_start = 200;
    private int row = 4; //4
    private int column = 7; //7
    private int hp_start = 4; //4
    double zmiana=0;



    Board()
    {
        super();
        addMouseMotionListener(this);
        addKeyListener(this);

        int hp = hp_start;
        b=new Bar(b_start);
        a=new Ball(this,a_start.x,a_start.y,dx_start,dy_start);
        s=new BallEngine(a);

        for (int i = 0; i < row; i++){ //4
            for (int j = 0; j < column; j++){ //7
                ((ArrayList) bricks).add(new Brick(10+53*j,25+30*i, hp));
            }
            hp--;
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;

        g2d.fill(a);
        int color = 50;
        for (int i = 0; i < bricks.size(); i++){
            if(bricks.get(i).health > 0) {
                g2d.setPaint(new Color(255 - color * bricks.get(i).health));
                g2d.fill(bricks.get((i)));
            }
        }
        g2d.setPaint(Color.BLACK);
        g2d.drawString("Points: " + points, 10, getHeight()-10);
        g2d.setPaint(Color.orange);
        g2d.fill(b);
        if (lose){
            g2d.setPaint(Color.RED);
            g2d.setFont(new Font("TimesRoman",Font.PLAIN,30));
            g2d.drawString("YOU LOSE",100,185);
            g2d.setFont(new Font("TimesRoman",Font.PLAIN,10));
            g2d.drawString("Click Spacebar to Play Again", 105, 195);

        }
        if (win==true){
            g2d.setPaint(new Color(20,120,20));
            g2d.setFont(new Font("TimesRoman",Font.PLAIN,30));
            g2d.drawString("YOU WON",100,185);
            g2d.setFont(new Font("TimesRoman",Font.PLAIN,10));
            g2d.drawString("Click Spacebar to Play Again", 105, 195);
        }
    }

    public void restart() {
        System.out.println("-----RESTART-----");
        stop = false;
        win = false;
        lose = false;
        a.dx = dx_start;
        a.dy = dy_start;
        a.x = a_start.x;
        a.y = a_start.y;
        points = 0;
        int hp = hp_start;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                bricks.get(i * column + j).health = hp;
            }
            hp--;
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        if(!stop) {
            b.setX(e.getX() - 30);
            if (hold) {
                a.setX((int)(b.getX()-(zmiana)));
            }
            repaint();
        }
    }

    public void mouseDragged(MouseEvent e)
    {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && !(win || lose)){
            if (!stop) {
                System.out.println("PAUSED");
                stop = !stop;
            }
            else if (stop){
                System.out.println("RESUMED");
                stop = !stop;
            }
        }
        if (win || lose){
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                restart();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_1){
            hold = !hold;
            System.out.println("HOLD: " + hold);
            if (hold){
                zmiana = b.getX() - a.getX();
            }
        }

    }
}
