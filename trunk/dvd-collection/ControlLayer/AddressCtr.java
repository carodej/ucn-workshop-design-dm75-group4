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
    public String getPerson(int id)
    {
        return addressBook.findPerson(id).print();
    }
    
    
    public void createPerson(int id, String name, String address, int zip, String city, String phoneNumber)
    {   
        Person p = new Person(id, name, address, zip, city, phoneNumber);
        addressBook.addPerson(p);
    }
    
    public void deletePerson(int id)
    {
        Person p = addressBook.findPerson(id);
        if(p != null)
        {
            addressBook.removePerson(p);
        }
    }
    
    public void updatePerson(int id, String name, String address, int zip, String city, String phoneNumber)
    {
        if(addressBook.findPerson(id) != null)
        {
            if(name != null)
            {
                addressBook.findPerson(id).setName(name);
            }
            if(address != null)
            {
                addressBook.findPerson(id).setAddress(address);
            }
            if(zip != 0)
            {
                addressBook.findPerson(id).setZip(zip);
            }
            if(city != null)
            {
                addressBook.findPerson(id).setCity(city);
            }
            if(phoneNumber != null)
            {
                addressBook.findPerson(id).setPhoneNumber(phoneNumber);
            }
        }
    }
    
    public ArrayList listAllPersons()
    {
          return null;
    }
}
