import java.io.*;
import java.util.Scanner;

// my java program to read json and make hash
public class HashGenerator {
    public static void main(String[] args) {
        try {
            // reading json file
            Scanner sc = new Scanner(new File("input.json"));
            String fname = "";  // for first name
            String rno = "";   // for roll number
            
            // reading line by line
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                
                // get first name
                if(line.contains("first_name")) {
                    fname = line.split(":")[1];
                    fname = fname.replace("\"", "");
                    fname = fname.replace(",", "");
                    fname = fname.trim();
                }
                
                // get roll number
                if(line.contains("roll_number")) {
                    rno = line.split(":")[1];
                    rno = rno.replace("\"", "");
                    rno = rno.replace(",", "");
                    rno = rno.trim();
                }
            }
            sc.close();
            
            // make everything small letters
            fname = fname.toLowerCase();
            rno = rno.toLowerCase();
            
            // join the strings
            String str = fname + rno;
            System.out.println("Name and roll: " + str);
            
            // make hash
            String hash = makeHash(str);
            System.out.println("Hash value: " + hash);
            
            // save to file
            FileWriter fw = new FileWriter("output.txt");
            fw.write(hash);
            fw.close();
            
            System.out.println("Saved to output.txt!");
            
        } catch(Exception e) {
            // if something goes wrong
            System.out.println("Error:");
            System.out.println(e);
        }
    }
    
    // function to make md5 hash
    public static String makeHash(String s) {
        try {
            byte[] b = s.getBytes();
            
            // using MD5 algorithm
            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            byte[] hash = md5.digest(b);
            
            // convert bytes to hex
            String result = "";
            for(byte bt : hash) {
                result = result + String.format("%02x", bt);
            }
            
            return result;
            
        } catch(Exception e) {
            System.out.println("Hash error: " + e);
            return "";
        }
    }
}
