package ControlLayer;

import java.util.ArrayList;
import ModelLayer.*;

/**
 * Controller class for the address book
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class AddressCtr
{
    
    private static AddressCtr instance = null;
    private AddressBook addressBook;
    
     /**
      * Singleton
      */
     public static AddressCtr getInstance()
     {
         if(instance == null)
         {
             instance = new AddressCtr();
         }
         return instance;
     }
    
    /**
     * Constructor for creating AddressCtr
     */
    private AddressCtr()
    {
        addressBook = addressBook.getInstance();
    }
    
    /**
     * Method for printing out information about a Person
     * 
     * @param   id  Instance variable for Person object
     * @return  p   Person object
     */
    public Person getPerson(int id)
    {
        return addressBook.findPerson(id);
    }
    
    public String getName(int id)
    {
        return getPerson(id).getName();
    }
    
    public String getAddress(int id)
    {
        return getPerson(id).getAddress();
    }
    
    public int getZip(int id)
    {
        return getPerson(id).getZip();
    }
    
    public String getCity(int id)
    {
        return getPerson(id).getCity();
    }
    
    public String getPhoneNumber(int id)
    {
        return getPerson(id).getPhoneNumber();
    }
    
    public void createPerson(String name, String address, int zip, String city, String phoneNumber)
    {   
        Person p = new Person(name, address, zip, city, phoneNumber);
        addressBook.addPerson(p);
    }
    
    public void deletePerson(int id)
    {
        addressBook.removePerson(id);
    }
    
    public void updatePerson(int id, String name, String address, int zip, String city, String phoneNumber)
    {
        if(getPerson(id) != null)
        {
            if(name != null)
            {
                getPerson(id).setName(name);
            }
            if(address != null)
            {
                getPerson(id).setAddress(address);
            }
            if(zip != 0)
            {
                getPerson(id).setZip(zip);
            }
            if(city != null)
            {
                getPerson(id).setCity(city);
            }
            if(phoneNumber != null)
            {
                getPerson(id).setPhoneNumber(phoneNumber);
            }
        }
    }
    
    public ArrayList listAllPersons()
    {
          return null;
    }
}
