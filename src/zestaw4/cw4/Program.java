package zestaw4.cw4;
import java.io.*;

public class Program
{
    public static void main(String[] args)
    {
        System.out.println("-- do zapisu --");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(br.readLine());
        }
        catch(IOException e){
            System.out.println("Błąd odczytu pliku");
        }
        DowodOsobisty z=new DowodOsobisty(new Osoba("Jajor","Strusiodolski"));
        z.info();

        try
        {
            ObjectOutputStream outp=new ObjectOutputStream(new FileOutputStream("plik.dat"));
            outp.writeObject(z);
            outp.close();
        }
        catch(Exception e){System.out.println(e);}



        System.out.println("\n-- z pliku --");
        ObjectInputStream inp;

        try
        {
            inp=new ObjectInputStream(new FileInputStream("plik.dat"));
            Object o=inp.readObject();
            DowodOsobisty x=(DowodOsobisty)o;
            inp.close();
            x.info();
        }
        catch(Exception e){System.out.println(e);}
    }
}
