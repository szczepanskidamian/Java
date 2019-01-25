package zestaw2;

public class WielomianKwadratowy {

    private int a;
    private int b;
    private int c;

    public WielomianKwadratowy(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString(){
        return a + "x^2" + " + " + b + "x + " + c;
    }

    WielomianKwadratowy plus(WielomianKwadratowy wielomian){
        return new WielomianKwadratowy(this.a+wielomian.a, this.b+wielomian.b, this.c+wielomian.c);
    }

//    WielomianKwadratowy razy(WielomianKwadratowy wielomian){
//        return
//    }

    double[] miejscaZerowe(){
        double delta = b*b - 4*a*c;
        if (delta > 0){
            double[] wynik = new double[2];
//            wynik[0] = (-b-Math.sqrt(delta))/2*a;
//            wynik[1] = (-b+Math.sqrt(delta))/2*a;
            return new double[] {(-b-Math.sqrt(delta))/2*a, (-b+Math.sqrt(delta))/2*a};
        }
        else if(delta ==0 ){
            double[] wynik = new double[1];
//            wynik[0] = -b/(2*a);
            return new double[] {-b/(2*a)};
        }
        else {
            return new double[0];
        }
    }
}
