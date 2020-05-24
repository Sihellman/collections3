package edu.ti.caih313.collections.aggregate;

import edu.ti.caih313.collections.dataobj.EmailAddress;
import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;

import java.util.*;

import java.util.stream.Stream;

import static edu.ti.caih313.collections.dataobj.EmailAddress.Type.*;
import static edu.ti.caih313.collections.dataobj.Person.Gender.FEMALE;
import static edu.ti.caih313.collections.dataobj.Person.Gender.MALE;
import static java.util.Arrays.stream;


public class PeopleFilterHomework {
    public static void main(String[] args) {
        Person boo = new Person(new Name("Bo", "Peep"), FEMALE, 205);
        boo.addOrReplaceEmail("boo@school", SCHOOL);
        boo.addOrReplaceEmail("boo2@school", SCHOOL);
        boo.addOrReplaceEmail("boo@work", WORK);
        boo.addOrReplaceEmail("boo@home", HOME);

        Person karl = new Person(new Name("Karl", "Ng"), MALE, 73);

        Person john = new Person(new Name("John", "Smith"), MALE, 42);
        john.addOrReplaceEmail("john@school", SCHOOL);
        john.addOrReplaceEmail("john@home", HOME);

        Person jeff = new Person(new Name("Jeff", "Smith"), MALE, 21);
        jeff.addOrReplaceEmail("jeff@work", WORK);

        Person tom = new Person(new Name("Tom", "Rich"), MALE, 18);
        tom.addOrReplaceEmail("Tom@home", HOME);

        Person bob = new Person(new Name("Bob", "Smith"), MALE, 13);
        bob.addOrReplaceEmail("bob@home", HOME);

        Person jane = new Person(new Name("Jane", "Doe"), FEMALE, 27);
        jane.addOrReplaceEmail("Doe@school", SCHOOL);

        Person tony = new Person(new Name("Tony", "Stark"), MALE, 52);
        tony.addOrReplaceEmail("stark@work", WORK);

        Person bo = new Person(new Name("Bo", "Peep"), FEMALE, 205);
        bo.addOrReplaceEmail("peep@home", HOME);

        Person personArray[] = {john, karl, jeff, tom, bob, jane, tony, bo, boo};




        System.out.println("boo's primary email address: " + EmailAddress.primaryEmailAddress(boo));
        System.out.println("karl's email: " + karl.getEmail());
        System.out.println("karl's primary email address: " + EmailAddress.primaryEmailAddress(karl));
        System.out.println();
        System.out.println("karl toString: " + karl.toString());
        System.out.println();
        System.out.println("list of school email addresses");
        Stream<String> schoolAddresses =
                stream(personArray)
                    .filter(p -> p.getEmail() != null)
                    .filter(p -> p.getEmail().getEmailMap().containsKey(SCHOOL))
                    .map(person -> person.getEmail().getEmailString());
        schoolAddresses.forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("list of all emails for each person over 27");
        Stream<String> over27 =
                stream(personArray)
                    .filter(p -> p.getEmail() != null)
                    .filter(p -> p.getAge() > 27)
                    .map(p -> p.getEmail().getEmailMap().values().toString());

        over27.forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("an email of each person over 27");
        Stream<String> over27OneEmail =
                stream(personArray)
                        .filter(p -> p.getEmail() != null)
                        .filter(p -> p.getAge() > 27)
                        .map(p -> p.getEmail().getEmailString());

        over27OneEmail.forEach(s -> System.out.println(s));
        System.out.println();
        /*for (EmailAddress.Type key : personArray[0].getEmail().getEmailMap().keySet()) {
            String email = personArray[0].getEmail().getEmailMap().get(key);
            System.out.println(key +
                    " --> " + email);
        }*/
        Stream<String> number =
                stream(personArray)
                        .sorted((p1,p2) -> p1.getName().getFirstName().compareTo(p2.getName().getFirstName()))
                        .sorted((p1,p2) -> p1.getName().getLastName().compareTo(p2.getName().getLastName()))
                        .sorted((p1,p2) -> p2.getSize() - p1.getSize())
                        .map(p -> p.getName().getLastName() + " " + p.getName().getFirstName() + " " + p.getSize());

        number.forEach(s -> System.out.println(s));




    }

}
