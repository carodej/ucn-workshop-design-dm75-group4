package TUILayer;//makes this class a part of the TUILayer package
import java.util.Scanner;
import ControlLayer.*;//The TUILayer needs to know the ControlLayer
 

/**
 * User interface class to the AddressBook
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * (FEN): 2006.03.21: Comments translated into English
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class AddressBookUI
{   

    private AddressCtr addrCtr;//reference to the ControlLayer
    
    //constructor which does nothing
    public AddressBookUI()
    {
        addrCtr = AddressCtr.getInstance();
    }
    
    public void start()
    {
        addressMenu();
    }
    
    public void addressMenu()
    {
       boolean exit = false;
       while(!exit)//that is: while exit is false
       {
          int choise = writeAddressBookMenu(); 
          if(choise == 1)
          {   //show person
              
              getPerson();
          }
          else{
              if(choise == 2){
                    createPerson();
              }  
              else{
                  if(choise == 3){
                      deletePerson();
                  }  
                  else{
                      if(choise == 4){
                          // update person
                      }
                      else{
                          if(choise == 5){
                              // listAllPersons();
                            }
                          else{
                              exit = true;
                           }//end else
                        }//end else
                    }//end else
                }//end else
            }//end else
            
       }//end while
    }
    public int writeAddressBookMenu()
    {      // makes an object keyboard to read input from the screen
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f *** AddressBook Menu ***");
            System.out.println(" (1) Show information about person");
            System.out.println(" (2) Add person");
            System.out.println(" (3) Delete person");
            System.out.println(" (4) Update person");
            System.out.println(" (5) List all persons");
            System.out.println(" (6) Return");
            System.out.print("\n Make your choice: ");
            
            int choise = keyboard.nextInt();
            return choise;
        }
    
   private void returnToMenu()
   {
       Scanner keyboard = new Scanner(System.in);
       System.out.print("\n Press enter to return");
       keyboard.nextLine();
   }    
    //the method reads id for a person and return
    // 
    public int inputPersonsID()
    {   
        boolean ok = false;
        int id = 0;
        while(!ok)
        {
        // makes an object keyboard to have input from the console
           Scanner keyboard = new Scanner(System.in);
           System.out.println(" Write Id:  ");
           try{
             id = keyboard.nextInt();
             ok = true;
           }
           catch (Exception e)
            {
             System.out.println("Enter a number please...");
             String input = keyboard.nextLine();
           }
        }//end while
        return id;
    }
    
    public String inputName()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write Name:  ");
         String name = keyboard.nextLine();
         return name;
    }
   
    public int inputPostalCode()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write Postal Code:  ");
         int code = keyboard.nextInt();
         return code;
    }
    public String inputCity()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write City:  ");
         String city = keyboard.nextLine();
         return city;
    } 
    public String inputPhone()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write Phone Number:  ");
         String phone = keyboard.nextLine();
         return phone;
    } 
     
    public String  inputAddress()
    {
        // makes an object keyboard to read input from the console
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Write Address: ");
        String address = keyboard.nextLine();
        return address;
    }
    
//     public void showId(long id)
//     {
//         System.out.println("ID of the person: " + id);
//     }
//     public void showName(String name)
//     { 
//         System.out.println("The name of the persone: " + name);
//     }
//     public void showAddress(String address)
//     { 
//         System.out.println("The address of the person: " + address);
//     }

    private void getPerson()
    {
        int id = inputPersonsID();
        try
        {
            System.out.println("ID:            " + id);
            System.out.println("Name:          " + addrCtr.getName(id));
            System.out.println("Address:       " + addrCtr.getAddress(id));
            System.out.println("Postal Code:   " + addrCtr.getZip(id));
            System.out.println("City:          " + addrCtr.getCity(id));
            System.out.println("Phone Number:  " + addrCtr.getPhoneNumber(id));
        }
        catch(Exception e)
        {
            System.out.println("No person exist with the entered ID");
        }
        System.out.print("\n");
        returnToMenu();
        

    }
    
    private void createPerson()
    {
        String name = inputName();
        String address = inputAddress();
        int zip = inputPostalCode();
        String city = inputCity();
        String phoneNumber = inputPhone();
        addrCtr.createPerson(name, address, zip, city, phoneNumber);
    }
    
    private void deletePerson()
    {
        int id = inputPersonsID();
        try
        {
            addrCtr.getName(id);
            addrCtr.deletePerson(id);
            System.out.println("Person with ID " + id + " has been deleted");
        }
        catch(Exception e)
        {
            System.out.println("No person exist with the entered ID");
        }
        returnToMenu();
    }
}
            
        
