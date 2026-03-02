import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "level";
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 1. Two-Pointer Approach Performance
        long startTime = System.nanoTime();
        boolean res1 = checkTwoPointer(cleanStr);
        long endTime = System.nanoTime();
        long durationTP = endTime - startTime;

        // 2. Deque Approach Performance
        startTime = System.nanoTime();
        boolean res2 = checkDeque(cleanStr);
        endTime = System.nanoTime();
        long durationDeque = endTime - startTime;

        // 3. Stack (Reverse) Approach Performance
        startTime = System.nanoTime();
        boolean res3 = checkStack(cleanStr);
        endTime = System.nanoTime();
        long durationStack = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + res1);
        System.out.println("\n--- Performance Results (nanoseconds) ---");
        System.out.println("Two-Pointer Time : " + durationTP + " ns");
        System.out.println("Deque Time       : " + durationDeque + " ns");
        System.out.println("Stack Time       : " + durationStack + " ns");
    }

    public static boolean checkTwoPointer(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean checkDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static boolean checkStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return str.equals(sb.toString());
    }
}