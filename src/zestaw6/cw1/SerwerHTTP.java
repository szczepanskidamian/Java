package zestaw6.cw1;

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

            //strumienie danych
            InputStream is=sock.getInputStream();
            OutputStream os=sock.getOutputStream();
            BufferedReader inp=new BufferedReader(new InputStreamReader(is));
            DataOutputStream outp=new DataOutputStream(os);

            //przyjecie zadania (request)
            String request=inp.readLine();
            String str;
            //wyslanie odpowiedzi (response)
            if(request.startsWith("GET"))
            {
                //response header
                outp.writeBytes("HTTP/1.0 200 OK\r\n");
                outp.writeBytes("Content-Type: text/html\r\n");
                outp.writeBytes("Content-Length: \r\n");
                outp.writeBytes("\r\n");

                //response body
                outp.writeBytes("<html>\r\n");
                outp.writeBytes("<H1>Strona testowa</H1>\r\n");
                outp.writeBytes("</html>\r\n");
            }
            else
            {
                outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");
            }

            StringBuffer response = new StringBuffer();
            while ((str = inp.readLine()) != null) {
                if (str.isEmpty()) break;
                response.append(str);
                System.out.println(str+"\n");
            }

//            System.out.println(response);
            //zamykanie strumieni

//            System.out.println("Zamkniete");

            try {
//                FileInputStream file = new FileInputStream("plik.txt");
                FileInputStream file = new FileInputStream("plik.txt");
            }
            catch (Exception e){
                outp.writeBytes("<html>\r\n");
                outp.writeBytes("<H1>HTTP/1.0 404 Not Found</H1>\r\n");
                outp.writeBytes("</html>\r\n");
            }
            String file = "bufor.txt";
            FileInputStream fis = new FileInputStream(file);
            String[] fileName = file.split("[.]");

            byte[] bufor;
            bufor=new byte[1024];
            int n=0;
            int bajty = fis.available();
            System.out.println(bajty);

            int i = 0;
            while ((n = fis.read(bufor)) != -1 )
            {
                outp.write(bufor,0,n);
                outp.writeBytes("<html>\r\n");
                outp.writeBytes("<H1>Content-Lenght: "+bajty+"</H1>\r\n");
                String typ;
                if (fileName[fileName.length-1].equals("html") || fileName[fileName.length-1].equals("htm")){
                    outp.writeBytes("<H1>Content-Type: text/html\\r\\n</H1>\r\n");
                }
                else{
                    outp.writeBytes("<H1>Content-Type: \\r\\n</H1>\r\n");
                }
                outp.writeBytes("</html>\r\n");
            }


            inp.close();
            outp.close();
            sock.close();
        }
    }
}
