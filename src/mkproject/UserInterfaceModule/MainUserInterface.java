/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.DateFormat;
import java.util.Locale;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mkproject.applicationModule.AccountApplication;
import mkproject.resources.ResourceLoader;
import mkproject.WorkinigInterface;

/**
 *
 * @author Emu
 */
public class MainUserInterface extends Application {

    TextField txtUserName, tFirstName, tFatherName, tUserName, tUserCode;
    PasswordField passwordField, pwordField;

    public static void main(String[] args) {
        ResourceLoader.loadFonts();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage = ApplicationWindow.getApplicationWindowInstance().setStageProperty();
        userAccountUI();
        primaryStage.show();
    }

    private void userAccountUI() {
        BorderPane mainBorderP = mkproject.UserInterfaceModule.Border.getBorderPaneInstance().setBorderProperty();
        mainBorderP.maxWidth(600);
        mainBorderP.maxHeight(400);

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMaxHeight(70);
        hBox1.setPadding(new Insets(20, 20, 20, 20));

        System.out.println(hBox1.getHeight());

        //grid panes
        GridPane gridPane = GridPaneModule.getGridPane();

        //GridPane gridPaneN = GridPaneModule.getGridPane();
        //ImageIcon image = new ImageIcon();

        //Implementing Nodes for GridPane
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

        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginHbox, 1, 2);
        gridPane.add(lblMessage, 1, 3);
        gridPane.add(rmbrMessage, 1, 4);

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

        Text text = new Text("ሚስጥራዊ መረጃን ያስገቡ");
        text.setFont(Font.font("Nyala", FontWeight.EXTRA_BOLD, 30));

        //Adding text to HBox
        //hBox1.setMinSize(600, 40);
        hBox1.getChildren().add(text);

        //Add ID's to Nodes
        //mainBorderP.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");
        hBox1.setId("hBox");

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (new AccountApplication().checkUserNameAndPassword(txtUserName.getText(), passwordField.getText())) {
                    //primaryStage.close();
                    new WorkinigInterface().startt();
                } else {
                    lblMessage.setText("Incorrect User Account");
                    lblMessage.setTextFill(Color.RED);
                }
                txtUserName.setText("");
                passwordField.setText("");
            }
        });

        //Add HBox and GridPane layout to BorderPane Layout
        HBox hboxAccount = HBoxModule.getHBox();
        Label emptySpace1 = new Label("                                       ");
        hboxAccount.getChildren().addAll(emptySpace1, btnCreatAccount);

        //adding noeds to the main border
        mainBorderP.setTop(hBox1);
        mainBorderP.setCenter(gridPane);
        mainBorderP.setBottom(hboxAccount);

        btnCreatAccount.setOnAction(new UserAccountInputHelper());

        rmbrMessage.setOnAction(new UserAccountReminder());
        System.out.println("Border Pane width: " + mainBorderP.getWidth() + "and Border Pane height: " + mainBorderP.getHeight());
    }
}
