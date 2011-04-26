package ModelLayer;
import java.util.HashMap;


/**
 * Write a description of class Dvd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dvd
{
    private String title;
    private String director;
    private String releaseDate;
    private HashMap<Integer, Copy> copies;
    private static int nextSerialNo;

    /**
     * Constructor for objects of class Dvd
     */
    public Dvd(String title, String director, String releaseDate)
    {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        copies = new HashMap<Integer, Copy>();
        nextSerialNo = 0;
    }

    /**
     * Get and set methods
     */
    public int getNextSerialNo()
    {
        nextSerialNo++;
        return nextSerialNo;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setDirector(String director)
    {
        this.director = director;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }
    
    public String getReleaseDate()
    {
        return releaseDate;
    }
    
    /**
     * Add method, for adding a copy to the HashMap
     */
    public void addCopy(Copy c)
    {
        copies.put(getNextSerialNo(), c);
    }
    
    public void removeCopy(int serialNo)
    {
        copies.remove(serialNo);
    }
    
    public Copy findCopy(int serialNo)
    {
        return copies.get(serialNo);
//         boolean found = false;
//         int index = 0;
//         Copy returnCopy = null;
//         while(index < copies.size() && !found)
//         {
//             if(copies.get(index).getSerialNo() == serialNo)
//             {
//                 found = true;
//                 returnCopy = copies.get(index);
//             }
//             index++;
//         }
//         return returnCopy;
    }
    
    public int numberOfCopies()
    {
        return copies.size();
    }
    
//     public String print()
//     {
//         
//         String returnString = title + "\n" + director + "\n" + releaseDate + "\n";
//         for(Copy c : copies)
//         {
//             returnString += c.print();
//         }
//         return returnString;
//     }
}
