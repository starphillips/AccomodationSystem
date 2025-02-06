package accommodationsystem.gui;

import accommodationsystem.model.Accommodation;
import accommodationsystem.model.AccommodationSystem;
import accommodationsystem.model.Area;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 */
public class FXMLAccommodationSystemController implements Initializable
{

    @FXML
    private ChoiceBox<Area> cbArea;
    @FXML
    private TextField txtNumBreakfasts;
    @FXML
    private TextField txtAreaDescription;
    @FXML
    private TextField txtNumRequireCleaning;
    @FXML
    private TableView<AccommodationRow> tblAccommodations;

    // THE ATTRIBUTES BELOW ARE MANUALLY ADDED
    private ObservableList<Area> areaData = FXCollections.observableArrayList();
    
    private ObservableList<AccommodationRow> tableData = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        AccommodationSystem accommodationSystem = AccommodationSystem.getInstance();
        
        ArrayList<Area> zones = accommodationSystem.getAreas();
        
        for (int i = 0; i<zones.size(); i++)
        {
            areaData.add(zones.get(i));
        }
        
        // Associate the choice box data with the choice box
        cbArea.setItems(areaData);
        // Set the default entry to the first in the list
        cbArea.setValue(areaData.get(0));
       
        // Set on action does not exist in scene builder
        cbArea.setOnAction(this::cbAreaOnAction);
        
        tblAccommodations.setEditable(false);
        
        TableColumn accommNoCol = new TableColumn("Accomm No");
        accommNoCol.setMinWidth(50);
        
        TableColumn typeCol = new TableColumn("Accomm Type");
        typeCol.setMinWidth(100);
        
        tblAccommodations.getColumns().addAll(accommNoCol, typeCol);
        
        accommNoCol.setCellValueFactory(new PropertyValueFactory<AccommodationRow, String>("accommodationNumber"));
        typeCol.setCellValueFactory(new PropertyValueFactory<AccommodationRow, String>("accommodationType"));
       
        // tblRoomDetails.setSelectionModel(SelectionMode.SINGLE);
        tblAccommodations.setItems(tableData);       

    }
    
    private void cbAreaOnAction(ActionEvent event) 
    {
        // Retrieve the area instance selected
        Area area = cbArea.getValue();
        
        System.out.println("Area selected: " + area);   // DEBUG
        
        // Set the area description - retrieve from the area instance
        txtAreaDescription.setText(area.getDescription());
        
        // Display the area statistics for the selected area
        showAreaStatistics(area);
        
        // POPULATE THE TABLE WITH ACCOMMODATION FOR THE AREA
        populateTable(area);
    }
    
    private void populateTable(Area area) 
    {
        System.out.println("Populate Table Called");
        
        tableData.clear();
        
        ArrayList<Accommodation> accommodations = area.getAccommodations();

        for (Accommodation accommodation : accommodations) 
        {
            AccommodationRow accommodationRow = new AccommodationRow(accommodation.getAccommodationNumber(),
                                                                     accommodation.getAccommodationType(),
                                                                     accommodation);

            tableData.add(accommodationRow);
        }

        tblAccommodations.setItems(tableData);
    }

    private void showAreaStatistics(Area area)
    {
        // TODO: Implement these methods
        int numBreakfasts = area.getNumBreakfasts();
        int numRequireCleaning = area.getNumRequireCleaning();
        
        // Set the text fields to display the values
        txtNumBreakfasts.setText(Integer.toString(numBreakfasts));
        txtNumRequireCleaning.setText(Integer.toString(numRequireCleaning)); 
    }
}
