package TUILayer;
import java.util.Scanner;
import ControlLayer.DvdCtr;
import java.util.ArrayList;
/**
 * User interface to the DVD controller
 * @author(kbh)
 * @version(2005.03.31)
 * (FEN): 2006.02.24: Comments translated into English
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 * (KBH): 2008.10.24: dvdmenu changed to If                   
 */

public class DvdUI
{
    private DvdCtr dvdCtr;//DVD UI must know the DVD controller 
    
    public DvdUI()
    {
        dvdCtr = DvdCtr.getInstance();
    }
    
    public void start()
    {
        dvdMenu();
    }
    
    public void dvdMenu()
    {   
        boolean exit = false;
        while(!exit)
        {
            //show menu and return the user's choise
            int choise =   writeDvdMenu();
            if (choise == 1)
            {
                findDvd();
            }
            else{if(choise == 2){
                   createDvd();
                }
                else{
                    if(choise == 3){
                        createCopy();
                    }
                    else{
                        if(choise == 4){
                             deleteDVD();
                        }
                        else{
                            if(choise == 5){
                                listAllDvds();
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
    private int writeDvdMenu()
    {
           // creates an object keyboard to read data from the keyboard
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f *** DVD Menu ***");
            System.out.println(" (1) Show DVD information");
            System.out.println(" (2) Create DVD description");
            System.out.println(" (3) Create DVD copy");
            System.out.println(" (4) Delete DVD");
            System.out.println(" (5) Show current DVD list");
            System.out.println(" (6) Return");
            System.out.print("\n Make your choise: ");
            
            int choise = keyboard.nextInt();
            return choise;
    }
    
   private void returnToMenu()
   {
       Scanner keyboard = new Scanner(System.in);
       System.out.println(" (?) Return");
       System.out.print("\n Enter any number to return: ");
       keyboard.next();
   }
    
    private int inputDvdId()
    {
        // creates an object keyboard to read data from the keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type DVD id: ");
        int id = keyboard.nextInt();
        return id;
    }
        
    private String inputTitle()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type DVD title: " );
        String title = keyboard.nextLine();
        return title;
    }
    
    private String inputDirector()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type DVD director: ");
        String director = keyboard.nextLine();
        return director;
    }
    
    private String inputReleaseDate()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type DVD release date: ");
        String releaseDate = keyboard.nextLine();
        return releaseDate;
    }
    
    private int inputCopyNo()
    {
        // creates an object keyboard to read data from the keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the copy serial number: ");
        int serialNo = keyboard.nextInt();
        return serialNo;
    }
    
    private String inputBuyDate()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the copy aquisition date: ");
        String buyDate = keyboard.nextLine();
        return buyDate;
    }
    
    private double inputBuyPrice()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the copy aquisition price: ");
        double buyPrice = keyboard.nextDouble();
        return buyPrice;
    }
  
    private void findDvd()
    {     
        int id = inputDvdId();
        String dvd = dvdCtr.getDvd(id);
        System.out.println(dvd);
        returnToMenu();    
    }
    
    private void createDvd()
    {
        int id = inputDvdId();
        String title = inputTitle();
        String director = inputDirector();
        String releaseDate = inputReleaseDate();
        dvdCtr.createDvd(id, title, director, releaseDate);
    }
    
    private void createCopy()
    {
        int serialNo = inputCopyNo();
        String buyDate = inputBuyDate();
        double buyPrice = inputBuyPrice();
        int dvdId = inputDvdId();
        
        String result = dvdCtr.createCopy(serialNo, buyDate, buyPrice, dvdId);
        System.out.println(result);
        returnToMenu();
    }
    
    private void deleteDVD()
    {
    }
    private void listAllDvds()
    {
        System.out.println(dvdCtr.listAllDvds());
        returnToMenu();
    }
}