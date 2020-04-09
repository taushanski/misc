package java_chapter;


import java.util.Arrays;
import java.util.List;

import static java_chapter.LambdaExpressions_13_7.Continent.Africa;
import static java_chapter.LambdaExpressions_13_7.Continent.Europe;

public class LambdaExpressions_13_7 {
    public static void main(String[] args) {
        List<Country> countries = Arrays.asList(new Country("A", Europe, 10), new Country("B", Europe, 25),
                new Country("C", Africa, 1));
        System.out.println("getPopulation(countries, Europe) = " + getPopulation(countries, Africa));

    }

    private static int getPopulation(List<Country> countries, Continent continent) {
        return countries.stream().filter(country -> country.getContinent() == continent).mapToInt(
                country -> country.getPopulation()).sum();
    }

    private static class Country {

        private final String name;
        private final Continent continent;
        private final int population;

        public Country(String name, Continent continent, int population) {
            this.name = name;
            this.continent = continent;
            this.population = population;
        }

        public int getPopulation() {
            return population;
        }

        public Continent getContinent() {
            return continent;
        }

        public String getName() {
            return name;
        }
    }

    public enum Continent {
        Africa,
        NorthAmerica,
        SouthAmerica,
        Antarctica,
        Asia,
        AustraliaAndOceania,
        Europe
    }

}
