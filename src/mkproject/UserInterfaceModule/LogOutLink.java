/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.scene.control.Hyperlink;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

/**
 *
 * @author Ashenafi
 */
public class LogOutLink extends Hyperlink {

    private static LogOutLink logOutHyperlink;

    private LogOutLink(String txt) {
        super(txt);
       
    }

    public static LogOutLink getLogOutLinkInstance() {
        if (logOutHyperlink == null) {
            logOutHyperlink = new LogOutLink("ውጣ");
             logOutHyperlink.setFont(Font.font("Nyala", FontPosture.REGULAR, 20));
        logOutHyperlink.setTextFill(Color.BLUE);
            
        }

        return logOutHyperlink;
    }
}
