package ModelLayer;
import java.util.HashMap;

/**
 * Write a description of class DvdCollection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DvdCollection
{
    private HashMap<Integer, Dvd> dvds;
    private static DvdCollection instance = null;
    private static int nextId;

    public static DvdCollection getInstance()
    {
        if(instance == null)
        {
            instance = new DvdCollection();
        }
        return instance;
    }
    
    /**
     * Constructor for objects of class DvdCollection
     */
    private DvdCollection()
    {
        dvds = new HashMap<Integer, Dvd>();
        nextId = 0;
    }

    public int getNextId()
    {
        nextId++;
        return nextId;
    }
    
    /**
     * Add method, for adding a dvd to the HashMap
     * 
     * @param   d   Dvd object
     */
    public void addDvd(Dvd d)
    {
        dvds.put(getNextId(), d);
    }
    
    public void removeDvd(int id)
    {
        dvds.remove(id);
    }
    
//     public ArrayList<Dvd> getDvds()
//     {
//         ArrayList<Dvd> returnList = new ArrayList<Dvd>();
//         for(Dvd d : dvds)
//         {
//             returnList.add(d);
//         }
//         return returnList;
//     }
    
    public Dvd findDvd(int id)
    {
        return dvds.get(id);
//         boolean found = false;
//         int index = 0;
//         Dvd returnDvd = null;
//         while(index < dvds.size() && !found)
//         {
//             if(dvds.get(index).getId() == id)
//             {
//                 found = true;
//                 returnDvd = dvds.get(index);
//             }
//             index++;
//         }
//         return returnDvd;
    }
    
    
    
}
