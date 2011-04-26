package ModelLayer;

import java.util.HashMap;


/**
 * Write a description of class LoanCollection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoanCollection
{
    private static LoanCollection instance = null;
    private HashMap<Integer, Loan> loans;
    private static int nextId;

    public static LoanCollection getInstance()
    {
        if(instance == null)
        {
            instance = new LoanCollection();
        }
        return instance;
    }
    
    /**
     * Constructor for objects of class LoanCollection
     */
    private LoanCollection()
    {
        loans = new HashMap<Integer, Loan>();
        nextId = 0;
    }
    
    public int getNextId()
    {
        nextId++;
        return nextId;
    }

    /**
     * Method for adding a Loan to the HashMap
     */
    public void addLoan(Loan loan)
    {
        loans.put(getNextId(), loan);
    }
    
    public Loan findLoan(int id)
    {
        return loans.get(id);
    }
    
    public void removeLoan(int id)
    {
        loans.remove(id);
    }
}
