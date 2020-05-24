package edu.ti.caih313.collections.dataobj;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static edu.ti.caih313.collections.dataobj.EmailAddress.Type.*;

public class EmailAddress {
    private String email;
    private Type type;
    private Map<Type, String> emailMap = new HashMap<>();
    public enum Type{HOME, SCHOOL, WORK}
    public EmailAddress(String email, Type type){
        this.email = email;
        this.type = type;

    }

    public Map<Type, String> getEmailMap(){
        return emailMap;
    }
    public Type getType(){
        return type;
    }
    public String getEmailString(){
        return email;
    }
    public static String primaryEmailAddress(Person person){
        String primaryEmail = "";
        if (person.getEmail() == null){
            primaryEmail = null;
        }
        else if (person.getEmail().getEmailMap().containsKey(HOME)){
            primaryEmail =  person.getEmail().getEmailMap().get(HOME);
        }
        else if(person.getEmail().getEmailMap().containsKey(WORK)){
            primaryEmail = person.getEmail().getEmailMap().get(WORK);
        }
        else if(person.getEmail().getEmailMap().containsKey(SCHOOL)){
            primaryEmail =  person.getEmail().getEmailMap().get(SCHOOL);
        }
        return primaryEmail;
    }


}
