/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 *
 * @author YOHY
 */
public class InfoDisplayClass {

    BorderPane border = new BorderPane();
    Stage stage = new Stage();
    Stage stage1 = new Stage();
    Stage stage2 = new Stage();
    Stage stage3 = new Stage();
    Stage stage4 = new Stage();
    Stage stage5 = new Stage();
    BorderPane border1 = new BorderPane();
    BorderPane border2 = new BorderPane();
    BorderPane border3 = new BorderPane();
    BorderPane border4 = new BorderPane();
    BorderPane border5 = new BorderPane();
    BorderPane border6 = new BorderPane();
    GridPane gridPane = new GridPane();
    GridPane gridPane2 = new GridPane();
    GridPane gridPane3 = new GridPane();
    GridPane gridPane4 = new GridPane();
    GridPane gridPane5 = new GridPane();
    GridPane gridPane6 = new GridPane();
    GridPane gridPane7 = new GridPane();
    GridPane gridPane8 = new GridPane();
    GridPane gridPane9 = new GridPane();
    GridPane gridPane10 = new GridPane();
    GridPane gridPane1L = new GridPane();
    GridPane gridPaneN = new GridPane();
    GridPane gridPane13 = new GridPane();
    GridPane gridPane14 = new GridPane();
    GridPane gridTra = new GridPane();
    ImageView iView, iView2, iView3;
    byte[] imgData = null;
    Blob img;
    Image imagePhoto;
    TextField tIdSearch, tNameSearch, tIDL, tMoL, tMoL1, t201, t211, t311, t411, t511, t611, t711, t811, t911, tIDNO;
    TextField tFn, tFa, tGn, tSe, tBdate, tWer, tCity, tKeb, tKir, tKbk, tKih, tKibk;
    TextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    TextField ta, tb, tc, td, te, tf, tg, th, ti, t20, t21, t31, t41, t51, t61, t71, t81, t91, t101, t111, t121, t131, t141, t151;
    VBox vBoxTop, vBoxTop1;
    // JTextPane pane;
    //JLabel jLabel;

    private ObservableList<ObservableList> data;

    private TableView tableview, tableview1;
    TableColumn col;

    static Label labelN, lFullName, lBirthTime, lKiristinaName, lKihinetName, lLangSkill, lLangSkil2, lLangSkil3, lPhoneSearch;
    static Label lHsibket, lDebir, lAwraja, lBk, lAbal, lAbal2, lTequam, lStay, lUniHsibket, lUniBk, lUniSenbet, lUniMuya;
    static Label lHsibketj, lDebirj, lAwrajaj, lBkj, lAbalj, lAbal2j, lTequamj, lStayj, lUniHsibketj;
    static Label lHsibketjt, lDebirjt, lAwrajajt, lBkjt, lAbaljt, lAbal2jt, lTequamjt, lStayjt, lUniHsibketjt;
    static Label lHsibketjtl, lDebirjtl, lAwrajajtl, lBkjtl, lAbaljtl, lAbal2jtl, lTequamjtl, lStayjtl;
    static Label lHsibketjtlc, lDebirjtlc, lAwrajajtlc, lBkjtlc, lAbaljtlc, lAbal2jtlc, lTequamjtlc, ket, ketw, ketk, lKihinet, lKirstina;
    private Members studata;
    DatabaseClass stuQueries;
    private List<Members> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    ComboBox cSelectJob;
    ComboBox cService, cServiceY, cServiceYt, cServiceYt1;
    ComboBox cServiceYtr, cServiceYtr1, cServiceYtrB, cServiceYtr1B;

    private final ObservableList<Person> data1 = FXCollections.observableArrayList();
    TableView<Person> table = new TableView<>();
    Connection con;
    PreparedStatement pst;
    JdbcConnectionPool cp;
    ResultSet rs;
    String newValue, newValue1, newValue2, colName, tableName, idString, tsotaService, tsotaBatch;
    TableColumn.CellEditEvent<Person, String> t;
    Button infoUpdate;

