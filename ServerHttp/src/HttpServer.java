import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static void main(String[] args) throws Throwable {
        ServerSocket mySocket = new ServerSocket(7567);
        while (true) {
            Socket s = mySocket.accept();
            System.err.println("Client accepted");
            new Thread(new SocketProcessor(s)).start();
        }
    }

    private static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream is;
        private OutputStream out;

        private SocketProcessor(Socket s) throws Throwable {
            this.s = s;
            this.is = s.getInputStream();
            this.out = s.getOutputStream();
        }


        public void run() {
            try {
                readInputHeaders();
                writeResponse("<html><body><h1>Hello Vlad</h1></body></html>");
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
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while(true) {
        String s = br.readLine();
        if(s == null || s.trim().length() == 0) {
            break;
        }
    }
}

//File f = new File("1.gif");
//System.out.println("Mime Type of " + f.getName() + " is " + new MimetypesFileTypeMap().getContentType(f));



}
}