public class PalindromeCheck {

    public static void main(String[] args) {
        String input = "abaab";
        System.out.println("isPalindrome(input) = " + isPalindrome(input));
    }

    /*O(n) time | O(1) space*/
    private static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
