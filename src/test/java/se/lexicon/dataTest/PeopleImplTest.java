package se.lexicon.dataTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.data.People_Impl;
import se.lexicon.model.Person;
public class PeopleImplTest {
    /*
    private Person[] testPeople1 = new Person[3];
    private Person testPeoplePerson1 = new Person();
    private Person testPeoplePerson2 = new Person();
    private Person testPeoplePerson3 = new Person();

    @Before
    public void setup (){
        //testPeoplePerson1.getPERSONID();
        testPeoplePerson1.setFirstName("Mikael");
        testPeoplePerson1.setLastName("Aurell");
        //testPeoplePerson2.getPERSONID();
        testPeoplePerson2.setFirstName("Ola");
        testPeoplePerson2.setLastName("Kula");
        //testPeoplePerson3.getPERSONID();
        testPeoplePerson3.setFirstName("Sebbe");
        testPeoplePerson3.setLastName("Picaso");
        testPeople1[0] = testPeoplePerson1;
        testPeople1[1] = testPeoplePerson2;
        testPeople1[2] = testPeoplePerson3;

    }
    @Test
    public void testAddPerson(){
        People_Impl testPeopleImpl = new People_Impl();
        testPeopleImpl.addPerson(testPeoplePerson1);
        testPeopleImpl.addPerson(testPeoplePerson2);
        Person[] expectedTestArray = testPeople1;
        Person[] actualTestArray = testPeopleImpl.findAll();
        Assert.assertEquals(expectedTestArray[0].getPERSONID(), actualTestArray[0].getPERSONID());
    }
    @Test
    public void testFindAll(){
        People_Impl testPeopleImpl = new People_Impl();
        testPeopleImpl.addPerson(testPeoplePerson1);
        testPeopleImpl.addPerson(testPeoplePerson2);
        Person[] expectedTestArray = testPeople1;
        Person[] actualTestArray = testPeopleImpl.findAll();
        Assert.assertArrayEquals(expectedTestArray, actualTestArray);
    }
    @Test
    public void testClear(){
        People_Impl testClear = new People_Impl();
        testClear.addPerson(testPeoplePerson1);
        testClear.addPerson(testPeoplePerson2);
        testClear.clear();
        Assert.assertNull(null,testClear.findAll());
    }
    @Test
    public void testRemove() {
        People_Impl testRemovePerson = new People_Impl();        //Index
        testRemovePerson.addPerson(testPeoplePerson1); //0 Micke
        testRemovePerson.addPerson(testPeoplePerson2); //1 Ola
        testRemovePerson.addPerson(testPeoplePerson3); //2 Sebbe
        System.out.println("testRemovePerson.size() = " + testRemovePerson.size());
        testRemovePerson.remove(2);
        System.out.println("testRemovePerson.size() = " + testRemovePerson.size());

        int expectedLength = 2;
        int actualLength = testRemovePerson.size();
        Assert.assertEquals(expectedLength, actualLength);

    }


     */
}