package dziedziczenie;
import java.awt.*;

class Prostokat extends Rectangle
{
    Prostokat(int a,int b)
    {
        super(a,b);
    }

    void info()
    {
        System.out.println(this);
    }

    Prostokat (Point p, int a, int b){
        super(p.x, p.y, a, b);
    }

    public boolean saPrzylegle(Prostokat p)
    {
        if (this.intersects(p) == true || this.contains(p) == true || p.contains(this)) {
            return false;
        }
        else if (this.x <= p.x && this.x+this.width >= p.x) {
            return true;
        }
        else if (p.y >= this.y && this.y <= this.y + this.width){
            return true;
        }
        else if (p.x == this.x + this.width && p.y >= this.y && p.y <= this.y + this.height){
            return true;
        }
        else if (p.y == this.y + this.height && p.x >= this.x && p.x <= this.x + this.width){
            return true;
        }
        else {
            return false;
        }
    }
}
