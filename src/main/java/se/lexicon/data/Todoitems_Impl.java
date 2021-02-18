package se.lexicon.data;


import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import static java.util.Arrays.*;

public class Todoitems_Impl {
    private static Todo_Item[] todoItemItemsArray = new Todo_Item[0];

    public int size() {
        return todoItemItemsArray.length;
    }

    public Todo_Item[] findAllThingsTodo() {
        return todoItemItemsArray;
    }

    public Todo_Item findByTodoId(int todo_Id) {
        Todo_Item findTodoItem = new Todo_Item();
        int tempTODOID = 0;
        for (int i = 0; i < todoItemItemsArray.length; i++) {
            tempTODOID = todoItemItemsArray[i].getTodo_id();
            if (tempTODOID == todo_Id) {
                findTodoItem = todoItemItemsArray[i];
            }
        }
        return findTodoItem;
    }

    public void addTodo(Todo_Item newThingTodoItem) {
        Todo_Item[] newtodoItemsArray = copyOf(todoItemItemsArray, todoItemItemsArray.length + 1);
        newtodoItemsArray[newtodoItemsArray.length - 1] = newThingTodoItem;
        todoItemItemsArray = newtodoItemsArray;
    }

    public void clear() {
        todoItemItemsArray = null;
    }

    public Todo_Item[] findByDoneStatus(boolean doneStatus) {
        int countDone = 0;
        int countUnDone = 0;
        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].isDone() == true) {
                countDone++;
            } else {
                countUnDone++;
            }
        }

        Todo_Item[] done = new Todo_Item[countDone];
        Todo_Item[] unDone = new Todo_Item[countUnDone];

        int j = 0;
        int k = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].isDone() == true) {
                if (countDone != 0) {
                    done[j] = todoItemItemsArray[i];
                    countDone--;
                    j++;
                }
            } else {
                if (countUnDone != 0) {
                    unDone[k] = todoItemItemsArray[i];
                    countUnDone--;
                    k++;
                }
            }
        }

        if (doneStatus == true) {
            return done;
        } else {
            return unDone;
        }
    }

    public Todo_Item[] findByAssignee(int personId) {
        int counter = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].getAssignee_id().getPerson_Id() == personId) {
                counter++;
            }
        }
            Todo_Item[] thingsIShouldDo = new Todo_Item[counter];
            int k = 0;
            for (int j = 0; j < todoItemItemsArray.length; j++) {
                if (todoItemItemsArray[j].getAssignee().getPerson_Id() == personId) {
                    thingsIShouldDo[k] = todoItemItemsArray[j];
                    k++;
                }
            }
        return thingsIShouldDo;
        }


    public Todo_Item[] findByAssignee2(Person assignee){
        int counter = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].getAssignee().getPerson_Id() == assignee.getPerson_Id()) {
                counter++;
            }
        }
        Todo_Item[] thingsIShouldDo = new Todo_Item[counter];
        int k = 0;
        for (int j = 0; j < todoItemItemsArray.length; j++) {
            if (todoItemItemsArray[j].getAssignee().getPerson_Id() == assignee.getPerson_Id()) {
                thingsIShouldDo[k] = todoItemItemsArray[j];
                k++;
            }
        }
        return thingsIShouldDo;
    }

    public Todo_Item[] findUnassignedTodoItems(){
        int counter = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].getAssignee() == null) {
                counter++;
            }
        }
        Todo_Item[] thingsIShouldDo = new Todo_Item[counter];
        int k = 0;
        for (int j = 0; j < todoItemItemsArray.length; j++) {
            if (todoItemItemsArray[j].getAssignee() == null) {
                thingsIShouldDo[k] = todoItemItemsArray[j];
                k++;
            }
        }
        return thingsIShouldDo;
    }

    public void removeTodo(int removePerson_Id){
        int index = -1;
        for(int i = 0; i < todoItemItemsArray.length; i++){
            if(todoItemItemsArray[i].getTODOID() == removePerson_Id){
                index = i;
                break;
            }
        }
        Todo_Item[] newArray = new Todo_Item[todoItemItemsArray.length - 1];

        for(int i = 0, k = 0; i < todoItemItemsArray.length; i++){
            if(i == index){
                continue;
            }
            newArray[k++] = todoItemItemsArray[i];
        }
        todoItemItemsArray = newArray;
    }

}
