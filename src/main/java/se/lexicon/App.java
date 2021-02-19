package se.lexicon;


import se.lexicon.data.People;
import se.lexicon.data.People_Impl;
import se.lexicon.data.TodoItems;
import se.lexicon.data.Todoitems_Impl;
import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        People peopleDao = new People_Impl();
        TodoItems todoItemsDao = new Todoitems_Impl();

       // Person createPerson = peopleDao.create(new Person("Sebastian", "Bocaciu"));
       // System.out.println(createPerson);
        // Person createPerson = peopleDao.create(new Person("Emma", "Petersson"));


        //  Person findPersonById = peopleDao.findById(1);
      //  System.out.println(findPersonById);

       // List<Person> findAll = peopleDao.findAll();
      //  findAll.forEach(System.out::println);

       // List<Person> findByName = peopleDao.findByName("Sebastian");
       // findByName.forEach(System.out::println);

       // Person updatePerson = new Person(1, "Sebastian", "Petersson");
       // Person updatedPerson = peopleDao.update(updatePerson);

      //  Person findPersonById = peopleDao.findById(1);
      //  System.out.println(findPersonById);

       // boolean deletePerson = peopleDao.deleteById(1);

       // Todo_Item addTodoItem = new Todo_Item("Handla", "Handla mjölk", LocalDate.parse("2021-03-01"), false, 2);
       // Todo_Item addedTodoItem = todoItemsDao.create(addTodoItem);
      //  System.out.println(addedTodoItem);

      //  List<Todo_Item> findAllTodoItems = todoItemsDao.findAll();
      //  findAllTodoItems.forEach(System.out::println);

        Todo_Item findById = todoItemsDao.findById(1);
        System.out.println("Result: " + findById);




    }
}
