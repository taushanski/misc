package math_and_logic_puzzles;

import java.util.Random;

public class TheAppocalypse_6_7 {
    public static void main(String[] args) {
        System.out.println("runNFamilies(10000000000000000L) = " + runNFamilies(10000));
    }
    static double runNFamilies(int n) {
        int boys = 0;
        int girls = 0;
        for (int i = 0; i < n; i++) {
            int[] genders = runOneFamily();
            girls += genders[0];
            boys += genders[1];
        }
        return girls / (double) (boys + girls);
    }

    private static int[] runOneFamily() {

        Random random = new Random();
        int boys = 0;
        int girls = 0;
        while (girls == 0) { // until we get a girl
            if (random.nextBoolean()) { // girl
                girls++;
            } else {
                boys++;
            }
        }
        int[] genders = {girls, boys};
        return genders;
    }
}
