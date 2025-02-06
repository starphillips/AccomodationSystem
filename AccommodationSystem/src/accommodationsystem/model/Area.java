
package accommodationsystem.model;

import java.util.ArrayList;

public abstract class Area
{
    public ArrayList<Accommodation> accommodations;
    
    public abstract String getName();
    public abstract String getDescription();
    
    Area()
    {
        accommodations = new ArrayList<Accommodation>();
    }
    
    public void addAccommodation(Accommodation accommodation)
    {
        accommodations.add(accommodation);
    }
    
    public ArrayList<Accommodation> getAccommodations()
    {
        return accommodations;
    }
    
    public int getNumBreakfasts()
    {
        // TODO: You will have to implement this method
        return 0;
    }
    
    public int getNumRequireCleaning()
    {
        // TODO: You will have to implement this method
        return 0;        
    }
    
    @Override
    public String toString() 
    {
        return getName();
    }
}
