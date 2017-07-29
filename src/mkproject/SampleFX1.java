package mkproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 *
 * @author Graham Smith
 */
public class SampleFX1 extends Application {

    // private TableView table = new TableView();
    private final ObservableList<Person> data = FXCollections.observableArrayList();
    TableView<Person> table = new TableView<>();
    Connection con;
    PreparedStatement pst;
    JdbcConnectionPool cp;
    ResultSet rs;
    String newValue, newValue1, newValue2, colName;
    CellEditEvent<Person, String> t;

    Stage actionStage = new Stage();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(1300);
        stage.setHeight(800);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
        //Create a customer cell factory so that cells can support editing.
        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        //Set up the columns
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(cellFactory);
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(cellFactory);
        //lastNameCol.setEditable( false );

        TableColumn primaryEmailColG = new TableColumn("Grand Name");
        primaryEmailColG.setMinWidth(200);
        primaryEmailColG.setCellValueFactory(new PropertyValueFactory<Person, String>("grandName"));
        primaryEmailColG.setCellFactory(cellFactory);
        //Make this column un-editable        

        TableColumn secondaryEmailColB = new TableColumn("BirthDate");
        secondaryEmailColB.setMinWidth(200);
        secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
        secondaryEmailColB.setCellFactory(cellFactory);

        TableColumn firstNameColW = new TableColumn("Wereda");
        firstNameColW.setMinWidth(100);
        firstNameColW.setCellValueFactory(new PropertyValueFactory<Person, String>("wereda"));
        firstNameColW.setCellFactory(cellFactory);
        TableColumn lastNameColKt = new TableColumn("Ketema");
        lastNameColKt.setMinWidth(100);
        lastNameColKt.setCellValueFactory(new PropertyValueFactory<Person, String>("ketema"));
        lastNameColKt.setCellFactory(cellFactory);
//        lastNameCol.setEditable( false );

        TableColumn primaryEmailColKb = new TableColumn("Kebele");
        primaryEmailColKb.setMinWidth(200);
        primaryEmailColKb.setCellValueFactory(new PropertyValueFactory<Person, String>("kebele"));
        primaryEmailColKb.setCellFactory(cellFactory);
        TableRow row = new TableRow();
        TableCell cell = new TableCell();

        //Make this column un-editable        
        TableColumn secondaryEmailColId = new TableColumn("መለያ ቁጥር");
        secondaryEmailColId.setId("table");
        secondaryEmailColId.setMinWidth(200);
        secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<Person, String>("idNumber"));
        secondaryEmailColId.setCellFactory(cellFactory);
