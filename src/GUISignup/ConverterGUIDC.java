/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUISignup;

import GUIUser.*;
import DomainObject.GeneralDObject;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class ConverterGUIDC {
    
    public static boolean convertGUIInDC(FXMLDocumentController fxcon, GeneralDObject gdo)
    {
        for(Field f:fxcon.getClass().getDeclaredFields()) 
       {   
           for(Field dc:gdo.getClass().getDeclaredFields()) 
               {  
                   if (dc.getName().equals(f.getName()))
                  {  
                      
                      if (f.getType().getName().equals("javafx.scene.control.TextField") && dc.getType().getName().equals("int"))
                       { 
                           try {  
                               
                               Integer number =  Integer.valueOf(((javafx.scene.control.TextField)f.get(fxcon)).getText());
                               dc.set(gdo, number); 
                           } 
                           catch (IllegalArgumentException | IllegalAccessException ex) 
                               {
                                   
                                   Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                                   
                                   return false;
                            }
                       }
                      
                     if (f.getType().getName().equals("javafx.scene.control.TextField") && dc.getType().getName().equals("java.lang.String"))
                       { 
                           try { 
                               
                               dc.set(gdo, ((javafx.scene.control.TextField)f.get(fxcon)).getText());
                           } 
                           catch (IllegalArgumentException | IllegalAccessException ex) 
                               { 
                                   
                                   Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                                   
                                   return false;
                           }
                       }
                     
                     if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dc.getType().getName().equals("java.lang.String"))
                       { 
                           try {  
                               
                               dc.set(gdo, ((javafx.scene.control.PasswordField)f.get(fxcon)).getText()); 
                             } 
                           catch (IllegalArgumentException | IllegalAccessException ex) 
                               { 
                                   
                                   Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                                   
                                   return false;
                           }
                       }
                   } 
              }
       } 
     return true;
    }
    
  public static boolean convertDCInGUI(GeneralDObject gdo, FXMLDocumentController fxcon) 
  {   
      for(Field f:fxcon.getClass().getDeclaredFields()) 
       {   
           for(Field dc:gdo.getClass().getDeclaredFields())
               {  
                   if (dc.getName().equals(f.getName()))
                  {  
                      if (f.getType().getName().equals("javafx.scene.control.TextField") && dc.getType().getName().equals("int"))
                       { 
                           try {  
                               Integer number = (Integer) dc.get(gdo); 
                               
                               ((javafx.scene.control.TextField)f.get(fxcon)).setText(String.valueOf(number));
                             } 
                           catch (IllegalArgumentException | IllegalAccessException ex) 
                               { 
                                   
                                   Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                                   
                                   return false;
                           }
                       }
                     if (f.getType().getName().equals("javafx.scene.control.TextField") && dc.getType().getName().equals("java.lang.String"))
                       { 
                           try {  
                               
                                ((javafx.scene.control.TextField)f.get(fxcon)).setText((String) dc.get(gdo));
                           } 
                           catch (IllegalArgumentException | IllegalAccessException ex) 
                               { 
                                   
                                   Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                                   
                                   return false;
                           }
                       }
                     if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dc.getType().getName().equals("java.lang.String"))
                       { 
                           try {
                               
                                ((javafx.scene.control.PasswordField)f.get(fxcon)).setText((String) dc.get(gdo));
                           } 
                           catch (IllegalArgumentException | IllegalAccessException ex) 
                               { 
                                   
                                   Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                                   
                                   return false;
                            }
                       }
                   } 
              }
       } 
     return true;
  }  
}
