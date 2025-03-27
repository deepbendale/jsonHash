import java.io.*;
import java.util.Scanner;

public class HashGenerator {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.json"));
            String fname = "";
            String rno = "";
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("first_name")) {
                    fname = line.split(":")[1];
                    fname = fname.replace("\"", "");
                    fname = fname.replace(",", "");
                    fname = fname.trim();
                }

                if (line.contains("roll_number")) {
                    rno = line.split(":")[1];
                    rno = rno.replace("\"", "");
                    rno = rno.replace(",", "");
                    rno = rno.trim();
                }
            }
            sc.close();
            fname = fname.toLowerCase();
            rno = rno.toLowerCase();
            String str = fname + rno;
            System.out.println("Name and roll: " + str);

            String hash = makeHash(str);
            System.out.println("Hash value: " + hash);

            FileWriter fw = new FileWriter("output.txt");
            fw.write(hash);
            fw.close();

            System.out.println("Saved to output.txt!");

        } catch (Exception e) {
            System.out.println("Error:");
            System.out.println(e);
        }
    }

    public static String makeHash(String s) {
        try {
            byte[] b = s.getBytes();

            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            byte[] hash = md5.digest(b);

            String result = "";
            for (byte bt : hash) {
                result = result + String.format("%02x", bt);
            }

            return result;

        } catch (Exception e) {
            System.out.println("Hash error: " + e);
            return "";
        }
    }
}
