/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin;

import DomainObject.GeneralDObject;
import DomainObject.User;
import GUILogin.Assets.CheckLogin;
import GUILogin.Assets.Message;
import GUILogin.Listener.ListenerLogin;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


/**
 *
 * @author Ivan
 */
public class ControllerGUILogin extends GeneralGUIController {
    
    public ControllerGUILogin(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException
    {
        super(fxcon);
        this.fxcon.login.setOnAction(new ListenerLogin(this));
        
        // ON SIGNIN PAGE
        this.fxcon.createDC.setOnAction(e -> {
            try {
                
                createDC();
                onSignupPage();
            } 
            catch (Exception ex) {
                Logger.getLogger(ControllerGUILogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // ALL USERS
        this.fxcon.allUsers.setOnAction(e -> {
        
            allUsers();
        });
        
      
    }

    @Override
    void newDC() {
        
        gto.setDC(new User());
    }

    @Override
    GeneralDObject getNewDC() {
        
        return new User();
    }
    
    // MOJE METODE
    public void onSignupPage() throws Exception {
    
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUISignup/FXMLDocument.fxml"));
            
            Parent newPage = (Parent) fxmlLoader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(newPage));
            stage.show();
        }
        catch (Exception e) {
        
            e.printStackTrace();
        }
    }
    
    public void message(String message) {
    
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Message:");
        infoAlert.setHeaderText(null); 
        infoAlert.setContentText(message); 
        infoAlert.showAndWait();  
    }
    
     public void login() {
    
        Message m = new Message();
        
        String username = fxcon.username.getText();
        String password = fxcon.password.getText();
        
        new CheckLogin().checkLogin(username, password, m);
        
        if(m.message.equals("user login")) {
        
            GuiSlotMachine.Slotmachine slotmachine;
            Stage s;
            
            slotmachine = new GuiSlotMachine.Slotmachine();
            s = new Stage();
            
            
            try {
                
                slotmachine.start(s);
                
                fxcon.closeForm();
            }
            catch (Exception ex) {
                
                Logger.getLogger(ControllerGUILogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            
            message("Wrong username or password!");
        }
    }
     
     public void allUsers() {
         
        GUIUser.UserClient userClient;
        Stage s;
            
        userClient = new GUIUser.UserClient();
        s = new Stage();
         
        try {
            
            
            userClient.start(s);
            
            fxcon.closeForm();
        } 
        catch (Exception ex) {
            
            Logger.getLogger(ControllerGUILogin.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
