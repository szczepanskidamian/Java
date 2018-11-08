package biblioteki;
import java.io.*;

public class A {
    static double DOLAR=3.8;
    static double EURO=4.1;
    static double FUNT=4.5;

    public static void main(String[] args){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
            System.out.println("Wybierz walute [USD, EUR, GDP]: ");
            String walutaStr;
            String waluta=br.readLine();
            System.out.println("Wpisz kwote: ");
            String str = br.readLine();
            int x = Integer.parseInt(str);

            switch (waluta){
                case "USD": walutaStr = "$";
                    System.out.println("\nPLN: " + x * DOLAR);
                    break;
                case "EUR": walutaStr = "E";
                    System.out.println("PLN: " + x*EURO);
                    break;
                case "GDP": walutaStr = "GDP";
                    System.out.println("PLN: " + x*FUNT);
                    break;
            }


        }

        catch (IOException e1){
            System.out.println("wyjatek operacji wejscia/wyjscia");
        }

        catch (NumberFormatException e2){
            System.out.println("nieprawidlowy format liczby");
        }
    }
}
