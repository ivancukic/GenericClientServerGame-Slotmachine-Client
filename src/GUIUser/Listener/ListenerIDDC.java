/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUser.Listener;


import GUIUser.GeneralGUIController;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Ivan
 */
public class ListenerIDDC implements EventHandler {
    
    GeneralGUIController congui;
    
    public ListenerIDDC(GeneralGUIController congui) {
        
        this.congui = congui;
    }

    @Override
    public void handle(Event event) {
        
        congui.findDC();
    }
    
    
    
}