package second_iteration.arrays_and_strings_1;

public class URLify_1_3 {

    public static void main(String[] args) {
        char[] source = "Mr John Smith      ".toCharArray();
        encodeUrl(source, 13);
        System.out.println(source);
    }

    private static void encodeUrl(char[] source, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < source.length; i++) {
            if (i >= trueLength) {
                source[i] = '^';
            } else if (source[i] == ' ') {
                spaceCount++;
            }

        }
        int destPos = trueLength + spaceCount * 2;
        for (int sourcePos = trueLength - 1; sourcePos >= 0; sourcePos--) {
            char nextSourceChar = source[sourcePos];
            if (nextSourceChar == ' ') {
                source[destPos - 1] = '0';
                source[destPos - 2] = '2';
                source[destPos - 3] = '%';
                destPos -= 3;
            } else {
                source[destPos - 1] = nextSourceChar;
                destPos -= 1;
            }
        }

    }

}
