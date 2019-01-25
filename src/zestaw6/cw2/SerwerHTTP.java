package zestaw6.cw2;

import java.io.*;
import java.net.*;

public class SerwerHTTP
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serv=new ServerSocket(80);

        while(true)
        {
            //przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock=serv.accept();

            //tworzenie watku obslugi tego polaczenia
            new ObslugaZadania(sock).start();
        }
    }
}
