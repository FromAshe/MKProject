/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

import mkproject.UserInterfaceModule.MainUserInterface;
import java.awt.image.BufferedImage;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.util.Optional;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import javax.imageio.ImageIO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import org.h2.jdbcx.JdbcConnectionPool;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import mkproject.UserInterfaceModule.ApplicationWindow;
import mkproject.UserInterfaceModule.CommentMenu;
import mkproject.UserInterfaceModule.MemberDisplayMenu;
import mkproject.UserInterfaceModule.MemberPlacementMenu;
import mkproject.UserInterfaceModule.MemberRegisterarMenu;
import org.h2.result.Row;

/**
 *
 * @author YOHY
 */
public class WorkinigInterface {

    Button bt;
    Button nextB;
    TextField tID, tIDN, tTitle;
    TextArea text;
    ImageView imageView;
    File file;
    static int idnum, idnum1;
    TextField tIDa, tMo, tFiNameA, tFaNameA, tGnameA, tTsota, tIDNO;
    ComboBox cDayA, cMonthA, cServiceY, cServiceA, tResponse, cServiceYY;
    String radioSex;
    private Members studata;
    DatabaseClass stuQueries;
    private List<Members> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    private static JdbcConnectionPool cp = null;
    private static Connection con = null;
    private static Statement stmt = null;
    GridPane gridP = new GridPane();
    GridPane gridP1 = new GridPane();
    GridPane gridP2 = new GridPane();
    GridPane gridP3 = new GridPane();
    GridPane gridP4 = new GridPane();
    GridPane gridP5 = new GridPane();
    GridPane gridP6 = new GridPane();
    GridPane gridP7 = new GridPane();
    GridPane gridP8 = new GridPane();
    GridPane gridP9 = new GridPane();
    GridPane gridP10 = new GridPane();
    GridPane gridP11 = new GridPane();
    GridPane gridP12 = new GridPane();
    GridPane gridPane8 = new GridPane();
    GridPane gridPane9 = new GridPane();
    GridPane gridPane10 = new GridPane();
    GridPane gridPane1L = new GridPane();
    GridPane gridPaneN = new GridPane();
    GridPane gridPane13 = new GridPane();
    GridPane gridPane14 = new GridPane();
    Stage primaryStage = new Stage();
    PreparedStatement pst;

