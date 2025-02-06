/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accommodationsystem.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TableViewExample extends Application 
{
    private TableView<Person> table = new TableView<>();
    
    @Override
    public void start(Stage stage) 
    {
        TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Person, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        table.getColumns().addAll(nameCol, ageCol);
        table.setItems(getPeople());
        
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            rowSelected(newSelection);
            // System.out.println("Selected Person: " + newSelection.getName() + ", Age: " + newSelection.getAge());
        }
        });
        

        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.setTitle("JavaFX TableView Example");
        stage.show();
    }
    
    private void rowSelected(Person newSelection)
    {
        System.out.println("Selected Person: " + newSelection.getName() + ", Age: " + newSelection.getAge());
    }

    private ObservableList<Person> getPeople() 
    {
        return FXCollections.observableArrayList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        );
    }

    public static class Person 
    {
        private final String name;
        private final int age;
        
        public Person(String name, int age) 
        {
            this.name = name;
            this.age = age;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
    }
    

    
    public static void main(String[] args) 
    {
        launch(args);
    }
}