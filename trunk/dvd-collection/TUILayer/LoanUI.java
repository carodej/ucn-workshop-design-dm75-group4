package TUILayer;
import java.util.Scanner;
import ControlLayer.LoanCtr;

/**
 * User interface to the Loan controller
 */
public class LoanUI
{
    private LoanCtr loanCtr;

    public LoanUI()
    {
        loanCtr = LoanCtr.getInstance();
    }

    public void start()
    {
        loanMenu();
    }
    
    public void loanMenu()
    {
        boolean exit = false;
        while(!exit)
        {
            int choice = writeLoanMenu();
            if(choice == 1)
            {
                findLoan();
            }
            else
            {
                if(choice == 2)
                {
                    createLoan();
                }
                else
                {
                    if(choice == 3)
                    {
                        
                    }
                    else
                    {
                        exit = true;
                    }
                }
            }
        }
    }
    
    private int writeLoanMenu()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\f *** Loan Menu ***");
        System.out.println(" (1) Show Loan information");
        System.out.println(" (2) Create Loan");
        System.out.println(" (3) Delete Loan");
        System.out.println(" (4) Return");
        System.out.println("\n Make your choice: ");
        
        int choice = keyboard.nextInt();
        return choice;
    }
    
    private void returnToMenu()
    {
       Scanner keyboard = new Scanner(System.in);
       System.out.print("\n Press enter to return");
       keyboard.nextLine();
    }
    
    private String inputDate()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type todays date: ");
        String date = keyboard.nextLine();
        return date;
    }
    
    private String inputPeriod()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type a loan period: ");
        String period = keyboard.nextLine();
        return period;
    }
    
    private String inputStatus()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type in the status of the loan: ");
        String status = keyboard.nextLine();
        return status;
    }
    
    public int inputPersonId()
    {   
        boolean ok = false;
        int id = 0;
        while(!ok)
        {
           Scanner keyboard = new Scanner(System.in);
           System.out.println(" Type person ID:  ");
           try{
             id = keyboard.nextInt();
             ok = true;
           }
           catch (Exception e)
            {
             System.out.println("Enter a number please...");
             String input = keyboard.nextLine();
           }
        }
        return id;
    }
    
    private int inputDvdId()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type DVD id: ");
        int id = keyboard.nextInt();
        return id;
    }
    
    private int inputSerialNo()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the copy serial number: ");
        int serialNo = keyboard.nextInt();
        return serialNo;
    }
    
    private int inputLoanId()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type in the loan ID: ");
        int loanId = keyboard.nextInt();
        return loanId;
    }
    
    private void findLoan()
    {
        int id = inputLoanId();
        try
        {
            System.out.println("Loan ID:  " + id);
            System.out.println("Date:     " + loanCtr.getDate(id));
            System.out.println("Period:   " + loanCtr.getPeriod(id));
            System.out.println("Status:   " + loanCtr.getStatus(id));
  //          System.out.println("Loaner:   " + loanCtr.)
        }
        catch(Exception e)
        {
            System.out.println("No Loan exist with the entered ID");
        }
        returnToMenu();
    }
    
    private void createLoan()
    {
        String date = inputDate();
        String period = inputPeriod();
        String status = inputStatus();
        int personId = inputPersonId();
        int dvdId = inputDvdId();
        int serialNo = inputSerialNo();
        try
        {
            loanCtr.createLoan(date, period, status, loanCtr.findLoanPerson(personId), loanCtr.findLoanCopy(dvdId, serialNo));
            System.out.println("Loan registered");
        }
        catch(Exception e)
        {
            System.out.println("The entered information does not compute");
        }
        returnToMenu();
    }
}
