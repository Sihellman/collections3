package edu.ti.caih313.collections.dataobj;

import edu.ti.caih313.collections.lambda.IntegerMath;

import java.util.*;

import static edu.ti.caih313.collections.dataobj.EmailAddress.Type.SCHOOL;

public class Person {
    private Name name;
    private Gender gender;
    private EmailAddress email;






    //age in years
    //TODO -- replace by Date birthday, and getAge that calculates age
    private Integer age;

    public enum Gender {MALE, FEMALE}


    public Person(Name name, Gender gender, Integer age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }



    public void addOrReplaceEmail( String email, EmailAddress.Type type){
        if (getEmail() == null){
            this.email = new EmailAddress(email, type);
        }
        this.email.getEmailMap().put(type, email);
    }

    public EmailAddress getEmail(){
        if (email == null){
            email = null;

        }
        return email;
    }

    public int getSize(){
        int size;
        if (getEmail() == null){
            size = 0;
        }
        else if(getEmail().getEmailMap().size() == 1){
            size = 1;
        }
        else if(getEmail().getEmailMap().size() == 2){
            size = 2;
        }
        else{
            size = 3;
        }
        return size;
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
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", gender=" + gender +
                ", age=" + age +
                ", email=" + email +
                "}";
    }
}
