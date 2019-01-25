package zestaw3;
import java.io.*;
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


class Prostokat {
    double dlugosc;
    double szerokosc;
    Punkt wierzcholek;
    boolean zawiera;

    Prostokat(double dlugosc, double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wierzcholek = new Punkt(0, 0);
    }

    Prostokat(double dlugosc, double szerokosc, Punkt wierzcholek) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wierzcholek = wierzcholek;
    }

    public String toString() {
        return "[dl: " + dlugosc + ", sz: " + szerokosc + "]" + wierzcholek.toString();
    }

    double pole() {
        return dlugosc * szerokosc;
    }

    double obwod() {
        return 2 * dlugosc + 2 * szerokosc;
    }

    void przesun(double u, double v) {
        this.wierzcholek.przesun(u, v);
    }

    public boolean zawiera(Punkt obj) {
        if (obj.x >= Prostokat.this.wierzcholek.x && obj.x <= Prostokat.this.wierzcholek.x + Prostokat.this.szerokosc &&
                obj.y >= Prostokat.this.wierzcholek.y && obj.y <= Prostokat.this.wierzcholek.y + Prostokat.this.dlugosc) {
            return true;
        } else {
            return false;
        }
    }
    public boolean przecina(Prostokat prostokat){
        if (prostokat.wierzcholek.x <= this.wierzcholek.x + szerokosc && prostokat.wierzcholek.y <= this.wierzcholek.y + dlugosc){
            return true;
        }
        else{
            return false;
        }
    }

    void save(String plik){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        try
        {
//            System.out.print("imie: ");
//            String imie=br.readLine();
//            System.out.print("nazwisko: ");
//            String nazwisko=br.readLine();

            PrintWriter plik1=new PrintWriter(new BufferedWriter(new FileWriter(plik,false)));
            plik1.println(toString()+ "\npole: " + pole() + "\nobwod: " + obwod());
            plik1.close();
        }
        catch(Exception e){System.out.println(e);}
    }

}
