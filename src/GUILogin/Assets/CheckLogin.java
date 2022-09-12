/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin.Assets;

import DomainObject.GeneralDObject;
import DomainObject.User;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class CheckLogin extends GeneralUsageSO {
    
    String username;
    String password;
    Message m;
    
    public  boolean  checkLogin(String username, String password, Message m) {
    
        this.username = username;
        this.password = password;
        this.m = m;
        
        return generalUsageSO();
    }

    @Override
    public boolean executeSO() {
        
        User user = new User.Builder(username, password).build();
        
        List<GeneralDObject> l = bdb.findRecord(user, "WHERE username = '" + username + "' and password='" + password + "'" );
        
        if(l.size() > 0) {
        
            m.message = "user login"; 
            user = (User) l.get(0);
            m.idUser = user.getIdUser();
        }
        else {
            
            m.message = "User Is Not Logged!";
        }
        
        return true;
    }
    
    
}