//        secondaryEmailCol.setEditable( false );

        //Add the columns and data to the table.
        // table.setItems(data);
        table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, secondaryEmailColB, firstNameColW, lastNameColKt, primaryEmailColKb);
        //Make the table editable
        table.setEditable(true);
        table.setId("table");

        //Modifying the firstName property
        secondaryEmailColId.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdNumber(t.getNewValue());
            }
        });
        firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                newValue = t.getNewValue();
                colName = "የመጀመሪያስም";

            }
        });
        //Modifying the lastName property
        lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());
                newValue = t.getNewValue();
                colName = "የአባትስም";
                // textInput(colName,newValue);

            }
        });
        //Modifying the primary email property
        primaryEmailColG.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrandName(t.getNewValue());

            }
        });
        //Modifying the secondary email property
        secondaryEmailColB.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBirthDate(t.getNewValue());

            }
        });
        firstNameColW.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWereda(t.getNewValue());

            }
        });
        lastNameColKt.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKetema(t.getNewValue());

            }
        });
        /* primaryEmailColKb.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKebele(t.getNewValue());

            }
        });*/
        Button browse = new Button("Retrieve");
        Button update = new Button("Update");
        final GridPane vbox = new GridPane();
        vbox.setVgap(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        vbox.add(label, 1, 0);
        table.setPrefSize(1000, 600);

        GridPane.setColumnSpan(table, 15);
        GridPane.setRowSpan(table, 20);
        vbox.add(browse, 0, 21);
        vbox.add(update, 0, 22);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        browse.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {

                data.clear();
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

                        data.add(new Person(
                                rs.getString("መለያቁጥር"),
                                rs.getString("የመጀመሪያስም"),
                                rs.getString("የአባትስም"),
                                rs.getString("የትውልድጊዜ"),
                                rs.getString("HollyFather"),
                                rs.getString("Ageligilot"),
                                rs.getString("LiveMobile")));
                        table.setItems(data);
                    }
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
                }
                vbox.add(table, 0, 1);
            }

        });
        update.setOnAction(e
                -> {

            //textInput(colName, newValue);
        });
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void textInput(String str1, String str2, String str3, String str4) {

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        TextInputDialog alert = new TextInputDialog("");
        alert.setTitle("ማረጋግጫ ሳጥን");
        alert.setHeaderText("መለያ ቁጥር ያስገቡ");
        DialogPane dialog = alert.getDialogPane();

        dialog.setStyle("-fx-background-color:greenyellow;");
        dialog.getStyleClass().remove("alert");
        GridPane gridS = (GridPane) dialog.lookup(".header-panel");
        gridS.setStyle("-fx-background-color: cadetblue;-fx-font-family:\"Nyala\";");
        //dialog.lookup(".label.content").setStyle("-fx-font-family:\"Nyala\";");
        int res1 = 0;
        Optional<String> res = alert.showAndWait();
        if (res.isPresent()) {
            System.out.println("Your ID Number is = " + res.get());
            try {
                Class.forName("org.h2.Driver");
                try {
                    try {
                        cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                    } catch (Exception y) {
                    }

                    con = cp.getConnection();
                    pst = con.prepareStatement(" UPDATE " + str1 + " SET " + str2 + "=? WHERE " + str4 + " =?");

                    pst.setString(1, str3);

                    pst.setString(2, res.get());

                    res1 = pst.executeUpdate();
                    if (res1 == 1) {
                        Alert alert1 = new Alert(AlertType.INFORMATION);
                        alert1.setHeaderText("ተስተካክሏል");

                        alert1.setTitle("ማረጋግጫ ሳጥን");
                        alert1.showAndWait();
                        DialogPane dialogP = alert1.getDialogPane();
                        dialogP.setId("myDialog");
                        dialogP.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
                        dialogP.getStyleClass().add("myDialog");

                    } else {
                        Alert alert2 = new Alert(AlertType.ERROR);
                        alert2.setHeaderText("Not Updated");

                        alert2.setTitle("ማረጋግጫ ሳጥን");

                        alert2.showAndWait();
                        dialog = alert2.getDialogPane();

                        dialog.setStyle("-fx-background-color:greenyellow;");
                        dialog.getStyleClass().remove("alert2");
                        GridPane gridS3 = (GridPane) dialog.lookup(".header-panel");
                        gridS3.setStyle("-fx-background-color: cadetblue;-fx-font-family:\"Nyala\";");
                        // dialog3.lookup(".label.content").setStyle("-fx-font-family:\"Nyala\";");

                    }

                } catch (Exception l) {
                }

                //   pst.close();
                //   rs.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void textInputBatch(String str1, String str2, String str3) {

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
 int res1 = 0;
            try {
                Class.forName("org.h2.Driver");
                try {
                    try {
                        cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                    } catch (Exception y) {
                    }

                    con = cp.getConnection();
                    pst = con.prepareStatement(" UPDATE ATablee" + str1 + " SET " + str2 + "=? WHERE መለያቁጥር =? ");

                    pst.setString(1, str3);

                  pst.setString(2, res.get());

                    res1 = pst.executeUpdate();
                    if (res1 == 1) {
                        Alert alert1 = new Alert(AlertType.INFORMATION);
                        alert1.setHeaderText("ተስተካክሏል");

                        alert1.setTitle("ማረጋግጫ ሳጥን");

                       // alert1.showAndWait();
                        DialogPane dialogA = alert1.getDialogPane();

                        dialogA.setStyle("-fx-background-color:greenyellow;");
                        dialogA.getStyleClass().remove("alert");
                        GridPane gridSA = (GridPane) dialogA.lookup(".header-panel");
                        gridSA.setStyle("-fx-background-color: cadetblue;-fx-font-family:\"Nyala\";");
                          Optional<ButtonType> res2 = alert1.showAndWait();
                    } else {
                        Alert alert2 = new Alert(AlertType.ERROR);
                        alert2.setHeaderText("Not Updated");

                        alert2.setTitle("ማረጋግጫ ሳጥን");

                        alert2.showAndWait();
                       DialogPane dialogB = alert2.getDialogPane();

                        dialogB.setStyle("-fx-background-color:greenyellow;");
                        dialogB.getStyleClass().remove("alert2");
                        GridPane gridS3 = (GridPane) dialogB.lookup(".header-panel");
                        gridS3.setStyle("-fx-background-color: cadetblue;-fx-font-family:\"Nyala\";");
                        Optional<ButtonType> res2 = alert2.showAndWait();
                        // dialog3.lookup(".label.content").setStyle("-fx-font-family:\"Nyala\";");

                    }

                } catch (Exception l) {
                }

                //   pst.close();
                //   rs.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SampleFX1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
