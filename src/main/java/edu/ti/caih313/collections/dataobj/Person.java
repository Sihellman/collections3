package edu.ti.caih313.collections.dataobj;

import edu.ti.caih313.collections.lambda.IntegerMath;

import java.util.*;

import static edu.ti.caih313.collections.dataobj.EmailAddress.Type.SCHOOL;

public class Person {
    private Name name;
    private Gender gender;
    private EmailAddress email;




    //private EmailAddress emailAddress;

    //age in years
    //TODO -- replace by Date birthday, and getAge that calculates age
    private Integer age;

    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, Integer age, String emailString, EmailAddress.Type type) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        email = new EmailAddress(emailString, type);

    }
    public Person(Name name, Gender gender, Integer age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }



    public void addOrReplaceEmail(String email, EmailAddress.Type type){
          new Person(getName(), getGender(), getAge(), email, type);
    }

    public EmailAddress getEmail(){
        return email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }



    @Override
    public String toString() {//TODO add email
        return "Person{" +
                "name=" + name +
                ", gender=" + gender +
                ", age=" + age
                + "}";
    }
}
