package se.lexicon;


import se.lexicon.data.People;
import se.lexicon.data.People_Impl;
import se.lexicon.model.Person;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
        People peopleDao = new People_Impl();

       // Person createPerson = peopleDao.create(new Person("Sebastian", "Bocaciu"));
       // System.out.println(createPerson);
        // Person createPerson = peopleDao.create(new Person("Emma", "Petersson"));


        //  Person findPersonById = peopleDao.findById(1);
      //  System.out.println(findPersonById);

        List<Person> findAll = peopleDao.findAll();
        findAll.forEach(System.out::println);

    }
}
