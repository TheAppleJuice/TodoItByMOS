package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.util.Collection;

public interface TodoItems {
    Todo_Item create (Todo_Item todo);
    Collection<Todo_Item> findAll();
    Todo_Item findById (int todo_id);
    Collection<Todo_Item> findByDoneStatus (boolean done);
    Collection<Todo_Item> findByAssignee (int assignee_id);
    Collection<Todo_Item> findByAssignee (Person person);
    Collection<Todo_Item> findByUnassignedTodoItems();
    Todo_Item update (Todo_Item todo);
    boolean deleteById (int todo_id);

    // ADDED createUnassignedItem FUNCTION TO TEST findByUnassignedTodoItems.
    Todo_Item createUnassignedItem(Todo_Item todo);

}