    public void infoDisplay() {
        stuQueries = new DatabaseClass();
        Scene scene = new Scene(border, 1200, 750);
        stage.setScene(scene);
        stage.setTitle("የመረጃ ማግኛ ፎርም");
        stage.show();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/mkproject/Image/Mesikell.jpg")));
        //stage.setFullScreen(true);
        border.setId("bp2");

        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        Label titleLabel = new Label("መረጃን በተመለከተ ማግኛ ቦታ");
        titleLabel.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 22));
        titleLabel.setTextFill(Color.BLACK);

        vBoxTop = new VBox();
        vBoxTop.setId("vBoxT");
        vBoxTop.setSpacing(10);
        vBoxTop.setAlignment(Pos.CENTER);
        vBoxTop.setPadding(new Insets(10, 10, 10, 10));

        HBox hBoxRadio = new HBox();
        hBoxRadio.setSpacing(7);
        hBoxRadio.setAlignment(Pos.BASELINE_LEFT);
        hBoxRadio.setId("hBox1");
        hBoxRadio.setPadding(new Insets(5, 5, 5, 5));
        Button butPersonal = new Button("የግለሰብ መረጃ");
        butPersonal.setMaxWidth(150);
        butPersonal.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butPersonal.setStyle("-fx-text-fill: black;");

        Button butService = new Button("የአገልግሎት አባላት መረጃ");
        butService.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butService.setStyle("-fx-text-fill: black;");

        Button butBatch = new Button("ስራ አስፈፃሚ አባላት");
        butBatch.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butBatch.setStyle("-fx-text-fill: black;");

        Button butLeave = new Button("የለቀቀ አባላት መረጃ");
        butLeave.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butLeave.setStyle("-fx-text-fill: black;");
        Button butTr = new Button("ባች ለማዘዋወር");
        butTr.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butTr.setStyle("-fx-text-fill: black;");
        Hyperlink logOut = new Hyperlink("ውጣ");
        logOut.setFont(Font.font("Nyala", FontPosture.REGULAR, 20));
        logOut.setTextFill(Color.BLUE);
        hBoxRadio.getChildren().addAll(butPersonal, butService, butLeave, butTr, logOut);
        vBoxTop.getChildren().addAll(titleLabel, hBoxRadio);

        logOut.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                stage.close();
                new WorkinigInterface().startt();
            }
        });

        butPersonal.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                personalSearch(ev);

            }
        });
        butTr.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                gridPane3.getChildren().clear();
                gridPane5.getChildren().clear();
                gridPane6.getChildren().clear();
                gridPane7.getChildren().clear();
                gridPane8.getChildren().clear();
                gridPane.getChildren().clear();
                gridPane2.getChildren().clear();
                gridPane1L.getChildren().clear();
                gridTra.setPadding(new Insets(10, 10, 10, 10));
                gridTra.setVgap(10);
                gridTra.setHgap(10);
                border.setLeft(gridPane4);
                VBox hboxTitle = new VBox();
                hboxTitle.setSpacing(15);
                hboxTitle.setAlignment(Pos.CENTER);
                hboxTitle.setPadding(new Insets(5, 5, 5, 5));
                hboxTitle.setId("hbt");

                Label labelTitle = new Label("ወደ ሚቀጥለው ዘመን ለማዘዋወር");
                labelTitle.setFont(Font.font("Nyala", FontPosture.REGULAR, 23));
                labelTitle.setTextFill(Color.BLUE);

                hboxTitle.getChildren().addAll(labelTitle);
                gridTra.add(hboxTitle, 1, 0);

                Label transferBaLable = new Label("አሻግር");
                transferBaLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                transferBaLable.setTextFill(Color.BLACK);

                Label wedeLable = new Label("ወደ");
                wedeLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                wedeLable.setTextFill(Color.BLACK);
                Label keLable = new Label("ከ");
                keLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                keLable.setTextFill(Color.BLACK);

                cServiceYtrB = new ComboBox();
                cServiceYtrB.getItems().addAll(
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
                cServiceYtrB.setPromptText("ባች");
                cServiceYtrB.setEditable(true);
                cServiceYtrB.setId("table");
                cServiceYtrB.setMaxWidth(150);

                cServiceYtr1B = new ComboBox();
                cServiceYtr1B.getItems().addAll(
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
                cServiceYtr1B.setPromptText("ባች");
                cServiceYtr1B.setEditable(true);
                cServiceYtr1B.setId("table");
                cServiceYtr1B.setMaxWidth(150);
                Button buttra = new Button("አዛውር");
                buttra.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                buttra.setStyle("-fx-text-fill: black;");
                buttra.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        String str = cServiceYtrB.getValue().toString();
                        String str1 = cServiceYtr1B.getValue().toString();
                        DatabaseClass.updateTable(str, str1);
                    }
                });

                HBox hBoxRadioS = new HBox();
                hBoxRadioS.setSpacing(5);
                GridPane.setColumnSpan(hBoxRadioS, 10);
                hBoxRadioS.setAlignment(Pos.BASELINE_LEFT);
                hBoxRadioS.setId("hBox1");
                hBoxRadioS.setPadding(new Insets(10, 10, 10, 10));
                hBoxRadioS.getChildren().addAll(transferBaLable, keLable, cServiceYtrB, wedeLable, cServiceYtr1B, buttra);
                gridTra.add(hBoxRadioS, 0, 2);
                border.setCenter(gridTra);

            }
        });

        butService.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                serviceInfo(ev);
            }
        });
        butLeave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                leaveInfo(ev);
            }
        });

        butBatch.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                batchInfo(ev);
            }
        });

        border.setTop(vBoxTop);

    }

    public void leaveInfo(ActionEvent eve) {
        gridTra.getChildren().clear();
        gridPane1L.getChildren().clear();
        border.setLeft(gridPane4);
        ToggleGroup group = new ToggleGroup();
        RadioButton fillRadioData = new RadioButton("የለቀቁ አባላትን ለመመዝገብ");
        fillRadioData.setToggleGroup(group);
        fillRadioData.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));

        RadioButton seeRadioData = new RadioButton("የለቀቁ አባላትን ዝርዝር ለማየት ");
        seeRadioData.setToggleGroup(group);
        seeRadioData.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));

        HBox hBoxRadioL = new HBox();
        hBoxRadioL.setSpacing(40);
        GridPane.setColumnSpan(hBoxRadioL, 10);
        hBoxRadioL.setAlignment(Pos.BASELINE_LEFT);
        hBoxRadioL.setId("hBox1");
        hBoxRadioL.setPadding(new Insets(10, 10, 10, 10));
        hBoxRadioL.getChildren().addAll(fillRadioData, seeRadioData);

        gridPane1L.add(hBoxRadioL, 0, 0);
        gridPane1L.setId("bp");
        gridPane1L.setVgap(5);
        gridPane1L.setHgap(15);
        // gridPane1L.setPadding(new Insets(15, 15, 15, 15));
        seeRadioData.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {
                gridPane1L.getChildren().clear();
                gridPane1L.add(hBoxRadioL, 0, 0);
                leaveSearch();

            }
        });
        fillRadioData.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {
                gridPane1L.getChildren().clear();
                gridPane1L.add(hBoxRadioL, 0, 0);
                gridPane1L.setPadding(new Insets(10, 10, 10, 10));
                Label fullY = new Label("የመረጃ ዘመን:");
                fullY.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullY.setTextFill(Color.BLACK);
                gridPane1L.add(fullY, 0, 2);
                Label fullID = new Label("መለያ ቁጥር:");
                fullID.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullID.setTextFill(Color.BLACK);
                tIDL = new TextField();
                gridPane1L.add(fullID, 0, 3);
                gridPane1L.add(tIDL, 1, 3);
                Label fullName = new Label("የመጀመሪያ ስም:");
                fullName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullName.setTextFill(Color.BLACK);
                gridPane1L.add(fullName, 0, 4);
                Label faName = new Label("የአባት ስም:");
                faName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                faName.setTextFill(Color.BLACK);
                gridPane1L.add(faName, 0, 5);
                Label gName = new Label("የአያት ስም:");
                gName.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                gName.setTextFill(Color.BLACK);
                gridPane1L.add(gName, 0, 6);

                TextField tFiName = new TextField();
                tFiName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridPane1L.add(tFiName, 1, 4);
                TextField tFaName = new TextField();
                tFaName.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridPane1L.add(tFaName, 1, 5);
                TextField tGname = new TextField();
                tGname.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridPane1L.add(tGname, 1, 6);

                Label titleSex = new Label("ጾታ");
                titleSex.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleSex.setTextFill(Color.BLACK);
                gridPane1L.add(titleSex, 0, 7);
                TextField tSex = new TextField();
                tSex.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridPane1L.add(tSex, 1, 7);
                Label titleService = new Label("የአገልግሎት ክፍል");
                titleService.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleService.setTextFill(Color.BLACK);
                gridPane1L.add(titleService, 0, 8);
                TextField tSer = new TextField();
                tSer.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridPane1L.add(tSer, 1, 8);

                Label titleBatch = new Label("የገቡበት ጊዜ");
                titleBatch.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleBatch.setTextFill(Color.BLACK);
                gridPane1L.add(titleBatch, 0, 9);
                TextField tEnterTime = new TextField();
                tEnterTime.setFont(Font.font("Nyala", FontPosture.REGULAR, 14));
                gridPane1L.add(tEnterTime, 1, 9);

                Label fullMo = new Label("የሞባይል ቁጥር:");
                fullMo.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                fullMo.setTextFill(Color.BLACK);
                tMoL = new TextField();
                gridPane1L.add(fullMo, 0, 10);
                gridPane1L.add(tMoL, 1, 10);
                Label leaveReason = new Label("የለቀቁበት ምክንያት:");
                leaveReason.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                leaveReason.setTextFill(Color.BLACK);
                tMoL1 = new TextField();
                tMoL1.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
                gridPane1L.add(leaveReason, 0, 12);
                gridPane1L.add(tMoL1, 1, 12);

                Label leaveTime = new Label("የለቀቁበት ጊዜ");
                leaveTime.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                leaveTime.setTextFill(Color.BLACK);
                gridPane1L.add(leaveTime, 0, 13);

                final ComboBox cSerY = new ComboBox();
                cSerY.getItems().addAll(
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
                cSerY.setPromptText("ባች");
                cSerY.setEditable(true);
                cSerY.setId("table");
                cSerY.setMaxWidth(150);
                final ComboBox cSerYA = new ComboBox();
                cSerYA.getItems().addAll(
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
                cSerYA.setPromptText("ዓ/ም");
                cSerYA.setEditable(true);
                cSerYA.setId("table");
                cSerYA.setMaxWidth(150);
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
                cMonth.setMaxWidth(150);
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
                cDay.setMaxWidth(150);
                cDay.setId("table");

                gridPane1L.add(cDay, 1, 13);
                gridPane1L.add(cMonth, 1, 14);
                gridPane1L.add(cSerYA, 1, 15);
                gridPane1L.add(cSerY, 1, 2);
                Label titleResponse = new Label("ኃላፊነት");
                titleResponse.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                titleResponse.setTextFill(Color.BLACK);
                TextField tResponse = new TextField();
                tResponse.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                gridPane1L.add(titleResponse, 0, 11);
                gridPane1L.add(tResponse, 1, 11);
                Button butSearch = new Button("ፈልግ");
                butSearch.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                butSearch.setStyle("-fx-text-fill: black;");

                Button butNew = new Button("መዝግብ");
                butNew.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
                butNew.setStyle("-fx-text-fill: black;");

                HBox hBut = new HBox();
                hBut.setSpacing(12);
                hBut.setAlignment(Pos.CENTER);
                hBut.getChildren().addAll(butSearch, butNew);
                gridPane1L.add(hBut, 1, 16);

                butSearch.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        String str = cSerY.getValue().toString();
                        DatabaseClass.openConnection(str);

                        results = stuQueries.getLeave(tIDL.getText());
                        numberOfEntries = results.size();

                        if (numberOfEntries != 0) {
                            currentEntryIndex = 0;

                            studata = results.get(currentEntryIndex);

                            tFiName.setText(studata.getFName());
                            tFaName.setText(studata.getMName());
                            tGname.setText(studata.getLName());
                            tSex.setText(studata.getBdate());
                            tSer.setText(studata.getWoreda());
                            tEnterTime.setText(studata.getCity() + "/" + studata.getKebele() + "/" + studata.getGField());
                            tResponse.setText(studata.getResp());
                            tMoL.setText(studata.getHolly());

                        }
                    }
                });
                butNew.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        String str, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, strR;
                        str = tIDL.getText();
                        str1 = tFiName.getText();
                        str2 = tFaName.getText();
                        str3 = tGname.getText();
                        str4 = cDay.getValue().toString() + "/" + cMonth.getValue().toString() + "/" + cSerYA.getValue().toString();
                        str5 = tSer.getText();
                        str8 = tMoL.getText();
                        str9 = tEnterTime.getText();
                        str10 = tMoL1.getText();
                        str11 = tSex.getText();
                        strR = tResponse.getText();

                        DatabaseClass.addLeaveTable(str, str1, str2, str3, str11, str5, strR, str9, str8, str10, str4);
                        String strY = cSerY.getValue().toString();
                        DatabaseClass.openConnection(strY);
                        int res = stuQueries.deleteMem(tIDL.getText());
                        if (res == 1) {
                            JOptionPane.showMessageDialog(null, "yes,Database is Updated");
                        } else {
                            JOptionPane.showMessageDialog(null, "Not Updated");
                        }
                    }
                });

            }
        });

        border.setCenter(gridPane1L);
    }

    public void batchInfo(ActionEvent eve) {
        gridTra.getChildren().clear();
        gridPane2.getChildren().clear();
        Label titleBatch = new Label("የመረጃ ዘመን");
        titleBatch.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        titleBatch.setTextFill(Color.BLACK);
        // gridPane2.add(titleBatch, 0, 2);
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

        // gridPane2.add(cServiceY, 0, 3);
        Button butFe = new Button("ሴት አባላት");
        butFe.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butFe.setStyle("-fx-text-fill: black;");
        Button butMa = new Button("ወንድ አባላት");
        butMa.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butMa.setStyle("-fx-text-fill: black;");
        Button butFu = new Button("ፈልግ");
        butFu.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butFu.setStyle("-fx-text-fill: black;");
        Button butTotal = new Button("የዚህ ዓመት ጠቅላላ አባላት");
        butTotal.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butTotal.setStyle("-fx-text-fill: black;");
        // gridPane2.add(butServiceSearch, 0, 3);
        HBox hBoxRadioS = new HBox();
        hBoxRadioS.setSpacing(5);
        GridPane.setColumnSpan(hBoxRadioS, 10);
        hBoxRadioS.setAlignment(Pos.BASELINE_LEFT);
        hBoxRadioS.setId("hBox1");
        hBoxRadioS.setPadding(new Insets(10, 10, 10, 10));
        // hBoxRadioS.getChildren().addAll(titleBatch, cServiceY, butFu, butMa, butFe);

        gridPane2.setId("bp");
        gridPane2.setVgap(10);
        gridPane2.setHgap(5);

        Label numInfoLable = new Label("    የቁጥር መረጃ    ");
        numInfoLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        numInfoLable.setTextFill(Color.BLACK);

        Label manumLable = new Label("የወንድ ብዛት");
        manumLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        manumLable.setTextFill(Color.BLACK);
        Label fenumLable = new Label("የሴት ብዛት");
        fenumLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        fenumLable.setTextFill(Color.BLACK);
        Label totalnumLable = new Label("ጠቅላላ ድምር");
        totalnumLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        totalnumLable.setTextFill(Color.BLACK);

        vBoxTop1 = new VBox();
        vBoxTop1.setId("bp");
        vBoxTop1.setSpacing(10);
        vBoxTop1.setAlignment(Pos.CENTER);
        vBoxTop1.setPadding(new Insets(15, 15, 15, 15));
        //vBoxTop1.getChildren().addAll();

        HBox hBoxtra = new HBox();
        hBoxtra.setSpacing(5);
        GridPane.setColumnSpan(hBoxtra, 10);
        hBoxtra.setAlignment(Pos.BASELINE_LEFT);
        hBoxtra.setId("hBox1");
        hBoxtra.setPadding(new Insets(5, 5, 5, 5));
        hBoxtra.getChildren().addAll();

        hBoxRadioS.getChildren().addAll(titleBatch, cServiceY, butFu);

        gridPane2.add(hBoxRadioS, 0, 0);

        border.setCenter(gridPane2);
        border.setLeft(gridPane4);
    }

    public void serviceInfo(ActionEvent eve) {

        Label titleService = new Label("የአገልግሎት ክፍል");
        titleService.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        titleService.setTextFill(Color.BLACK);
        gridTra.getChildren().clear();
        gridPane2.getChildren().clear();
        cService = new ComboBox();
        cService.getItems().addAll(
                "የትምህርትና ሐዋርያዊ ክፍል",
                "ቅዱሳን መካናት ክፍል",
                "የልማት ክፍል",
                "ኦዲትና ኢንስፔክሽን ክፍል",
                "አባላትና ወረዳ ማዕከላት ማስተባበሪያ",
                "ሙያ አገልግሎት ክፍል",
                "ዕቅድና ዝግጅት ክፍል",
                "የሂሳብ ክፍል",
                "የሚዲያና ክፍል", "ጽ/ቤት ክፍል", "ግቢ ጉባዔ አስተባባሪ");
        cService.setPromptText("የአገልግሎት ክፍል");
        cService.setEditable(true);
        cService.setId("table");
        cService.setMaxWidth(150);
        // gridPane2.add(cService, 0, 1);
        Label titleBatch = new Label("የመረጃ ዘመን");
        titleBatch.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        titleBatch.setTextFill(Color.BLACK);
        // gridPane2.add(titleBatch, 0, 2);
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
        cServiceY.setMaxWidth(75);

        // gridPane2.add(cServiceY, 0, 3);
        Button butFe = new Button("ሴት አባላት");
        butFe.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butFe.setStyle("-fx-text-fill: black;");
        Button butMa = new Button("ወንድ አባላት");
        butMa.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butMa.setStyle("-fx-text-fill: black;");
        Button butFu = new Button("ሙሉ አባላት");
        butFu.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butFu.setStyle("-fx-text-fill: black;");
        // gridPane2.add(butServiceSearch, 0, 3);
        HBox hBoxRadioS = new HBox();
        hBoxRadioS.setSpacing(5);
        GridPane.setColumnSpan(hBoxRadioS, 10);
        hBoxRadioS.setAlignment(Pos.BASELINE_LEFT);
        hBoxRadioS.setId("hBox1");
        hBoxRadioS.setPadding(new Insets(5, 5, 5, 5));
        hBoxRadioS.setMaxWidth(900);
        hBoxRadioS.getChildren().addAll(titleBatch, cServiceY, titleService, cService, butFu, butMa, butFe);
        gridPane2.add(hBoxRadioS, 0, 0);
        // gridPane2.setId("bp");
        gridPane2.setVgap(15);
        gridPane2.setHgap(5);

        Label numInfoLable = new Label("    የቁጥር መረጃ    ");
        numInfoLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        numInfoLable.setTextFill(Color.BLACK);

        Label manumLable = new Label("የወንድ ብዛት");
        manumLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        manumLable.setTextFill(Color.BLACK);
        Label fenumLable = new Label("የሴት ብዛት");
        fenumLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        fenumLable.setTextFill(Color.BLACK);
        Label totalnumLable = new Label("ጠቅላላ ድምር");
        totalnumLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        totalnumLable.setTextFill(Color.BLACK);
        Label transferBaLable = new Label("ወደሚቀጥለው ዓመት ለማሻገር");
        transferBaLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        transferBaLable.setTextFill(Color.BLACK);

        Label wedeLable = new Label("ወደ");
        wedeLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        wedeLable.setTextFill(Color.BLACK);
        Label keLable = new Label("ከ");
        keLable.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        keLable.setTextFill(Color.BLACK);

        gridPane10.setVgap(7);
        gridPane10.setId("bp");
        gridPane10.setPadding(new Insets(5, 5, 5, 5));

        vBoxTop1 = new VBox();
        vBoxTop1.setId("vBoxT");
        vBoxTop1.setSpacing(10);
        vBoxTop1.setAlignment(Pos.CENTER);
        vBoxTop1.setPadding(new Insets(5, 5, 5, 5));
        vBoxTop1.getChildren().addAll(numInfoLable, manumLable, fenumLable, totalnumLable);

        HBox hBoxtra = new HBox();
        hBoxtra.setSpacing(5);
        GridPane.setColumnSpan(hBoxtra, 15);
        hBoxtra.setAlignment(Pos.BASELINE_LEFT);
        hBoxtra.setId("hBox1");
        hBoxtra.setPadding(new Insets(10, 10, 10, 10));
        hBoxtra.getChildren().addAll();

        butFu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                if (cServiceY.getSelectionModel().isEmpty() && cService.getSelectionModel().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("መረጃ መንገድ");
                    alert.setContentText("Please Select Year or Both ");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                } else if (cServiceY.getSelectionModel().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("መረጃ መንገድ");
                    alert.setContentText("Please Select Year is Mandatory");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                } else if (cService.getSelectionModel().isEmpty()) {
                    String cY = cServiceY.getValue().toString();
                    batchSearchFull(cY);

                } else {
                    serviceSearchFull();
                }

            }
        });
        butFe.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                if (cServiceY.getSelectionModel().isEmpty() && cService.getSelectionModel().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("መረጃ መንገድ");
                    alert.setContentText("Please Select Year or Both ");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                } else if (cServiceY.getSelectionModel().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("መረጃ መንገድ");
                    alert.setContentText("Please Select Year is Mandatory");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                } else if (cService.getSelectionModel().isEmpty()) {
                    String cYf = cServiceY.getValue().toString();
                    tsotaBatch = "ሴት";
                    batchSearch(cYf, tsotaBatch);

                } else {

                    hBoxRadioS.setMaxWidth(900);
                    tsotaService = "ሴት";
                    serviceSearch();
                }

            }
        });

        butMa.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                if (cServiceY.getSelectionModel().isEmpty() && cService.getSelectionModel().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("መረጃ መንገድ");
                    alert.setContentText("Please Select Year or Both ");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                } else if (cServiceY.getSelectionModel().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("መረጃ መንገድ");
                    alert.setContentText("Please Select Year is Mandatory");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                } else if (cService.getSelectionModel().isEmpty()) {
                    String cYf = cServiceY.getValue().toString();
                    tsotaBatch = "ወንድ";
                    batchSearch(cYf, tsotaBatch);

                } else {
                    hBoxRadioS.setMaxWidth(900);
                    tsotaService = "ወንድ";
                    serviceSearch();
                }

            }
        });

        border.setCenter(gridPane2);
        border.setLeft(gridPane4);

        //  gridPane2.setPadding(new Insets(10, 10, 10, 10));
    }

    public void serviceSearch() {
        String sy = cServiceY.getValue().toString();
        String sy2 = cService.getValue().toString();

        table = new TableView();
        table.setId("table");
        table.setMaxSize(900, 600);

        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        //Set up the columns
        TableColumn firstNameCol = new TableColumn("የመጀመሪያ ስም");
        firstNameCol.setMinWidth(120);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(cellFactory);
        TableColumn lastNameCol = new TableColumn("የአባት ስም");
        lastNameCol.setMinWidth(120);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(cellFactory);
        //lastNameCol.setEditable( false );

        TableColumn primaryEmailColG = new TableColumn("የአያት ስም");
        primaryEmailColG.setMinWidth(120);
        primaryEmailColG.setCellValueFactory(new PropertyValueFactory<Person, String>("grandName"));
        primaryEmailColG.setCellFactory(cellFactory);
        //Make this column un-editable        

        TableColumn secondaryEmailColB = new TableColumn("ኃላፊነት");
        secondaryEmailColB.setMinWidth(120);
        secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
        secondaryEmailColB.setCellFactory(cellFactory);

        TableColumn firstNameColW = new TableColumn("የገቡበት ዓመት");
        firstNameColW.setMinWidth(150);
        firstNameColW.setCellValueFactory(new PropertyValueFactory<Person, String>("wereda"));
        firstNameColW.setCellFactory(cellFactory);
        TableColumn lastNameColKt = new TableColumn("ስልክ ቁጥር");
        lastNameColKt.setMinWidth(150);
        lastNameColKt.setCellValueFactory(new PropertyValueFactory<Person, String>("ketema"));
        lastNameColKt.setCellFactory(cellFactory);

        //Make this column un-editable        
        TableColumn secondaryEmailColId = new TableColumn("መለያ ቁጥር");
        secondaryEmailColId.setId("table");
        secondaryEmailColId.setMinWidth(80);
        secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<Person, String>("idNumber"));
        secondaryEmailColId.setCellFactory(cellFactory);

        table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, secondaryEmailColB, firstNameColW, lastNameColKt);
        //Make the table editable
        table.setEditable(true);
        // table.setId("table");

        firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                newValue = t.getNewValue();
                colName = "የመጀመሪያስም";

            }
        });
        //Modifying the lastName property
        lastNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());

                colName = "የአባትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the primary email property
        primaryEmailColG.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrandName(t.getNewValue());
                colName = "የአያትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the secondary email property
        secondaryEmailColB.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBirthDate(t.getNewValue());
                colName = "ኃላፊነት";
                newValue = t.getNewValue();

            }
        });
        firstNameColW.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWereda(t.getNewValue());
                colName = "የገቡበትዓመት";
                newValue = t.getNewValue();

            }
        });
        lastNameColKt.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKetema(t.getNewValue());
                colName = "ስልክቁጥር";
                newValue = t.getNewValue();

            }
        });
        secondaryEmailColId.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdNumber(t.getNewValue());

                colName = "መለያቁጥር";
                newValue = t.getNewValue();

            }
        });

        data1.clear();
        try {
            Class.forName("org.h2.Driver");
            try {
                try {
                    cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                } catch (Exception y) {
                }
                con = cp.getConnection();

            } catch (Exception l) {
            }
            String sql = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + sy + " WHERE ፆታ='" + tsotaService + "' AND አገልግሎትክፍል ='" + cService.getValue().toString() + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                data1.add(new Person(
                        rs.getString("መለያቁጥር"),
                        rs.getString("የመጀመሪያስም"),
                        rs.getString("የአባትስም"),
                        rs.getString("የአያትስም"),
                        rs.getString("ኃላፊነት"),
                        rs.getString("የገቡበትዓመት"),
                        rs.getString("ስልክቁጥር")));
                table.setItems(data1);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridPane.setColumnSpan(table, 10);
        GridPane.setRowSpan(table, 40);

        infoUpdate = new Button("አስተካክል");
        infoUpdate.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

        Button infoOut = new Button("መረጃውን ፋይል ላይ ገልብጥ");
        infoOut.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        HBox infoHbox = new HBox();
        infoHbox.setAlignment(Pos.BASELINE_LEFT);
        infoHbox.setSpacing(20);
        infoHbox.setPadding(new Insets(5, 5, 5, 5));
        infoHbox.getChildren().addAll(infoOut, infoUpdate);
        VBox infoVbox = new VBox();
        infoVbox.setAlignment(Pos.CENTER);
        infoVbox.setSpacing(100);
        // infoVbox.setMaxSize(1000,900);
        infoVbox.setPadding(new Insets(5, 5, 5, 5));
        infoVbox.getChildren().addAll(table, infoHbox);

        gridPane2.add(infoVbox, 1, 1);
        infoUpdate.setOnAction(e
                -> {
            new SampleFX1().textInputBatch(sy, colName, newValue);
        }
        );
        infoOut.setOnAction(e
                -> {

            new JavaFxApplication1().exportDataService(sy, tsotaService, sy2);
        }
        );
    }

    public void batchSearch(String str, String str2) {

        table = new TableView();
        table.setId("table");
        table.setMaxSize(900, 600);

        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        //Set up the columns
        TableColumn firstNameCol = new TableColumn("የመጀመሪያ ስም");
        firstNameCol.setMinWidth(120);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(cellFactory);

        TableColumn lastNameCol = new TableColumn("የአባት ስም");
        lastNameCol.setMinWidth(120);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(cellFactory);
        //lastNameCol.setEditable( false );

        TableColumn primaryEmailColG = new TableColumn("የአያት ስም");
        primaryEmailColG.setMinWidth(120);
        primaryEmailColG.setCellValueFactory(new PropertyValueFactory<Person, String>("grandName"));
        primaryEmailColG.setCellFactory(cellFactory);
        //Make this column un-editable        

        TableColumn secondaryEmailColB = new TableColumn("ኃላፊነት");
        secondaryEmailColB.setMinWidth(80);
        secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
        secondaryEmailColB.setCellFactory(cellFactory);

        TableColumn firstNameColT = new TableColumn("አገልግሎት ክፍል");
        firstNameColT.setMinWidth(70);
        firstNameColT.setCellValueFactory(new PropertyValueFactory<Person, String>("kebele"));
        firstNameColT.setCellFactory(cellFactory);

        TableColumn firstNameColW = new TableColumn("የገቡበት ዓመት");
        firstNameColW.setMinWidth(80);
        firstNameColW.setCellValueFactory(new PropertyValueFactory<Person, String>("wereda"));
        firstNameColW.setCellFactory(cellFactory);

        TableColumn lastNameColKt = new TableColumn("ስልክ ቁጥር");
        lastNameColKt.setMinWidth(150);
        lastNameColKt.setCellValueFactory(new PropertyValueFactory<Person, String>("ketema"));
        lastNameColKt.setCellFactory(cellFactory);

        //Make this column un-editable        
        TableColumn secondaryEmailColId = new TableColumn("መለያ ቁጥር");
        secondaryEmailColId.setId("table");
        secondaryEmailColId.setMinWidth(80);
        secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<Person, String>("idNumber"));
        secondaryEmailColId.setCellFactory(cellFactory);

        table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, firstNameColT, secondaryEmailColB, firstNameColW, lastNameColKt);
        //Make the table editable
        table.setEditable(true);
        // table.setId("table");

      
        firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                newValue = t.getNewValue();
                colName = "የመጀመሪያስም";

            }
        });
        //Modifying the lastName property
        lastNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());

                colName = "የአባትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the primary email property
        primaryEmailColG.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrandName(t.getNewValue());
                colName = "የአያትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the secondary email property
        secondaryEmailColB.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBirthDate(t.getNewValue());
                colName = "ኃላፊነት";
                newValue = t.getNewValue();

            }
        });
        firstNameColW.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWereda(t.getNewValue());
                colName = "የገቡበትዓመት";
                newValue = t.getNewValue();

            }
        });
        firstNameColT.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKebele(t.getNewValue());
                colName = "አገልግሎትክፍል";
                newValue = t.getNewValue();

            }
        });
        lastNameColKt.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKetema(t.getNewValue());
                colName = "ስልክቁጥር";
                newValue = t.getNewValue();

            }
        });
        secondaryEmailColId.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdNumber(t.getNewValue());

                colName = "መለያቁጥር";
                newValue = t.getNewValue();

            }
        });
        data1.clear();
        try {
            Class.forName("org.h2.Driver");
            try {
                try {
                    cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                } catch (Exception y) {
                }
                con = cp.getConnection();

            } catch (Exception l) {
            }
            String sql = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,አገልግሎትክፍል,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + str + " WHERE ፆታ='" + str2 + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                data1.add(new Person(
                        rs.getString("መለያቁጥር"),
                        rs.getString("የመጀመሪያስም"),
                        rs.getString("የአባትስም"),
                        rs.getString("የአያትስም"),
                        rs.getString("አገልግሎትክፍል"),
                        rs.getString("ኃላፊነት"),
                        rs.getString("የገቡበትዓመት"),
                        rs.getString("ስልክቁጥር")));
                table.setItems(data1);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridPane.setColumnSpan(table, 10);
        GridPane.setRowSpan(table, 40);

        infoUpdate = new Button("አስተካክል");
        infoUpdate.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

        Button infoOut = new Button("መረጃውን ፋይል ላይ ገልብጥ");
        infoOut.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        HBox infoHbox = new HBox();
        infoHbox.setAlignment(Pos.BASELINE_LEFT);
        infoHbox.setSpacing(20);
        infoHbox.setPadding(new Insets(5, 5, 5, 5));
        infoHbox.getChildren().addAll(infoOut, infoUpdate);
        VBox infoVbox = new VBox();
        infoVbox.setAlignment(Pos.CENTER);
        infoVbox.setSpacing(100);
        // infoVbox.setMaxSize(1000,900);
        infoVbox.setPadding(new Insets(5, 5, 5, 5));
        infoVbox.getChildren().addAll(table, infoHbox);

        gridPane2.add(infoVbox, 1, 1);
        infoUpdate.setOnAction(e
                -> {
            new SampleFX1().textInputBatch(str, colName, newValue);
        }
        );
        infoOut.setOnAction(e
                -> {
            new JavaFxApplication1().exportDataBatch(str, str2);
        }
        );
    }

    public void batchSearchFull(String str) {

        table = new TableView();
        table.setId("table");
        table.setMaxSize(900, 600);

        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        //Set up the columns
        TableColumn firstNameCol = new TableColumn("የመጀመሪያ ስም");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(cellFactory);

        TableColumn lastNameCol = new TableColumn("የአባት ስም");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(cellFactory);
        //lastNameCol.setEditable( false );
        TableColumn primaryEmailColG = new TableColumn("የአያት ስም");
        primaryEmailColG.setMinWidth(100);
        primaryEmailColG.setCellValueFactory(new PropertyValueFactory<Person, String>("grandName"));
        primaryEmailColG.setCellFactory(cellFactory);
        //Make this column un-editable        

        TableColumn secondaryEmailColB = new TableColumn("ኃላፊነት");
        secondaryEmailColB.setMinWidth(80);
        secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
        secondaryEmailColB.setCellFactory(cellFactory);

        TableColumn firstNameColT = new TableColumn("ፆታ");
        firstNameColT.setMinWidth(70);
        firstNameColT.setCellValueFactory(new PropertyValueFactory<Person, String>("kebele"));
        firstNameColT.setCellFactory(cellFactory);

        TableColumn firstNameColTA = new TableColumn("አገልግሎት ክፍል");
        firstNameColTA.setMinWidth(70);
        firstNameColTA.setCellValueFactory(new PropertyValueFactory<Person, String>("ageligilot"));
        firstNameColTA.setCellFactory(cellFactory);

        TableColumn firstNameColW = new TableColumn("የገቡበት ዓመት");
        firstNameColW.setMinWidth(80);
        firstNameColW.setCellValueFactory(new PropertyValueFactory<Person, String>("wereda"));
        firstNameColW.setCellFactory(cellFactory);

        TableColumn lastNameColKt = new TableColumn("ስልክ ቁጥር");
        lastNameColKt.setMinWidth(100);
        lastNameColKt.setCellValueFactory(new PropertyValueFactory<Person, String>("ketema"));
        lastNameColKt.setCellFactory(cellFactory);

        //Make this column un-editable        
        TableColumn secondaryEmailColId = new TableColumn("መለያ ቁጥር");
        secondaryEmailColId.setId("table");
        secondaryEmailColId.setMinWidth(70);
        secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<Person, String>("idNumber"));
        secondaryEmailColId.setCellFactory(cellFactory);

        table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, firstNameColT, firstNameColTA, secondaryEmailColB, firstNameColW, lastNameColKt);
        //Make the table editable
        table.setEditable(true);
      
        firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                newValue = t.getNewValue();
                colName = "የመጀመሪያስም";

            }
        });
        //Modifying the lastName property
        lastNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());

                colName = "የአባትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the primary email property
        primaryEmailColG.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrandName(t.getNewValue());
                colName = "የአያትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the secondary email property
        secondaryEmailColB.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBirthDate(t.getNewValue());
                colName = "ኃላፊነት";
                newValue = t.getNewValue();

            }
        });
        firstNameColW.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWereda(t.getNewValue());
                colName = "የገቡበትዓመት";
                newValue = t.getNewValue();

            }
        });
        firstNameColT.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKebele(t.getNewValue());
                colName = "ፆታ";
                newValue = t.getNewValue();

            }
        });
        firstNameColTA.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAgeligilot(t.getNewValue());
                colName = "አገልግሎትክፍል";
                newValue = t.getNewValue();

            }
        });
        lastNameColKt.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKetema(t.getNewValue());
                colName = "ስልክቁጥር";
                newValue = t.getNewValue();

            }
        });
          secondaryEmailColId.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdNumber(t.getNewValue());

                colName = "መለያቁጥር";
                newValue = t.getNewValue();

            }
        });

        data1.clear();
        try {
            Class.forName("org.h2.Driver");
            try {
                try {
                    cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                } catch (Exception y) {
                }
                con = cp.getConnection();

            } catch (Exception l) {
            }
            String sql = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + str + " ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                data1.add(new Person(
                        rs.getString("መለያቁጥር"),
                        rs.getString("የመጀመሪያስም"),
                        rs.getString("የአባትስም"),
                        rs.getString("የአያትስም"),
                        rs.getString("ፆታ"),
                        rs.getString("አገልግሎትክፍል"),
                        rs.getString("ኃላፊነት"),
                        rs.getString("የገቡበትዓመት"),
                        rs.getString("ስልክቁጥር")));
                table.setItems(data1);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridPane.setColumnSpan(table, 10);
        GridPane.setRowSpan(table, 40);

        infoUpdate = new Button("አስተካክል");
        infoUpdate.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

        Button infoOut = new Button("መረጃውን ፋይል ላይ ገልብጥ");
        infoOut.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        HBox infoHbox = new HBox();
        infoHbox.setAlignment(Pos.BASELINE_LEFT);
        infoHbox.setSpacing(20);
        infoHbox.setPadding(new Insets(5, 5, 5, 5));
        infoHbox.getChildren().addAll(infoOut, infoUpdate);
        VBox infoVbox = new VBox();
        infoVbox.setAlignment(Pos.CENTER);
        infoVbox.setSpacing(100);
        // infoVbox.setMaxSize(1000,900);
        infoVbox.setPadding(new Insets(5, 5, 5, 5));
        infoVbox.getChildren().addAll(table, infoHbox);

        gridPane2.add(infoVbox, 1, 1);
        infoUpdate.setOnAction(e
                -> {
            new SampleFX1().textInputBatch(str, colName, newValue);
        }
        );
        infoOut.setOnAction(e
                -> {
            new JavaFxApplication1().exportDataBatchFull(str);
        }
        );
    }

    public void leaveSearch() {

        table = new TableView();
        table.setId("table");
        table.setMaxSize(950, 600);

        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        //Set up the columns
        TableColumn firstNameCol = new TableColumn("የመጀመሪያ ስም");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(cellFactory);

        TableColumn lastNameCol = new TableColumn("የአባት ስም");
        lastNameCol.setMinWidth(80);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(cellFactory);
        //lastNameCol.setEditable( false );

        TableColumn primaryEmailColG = new TableColumn("አገልግሎት ክፍል");
        primaryEmailColG.setMinWidth(150);
        primaryEmailColG.setCellValueFactory(new PropertyValueFactory<Person, String>("grandName"));
        primaryEmailColG.setCellFactory(cellFactory);
        //Make this column un-editable        

        TableColumn secondaryEmailColB = new TableColumn("ኃላፊነት");
        secondaryEmailColB.setMinWidth(80);
        secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
        secondaryEmailColB.setCellFactory(cellFactory);

        TableColumn firstNameColT = new TableColumn("የገቡበት ጊዜ");
        firstNameColT.setMinWidth(70);
        firstNameColT.setCellValueFactory(new PropertyValueFactory<Person, String>("kebele"));
        firstNameColT.setCellFactory(cellFactory);

        TableColumn firstNameColTA = new TableColumn("ስልክ ቁጥር");
        firstNameColTA.setMinWidth(70);
        firstNameColTA.setCellValueFactory(new PropertyValueFactory<Person, String>("ageligilot"));
        firstNameColTA.setCellFactory(cellFactory);

        TableColumn firstNameColW = new TableColumn("የለቀቁበት ምክንያት");
        firstNameColW.setMinWidth(80);
        firstNameColW.setCellValueFactory(new PropertyValueFactory<Person, String>("wereda"));
        firstNameColW.setCellFactory(cellFactory);

        TableColumn lastNameColKt = new TableColumn("የለቀቁበት ጊዜ");
        lastNameColKt.setMinWidth(100);
        lastNameColKt.setCellValueFactory(new PropertyValueFactory<Person, String>("ketema"));
        lastNameColKt.setCellFactory(cellFactory);

        //Make this column un-editable        
        TableColumn secondaryEmailColId = new TableColumn("መለያ ቁጥር");
        secondaryEmailColId.setId("table");
        secondaryEmailColId.setMinWidth(70);
        secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<Person, String>("idNumber"));
        secondaryEmailColId.setCellFactory(cellFactory);

        table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, firstNameColT, firstNameColTA, secondaryEmailColB, firstNameColW, lastNameColKt);

        data1.clear();
        try {
            Class.forName("org.h2.Driver");
            try {
                try {
                    cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                } catch (Exception y) {
                }
                con = cp.getConnection();

            } catch (Exception l) {
            }
            String sql = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,አገልግሎትክፍል,ኃላፊነት,የገቡበትጊዜ,ስልክቁጥር,የለቀቁበትምክንያት,የለቀቁበትጊዜ from LeaveTableA";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                data1.add(new Person(
                        rs.getString("መለያቁጥር"),
                        rs.getString("የመጀመሪያስም"),
                        rs.getString("የአባትስም"),
                        rs.getString("አገልግሎትክፍል"),
                        rs.getString("የገቡበትጊዜ"),
                        rs.getString("ስልክቁጥር"),
                        rs.getString("ኃላፊነት"),
                        rs.getString("የለቀቁበትምክንያት"),
                        rs.getString("የለቀቁበትጊዜ")));
                table.setItems(data1);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridPane.setColumnSpan(table, 10);
        GridPane.setRowSpan(table, 40);

        gridPane1L.add(table, 1, 1);

    }

    public void serviceSearchFull() {
        String sy = cServiceY.getValue().toString();
        String sy2 = cService.getValue().toString();

        table = new TableView();
        table.setId("table");
        table.setMaxSize(900, 600);

        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        //Set up the columns
        TableColumn firstNameCol = new TableColumn("የመጀመሪያ ስም");
        firstNameCol.setMinWidth(120);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(cellFactory);

        TableColumn lastNameCol = new TableColumn("የአባት ስም");
        lastNameCol.setMinWidth(120);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(cellFactory);
        //lastNameCol.setEditable( false );

        TableColumn primaryEmailColG = new TableColumn("የአያት ስም");
        primaryEmailColG.setMinWidth(120);
        primaryEmailColG.setCellValueFactory(new PropertyValueFactory<Person, String>("grandName"));
        primaryEmailColG.setCellFactory(cellFactory);
        //Make this column un-editable        

        TableColumn secondaryEmailColB = new TableColumn("ኃላፊነት");
        secondaryEmailColB.setMinWidth(80);
        secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
        secondaryEmailColB.setCellFactory(cellFactory);

        TableColumn firstNameColT = new TableColumn("ፆታ");
        firstNameColT.setMinWidth(70);
        firstNameColT.setCellValueFactory(new PropertyValueFactory<Person, String>("kebele"));
        firstNameColT.setCellFactory(cellFactory);

        TableColumn firstNameColW = new TableColumn("የገቡበት ዓመት");
        firstNameColW.setMinWidth(80);
        firstNameColW.setCellValueFactory(new PropertyValueFactory<Person, String>("wereda"));
        firstNameColW.setCellFactory(cellFactory);

        TableColumn lastNameColKt = new TableColumn("ስልክ ቁጥር");
        lastNameColKt.setMinWidth(150);
        lastNameColKt.setCellValueFactory(new PropertyValueFactory<Person, String>("ketema"));
        lastNameColKt.setCellFactory(cellFactory);

        //Make this column un-editable        
        TableColumn secondaryEmailColId = new TableColumn("መለያ ቁጥር");
        secondaryEmailColId.setId("table");
        secondaryEmailColId.setMinWidth(80);
        secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<Person, String>("idNumber"));
        secondaryEmailColId.setCellFactory(cellFactory);

        table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, firstNameColT, secondaryEmailColB, firstNameColW, lastNameColKt);
        //Make the table editable
        table.setEditable(true);
        // table.setId("table");

        //Modifying the firstName property
        secondaryEmailColId.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdNumber(t.getNewValue());
                colName = "መለያቁጥር";
                newValue = t.getNewValue();

            }
        });
        firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                newValue = t.getNewValue();
                colName = "የመጀመሪያስም";

            }
        });
        //Modifying the lastName property
        lastNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());

                colName = "የአባትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the primary email property
        primaryEmailColG.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrandName(t.getNewValue());
                colName = "የአያትስም";
                newValue = t.getNewValue();

            }
        });
        //Modifying the secondary email property
        secondaryEmailColB.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBirthDate(t.getNewValue());
                colName = "ኃላፊነት";
                newValue = t.getNewValue();

            }
        });
        firstNameColW.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWereda(t.getNewValue());
                colName = "የገቡበትዓመት";
                newValue = t.getNewValue();

            }
        });
        firstNameColT.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKebele(t.getNewValue());
                colName = "ፆታ";
                newValue = t.getNewValue();

            }
        });
        lastNameColKt.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKetema(t.getNewValue());
                colName = "ስልክቁጥር";
                newValue = t.getNewValue();

            }
        });

        data1.clear();
        try {
            Class.forName("org.h2.Driver");
            try {
                try {
                    cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                } catch (Exception y) {
                }
                con = cp.getConnection();

            } catch (Exception l) {
            }
            String sql = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + sy + " WHERE አገልግሎትክፍል ='" + cService.getValue().toString() + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                data1.add(new Person(
                        rs.getString("መለያቁጥር"),
                        rs.getString("የመጀመሪያስም"),
                        rs.getString("የአባትስም"),
                        rs.getString("የአያትስም"),
                        rs.getString("ፆታ"),
                        rs.getString("ኃላፊነት"),
                        rs.getString("የገቡበትዓመት"),
                        rs.getString("ስልክቁጥር")));
                table.setItems(data1);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridPane.setColumnSpan(table, 10);
        GridPane.setRowSpan(table, 40);

        infoUpdate = new Button("አስተካክል");
        infoUpdate.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

        Button infoOut = new Button("መረጃውን ፋይል ላይ ገልብጥ");
        infoOut.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
        HBox infoHbox = new HBox();
        infoHbox.setAlignment(Pos.BASELINE_LEFT);
        infoHbox.setSpacing(20);
        infoHbox.setPadding(new Insets(5, 5, 5, 5));
        infoHbox.getChildren().addAll(infoOut, infoUpdate);
        VBox infoVbox = new VBox();
        infoVbox.setAlignment(Pos.CENTER);
        infoVbox.setSpacing(100);
        // infoVbox.setMaxSize(1000,900);
        infoVbox.setPadding(new Insets(5, 5, 5, 5));
        infoVbox.getChildren().addAll(table, infoHbox);

        gridPane2.add(infoVbox, 1, 1);
        infoUpdate.setOnAction(e
                -> {
            new SampleFX1().textInputBatch(sy, colName, newValue);
        }
        );
        infoOut.setOnAction(e
                -> {
            new JavaFxApplication1().exportDataServiceFull(sy, sy2);
        }
        );
    }

    public void personalSearch(ActionEvent eve) {
        gridTra.getChildren().clear();
        gridPane.setVgap(7);
        gridPane.setId("bpa");
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane9.getChildren().clear();

        Label askInfo = new Label(" የመለያ ቁጥር ያስገቡ !");
        askInfo.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        gridPane.add(askInfo, 0, 3);
        tIdSearch = new TextField();
        tNameSearch = new TextField();
        Label idInfo = new Label("መለያ ቁጥር");
        idInfo.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label nameInfo = new Label("ሙሉ ስም");
        nameInfo.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        gridPane.add(idInfo, 0, 4);
        gridPane.add(tIdSearch, 0, 5);

        Hyperlink selectAll = new Hyperlink("ቅጽ የሞሉ ሙሉ አባላት");
        selectAll.setFont(Font.font("Nyala", FontPosture.REGULAR, 16));
        selectAll.setTextFill(Color.BLUE);

        selectAll.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                table = new TableView();
                table.setId("table");
                table.setMaxSize(900, 600);

                Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditingCell();
                    }
                };

                //Set up the columns
                TableColumn firstNameCol = new TableColumn("የመጀመሪያ ስም");
                firstNameCol.setMinWidth(120);
                firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
                firstNameCol.setCellFactory(cellFactory);
                TableColumn lastNameCol = new TableColumn("የአባት ስም");
                lastNameCol.setMinWidth(120);
                lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
                lastNameCol.setCellFactory(cellFactory);
                //lastNameCol.setEditable( false );

                TableColumn primaryEmailColG = new TableColumn("የትውልድ ጊዜ");
                primaryEmailColG.setMinWidth(120);
                primaryEmailColG.setCellValueFactory(new PropertyValueFactory<Person, String>("grandName"));
                primaryEmailColG.setCellFactory(cellFactory);
                //Make this column un-editable        

                TableColumn secondaryEmailColB = new TableColumn("የንስሃ አባት ስም");
                secondaryEmailColB.setMinWidth(120);
                secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
                secondaryEmailColB.setCellFactory(cellFactory);

                TableColumn firstNameColW = new TableColumn("ፎርም የሞሉበት ጊዜ");
                firstNameColW.setMinWidth(150);
                firstNameColW.setCellValueFactory(new PropertyValueFactory<Person, String>("wereda"));
                firstNameColW.setCellFactory(cellFactory);
                TableColumn lastNameColKt = new TableColumn("ስልክ ቁጥር");
                lastNameColKt.setMinWidth(150);
                lastNameColKt.setCellValueFactory(new PropertyValueFactory<Person, String>("ketema"));
                lastNameColKt.setCellFactory(cellFactory);

                //Make this column un-editable        
                TableColumn secondaryEmailColId = new TableColumn("መለያ ቁጥር");
                secondaryEmailColId.setId("table");
                secondaryEmailColId.setMinWidth(80);
                secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<Person, String>("idNumber"));
                secondaryEmailColId.setCellFactory(cellFactory);

                table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, secondaryEmailColB, firstNameColW, lastNameColKt);
                //Make the table editable
                table.setEditable(true);
                // table.setId("table");

                //Modifying the firstName property
                secondaryEmailColId.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdNumber(t.getNewValue());
                        colName = "መለያቁጥር";
                        newValue = t.getNewValue();
                        tableName = "NameBirthB";
                        idString = "መለያቁጥር";
                    }
                });
                firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                        newValue = t.getNewValue();
                        colName = "የመጀመሪያስም";
                        tableName = "NameBirthB";
                        idString = "መለያቁጥር";
                    }
                });
                //Modifying the lastName property
                lastNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {

                        ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());

                        colName = "የአባትስም";
                        newValue = t.getNewValue();
                        tableName = "NameBirthB";
                        idString = "መለያቁጥር";

                    }
                });
                //Modifying the primary email property
                primaryEmailColG.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrandName(t.getNewValue());
                        colName = "የትውልድጊዜ";
                        newValue = t.getNewValue();
                        tableName = "NameBirthB";
                        idString = "መለያቁጥር";
                    }
                });
                //Modifying the secondary email property
                secondaryEmailColB.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBirthDate(t.getNewValue());
                        colName = "HollyFather";
                        newValue = t.getNewValue();
                        tableName = "CurrentServiceTable";
                        idString = "IDNO";
                    }
                });
                firstNameColW.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWereda(t.getNewValue());
                        colName = "Ageligilot";
                        newValue = t.getNewValue();
                        tableName = "CurrentServiceTable";
                        idString = "IDNO";
                    }
                });
                lastNameColKt.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKetema(t.getNewValue());
                        colName = "LiveMobile";
                        newValue = t.getNewValue();
                        tableName = "LiveAddressTable";
                        idString = "IDNO";
                    }
                });

                data1.clear();
                try {
                    Class.forName("org.h2.Driver");
                    try {
                        try {
                            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                        } catch (Exception y) {
                        }
                        con = cp.getConnection();

                    } catch (Exception l) {
                    }
                    String sql = "SELECT NameBirthB.መለያቁጥር,NameBirthB.የመጀመሪያስም,NameBirthB.የአባትስም,NameBirthB.የትውልድጊዜ,CurrentServiceTable.HollyFather,CurrentServiceTable.Ageligilot,LiveAddressTable.LiveMobile"
                            + " FROM NameBirthB INNER JOIN CurrentServiceTable ON NameBirthB.መለያቁጥር=CurrentServiceTable.IDNO INNER JOIN LiveAddressTable"
                            + " ON NameBirthB.መለያቁጥር=LiveAddressTable.IDNO";
                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    while (rs.next()) {

                        data1.add(new Person(
                                rs.getString("መለያቁጥር"),
                                rs.getString("የመጀመሪያስም"),
                                rs.getString("የአባትስም"),
                                rs.getString("የትውልድጊዜ"),
                                rs.getString("HollyFather"),
                                rs.getString("Ageligilot"),
                                rs.getString("LiveMobile")));
                        table.setItems(data1);
                    }
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
                }

                GridPane.setColumnSpan(table, 10);
                GridPane.setRowSpan(table, 40);

                infoUpdate = new Button("አስተካክል");
                infoUpdate.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));

                Button infoOut = new Button("መረጃውን ፋይል ላይ ገልብጥ");
                infoOut.setFont(Font.font("Nyala", FontWeight.BOLD, FontPosture.REGULAR, 18));
                HBox infoHbox = new HBox();
                infoHbox.setAlignment(Pos.BASELINE_LEFT);
                infoHbox.setSpacing(20);
                infoHbox.setPadding(new Insets(5, 5, 5, 5));
                infoHbox.getChildren().addAll(infoOut, infoUpdate);
                VBox infoVbox = new VBox();
                infoVbox.setAlignment(Pos.CENTER);
                infoVbox.setSpacing(100);
                // infoVbox.setMaxSize(1000,900);
                infoVbox.setPadding(new Insets(5, 5, 5, 5));
                infoVbox.getChildren().addAll(table, infoHbox);

                table.setOnKeyReleased(e -> {
                    //iView2.setImage(null);
                    if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.DOWN) {
                        try {
                            Person person = (Person) table.getSelectionModel().getSelectedItem();
                            // int phoId = Integer.parseInt(tIdSearch.getText());
                            String query = "SELECT * FROM Pic1 WHERE መለያቁጥር = ?";
                            pst = con.prepareStatement(query);
                            pst.setString(1, person.getIdNumber());
                            rs = pst.executeQuery();
                            while (rs.next()) {
                                InputStream in = rs.getBinaryStream("ፎቶግራፍ");
                                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                                byte[] content = new byte[1024];
                                int size = 0;
                                while ((size = in.read(content)) != -1) {
                                    os.write(content, 0, size);
                                }
                                os.close();
                                in.close();
                                imagePhoto = new Image("File:photo.jpg", 100, 150, true, true);
                                iView2 = new ImageView(imagePhoto);
                                iView2.setFitHeight(150);
                                iView2.setFitWidth(100);
                                iView2.setPreserveRatio(true);
                                gridPane.add(iView2, 0, 12);
                            }
                            pst.close();
                            rs.close();
                        } catch (Exception ex) {

                        }

                    }
                });
                table.setOnMouseClicked(e -> {
                    //  iView2.setImage(null);
                    Image noImage = new Image(getClass().getResourceAsStream("/mkproject/Image/Nophoto.jpg"));
                    try {
                        Person person = (Person) table.getSelectionModel().getSelectedItem();
                        // int phoId = Integer.parseInt(tIdSearch.getText());
                        String query = "SELECT * FROM Pic1 WHERE መለያቁጥር = ?";
                        pst = con.prepareStatement(query);
                        pst.setString(1, person.getIdNumber());

                        rs = pst.executeQuery();
                        String idN = null;
                        while (rs.next()) {
                            InputStream in = rs.getBinaryStream("ፎቶግራፍ");
                            OutputStream os = new FileOutputStream(new File("photo.jpg"));
                            byte[] content = new byte[1024];
                            int size = 0;
                            while ((size = in.read(content)) != -1) {
                                os.write(content, 0, size);
                            }
                            os.close();
                            in.close();
                            imagePhoto = new Image("File:photo.jpg", 160, 180, true, true);
                            System.out.println("IDTable=" + person.getIdNumber());
                            System.out.println("IDPhoto=" + rs.getString("መለያቁጥር"));
                            if (rs.next() == false) {
                                iView2 = new ImageView(imagePhoto);
                                iView2.setFitHeight(150);
                                iView2.setFitWidth(100);
                                iView2.setPreserveRatio(true);
                                gridPane.add(iView2, 0, 12);
                            }

                            if (rs.next() == true) {

                                iView3 = new ImageView(noImage);
                                iView3.setFitHeight(150);
                                iView3.setFitWidth(100);
                                iView3.setPreserveRatio(true);
                                gridPane.add(iView3, 0, 12);
                            }

                        }

                        pst.close();
                        rs.close();
                    } catch (Exception ex) {

                    }

                });

                gridPane9.add(infoVbox, 1, 1);
                infoUpdate.setOnAction(e
                        -> {
                    new SampleFX1().textInput(tableName, colName, newValue, idString);
                }
                );
                infoOut.setOnAction(e
                        -> {
                    new JavaFxApplication1().exportData();
                }
                );

            }
        });

        Label selectInfo = new Label(" የሚፈልጉትን የመረጃ አይነት ይምረጡ!");
        selectInfo.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        gridPane.add(selectInfo, 0, 6);

        cSelectJob = new ComboBox();
        cSelectJob.getItems().addAll(
                "የማንነት መረጃ",
                "ስላለፈ ተሳትፎ መረጃ",
                "የስራው/ዋ መረጃ",
                "ወቅታዊ መረጃ", "የቅርብ ተጠሪ መረጃ");
        cSelectJob.setPromptText("የመረጃ አይነት");
        cSelectJob.setEditable(true);
        cSelectJob.setId("table");
        gridPane.add(cSelectJob, 0, 7);

        Button butSearch = new Button("ፈልግ");
        butSearch.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butSearch.setStyle("-fx-text-fill: black;");

        Button butNew = new Button("አዲስ");
        butNew.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butNew.setStyle("-fx-text-fill: black;");

        HBox hBut = new HBox();
        hBut.setSpacing(12);
        hBut.setAlignment(Pos.CENTER);
        hBut.getChildren().addAll(butSearch, butNew);
        gridPane.add(hBut, 0, 9);

        gridPane.add(selectAll, 0, 10);

        butSearch.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {
                personalInfo(eve);

            }
        });
        butNew.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                tIdSearch.setText("");
                cSelectJob.setValue("የመረጃ አይነት");

            }
        });

        border.setLeft(gridPane);
        border.setCenter(gridPane9);
    }

    public void personalInfo(ActionEvent eve) {
        Label fullName = new Label("ሙሉ ስም: ");
        fullName.setFont(Font.font("Nyala", FontWeight.BOLD, 16));

        Label birthTime = new Label("የትውልድ ጊዜ: ");
        birthTime.setFont(Font.font("Nyala", FontWeight.BOLD, 16));

        Label kiristinaName = new Label("ስመ ክርስትና: ");
        kiristinaName.setFont(Font.font("Nyala", FontWeight.BOLD, 16));

        Label kihinetName = new Label("ክህነት: ");
        kihinetName.setFont(Font.font("Nyala", FontWeight.BOLD, 16));

        Label kiristinaNameB = new Label("ክርስትና የተነሱበት ቤ/ክ: ");
        kiristinaNameB.setFont(Font.font("Nyala", FontWeight.BOLD, 16));

        Label kihinetNameK = new Label("ክህነት የተቀበሉበት ዘመን: ");
        kihinetNameK.setFont(Font.font("Nyala", FontWeight.BOLD, 16));

        Label lSex = new Label("ፆታ: ");
        lSex.setFont(Font.font("Nyala", FontWeight.BOLD, 16));

        Label photo = new Label("ፎቶ ግራፍ: ");
        photo.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        iView = new ImageView();
        iView.setFitHeight(160);
        iView.setFitWidth(160);

        GridPane.setRowSpan(iView, 4);
        Label startAw = new Label("አውራጃ: ");
        startAw.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startHs = new Label("መንፈሳዊ ት/ት የጀመሩበት ሀ/ስብከት: ");
        startHs.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startHs1 = new Label("ሀ/ስብከት: ");
        startHs1.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startDe = new Label("ቀ/ገ/ማዕበር(ደብር): ");
        startDe.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startBk = new Label("ቤ/ክርስቲያን: ");
        startBk.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startBk1 = new Label("ቤ/ክርስቲያን: ");
        startBk1.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startHS = new Label(": ");
        startHS.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startUni = new Label("ከፍተኛ ትምህርት የተከታተሉበት ተቋም: ");
        startUni.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startTi = new Label("የቆዩበት ጊዜ: ");
        startTi.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startKt = new Label("በከፍተኛ ትምህርት ተቋም በቆዩበት ጊዜ መንፈሳዊ ትምህርት የተከታተሉበት: ");
        startKt.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startSt = new Label("ሰንበት ት/ቤት: ");
        startSt.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startGf = new Label("የተመረቁበት ሙያ: ");
        startGf.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        Label startSs = new Label("አባል የሆኑባቸው ሰንበት ት/ቤቶች ወይም ሰበካ ጉባዔ: ");
        startSs.setFont(Font.font("Nyala", FontWeight.BOLD, 16));
        GridPane.setColumnSpan(startSs, 3);
        GridPane.setColumnSpan(startKt, 3);

        Label labelJobHS = new Label("ሀ /ስብከት :");
        labelJobHS.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobHS.setTextFill(Color.BLACK);

        Label labelJobZone = new Label("ዞን :");
        labelJobZone.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobZone.setTextFill(Color.BLACK);

        Label labelJobWereda = new Label("ወረዳ :");
        labelJobWereda.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobWereda.setTextFill(Color.BLACK);

        Label labelJobKetema = new Label("ከተማ :");
        labelJobKetema.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKetema.setTextFill(Color.BLACK);

        Label labelJobKebele = new Label("ቀበሌ :");
        labelJobKebele.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKebele.setTextFill(Color.BLACK);

        Label labelJobGebere = new Label("ቀ/ገ/ማኅበር:");
        labelJobGebere.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobGebere.setTextFill(Color.BLACK);

        Label labelJobType = new Label("የሥራ ዘርፍ  :");
        labelJobType.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobType.setTextFill(Color.BLACK);

        Label labelJobHouse = new Label("መ/ቤት:");
        labelJobHouse.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobHouse.setTextFill(Color.BLACK);

        Label labelJobPhone = new Label("ስ/ቁ(የመ/ቤት) :");
        labelJobPhone.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobPhone.setTextFill(Color.BLACK);

        Label labelJobGene = new Label("          ስራ የተመደቡበት አካባቢ መረጃ:");
        labelJobGene.setFont(Font.font("Nyala", FontPosture.REGULAR, 19));
        labelJobGene.setTextFill(Color.BLACK);
        GridPane.setColumnSpan(labelJobGene, 2);

        Label labelJobHSt = new Label("ሙሉ ስም:");
        labelJobHSt.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobHSt.setTextFill(Color.BLACK);

        Label labelJobKetemat = new Label("ከተማ :");
        labelJobKetemat.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKetemat.setTextFill(Color.BLACK);

        Label labelJobKebelet = new Label("ወረዳ :");
        labelJobKebelet.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKebelet.setTextFill(Color.BLACK);

        Label labelJobGeberet = new Label("ቀበሌ:");
        labelJobGeberet.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobGeberet.setTextFill(Color.BLACK);

        Label labelJobTypet = new Label("የቤት ቁጥር :");
        labelJobTypet.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobTypet.setTextFill(Color.BLACK);

        Label labelJobHouset = new Label("ስ.ቁ(የቤት):");
        labelJobHouset.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobHouset.setTextFill(Color.BLACK);

        Label labelJobPhonet = new Label("ሞባይል ቁጥር:");
        labelJobPhonet.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobPhonet.setTextFill(Color.BLACK);

        Label labelJobGenet = new Label("       የቅርብ ተጠሪ ሰው  መረጃ:");
        labelJobGenet.setFont(Font.font("Nyala", FontPosture.REGULAR, 19));
        labelJobGenet.setTextFill(Color.BLACK);
        GridPane.setColumnSpan(labelJobGenet, 2);

        Label labelJobHSl = new Label("የመኖርያ አድራሻና ወቅታዊ ጉዳይ በተመለከተ መረጃ:");
        labelJobHSl.setFont(Font.font("Nyala", FontPosture.REGULAR, 19));
        labelJobHSl.setTextFill(Color.BLACK);
        GridPane.setColumnSpan(labelJobHSl, 2);

        Label labelJobZonel = new Label("ከተማ :");
        labelJobZonel.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobZonel.setTextFill(Color.BLACK);

        Label labelJobWeredal = new Label("ከፍተኛ :");
        labelJobWeredal.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobWeredal.setTextFill(Color.BLACK);

        Label labelJobKetemal = new Label("ቀበሌ:");
        labelJobKetemal.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKetemal.setTextFill(Color.BLACK);

        Label labelJobKebelel = new Label("የቤት ቁጥር :");
        labelJobKebelel.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKebelel.setTextFill(Color.BLACK);

        Label labelJobGeberel = new Label("ስ/ቁ (የቤት):");
        labelJobGeberel.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobGeberel.setTextFill(Color.BLACK);

        Label labelJobTypel = new Label("ሞባይል ቁጥር :");
        labelJobTypel.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobTypel.setTextFill(Color.BLACK);

        Label labelJobHousel = new Label("መተዳደሪያ ና ልዩ ሙያ:");
        labelJobHousel.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobHousel.setTextFill(Color.BLACK);

        Label labelJobPhonel = new Label("የትምህርት ደረጃ::");
        labelJobPhonel.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobPhonel.setTextFill(Color.BLACK);

        Label labelJobHSlc = new Label("     በአሁኑ ወቅት አገልግሎት እየሰጡ(እያገኙ) ያሉበት ቤተ ክርስትያን መረጃ:");
        labelJobHSlc.setFont(Font.font("Nyala", FontPosture.REGULAR, 19));
        labelJobHSlc.setTextFill(Color.BLACK);
        GridPane.setColumnSpan(labelJobHSlc, 2);

        Label labelJobZonelc = new Label("የቤተ ክርስትያኑ ስም :");
        labelJobZonelc.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobZonelc.setTextFill(Color.BLACK);

        Label labelJobWeredalc = new Label("የክህነት ማዕረግ:");
        labelJobWeredalc.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobWeredalc.setTextFill(Color.BLACK);

        Label labelJobKetemalc = new Label("በሰንበት ት/ቤት የሥራ ድርሻ:");
        labelJobKetemalc.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKetemalc.setTextFill(Color.BLACK);

        Label labelJobKebelelc = new Label("በሰበካ ጉባኤ የሥራ ድርሻ :");
        labelJobKebelelc.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobKebelelc.setTextFill(Color.BLACK);

        Label labelJobGeberelc = new Label("የሰበካ ጉባኤ(የሰ/ት/ቤት) መ/ቁጥር:");
        labelJobGeberelc.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobGeberelc.setTextFill(Color.BLACK);

        Label labelJobTypelc = new Label("የንስሐ አባት ስም :");
        labelJobTypelc.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobTypelc.setTextFill(Color.BLACK);

        Label labelJobHouselc = new Label("የአገልግሎት ምርጫ/ክፍል :");
        labelJobHouselc.setFont(Font.font("Nyala", FontPosture.REGULAR, 18));
        labelJobHouselc.setTextFill(Color.BLACK);

        Label ket1 = new Label("ከተማ : ");
        ket1.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ket1.setTextFill(Color.BLACK);

        Label ketw1 = new Label("ወረዳ :");
        ketw1.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ketw1.setTextFill(Color.BLACK);

        Label ketk1 = new Label("ቀበሌ :");
        ketk1.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ketk1.setTextFill(Color.BLACK);
        //  lFullName = new Label();
        ket = new Label();
        ket.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ket.setTextFill(Color.BLACK);

        ketw = new Label();
        ketw.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ketw.setTextFill(Color.BLACK);

        ketk = new Label();
        ketk.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ketk.setTextFill(Color.BLACK);
        lFullName = new Label();

        lFullName.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        lBirthTime = new Label();
        lBirthTime.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        lKiristinaName = new Label();
        lKiristinaName.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        lKihinetName = new Label();
        lKihinetName.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        lKihinet = new Label();
        lKihinet.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        lKirstina = new Label();
        lKirstina.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        lLangSkil3 = new Label();
        lLangSkil3.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        lPhoneSearch = new Label();
        lPhoneSearch.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        // lHsibket,lDebir,lAwraja,lBk,lAbal,lAbal2,lTequam,lStay,lUniHsibket,lUniBk,lUniSenbet,lUniMuya;
        lHsibket = new Label();
        lHsibket.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lDebir = new Label();
        lDebir.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAwraja = new Label();
        lAwraja.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lBk = new Label();
        lBk.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbal = new Label();
        lAbal.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbal2 = new Label();
        lAbal2.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lTequam = new Label();
        lTequam.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lStay = new Label();
        lStay.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lUniHsibket = new Label();
        lUniHsibket.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lUniBk = new Label();
        lUniBk.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lUniSenbet = new Label();
        lUniSenbet.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lUniMuya = new Label();
        lUniMuya.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        GridPane.setColumnSpan(lAbal, 3);
        GridPane.setColumnSpan(lAbal2, 3);
        lHsibketj = new Label();
        lHsibketj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lDebirj = new Label();
        lDebirj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAwrajaj = new Label();
        lAwrajaj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lBkj = new Label();
        lBkj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbalj = new Label();
        lAbalj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbal2j = new Label();
        lAbal2j.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lTequamj = new Label();
        lTequamj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lStayj = new Label();
        lStayj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lUniHsibketj = new Label();
        lUniHsibketj.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lHsibketjt = new Label();
        lHsibketjt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lDebirjt = new Label();
        lDebirjt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAwrajajt = new Label();
        lAwrajajt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lBkjt = new Label();
        lBkjt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbaljt = new Label();
        lAbaljt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbal2jt = new Label();
        lAbal2jt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lTequamjt = new Label();
        lTequamjt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lStayjt = new Label();
        lStayjt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lUniHsibketjt = new Label();
        lUniHsibketjt.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lHsibketjtl = new Label();
        lHsibketjtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lDebirjtl = new Label();
        lDebirjtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAwrajajtl = new Label();
        lAwrajajtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lBkjtl = new Label();
        lBkjtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbaljtl = new Label();
        lAbaljtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbal2jtl = new Label();
        lAbal2jtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lTequamjtl = new Label();
        lTequamjtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lStayjtl = new Label();
        lStayjtl.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lHsibketjtlc = new Label();
        lHsibketjtlc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lDebirjtlc = new Label();
        lDebirjtlc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAwrajajtlc = new Label();
        lAwrajajtlc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lBkjtlc = new Label();
        lBkjtlc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbaljtlc = new Label();
        lAbaljtlc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lAbal2jtlc = new Label();
        lAbal2jtlc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        lTequamjtlc = new Label();
        lTequamjtlc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        Button butCorr = new Button("አስተካክል");
        butCorr.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butCorr.setStyle("-fx-text-fill: black;");

        Button butReg = new Button("መዝግብ");
        butReg.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        butReg.setStyle("-fx-text-fill: black;");

        HBox hBut = new HBox();
        hBut.setSpacing(12);
        hBut.setAlignment(Pos.CENTER);
        hBut.getChildren().addAll(butCorr, butReg);

        tFn = new TextField();
        tFn.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tFa = new TextField();
        tFa.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tGn = new TextField();
        tGn.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        HBox hButN = new HBox();
        hButN.setSpacing(12);
        hButN.setAlignment(Pos.BASELINE_LEFT);
        hButN.getChildren().addAll(tFn, tFa, tGn);
        tSe = new TextField();
        tSe.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tBdate = new TextField();
        tBdate.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tWer = new TextField();
        tWer.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tCity = new TextField();
        tCity.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tKeb = new TextField();
        tKeb.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tKir = new TextField();
        tKir.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tKbk = new TextField();
        tKbk.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tKih = new TextField();
        tKih.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tKibk = new TextField();
        tKibk.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        t1 = new TextField();
        t1.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t2 = new TextField();
        t2.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t3 = new TextField();
        t3.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t4 = new TextField();
        t4.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t5 = new TextField();
        t5.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t6 = new TextField();
        t6.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t7 = new TextField();
        t7.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t8 = new TextField();
        t8.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t9 = new TextField();
        t9.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t10 = new TextField();
        t10.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t11 = new TextField();
        t11.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t12 = new TextField();
        t12.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t13 = new TextField();
        t13.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t14 = new TextField();
        t14.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t15 = new TextField();
        t15.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t16 = new TextField();
        t16.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        t20 = new TextField();
        t20.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t21 = new TextField();
        t21.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t31 = new TextField();
        t31.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t41 = new TextField();
        t41.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t51 = new TextField();
        t51.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t61 = new TextField();
        t61.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t71 = new TextField();
        t71.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t81 = new TextField();
        t81.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t91 = new TextField();
        t91.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t101 = new TextField();
        t101.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t111 = new TextField();
        t111.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t121 = new TextField();
        t121.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t131 = new TextField();
        t131.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t141 = new TextField();
        t141.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t151 = new TextField();
        t151.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tIDNO = new TextField();
        tIDNO.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t201 = new TextField();
        t201.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t211 = new TextField();
        t211.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t311 = new TextField();
        t311.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t411 = new TextField();
        t411.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t511 = new TextField();
        t511.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t611 = new TextField();
        t611.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t711 = new TextField();
        t711.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t811 = new TextField();
        t811.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        t911 = new TextField();
        t911.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ta = new TextField();
        ta.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tb = new TextField();
        tb.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tc = new TextField();
        tc.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        td = new TextField();
        td.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        te = new TextField();
        te.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tf = new TextField();
        tf.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        tg = new TextField();
        tg.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        th = new TextField();
        th.setFont(Font.font("Nyala", FontWeight.BOLD, 18));
        ti = new TextField();
        ti.setFont(Font.font("Nyala", FontWeight.BOLD, 18));

        gridPane3.getChildren().clear();
        gridPane5.getChildren().clear();
        gridPane6.getChildren().clear();
        gridPane7.getChildren().clear();
        gridPane8.getChildren().clear();
// final SwingNode swingNode = new SwingNode();
//             swingContent(swingNode);
//             HBox hbo = new HBox();
//            // hbo.setAlignment(Pos.CENTER);
//            hbo.setMaxSize(200,200);
//             GridPane.setRowSpan(hbo,4);
//             hbo.getChildren().add(swingNode);
        switch (cSelectJob.getValue().toString()) {
            case "የማንነት መረጃ":
                gridPane3.getChildren().clear();
                gridPane3.setVgap(10);
                gridPane3.setHgap(20);
                gridPane3.setPadding(new Insets(10, 10, 10, 10));
                border.setCenter(gridPane3);
                gridPane3.add(fullName, 0, 6);

                gridPane3.add(birthTime, 0, 7);
                gridPane3.add(ketw1, 0, 8);
                gridPane3.add(ket1, 0, 9);
                gridPane3.add(ketk1, 0, 10);
                gridPane3.add(kiristinaName, 0, 11);
                gridPane3.add(kiristinaNameB, 0, 12);
                gridPane3.add(kihinetName, 0, 13);
                gridPane3.add(kihinetNameK, 0, 14);
                gridPane3.add(photo, 0, 15);
                gridPane3.add(hBut, 1, 20);
                display(eve);
                gridPane3.add(lFullName, 1, 6);
                gridPane3.add(lBirthTime, 1, 7);
                gridPane3.add(ketw, 1, 8);
                gridPane3.add(ket, 1, 9);
                gridPane3.add(ketk, 1, 10);
                display1(eve);
                gridPane3.add(lKiristinaName, 1, 11);
                gridPane3.add(lKirstina, 1, 12);
                gridPane3.add(lKihinetName, 1, 13);
                gridPane3.add(lKihinet, 1, 14);
                displayPhoto();
                gridPane3.add(iView, 1, 15);

                butCorr.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        gridPane3.getChildren().clear();
                        gridPane3.setVgap(7);
                        gridPane3.setHgap(15);
                        gridPane3.setPadding(new Insets(10, 10, 10, 10));
                        border.setCenter(gridPane3);
                        gridPane3.add(fullName, 0, 5);
                        gridPane3.add(lSex, 0, 8);
                        gridPane3.add(birthTime, 0, 9);
                        gridPane3.add(ketw1, 0, 10);
                        gridPane3.add(ket1, 0, 11);
                        gridPane3.add(ketk1, 0, 12);
                        gridPane3.add(kiristinaName, 0, 13);
                        gridPane3.add(kiristinaNameB, 0, 14);
                        gridPane3.add(kihinetName, 0, 15);
                        gridPane3.add(kihinetNameK, 0, 16);
                        gridPane3.add(photo, 0, 17);

                        tBdate.setText(lBirthTime.getText());
                        tWer.setText(ketw.getText());
                        tCity.setText(ket.getText());
                        tKeb.setText(ketk.getText());
                        gridPane3.add(tFn, 1, 5);
                        gridPane3.add(tFa, 1, 6);
                        gridPane3.add(tGn, 1, 7);

                        gridPane3.add(tBdate, 1, 9);
                        gridPane3.add(tWer, 1, 10);
                        gridPane3.add(tCity, 1, 11);
                        gridPane3.add(tKeb, 1, 12);
                        tKir.setText(lKiristinaName.getText());
                        tKbk.setText(lKirstina.getText());
                        tKih.setText(lKihinetName.getText());
                        tKibk.setText(lKihinet.getText());

                        gridPane3.add(tKir, 1, 13);
                        gridPane3.add(tKbk, 1, 14);
                        gridPane3.add(tKih, 1, 15);
                        gridPane3.add(tKibk, 1, 16);
                        gridPane3.add(hBut, 1, 20);
                        butReg.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent eve) {
                                updateN(eve);

                            }
                        });

                    }
                });

                break;
            case "ስላለፈ ተሳትፎ መረጃ":
                gridPane5.getChildren().clear();
                gridPane5.setVgap(10);
                gridPane5.setHgap(20);
                gridPane5.setPadding(new Insets(10, 10, 10, 10));
                border.setCenter(gridPane5);
                gridPane5.add(startHs, 0, 5);
                gridPane5.add(startDe, 0, 6);
                gridPane5.add(startAw, 0, 7);
                gridPane5.add(startBk, 0, 8);
                gridPane5.add(startSs, 0, 9);
                gridPane5.add(startKt, 0, 14);
                gridPane5.add(startUni, 0, 12);
                gridPane5.add(startTi, 0, 13);
                gridPane5.add(startHs1, 0, 15);
                gridPane5.add(startBk1, 0, 16);
                gridPane5.add(startSt, 0, 17);
                gridPane5.add(startGf, 0, 18);
                gridPane5.add(hBut, 1, 20);

                displayBack(eve);

                gridPane5.add(lHsibket, 1, 5);
                gridPane5.add(lDebir, 1, 6);
                gridPane5.add(lAwraja, 1, 7);
                gridPane5.add(lBk, 1, 8);
                displayBack2(eve);
                gridPane5.add(lAbal, 0, 10);
                gridPane5.add(lAbal2, 0, 11);
                gridPane5.add(lTequam, 1, 12);
                gridPane5.add(lStay, 1, 13);
                gridPane5.add(lUniHsibket, 1, 15);
                gridPane5.add(lUniBk, 1, 16);
                gridPane5.add(lUniSenbet, 1, 17);
                gridPane5.add(lUniMuya, 1, 18);
                butCorr.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        gridPane5.getChildren().clear();
                        gridPane5.setVgap(10);
                        gridPane5.setHgap(20);
                        gridPane5.setPadding(new Insets(10, 10, 10, 10));
                        border.setCenter(gridPane5);
                        gridPane5.add(startHs, 0, 5);
                        gridPane5.add(startDe, 0, 6);
                        gridPane5.add(startAw, 0, 7);
                        gridPane5.add(startBk, 0, 8);
                        gridPane5.add(startSs, 0, 9);
                        gridPane5.add(startKt, 0, 14);
                        gridPane5.add(startUni, 0, 12);
                        gridPane5.add(startTi, 0, 13);
                        gridPane5.add(startHs1, 0, 15);
                        gridPane5.add(startBk1, 0, 16);
                        gridPane5.add(startSt, 0, 17);
                        gridPane5.add(startGf, 0, 18);
                        gridPane5.add(hBut, 1, 20);

                        t1.setText(lHsibket.getText());
                        t2.setText(lDebir.getText());
                        t3.setText(lAwraja.getText());
                        t4.setText(lBk.getText());
                        t5.setText(lAbal.getText());
                        t6.setText(lAbal2.getText());
                        GridPane.setColumnSpan(t5, 3);
                        GridPane.setColumnSpan(t6, 3);
                        t7.setText(lTequam.getText());
                        t8.setText(lStay.getText());
                        t9.setText(lUniHsibket.getText());
                        t10.setText(lUniBk.getText());
                        t11.setText(lUniSenbet.getText());
                        t12.setText(lUniMuya.getText());

                        gridPane5.add(t1, 1, 5);
                        gridPane5.add(t2, 1, 6);
                        gridPane5.add(t3, 1, 7);
                        gridPane5.add(t4, 1, 8);

                        gridPane5.add(t5, 0, 10);
                        gridPane5.add(t6, 0, 11);
                        gridPane5.add(t7, 1, 12);
                        gridPane5.add(t8, 1, 13);
                        gridPane5.add(t9, 1, 15);
                        gridPane5.add(t10, 1, 16);
                        gridPane5.add(t11, 1, 17);
                        gridPane5.add(t12, 1, 18);

                        butReg.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent eve) {
                                updateUS(eve);

                            }
                        });
                    }
                });

                break;
            case "የስራው/ዋ መረጃ":
                gridPane6.getChildren().clear();
                gridPane6.setVgap(10);
                gridPane6.setHgap(20);
                gridPane6.setPadding(new Insets(10, 10, 10, 10));
                border.setCenter(gridPane6);
                gridPane6.add(labelJobGene, 0, 5);
                gridPane6.add(labelJobHS, 0, 6);
                gridPane6.add(labelJobZone, 0, 7);
                gridPane6.add(labelJobWereda, 0, 8);
                gridPane6.add(labelJobKetema, 0, 9);
                gridPane6.add(labelJobKebele, 0, 10);
                gridPane6.add(labelJobGebere, 0, 11);
                gridPane6.add(labelJobType, 0, 12);
                gridPane6.add(labelJobHouse, 0, 13);
                gridPane6.add(labelJobPhone, 0, 14);
                gridPane6.add(hBut, 1, 16);

                displayJobLife(eve);
                gridPane6.add(lHsibketj, 1, 6);
                gridPane6.add(lDebirj, 1, 7);
                gridPane6.add(lAwrajaj, 1, 8);
                gridPane6.add(lBkj, 1, 9);
                gridPane6.add(lAbalj, 1, 10);
                gridPane6.add(lAbal2j, 1, 11);
                gridPane6.add(lTequamj, 1, 12);
                gridPane6.add(lStayj, 1, 13);
                gridPane6.add(lUniHsibketj, 1, 14);

                butCorr.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        gridPane6.getChildren().clear();
                        ta.setText(lHsibketj.getText());
                        tb.setText(lDebirj.getText());
                        tc.setText(lAwrajaj.getText());
                        td.setText(lBkj.getText());
                        te.setText(lAbalj.getText());
                        tf.setText(lAbal2j.getText());

                        tg.setText(lTequamj.getText());
                        th.setText(lStayj.getText());
                        ti.setText(lUniHsibketj.getText());

                        gridPane6.setVgap(10);
                        gridPane6.setHgap(20);
                        gridPane6.setPadding(new Insets(10, 10, 10, 10));
                        border.setCenter(gridPane6);
                        gridPane6.add(labelJobGene, 0, 5);
                        gridPane6.add(labelJobHS, 0, 6);
                        gridPane6.add(labelJobZone, 0, 7);
                        gridPane6.add(labelJobWereda, 0, 8);
                        gridPane6.add(labelJobKetema, 0, 9);
                        gridPane6.add(labelJobKebele, 0, 10);
                        gridPane6.add(labelJobGebere, 0, 11);
                        gridPane6.add(labelJobType, 0, 12);
                        gridPane6.add(labelJobHouse, 0, 13);
                        gridPane6.add(labelJobPhone, 0, 14);
                        gridPane6.add(hBut, 1, 16);

                        gridPane6.add(ta, 1, 6);
                        gridPane6.add(tb, 1, 7);
                        gridPane6.add(tc, 1, 8);
                        gridPane6.add(td, 1, 9);
                        gridPane6.add(te, 1, 10);
                        gridPane6.add(tf, 1, 11);
                        gridPane6.add(tg, 1, 12);
                        gridPane6.add(th, 1, 13);
                        gridPane6.add(ti, 1, 14);

                    }
                });

                butReg.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        updateUJ(eve);

                    }
                });

                break;
            case "ወቅታዊ መረጃ":

                gridPane8.setVgap(10);
                gridPane8.setHgap(20);
                gridPane8.setPadding(new Insets(10, 10, 10, 10));
                gridPane8.getChildren().clear();
                border.setCenter(gridPane8);
                gridPane8.add(labelJobHSl, 0, 5);
                gridPane8.add(labelJobZonel, 0, 6);
                gridPane8.add(labelJobWeredal, 0, 7);
                gridPane8.add(labelJobKetemal, 0, 8);
                gridPane8.add(labelJobKebelel, 0, 9);
                gridPane8.add(labelJobGeberel, 0, 10);
                gridPane8.add(labelJobTypel, 0, 11);
                gridPane8.add(labelJobHousel, 0, 12);
                gridPane8.add(labelJobPhonel, 0, 13);
                gridPane8.add(labelJobHSlc, 0, 14);
                gridPane8.add(labelJobZonelc, 0, 15);
                gridPane8.add(labelJobWeredalc, 0, 16);
                gridPane8.add(labelJobKetemalc, 0, 17);
                gridPane8.add(labelJobKebelelc, 0, 18);
                gridPane8.add(labelJobGeberelc, 0, 19);
                gridPane8.add(labelJobTypelc, 0, 20);
                gridPane8.add(labelJobHouselc, 0, 21);
                displayLiveAddress(eve);
                gridPane8.add(lHsibketjtl, 1, 6);
                gridPane8.add(lDebirjtl, 1, 7);
                gridPane8.add(lAwrajajtl, 1, 8);
                gridPane8.add(lBkjtl, 1, 9);
                gridPane8.add(lAbaljtl, 1, 10);
                gridPane8.add(lAbal2jtl, 1, 11);
                gridPane8.add(lTequamjtl, 1, 12);
                gridPane8.add(lStayjtl, 1, 13);
                displayCurrentService(eve);
                gridPane8.add(lHsibketjtlc, 1, 15);
                gridPane8.add(lDebirjtlc, 1, 16);
                gridPane8.add(lAwrajajtlc, 1, 17);
                gridPane8.add(lBkjtlc, 1, 18);
                gridPane8.add(lAbaljtlc, 1, 19);
                gridPane8.add(lAbal2jtlc, 1, 20);
                gridPane8.add(lTequamjtlc, 1, 21);
                gridPane8.add(hBut, 1, 22);
                butCorr.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        gridPane8.getChildren().clear();
                        t20.setText(lHsibketjtl.getText());
                        t21.setText(lDebirjtl.getText());
                        t31.setText(lAwrajajtl.getText());
                        t41.setText(lBkjtl.getText());
                        t51.setText(lAbaljtl.getText());
                        t61.setText(lAbal2jtl.getText());

                        t71.setText(lTequamjtl.getText());
                        t81.setText(lStayjtl.getText());
                        t91.setText(lHsibketjtlc.getText());
                        t101.setText(lDebirjtlc.getText());
                        t111.setText(lAwrajajtlc.getText());
                        t121.setText(lBkjtlc.getText());
                        t131.setText(lAbaljtlc.getText());
                        t141.setText(lAbal2jtlc.getText());

                        t151.setText(lTequamjtlc.getText());

                        gridPane8.setVgap(5);
                        gridPane8.setHgap(20);
                        gridPane8.setPadding(new Insets(10, 10, 10, 10));
                        gridPane8.getChildren().clear();
                        border.setCenter(gridPane8);
                        gridPane8.add(labelJobHSl, 0, 5);
                        gridPane8.add(labelJobZonel, 0, 6);
                        gridPane8.add(labelJobWeredal, 0, 7);
                        gridPane8.add(labelJobKetemal, 0, 8);
                        gridPane8.add(labelJobKebelel, 0, 9);
                        gridPane8.add(labelJobGeberel, 0, 10);
                        gridPane8.add(labelJobTypel, 0, 11);
                        gridPane8.add(labelJobHousel, 0, 12);
                        gridPane8.add(labelJobPhonel, 0, 13);
                        gridPane8.add(labelJobHSlc, 0, 14);
                        gridPane8.add(labelJobZonelc, 0, 15);
                        gridPane8.add(labelJobWeredalc, 0, 16);
                        gridPane8.add(labelJobKetemalc, 0, 17);
                        gridPane8.add(labelJobKebelelc, 0, 18);
                        gridPane8.add(labelJobGeberelc, 0, 19);
                        gridPane8.add(labelJobTypelc, 0, 20);
                        gridPane8.add(labelJobHouselc, 0, 21);

                        gridPane8.add(t20, 1, 6);
                        gridPane8.add(t21, 1, 7);
                        gridPane8.add(t31, 1, 8);
                        gridPane8.add(t41, 1, 9);
                        gridPane8.add(t51, 1, 10);
                        gridPane8.add(t61, 1, 11);
                        gridPane8.add(t71, 1, 12);
                        gridPane8.add(t81, 1, 13);

                        gridPane8.add(t91, 1, 15);
                        gridPane8.add(t101, 1, 16);
                        gridPane8.add(t111, 1, 17);
                        gridPane8.add(t121, 1, 18);
                        gridPane8.add(t131, 1, 19);
                        gridPane8.add(t141, 1, 20);
                        gridPane8.add(t151, 1, 21);
                        gridPane8.add(hBut, 1, 22);
                    }
                });

                butReg.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        updateLAC(eve);

                    }
                });
                break;
            case "የቅርብ ተጠሪ መረጃ":

                gridPane7.setVgap(10);
                gridPane7.setHgap(20);
                gridPane7.setPadding(new Insets(10, 10, 10, 10));
                gridPane7.add(labelJobGenet, 0, 5);
                gridPane7.add(labelJobHSt, 0, 6);
                border.setCenter(gridPane7);
                gridPane7.add(labelJobKetemat, 0, 7);
                gridPane7.add(labelJobKebelet, 0, 8);
                gridPane7.add(labelJobGeberet, 0, 9);
                gridPane7.add(labelJobTypet, 0, 10);
                gridPane7.add(labelJobHouset, 0, 11);
                gridPane7.add(labelJobPhonet, 0, 12);

                displayKiribTeteri(eve);
                gridPane7.add(lHsibketjt, 1, 6);

                gridPane7.add(lBkjt, 1, 7);
                gridPane7.add(lAbaljt, 1, 8);
                gridPane7.add(lAbal2jt, 1, 9);
                gridPane7.add(lTequamjt, 1, 10);
                gridPane7.add(lStayjt, 1, 11);
                gridPane7.add(lUniHsibketjt, 1, 12);
                gridPane7.add(hBut, 1, 14);
                butCorr.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        gridPane7.getChildren().clear();
                        t201.setText(lHsibketjt.getText());
                        t211.setText(lDebirjt.getText());
                        t311.setText(lAwrajajt.getText());
                        t411.setText(lBkjt.getText());
                        t511.setText(lAbaljt.getText());
                        t611.setText(lAbal2jt.getText());

                        t711.setText(lTequamjt.getText());
                        t811.setText(lStayjt.getText());
                        t911.setText(lUniHsibketjt.getText());

                        gridPane7.setVgap(7);
                        gridPane7.setHgap(15);
                        gridPane7.setPadding(new Insets(10, 10, 10, 10));
                        gridPane7.add(labelJobGenet, 0, 5);
                        gridPane7.add(labelJobHSt, 0, 6);
                        border.setCenter(gridPane7);
                        gridPane7.add(labelJobKetemat, 0, 9);
                        gridPane7.add(labelJobKebelet, 0, 10);
                        gridPane7.add(labelJobGeberet, 0, 11);
                        gridPane7.add(labelJobTypet, 0, 12);
                        gridPane7.add(labelJobHouset, 0, 13);
                        gridPane7.add(labelJobPhonet, 0, 14);

                        gridPane7.add(t201, 1, 6);
                        gridPane7.add(t211, 1, 7);

                        gridPane7.add(t311, 1, 8);
                        gridPane7.add(t411, 1, 9);
                        gridPane7.add(t511, 1, 10);
                        gridPane7.add(t611, 1, 11);
                        gridPane7.add(t711, 1, 12);
                        gridPane7.add(t811, 1, 13);
                        gridPane7.add(t911, 1, 14);
                        gridPane7.add(hBut, 1, 16);

                    }
                });

                butReg.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent eve) {
                        updateUKI(eve);

                    }
                });

                break;
        }
    }

    private void displayBack(ActionEvent evt) {
        DatabaseClass.openConnection();
//stuQueries = new DatabaseClass();
        results = stuQueries.getStatusBackLife(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            lHsibket.setText(studata.getHolly());
            lDebir.setText(studata.getBK());
            lAwraja.setText(studata.getKN());
            lBk.setText(studata.getKY());

        }
    }

    private void displayBack2(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getStatusBackLife1(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            lAbal.setText(studata.getFName());
            lAbal2.setText(studata.getMName());
            lTequam.setText(studata.getLName());
            lStay.setText(studata.getBdate());
            lUniHsibket.setText(studata.getWoreda());
            lUniBk.setText(studata.getCity());
            lUniSenbet.setText(studata.getKebele());
            lUniMuya.setText(studata.getGField());

        }
    }

    private void displayJobLife(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getJobLife(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            lHsibketj.setText(studata.getFName());
            lDebirj.setText(studata.getMName());
            lAwrajaj.setText(studata.getLName());
            lBkj.setText(studata.getBdate());
            lAbalj.setText(studata.getWoreda());
            lAbal2j.setText(studata.getCity());
            lTequamj.setText(studata.getKebele());
            lStayj.setText(studata.getGField());
            lUniHsibketj.setText(studata.getHolly());

        }
    }

    private void displayLiveAddress(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getLiveAddress(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            lHsibketjtl.setText(studata.getFName());
            lDebirjtl.setText(studata.getMName());
            lAwrajajtl.setText(studata.getLName());
            lBkjtl.setText(studata.getBdate());
            lAbaljtl.setText(studata.getWoreda());
            lAbal2jtl.setText(studata.getCity());
            lTequamjtl.setText(studata.getKebele());
            lStayjtl.setText(studata.getGField());

        }
    }

    private void displayCurrentService(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getCurrentService(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            lHsibketjtlc.setText(studata.getFName());
            lDebirjtlc.setText(studata.getMName());
            lAwrajajtlc.setText(studata.getLName());
            lBkjtlc.setText(studata.getBdate());
            lAbaljtlc.setText(studata.getWoreda());
            lAbal2jtlc.setText(studata.getCity());
            lTequamjtlc.setText(studata.getKebele());

        }
    }

    private void displayKiribTeteri(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getKiribTeter(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            lHsibketjt.setText(studata.getFName() + " " + studata.getMName() + " " + studata.getLName());
            lDebirjt.setText(studata.getMName());
            lAwrajajt.setText(studata.getLName());
            lBkjt.setText(studata.getBdate());
            lAbaljt.setText(studata.getWoreda());
            lAbal2jt.setText(studata.getCity());
            lTequamjt.setText(studata.getKebele());
            lStayjt.setText(studata.getGField());
            lUniHsibketjt.setText(studata.getHolly());

        }
    }

    private void display(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getStatusByStuName(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);
            tIDNO.setText(studata.getFName());
            tFn.setText(studata.getMName());
            tFa.setText(studata.getLName());
            tGn.setText(studata.getBdate());

            lFullName.setText(studata.getMName() + " " + studata.getLName() + " " + studata.getBdate());
            lBirthTime.setText(studata.getWoreda());
            //tBdate.setText(studata.getWoreda());
            ketw.setText(studata.getCity());
            ket.setText(studata.getKebele());
            ketk.setText(studata.getGField());

        }
    }

    private void display1(ActionEvent evt) {
        DatabaseClass.openConnection();

        results = stuQueries.getStatusByStuName1(tIdSearch.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;

            studata = results.get(currentEntryIndex);

            lKiristinaName.setText(studata.getHolly());
            lKirstina.setText(studata.getBK());
            lKihinetName.setText(studata.getKN());
            lKihinet.setText(studata.getKY());

        }
    }

    private void updateN(ActionEvent evt) {
        int res = stuQueries.updateN(tFn.getText(), tFa.getText(), tGn.getText(), tBdate.getText(), tWer.getText(), tCity.getText(), tKeb.getText(), tIdSearch.getText());
        int res1 = stuQueries.updateK(tKir.getText(), tKbk.getText(), tKih.getText(), tKibk.getText(), tIdSearch.getText());

        if (res == 1 && res1 == 1) {
            JOptionPane.showMessageDialog(null, "yes,Data is Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
    }

    private void updateUS(ActionEvent evt) {
        int res = stuQueries.updateUS(t5.getText(), t6.getText(), t7.getText(), t8.getText(), t9.getText(), t10.getText(), t11.getText(), t12.getText(), tIdSearch.getText());
        int res1 = stuQueries.updateUK(t1.getText(), t2.getText(), t3.getText(), t4.getText(), tIdSearch.getText());

        if (res == 1 && res1 == 1) {
            JOptionPane.showMessageDialog(null, "yes,Data is Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
    }

    private void updateUJ(ActionEvent evt) {
        int res = stuQueries.updateUJ(ta.getText(), tb.getText(), tc.getText(), td.getText(), te.getText(), tf.getText(), tg.getText(), th.getText(), ti.getText(), tIdSearch.getText());

        if (res == 1) {
            JOptionPane.showMessageDialog(null, "yes,Data is Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
    }

    private void updateYear(ActionEvent evt) {
        int res = stuQueries.updateYear(cServiceYtr1.getValue().toString(), cServiceYtr.getValue().toString());

        if (res == 1) {
            JOptionPane.showMessageDialog(null, "yes,Year is Updated");
        } else {
            JOptionPane.showMessageDialog(null, "yes,Year is Updated");
        }
    }

    private void updateLAC(ActionEvent evt) {
        int res = stuQueries.updateUL(t20.getText(), t21.getText(), t31.getText(), t41.getText(), t51.getText(), t61.getText(), t71.getText(), t81.getText(), tIdSearch.getText());
        int res1 = stuQueries.updateUC(t91.getText(), t101.getText(), t111.getText(), t121.getText(), t131.getText(), t141.getText(), t151.getText(), tIdSearch.getText());
        if (res == 1 && res1 == 1) {
            JOptionPane.showMessageDialog(null, "yes,Data is Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
    }

    private void updateUKI(ActionEvent evt) {
        int res = stuQueries.updateUKI(t201.getText(), t211.getText(), t311.getText(), t411.getText(), t511.getText(), t611.getText(), t711.getText(), t811.getText(), t911.getText(), tIdSearch.getText());

        if (res == 1) {
            JOptionPane.showMessageDialog(null, "yes,Data is Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
    }

    private void displayPhoto() {
        try {
            int phoId = Integer.parseInt(tIdSearch.getText());
            String query = "SELECT * FROM Pic1 WHERE መለያቁጥር = '" + phoId + "'";

            ResultSet rset = DatabaseClass.selectTable(query);

            int c = 0;
            while (rset.next()) {
                c++;
                imgData = null;

                try {
                    img = rset.getBlob("ፎቶግራፍ");
                    imgData = img.getBytes(1, (int) img.length());
                } catch (Exception w) {
                }

                if (imgData != null) {
                    ByteArrayInputStream in = new ByteArrayInputStream(imgData);

                    Image image = new Image(in);
                    iView.setImage(image);

                }
            }

        } catch (Exception e) {
        }
    }

}