    public void startt() {
        stuQueries = new DatabaseClass();
        // BorderPane border = new BorderPane();
        BorderPane border = mkproject.UserInterfaceModule.Border.getBorderPaneInstance().setBorderProperty();
        border.getChildren().clear();


        primaryStage = ApplicationWindow.getApplicationWindowInstance().setStageProperty();

        Label label1 = new Label("በኢትዮጵያ ኦርቶዶክስ ተዋህዶ ቤተክርስትያን የማኅበረ ቅዱሳን የሀረር ማዕከል");
        label1.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 22));
        label1.setTextFill(Color.WHITE);
        Label label2 = new Label("የአባላት መረጃ ቋት መመዝገቢያ ዳታቤዝ");
        label2.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 28));
        label2.setTextFill(Color.BLUE);

        VBox vBoxTop = new VBox();
        vBoxTop.setId("vBoxT2");
        vBoxTop.setSpacing(10);
        vBoxTop.setAlignment(Pos.CENTER);
        vBoxTop.setPadding(new Insets(10, 10, 10, 10));

        Label label3 = new Label("የሚፈልጉትን የስራ መደብ ይምረጡ");
        label3.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 22));
        label3.setTextFill(Color.BLACK);
        HBox hBoxSira = new HBox();
        hBoxSira.setId("hs");
        hBoxSira.setAlignment(Pos.CENTER);
        //  hBoxSira.getChildren().add(label3);
        hBoxSira.setPadding(new Insets(10, 10, 10, 10));

        HBox hBoxRadio = new HBox();
        hBoxRadio.setSpacing(50);
        hBoxRadio.setAlignment(Pos.CENTER);
        //  hBoxRadio.setId("hBox");
        hBoxRadio.setId("hBox1");
        hBoxRadio.setPadding(new Insets(10, 10, 10, 10));

        HBox hBoxRadio1 = new HBox();
        hBoxRadio1.setSpacing(120);
        hBoxRadio1.setAlignment(Pos.CENTER);
        hBoxRadio1.setId("hBox1");
        hBoxRadio1.setPadding(new Insets(5, 5, 5, 5));

        VBox hBoxRadio2 = new VBox();
        hBoxRadio2.setSpacing(10);
        hBoxRadio2.setAlignment(Pos.CENTER);
        hBoxRadio2.setId("vBoxC");
        hBoxRadio2.setPadding(new Insets(10, 10, 10, 10));

        
        MemberRegisterarMenu fillRadioData = MemberRegisterarMenu.getMeberRegisterarMenu();
        RadioButton retrieveRadioData = MemberDisplayMenu.getDisplayInstanceMenu();//new RadioButton("የአባላት መረጃ ማግኛ");
        RadioButton serviceRadioData = MemberPlacementMenu.getMemeberPlacementInstance();//new RadioButton("አገልግሎት ክፍል መመደቢያ");
        RadioButton noteRadioData = CommentMenu.getCommentMenuInstance();//new RadioButton("ማስታወሻ ለመመዝገብ");
        Hyperlink logOut = mkproject.UserInterfaceModule.LogOutLink.getLogOutLinkInstance();
        logOut.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                //primaryStage.close();
                
                new MainUserInterface().start(primaryStage);

            }
        });
        ImageView ivMK = new ImageView();
        ivMK = new ImageView();
        ivMK.setFitHeight(80);
        ivMK.setFitWidth(80);
        ivMK.setImage((new Image(getClass().getResourceAsStream("/mkproject/Image/MK.png"))));
        ImageView ivMK1 = new ImageView();
        ivMK1 = new ImageView();
        ivMK1.setFitHeight(80);
        ivMK1.setFitWidth(80);
        ivMK1.setImage((new Image(getClass().getResourceAsStream("/mkproject/Image/MK.png"))));

        hBoxRadio1.getChildren().addAll(ivMK, label2, ivMK1);
        //hBoxRadio2.getChildren().addAll(hBoxRadio);
        hBoxRadio = mkproject.UserInterfaceModule.Menu.getMenuInstance().menuHBox();

        vBoxTop.getChildren().addAll(hBoxRadio1, hBoxRadio);

        fillRadioData.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {
                //gridP.setId("bp");
                gridP7.getChildren().clear();
                gridP8.getChildren().clear();
                gridP.setPadding(new Insets(10, 10, 10, 10));
                gridP.setVgap(10);
                gridP.setHgap(15);

                Label fullName = new Label("1. ሙሉ ስም ከነአያት:");
                fullName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullName.setTextFill(Color.BLACK);
                gridP.add(fullName, 0, 0);

                TextField tFiName = new TextField();
                tFiName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridP.add(tFiName, 1, 0);

                Hyperlink uploadLink = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                //Hyperlink uploadLink = mkproject.UserInterfaceModule.Menu.getMenuInstance().getLogOUtHyperlink();
                uploadLink.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLink.setTextFill(Color.BLUE);

                uploadLink.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        new JavaFxApplication1().importData();

                    }
                });
                Hyperlink uploadLink1 = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                uploadLink1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLink1.setTextFill(Color.BLUE);

                uploadLink1.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        new JavaFxApplication1().importData1();

                    }
                });
                Hyperlink uploadLink2 = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                uploadLink2.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLink2.setTextFill(Color.BLUE);

                uploadLink2.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        new JavaFxApplication1().importData2();

                    }
                });
                Hyperlink uploadLink3 = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                uploadLink3.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLink3.setTextFill(Color.BLUE);

                uploadLink3.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        new JavaFxApplication1().importData3();

                    }
                });
                Hyperlink uploadLink4 = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                uploadLink4.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLink4.setTextFill(Color.BLUE);

                uploadLink4.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        new JavaFxApplication1().importData4();

                    }
                });
                Hyperlink uploadLink5 = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                uploadLink5.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLink5.setTextFill(Color.BLUE);

                uploadLink5.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        new JavaFxApplication1().importData5();

                    }
                });
                Hyperlink uploadLink6 = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                uploadLink6.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLink6.setTextFill(Color.BLUE);

                uploadLink6.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        new JavaFxApplication1().importData6();

                    }
                });

                TextField tFaName = new TextField();
                tFaName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridP.add(tFaName, 1, 1);

                TextField tGname = new TextField();
                tGname.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridP.add(tGname, 1, 2);

                Label fullID = new Label("መለያ ቁጥር:");
                fullID.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullID.setTextFill(Color.BLACK);
                tID = new TextField();
                gridP.add(fullID, 0, 3);
                gridP.add(tID, 1, 3);

                tGname.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelBirth = new Label("2. የትውልድ ጊዜ");
                labelBirth.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelBirth.setTextFill(Color.BLACK);
                gridP.add(labelBirth, 0, 4);

                Label labelYBirth = new Label("ዓ/ም:");
                labelYBirth.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelYBirth.setTextFill(Color.BLACK);

                final ComboBox cYear = new ComboBox();
                cYear.getItems().addAll(
                        "1960",
                        "1961",
                        "1962",
                        "1963",
                        "1964",
                        "1965",
                        "1966",
                        "1967",
                        "1968",
                        "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981",
                        "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994");
                cYear.setPromptText("ዓመት");
                cYear.setEditable(true);
                cYear.setId("table");
                HBox hboxYear = new HBox();
                hboxYear.setSpacing(5);
                hboxYear.getChildren().addAll(labelYBirth, cYear);
                gridP.add(hboxYear, 1, 4);

                Label labelMBirth = new Label("ወር:");
                labelMBirth.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelMBirth.setTextFill(Color.BLACK);

                final ComboBox cMonth = new ComboBox();
                cMonth.setId("table");
                cMonth.getItems().addAll(
                        "መስከረም",
                        "ጥቅምት",
                        "ህዳር",
                        "ታህሳስ",
                        "ጥር",
                        "የካቲት",
                        "መጋቢት",
                        "ሚያዚያ",
                        "ግንቦት", "ሰኔ", "ሐምሌ", "ነሐሴ");

                cMonth.setPromptText("ወር");
                cMonth.setEditable(true);
                HBox hboxMonth = new HBox();
                hboxMonth.setSpacing(5);
                hboxMonth.getChildren().addAll(labelMBirth, cMonth);
                gridP.add(hboxMonth, 1, 5);

                Label labelDBirth = new Label("ቀን:");
                labelDBirth.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelDBirth.setTextFill(Color.BLACK);

                final ComboBox cDay = new ComboBox();
                cDay.getItems().addAll(
                        "01",
                        "02",
                        "03",
                        "04",
                        "05",
                        "06",
                        "07",
                        "08",
                        "09", "10", "11", "12", "13",
                        "14",
                        "15",
                        "16",
                        "17",
                        "18",
                        "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");

                cDay.setPromptText("ቀን");
                cDay.setEditable(true);
                cDay.setId("table");

                HBox hboxDay = new HBox();
                hboxDay.setSpacing(5);
                hboxDay.getChildren().addAll(labelDBirth, cDay);
                gridP.add(hboxDay, 1, 6);

                Label labelWereda = new Label("  ወረዳ:");
                labelWereda.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelWereda.setTextFill(Color.BLACK);
                TextField tWereda = new TextField();
                tWereda.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                gridP.add(labelWereda, 0, 7);
                gridP.add(tWereda, 1, 7);

                Label labelKetema = new Label("  ከተማ:");
                labelKetema.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelKetema.setTextFill(Color.BLACK);
                TextField tKetema = new TextField();
                tKetema.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                gridP.add(labelKetema, 0, 8);
                gridP.add(tKetema, 1, 8);

                Label labelKebele = new Label("  ቀበሌ:");
                labelKebele.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelKebele.setTextFill(Color.BLACK);
                TextField tKebele = new TextField();
                tKebele.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                gridP.add(labelKebele, 0, 9);
                gridP.add(tKebele, 1, 9);
                gridP.add(uploadLink, 1, 11);

                Label labelSimeK = new Label("3. ስመ ክርስትና:");
                labelSimeK.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSimeK.setTextFill(Color.BLACK);

                TextField tSimeK = new TextField();
                tSimeK.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelBK = new Label("   ክርስትና የተነሱበት ቤ/ክ :");
                labelBK.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelBK.setTextFill(Color.BLACK);
                TextField tBK = new TextField();
                tBK.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxBK = new HBox();
                hboxBK.setSpacing(3);
                hboxBK.getChildren().addAll(labelBK, tBK);
                GridPane.setColumnSpan(hboxBK, 2);

                Label labelMK = new Label("4. ማዕረገ ክህነት :");
                labelMK.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelMK.setTextFill(Color.BLACK);

                TextField tMK = new TextField();
                tMK.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelMKY = new Label("   (ካለ)የተቀበሉበት ዘመን :");
                labelMKY.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelMKY.setTextFill(Color.BLACK);
                TextField tMKY = new TextField();
                tMKY.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxMKY = new HBox();
                hboxMKY.setSpacing(3);
                hboxMKY.getChildren().addAll(labelMKY, tMKY);
                GridPane.setColumnSpan(hboxMKY, 2);

                Label labelSEdu = new Label("5. መ/ት/የ/ሀ/ስብከት");
                labelSEdu.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSEdu.setTextFill(Color.BLACK);

                TextField tSEdu = new TextField();
                tSEdu.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelKGM = new Label("   ቀ/ገ/ማኅበር(ደብር):");
                labelKGM.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelKGM.setTextFill(Color.BLACK);

                TextField tKGM = new TextField();
                tKGM.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxDebir = new HBox();
                hboxDebir.setSpacing(8);
                hboxDebir.getChildren().addAll(tSEdu, labelKGM, tKGM);
                GridPane.setColumnSpan(hboxDebir, 3);

                Label labelAwraja = new Label("   አዉራጃ:");
                labelAwraja.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAwraja.setTextFill(Color.BLACK);

                TextField tAwraja = new TextField();
                tAwraja.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                Label labelHBK = new Label("   ቤተክርስትያን :");
                labelHBK.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelHBK.setTextFill(Color.BLACK);

                TextField tHBK = new TextField();
                tHBK.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                tIDNO = new TextField();
                tIDNO.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                HBox hboxAwira = new HBox();
                hboxAwira.setSpacing(8);
                hboxAwira.getChildren().addAll(labelAwraja, tAwraja, labelHBK, tHBK);
                GridPane.setColumnSpan(hboxAwira, 3);

                Label labelSuChu = new Label("6. አባል የሆኑባቸዉ ሰንበት ት/ቤቶች ወይም ሰበካ ጉባኤያት ከበፊት እስከ አሁን የመጨረሻ ሁለቱን ይጥቀሱ::");
                labelSuChu.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSuChu.setTextFill(Color.BLACK);
                GridPane.setColumnSpan(labelSuChu, 3);

                Label labelSuChuName = new Label("   ስሙ :");
                labelSuChuName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSuChuName.setTextFill(Color.BLACK);
                TextField tSuName = new TextField();
                tSuName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxSuName = new HBox();
                hboxSuName.setSpacing(3);
                hboxSuName.getChildren().addAll(labelSuChuName, tSuName);

                Label labelHSibket = new Label("ሀ/ስብከት:");
                labelHSibket.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelHSibket.setTextFill(Color.BLACK);
                TextField tHSibket = new TextField();
                tHSibket.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxHSibket = new HBox();
                hboxHSibket.setSpacing(3);
                hboxHSibket.getChildren().addAll(labelHSibket, tHSibket);

                Label labelHSibketW = new Label("ወረዳ:");
                labelHSibketW.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelHSibketW.setTextFill(Color.BLACK);
                TextField tHSibketW = new TextField();
                tHSibketW.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxHSibketW = new HBox();
                hboxHSibketW.setSpacing(3);
                hboxHSibketW.getChildren().addAll(labelHSibketW, tHSibketW);

                Label labelSuChuName1 = new Label("   ስሙ :");
                labelSuChuName1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSuChuName1.setTextFill(Color.BLACK);
                TextField tSuName1 = new TextField();
                tSuName1.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxSuName1 = new HBox();
                hboxSuName1.setSpacing(3);
                hboxSuName1.getChildren().addAll(labelSuChuName1, tSuName1);

                Label labelHSibket1 = new Label("ሀ/ስብከት:");
                labelHSibket1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelHSibket1.setTextFill(Color.BLACK);
                TextField tHSibket1 = new TextField();
                tHSibket1.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                HBox hboxHSibket1 = new HBox();
                hboxHSibket1.setSpacing(3);
                hboxHSibket1.getChildren().addAll(labelHSibket1, tHSibket1);

                Label labelHSibketW1 = new Label("ወረዳ:");
                labelHSibketW1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelHSibketW1.setTextFill(Color.BLACK);
                TextField tHSibketW1 = new TextField();
                tHSibketW1.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxHSibketW1 = new HBox();
                hboxHSibketW1.setSpacing(3);
                hboxHSibketW1.getChildren().addAll(labelHSibketW1, tHSibketW1);

                Label labelUni = new Label("7. ከፍተኛ ትምህርት የተከታተሉበት ተቋም(ኮሌጅ)ዩንቨርስቲ ካለ የተቋሙ ስም:");
                labelUni.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUni.setTextFill(Color.BLACK);
                TextField tUniName = new TextField();
                tUniName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxUni = new HBox();
                hboxUni.setSpacing(3);
                hboxUni.getChildren().addAll(labelUni, tUniName);
                GridPane.setColumnSpan(hboxUni, 3);

                Label labelUniLife = new Label("  የቆዩበት ግዜ ከ ");
                labelUniLife.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUniLife.setTextFill(Color.BLACK);

                TextField tUniLife = new TextField();
                Label labelUniLifeBY = new Label("ዓ.ም");
                labelUniLifeBY.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUniLifeBY.setTextFill(Color.BLACK);
                HBox hboxUniLife = new HBox();
                hboxUniLife.setSpacing(3);
                hboxUniLife.getChildren().addAll(tUniLife, labelUniLifeBY);

                Label labelUniLifeUntile = new Label("  እስከ ");
                labelUniLifeUntile.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUniLifeUntile.setTextFill(Color.BLACK);
                TextField tUniLifeUntile = new TextField();
                Label labelUniLifeEY = new Label("ዓ.ም");
                labelUniLifeEY.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUniLifeEY.setTextFill(Color.BLACK);
                HBox hboxUniLifeUntile = new HBox();
                hboxUniLifeUntile.setSpacing(3);
                hboxUniLifeUntile.getChildren().addAll(tUniLifeUntile, labelUniLifeEY);

                Label labelUniHS = new Label("8. በተራ ቁጥር 7 በተጠቀሰዉ ተቋም መንፈሳዊ ትምህርት የተከታተሉበት ሀ/ስብከት :");
                labelUniHS.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUniHS.setTextFill(Color.BLACK);
                TextField tUniHS = new TextField();
                tUniHS.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxUniHS = new HBox();
                hboxUniHS.setSpacing(3);
                hboxUniHS.getChildren().addAll(labelUniHS, tUniHS);
                GridPane.setColumnSpan(hboxUniHS, 3);

                Label labelUniBK = new Label("   ቤተ ክርስትያን :");
                labelUniBK.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUniBK.setTextFill(Color.BLACK);
                TextField tUniBK = new TextField();
                tUniBK.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxUniBK = new HBox();
                hboxUniBK.setSpacing(3);
                hboxUniBK.getChildren().addAll(labelUniBK, tUniBK);

                Label labelUniSC = new Label("   ሰ/ት/ቤት :");
                labelUniSC.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelUniSC.setTextFill(Color.BLACK);
                TextField tUniSC = new TextField();
                tUniSC.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxUniSC = new HBox();
                hboxUniSC.setSpacing(3);
                hboxUniSC.getChildren().addAll(labelUniSC, tUniSC);

                Label labelMuya = new Label("9. በከፍተኛ ትምህርት ተቋም የተመረቁበት ሙያ  :");
                labelMuya.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelMuya.setTextFill(Color.BLACK);
                final ComboBox cMuya = new ComboBox();
                cMuya.setId("table");
                cMuya.getItems().addAll(
                        "መምህር",
                        "መድሐኒት ቤት",
                        "ጤና",
                        "ሂሳብ ሰራተኛ",
                        "ፀሐፊ",
                        "ኢንጂነሪንግ",
                        "ቢዝነስ አስተዳደር",
                        "ሌላ ሙያ");
                cMuya.setPromptText("የስራ አይነት");
                cMuya.setEditable(true);

                HBox hboxMuya = new HBox();
                GridPane.setColumnSpan(hboxMuya, 3);
                hboxMuya.setSpacing(3);
                hboxMuya.getChildren().addAll(labelMuya, cMuya);

                Label labelJobCity = new Label("10. ለሥራ የተመደቡበት :");
                labelJobCity.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobCity.setTextFill(Color.BLACK);

                Label labelJobHS = new Label("    ሀ /ስብከት :");
                labelJobHS.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobHS.setTextFill(Color.BLACK);
                TextField tJobHS = new TextField();
                tJobHS.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobHS = new HBox();
                hboxJobHS.setSpacing(3);
                hboxJobHS.getChildren().addAll(labelJobHS, tJobHS);

                Label labelJobZone = new Label("    ዞን :");
                labelJobZone.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobZone.setTextFill(Color.BLACK);
                TextField tJobZone = new TextField();
                tJobZone.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobZone = new HBox();
                hboxJobZone.setSpacing(3);
                hboxJobZone.getChildren().addAll(labelJobZone, tJobZone);

                Label labelJobWereda = new Label("    ወረዳ :");
                labelJobWereda.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobWereda.setTextFill(Color.BLACK);
                TextField tJobWereda = new TextField();
                tJobWereda.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobWereda = new HBox();
                hboxJobWereda.setSpacing(3);
                hboxJobWereda.getChildren().addAll(labelJobWereda, tJobWereda);

                HBox hboxJob = new HBox();
                hboxJob.setSpacing(25);
                hboxJob.getChildren().addAll(hboxJobHS, hboxJobZone, hboxJobWereda);
                GridPane.setColumnSpan(hboxJob, 4);

                Label labelJobKetema = new Label("    ከተማ :");
                labelJobKetema.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobKetema.setTextFill(Color.BLACK);
                TextField tJobKetema = new TextField();
                tJobKetema.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobKetema = new HBox();
                hboxJobKetema.setSpacing(3);
                hboxJobKetema.getChildren().addAll(labelJobKetema, tJobKetema);

                Label labelJobKebele = new Label("    ቀበሌ:");
                labelJobKebele.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobKebele.setTextFill(Color.BLACK);
                TextField tJobKebele = new TextField();
                tJobKebele.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobKebele = new HBox();
                hboxJobKebele.setSpacing(3);
                hboxJobKebele.getChildren().addAll(labelJobKebele, tJobKebele);

                Label labelJobGebere = new Label("    ቀ/ገ/ማኅበር:");
                labelJobGebere.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobGebere.setTextFill(Color.BLACK);
                TextField tJobGebere = new TextField();
                tJobGebere.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobGebere = new HBox();
                hboxJobGebere.setSpacing(3);
                hboxJobGebere.getChildren().addAll(labelJobGebere, tJobGebere);

                HBox hboxJobAdd = new HBox();
                hboxJobAdd.setSpacing(15);
                hboxJobAdd.getChildren().addAll(hboxJobKetema, hboxJobKebele, hboxJobGebere);
                GridPane.setColumnSpan(hboxJobAdd, 4);

                Label labelJobType = new Label("    የሥራ ዘርፍ:");
                labelJobType.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobType.setTextFill(Color.BLACK);
                TextField tJobType = new TextField();
                tJobType.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobType = new HBox();
                hboxJobType.setSpacing(3);
                hboxJobType.getChildren().addAll(labelJobType, tJobType);

                Label labelJobHouse = new Label("    መ/ቤት:");
                labelJobHouse.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobHouse.setTextFill(Color.BLACK);
                TextField tJobHouse = new TextField();
                tJobHouse.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobHouse = new HBox();
                hboxJobHouse.setSpacing(3);
                hboxJobHouse.getChildren().addAll(labelJobHouse, tJobHouse);

                Label labelJobPhone = new Label("    ስ/ቁ(የመ/ቤት):");
                labelJobPhone.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelJobPhone.setTextFill(Color.BLACK);
                TextField tJobPhone = new TextField();
                tJobPhone.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxJobPhone = new HBox();
                hboxJobPhone.setSpacing(3);
                hboxJobPhone.getChildren().addAll(labelJobPhone, tJobPhone);

                HBox hboxJobAdd1 = new HBox();
                hboxJobAdd1.setSpacing(15);
                hboxJobAdd1.getChildren().addAll(hboxJobType, hboxJobHouse, hboxJobPhone);
                GridPane.setColumnSpan(hboxJobAdd1, 4);

                Label labelAdHou = new Label("11. የመኖርያ አድራሻ:");
                labelAdHou.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHou.setTextFill(Color.BLACK);
                // gridP.add(labelAdHou,0,0);
                Label labelAdHouKetema = new Label("  ከተማ:");
                labelAdHouKetema.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouKetema.setTextFill(Color.BLACK);
                TextField tAdHouKetema = new TextField();
                tAdHouKetema.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxAdHou = new HBox();
                hboxAdHou.setSpacing(3);
                hboxAdHou.getChildren().addAll(labelAdHouKetema, tAdHouKetema);
                // gridP.add(hboxAdHou, 1,0);
                Label labelAdHouKefitegna = new Label("  ከፍተኛ:");
                labelAdHouKefitegna.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouKefitegna.setTextFill(Color.BLACK);
                TextField tAdHouKefitegna = new TextField();
                tAdHouKefitegna.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxKefitegna = new HBox();
                hboxKefitegna.setSpacing(3);
                hboxKefitegna.getChildren().addAll(labelAdHouKefitegna, tAdHouKefitegna);
                // gridP.add(hboxKefitegna, 2,0);
                Label labelAdHouKebele = new Label("  ቀበሌ:");
                labelAdHouKebele.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouKebele.setTextFill(Color.BLACK);
                TextField tAdHouKebele = new TextField();
                tAdHouKebele.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxAdHouKebele = new HBox();
                hboxAdHouKebele.setSpacing(3);
                GridPane.setColumnSpan(hboxAdHouKebele, 3);
                hboxAdHouKebele.getChildren().addAll(labelAdHou, labelAdHouKetema, tAdHouKetema, labelAdHouKefitegna, tAdHouKefitegna, labelAdHouKebele, tAdHouKebele);

                Label labelAdHouNum = new Label("  የቤት ቁ.:");
                labelAdHouNum.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouNum.setTextFill(Color.BLACK);
                TextField tAdHouNum = new TextField();
                tAdHouNum.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxAdHouNum = new HBox();
                hboxAdHouNum.setSpacing(3);
                hboxAdHouNum.getChildren().addAll(labelAdHouNum, tAdHouNum);
                // gridP.add(hboxAdHouNum, 1,1);
                Label labelAdHouPhone = new Label("  ስ/ቁ (የቤት)");
                labelAdHouPhone.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouPhone.setTextFill(Color.BLACK);
                TextField tAdHouPhone = new TextField();
                tAdHouPhone.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxAdHouPhone = new HBox();
                hboxAdHouPhone.setSpacing(3);
                hboxAdHouPhone.getChildren().addAll(labelAdHouPhone, tAdHouPhone);
                // gridP.add(hboxAdHouPhone, 2,1);
                Label labelMobile = new Label("  ሞባይል:");
                labelMobile.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelMobile.setTextFill(Color.BLACK);
                TextField tMobile = new TextField();
                tMobile.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxMobile = new HBox();
                hboxMobile.setSpacing(3);
                GridPane.setColumnSpan(hboxMobile, 3);
                hboxMobile.getChildren().addAll(labelAdHouNum, tAdHouNum, labelAdHouPhone, tAdHouPhone, labelMobile, tMobile);

                Label labelMetedaderiya = new Label("12. መተዳደሪያ:");
                labelMetedaderiya.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelMetedaderiya.setTextFill(Color.BLACK);
                // gridP.add(labelMetedaderiya, 0,2);
                final ComboBox cAd = new ComboBox();
                cAd.getItems().addAll(
                        "የግል ስራ",
                        "ተማሪ",
                        "የመንግስት ሠራተኛ");
                cAd.setId("table");
                cAd.setPromptText("ስራ");
                cAd.setEditable(true);
                cAd.setMaxWidth(150);

                //  gridP.add(radioGovSer, 2,2);
                Label labelSelf = new Label("  ልዩ ሙያ(ይጠቀስ)");

                labelSelf.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));

                TextField tLiyuMuya = new TextField();
                tLiyuMuya.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                Label labelEduLevel = new Label("  የት/ደረጃ:");
                labelEduLevel.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelEduLevel.setTextFill(Color.BLACK);
                TextField tEduLevel = new TextField();
                tEduLevel.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxAdmin = new HBox();
                hboxAdmin.setSpacing(10);
                GridPane.setColumnSpan(hboxAdmin, 3);
                hboxAdmin.getChildren().addAll(labelMetedaderiya, cAd, labelSelf, tLiyuMuya, labelEduLevel, tEduLevel);

                Label labelBKSur = new Label("13. በአሁኑ ወቅት አገልግሎት እየሰጡ(እያገኙ) ያሉበት ቤተ ክርስትያን ስም   ");
                labelBKSur.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelBKSur.setTextFill(Color.BLACK);
                TextField tBkName = new TextField();
                tBkName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxKale = new HBox();
                GridPane.setColumnSpan(hboxKale, 3);
                hboxKale.setSpacing(3);
                hboxKale.getChildren().addAll(labelBKSur, tBkName);

                Label labelKihinetKale = new Label("    ሀ. የክህነት ማዕረግ (ካለ):");
                labelKihinetKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelKihinetKale.setTextFill(Color.BLACK);
                TextField tKihinetKale = new TextField();
                tKihinetKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxKihinetKale = new HBox();
                GridPane.setColumnSpan(hboxKihinetKale, 3);
                hboxKihinetKale.setSpacing(3);
                hboxKihinetKale.getChildren().addAll(labelKihinetKale, tKihinetKale);

                Label labelSunibetKale = new Label("    ለ. በሰንበት ት/ቤት የሥራ ድርሻ (ካለ):");
                labelSunibetKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSunibetKale.setTextFill(Color.BLACK);
                TextField tSunibetKale = new TextField();
                tSunibetKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxSunibetKale = new HBox();
                GridPane.setColumnSpan(hboxSunibetKale, 3);
                hboxSunibetKale.setSpacing(3);
                hboxSunibetKale.getChildren().addAll(labelSunibetKale, tSunibetKale);

                Label labelSebekaKale = new Label("    ሐ. በሰበካ ጉባኤ የሥራ ድርሻ(ካለ):");
                labelSebekaKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSebekaKale.setTextFill(Color.BLACK);
                TextField tSebekaKale = new TextField();
                tSebekaKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxSebekaKale = new HBox();
                GridPane.setColumnSpan(hboxSebekaKale, 3);
                hboxSebekaKale.setSpacing(3);
                hboxSebekaKale.getChildren().addAll(labelSebekaKale, tSebekaKale);

                Label labelSebekaIDKale = new Label("    መ. የሰበካ ጉባኤ(የሰንበት ት/ቤት) መታወቂያ ቁጥር:");
                labelSebekaIDKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSebekaIDKale.setTextFill(Color.BLACK);
                TextField tSebekaIDKale = new TextField();
                tSebekaIDKale.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxSebekaIDKale = new HBox();
                GridPane.setColumnSpan(hboxSebekaIDKale, 3);
                hboxSebekaIDKale.setSpacing(3);
                hboxSebekaIDKale.getChildren().addAll(labelSebekaIDKale, tSebekaIDKale);

                Label labelSpritFather = new Label("14.  የንስሐ አባት ስም:");
                labelSpritFather.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelSpritFather.setTextFill(Color.BLACK);
                TextField tSpritFather = new TextField();
                tSpritFather.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxSpritFather = new HBox();
                GridPane.setColumnSpan(hboxSpritFather, 3);
                hboxSpritFather.setSpacing(10);
                hboxSpritFather.getChildren().addAll(labelSpritFather, tSpritFather);

                Label labelLangSkill = new Label("15.  የቋንቋ ችሎታ:");
                labelLangSkill.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelLangSkill.setTextFill(Color.BLACK);

                Label labelLangSkillA = new Label("   ሀ) ");
                labelLangSkillA.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelLangSkillA.setTextFill(Color.BLACK);
                TextField tLangSkillA = new TextField();
                tLangSkillA.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                Label checkLangSkillSpeak = new Label("መናገር");
                checkLangSkillSpeak.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillSpeak.setTextFill(Color.BLACK);
                final ComboBox cSpeak = new ComboBox();
                cSpeak.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cSpeak.setPromptText("ብቃት");
                cSpeak.setEditable(true);
                cSpeak.setId("table");
                cSpeak.setMaxWidth(100);
                Label checkLangSkillListen = new Label("መስማት");
                checkLangSkillListen.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillListen.setTextFill(Color.BLACK);
                final ComboBox cListen = new ComboBox();
                cListen.setId("table");
                cListen.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cListen.setPromptText("ብቃት");
                cListen.setMaxWidth(100);
                cListen.setEditable(true);
                Label checkLangSkillWrite = new Label("መጻፍ");
                checkLangSkillWrite.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillWrite.setTextFill(Color.BLACK);
                final ComboBox cWrite = new ComboBox();
                cWrite.setEditable(true);
                cWrite.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cWrite.setId("table");
                cWrite.setPromptText("ብቃት");
                cWrite.setMaxWidth(100);
                Label checkLangSkillRead = new Label("ማንበብ");
                checkLangSkillRead.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillRead.setTextFill(Color.BLACK);
                final ComboBox cRead = new ComboBox();
                cRead.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cRead.setId("table");
                cRead.setPromptText("ብቃት");
                cRead.setEditable(true);
                cRead.setMaxWidth(100);
                final ComboBox cRead1 = new ComboBox();
                cRead1.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cRead1.setId("table");
                cRead1.setPromptText("ብቃት");
                cRead1.setEditable(true);
                cRead1.setMaxWidth(100);
                final ComboBox cRead2 = new ComboBox();
                cRead2.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cRead2.setId("table");
                cRead2.setPromptText("ብቃት");
                cRead2.setEditable(true);
                cRead2.setMaxWidth(100);
                HBox hboxLangSkillA = new HBox();
                GridPane.setColumnSpan(hboxLangSkillA, 3);
                hboxLangSkillA.setSpacing(10);
                hboxLangSkillA.getChildren().addAll(labelLangSkillA, tLangSkillA, checkLangSkillSpeak, cSpeak, checkLangSkillListen, cListen, checkLangSkillWrite, cWrite, checkLangSkillRead, cRead);

                final ComboBox cWrite1 = new ComboBox();
                cWrite1.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cWrite1.setId("table");
                cWrite1.setPromptText("ብቃት");
                cWrite1.setEditable(true);
                cWrite1.setMaxWidth(100);
                final ComboBox cWrite2 = new ComboBox();
                cWrite2.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cWrite2.setId("table");
                cWrite2.setPromptText("ብቃት");
                cWrite2.setEditable(true);
                cWrite2.setMaxWidth(100);
                final ComboBox cSpeak1 = new ComboBox();
                cSpeak1.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cSpeak1.setId("table");
                cSpeak1.setPromptText("ብቃት");
                cSpeak1.setEditable(true);
                cSpeak1.setMaxWidth(100);
                final ComboBox cListen1 = new ComboBox();
                cListen1.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cListen1.setId("table");
                cListen1.setPromptText("ብቃት");
                cListen1.setEditable(true);
                cListen1.setMaxWidth(100);
                Label labelLangSkillA1 = new Label("   ለ) ");
                labelLangSkillA1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelLangSkillA1.setTextFill(Color.BLACK);
                TextField tLangSkillA1 = new TextField();
                tLangSkillA1.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                Label checkLangSkillSpeak1 = new Label("መናገር");
                checkLangSkillSpeak1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillSpeak1.setTextFill(Color.BLACK);
                Label checkLangSkillListen1 = new Label("መስማት");
                checkLangSkillListen1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillListen1.setTextFill(Color.BLACK);
                Label checkLangSkillWrite1 = new Label("መጻፍ");
                checkLangSkillWrite1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillWrite1.setTextFill(Color.BLACK);
                Label checkLangSkillRead1 = new Label("ማንበብ");
                checkLangSkillRead1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillRead1.setTextFill(Color.BLACK);
                HBox hboxLangSkillA1 = new HBox();
                GridPane.setColumnSpan(hboxLangSkillA1, 3);
                hboxLangSkillA1.setSpacing(10);
                hboxLangSkillA1.getChildren().addAll(labelLangSkillA1, tLangSkillA1, checkLangSkillSpeak1, cSpeak1, checkLangSkillListen1, cListen1, checkLangSkillWrite1, cWrite1, checkLangSkillRead1, cRead1);

                Label labelLangSkillA2 = new Label("   ሐ) ");
                labelLangSkillA2.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelLangSkillA2.setTextFill(Color.BLACK);
                TextField tLangSkillA2 = new TextField();
                tLangSkillA2.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                Label checkLangSkillSpeak2 = new Label("መናገር");
                checkLangSkillSpeak2.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillSpeak2.setTextFill(Color.BLACK);
                Label checkLangSkillListen2 = new Label("መስማት");
                checkLangSkillListen2.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillListen2.setTextFill(Color.BLACK);
                Label checkLangSkillWrite2 = new Label("መጻፍ");
                checkLangSkillWrite2.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillWrite2.setTextFill(Color.BLACK);
                Label checkLangSkillRead2 = new Label("ማንበብ");
                checkLangSkillRead2.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                checkLangSkillRead2.setTextFill(Color.BLACK);
                HBox hboxLangSkillA2 = new HBox();
                GridPane.setColumnSpan(hboxLangSkillA2, 3);
                hboxLangSkillA2.setSpacing(10);
                final ComboBox cSpeak2 = new ComboBox();
                cSpeak2.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cSpeak2.setId("table");
                cSpeak2.setPromptText("ብቃት");
                cSpeak2.setEditable(true);
                cSpeak2.setMaxWidth(100);
                final ComboBox cListen2 = new ComboBox();
                cListen2.getItems().addAll(
                        "እጅግ በጣም ጥሩ",
                        "በጣም ጥሩ",
                        "ጥሩ",
                        "በቂ", " አነስተኛ");
                cListen2.setId("table");
                cListen2.setPromptText("ብቃት");
                cListen2.setEditable(true);
                cListen2.setMaxWidth(100);
                hboxLangSkillA2.getChildren().addAll(labelLangSkillA2, tLangSkillA2, checkLangSkillSpeak2, cSpeak2, checkLangSkillListen2, cListen2, checkLangSkillWrite2, cWrite2, checkLangSkillRead2, cRead2);

                Label labelAgeligilot = new Label("16. በአገልግሎት መሳተፍ የሚፈልጉበት (የሚችሉበት):");
                labelAgeligilot.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAgeligilot.setTextFill(Color.BLACK);

                final ComboBox cService = new ComboBox();
                cService.getItems().addAll(
                        "በመዘመር",
                        "በማስተማር",
                        "በሥነ-ጽሑፍ",
                        "በሥዕል", "በዕደ- ጥበብ");
                cService.setId("table");
                cService.setPromptText("አገልግሎት ክፍል");
                cService.setEditable(true);
                cService.setMaxWidth(200);

                HBox hboxService = new HBox();
                GridPane.setColumnSpan(hboxService, 3);
                hboxService.setSpacing(10);
                hboxService.getChildren().addAll(labelAgeligilot, cService);

                Label labelOtherSkill = new Label("16. ቅጽ የሞሉበት ቀን፣ወር፣ዓ.ም:");
                labelOtherSkill.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelOtherSkill.setTextFill(Color.BLACK);

                TextField tOtherSkill = new TextField();
                tOtherSkill.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelID = new Label("የአባሉ መለያ ቁጥር:");
                labelID.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelID.setTextFill(Color.BLACK);

                HBox hboxLela = new HBox();
                GridPane.setColumnSpan(hboxLela, 3);
                hboxLela.setSpacing(10);
                hboxLela.getChildren().addAll(labelOtherSkill, tOtherSkill, labelID);

                Label labelRep = new Label("17. የቅርብ ተጠሪ :");
                labelRep.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelRep.setTextFill(Color.BLACK);

                Label labelRepName = new Label("  ሙሉ ስም  :");
                labelRepName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelRepName.setTextFill(Color.BLACK);
                TextField tRepName = new TextField();
                tRepName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                TextField tRepName2 = new TextField();
                tRepName2.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                TextField tRepName3 = new TextField();
                tRepName3.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxRepName = new HBox();
                GridPane.setColumnSpan(hboxRepName, 3);
                hboxRepName.setSpacing(10);
                hboxRepName.getChildren().addAll(labelRepName, tRepName, tRepName2, tRepName3);

                Label labelAdHouR = new Label("    ለ) አድራሻ:");
                labelAdHouR.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouR.setTextFill(Color.BLACK);
                // gridP.add(labelAdHou,0,0);
                Label labelAdHouKetemaR = new Label("  ከተማ:");
                labelAdHouKetemaR.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouKetemaR.setTextFill(Color.BLACK);
                TextField tAdHouKetemaR = new TextField();
                tAdHouKetemaR.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelAdHouKefitegnaR = new Label("  ከፍተኛ:");
                labelAdHouKefitegnaR.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouKefitegnaR.setTextFill(Color.BLACK);
                TextField tAdHouKefitegnaR = new TextField();
                tAdHouKefitegnaR.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelAdHouKebeleR = new Label("  ቀበሌ:");
                labelAdHouKebeleR.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouKebeleR.setTextFill(Color.BLACK);
                TextField tAdHouKebeleR = new TextField();
                tAdHouKebeleR.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxAdHouKebeleR = new HBox();
                hboxAdHouKebeleR.setSpacing(3);
                GridPane.setColumnSpan(hboxAdHouKebeleR, 3);
                hboxAdHouKebeleR.getChildren().addAll(labelAdHouR, labelAdHouKetemaR, tAdHouKetemaR, labelAdHouKefitegnaR, tAdHouKefitegnaR, labelAdHouKebeleR, tAdHouKebeleR);

                Label labelAdHouNumR = new Label("  የቤት ቁ.:");
                labelAdHouNumR.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouNumR.setTextFill(Color.BLACK);
                TextField tAdHouNumR = new TextField();
                tAdHouNumR.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelAdHouPhoneR = new Label("  ስ/ቁ (የቤት)");
                labelAdHouPhoneR.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelAdHouPhoneR.setTextFill(Color.BLACK);
                TextField tAdHouPhoneR = new TextField();
                tAdHouPhoneR.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));

                Label labelMobileR = new Label("  ሞባይል:");
                labelMobileR.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelMobileR.setTextFill(Color.BLACK);
                TextField tMobileR = new TextField();
                tMobileR.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                HBox hboxMobileR = new HBox();
                hboxMobileR.setSpacing(3);
                GridPane.setColumnSpan(hboxMobileR, 3);
                hboxMobileR.getChildren().addAll(labelAdHouNumR, tAdHouNumR, labelAdHouPhoneR, tAdHouPhoneR, labelMobileR, tMobileR);

                Label labelPhoto = new Label("  ፎቶ ግራፍ:");
                labelPhoto.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelPhoto.setTextFill(Color.BLACK);

                Button butUpload = new Button("ይጫኑ");
                butUpload.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                butUpload.setTextFill(Color.BLACK);
                HBox hboxPhoto = new HBox();
                hboxPhoto.setSpacing(10);
                hboxPhoto.getChildren().addAll(labelPhoto, butUpload);

                imageView = new ImageView();
                imageView.setFitHeight(160);
                imageView.setFitWidth(160);

                GridPane.setRowSpan(imageView, 4);

                butUpload.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        FileChooser fileChooser = new FileChooser();

                        //Set extension filter
                        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

                        //Show open file dialog
                        file = fileChooser.showOpenDialog(null);

                        try {
                            BufferedImage bufferedImage = ImageIO.read(file);
                            String str;
                            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                            str = file.getAbsolutePath();
                            System.out.println("File path " + str);
                            imageView.setImage(image);
                        } catch (IOException ex) {
                            Logger.getLogger(WorkinigInterface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                //Ageligilote..... Interface.... begin....//
                HBox hbox = new HBox();
                hbox.setSpacing(20);
                Button fillB = new Button("ሙላ");
                fillB.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fillB.setPrefWidth(100);
                fillB.setStyle("-fx-base:#98fb98;");

                nextB = new Button("ቀጣይ");
                nextB.setPrefWidth(100);
                nextB.setStyle("-fx-base:#98fb98;");
                // nextB.setDisable(true);
                nextB.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                hbox.getChildren().addAll(fillB, nextB);
                gridP.add(hbox, 1, 10);
                fillB.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        idnum = Integer.parseInt(tID.getText());
                        // String  idStr= tID.getText();
                        String str1, str2, str3, str4, str5, str6, str7, strd, strm, stry;
                        str1 = tFiName.getText();
                        str2 = tFaName.getText();
                        str3 = tGname.getText();
                        strd = cDay.getValue().toString();
                        strm = cMonth.getValue().toString();
                        stry = cYear.getValue().toString();
                        str4 = strd + "/" + strm + "/" + stry;
                        str5 = tWereda.getText();
                        str6 = tKetema.getText();
                        str7 = tKebele.getText();
                        if (str1.equals("") || str2.equals("") || str3.equals("") || str4.equals("") || str5.equals("") || str6.equals("") || str7.equals("")) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Please Fill All information space is not Allowed");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else if (!ValidateInput.validateFirstName(str1) && !ValidateInput.validateSecondName(str1)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in FirstName Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else if (!ValidateInput.validateFirstName(str2) && !ValidateInput.validateSecondName(str2)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in FatherName Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else if (!ValidateInput.validateFirstName(str3) && !ValidateInput.validateSecondName(str3)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in GFatherName Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else if (!ValidateInput.validateYear(stry)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in Year Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();
                        } else if (!ValidateInput.validateMonth(strm)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in Month Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();
                        } else if (!ValidateInput.validateDay(strd)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in Day Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();
                        } else if (!ValidateInput.validateFirstName(str5) && !ValidateInput.validateSecondName(str5)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in Wereda Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else if (!ValidateInput.validateFirstName(str6) && !ValidateInput.validateSecondName(str6)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in Ketema Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else if (!ValidateInput.validateKebele(str7)) {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Incorrect input in Kebele Field");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else {

                            DatabaseClass.addNameBirth(idnum, str1, str2, str3, str4, str5, str6, str7);
                            nextB.setDisable(false);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Data is sucessefully enterd");
                            alert.setHeaderText("Time is");
                            alert.showAndWait();
                            nextB.setDisable(false);

                        }
                    }
                });
                nextB.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        gridP1.setPadding(new Insets(10, 10, 10, 10));
                        gridP1.setVgap(10);
                        gridP1.setHgap(15);
                        gridP.getChildren().clear();
                        // gridP2.getChildren().clear();
                        Button fillB1 = new Button("ሙላ");
                        fillB1.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                        fillB1.setPrefWidth(100);
                        fillB1.setStyle("-fx-base:#98fb98;");
                        Button backB = new Button("መልስ");
                        backB.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                        backB.setPrefWidth(100);
                        backB.setStyle("-fx-base:#98fb98;");
                        Button nextB1 = new Button("ቀጣይ");
                        nextB1.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                        nextB1.setPrefWidth(100);
                        // nextB1.setDisable(true);
                        nextB1.setStyle("-fx-base:#98fb98;");
                        HBox hbox1 = new HBox();
                        hbox1.setSpacing(20);
                        hbox1.getChildren().addAll(fillB1, backB, nextB1);
                        gridP1.add(uploadLink1, 1, 11);
                        gridP1.add(hbox1, 1, 10);
                        gridP1.add(labelAwraja, 0, 7);
                        gridP1.add(tAwraja, 1, 7);
                        gridP1.add(labelHBK, 0, 8);
                        gridP1.add(tHBK, 1, 8);
                        gridP1.add(labelKGM, 0, 6);
                        gridP1.add(tKGM, 1, 6);
                        gridP1.add(labelSEdu, 0, 5);
                        gridP1.add(tSEdu, 1, 5);
                        gridP1.add(labelMKY, 0, 4);
                        gridP1.add(tMKY, 1, 4);
                        gridP1.add(tMK, 1, 3);
                        gridP1.add(labelMK, 0, 3);
                        gridP1.add(labelBK, 0, 2);
                        gridP1.add(tBK, 1, 2);
                        gridP1.add(tSimeK, 1, 1);
                        gridP1.add(labelSimeK, 0, 1);
                        fillB1.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent eve) {
                                idnum = Integer.parseInt(tID.getText());
                                // String  idStr= tID.getText();

                                String str8, str9, str10, str11, str12, str13, str14, str15;
                                str8 = tSimeK.getText();
                                str9 = tBK.getText();
                                str10 = tMK.getText();
                                str11 = tMKY.getText();
                                str12 = tSEdu.getText();
                                str13 = tKGM.getText();
                                str14 = tAwraja.getText();
                                str15 = tHBK.getText();
                                DatabaseClass.addKirstinaTable(idnum, str8, str9, str10, str11, str12, str13, str14, str15);
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("መረጃ መንገድ");
                                alert.setContentText("Data is sucessefully enterd");
                                alert.setHeaderText("Time is");
                                alert.showAndWait();
                                nextB1.setDisable(false);

                            }
                        });
                        border.setCenter(gridP1);
                        backB.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent eve) {
                                gridP1.getChildren().clear();
                                gridP.add(labelKebele, 0, 9);
                                gridP.add(tKebele, 1, 9);
                                gridP.add(labelKetema, 0, 8);
                                gridP.add(tKetema, 1, 8);
                                gridP.add(labelWereda, 0, 7);
                                gridP.add(tWereda, 1, 7);
                                gridP.add(hboxDay, 1, 6);
                                gridP.add(hboxMonth, 1, 5);
                                gridP.add(hboxYear, 1, 4);
                                gridP.add(labelBirth, 0, 4);
                                gridP.add(fullID, 0, 3);
                                gridP.add(tID, 1, 3);
                                gridP.add(tGname, 1, 2);
                                gridP.add(tFaName, 1, 1);
                                gridP.add(tFiName, 1, 0);
                                gridP.add(fullName, 0, 0);
                                // nextB.setDisable(true);
                                gridP.add(hbox, 1, 10);
                                // gridP.add(uploadLink, 2, 0);
                                gridP.add(uploadLink, 1, 11);
                                border.setCenter(gridP);

                            }
                        });
                        nextB1.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent eve) {
                                gridP2.setPadding(new Insets(10, 10, 10, 10));
                                gridP2.setVgap(10);
                                gridP2.setHgap(15);
                                gridP1.getChildren().clear();

                                gridP2.add(hboxHSibketW1, 2, 3);
                                gridP2.add(hboxHSibket1, 1, 3);
                                gridP2.add(hboxSuName1, 0, 3);
                                gridP2.add(hboxHSibketW, 2, 2);
                                gridP2.add(hboxHSibket, 1, 2);
                                gridP2.add(hboxSuName, 0, 2);
                                gridP2.add(labelSuChu, 0, 1);

                                gridP2.add(hboxUni, 0, 4);
                                gridP2.add(labelUniLife, 0, 5);
                                gridP2.add(hboxUniLife, 1, 5);
                                gridP2.add(hboxUniLifeUntile, 1, 6);
                                gridP2.add(labelUniLifeUntile, 0, 6);
                                gridP2.add(hboxUniHS, 0, 7);
                                gridP2.add(labelUniBK, 0, 8);
                                gridP2.add(tUniBK, 1, 8);
                                gridP2.add(labelUniSC, 0, 9);
                                gridP2.add(tUniSC, 1, 9);
                                gridP2.add(hboxMuya, 0, 10);

                                Button fillB2 = new Button("ሙላ");
                                fillB2.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                fillB2.setPrefWidth(100);
                                fillB2.setStyle("-fx-base:#98fb98;");
                                Button backB1 = new Button("መልስ");
                                backB1.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                backB1.setPrefWidth(100);
                                backB1.setStyle("-fx-base:#98fb98;");
                                Button nextB2 = new Button("ቀጣይ");
                                nextB2.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                nextB2.setPrefWidth(100);
                                //  nextB2.setDisable(true);
                                nextB2.setStyle("-fx-base:#98fb98;");
                                HBox hbox2 = new HBox();
                                hbox2.setSpacing(20);
                                hbox2.getChildren().addAll(fillB2, backB1, nextB2);
                                fillB2.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent eve) {
                                        idnum = Integer.parseInt(tID.getText());
                                        // String  idStr= tID.getText();

                                        String str16, str17, str18, str19, str20, str21, str22, str23;
                                        str16 = tSuName.getText() + "," + tHSibket.getText() + "," + tHSibketW.getText();
                                        str17 = tSuName1.getText() + "," + tHSibket1.getText() + "," + tHSibketW1.getText();
                                        str18 = tUniName.getText();
                                        str19 = tUniLife.getText() + "-" + tUniLifeUntile.getText() + " " + labelUniLifeBY.getText();
                                        str20 = tUniHS.getText();
                                        str21 = tUniBK.getText();
                                        str22 = tUniSC.getText();
                                        str23 = cMuya.getValue().toString();
                                        DatabaseClass.addSenbetBKTable(idnum, str16, str17, str18, str19, str20, str21, str22, str23);
                                        Alert alert = new Alert(AlertType.INFORMATION);
                                        alert.setTitle("መረጃ መንገድ");
                                        alert.setContentText("Data is sucessefully enterd");
                                        alert.setHeaderText("Time is");
                                        alert.showAndWait();
                                        nextB2.setDisable(false);

                                    }
                                });
                                gridP2.add(hbox2, 1, 12);
                                gridP2.add(uploadLink2, 1, 13);
                                border.setCenter(gridP2);

                                backB1.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent eve) {

                                        gridP2.getChildren().clear();
                                        //  nextB1.setDisable(true);
                                        gridP1.add(uploadLink1, 1, 11);
                                        gridP1.add(hbox1, 1, 10);
                                        gridP1.add(labelAwraja, 0, 7);
                                        gridP1.add(tAwraja, 1, 7);
                                        gridP1.add(labelHBK, 0, 8);
                                        gridP1.add(tHBK, 1, 8);
                                        gridP1.add(labelKGM, 0, 6);
                                        gridP1.add(tKGM, 1, 6);
                                        gridP1.add(labelSEdu, 0, 5);
                                        gridP1.add(tSEdu, 1, 5);
                                        gridP1.add(labelMKY, 0, 4);
                                        gridP1.add(tMKY, 1, 4);
                                        gridP1.add(tMK, 1, 3);
                                        gridP1.add(labelMK, 0, 3);
                                        gridP1.add(labelBK, 0, 2);
                                        gridP1.add(tBK, 1, 2);
                                        gridP1.add(tSimeK, 1, 1);
                                        gridP1.add(labelSimeK, 0, 1);
                                        border.setCenter(gridP1);
                                    }
                                });

                                nextB2.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent eve) {
                                        gridP2.getChildren().clear();
                                        gridP3.setPadding(new Insets(10, 10, 10, 10));
                                        gridP3.setVgap(10);
                                        gridP3.setHgap(15);

                                        gridP3.add(labelJobCity, 0, 0);
                                        gridP3.add(labelJobHS, 0, 1);
                                        gridP3.add(tJobHS, 1, 1);
                                        gridP3.add(labelJobZone, 0, 2);
                                        gridP3.add(tJobZone, 1, 2);
                                        gridP3.add(labelJobWereda, 0, 3);
                                        gridP3.add(tJobWereda, 1, 3);

                                        gridP3.add(labelJobKetema, 0, 4);
                                        gridP3.add(tJobKetema, 1, 4);
                                        gridP3.add(labelJobKebele, 0, 5);
                                        gridP3.add(tJobKebele, 1, 5);
                                        gridP3.add(labelJobGebere, 0, 6);
                                        gridP3.add(tJobGebere, 1, 6);
                                        gridP3.add(labelJobType, 0, 7);
                                        gridP3.add(tJobType, 1, 7);
                                        gridP3.add(labelJobHouse, 0, 8);
                                        gridP3.add(tJobHouse, 1, 8);
                                        gridP3.add(labelJobPhone, 0, 9);
                                        gridP3.add(tJobPhone, 1, 9);

                                        Button fillB3 = new Button("ሙላ");
                                        fillB3.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

                                        Button backB2 = new Button("መልስ");
                                        backB2.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

                                        Button nextB3 = new Button("ቀጣይ");
                                        nextB3.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                        fillB3.setPrefWidth(100);
                                        // nextB3.setDisable(true);
                                        fillB3.setStyle("-fx-base:#98fb98;");
                                        backB2.setPrefWidth(100);
                                        backB2.setStyle("-fx-base:#98fb98;");
                                        nextB3.setPrefWidth(100);
                                        nextB3.setStyle("-fx-base:#98fb98;");
                                        HBox hbox3 = new HBox();
                                        hbox3.setSpacing(20);
                                        hbox3.getChildren().addAll(fillB3, backB2, nextB3);
                                        gridP3.add(hbox3, 1, 11);
                                        gridP3.add(uploadLink3, 1, 12);
                                        fillB3.setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent eve) {
                                                idnum = Integer.parseInt(tID.getText());
                                                // String  idStr= tID.getText();
                                                String str24, str25, str26, str27, str28, str29, str30, str31, str32;
                                                str24 = tJobHS.getText();
                                                str25 = tJobZone.getText();
                                                str26 = tJobWereda.getText();
                                                str27 = tJobKetema.getText();
                                                str28 = tJobKebele.getText();
                                                str29 = tJobGebere.getText();
                                                str30 = tJobType.getText();
                                                str31 = tJobHouse.getText();
                                                str32 = tJobPhone.getText();
                                                DatabaseClass.addCurrentJobTable(idnum, str24, str25, str26, str27, str28, str29, str30, str31, str32);
                                                Alert alert = new Alert(AlertType.INFORMATION);
                                                alert.setTitle("መረጃ መንገድ");
                                                alert.setContentText("Data is sucessefully enterd");
                                                alert.setHeaderText("Time is");
                                                alert.showAndWait();
                                                nextB3.setDisable(false);
                                            }
                                        });
                                        border.setCenter(gridP3);

                                        nextB3.setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent eve) {
                                                gridP3.getChildren().clear();
                                                gridP4.setPadding(new Insets(10, 10, 10, 10));
                                                gridP4.setVgap(10);
                                                gridP4.setHgap(15);
                                                gridP4.add(labelAdHou, 0, 0);
                                                gridP4.add(labelAdHouKetema, 0, 1);
                                                gridP4.add(tAdHouKetema, 1, 1);
                                                gridP4.add(labelAdHouKefitegna, 0, 2);
                                                gridP4.add(tAdHouKefitegna, 1, 2);
                                                gridP4.add(labelAdHouKebele, 0, 3);
                                                gridP4.add(tAdHouKebele, 1, 3);
                                                gridP4.add(labelAdHouNum, 0, 4);
                                                gridP4.add(tAdHouNum, 1, 4);
                                                gridP4.add(labelAdHouPhone, 0, 5);
                                                gridP4.add(tAdHouPhone, 1, 5);
                                                gridP4.add(labelMobile, 0, 6);
                                                gridP4.add(tMobile, 1, 6);
                                                gridP4.add(labelMetedaderiya, 0, 7);
                                                gridP4.add(cAd, 1, 7);
                                                gridP4.add(labelSelf, 0, 8);
                                                gridP4.add(tLiyuMuya, 1, 8);
                                                gridP4.add(labelEduLevel, 0, 9);
                                                gridP4.add(tEduLevel, 1, 9);
                                                Button fillB4 = new Button("ሙላ");
                                                fillB4.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                Button backB3 = new Button("መልስ");
                                                backB3.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                Button nextB4 = new Button("ቀጣይ");
                                                nextB4.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                fillB4.setPrefWidth(100);
                                                //   nextB4.setDisable(true);
                                                fillB4.setStyle("-fx-base:#98fb98;");
                                                backB3.setPrefWidth(100);
                                                backB3.setStyle("-fx-base:#98fb98;");
                                                nextB4.setPrefWidth(100);
                                                nextB4.setStyle("-fx-base:#98fb98;");
                                                HBox hbox4 = new HBox();
                                                hbox4.setSpacing(20);
                                                hbox4.getChildren().addAll(fillB4, backB3, nextB4);
                                                gridP4.add(hbox4, 1, 11);
                                                gridP4.add(uploadLink4, 1, 12);
                                                fillB4.setOnAction(new EventHandler<ActionEvent>() {
                                                    public void handle(ActionEvent eve) {
                                                        // tID1.setText(rr.tID.getText());
                                                        idnum1 = Integer.parseInt(tID.getText());
                                                        String str1, str2, str3, str4, str5, str6, str7, str8;
                                                        str1 = tAdHouKetema.getText();
                                                        str2 = tAdHouKefitegna.getText();
                                                        str3 = tAdHouKebele.getText();
                                                        str4 = tAdHouNum.getText();
                                                        str5 = tAdHouPhone.getText();
                                                        str6 = tMobile.getText();
                                                        str7 = cAd.getValue().toString() + "(" + tLiyuMuya.getText() + ")";
                                                        str8 = tEduLevel.getText();
                                                        DatabaseClass.addLiveAddressTable(idnum1, str1, str2, str3, str4, str5, str6, str7, str8);
                                                        Alert alert = new Alert(AlertType.INFORMATION);
                                                        alert.setTitle("መረጃ መንገድ");
                                                        alert.setContentText("Data is sucessefully enterd");
                                                        alert.setHeaderText("Time is");
                                                        alert.showAndWait();
                                                        nextB4.setDisable(false);

                                                    }
                                                });

                                                border.setCenter(gridP4);

                                                backB3.setOnAction(new EventHandler<ActionEvent>() {
                                                    public void handle(ActionEvent eve) {
                                                        gridP4.getChildren().clear();

                                                        gridP3.add(labelJobCity, 0, 0);
                                                        gridP3.add(labelJobHS, 0, 1);
                                                        gridP3.add(tJobHS, 1, 1);
                                                        gridP3.add(labelJobZone, 0, 2);
                                                        gridP3.add(tJobZone, 1, 2);
                                                        gridP3.add(labelJobWereda, 0, 3);
                                                        gridP3.add(tJobWereda, 1, 3);

                                                        gridP3.add(labelJobKetema, 0, 4);
                                                        gridP3.add(tJobKetema, 1, 4);
                                                        gridP3.add(labelJobKebele, 0, 5);
                                                        gridP3.add(tJobKebele, 1, 5);
                                                        gridP3.add(labelJobGebere, 0, 6);
                                                        gridP3.add(tJobGebere, 1, 6);
                                                        gridP3.add(labelJobType, 0, 7);
                                                        gridP3.add(tJobType, 1, 7);
                                                        gridP3.add(labelJobHouse, 0, 8);
                                                        gridP3.add(tJobHouse, 1, 8);
                                                        gridP3.add(labelJobPhone, 0, 9);
                                                        gridP3.add(tJobPhone, 1, 9);
                                                        //   nextB3.setDisable(true);
                                                        gridP3.add(hbox3, 1, 11);
                                                        gridP3.add(uploadLink3, 1, 12);
                                                        border.setCenter(gridP3);
                                                    }
                                                });
                                                nextB4.setOnAction(new EventHandler<ActionEvent>() {
                                                    public void handle(ActionEvent eve) {
                                                        gridP4.getChildren().clear();
                                                        gridP5.setPadding(new Insets(10, 10, 10, 10));
                                                        gridP5.setVgap(10);
                                                        gridP5.setHgap(15);

                                                        gridP5.add(hboxKale, 0, 0);
                                                        gridP5.add(labelKihinetKale, 0, 1);
                                                        gridP5.add(tKihinetKale, 1, 1);
                                                        gridP5.add(labelSunibetKale, 0, 2);
                                                        gridP5.add(tSunibetKale, 1, 2);
                                                        gridP5.add(labelSebekaKale, 0, 3);
                                                        gridP5.add(tSebekaKale, 1, 3);
                                                        gridP5.add(labelSebekaIDKale, 0, 4);
                                                        gridP5.add(tSebekaIDKale, 1, 4);
                                                        gridP5.add(labelSpritFather, 0, 5);
                                                        gridP5.add(tSpritFather, 1, 5);
                                                        gridP5.add(labelLangSkill, 0, 6);
                                                        gridP5.add(hboxLangSkillA, 0, 7);
                                                        gridP5.add(hboxLangSkillA1, 0, 8);
                                                        gridP5.add(hboxLangSkillA2, 0, 9);
                                                        //gridP5.add(hboxService, 0, 10);
                                                        gridP5.add(labelOtherSkill, 0, 10);
                                                        gridP5.add(tOtherSkill, 1, 10);
                                                        Button fillB5 = new Button("ሙላ");
                                                        fillB5.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                        Button backB4 = new Button("መልስ");
                                                        backB4.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                        Button nextB5 = new Button("ቀጣይ");
                                                        nextB5.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                        fillB5.setPrefWidth(100);
                                                        fillB5.setStyle("-fx-base:#98fb98;");
                                                        backB4.setPrefWidth(100);
                                                        backB4.setStyle("-fx-base:#98fb98;");
                                                        nextB5.setPrefWidth(100);
                                                        nextB5.setStyle("-fx-base:#98fb98;");
                                                        //   nextB5.setDisable(true);
                                                        HBox hbox5 = new HBox();
                                                        hbox5.setSpacing(20);
                                                        hbox5.getChildren().addAll(fillB5, backB4, nextB5);
                                                        gridP5.add(hbox5, 1, 11);
                                                        gridP5.add(uploadLink5, 1, 12);
                                                        fillB5.setOnAction(new EventHandler<ActionEvent>() {
                                                            public void handle(ActionEvent eve) {
                                                                // tID1.setText(rr.tID.getText());
                                                                idnum1 = Integer.parseInt(tID.getText());

                                                                String str16, str9, str10, str11, str12, str13, str14, str15, str17;
                                                                str9 = tKihinetKale.getText();
                                                                str10 = tSunibetKale.getText();
                                                                str11 = tSebekaKale.getText();
                                                                str12 = tSebekaIDKale.getText();
                                                                str13 = tSpritFather.getText();
                                                                str14 = tLangSkillA.getText() + "(" + cSpeak.getValue().toString() + "," + cListen.getValue().toString() + "," + cWrite.getValue().toString() + "," + cRead.getValue().toString() + ")";
                                                                str15 = tLangSkillA1.getText() + "(" + cSpeak1.getValue().toString() + "," + cListen1.getValue().toString() + "," + cWrite1.getValue().toString() + "," + cRead1.getValue().toString() + ")";
                                                                str16 = tLangSkillA2.getText() + "(" + cSpeak2.getValue().toString() + "," + cListen2.getValue().toString() + "," + cWrite2.getValue().toString() + "," + cRead2.getValue().toString() + ")";
                                                                str17 = tOtherSkill.getText();
                                                                String str;
                                                                str = tBkName.getText();
                                                                DatabaseClass.addCurrentServiceTablet(idnum1, str, str9, str10, str11, str12, str13, str14, str15, str16, str17);
                                                                Alert alert = new Alert(AlertType.INFORMATION);
                                                                alert.setTitle("መረጃ መንገድ");
                                                                alert.setContentText("Data is sucessefully enterd");
                                                                alert.setHeaderText("Time is");
                                                                alert.showAndWait();
                                                                nextB5.setDisable(false);
                                                            }
                                                        });
                                                        border.setCenter(gridP5);

                                                        backB4.setOnAction(new EventHandler<ActionEvent>() {
                                                            public void handle(ActionEvent eve) {
                                                                gridP5.getChildren().clear();
                                                                gridP4.add(labelAdHou, 0, 0);
                                                                gridP4.add(labelAdHouKetema, 0, 1);
                                                                gridP4.add(tAdHouKetema, 1, 1);
                                                                gridP4.add(labelAdHouKefitegna, 0, 2);
                                                                gridP4.add(tAdHouKefitegna, 1, 2);
                                                                gridP4.add(labelAdHouKebele, 0, 3);
                                                                gridP4.add(tAdHouKebele, 1, 3);
                                                                gridP4.add(labelAdHouNum, 0, 4);
                                                                gridP4.add(tAdHouNum, 1, 4);
                                                                gridP4.add(labelAdHouPhone, 0, 5);
                                                                gridP4.add(tAdHouPhone, 1, 5);
                                                                gridP4.add(labelMobile, 0, 6);
                                                                gridP4.add(tMobile, 1, 6);
                                                                gridP4.add(labelMetedaderiya, 0, 7);
                                                                gridP4.add(cAd, 1, 7);
                                                                gridP4.add(labelSelf, 0, 8);
                                                                gridP4.add(tLiyuMuya, 1, 8);
                                                                gridP4.add(labelEduLevel, 0, 9);
                                                                gridP4.add(tEduLevel, 1, 9);
                                                                //     nextB4.setDisable(true);
                                                                gridP4.add(hbox4, 1, 11);
                                                                gridP4.add(uploadLink4, 1, 12);
                                                                border.setCenter(gridP4);
                                                            }
                                                        });
                                                        nextB5.setOnAction(new EventHandler<ActionEvent>() {
                                                            public void handle(ActionEvent eve) {
                                                                gridP5.getChildren().clear();
                                                                gridP6.setPadding(new Insets(10, 10, 10, 10));
                                                                gridP6.setVgap(10);
                                                                gridP6.setHgap(15);
                                                                gridP6.add(labelRep, 0, 0);
                                                                gridP6.add(labelRepName, 0, 1);
                                                                gridP6.add(tRepName, 1, 1);
                                                                gridP6.add(tRepName2, 1, 2);
                                                                gridP6.add(tRepName3, 1, 3);
                                                                gridP6.add(labelAdHouKetemaR, 0, 4);
                                                                gridP6.add(tAdHouKetemaR, 1, 4);
                                                                gridP6.add(labelAdHouKefitegnaR, 0, 5);
                                                                gridP6.add(tAdHouKefitegnaR, 1, 5);
                                                                gridP6.add(labelAdHouKebeleR, 0, 6);
                                                                gridP6.add(tAdHouKebeleR, 1, 6);
                                                                gridP6.add(labelAdHouNumR, 0, 7);
                                                                gridP6.add(tAdHouNumR, 1, 7);
                                                                gridP6.add(labelAdHouPhoneR, 0, 8);
                                                                gridP6.add(tAdHouPhoneR, 1, 8);
                                                                gridP6.add(labelMobileR, 0, 9);
                                                                gridP6.add(tMobileR, 1, 9);

                                                                gridP6.add(hboxPhoto, 2, 0);
                                                                gridP6.add(imageView, 2, 1);

                                                                HBox hPhoto = new HBox();
                                                                hPhoto.setAlignment(Pos.CENTER);
                                                                hPhoto.setSpacing(10);
                                                                Button fillPhoto = new Button("ሙላ");
                                                                fillPhoto.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

                                                                //nextB6.setDisable(true);
                                                                Button changePhoto = new Button("ቀይር");
                                                                changePhoto.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                                hPhoto.getChildren().addAll(fillPhoto, changePhoto);
                                                                gridP6.add(hPhoto, 2, 7);
                                                                fillPhoto.setOnAction(new EventHandler<ActionEvent>() {
                                                                    public void handle(ActionEvent eve) {
                                                                        TextInputDialog alert = new TextInputDialog("");
                                                                        alert.setTitle("ማረጋግጫ ሳጥን");
                                                                        alert.setHeaderText("መለያ ቁጥር ያስገቡ");
                                                                        DialogPane dialog = alert.getDialogPane();

                                                                        dialog.setStyle("-fx-background-color:greenyellow;");
                                                                        dialog.getStyleClass().remove("alert");
                                                                        GridPane gridS = (GridPane) dialog.lookup(".header-panel");
                                                                        gridS.setStyle("-fx-background-color: cadetblue;-fx-font-family:\"Nyala\";");
                                                                        //dialog.lookup(".label.content").setStyle("-fx-font-family:\"Nyala\";");

                                                                        Optional<String> res = alert.showAndWait();
                                                                        if (res.isPresent()) {
                                                                            addPhoto(res.get());
                                                                        }

                                                                    }
                                                                });
                                                                Button fillB6 = new Button("ሙላ");
                                                                fillB6.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                                //nextB6.setDisable(true);
                                                                Button backB5 = new Button("መልስ");
                                                                backB5.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                                                                fillB6.setPrefWidth(100);
                                                                fillB6.setStyle("-fx-base:#98fb98;");
                                                                backB5.setPrefWidth(100);
                                                                backB5.setStyle("-fx-base:#98fb98;");

                                                                HBox hbox6 = new HBox();
                                                                hbox6.setSpacing(20);
                                                                hbox6.getChildren().addAll(fillB6, backB5);
                                                                gridP6.add(hbox6, 1, 11);
                                                                gridP6.add(uploadLink6, 1, 12);
                                                                fillB6.setOnAction(new EventHandler<ActionEvent>() {
                                                                    public void handle(ActionEvent eve) {
                                                                        // tID1.setText(rr.tID.getText());
                                                                        idnum1 = Integer.parseInt(tID.getText());

                                                                        String stra, strb, strc, strd, stre, strf, strg, strh, stri;
                                                                        stra = tRepName.getText();
                                                                        strb = tRepName2.getText();
                                                                        strc = tRepName3.getText();
                                                                        strd = tAdHouKetemaR.getText();
                                                                        stre = tAdHouKefitegnaR.getText();
                                                                        strf = tAdHouKebeleR.getText();
                                                                        strg = tAdHouNumR.getText();
                                                                        strh = tAdHouPhoneR.getText();
                                                                        stri = tMobileR.getText();
                                                                        DatabaseClass.addKiribTeteriTable(idnum1, stra, strb, strc, strd, stre, strf, strg, strh, stri);

                                                                        Alert alert = new Alert(AlertType.INFORMATION);
                                                                        alert.setTitle("መረጃ መንገድ");
                                                                        alert.setContentText("Data is sucessefully enterd");
                                                                        alert.setHeaderText("Time is");
                                                                        alert.showAndWait();

                                                                    }
                                                                });
                                                                border.setCenter(gridP6);

                                                                backB5.setOnAction(new EventHandler<ActionEvent>() {
                                                                    public void handle(ActionEvent eve) {
                                                                        gridP6.getChildren().clear();
                                                                        gridP5.add(hboxKale, 0, 0);
                                                                        gridP5.add(labelKihinetKale, 0, 1);
                                                                        gridP5.add(tKihinetKale, 1, 1);
                                                                        gridP5.add(labelSunibetKale, 0, 2);
                                                                        gridP5.add(tSunibetKale, 1, 2);
                                                                        gridP5.add(labelSebekaKale, 0, 3);
                                                                        gridP5.add(tSebekaKale, 1, 3);
                                                                        gridP5.add(labelSebekaIDKale, 0, 4);
                                                                        gridP5.add(tSebekaIDKale, 1, 4);
                                                                        gridP5.add(labelSpritFather, 0, 5);
                                                                        gridP5.add(tSpritFather, 1, 5);
                                                                        gridP5.add(labelLangSkill, 0, 6);
                                                                        gridP5.add(hboxLangSkillA, 0, 7);
                                                                        gridP5.add(hboxLangSkillA1, 0, 8);
                                                                        gridP5.add(hboxLangSkillA2, 0, 9);
                                                                        gridP5.add(hboxService, 0, 10);
                                                                        gridP5.add(labelOtherSkill, 0, 11);
                                                                        gridP5.add(tOtherSkill, 1, 11);
                                                                        //  nextB5.setDisable(true);
                                                                        gridP5.add(hbox5, 1, 13);
                                                                        gridP5.add(uploadLink5, 1, 14);
                                                                        border.setCenter(gridP5);
                                                                    }
                                                                });
                                                            }
                                                        });

                                                    }
                                                });

                                            }
                                        });

                                        backB2.setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent eve) {
                                                gridP3.getChildren().clear();
                                                gridP2.add(hboxHSibketW1, 2, 3);
                                                gridP2.add(hboxHSibket1, 1, 3);
                                                gridP2.add(hboxSuName1, 0, 3);
                                                gridP2.add(hboxHSibketW, 2, 2);
                                                gridP2.add(hboxHSibket, 1, 2);
                                                gridP2.add(hboxSuName, 0, 2);
                                                gridP2.add(labelSuChu, 0, 1);

                                                gridP2.add(hboxUni, 0, 4);
                                                gridP2.add(labelUniLife, 0, 5);
                                                gridP2.add(hboxUniLife, 1, 5);
                                                gridP2.add(hboxUniLifeUntile, 1, 6);
                                                gridP2.add(labelUniLifeUntile, 0, 6);
                                                gridP2.add(hboxUniHS, 0, 7);
                                                gridP2.add(labelUniBK, 0, 8);
                                                gridP2.add(tUniBK, 1, 8);
                                                gridP2.add(labelUniSC, 0, 9);
                                                gridP2.add(tUniSC, 1, 9);
                                                gridP2.add(hboxMuya, 0, 10);
                                                gridP2.add(hbox2, 1, 12);
                                                gridP2.add(uploadLink2, 1, 13);
                                                // nextB2.setDisable(true);
                                                border.setCenter(gridP2);
                                            }
                                        });

                                    }
                                });
                            }
                        });
                    }
                });
                // gridP1.getChildren().clear();
                border.setCenter(gridP);

                // new RegisterForm().registerForm();
            }
        });

        noteRadioData.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                gridP.getChildren().clear();
                gridP1.getChildren().clear();
                gridP2.getChildren().clear();
                gridP3.getChildren().clear();
                gridP4.getChildren().clear();
                gridP5.getChildren().clear();
                gridP6.getChildren().clear();
                gridP7.getChildren().clear();
                gridP8.setPadding(new Insets(20, 20, 20, 20));
                gridP8.setVgap(10);
                gridP8.setHgap(10);

                VBox hboxTitle = new VBox();
                hboxTitle.setSpacing(15);
                hboxTitle.setAlignment(Pos.CENTER);
                hboxTitle.setPadding(new Insets(7, 7, 7, 7));
                hboxTitle.setId("hbt");

                Label labelTitle = new Label("የዕለቱን ማስታወሻ መመዝገቢያ ስፍራ");
                labelTitle.setFont(Font.font("Nyala", FontPosture.REGULAR, 23));
                labelTitle.setTextFill(Color.BLUE);

                Label labelDate = new Label("ቀን");
                labelDate.setFont(Font.font("Nyala", FontPosture.REGULAR, 23));
                labelDate.setTextFill(Color.BLUE);

                Button butFeS = new Button("መዝግብ");
                butFeS.setTextFill(Color.BLUE);
                butFeS.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                //butFeS.setStyle("-fx-text-fill: black;");
                Button butMaR = new Button("አንብብ");
                butMaR.setTextFill(Color.BLUE);
                butMaR.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                // butMaR.setStyle("-fx-text-fill: black;");
                Button butFuC = new Button("አስተካክል");
                butFuC.setTextFill(Color.BLUE);
                butFuC.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                //butFuC.setStyle("-fx-text-fill: black;");
                // gridPane2.add(butServiceSearch, 0, 3);
                HBox hBoxRadioS = new HBox();
                hBoxRadioS.setSpacing(10);
                GridPane.setColumnSpan(hBoxRadioS, 10);
                hBoxRadioS.setAlignment(Pos.BASELINE_LEFT);
                hBoxRadioS.setId("hBox1");
                hBoxRadioS.setPadding(new Insets(10, 10, 10, 10));
                tIDN = new TextField();
                tIDN.setMaxWidth(150);
                tTitle = new TextField();
                tTitle.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                tTitle.setMaxWidth(200);

                Label labelTitle2 = new Label("ርዕስ");
                labelTitle2.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                labelTitle2.setTextFill(Color.BLUE);
                HBox hBoxRadioS2 = new HBox();
                hBoxRadioS2.setSpacing(10);
                HBox hBoxRadioS1 = new HBox();
                hBoxRadioS1.setSpacing(220);
                GridPane.setColumnSpan(hBoxRadioS1, 10);
                hBoxRadioS1.setAlignment(Pos.BASELINE_LEFT);
                hBoxRadioS1.setId("hBox1");
                hBoxRadioS1.setPadding(new Insets(5, 5, 5, 5));
                hBoxRadioS2.getChildren().addAll(labelTitle2, tTitle);
                hBoxRadioS1.getChildren().addAll(hBoxRadioS2);

                hBoxRadioS.getChildren().addAll(labelDate, tIDN, butFeS, butMaR, butFuC);

                hboxTitle.getChildren().addAll(labelTitle, hBoxRadioS1);
                GridPane.setColumnSpan(hBoxRadioS1, 10);
                gridP8.add(hBoxRadioS1, 0, 0);
                // border.setTop(hboxTitle);

                text = new TextArea();
                text.setWrapText(true);
                text.setPrefRowCount(20);
                text.setMaxSize(550, 500);
                text.setEditable(true);
                text.setFont(Font.font("Nyala", FontPosture.REGULAR, 20));
                GridPane.setColumnSpan(text, 10);
                GridPane.setRowSpan(text, 10);
                // border.setCenter(text);
                gridP8.add(text, 0, 2);
                GridPane.setColumnSpan(hBoxRadioS, 10);
                gridP8.add(hBoxRadioS, 0, 15);
                border.setCenter(gridP8);
                butFeS.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        String str, str2, str3;
                        str = tTitle.getText();
                        str2 = text.getText();
                        str3 = tIDN.getText();
                        addNote(str3, str, str2);
                    }
                });
                butMaR.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        displayNote(eve);
                    }
                });

                butFuC.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        update(eve);
                    }
                });

            }
        });

        serviceRadioData.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                gridP.getChildren().clear();
                gridP1.getChildren().clear();
                gridP2.getChildren().clear();
                gridP3.getChildren().clear();
                gridP4.getChildren().clear();
                gridP5.getChildren().clear();
                gridP6.getChildren().clear();
                gridP8.getChildren().clear();
                //new AgeligilotClass().ageligilotForm();
                Label fullY = new Label("የመረጃ ዘመን:");
                fullY.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullY.setTextFill(Color.BLACK);

                Label fullName = new Label("የመጀመሪያ ስም:");
                fullName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullName.setTextFill(Color.BLACK);

                Label faName = new Label("የአባት ስም:");
                faName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                faName.setTextFill(Color.BLACK);

                Label gName = new Label("የአያት ስም:");
                gName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                gName.setTextFill(Color.BLACK);

                tFiNameA = new TextField();
                tFiNameA.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                tFiNameA.setMaxWidth(150);

                tFaNameA = new TextField();
                tFaNameA.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                tFaNameA.setMaxWidth(150);

                tGnameA = new TextField();
                tGnameA.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                tGnameA.setMaxWidth(150);

                Label titleService = new Label("የአገልግሎት ክፍል ይምረጡ");
                titleService.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleService.setTextFill(Color.BLACK);

                cServiceA = new ComboBox();
                cServiceA.getItems().addAll(
                        "የትምህርትና ሐዋርያዊ ክፍል",
                        "ቅዱሳን መካናት ክፍል",
                        "የልማት ክፍል",
                        "ኦዲትና ኢንስፔክሽን ክፍል",
                        "አባላትና ወረዳ ማዕከላት ማስተባበሪያ",
                        "ሙያ አገልግሎት ክፍል",
                        "ዕቅድና ዝግጅት ክፍል",
                        "የሂሳብ ክፍል",
                        "የሚዲያና ክፍል", "ጽ/ቤት ክፍል", "ግቢ ጉባዔ አስተባባሪ");
                cServiceA.setPromptText("የአገልግሎት ክፍል");
                cServiceA.setEditable(true);
                cServiceA.setId("table");
                cServiceA.setMaxWidth(150);

                Label titleBatch = new Label("የገቡበት ዘመን");
                titleBatch.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleBatch.setTextFill(Color.BLACK);
                Label titleResponse = new Label("ኃላፊነት");
                titleResponse.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleResponse.setTextFill(Color.BLACK);

                tResponse = new ComboBox();
                tResponse.getItems().addAll(
                        "ሰብሳቢ",
                        "ም/ሰብሳቢ",
                        "ፀሐፊ",
                        "ገንዘብ ያዢ",
                        "አባል");
                tResponse.setPromptText("ኃላፊነት");
                tResponse.setEditable(true);
                tResponse.setId("table");
                tResponse.setMaxWidth(150);

                cServiceY = new ComboBox();
                cServiceY.getItems().addAll(
                        "2007",
                        "2008",
                        "2009",
                        "2010",
                        "2011",
                        "2012",
                        "2013",
                        "2014",
                        "2015",
                        "2016");
                cServiceY.setPromptText("ባች");
                cServiceY.setEditable(true);
                cServiceY.setId("table");
                cServiceY.setMaxWidth(150);
                cMonthA = new ComboBox();
                cMonthA.setId("table");
                cMonthA.getItems().addAll(
                        "መስከረም",
                        "ጥቅምት",
                        "ህዳር",
                        "ታህሳስ",
                        "ጥር",
                        "የካቲት",
                        "መጋቢት",
                        "ሚያዚያ",
                        "ግንቦት", "ሰኔ", "ሐምሌ", "ነሐሴ");

                cMonthA.setPromptText("ወር");
                cMonthA.setEditable(true);
                cMonthA.setMaxWidth(150);
                cDayA = new ComboBox();
                cDayA.getItems().addAll(
                        "01",
                        "02",
                        "03",
                        "04",
                        "05",
                        "06",
                        "07",
                        "08",
                        "09", "10", "11", "12", "13",
                        "14",
                        "15",
                        "16",
                        "17",
                        "18",
                        "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");

                cDayA.setPromptText("ቀን");
                cDayA.setEditable(true);
                cDayA.setMaxWidth(150);
                cDayA.setId("table");

                Label titleSex = new Label("ጾታ");
                titleSex.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleSex.setTextFill(Color.BLACK);

                tTsota = new TextField();
                tTsota.setMaxWidth(150);
                tTsota.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                TextField tZemen = new TextField();
                tZemen.setMaxWidth(150);
                tZemen.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                Label fullID = new Label("መለያ ቁጥር:");
                fullID.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullID.setTextFill(Color.BLACK);
                tIDa = new TextField();
                tIDa.setMaxWidth(150);

                Label fullMo = new Label("የሞባይል ቁጥር:");
                fullMo.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullMo.setTextFill(Color.BLACK);
                tMo = new TextField();
                tMo.setMaxWidth(150);

                Button butFill = new Button("አስገባ");
                butFill.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                butFill.setStyle("-fx-text-fill: black;");

                Button butNew = new Button("አዲስ");
                butNew.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                butNew.setStyle("-fx-text-fill: black;");
                Button butSearch = new Button("ፈልግ");
                butSearch.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                butSearch.setStyle("-fx-text-fill: black;");

                Hyperlink uploadLinkA = new Hyperlink("መረጃ ከፋይል ላይ ለማስገባት ይህን ይጫኑ");
                uploadLinkA.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                uploadLinkA.setTextFill(Color.BLUE);

                HBox hBut = new HBox();
                hBut.setSpacing(12);
                hBut.setAlignment(Pos.CENTER);
                hBut.getChildren().addAll(butFill, butNew, butSearch);
                gridP7.setPadding(new Insets(20, 20, 20, 20));
                gridP7.setVgap(10);
                gridP7.setHgap(10);
                gridP7.add(fullY, 0, 0);
                gridP7.add(fullName, 0, 2);
                gridP7.add(faName, 0, 3);
                gridP7.add(gName, 0, 4);
                gridP7.add(tFiNameA, 1, 2);
                gridP7.add(tFaNameA, 1, 3);
                gridP7.add(tGnameA, 1, 4);
                gridP7.add(titleService, 0, 5);
                gridP7.add(cServiceA, 1, 5);
                gridP7.add(titleResponse, 0, 6);
                gridP7.add(tResponse, 1, 6);
                gridP7.add(titleBatch, 0, 7);

                gridP7.add(cDayA, 1, 7);
                gridP7.add(cMonthA, 1, 8);
                gridP7.add(cServiceY, 1, 0);
                gridP7.add(titleSex, 0, 9);
                gridP7.add(tTsota, 1, 9);
                gridP7.add(fullID, 0, 1);
                gridP7.add(tIDa, 1, 1);
                gridP7.add(fullMo, 0, 10);
                gridP7.add(tMo, 1, 10);
                gridP7.add(hBut, 1, 11);
                gridP7.add(uploadLinkA, 1, 12);
                uploadLinkA.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {

                        if (cServiceY.getSelectionModel().isEmpty()) {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("መረጃ መንገድ");
                            alert.setContentText("Please Fill Service Year ");
                            alert.setHeaderText(null);
                            alert.showAndWait();

                        } else {
                            String str = cServiceY.getValue().toString();
                            new JavaFxApplication1().importDataA(str);

                        }

                    }
                });

                butFill.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {

                        String strID, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10;
                        String str;

                        str1 = tFiNameA.getText();

                        str2 = tFaNameA.getText();

                        str3 = tGnameA.getText();
                        str4 = cDayA.getValue().toString();
                        str5 = cServiceA.getValue().toString();
                        str8 = tMo.getText();
                        str9 = tResponse.getValue().toString();
                        str6 = cMonthA.getValue().toString();
                        str7 = cServiceY.getValue().toString();
                        String sYear = cServiceY.getValue().toString();
                        str10 = tTsota.getText();
                        str = tIDa.getText();

                        if (str.equals("") || str1.equals("") || str2.equals("") || str3.equals("") || str4.equals("") || str5.equals("") || str6.equals("") || str7.equals("") || str8.equals("") || str9.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please Fill All information space is not Allowed");
                        } else if (!ValidateInput.validateFirstName(str1) && !ValidateInput.validateSecondName(str1)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in FirstName Field");
                        } else if (!ValidateInput.validateFirstName(str2) && !ValidateInput.validateSecondName(str2)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in FatherName Field");
                        } else if (!ValidateInput.validateFirstName(str3) && !ValidateInput.validateSecondName(str3)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in GFatherName Field");
                        } else if (!ValidateInput.validateSex(str10)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in Sex Field");
                        } else if (!ValidateInput.validateAclass(str5) && !ValidateInput.validateAclass2(str5)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in Ageligilot Field");
                        } else if (!ValidateInput.validateAclass(str9) && !ValidateInput.validateAclass2(str9)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in Halafinet Field");
                        } else if (!ValidateInput.validateYear(str7)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in Year Field");
                        } else if (!ValidateInput.validateMonth(str6)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in Month Field");
                        } else if (!ValidateInput.validateDay(str4)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in Day Field");
                        } else if (!ValidateInput.validatePhone(str8)) {
                            JOptionPane.showMessageDialog(null, "Incorrect input in Phone Field");
                        } else {
                            DatabaseClass.addATable2(sYear, str, str1, str2, str3, str10, str5, str9, str4, str6, str7, str8);
//               

                        }

                    }
                });
                butNew.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {

                        tFiNameA.setText("");
                        tFaNameA.setText("");
                        tGnameA.setText("");
                        cServiceA.setValue("የአገልግሎት ክፍል");
                        tResponse.setValue("ኃላፊነት");
                        cServiceY.setValue("ባች");
                        cDayA.setValue("ቀን");
                        cMonthA.setValue("ወር");
                        tIDa.setText("");
                        tMo.setText("");
                        tTsota.setText("");

                    }
                });
                butSearch.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        String str = cServiceY.getValue().toString();
                        DatabaseClass.openConnection(str);

                        results = stuQueries.getAgeligilot(tIDa.getText());
                        numberOfEntries = results.size();

                        if (numberOfEntries != 0) {
                            currentEntryIndex = 0;

                            studata = results.get(currentEntryIndex);

                            tFiNameA.setText(studata.getFName());
                            tFaNameA.setText(studata.getMName());
                            tGnameA.setText(studata.getLName());
                            tTsota.setText(studata.getBdate());
                            cServiceA.setValue(studata.getWoreda());
                            cDayA.setValue(studata.getCity());
                            cMonthA.setValue(studata.getKebele());
                            cServiceY.setValue(studata.getGField());
                            tResponse.setValue(studata.getResp());
                            tMo.setText(studata.getHolly());

                        }

                    }
                });

                border.setCenter(gridP7);
                // primaryStage.close();
            }
        });
        retrieveRadioData.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {
                primaryStage.close();
                new InfoDisplayClass().infoDisplay();

            }
        });
        border.setTop(vBoxTop);
        border.setId("bp2");

        //scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
    }

    public static void check(int sure) {
        if (sure == 1) {
            JOptionPane.showMessageDialog(null, "yes,Data is Inserted");
        } else {
            JOptionPane.showMessageDialog(null, "Data is not Inserted");
        }
    }

    public void addPhoto(String str) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO Pic1(መለያቁጥር,ፎቶግራፍ)VALUES(  '" + str + "',FILE_READ('" + file.getPath() + "'))");
            con.close();
            System.out.println(count + " 1 rows were inserted");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("መረጃ መንገድ");
            alert.setContentText("Photo is sucessefully enterd");

            alert.showAndWait();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void displayNote(ActionEvent evt) {

        DatabaseClass.openConnection();

        results = stuQueries.getNote(tIDN.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            tTitle.setText(studata.getNote());
            text.setText(studata.getTitle());

        }
    }

    public void addNote(String idno, String fname, String mname) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO Note1(Day,Title,Contents)VALUES(  '" + idno + "','" + fname + "','" + mname + "')");
            con.close();

            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void display(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getStatusByStuName(tID.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);
            tIDNO.setText(studata.getFName());

        }
    }

    private void update(ActionEvent evt) {
        int res = stuQueries.update(tTitle.getText(), text.getText(), tIDN.getText());
        String str1 = "መረጃው በትክክል ተመዝግቧል";
        Label lala = new Label(str1);
        lala.setFont(Font.font("Nyala", FontPosture.ITALIC, 15));
        String str = lala.getText();
        if (res == 1) {
            JOptionPane jop = new JOptionPane("");
            jop.setFont(new java.awt.Font("Nyala", 0, 36));
            JOptionPane.showMessageDialog(null, str, "Info_Page", INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }

    }

//    public static void main(String args[]) {
//        launch(args);
//    }
}
