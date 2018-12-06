package kolokwium.zadanie2;

class Punkt
{
    double x;
    double y;

    Punkt(double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    void przesun(double dx, double dy)
    {
        this.x=x+dx;
        this.y=y+dy;
    }

    public String toString()
    {
        return "[x: "+x+", y: "+y+"]";
    }


}
