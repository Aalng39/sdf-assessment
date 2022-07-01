package network;

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

        String request = ois.readUTF();
        String[] req = request.split(" ");
        String requestId = req[0];
        String listOfIntegers = req[1];
        String[] integers = listOfIntegers.split(",");

        oos.writeUTF(requestId);
        oos.writeUTF("Andy Ng Zhi Phang");
        oos.writeUTF("andyng3399@hotmail.com");
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
    public static boolean readBoolean(String response) {
        
        if(response.equals("false")){
            return false;   
    }
        return false;
    }

   
            
    
}

