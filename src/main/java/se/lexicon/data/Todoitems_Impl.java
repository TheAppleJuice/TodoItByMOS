package se.lexicon.data;


import se.lexicon.dao.database.MySqlConnection;
import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Todoitems_Impl implements TodoItems {
    @Override
    public Todo_Item create(Todo_Item todo) {
        String query = "insert into todo_item (title,description,deadline,done,assignee_id) value (?,?,?,?,?)";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ){
            preparedStatement.setString(1,todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setString(3, todo.getDeadline().toString());
            preparedStatement.setBoolean(4, todo.isDone());
            preparedStatement.setInt(5,todo.getAssignee_id());

            int resultSet = preparedStatement.executeUpdate();

            System.out.println((resultSet==1) ? "Todo item added to list" : "No todo item added to list");
            ResultSet resultSet1 = preparedStatement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return todo;
    }

    @Override
    public Collection<Todo_Item> findAll() {

        String query = "select * from todo_item";
        Collection<Todo_Item> todo_itemList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                todo_itemList.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return todo_itemList;


    }

    @Override
    public Todo_Item findById(int todo_id) {

        String query = "select * from todo_item where todo_id = ?";
        Todo_Item todoItem=new Todo_Item();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
                ){
            preparedStatement.setInt(1, todo_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                todoItem.setTodo_id(resultSet.getInt(1));
                todoItem.setTitle(resultSet.getString(2));
                todoItem.setDescription(resultSet.getString(3));
                todoItem.setDeadline(resultSet.getDate(4).toLocalDate());
                todoItem.setDone(resultSet.getBoolean(5));
                todoItem.setAssignee_id(resultSet.getInt(6));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return todoItem;
    }

    @Override
    public Collection<Todo_Item> findByDoneStatus(boolean done) {
        String query = "select * from todo_item where done = ?";
        Collection<Todo_Item> todo_itemList= new ArrayList<>();
        try(
                PreparedStatement preparedStatement=MySqlConnection.getConnection().prepareStatement(query);
                ){
            preparedStatement.setBoolean(1, done);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                todo_itemList.add(new Todo_Item(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDate(4).toLocalDate(),
                resultSet.getBoolean(5),
                resultSet.getInt(6)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return todo_itemList;
    }

    @Override
    public Collection<Todo_Item> findByAssignee(int assignee_id) {
        String query = "select * from todo_item where assignee_id = ?";
        Collection <Todo_Item> todo_itemList = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setInt(1, assignee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todo_itemList.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return todo_itemList;
    }

    @Override
    public Collection<Todo_Item> findByAssignee(Person person) {
        String query = "select * from todo_item where assignee_id =?";
            Collection <Todo_Item> todo_itemList = new ArrayList<>();
            try(
                PreparedStatement preparedStatement =MySqlConnection.getConnection().prepareStatement(query);
                ){
            preparedStatement.setInt(1, person.getPerson_Id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    todo_itemList.add(new Todo_Item(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4).toLocalDate(),
                            resultSet.getBoolean(5),
                            resultSet.getInt(6)
                    ));
                }
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            return todo_itemList;
    }

    @Override
    public Collection<Todo_Item> findByUnassignedTodoItems() {
        String query = "select * from todo_item where assignee_id = null ";
        Collection <Todo_Item> todo_itemList = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todo_itemList.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return todo_itemList;    }

    @Override
    public Todo_Item update(Todo_Item todo) {
        String query = "update todo_item set title=?, description=?, deadline=?, done=?, assignee_id=? where todo_id= ?";

        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
                ){
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setString(3,todo.getDeadline().toString());
            preparedStatement.setBoolean(4,todo.isDone());
            preparedStatement.setInt(5,todo.getAssignee_id());
            preparedStatement.setInt(6, todo.getTodo_id());


            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Todo item updated" : "Todo item not updated");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return todo;
    }

    @Override
    public boolean deleteById(int todo_id) {
        String query = "delete from todo_item where todo_id = ?";
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
                ){
            preparedStatement.setInt(1,todo_id);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Todo item deleted from list" : "Todo item not deleted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }




    /*
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

     */

}
