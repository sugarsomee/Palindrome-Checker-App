import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

// PalindromeStrategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Main application for performance comparison
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        PalindromeStrategy[] strategies = { new StackStrategy(), new DequeStrategy() };
        String[] strategyNames = { "Stack Strategy", "Deque Strategy" };

        for (int i = 0; i < strategies.length; i++) {

            long startTime = System.nanoTime();
            boolean result = strategies[i].isPalindrome(input);
            long endTime = System.nanoTime();

            System.out.println("\n" + strategyNames[i] + ":");
            System.out.println("Result: " + (result ? "Palindrome" : "NOT Palindrome"));
            System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        }

        scanner.close();
    }
}