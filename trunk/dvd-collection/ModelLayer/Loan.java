package ModelLayer;


/**
 * Write a description of class Loan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loan
{
    private String date;
    private String period;
    private String status;
    private Person person;
    private Copy copy;
    
    /**
     * Constructor for objects of class Loan
     */
    public Loan(String date, String period, String status, Person person, Copy copy)
    {
        this.date = date;
        this.period = period;
        this.status = status;
        this.person = person;
        this.copy = copy;
        
    }

    /**
     * Get and set methods
     */
    public String getDate()
    {
        return date;
    }
    
    public String getPeriod()
    {
        return period;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public Copy getCopy()
    {
        return copy;
    }
    
    public Person getPerson()
    {
        return person;
    }
    
    
}
