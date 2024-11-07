import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isWhitespace(c)) {
                hasSpecial = true;
            }
        }
        if (length < 8) {
            System.out.println("Password is too short. It should be at least 8 characters.");
        } else if (!hasUppercase || !hasLowercase || !hasNumber || !hasSpecial) {
            System.out.println("Password is weak. It should include at least one uppercase letter, one lowercase letter, one number, and one special character.");
        } else {
            System.out.println("Password is strong.");
        }
        scanner.close();
    }
}