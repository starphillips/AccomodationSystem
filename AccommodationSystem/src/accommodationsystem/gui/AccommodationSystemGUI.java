package accommodationsystem.gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccommodationSystemGUI extends Application
{
    @Override
    public void start(Stage primaryStage)
            throws IOException
    {   
        // Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAccommodationSystem.fxml"));
        
        //Scene scene = new Scene(button, 200, 100);
        primaryStage.setTitle("Cedar Woods Accommodation System");
        Scene cedarWoodsAccommodationSystemScene = new Scene(loader.load());
        
        primaryStage.setScene(cedarWoodsAccommodationSystemScene);
        primaryStage.show(); 

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
