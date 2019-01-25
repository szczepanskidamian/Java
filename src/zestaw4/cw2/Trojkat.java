package zestaw4.cw2;

class Trojkat extends Figura
{
    double a;
    double b;
    double c;

    Trojkat(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double pole()
    {
        return Math.sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c))/4;
    }

    double obwod()
    {
        return a+b+c;
    }

    public String toString()
    {
        return "trojkat o wymairach: a=" + a + ", b=" + b + ", c=" + c;
    }
}
