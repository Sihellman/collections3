package edu.ti.caih313.collections.aggregate;

import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static edu.ti.caih313.collections.dataobj.Person.Gender.FEMALE;
import static edu.ti.caih313.collections.dataobj.Person.Gender.MALE;
import static java.util.Arrays.stream;

public class PeopleFilterLab {
    public static void main(String[] args) {
        Person personArray[] = {
                new Person(new Name("Karl", "Ng"), MALE, 73),
                new Person(new Name("John", "Smith"), MALE, 42),
                new Person(new Name("Jeff", "Smith"), MALE, 21),
                new Person(new Name("Tom", "Rich"), MALE, 18),
                new Person(new Name("Bob", "Smith"), MALE, 13),
                new Person(new Name("Jane", "Doe"), FEMALE, 27),
                new Person(new Name("Tony", "Stark"), MALE, 52),
                new Person(new Name("Bo", "Peep"), FEMALE, 205)
        };
        System.out.println("youngest female");
        Stream<String> youngestFemale =
                stream(personArray)
                        .filter(p -> p.getGender() == FEMALE)
                        .sorted((p1,p2) -> (p1.getAge() - p2.getAge()))
                        .map(p -> p.getName().getFirstName())
                        .limit(1);
        youngestFemale.forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("oldest male");
        Stream<String> oldestMale =
                stream(personArray)
                        .filter(p -> p.getGender() == MALE)
                        .sorted((p1,p2) -> (p2.getAge() - p1.getAge()))
                        .map(p -> p.getName().getFirstName())
                        .limit(1);
        oldestMale.forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("unique last names");
        Stream<String> uniqueLastNames = Arrays.stream(personArray)
                .map(p -> p.getName().getLastName())
                .distinct();
        uniqueLastNames.forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("histogram of last names");
        Map<String, Integer> lastNames = new HashMap<String, Integer>();
        for (int i = 0; i < personArray.length; i++){
            if (lastNames.containsKey(personArray[i].getName().getLastName())){
                lastNames.put(personArray[i].getName().getLastName(), lastNames.get(personArray[i].getName().getLastName())+1);
            }
            else{
                lastNames.put(personArray[i].getName().getLastName(), 1);
            }
        }
        for (String key : lastNames.keySet()) {
            System.out.println(key + " : " + lastNames.get(key));
        }


    }
}
