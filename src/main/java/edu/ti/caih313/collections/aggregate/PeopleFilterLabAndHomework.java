package edu.ti.caih313.collections.aggregate;

import edu.ti.caih313.collections.dataobj.EmailAddress;
import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;

import java.util.Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static edu.ti.caih313.collections.dataobj.EmailAddress.Type.*;
import static edu.ti.caih313.collections.dataobj.Person.Gender.FEMALE;
import static edu.ti.caih313.collections.dataobj.Person.Gender.MALE;

public class PeopleFilterLabAndHomework {
    public static void main(String[] args) {
        Person boo = new Person(new Name("Bo", "Peep"), FEMALE, 205, "peep@home", SCHOOL);
        boo.addOrReplaceEmail("lala", SCHOOL);
        Person personArray[] = {//TODO make another enum class?
                new Person(new Name("John", "Smith"), MALE, 42, "smith@gmail", SCHOOL),
                new Person(new Name("Karl", "Ng"), MALE, 73, null, null),
                new Person(new Name("Jeff", "Smith"), MALE, 21, "jeff@work", WORK),
                new Person(new Name("Tom", "Rich"), MALE, 18, "Tom@home", HOME),
                new Person(new Name("Bob", "Smith"), MALE, 13, "l", HOME),
                new Person(new Name("Jane", "Doe"), FEMALE, 27, "Doe@gmail", SCHOOL),
                new Person(new Name("Tony", "Stark"), MALE, 52, "stark@work", WORK),
                new Person(new Name("Bo", "Peep"), FEMALE, 205, "peep@home", HOME),
                boo
        };
        personArray[1].addOrReplaceEmail("goon", SCHOOL);
        //TODO make into a string

        System.out.println("youngest female");
        Stream<String> youngestFemale =
                Arrays.stream(personArray)
                        .filter(p -> p.getGender() == FEMALE)
                        .sorted((p1,p2) -> (p1.getAge() - p2.getAge()))
                        .map(p -> p.getName().getFirstName())
                        .limit(1);
        youngestFemale.forEach(s -> System.out.println(s));//TODO include in stream

        System.out.println("oldest male");
        Stream<String> oldestMale =
                Arrays.stream(personArray)
                        .filter(p -> p.getGender() == MALE)
                        .sorted((p1,p2) -> (p2.getAge() - p1.getAge()))
                        .map(p -> p.getName().getFirstName())
                        .limit(1);
        oldestMale.forEach(s -> System.out.print(s));
        System.out.println("unique last names");
        Stream<String> uniqueLastNames = Arrays.stream(personArray)
                .map(p -> p.getName().getLastName())
                .distinct();
        uniqueLastNames.forEach(s -> System.out.println(s));//TODO do a double filter



        System.out.println("list of school email addresses");
        Stream<String> schoolAddresses =
                Arrays.stream(personArray)
                    .filter(p -> p.getEmail().getEmailMap().containsKey(SCHOOL))
                    .map(p -> p.getName().getFirstName());
        schoolAddresses.forEach(s -> System.out.println(s));

        System.out.println("list of persons over 27");
        Stream<String> over27 =
                Arrays.stream(personArray)
                    .filter(p -> p.getAge() > 27)
                    .map(p -> p.getName().getFirstName());
        over27.forEach(s -> System.out.println(s));






    }

}
