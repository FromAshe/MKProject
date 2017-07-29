/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import java.text.DateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import mkproject.applicationBeanModule.Admin;
import mkproject.databaseTableModule.AdminManager;

/**
 *
 * @author Ashenafi
 */
public class UserAccountReminder implements EventHandler<ActionEvent> {

    TextField txtUserName, tFirstName, tFatherName, tUserName, tUserCode;
    PasswordField passwordField, pwordField;

    @Override
    public void handle(ActionEvent event) {
        Stage primaryStage;
        BorderPane mainBorderP = mkproject.UserInterfaceModule.Border.getBorderPaneInstance().setBorderProperty();
        primaryStage = ApplicationWindow.getApplicationWindowInstance();
        GridPane gridPane = GridPaneModule.getGridPane();

        
        
//        gridPane.setPadding(new Insets(20, 20, 20, 20));
//        gridPane.setHgap(5);
//        gridPane.setVgap(5);
        GridPane gridPaneN = GridPaneModule.getGridPane();
//        gridPaneN.setPadding(new Insets(20, 20, 20, 20));
//        gridPaneN.setHgap(5);
//        gridPaneN.setVgap(5);
        GridPane gridPaneN1 = GridPaneModule.getGridPane();
//        gridPaneN1.setPadding(new Insets(20, 20, 20, 20));
//        gridPaneN1.setHgap(5);
//        gridPaneN1.setVgap(5);

        Label lblUserName = new Label("የተጠቃሚ ስም");
        Font font = Font.font("Nyala", 20f);
        lblUserName.setFont(font);
        txtUserName = new TextField();
        txtUserName.setFont(font);
        Label lblPassword = new Label("የይለፍ ቃል");
        lblPassword.setFont(Font.font("Nyala", FontWeight.BLACK, 20));
        passwordField = new PasswordField();
        Button btnLogin = new Button("ግባ");
        btnLogin.setAlignment(Pos.BASELINE_RIGHT);
        btnLogin.setFont(Font.font("Nyala", FontWeight.BOLD, 30));
        Label emptySpace = new Label("               ");

        HBox loginHbox = new HBox();
        loginHbox.setSpacing(40);
        loginHbox.getChildren().addAll(emptySpace, btnLogin);
        final Label lblMessage = new Label();
        final Hyperlink rmbrMessage = new Hyperlink("የመጠቀሚያ ቃል አስታውስ");
        rmbrMessage.setTextFill(Color.BLUE);
        rmbrMessage.setUnderline(true);
        rmbrMessage.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Button btnCreatAccount = new Button("አዲስ የመጠቀሚያ አካውንት ክፈት");
        btnCreatAccount.setFont(Font.font("Nyala", FontWeight.BOLD, 14));
        btnCreatAccount.setAlignment(Pos.BASELINE_RIGHT);

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(20, 20, 20, 30));
        hbox2.setSpacing(20);
        Label date = new Label("ቀን");
        date.setFont(Font.font("Nyala", FontPosture.ITALIC, 20));
        date.setTextFill(Color.BLACK);
        Label tdate = new Label();
        tdate.setTooltip(new Tooltip("Date in Gregorian Calander"));
        tdate.setText(DateFormat.getInstance().format(new Date()));

        hbox2.getChildren().addAll(date, tdate);
        gridPane.add(hbox2, 0, 7);

        HBox hboxAccount = new HBox();
        hboxAccount.setSpacing(50);
        hboxAccount.setAlignment(Pos.BOTTOM_RIGHT);
        hboxAccount.setPadding(new Insets(10, 50, 50, 50));

        hboxAccount.getChildren().clear();
        gridPane.getChildren().clear();
////                gridPane.setId("root");
        gridPaneN.getChildren().clear();

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

        Button btnRem = new Button("አስታውስ");
        btnRem.setFont(Font.font("Nyala", FontWeight.BLACK, 18));

        HBox hAccount = new HBox();
        hAccount.setSpacing(50);
        hAccount.setAlignment(Pos.BOTTOM_RIGHT);
        hAccount.setPadding(new Insets(10, 50, 50, 50));
        hAccount.getChildren().addAll(btnRem);
        gridPaneN1.add(lFirstName, 0, 0);
        gridPaneN1.add(tFirstName, 1, 0);
        gridPaneN1.add(lFatherName, 0, 1);
        gridPaneN1.add(tFatherName, 1, 1);

        gridPaneN1.add(lUserCode, 0, 2);
        gridPaneN1.add(tUserCode, 1, 2);

        gridPaneN1.add(hAccount, 1, 3);

        mainBorderP.setCenter(gridPaneN1);
        btnRem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                Admin userAccount = AdminManager.getUserA();
                txtUserName.setText(userAccount.getUserName());
                passwordField.setText(userAccount.getPassword());
                gridPaneN.getChildren().clear();
//                        gridPane.setId("root");
                gridPaneN1.getChildren().clear();
                gridPane.add(lblUserName, 0, 0);
                gridPane.add(txtUserName, 1, 0);
                gridPane.add(lblPassword, 0, 1);
                gridPane.add(passwordField, 1, 1);
                gridPane.add(loginHbox, 1, 2);
                gridPane.add(lblMessage, 1, 3);
                gridPane.add(rmbrMessage, 1, 4);
                gridPane.add(hbox2, 0, 7);
                mainBorderP.setCenter(gridPane);
                mainBorderP.setBottom(hboxAccount);
            }
        });
        //

        //primaryStage.show();
    }
    

}
