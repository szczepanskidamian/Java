package zestaw6.cw2;

import java.io.*;
import java.net.*;

class ObslugaZadania extends Thread
{
    Socket sock;

    ObslugaZadania(Socket klientSocket)
    {
        this.sock=klientSocket;
    }

    public void run()
    {

    }
}