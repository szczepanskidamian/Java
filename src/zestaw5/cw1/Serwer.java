package zestaw5.cw1;
import java.io.*;
import java.net.*;

public class Serwer
{
    public static final int PORT=50007;

    public static void main(String args[]) throws IOException
    {
        //tworzenie gniazda serwerowego
        ServerSocket serv;
        serv=new ServerSocket(PORT);

        //oczekiwanie na polaczenie i tworzenie gniazda sieciowego
        System.out.println("Nasluchuje: "+serv);
        Socket sock;
        sock=serv.accept();
        System.out.println("Jest polaczenie: "+sock);

        //tworzenie strumienia danych pobieranych z gniazda sieciowego
        BufferedReader inp;
        inp=new BufferedReader(new InputStreamReader(sock.getInputStream()));

        //komunikacja - czytanie danych ze strumienia
//        String str;
//        str=inp.readLine();
//        System.out.println("<Nadeszlo:> " + str);
//        while(!str.equals("exit")){
//            inp=new BufferedReader(new InputStreamReader(sock.getInputStream()));
//
//            //komunikacja - czytanie danych ze strumienia
//            str=inp.readLine();
//            System.out.println("<Nadeszlo:> " + str);
//        }
        boolean send = false;

        BufferedReader klaw;
        klaw = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp = new PrintWriter(sock.getOutputStream());
        String str = klaw.readLine();
        while (!str.equals(("exit"))) {
            if (send) {
                klaw = new BufferedReader(new InputStreamReader(System.in));
                outp = new PrintWriter(sock.getOutputStream());
                System.out.print("<Wysylamy:> ");
                str = klaw.readLine();
                outp.println(str);
                outp.flush();
                send = false;
            } else {
                inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                //komunikacja - czytanie danych ze strumienia
                str = inp.readLine();
                System.out.println("<Nadeszlo:> " + str);
                send = true;

            }
        }
        //zamykanie polaczenia
        inp.close();
        sock.close();
        serv.close();
    }
}
