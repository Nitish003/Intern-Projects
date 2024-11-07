public class PalindromeChecker {
    public static void main(String[] args) {
        String input = "Madam, I'm Adam.";
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String input) {
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(input).reverse();
        return input.equals(reversed.toString());
    }
}