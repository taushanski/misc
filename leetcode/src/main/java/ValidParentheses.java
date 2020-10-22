import java.util.*;

public class ValidParentheses {

    private final static Map<Character, Character> brackets;


    static {
        brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
    }

    public static void main(String[] args) {
        String source = "]";
        System.out.println("isValid(source) = " + isValid(source));
    }


    private static boolean isValid(String source) {
        if (source.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char nextBracket : source.toCharArray()) {
            if (brackets.containsKey(nextBracket)) { // its a closing bracket
                if (stack.isEmpty()) {
                    return false;
                }
                Character expectedOpeningBracketType = brackets.get(nextBracket);
                Character actualOpeningBracket = stack.removeFirst();
                if (!expectedOpeningBracketType.equals(actualOpeningBracket)) {
                    return false;
                }
            } else { // its an opening bracket so save it for later
                stack.addFirst(nextBracket);
            }
        }
        return stack.isEmpty();
    }

}
