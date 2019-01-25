package zestaw5.cw3;
import java.io.*;
import java.net.*;

public class Klient3
{
    public static final int PORT=80;
    public static final String HOST = "127.0.0.1";
    public static void main(String[] args) throws IOException
    {
        //nawiazanie polaczenia z serwerem
        Socket sock;
        sock=new Socket(HOST,PORT);
        System.out.println("Nawiazalem polaczenie: "+sock);
        //odbieranie
        new Odbior(sock).start();
        //wysylanie
        BufferedReader klaw;
        klaw=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp=new PrintWriter(sock.getOutputStream());
        String str=klaw.readLine();
        outp.println(str);
        outp.flush();
        while (!str.equalsIgnoreCase("exit")) {
            //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
            klaw=new BufferedReader(new InputStreamReader(System.in));
            outp=new PrintWriter(sock.getOutputStream());
            str=klaw.readLine();
            outp.println(str);
            outp.flush();
        }
        //zamykanie polaczenia
        klaw.close();
        outp.close();
        sock.close();
    }
}
