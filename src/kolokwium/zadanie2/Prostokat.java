package kolokwium.zadanie2;
import java.awt.*;

public class Prostokat extends Rectangle {
    double a, b, x, y;

    Prostokat(double a, double b, Punkt p){
        this.a = a;
        this.b = b;
        this.x = p.x;
        this.y = p.y;
    }

    public String toString()
    {
        return "dl: " + a + ", sz: " + b + "[x: "+x+", y: "+y+"]";
    }

    Punkt srodekCiezkosci()
    {
        return new Punkt(this.x + this.a / 2, this.y + this.b / 2);
    }

    boolean zawiera(Prostokat obj){
        if (this.x < obj.x && this.x+this.a > obj.x+obj.a && this.y < obj.y && this.y+this.b > obj.y+obj.b){
            return true;
        }
        else {
            return false;
        }
    }

    boolean przecina(Prostokat obj){
        if (this.x + this.a > obj.x && this.y+this.b > obj.y && this.x < obj.x+obj.a && this.y < obj.y+obj.b)
        {
            return true;
        }
        else {
            return false;
        }
    }


}
