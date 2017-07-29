/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.applicationModule;

import mkproject.databaseTableModule.AdminManager;
import mkproject.applicationBeanModule.Admin;

/**
 *
 * @author Ashenafi
 */
public class AccountApplication {

    String userName, password;
    

    public boolean checkUserNameAndPassword(String userName, String password) {

        Admin userAccount = AdminManager.getUserA();
        this.userName = userName;
        this.password = password;
        return this.userName.equals(userAccount.getUserName()) && this.password.equals(userAccount.getPassword());
    }
    
    public int accountUpdater(String tFirstName, String tFatherName, String tUserName, String tUserCode, String pwordField, int num){
         return new AdminManager().updateAccount(tFirstName, tFatherName, tUserName, tUserCode, pwordField, 1);
    }
}
