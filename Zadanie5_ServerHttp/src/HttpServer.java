import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {

    public static void main(String[] args) throws Throwable {
        ServerSocket mySocket = new ServerSocket(7574);
        while (true) {
            Socket s = mySocket.accept();
            System.out.println("Client accepted" );
            new Thread(new SocketProcessor(s)).start();

        }
    }




    private static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream in;
        private OutputStream out;

        DataInputStream sin = new DataInputStream(in);
        DataOutputStream sout = new DataOutputStream(out);


        private SocketProcessor(Socket s) throws Throwable {
            this.s = s;
            this.in = s.getInputStream();
            this.out = s.getOutputStream();

        }





        public void run() {
            try {
                readInputHeaders();
                String response="";

                try {

                    File file = new File("/home/vlad/index.html");

                    FileReader reader = new FileReader(file);

                    BufferedReader in = new BufferedReader(reader);

                    String string;


                    while ((string = in.readLine()) != null) {

                        response = response +string +"\r\n" ;

                    }

                    //System.out.println( );
                    in.close();

                } catch (IOException e) {

                    //  e.printStackTrace();

                }

                writeResponse(response);
                //     System.out.println(files);

            } catch (Throwable t) {
                System.out.println();

            }

        }



        private void writeResponse(String s) throws Throwable {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Server: JavaServer\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + s.length() + "\r\n" +
                    "Connection: close\r\n\r\n";
            String result = response + s;
            out.write(result.getBytes());
            out.flush();
        }


        private void readInputHeaders() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while(true) {
                String s = br.readLine();
                if(s == null || s.trim().length() == 0) {
                  //  s = sin.readUTF(); // ожидаем пока клиент пришлет строку текста.
                   // System.out.println("The dumb client just sent me this line : " + s);
                   // System.out.println("I'm sending it back...");
                   // sout.writeUTF(s); // отсылаем клиенту обратно ту самую строку текста.

                    break;
                }
            }
        }

//File f = new File("1.gif");
//System.out.println("Mime Type of " + f.getName() + " is " + new MimetypesFileTypeMap().getContentType(f));



    }
}