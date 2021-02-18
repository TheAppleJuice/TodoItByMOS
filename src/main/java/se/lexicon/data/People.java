package se.lexicon.data;

import se.lexicon.model.Person;

import java.util.List;

public interface People {
    Person create (Person person);
    List<Person> findAll();
    Person findById(int person_id);
    List<Person> findByName(String name);
    Person update (Person person);
    boolean deleteById (int person_id);


}
