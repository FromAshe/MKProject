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
public class CommentMenu extends RadioButton {

    private static CommentMenu commentMenuInstance;

    private CommentMenu(String text) {
        super(text);
        
    }

    public static CommentMenu getCommentMenuInstance() {

        if (commentMenuInstance == null) {
            commentMenuInstance = new CommentMenu("ማስታወሻ ለመመዝገብ");
            MenuGroup group = mkproject.UserInterfaceModule.MenuGroup.getContainerInstance();

        commentMenuInstance.setToggleGroup(group);
        commentMenuInstance.setTextFill(Color.BLACK);
        commentMenuInstance.setFont(Font.font("Nyala", FontPosture.REGULAR, 20));

        }
        return commentMenuInstance;
    }
}
