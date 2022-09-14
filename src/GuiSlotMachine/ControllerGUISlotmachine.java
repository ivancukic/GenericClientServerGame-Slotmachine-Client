/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiSlotMachine;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Ivan
 */
public class ControllerGUISlotmachine {
    
    FXMLDocumentController fxcon;
    
    
    public ControllerGUISlotmachine(FXMLDocumentController fxcon) {
        
        this.fxcon = fxcon;
        this.fxcon.labelWonSpin.setText(new Label(Integer.toString(this.fxcon.spinValue)).getText()); 
        this.fxcon.textTotal.setText(Integer.toString(0));
        
        this.fxcon.labelBetWarrning.setVisible(false);
        
        // SPIN BUTTON
        this.fxcon.btnSpin.setOnAction(e -> {
        
            try {
            
                getMatrix(this.fxcon.length, this.fxcon.width);
                whoIsWinner();
            }
            catch(NumberFormatException num) {
                
                this.fxcon.labelBetWarrning.setVisible(true);
            }
        });
        
    }
    
    public void message(String message) {
        
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        
        infoAlert.setTitle("Message:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }
    
    // OVAJ GENERATOR JE SAMO ZA TEXT POLJA, ZA SLIKE JE randNumberGeneratorImage()
    public void randNumberGenerator(int i, int j) {   
        
        TextField tField = null;
        String nameOfImageField = "textField" + i + j;
        
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        
        Class cls = fxcon.getClass(); 
        
        try { 
            
            Field field = cls.getDeclaredField(nameOfImageField);
            tField = (TextField) field.get(this.fxcon); 
        } 
        catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tField.setText("(" + rand1 + ")");
    }
    
    public void randNumberGeneratorImage(int i, int j) {   
        
        ImageView imgField = null;
        String nameOfImageField = "imageField" + i + j;
        
        Random rand = new Random();
        Integer rand1 = rand.nextInt(5);
        
        Class cls = fxcon.getClass(); 
        
        try { 
            
            Field field = cls.getDeclaredField(nameOfImageField);
            imgField = (ImageView) field.get(this.fxcon); 
        } 
        catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String path = "/images/" + rand1 + ".jpg";
        Image image = new Image(path);
        
        imgField.setImage(image);
        imgField.setId(rand1.toString()); // ZA UPOREDJIVANJE SLIKA
    }

    
    public  GridPane getMatrix(int length, int width) {
        
    
        for(int i = 0; i < length; i++){
            
                for(int j = 0; j < width; j++){

                        randNumberGeneratorImage(i, j);
                }
            }
        
        return this.fxcon.matrix;
    }
    
    public void whoIsWinner() {
        
        if(
              this.fxcon.imageField00.getId().equals(this.fxcon.imageField01.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField02.getId())
           && this.fxcon.imageField00.getId().equals(this.fxcon.imageField03.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField04.getId())
           && this.fxcon.imageField00.getId().equals(this.fxcon.imageField10.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField11.getId())
           && this.fxcon.imageField00.getId().equals(this.fxcon.imageField12.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField13.getId())
           && this.fxcon.imageField00.getId().equals(this.fxcon.imageField14.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField20.getId()) 
           && this.fxcon.imageField00.getId().equals(this.fxcon.imageField21.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField22.getId())
           && this.fxcon.imageField00.getId().equals(this.fxcon.imageField23.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField24.getId())
           ) 
        {
           
            jackPot();
            setTextTotal(this.fxcon.spinValue);
            calculateTotal(Integer.parseInt(this.fxcon.textTotal.getText()));
        }
        else if( // 0-1 
                (  this.fxcon.imageField00.getId().equals(this.fxcon.imageField01.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField02.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField03.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField04.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField10.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField11.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField12.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField13.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField14.getId()))
                || // 0-2
                (  this.fxcon.imageField00.getId().equals(this.fxcon.imageField01.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField02.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField03.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField04.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField20.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField21.getId()) 
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField22.getId())&& this.fxcon.imageField00.getId().equals(this.fxcon.imageField23.getId()) 
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField24.getId()))
                || // 1-2
                (  this.fxcon.imageField10.getId().equals(this.fxcon.imageField11.getId()) && this.fxcon.imageField10.getId().equals(this.fxcon.imageField12.getId())
                && this.fxcon.imageField10.getId().equals(this.fxcon.imageField13.getId()) && this.fxcon.imageField10.getId().equals(this.fxcon.imageField14.getId())
                && this.fxcon.imageField10.getId().equals(this.fxcon.imageField20.getId()) && this.fxcon.imageField10.getId().equals(this.fxcon.imageField21.getId()) 
                && this.fxcon.imageField10.getId().equals(this.fxcon.imageField22.getId())&& this.fxcon.imageField10.getId().equals(this.fxcon.imageField23.getId()) 
                && this.fxcon.imageField10.getId().equals(this.fxcon.imageField24.getId()))
                || // D1-D2
                (  this.fxcon.imageField00.getId().equals(this.fxcon.imageField11.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField12.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField13.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField24.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField04.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField13.getId()) 
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField12.getId())&& this.fxcon.imageField00.getId().equals(this.fxcon.imageField11.getId()) 
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField20.getId()))
                ) 
        {
        
            twoRows();
            setTextTotal(this.fxcon.spinValue);
            calculateTotal(Integer.parseInt(this.fxcon.textTotal.getText()));
            
        }
        else if ( // 0
                (  this.fxcon.imageField00.getId().equals(this.fxcon.imageField01.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField02.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField03.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField04.getId())) 
                || // 1
                (  this.fxcon.imageField10.getId().equals(this.fxcon.imageField11.getId()) && this.fxcon.imageField10.getId().equals(this.fxcon.imageField12.getId())
                && this.fxcon.imageField10.getId().equals(this.fxcon.imageField13.getId()) && this.fxcon.imageField10.getId().equals(this.fxcon.imageField14.getId()))
                || // 2
                (  this.fxcon.imageField20.getId().equals(this.fxcon.imageField21.getId()) && this.fxcon.imageField20.getId().equals(this.fxcon.imageField22.getId())
                && this.fxcon.imageField20.getId().equals(this.fxcon.imageField23.getId()) && this.fxcon.imageField20.getId().equals(this.fxcon.imageField24.getId()))
                || // D1
                (  this.fxcon.imageField00.getId().equals(this.fxcon.imageField11.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField12.getId())
                && this.fxcon.imageField00.getId().equals(this.fxcon.imageField13.getId()) && this.fxcon.imageField00.getId().equals(this.fxcon.imageField24.getId()))
                || // D2
                (  this.fxcon.imageField04.getId().equals(this.fxcon.imageField13.getId()) && this.fxcon.imageField04.getId().equals(this.fxcon.imageField12.getId())
                && this.fxcon.imageField04.getId().equals(this.fxcon.imageField11.getId()) && this.fxcon.imageField04.getId().equals(this.fxcon.imageField20.getId()))
                )
        {
        
            oneRow();
            setTextTotal(this.fxcon.spinValue);
            calculateTotal(Integer.parseInt(this.fxcon.textTotal.getText()));
        }
        else {
            
            // NO WIN
            calculateTotal(Integer.parseInt(this.fxcon.textTotal.getText()));
            this.fxcon.labelWonSpin.setText(new Label(Integer.toString(0)).getText());
        }
        
    }
    
    public void calculateTotal(Integer totalValue) {
    
        if(totalValue <= 0) {
            
            message("You don't have any more coins! Plese re-buy!");
        }
        else {
            
            this.fxcon.textTotal.setText(String.valueOf(Integer.parseInt(this.fxcon.textTotal.getText()) - Integer.parseInt(this.fxcon.textAmount.getText())));
            this.fxcon.labelWonSpin.setText(new Label(Integer.toString(this.fxcon.spinValue)).getText()); 
        }
        
    }
    
    public void setTextTotal(Integer spinValue) {
        
        this.fxcon.textTotal.setText(String.valueOf(Integer.parseInt(this.fxcon.textTotal.getText()) + spinValue));
    }
    
    public void jackPot() {
        
        this.fxcon.spinValue = Integer.parseInt(this.fxcon.textAmount.getText()) * 5;
        message("You got Jackpot!");
    }
    
    public void twoRows() {
        
         this.fxcon.spinValue = Integer.parseInt(this.fxcon.textAmount.getText()) * 3;
    }
    
    public void oneRow() {
    
         this.fxcon.spinValue = Integer.parseInt(this.fxcon.textAmount.getText()) * 2;
    }
    
}
