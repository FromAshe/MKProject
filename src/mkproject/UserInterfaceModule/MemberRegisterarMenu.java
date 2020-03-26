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
public class MemberRegisterarMenu extends RadioButton {

    private static MemberRegisterarMenu instance;

    private MemberRegisterarMenu(String text) {
        super(text);
       
    }

    public static MemberRegisterarMenu getMeberRegisterarMenu() {
        if (instance == null) {
            instance = new MemberRegisterarMenu("የአባልነት ቅፅ መሙያ");
             MenuGroup group = mkproject.UserInterfaceModule.MenuGroup.getContainerInstance();
        instance.setToggleGroup(group);
        instance.setFont(Font.font("Nyala", FontPosture.REGULAR, 20));
        instance.setTextFill(Color.BLACK);

        }

        return instance;
    }

}
