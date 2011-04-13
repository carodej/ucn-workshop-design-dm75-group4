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
    
    /**
     * Get methods regarding DVD
     */
    public Dvd getDvd(int id)
    {
        return dvdCollection.findDvd(id);
    }
   
    public String getTitle(int id)
    {
        return getDvd(id).getTitle();
    }
    
    public String getDirector(int id)
    {
        return getDvd(id).getDirector();
    }
    
    public String getReleaseDate(int id)
    {
        return getDvd(id).getReleaseDate();
    }
    
    /**
     * Get methods regarding Copy
     */
    public Copy getCopy(int id, int serialNo)
    {
        return getDvd(id).findCopy(serialNo);
    }
    
    public String getBuyDate(int id, int serialNo)
    {
        return getCopy(id, serialNo).getBuyDate();
    }
    
    public double getBuyPrice(int id, int serialNo)
    {
        return getCopy(id, serialNo).getBuyPrice();
    }
    
    //Dummy implementation: more parameters are probaly to added
    public void createDvd(String title, String director, String releaseDate)
    {       
        Dvd d = new Dvd(title, director, releaseDate);
        dvdCollection.addDvd(d);
    }
    
    public void deleteDvd(int id)
    {
        dvdCollection.removeDvd(id);
    }
    
    public void createCopy(String buyDate, double buyPrice, int id)
    {
        Copy c = new Copy(buyDate, buyPrice);
        if(dvdCollection.findDvd(id) != null)
        {
            dvdCollection.findDvd(id).addCopy(c);
        }
    }
    
    public int numberOfCopies(int id)
    {
        return dvdCollection.findDvd(id).numberOfCopies();
    }
    
    
//     public String listAllDvds()
//     {
//           ArrayList<Dvd> dvdList = dvdCollection.getDvds();
//           String returnString = "";
//           for(Dvd d : dvdList)
//           {
//               returnString += d.print() + "\n";
//           }
//           return returnString;
//     }
}
