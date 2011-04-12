package TUILayer;//makes this class a part of the TUILayer package
import java.util.Scanner;
import ControlLayer.*;//The TUILayer needs to know the ControlLayer
/**
 * 
 * User interface - main menu
 * The entry-point for the application:
 * Create an instance of class MainMenuUI and the constructor starts the application
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * (FEN): 2006.02.24: Comments translated into English
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 *                    
 * (KBH): 2008.10.24: Change af manimenuStart to if
 */
public class MainMenuUI
{
  //the reference to the ControlLayer
   private AddressBookUI adrUI;//references to other UI objects
   private DvdUI dvdUI;
   
   public MainMenuUI()
   {
  
      
   }
   
   public void mainMenuStart()
   {
        boolean exit=false;
        while (!exit) //! means while exit not is true (that is: false)
        {
            int choise = writeMainMenu();
            if(choise == 1)
            {
                startAddressBook();
            }
            else{
                    if(choise == 2){ 
                        startDvd();
                    }
                    else{
                        if(choise == 3){
                        //start loanController 
                            }//end if
                        else{
                            writeEnd();
                            exit = true;
                        }//end else
                    }// end else
             }//end else
        }//end while
    }//end start
    
   private int writeMainMenu()
    {       
            // creates a keyboard object to read input
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f *** MainMenu ***");
            System.out.println(" (1) AddressBook");
            System.out.println(" (2) DVDs");
            System.out.println(" (3) Loan");
            System.out.println(" (4) Close");
            System.out.print("\n Make your choise: ");
            
            int choise = keyboard.nextInt();
            
            return choise;
    }
    
    private void startAddressBook()
    {
        adrUI= new AddressBookUI();
        adrUI.start();
        //the adrUI needs to have a reference to the address controller
        //main controller can return references to the other controllers
     
    }

    private void startDvd()
    {
        dvdUI= new DvdUI();
        dvdUI.start();
        //the DvdUI needs to have a reference to the DVD controller
        //main controller can return references to the other controllers
     
    }
    private void writeEnd()
    {
        System.out.println(" The System is shuting down ");
    }
 }
