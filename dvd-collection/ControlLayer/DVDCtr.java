package ControlLayer;
import java.util.ArrayList;
import ModelLayer.*;
//model layer package has to be imported
/**
 * Controller class for the DVD collection
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * @revised version English (Ab)
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class DvdCtr
{
    private static DvdCtr instance = null;
    private DvdCollection dvdCollection; 

    public static DvdCtr getInstance()
    {
         if(instance == null)
         {
             instance = new DvdCtr();
         }
         return instance;
    }
    
    /**
     * Constructor for objects of class DVDCtr
     */
    private DvdCtr()
    {
        dvdCollection = dvdCollection.getInstance();   
    }
    
    //Dummy implementation: after implementing the model layer 
    //objects of class DVD are to be returned, not String
    public String getDvd(int id)
    {
        String returnString = "";
        if(dvdCollection.findDvd(id) != null)
        {
            returnString = dvdCollection.findDvd(id).print();
        }
        else
        {
            returnString = "No DVD found";
        }
        return returnString;
    }
    
    //Dummy implementation: more parameters are probaly to added
    public void createDvd(int id, String title, String director, String releaseDate)
    {       
          Dvd d = new Dvd(id, title, director, releaseDate);
          dvdCollection.addDvd(d);
    }
    
    public void deleteDVD(long id)
    {
        
        //search for the dvd and delete the object from the container
       
    }
    
    public String createCopy(int serialNo, String buyDate, double buyPrice, int id)
    {
        String returnString = "";
        Copy c = new Copy(serialNo, buyDate, buyPrice);
        if(dvdCollection.findDvd(id) != null)
        {
            dvdCollection.findDvd(id).addCopy(c);
            returnString = "Copy added successfully";
        }
        else
        {
            returnString = "DVD not found"; 
        }
        return returnString;
    }
    
    
    public String listAllDvds()
    {
          ArrayList<Dvd> dvdList = dvdCollection.getDvds();
          String returnString = "";
          for(Dvd d : dvdList)
          {
              returnString += d.print() + "\n";
          }
          return returnString;
    }
}