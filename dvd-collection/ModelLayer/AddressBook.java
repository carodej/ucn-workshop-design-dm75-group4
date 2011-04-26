package ModelLayer;

import java.util.HashMap;


/**
 * Write a description of class AddressBook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddressBook
{
    private static AddressBook instance = null;
    private HashMap<Integer, Person> persons;
    private static int nextId;

    /**
     * From container to Singleton
     */
    public static AddressBook getInstance()
    {
        if(instance == null)
        {
            instance = new AddressBook();
        }
        return instance;
    }
    
    /**
     * Constructor for objects of class AddressBook
     */
    private AddressBook()
    {
        persons = new HashMap<Integer, Person>();
        nextId = 0;
    }

    public int getNextId()
    {
        nextId++;
        return nextId;
    }
    
    /**
     * Add method, for adding a Person to the HashMap
     * 
     * @param   p   Person object
     */
    public void addPerson(Person p)
    {
        persons.put(getNextId(), p);
    }
    
    /**
     * Remove method, for removing a Person from the HashMap
     */
    public void removePerson(int id)
    {
        persons.remove(id);
    }
    
    /**
     * Search method, for finding a Person in the HashMap
     * 
     * @param   id  Instance variable for Person
     * @return  p   Person object
     */
    public Person findPerson(int id)
    {
        return persons.get(id);
//         boolean found = false;
//         int index = 0;
//         Person returnPerson = null;
//         while(index < persons.size() && !found)
//         {
//             if(persons.get(index).getId() == id)
//             {
//                 found = true;
//                 returnPerson = persons.get(index);
//             }
//             index++;
//         }
//         return returnPerson;
    }
    
    
    
}
