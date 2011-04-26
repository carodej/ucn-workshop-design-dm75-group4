package ModelLayer;


/**
 * Write a description of class Copy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Copy
{
    private String buyDate;
    private double buyPrice;

    /**
     * Constructor for objects of class Copy
     */
    public Copy(String buyDate, double buyPrice)
    {
        this.buyDate = buyDate;
        this.buyPrice = buyPrice;
    }

    /**
     * Get and set methods
     */
    public String getBuyDate()
    {
        return buyDate;
    }
    
    public double getBuyPrice()
    {
        return buyPrice;
    }
    
    public String print()
    {
        String returnString = buyDate + "\n" + Double.toString(buyPrice) + "\n";
        return returnString;
    }
}
