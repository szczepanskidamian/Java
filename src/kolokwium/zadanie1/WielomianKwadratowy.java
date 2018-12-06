package kolokwium.zadanie1;


public class WielomianKwadratowy {

    private double a;
    private double b;
    private double c;

    public WielomianKwadratowy(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void drukuj(){
        System.out.println(a + "x^2" + " + " + b + "x + " + c);
    }

    public String toString(){
        return a + "x^2" + " + " + b + "x + " + c;
    }

    double delta()
    {
        return b*b - 4*a*c;
    }

    double pierwiastek1()
    {
        if (this.delta() > 0){
            return ((-b - Math.sqrt(this.delta()))/(2*a));
        }
        else if (this.delta() == 0){
            return (-b)/(2*a);
        }
        else {
            return 0;
        }
    }

    double pierwiastek2()
    {
        if (this.delta() > 0){
            return ((-b + Math.sqrt(this.delta()))/(2*a));
        }
        else if (this.delta() == 0){
            return (-b)/(2*a);
        }
        else {
            return 0;
        }
    }
}
