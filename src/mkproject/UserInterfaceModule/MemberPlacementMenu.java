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
public class MemberPlacementMenu extends RadioButton {

    private static MemberPlacementMenu memberPlacementInstance;

    private MemberPlacementMenu(String text) {
        super(text);
        
    }

    public static MemberPlacementMenu getMemeberPlacementInstance() {
        if (memberPlacementInstance == null) {
            memberPlacementInstance = new MemberPlacementMenu("አገልግሎት ክፍል መመደቢያ");
            MenuGroup group = mkproject.UserInterfaceModule.MenuGroup.getContainerInstance();
        memberPlacementInstance.setToggleGroup(group);
        memberPlacementInstance.setFont(Font.font("Nyala", FontPosture.REGULAR, 20));
        memberPlacementInstance.setTextFill(Color.BLACK);

        }

        return memberPlacementInstance;
    }
}
