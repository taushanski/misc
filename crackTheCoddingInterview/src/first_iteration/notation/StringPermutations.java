package first_iteration.notation;

public class StringPermutations {

    public static void main(String[] args) {
        System.out.println("CAlled with " + args[0]);
        permuntation(args[0]);
    }

    private static void permuntation(String word) {
        permutation(word, "");
    }

    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
