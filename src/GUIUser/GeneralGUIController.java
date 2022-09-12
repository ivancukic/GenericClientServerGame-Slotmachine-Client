/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUser;

import DomainObject.GeneralDObject;
import GUIUser.Listener.ListenerChangeDC;
import GUIUser.Listener.ListenerCreateDC;
import GUIUser.Listener.ListenerDeleteDC;
import GUIUser.Listener.ListenerIDDC;
import TransferObject.GenericTransferObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Ivan
 */
public abstract class GeneralGUIController {
    
    FXMLDocumentController fxcon;
    
    Socket socketC;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    GenericTransferObject gto;

    public GeneralGUIController(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException 
    {
        this.fxcon = fxcon;
        
        this.fxcon.createDC.setOnAction(new ListenerCreateDC(this));
        this.fxcon.changeDC.setOnAction(new ListenerChangeDC(this));
        this.fxcon.deleteDC.setOnAction(new ListenerDeleteDC(this));
        
        this.fxcon.onFirst.setOnAction(e -> onFirst());
        this.fxcon.onLast.setOnAction(e -> onLast());
        this.fxcon.onNext.setOnAction(e -> onNext());
        this.fxcon.onPrevious.setOnAction(e -> onPrevious());
        
        this.fxcon.idUser.setOnKeyReleased(new ListenerIDDC(this)); 
        
        socketC = new Socket("127.0.0.1",8189);
        
        gto = new GenericTransferObject();
        newDC();
        onFirst();
        
        for(Field f:this.fxcon.getClass().getFields()) {
            
            System.out.println("field name: " + f.getName() + " field type " + f.getType());
        }
    }
    
    public void message(String message) {
        
         Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        
        infoAlert.setTitle("Message:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }
    
    abstract void newDC();
    abstract  GeneralDObject getNewDC();
    
    public void createDC() {
               
        newDC();
        callSo(nameSOCreate());
        onLast();
        message(transferObjectMessage()); 
    }
    
    public void changeDC() {
        
        if(takeObjectFromForm()) {
        
            callSo(nameSOChange());
            message(transferObjectMessage()); 
        } 
        
    }
    
    public void deleteDC() { 
        
        if(takeObjectFromForm()) {
        
            callSo(nameSODelete());
            
            if(gto.getSignal()) {
                
                takeEmptyForm();
                onFirst();
            }
        }
        
        message(transferObjectMessage()); 
    }
   
    public void findDC() {
    
        if(takeObjectFromForm()) {
                
                 callSo(nameSOFind());
        
            if(gto.getSignal()) {
            
                takeFormFromObject(gto.getDC());
            }
            else {
            
                takeEmptyForm();
            }
        }
        
    }
    
    public LocalDate convertUtilDateInLocalDate(java.util.Date input) {
        
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(sm.format(input)); 
        LocalDate date = sqlDate.toLocalDate();
        
        return date;
    }
    
    public static java.sql.Date convertLocalDateInSqlDate(LocalDate input) {
        
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = java.sql.Date.valueOf(input); 
    
        return java.sql.Date.valueOf(sm.format(date));
    }
    
     void onFirst() {
        
        callSo("onFirst");
        
        if(gto.getSignal()) {
            
            takeFormFromObject(gto.getDC());
        }
    }
    
    void onNext() {
        
        callSo("onNext");
        
        if(gto.getSignal()) {
            
            takeFormFromObject(gto.getDC());
        }
    }
    
    void onPrevious() {
        
       callSo("onPrevious");
        
        if(gto.getSignal()) {
            
            takeFormFromObject(gto.getDC());
        }
    }
    
    void onLast() {
    
        callSo("onLast");
        
        if(gto.getSignal()) {
            
            takeFormFromObject(gto.getDC());
        }
    }
    
    public void callSo(String nameOfSO) {
        
        gto.setNameOfOperation(nameOfSO);
        try {
            
            out = new ObjectOutputStream(socketC.getOutputStream());
            in = new ObjectInputStream(socketC.getInputStream());
        }
        catch(IOException ex) {
           
            Logger.getLogger(GeneralGUIController.class.getName()).log(Level.SEVERE, null, ex); // GRESKA
        }
        
        try {
           
            out.writeObject(gto);
        }
        catch(IOException ex) {
            
             Logger.getLogger(GeneralGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
           
            gto = (GenericTransferObject) in.readObject();
        }
        catch (IOException | ClassNotFoundException ex) {
           
             Logger.getLogger(GeneralGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GenericTransferObject returnTransferObject() {
    
        return  gto;
    }
    
    String nameSOCreate() {
        
        return  "createDC";
    }
    
    String nameSOChange() {
        
        return  "changeDC";
    }
     
     String nameSODelete() {
        
        return  "deleteDC";
    }
     
     String nameSOFind() {
        
        return  "findDC";
    }
     
    String transferObjectMessage() {
        
        return gto.getMessage();
    } 
    
     public boolean takeFormFromObject(GeneralDObject gdo) {
        
        try {
            
            if(!ConverterGUIDC.convertDCInGUI(gdo, fxcon)) {
                
                return false;
            }
        }
        catch(NumberFormatException e) {
            
            message("The form can not be filled with object!!!");
        }
        
        return  true;
    }
    
   public boolean  takeObjectFromForm() {
       
       try {
           
           if(gto.getDC() == null) {
               
               newDC();
           }
           
           GeneralDObject gdo = gto.getDC();
           
           if(!ConverterGUIDC.convertGUIInDC(fxcon, gdo)) {
               
               onFirst();
               
               return false;
           }
       }
       catch(Exception e) {
           
           message("The fields of form are not input correctly!!!");
       }
       
       return true;
   }
   
   public void takeEmptyForm() { 
       
        for(Field f:fxcon.getClass().getDeclaredFields()) { 
         
          if (f.getType().getName().equals("javafx.scene.control.TextField") || f.getType().getName().equals("javafx.scene.control.PasswordField")) {
                
            try {

                   ((javafx.scene.control.TextField)f.get(fxcon)).setText("");
            } 
            catch (IllegalArgumentException | IllegalAccessException ex) {

                Logger.getLogger(GeneralGUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }      
      }
    }
    
}
