package zestaw5.cw2;

import java.io.*;
import java.net.*;
//
//class Odbior extends Thread
//{
//    Socket sock;
//    BufferedReader sockReader;
//
//    public Odbior(Socket sock) throws IOException
//    {
//        this.sock=sock;
//        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
//    }
//
//    public void run()
//    {
//        try {
//            String str;
//            str = this.sockReader.readLine();
//            System.out.println("\n<Nadeszlo:> " + str);
//            while (!str.equalsIgnoreCase("exit")) {
//                this.sockReader = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
//                str = this.sockReader.readLine();
//                System.out.println("\n<Nadeszlo:> " + str);
//                System.out.print("<Wysylamy:> ");
//            }
//            System.out.println("KONIEC POLACZENIA" );
//            //zamykanie polaczenia
//            sockReader.close();
//        }
//        catch (IOException io) {
//            System.out.println("Exception");
//        }
//    }
//}

public class Klient
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {
        //nawiazanie polaczenia z serwerem
        Socket sock;
        sock=new Socket(HOST,PORT);
        System.out.println("Nawiazalem polaczenie: "+sock);

        //tworzenie watka odbierajacego
        Odbior o = new Odbior(sock);
        o.start();
        BufferedReader klaw;
        klaw=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("<Wysylamy:> ");
        PrintWriter outp;
        outp=new PrintWriter(sock.getOutputStream());
        String str=klaw.readLine();

//        String str=klaw.readLine();
//        String str = "";
        while (!str.equalsIgnoreCase("exit")) {
//            PrintWriter outp;
            outp=new PrintWriter(sock.getOutputStream());
            str=klaw.readLine();
            System.out.print("<Wysylamy:> ");
            outp.println(str);
            outp.flush();
        }

        System.out.println("KONIEC POLACZENIA" );
        sock.close();

    }
}

