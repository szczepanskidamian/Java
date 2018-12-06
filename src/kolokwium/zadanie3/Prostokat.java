package kolokwium.zadanie3;

class Prostokat extends Figura
{
    double dlugosc;
    double szerokosc;

    Prostokat(double dlugosc,double szerokosc)
    {
        this.dlugosc=dlugosc;
        this.szerokosc=szerokosc;
    }

    double pole()
    {
        return dlugosc*szerokosc;
    }

    double obwod()
    {
        return 2*dlugosc+2*szerokosc;
    }

    public String toString()
    {
        return "prostokat bokach: a="+dlugosc+", b="+szerokosc;
    }
}
