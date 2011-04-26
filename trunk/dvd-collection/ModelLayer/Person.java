package ModelLayer;


/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private String address;
    private int zip;
    private String city;
    private String phoneNumber;

    /**
     * Constructor for objects of class Person
     */
    public Person(String name, String address, int zip, String city, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    /**
     *  Get and set methods
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setZip(int zip)
    {
        this.zip = zip;
    }
    
    public int getZip()
    {
        return zip;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
}
