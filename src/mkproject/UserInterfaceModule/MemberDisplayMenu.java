/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

/**
 *
 * @author Ashenafi
 */
public class MemberDisplayMenu extends RadioButton {

    private static MemberDisplayMenu displayInstanceMenu;

    private MemberDisplayMenu(String text) {
        super(text);
        
    }

    public static MemberDisplayMenu getDisplayInstanceMenu() {

        if (displayInstanceMenu == null) {
            displayInstanceMenu = new MemberDisplayMenu("የአባላት መረጃ ማግኛ");
            MenuGroup group = mkproject.UserInterfaceModule.MenuGroup.getContainerInstance();
        displayInstanceMenu.setToggleGroup(group);
        displayInstanceMenu.setTextFill(Color.BLACK);
        displayInstanceMenu.setFont(Font.font("Nyala", FontPosture.REGULAR, 20));

        }
        return displayInstanceMenu;
    }
}
