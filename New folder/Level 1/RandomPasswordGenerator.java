import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        System.out.print("Include numbers? (y/n): ");
        char includeNumbers = scanner.next().charAt(0);
        System.out.print("Include lowercase letters? (y/n): ");
        char includeLowercase = scanner.next().charAt(0);
        System.out.print("Include uppercase letters? (y/n): ");
        char includeUppercase = scanner.next().charAt(0);
        System.out.print("Include special characters? (y/n): ");
        char includeSpecial = scanner.next().charAt(0);

        String characters = "";
        if (includeNumbers == 'y') {
            characters += "0123456789";
        }
        if (includeLowercase == 'y') {
            characters += "abcdefghijklmnopqrstuvwxyz";
        }
        if (includeUppercase == 'y') {
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (includeSpecial == 'y') {
            characters += "!@#$%^&*()_+-=[]{}|;':\"<>,./?";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        System.out.println("Random password: " + password);
        scanner.close();
    }
}