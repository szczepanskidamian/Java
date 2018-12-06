package komunikator.cw2;
import java.io.*;
import java.net.*;


public class Klient
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {


        Socket sock;
        try {
            sock = new Socket(HOST, PORT);
            System.out.println("Nawiazalem polaczenie: " + sock);
        } catch (java.net.ConnectException c) {
            System.out.println("Połączenie zostało przerwane.");
            return;
        }
        Odbior o = new Odbior(sock);
        o.start();
        o.run();

        //tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do socketu
        BufferedReader klaw;
        klaw = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp = new PrintWriter(sock.getOutputStream());
        String str = klaw.readLine();

        BufferedReader inp;

        boolean send = true;
        //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
        while (!str.equals(("exit"))) {
//            if (send) {
            klaw = new BufferedReader(new InputStreamReader(System.in));
            outp = new PrintWriter(sock.getOutputStream());
            System.out.print("<Wysylamy:> ");
            str = klaw.readLine();
            outp.println(str);
            outp.flush();
            send = false;
//            }
//            } else {
//                inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//
//                //komunikacja - czytanie danych ze strumienia
//                str = inp.readLine();
//                System.out.println("<Nadeszlo:> " + str);
//                send = true;
//            }
        }
        //zamykanie polaczenia
        klaw.close();
        outp.close();
        sock.close();

    //zamykanie polaczenia
    sock.close();
    }
}
