/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUser;

import DomainObject.GeneralDObject;
import DomainObject.User;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Ivan
 */
public class ControllerGUIUser extends GeneralGUIController {
    
    public ControllerGUIUser(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException
    {
        super(fxcon);
    }

    @Override
    public void newDC() {
        
        gto.setDC(new User());
    }

    @Override
    public GeneralDObject getNewDC() {
        
        return new User();
    }
    
    
    
}
