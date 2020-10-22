package first_iteration.java_chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaRandom_10_8 {

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("getRandomSubset(elements) = " + getRandomSubset(elements));

    }

    private static List<Integer> getRandomSubset(List<Integer> elements) {
        List<Integer> resultSubset = new ArrayList<>();
        Random random = new Random();
        elements.forEach(nextElement -> {
            /*Flip a coin*/
            if (random.nextBoolean()) {
                resultSubset.add(nextElement);
            }
        });
        return resultSubset;
    }

    private static List<Integer> getRandomSubsetLambda(List<Integer> elements) {
        Random random = new Random();

        return elements.stream().filter(nextElement -> random.nextBoolean()/*Flip a coin*/).collect(
                Collectors.toList());
    }
}
