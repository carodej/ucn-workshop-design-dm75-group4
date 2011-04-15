package ControlLayer;
import ModelLayer.*;


/**
 * Write a description of class LoanCtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoanCtr
{
    private static LoanCtr instance = null;
    private DvdCollection dvdCollection;
    private AddressBook addressBook;
    private LoanCollection loanCollection;

    public static LoanCtr getInstance()
    {
        if(instance == null)
         {
             instance = new LoanCtr();
         }
         return instance;
    }
    
    /**
     * Constructor for objects of class LoanCtr
     */
    private LoanCtr()
    {
        dvdCollection = dvdCollection.getInstance();
        addressBook = addressBook.getInstance();
        loanCollection = loanCollection.getInstance();
    }

    /**
     * Get and set Methods
     */
    public Loan getLoan(int id)
    {
        return loanCollection.findLoan(id);
    }
    
    public String getDate(int id)
    {
        return getLoan(id).getDate();
    }
    
    public String getPeriod(int id)
    {
       return getLoan(id).getPeriod();
    }
    
    public String getStatus(int id)
    {
        return getLoan(id).getStatus();
    }
    
    public String getPersonName(int id)
    {
        return getLoan(id).getPerson().getName();
    }
    
    /**
     * Method for creating a Loan
     */
    public void createLoan(String date, String period, String status, Person person, Copy copy)
    {   
        Loan l = new Loan(date, period, status, person, copy);
        loanCollection.addLoan(l);
    }
    
    public Person findLoanPerson(int personId)
    {
        return addressBook.findPerson(personId);
    }
    
    public Copy findLoanCopy(int dvdId, int serialNo)
    {
        return dvdCollection.findDvd(dvdId).findCopy(serialNo);
    }
    
    /**
     * Method for deleting a Loan
     */
    public void deleteLoan(int id)
    {
        loanCollection.removeLoan(id);
    }
    
    
}
