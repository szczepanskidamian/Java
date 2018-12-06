package komunikator.cw2;
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

        try {
            serv=new ServerSocket(PORT);
            sock=serv.accept();
            System.out.println("Nasluchuje: "+serv);
            System.out.println("Jest polaczenie: "+sock);
        } catch (java.net.ConnectException c) {
            System.out.println("Połączenie zostało przerwane.");
            return;
        }

        //oczekiwanie na polaczenie i tworzenie gniazda sieciowego

        //tworzenie watka odbierajacego
        new Odbior(sock).start();



        //zamykanie polaczenia
        serv.close();
        sock.close();
    }
}
