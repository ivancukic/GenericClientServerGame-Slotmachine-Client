/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUISignup;

import DomainObject.GeneralDObject;
import DomainObject.User;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Ivan
 */
public class ControllerGUISignup extends GeneralGUIController {

    public ControllerGUISignup(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        
        super(fxcon);
    }

    @Override
    void newDC() {
        
        gto.setDC(new User());
    }

    @Override
    GeneralDObject getNewDC() {
        
        return new User();
    }
    
    
    
}
