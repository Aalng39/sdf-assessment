package network;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        
        System.out.println("Connecting to task02.chuklee.com at port 80");

        Socket sock = new Socket("task02.chuklee.com", 80);
        System.out.println("Connected.");
       
       
        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        
        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        String requestId = "1234abcd";
        String listOfIntegers = "97,35,82,2,45";
        String[] integers = listOfIntegers.split(",");

        Console cons = System.console();
        String id = cons.readLine(requestId + " " + listOfIntegers + "\n");
        String name = cons.readLine();
        String email = cons.readLine();

        // Write to server
        oos.writeUTF(id);
        oos.writeUTF(name);
        oos.writeUTF(email);
        oos.writeUTF(String.valueOf(getAverage(integers)));
        oos.flush();

        // Wait for response from server
        String response = ois.readUTF();
            if(!readBoolean(response)){
                ois.readUTF();
                System.out.println("FAILED");
            }else{
                System.out.println("SUCCESS");
            }

        
        is.close();
        os.close();

       
        sock.close();
    }

    public static boolean readBoolean(String response) {
        
        return false;
    }

    //METODS TO GET AVERAGE PART 3
    public static float getAverage(String[] integers){
        float sum = 0;
        float average = 0f;
        for (int i = 0; i < integers.length; i++) {
                float a = Float.parseFloat(String.valueOf(integers[i]));
                sum = sum + a;
                 average = sum / integers.length;
            
            }
            return average;
            
    }
}

