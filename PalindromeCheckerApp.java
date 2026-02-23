public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string
        String word = "radar";

        // Convert string to character array
        char[] chars = word.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is Not a Palindrome");
        }
    }
}