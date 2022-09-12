/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiSlotMachine;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class FXMLDocumentController {

    int length = 3;
    int width = 5;
    int spinValue = 0;
    
    
    @FXML
    ImageView imageField00;
    
    @FXML
    ImageView imageField01;
    
    @FXML
    ImageView imageField02;
    
    @FXML
    ImageView imageField03;
    
    @FXML
    ImageView imageField04;
    
    @FXML
    ImageView imageField10;
    
    @FXML
    ImageView imageField11;
    
    @FXML
    ImageView imageField12;
    
    @FXML
    ImageView imageField13;
    
    @FXML
    ImageView imageField14;
    
    @FXML
    ImageView imageField20;
    
    @FXML
    ImageView imageField21;
    
    @FXML
    ImageView imageField22;
    
    @FXML
    ImageView imageField23;
    
    @FXML
    ImageView imageField24;
    
    @FXML
    GridPane matrix;
    
    @FXML
    Button btnSpin;
    
    @FXML
    TextField textAmount;
    
    @FXML
    TextField textTotal;
    
    @FXML
    Label labelWonSpin;
    
    @FXML
    Label labelWonTotal;
    
    @FXML
    Label labelBetWarrning;
    
    
    
    
    @FXML
    public void initialize()  throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException  {
        
        ControllerGUISlotmachine cgui = new ControllerGUISlotmachine(this);
    }    
}
