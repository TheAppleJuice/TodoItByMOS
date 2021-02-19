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

       // Person findPersonById = peopleDao.findById(1);
       // System.out.println(findPersonById);

       // Collection<Person> findAll = peopleDao.findAll();
       // findAll.forEach(System.out::println);

       // Collection<Person> findByName = peopleDao.findByName("Sebastian");
       // findByName.forEach(System.out::println);

     // Person updatePerson = new Person(4, "Oliver", "Bocaciu");
     // Person updatedPerson = peopleDao.update(updatePerson);

       // Person findPersonById = peopleDao.findById(1);
       // System.out.println(findPersonById);

       // boolean deletePerson = peopleDao.deleteById(1);

     // Todo_Item addTodoItem = new Todo_Item("Computer", "Buy a new computer", LocalDate.parse("2021-03-01"), false, 3);
     // Todo_Item addedTodoItem = todoItemsDao.create(addTodoItem);
     // System.out.println(addedTodoItem);

      // Collection<Todo_Item> findAllTodoItems = todoItemsDao.findAll();
      // findAllTodoItems.forEach(System.out::println);

       // Todo_Item findById = todoItemsDao.findById(1);
       // System.out.println("Result: " + findById);

       // Collection <Todo_Item> findByDoneStatus = todoItemsDao.findByDoneStatus(false);
       // System.out.println("findByDoneStatus = " + findByDoneStatus);

       // Collection<Todo_Item> findByAssignee = todoItemsDao.findByAssignee(2);
       // System.out.println("findByAssignee = " + findByAssignee);

      // Collection<Todo_Item> findByAssignee = todoItemsDao.findByAssignee( new Person (3, "Sebastian", "Bocaciu"));
      // findByAssignee.forEach(System.out::println);

       // Todo_Item updateTodoItem = new Todo_Item(1,"Update", "updated todo item",LocalDate.parse("2021-02-19"),true,2);
       // Todo_Item updatedTodoItem = todoItemsDao.update(updateTodoItem);
       // System.out.println(updatedTodoItem);

        boolean deleteItem = todoItemsDao.deleteById(3);














    }
}
