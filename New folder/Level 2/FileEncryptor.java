import java.io.*;
import java.util.Scanner;
public class FileEncryptor {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose between encryption or decryption (e/d): ");
        char choice = scanner.next().charAt(0);
        scanner.nextLine();
        System.out.print("Enter the file name or path: ");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".encrypted"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encryptOrDecrypt(choice, line);
                writer.write(encryptedLine);
                writer.newLine();
            }
        }
        scanner.close();
        System.out.println("File encrypted/decrypted successfully.");
    }
    public static String encryptOrDecrypt(char choice, String line) {
        StringBuilder encryptedLine = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (choice == 'e') {
                c = (char) (c + 1);
            } else if (choice == 'd') {
                c = (char) (c - 1);
            }
            encryptedLine.append(c);
        }
        return encryptedLine.toString();
        
    }
    
}