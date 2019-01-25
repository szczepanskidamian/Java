package zestaw5.cw2;

import java.io.*;
import java.net.*;


public class Serwer
{
    public static final int PORT=50007;

    public static void main(String args[]) throws IOException
    {
        //tworzenie gniazda serwerowego
        ServerSocket serv;
        Socket sock;
        serv = new ServerSocket(PORT);

        System.out.println("Nasluchuje: "+serv);
        sock=serv.accept();
        System.out.println("Jest polaczenie: "+sock);

        Odbior o = new Odbior(sock);
        o.start();

        BufferedReader klaw;
        klaw=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp=new PrintWriter(sock.getOutputStream());
        System.out.print("<Wysylamy:> ");
        String str=klaw.readLine();
        outp.println(str);
        outp.flush();
        while (!str.equalsIgnoreCase("exit")) {

            //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
            klaw=new BufferedReader(new InputStreamReader(System.in));
            outp=new PrintWriter(sock.getOutputStream());
            System.out.print("<Wysylamy:> ");
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

