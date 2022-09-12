/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class FXMLDocumentController {
    
    @FXML
    public TextField username;
    
    @FXML
    public PasswordField password;
    
    @FXML
    public Button login;
    
    @FXML
    public Button createDC;
    
    @FXML
    public Button allUsers;
    
  
    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        
        ControllerGUILogin cgui = new ControllerGUILogin(this);
        
    }    
    
    public Stage stage;
    
    void makeStage(Stage stage) {
    
        this.stage = stage;
    }
    
    void closeForm() {
        
        stage.close();
    }
    
}
