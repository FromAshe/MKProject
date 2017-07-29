/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import mkproject.applicationModule.AccountApplication;

/**
 *
 * @author Ashenafi
 */
public class UserAccountInputHelper implements EventHandler<ActionEvent>{
    Stage stage = new Stage();
TextField txtUserName, tFirstName, tFatherName, tUserName, tUserCode;
    PasswordField passwordField, pwordField;
    @Override
    public void handle(ActionEvent event) {
         BorderPane mainBorderP = mkproject.UserInterfaceModule.Border.getBorderPaneInstance().setBorderProperty();
         
         Label lblUserName = new Label("የተጠቃሚ ስም");
        Font font = Font.font("Nyala", 20f);
        lblUserName.setFont(font);
        
        Label lblPassword = new Label("የይለፍ ቃል");
        lblPassword.setFont(Font.font("Nyala", FontWeight.BLACK, 20));
        
        Button btnLogin = new Button("ግባ");
        btnLogin.setAlignment(Pos.BASELINE_RIGHT);
        btnLogin.setFont(Font.font("Nyala", FontWeight.BOLD, 30));
        Label emptySpace = new Label("               ");
        
        HBox loginHbox = new HBox();
        loginHbox.setSpacing(40);
        loginHbox.getChildren().addAll(emptySpace, btnLogin);
        final Label lblMessage = new Label();
        
         HBox hboxAccount = HBoxModule.getHBox();
        Label emptySpace1 = new Label("                                       ");
        
        final Hyperlink rmbrMessage = new Hyperlink("የመጠቀሚያ ቃል አስታውስ");
        rmbrMessage.setTextFill(Color.BLUE);
        rmbrMessage.setUnderline(true);
        rmbrMessage.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        //hboxAccount.getChildren().addAll(emptySpace1, btnCreatAccount);

        //adding noeds to the main border
        GridPane gridPane = GridPaneModule.getGridPane();

        GridPane gridPaneN = GridPaneModule.getGridPane(); 
        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMaxHeight(70);
        hBox1.setPadding(new Insets(20, 20, 20, 20));
        
        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(20, 20, 20, 30));
        hbox2.setSpacing(20);
        mainBorderP.setTop(hBox1);
        mainBorderP.setCenter(gridPane);
        mainBorderP.setBottom(hboxAccount);
       
        //hboxAccount.getChildren().clear();
                gridPane.getChildren().clear();
//                gridPane.setId("root");
                Label lUserName = new Label("የመጠቀሚያ ስም");
                lUserName.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                tUserName = new TextField();
                tUserName.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                Label lFirstName = new Label("የመጀመሪያ ስም");
                lFirstName.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                tFirstName = new TextField();
                tFirstName.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                Label lFatherName = new Label("የአባት ስም");
                lFatherName.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                tFatherName = new TextField();
                tFatherName.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                Label lUserCode = new Label("ልዩ ኮድ");
                lUserCode.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                tUserCode = new TextField();
                tUserCode.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                Label lPassword = new Label("የይለፍ ቃል");
                lPassword.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                pwordField = new PasswordField();
                Label lvPassword = new Label("የይለፍ ቃል ማረጋገጫ");
                lvPassword.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                final PasswordField vpwordField = new PasswordField();
                Button btnOpen = new Button("ክፈት");
                btnOpen.setFont(Font.font("Nyala", FontWeight.BLACK, 18));
                Button btnFinish = new Button("ጨርስ");
                btnFinish.setFont(Font.font("Nyala", FontWeight.BLACK, 18));

                HBox hAccount = HBoxModule.getHBox();
//                hAccount.setSpacing(50);
//                hAccount.setAlignment(Pos.BOTTOM_RIGHT);
//                hAccount.setPadding(new Insets(10, 50, 50, 50));
                hAccount.getChildren().addAll(btnOpen, btnFinish);
                gridPaneN.add(lFirstName, 0, 0);
                gridPaneN.add(tFirstName, 1, 0);
                gridPaneN.add(lFatherName, 0, 1);
                gridPaneN.add(tFatherName, 1, 1);
                gridPaneN.add(lUserName, 0, 2);
                gridPaneN.add(tUserName, 1, 2);
                gridPaneN.add(lUserCode, 0, 3);
                gridPaneN.add(tUserCode, 1, 3);
                gridPaneN.add(lPassword, 0, 4);
                gridPaneN.add(pwordField, 1, 4);
                gridPaneN.add(lvPassword, 0, 5);
                gridPaneN.add(vpwordField, 1, 5);
                gridPaneN.add(hAccount, 1, 6);
                gridPaneN.add(hbox2, 0, 7);
                mainBorderP.setCenter(gridPaneN);
                btnOpen.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        //updateAccount();
                        if (new AccountApplication().accountUpdater(tFirstName.getText(), tFatherName.getText(), tUserName.getText(), tUserCode.getText(), pwordField.getText(), 1) == 1) {
            JOptionPane.showMessageDialog(null, "User Account has changed");
        } else {
            JOptionPane.showMessageDialog(null, "User Account has not been changed");
        }
                    }
                });
                btnFinish.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {


new MainUserInterface().start(stage);
                    }
                });
          
    }
    
}
