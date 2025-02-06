package accommodationsystem.model;

import java.util.ArrayList;


public class AccommodationSystem
{
    private ArrayList<Area> areas;
    
    private static AccommodationSystem instance = null;
 
    
    protected AccommodationSystem()
    {
        areas = new ArrayList<>();
    }
    
    // Uses SINGLETON PATTERN
    // We will learn more, in later sessions
    public static AccommodationSystem getInstance()
    {
        if (instance == null)
        {
            instance = new AccommodationSystem();
            
            // Create the default data for the system
            // Add the areas
            Hilltop hilltop = new Hilltop();
            Lakeview lakeview = new Lakeview();
            Meadow meadow = new Meadow();
            Woodland woodland = new Woodland();
            
            instance.addArea(hilltop);
            instance.addArea(lakeview);
            instance.addArea(meadow);
            instance.addArea(woodland);
            
            for (int cabinNo = 0; cabinNo<4; cabinNo++)
            {
                Accommodation cabin = new Accommodation(cabinNo+1, 
                                          "Cabin");
                hilltop.addAccommodation(cabin);
            }
            
            for (int geodesicDomeNo = 0; geodesicDomeNo<2; geodesicDomeNo++)
            {
                Accommodation geodesicDome = new Accommodation(geodesicDomeNo+1, 
                                                 "Geodesic Dome");
                woodland.addAccommodation(geodesicDome);
            }
            
            for (int yurtNo = 0; yurtNo<2; yurtNo++)
            {
                Accommodation yurt = new Accommodation(yurtNo+1, 
                                         "Yurt");
                meadow.addAccommodation(yurt);
                
            }

            for (int airstreamNo = 0; airstreamNo<4; airstreamNo++)
            {
                Accommodation airstream = new Accommodation(airstreamNo+1, 
                                              "Airstream");
                lakeview.addAccommodation(airstream);
            }             
        }
        
        return instance;
    }
    
    
    
    public void addArea(Area area)
    {
        areas.add(area);    
    }
    
    public ArrayList<Area> getAreas()
    {
        return areas;
    }
}

