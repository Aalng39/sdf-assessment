package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException{

        try (ServerSocket server = new ServerSocket(80)) {
            System.out.println("Waiting for connection on port 80...");
            Socket sock = server.accept();
            System.out.println("Connection accepted");

                OutputStream os = sock.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);

                InputStream is = sock.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
            
            
                String request = ois.readUTF();
            
                if(!request.contains("1234abcd"))
            oos.writeUTF("Invalid request id");

                if(!request.contains("Andy Ng Zhi Phang"))
                oos.writeUTF("Invalid user"); 

                if(!request.contains("andyng3399@hotmail.com"))
                oos.writeUTF("Invalid email address");

                if(!request.contains("52.2"))
                oos.writeUTF("Incorrect Average");
                oos.flush();

                is.close();
                os.close();
                os.flush();

                sock.close();
            }
    }
}  
