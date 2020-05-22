package edu.ti.caih313.collections.dataobj;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static edu.ti.caih313.collections.dataobj.EmailAddress.Type.SCHOOL;

public class EmailAddress {
    private String email;
    private Type type;
    private Map<Type, String> emailMap = new HashMap<>();
    public enum Type{HOME, SCHOOL, WORK}
    public EmailAddress(String email, Type type){
        this.email = email;
        this.type = type;
        emailMap.put(type, email);
    }

    public Map<Type, String> getEmailMap(){
        return emailMap;
    }
    public Type getType(){
        return type;
    }
    public String getEmail(){
        return email;
    }
    public String primaryEmailAddress(){
        return type.toString();//TODO return null
    }


}
