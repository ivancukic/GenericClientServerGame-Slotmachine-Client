/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUser;

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
public class FXMLDocumentController  {

    @FXML
    public TextField idUser;
    
    @FXML
    public TextField username;
    
    @FXML
    public PasswordField password;
    
    @FXML
    public Button onFirst;
    
    @FXML
    public Button onNext;
    
    @FXML
    public Button onPrevious;
    
    @FXML
    public Button onLast;
    
    @FXML
    public Button createDC;
    
    @FXML
    public Button changeDC;
    
    @FXML
    public Button deleteDC;
    
    public ControllerGUIUser cgui;
    
    
    
    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        
        cgui = new ControllerGUIUser(this);
    }    
    
}
