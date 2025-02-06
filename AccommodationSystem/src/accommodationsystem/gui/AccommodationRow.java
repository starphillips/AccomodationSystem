package accommodationsystem.gui;

// REPRESENTS A SINGLE ROW IN THE TABLE
import accommodationsystem.model.Accommodation;
import javafx.beans.property.SimpleStringProperty;

public class AccommodationRow
{
    private SimpleStringProperty accommodationNumber;
    private SimpleStringProperty accommodationType;
    private Accommodation accommodation;
    
    AccommodationRow(int accommodationNumber,
                     String accommodationType,
                     Accommodation accommodation)
    {
        this.accommodationNumber = new SimpleStringProperty(Integer.toString(accommodationNumber));
        this.accommodationType = new SimpleStringProperty(accommodationType);
    }

    public String getAccommodationNumber()
    {
        return accommodationNumber.get();
    }

    public String getAccommodationType()
    {
        return accommodationType.get();
    }
    
    public Accommodation getAccommodation()
    {
        return accommodation;
    }
}

