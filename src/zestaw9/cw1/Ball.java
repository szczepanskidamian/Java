package zestaw9.cw1;

import java.awt.geom.*;

class Ball extends Ellipse2D.Float
{
    Board p;
    double dx,dy;
    double alpha;

    Ball(Board p, int x, int y, double dx, double dy)
    {
        this.x=x;
        this.y=y;
        this.width=10;
        this.height=10;

        this.p=p;
        this.dx=dx;
        this.dy=dy;
    }

    void setX(int x){ this.x=x;}

    void nextKrok()
    {
        x+=dx;
        y+=dy;
        boundHit();
        barHit();
        int bricks_health = 0;
        for (int i = 0; i < p.bricks.size(); i++) {
            Brick c = p.bricks.get(i);
            if (c.health > 0) {
                brickHit(c);
            }
            bricks_health += c.health;
        }
        if(p.getHeight() > 100) {
            if (getMaxY() > p.getHeight()) {
                lose();
            }
            if (bricks_health <= 0) {
                win();
            }
        }
        p.repaint();
    }

    private void lose(){
        p.stop = true;
        p.lose = true;
    }

    private void win(){
        p.win = true;
        p.stop = true;
    }

    private void brickHit(Brick c){
        if (getMaxX() + dx >= c.getMinX() && getMinX() + dx <= c.getMaxX() && getMaxY() + dy >= c.getMinY() && getMinY() + dy <= c.getMaxY()) {
            if ((getMaxX() < c.getMinX() && getMaxX() + dx >= c.getMinX()) || (getMinX() > c.getMaxX() && getMinX() + dx <= c.getMaxX())) {
                dx = -dx;
            }
            if ((getMinY() > c.getMaxY() && getMinY() + dy <= c.getMaxY()) || (getMaxY() < c.getMinY() && getMaxY() + dy >= c.getMinY())) {
                dy = -dy;
            }
            c.health--;
            if (c.health == 0) {
                p.points += 5;
            }
            p.points += 5;
        }

    }

    public boolean barHit(){
        if (getMaxX()+dx >= p.b.getMinX() && getMinX()+dx <= p.b.getMaxX() && getMaxY()+dy >= p.b.getMinY() && getMinY()+dy <= p.b.getMaxY()){
            if ((getMaxX() < p.b.getMinX() && getMaxX() + dx >= p.b.getMinX()) || (getMinX() > p.b.getMaxX() && getMinX() + dx <= p.b.getMaxX())) {
                dx = -dx;
            }
            if ((getMinY() > p.b.getMaxY() && getMinY() + dy <= p.b.getMaxY()) || (getMaxY() < p.b.getMinY() && getMaxY() + dy >= p.b.getMinY())) {
                alpha = (p.a.getCenterX() - p.b.getCenterX()) / (p.b.width / 2);
                double w_x = Math.sqrt(dx*dx + dy*dy);
                dx = Math.sin(alpha)*w_x;
                dy = -Math.cos(alpha)*w_x;
            }
            return true;
        }
        return false;
    }

    private void boundHit(){
        if(getMinX()+dx/2<0 || getMaxX()+dx/2>p.getWidth())  dx=-dx;
        if(getMinY()+dy/2<0) dy=-dy;
    }

}
