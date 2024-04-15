package tdd.exercice.Person;

import java.util.List;

import tdd.exercice.Email.Email;

public class Person {

    private int id;
    private String name;
    private int age;
    private List<Email> emails;

  
    public Person(int id, String name, int age, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emails = emails;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public List<Email> getEmails() {
        return emails;
    }
    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

}
