public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string
        String original = "level";

        // Reverse the string using a loop
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Compare original and reversed strings
        if (original.equals(reversed)) {
            System.out.println(original + " is a Palindrome");
        } else {
            System.out.println(original + " is Not a Palindrome");
        }
    }
}
