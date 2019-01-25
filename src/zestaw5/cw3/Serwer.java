package zestaw5.cw3;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
public class Serwer
{
    public static List<Socket> klienci = new ArrayList<Socket>();
    public static void main(String[] args) throws IOException
    {
        ServerSocket serv = new ServerSocket(80);
        while(true)
        {
            //przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock=serv.accept();
            System.out.println(sock);
            //tworzenie watku obslugi tego polaczenia
            new ObslugaZadania(sock).start();
            klienci.add(sock);
        }
    }
}
class WysylanieDoWszystkich extends Thread{
    String wiadomosc;
    Socket klient;
    WysylanieDoWszystkich(String wiadomosc, Socket klient){
        this.wiadomosc = wiadomosc;
        this.klient=klient;
    }

    public void run(){
        try
        {
            for(int i=0; i<Serwer.klienci.size(); i++){
                if (Serwer.klienci.get(i)!=this.klient) {
                    PrintWriter outp;
                    outp = new PrintWriter(Serwer.klienci.get(i).getOutputStream());
                    outp.println(this.wiadomosc);
                    outp.flush();
                }
            }
        }catch(IOException e){}
    }
}
class ObslugaZadania extends Thread
{
    Socket sock;
    String ostatniaWiadomosc = null;
    BufferedReader sockReader;

    ObslugaZadania(Socket klientSocket)
    {
        try{
            this.sock=klientSocket;
            this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
        }catch(IOException e){}
    }

    public void run()
    {
        try {
            String str;
            str = this.sockReader.readLine();
            System.out.println(str);
            new WysylanieDoWszystkich(str, this.sock).start();
            while (!str.equalsIgnoreCase("exit")) {
                this.sockReader = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
                str = this.sockReader.readLine();
                new WysylanieDoWszystkich(str, this.sock).start();

            }
            System.out.println("KONIEC POLACZENIA" );
            //zamykanie polaczenia
            sockReader.close();
        }
        catch (IOException io) {
            System.out.println("Exception");
        }
    }
}
