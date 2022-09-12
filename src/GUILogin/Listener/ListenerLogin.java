/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin.Listener;

import GUILogin.ControllerGUILogin;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Ivan
 */
public class ListenerLogin implements EventHandler {
    
    ControllerGUILogin conl;
    
    public ListenerLogin(ControllerGUILogin conl) {
        
        this.conl = conl;
    }

    @Override
    public void handle(Event event) {
        
        conl.login();
    }
    
}
