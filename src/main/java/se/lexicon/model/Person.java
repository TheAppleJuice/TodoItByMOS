package se.lexicon.model;
import se.lexicon.data.PersonSequencer;
public class Person {
    private int person_Id;
    private String first_Name;
    private String last_Name;

    public Person() {
    }

    public Person(String first_Name, String last_Name) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }

    public Person(int person_Id, String first_Name, String last_Name) {
        this.person_Id = person_Id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }

    public int getPerson_Id() {
        return person_Id;
    }
    public String getFirstName() {
        return first_Name;
    }
    public void setFirstName(String firstName) {
        this.first_Name = firstName;
    }
    public String getLastName() {
        return last_Name;
    }
    public void setLastName(String lastName) {
        this.last_Name = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_Id=" + person_Id +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                '}';
    }
}