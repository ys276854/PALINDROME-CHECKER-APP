public class Main{
    public static void main(String[] args) {
        String input = "madam";
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = checkRecursive(cleanStr, 0, cleanStr.length() - 1);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }

    public static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return checkRecursive(str, start + 1, end - 1);
    }
}