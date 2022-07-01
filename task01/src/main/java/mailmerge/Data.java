package mailmerge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Data {
    public static void main(String[] args){
        try {
        List<String> info = new LinkedList<String>();
        String path = "C:/Users/andyn/Desktop/sdf-assessment/task01/src/test/java/mailmerge/thankyou.csv";
         info = Files.readAllLines(Paths.get(path));
         for(int i = 0; i < info.size(); i++){
            String[] info2 = (info.get(i)).split(",");
            System.out.println(Arrays.toString(info2));
            

        }
            BufferedReader br = new BufferedReader(new FileReader(path));
            
        
            
            
            
            String line;
            while((line = br.readLine()) != null){
                info.add(line.split(","));
                }
                System.out.println(info.size());
                System.out.println(Arrays.toString(info.get(0)));
                String[] details = info.get(0);
                System.out.println(details[0]);
                
                 
                    
        br.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//