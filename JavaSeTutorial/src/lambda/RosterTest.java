/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Feb 15, 2015 by i059884
 * 
 */

package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RosterTest {

  public static void printPersonsOlderThan(List<Person> roster, int age) {

    for (Person person : roster) {
      if (person.getAge() > age) {
        person.printPerson();
      }
    }
  }

  public static void printPersonsWithinAgeRange(List<Person> roster, int startAge, int endAge) {
    for (Person person : roster) {
      if (startAge <= person.getAge() && person.getAge() < endAge) {
        person.printPerson();
      }
    }
  }

  interface CheckPerson {
    boolean test(Person p);
  }

  public static void printPersons(List<Person> roster, CheckPerson tester) {
    for (Person person : roster) {
      if (tester.test(person)) {
        person.printPerson();
      }
    }
  }

  class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
      return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
    }
  }

  public static void main(String[] args) {

    List<Person> roster = Person.createRoster();

    printPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

    processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.printPerson());

    processPersonsWithFunction(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.getEmailAddress(),
        email -> System.out.println(email));

    roster.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25).map(p -> p.getEmailAddress())
        .forEach(email -> System.out.println(email));
  }

  public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
    for (Person person : roster) {
      if (tester.test(person)) {
        block.accept(person);
      }
    }
  }

  public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
    for (Person p : roster) {
      if (tester.test(p)) {
        String data = mapper.apply(p);
        block.accept(data);
      }
    }
  }
}
