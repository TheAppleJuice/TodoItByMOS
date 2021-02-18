package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.util.List;

public interface TodoItems {
    Todo_Item create (Todo_Item todo);
    List<Todo_Item> findAll();
    Todo_Item findById (int todo_id);
    List<Todo_Item> findByDoneStatus (boolean done);
    List<Todo_Item> findByAssignee (int assignee_id);
    List<Todo_Item> findByAssignee (Person person);
    List<Todo_Item> findByUnassignedTodoItems();
    Todo_Item update (Todo_Item todo);
    boolean deleteById (int todo_id);

}
