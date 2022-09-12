/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUISignup;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class FXMLDocumentController {

    @FXML
    public TextField idUser;
    
    @FXML
    public TextField username;
    
    @FXML
    public PasswordField password;
    
    @FXML
    public Button changeDC;
    
    public ControllerGUISignup cgui;
    
    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        
        cgui = new ControllerGUISignup(this);
    }    
    
}
