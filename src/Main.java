import java.util.*;

interface PalindromeStrategy {
    boolean isValid(String str);
}

class StackStrategy implements PalindromeStrategy {
    public boolean isValid(String str) {
        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : clean.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return clean.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean isValid(String str) {
        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : clean.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeValidator {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String str) {
        return strategy.isValid(str);
    }
}

public class Main {
    public static void main(String[] args) {
        String input = "level";
        PalindromeValidator validator = new PalindromeValidator();

        validator.setStrategy(new DequeStrategy());
        boolean result = validator.validate(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}