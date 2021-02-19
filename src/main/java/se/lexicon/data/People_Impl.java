package se.lexicon.data;
import se.lexicon.dao.database.MySqlConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class People_Impl implements People {
    @Override
    public Person create(Person person) {
        String query = "insert into person (first_name, last_name) values (?,?)";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, person.getFirst_Name());
            preparedStatement.setString(2, person.getLast_Name());


            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "New person added to database" : "Person not added");
            ResultSet rs= preparedStatement.getGeneratedKeys();
            int idKey = 0;
            while (rs.next()) {
                idKey= rs.getInt(1);
            }

            person.setPerson_Id(idKey);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;

    }

    @Override
    public Collection<Person> findAll() {
        String query = "select * from person";
        Collection<Person> personList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                personList.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person findById(int person_id) {
        String query = "select * from person where person_id=?";
        Person person = new Person();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, person_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                person.setPerson_Id(resultSet.getInt("person_id"));
                person.setFirst_Name(resultSet.getString("first_name"));
                person.setLast_Name(resultSet.getString("last_name"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Collection<Person> findByName(String name) {
        String query = "select * from person where first_name=?";
        Collection <Person> personList = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personList.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person update(Person person) {
        String query = "update person set first_name=?, last_name=? where person_id= ?";

        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setString(1, person.getFirst_Name());
            preparedStatement.setString(2, person.getLast_Name());
            preparedStatement.setInt(3, person.getPerson_Id());


            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Person updated to database" : "Person not updated");
            // get generated key from prepared statement


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;    }

    @Override
    public boolean deleteById(int person_id) {
        String query = "delete from person where person_id= ?";
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){

            preparedStatement.setInt(1, person_id);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Person deleted from database" : "Person not deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return true;
    }


    /*
    private static Person[] peopleArray = new Person[0];
    public int size() {

        return peopleArray.length;
    }

    public Person[] findAll() {
        return peopleArray;
    }

    public Person findById(int person_Id) {
        Person findPerson = new Person();
        int tempPERSONID = 0;
        for (int i = 0; i < peopleArray.length; i++) {
            tempPERSONID = peopleArray[i].getPERSONID();
            if (tempPERSONID == person_Id) {
                findPerson = peopleArray[i];
            }
        }
        return findPerson;
    }

    public void addPerson(Person newPerson) {
        Person[] newPeopleArray = Arrays.copyOf(peopleArray, peopleArray.length + 1);
        newPeopleArray[newPeopleArray.length - 1] = newPerson;
        peopleArray = newPeopleArray;
    }

    public void remove(int removePerson_Id){
        int index = -1;
        for(int i = 0; i < peopleArray.length; i++){
            if(peopleArray[i].getPERSONID() == removePerson_Id){
                index = i;
                break;
            }
        }
        Person[] newArray = new Person[peopleArray.length - 1];

        for(int i = 0, k = 0; i < peopleArray.length; i++){
            if(i == index){
                continue;
            }
            newArray[k++] = peopleArray[i];
        }
        peopleArray = newArray;
    }


    public void clear (){
        peopleArray = null;
    }

     */
}