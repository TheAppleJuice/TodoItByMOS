package se.lexicon.data;

import com.sun.tools.javac.comp.Todo;
import se.lexicon.model.Person;

import java.util.List;

public interface TodoItems {
    Todo create (Todo todo);
    List<Todo> findAll();
    Todo findById (int todo_id);
    List<Todo> findByDoneStatus (boolean done);
    List<Todo> findByAssignee (int assignee_id);
    List<Todo> findByAssignee (Person person);
    List<Todo> findByUnassignedTodoItems();
    Todo update (Todo todo);
    boolean deleteById (int todo_id);

}
