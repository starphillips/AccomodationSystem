package accommodationsystem.model;

public class Accommodation
{
    private int accommodationNumber;
    private String accommodationType;
    
    // Constructor
    public Accommodation(int accommodationNumber, String accommodationType)
    {
        this.accommodationNumber = accommodationNumber;
        this.accommodationType = accommodationType;
    }
    
    public int getAccommodationNumber()
    {
        return accommodationNumber;
    }
    
    public String getAccommodationType()
    {
        return accommodationType;
    }
}
