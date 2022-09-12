package GUILogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Ivan
 */
public class LoginClient extends Application {
    
    FXMLDocumentController con;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fXMLLoader = new FXMLLoader(location);
        Parent root = fXMLLoader.load();
        con = (FXMLDocumentController) fXMLLoader.getController();
        
        con.makeStage(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("SLOTMACHINE");
        stage.show();
        
       stage.setOnCloseRequest(((WindowEvent we) -> {
           
           System.out.println("Game Over!!!!");
       }));
    }
    
    
    public static void main(String[] args) {
        
        launch(args);
    }
    
    public FXMLDocumentController getController() {
        
        return con;
    } 
    
}
