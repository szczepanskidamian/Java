package komunikator.cw2;
import java.io.*;
import java.net.*;

class Odbior extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    public Odbior(Socket sock) throws IOException
    {
        this.sock=sock;
        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run()
    {
        try {
            String str;
            str = this.sockReader.readLine();
            System.out.println("<Nadeszlo:> " + str);
            while (!str.equalsIgnoreCase("exit")) {
                this.sockReader = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
                str = this.sockReader.readLine();
                System.out.println("<Nadeszlo:> " + str);
            }
        }
        catch (IOException io) {
            System.out.println("Exception");
        }
    }
}