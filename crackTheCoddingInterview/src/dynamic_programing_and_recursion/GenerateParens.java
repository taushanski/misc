package dynamic_programing_and_recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParens {

    public static void main(String[] args) {
        int n = 14;

        System.out.println("generateParens(n) = " + generateParens(n));
        System.out.println("generateParens2(n) = " + generateParens2(n));
    }

    private static Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        /*Add s to set if it's not already in there. Note: HashSet
                         *automatically checks for duplicates before adding, so an explicit
                         *check is not necessary. */
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    private static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1);
        return left + "()" + right;
    }

    private static List<String> generateParens2(int count) {
        char[] str = new char[count * 2];
        List<String> list = new ArrayList<>();
        addParens(list, count, count, str, 0);
        return list;
    }

    private static void addParens(List<String> list, int leftRem, int rightRem, char[] str, int index) {

        if (leftRem < 0 || rightRem < leftRem) {
            return; // invalid state
        }

        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '('; // add left parentheses and recurse
            addParens(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')'; // add right parentheses and recurse
            addParens(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
