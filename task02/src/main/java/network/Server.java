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

                String requestId = "1234abcd";
                String listOfIntegers = "97,35,82,2,45";
                oos.writeUTF(requestId + " " + listOfIntegers);
                oos.flush();
            
                String reponse = ois.readUTF();
            
                if(!reponse.contains("1234abcd"))
            oos.writeUTF("Invalid request id");

                if(!reponse.contains("Andy Ng Zhi Phang"))
                oos.writeUTF("Invalid user"); 

                if(!reponse.contains("andyng3399@hotmail.com"))
                oos.writeUTF("Invalid email address");

                if(!reponse.contains("52.2"))
                oos.writeUTF("Incorrect Average");
                oos.flush();

                is.close();
                os.close();
                os.flush();

                sock.close();
            }
    }
}  
