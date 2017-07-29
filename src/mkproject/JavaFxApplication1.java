/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.sun.rowset.internal.Row;
//import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.h2.jdbcx.JdbcConnectionPool;
import javafx.scene.control.DatePicker;

/**
 *
 * @author swe
 */
public class JavaFxApplication1 extends Application {

    Connection con;
    PreparedStatement pst;
    JdbcConnectionPool cp;
    ResultSet rs;
    File file;
    DatePicker date;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        try {

        } catch (Exception l) {
        }

        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent eve) {
                FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

                fileChooser.getExtensionFilters().addAll(extFilterJPG);

                file = fileChooser.showOpenDialog(null);
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

                    String query = "INSERT INTO NameBirthB(መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,የትውልድጊዜ,ወረዳ,ከተማ,ቀበሌ)VALUES(?,?,?,?,?,?,?,?)";
                    pst = con.prepareStatement(query);
                    FileInputStream fileIn = new FileInputStream(file);
                    XSSFWorkbook wb = new XSSFWorkbook(fileIn);
                    XSSFSheet sheet = wb.getSheetAt(0);
                    Row row;
                    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                        row = sheet.getRow(i);
                        try {
                            pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                            pst.setString(2, row.getCell(1).getStringCellValue());
                            pst.setString(3, row.getCell(2).getStringCellValue());
                            pst.setString(4, row.getCell(3).getStringCellValue());
                            pst.setString(5, row.getCell(4).getStringCellValue());
                            pst.setString(6, row.getCell(5).getStringCellValue());
                            pst.setString(7, row.getCell(6).getStringCellValue());
                            pst.setInt(8, (int) row.getCell(7).getNumericCellValue());
                            pst.execute();

                        } catch (SQLException ex) {
                            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        );
        Button butExport = new Button("Export");
        butExport.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

                fileChooser.getExtensionFilters().addAll(extFilterJPG);

                file = fileChooser.showSaveDialog(null);
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
                    String query = "SELECT * FROM NameBirthB";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    XSSFWorkbook wb = new XSSFWorkbook();

                    XSSFSheet sheet = wb.createSheet();
                    XSSFRow header = sheet.createRow(0);
                    header.createCell(0).setCellValue("መለያ ቁጥር");
                    header.createCell(1).setCellValue("የመጀመሪያስም");
                    header.createCell(2).setCellValue("የአባትስም");
                    header.createCell(3).setCellValue("የአያትስም");
                    header.createCell(4).setCellValue("የትውልድጊዜ");
                    header.createCell(5).setCellValue("ወረዳ");
                    header.createCell(6).setCellValue("ከተማ");
                    header.createCell(7).setCellValue("ቀበሌ");
                    int index = 1;
                    while (rs.next()) {
                        XSSFRow row = sheet.createRow(index);
                        row.createCell(0).setCellValue(rs.getString("መለያቁጥር"));
                        row.createCell(1).setCellValue(rs.getString("የመጀመሪያስም"));
                        row.createCell(2).setCellValue(rs.getString("የአባትስም"));
                        row.createCell(3).setCellValue(rs.getString("የአያትስም"));
                        row.createCell(4).setCellValue(rs.getString("የትውልድጊዜ"));
                        row.createCell(5).setCellValue(rs.getString("ወረዳ"));
                        row.createCell(6).setCellValue(rs.getString("ከተማ"));
                        row.createCell(7).setCellValue(rs.getString("ቀበሌ"));
                        index++;

                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    wb.write(fos);

                    fos.close();
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        TextField txt = new TextField();
        txt.setPrefWidth(100);
        Label labl = new Label();
        labl.setPrefWidth(100);
        txt.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ey) {
                if (!"0123456789".contains(ey.getCharacter())) {
                    ey.consume();
                    txt.setStyle("-fx-border-color:red");
                    labl.setText("Wrong Input");

                } else {
                    txt.setStyle("-fx-border-color:black");
                    labl.setText("");
                }
            }
        });
        date = new DatePicker();
        date.setPromptText("BirthDate");
        date.setPrefWidth(300);
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(txt, labl);
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.add(btn, 2, 2);
        root.setPadding(new Insets(5, 5, 5, 5));
        root.add(hbox, 1, 1);
        root.add(butExport, 2, 4);
        root.add(date, 2, 3);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    public void exportData()
    {
        FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

                fileChooser.getExtensionFilters().addAll(extFilterJPG);

                file = fileChooser.showSaveDialog(null);
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
                    String query = "SELECT NameBirthB.መለያቁጥር,NameBirthB.የመጀመሪያስም,NameBirthB.የአባትስም,NameBirthB.የትውልድጊዜ,CurrentServiceTable.HollyFather,CurrentServiceTable.Ageligilot,LiveAddressTable.LiveMobile"
                            + " FROM NameBirthB INNER JOIN CurrentServiceTable ON NameBirthB.መለያቁጥር=CurrentServiceTable.IDNO INNER JOIN LiveAddressTable"
                            + " ON NameBirthB.መለያቁጥር=LiveAddressTable.IDNO";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    XSSFWorkbook wb = new XSSFWorkbook();

                    XSSFSheet sheet = wb.createSheet();
                    XSSFRow header = sheet.createRow(0);
                    header.createCell(0).setCellValue("መለያ ቁጥር");
                    header.createCell(1).setCellValue("የመጀመሪያ ስም");
                    header.createCell(2).setCellValue("የአባት ስም");
                    header.createCell(3).setCellValue("የትውልድ ጊዜ");
                    header.createCell(4).setCellValue("የንስሃ አባት ስም");
                    header.createCell(5).setCellValue("ፎርም የሞሉበት ጊዜ");
                    header.createCell(6).setCellValue("ስልክ ቁጥር");
                   
                    int index = 1;
                    while (rs.next()) {
                        XSSFRow row = sheet.createRow(index);
                        row.createCell(0).setCellValue(rs.getString("መለያቁጥር"));
                        row.createCell(1).setCellValue(rs.getString("የመጀመሪያስም"));
                        row.createCell(2).setCellValue(rs.getString("የአባትስም"));
                        row.createCell(3).setCellValue(rs.getString("የትውልድጊዜ"));
                        row.createCell(4).setCellValue(rs.getString("HollyFather"));
                        row.createCell(5).setCellValue(rs.getString("Ageligilot"));
                        row.createCell(6).setCellValue(rs.getString("LiveMobile"));
                      
                        index++;

                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    wb.write(fos);

                    fos.close();
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void exportDataService(String str,String str2, String str3)
    {
        FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

                fileChooser.getExtensionFilters().addAll(extFilterJPG);

                file = fileChooser.showSaveDialog(null);
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
                    String query = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + str + " WHERE ፆታ='" + str2 + "' AND አገልግሎትክፍል ='" + str3 + "'";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    XSSFWorkbook wb = new XSSFWorkbook();

                    XSSFSheet sheet = wb.createSheet();
                    XSSFRow header = sheet.createRow(0);
                    header.createCell(0).setCellValue("መለያ ቁጥር");
                    header.createCell(1).setCellValue("የመጀመሪያ ስም");
                    header.createCell(2).setCellValue("የአባት ስም");
                    header.createCell(3).setCellValue("የአያት ስም");
                    header.createCell(4).setCellValue("ኃላፊነት");
                    header.createCell(5).setCellValue("የገቡበትዓ መት");
                    header.createCell(6).setCellValue("ስልክ ቁጥር");
                   
                    int index = 1;
                    while (rs.next()) {
                        XSSFRow row = sheet.createRow(index);
                        row.createCell(0).setCellValue(rs.getString("መለያቁጥር"));
                        row.createCell(1).setCellValue(rs.getString("የመጀመሪያስም"));
                        row.createCell(2).setCellValue(rs.getString("የአባትስም"));
                        row.createCell(3).setCellValue(rs.getString("የአያትስም"));
                        row.createCell(4).setCellValue(rs.getString("ኃላፊነት"));
                        row.createCell(5).setCellValue(rs.getString("የገቡበትዓመት"));
                        row.createCell(6).setCellValue(rs.getString("ስልክቁጥር"));
                      
                        index++;

                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    wb.write(fos);

                    fos.close();
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void exportDataBatchFull(String str)
    {
        FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

                fileChooser.getExtensionFilters().addAll(extFilterJPG);

                file = fileChooser.showSaveDialog(null);
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
                   String query = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + str + " ";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    XSSFWorkbook wb = new XSSFWorkbook();

                    XSSFSheet sheet = wb.createSheet();
                    XSSFRow header = sheet.createRow(0);
                    header.createCell(0).setCellValue("መለያ ቁጥር");
                    header.createCell(1).setCellValue("የመጀመሪያ ስም");
                    header.createCell(2).setCellValue("የአባት ስም");
                    header.createCell(3).setCellValue("የአያት ስም");
                    header.createCell(4).setCellValue("ፆታ");
                    header.createCell(5).setCellValue("አገልግሎት ክፍል");
                    header.createCell(6).setCellValue("ኃላፊነት");
                    header.createCell(7).setCellValue("የገቡበትዓ መት");
                    header.createCell(8).setCellValue("ስልክ ቁጥር");
                   
                    int index = 1;
                    while (rs.next()) {
                        XSSFRow row = sheet.createRow(index);
                        row.createCell(0).setCellValue(rs.getString("መለያቁጥር"));
                        row.createCell(1).setCellValue(rs.getString("የመጀመሪያስም"));
                        row.createCell(2).setCellValue(rs.getString("የአባትስም"));
                        row.createCell(3).setCellValue(rs.getString("የአያትስም"));
                        row.createCell(4).setCellValue(rs.getString("ፆታ"));
                        row.createCell(5).setCellValue(rs.getString("አገልግሎትክፍል"));
                        row.createCell(6).setCellValue(rs.getString("ኃላፊነት"));
                        row.createCell(7).setCellValue(rs.getString("የገቡበትዓመት"));
                        row.createCell(8).setCellValue(rs.getString("ስልክቁጥር"));
                      
                        index++;

                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    wb.write(fos);

                    fos.close();
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void exportDataBatch(String str,String str2)
    {
        FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

                fileChooser.getExtensionFilters().addAll(extFilterJPG);

                file = fileChooser.showSaveDialog(null);
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
                   String query = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,አገልግሎትክፍል,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + str + " WHERE ፆታ = '"+str2+"' ";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    XSSFWorkbook wb = new XSSFWorkbook();

                    XSSFSheet sheet = wb.createSheet();
                    XSSFRow header = sheet.createRow(0);
                    header.createCell(0).setCellValue("መለያ ቁጥር");
                    header.createCell(1).setCellValue("የመጀመሪያ ስም");
                    header.createCell(2).setCellValue("የአባት ስም");
                    header.createCell(3).setCellValue("የአያት ስም");
                    
                    header.createCell(4).setCellValue("አገልግሎት ክፍል");
                    header.createCell(5).setCellValue("ኃላፊነት");
                    header.createCell(6).setCellValue("የገቡበትዓ መት");
                    header.createCell(7).setCellValue("ስልክ ቁጥር");
                   
                    int index = 1;
                    while (rs.next()) {
                        XSSFRow row = sheet.createRow(index);
                        row.createCell(0).setCellValue(rs.getString("መለያቁጥር"));
                        row.createCell(1).setCellValue(rs.getString("የመጀመሪያስም"));
                        row.createCell(2).setCellValue(rs.getString("የአባትስም"));
                        row.createCell(3).setCellValue(rs.getString("የአያትስም"));
                        row.createCell(4).setCellValue(rs.getString("አገልግሎትክፍል"));
                        row.createCell(5).setCellValue(rs.getString("ኃላፊነት"));
                        row.createCell(6).setCellValue(rs.getString("የገቡበትዓመት"));
                        row.createCell(7).setCellValue(rs.getString("ስልክቁጥር"));
                      
                        index++;

                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    wb.write(fos);

                    fos.close();
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void exportDataServiceFull(String str,String str2)
    {
        FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

                fileChooser.getExtensionFilters().addAll(extFilterJPG);

                file = fileChooser.showSaveDialog(null);
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
                    String query = "SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,ኃላፊነት,የገቡበትዓመት,ስልክቁጥር from ATablee" + str + " WHERE አገልግሎትክፍል ='" + str2 + "'";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    XSSFWorkbook wb = new XSSFWorkbook();

                    XSSFSheet sheet = wb.createSheet();
                    XSSFRow header = sheet.createRow(0);
                    header.createCell(0).setCellValue("መለያ ቁጥር");
                    header.createCell(1).setCellValue("የመጀመሪያ ስም");
                    header.createCell(2).setCellValue("የአባት ስም");
                    header.createCell(3).setCellValue("የአያት ስም");
                    header.createCell(4).setCellValue("ፆታ");
                    header.createCell(5).setCellValue("ኃላፊነት");
                    header.createCell(6).setCellValue("የገቡበትዓ መት");
                    header.createCell(7).setCellValue("ስልክ ቁጥር");
                   
                    int index = 1;
                    while (rs.next()) {
                        XSSFRow row = sheet.createRow(index);
                        row.createCell(0).setCellValue(rs.getString("መለያቁጥር"));
                        row.createCell(1).setCellValue(rs.getString("የመጀመሪያስም"));
                        row.createCell(2).setCellValue(rs.getString("የአባትስም"));
                        row.createCell(3).setCellValue(rs.getString("የአያትስም"));
                        row.createCell(4).setCellValue(rs.getString("ፆታ"));
                        row.createCell(5).setCellValue(rs.getString("ኃላፊነት"));
                        row.createCell(6).setCellValue(rs.getString("የገቡበትዓመት"));
                        row.createCell(7).setCellValue(rs.getString("ስልክቁጥር"));
                      
                        index++;

                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    wb.write(fos);

                    fos.close();
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void importData() {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO NameBirthB(መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,የትውልድጊዜ,ወረዳ,ከተማ,ቀበሌ)VALUES(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setString(4, row.getCell(3).getStringCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                    pst.setString(6, row.getCell(5).getStringCellValue());
                    pst.setString(7, row.getCell(6).getStringCellValue());
                    pst.setInt(8, (int) row.getCell(7).getNumericCellValue());
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                   // Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 public void importData1() {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO KirstinaTable(IDNO,KirstinaName,KirstinaBK,KihinetName,KihinetZemen,KihinetHager,KihinetKebele,KihinetAwraja,KihinetBK)VALUES(?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setString(4, row.getCell(3).getStringCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                    pst.setString(6, row.getCell(5).getStringCellValue());
                    
                    pst.setInt(7, (int) row.getCell(6).getNumericCellValue());
                    pst.setString(8, row.getCell(7).getStringCellValue());
                    pst.setString(9, row.getCell(8).getStringCellValue());
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                   // Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  public void importData2() {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO SenbetBKTable(IDNO,FirstStay,SecondStay,CollegeName,StayTime,StayHSibket,StayBK,StaySundayName,GraduatedField)VALUES(?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setString(4, row.getCell(3).getStringCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                    pst.setString(6, row.getCell(5).getStringCellValue());
                    pst.setString(7, row.getCell(6).getStringCellValue());
                    pst.setString(8, row.getCell(7).getStringCellValue());
                    pst.setString(9, row.getCell(8).getStringCellValue());
                    
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                    Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   public void importData3() {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO CurrentJobTable(IDNO,JobHS,JobZone,JobWereda,JobKetema,JobKebele,JobGebere,JobType,JobHouse,JobPhone)VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setString(4, row.getCell(3).getStringCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                    pst.setString(6, row.getCell(5).getStringCellValue());
                    pst.setString(7, row.getCell(6).getStringCellValue());
                     pst.setString(8, row.getCell(7).getStringCellValue());
                    pst.setString(9, row.getCell(8).getStringCellValue());
                    pst.setString(10, row.getCell(9).getStringCellValue());
                    
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                   // Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void importData4() {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO LiveAddressTable(IDNO,LiveKetema,LiveKefitegna,LiveKebele,LiveHNo,LivePhone,LiveMobile,LiveAdmin,LiveEduStatus)VALUES(?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setInt(3, (int) row.getCell(2).getNumericCellValue());
                    pst.setInt(4, (int) row.getCell(3).getNumericCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                    pst.setString(6, row.getCell(5).getStringCellValue());
                    pst.setString(7, row.getCell(6).getStringCellValue());
                    pst.setString(8, row.getCell(7).getStringCellValue());
                    pst.setString(9, row.getCell(8).getStringCellValue());
                   
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                   // Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void importData5() {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO CurrentServiceTable(IDNO,BkName,KihinetMahireg,SundaySchool,SebekaGubae,IdDSebeka,HollyFather,LangSkill1,LangSkill2,LangSkill3,Ageligilot)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setString(4, row.getCell(3).getStringCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                    pst.setString(6, row.getCell(5).getStringCellValue());
                    pst.setString(7, row.getCell(6).getStringCellValue());
                     pst.setString(8, row.getCell(7).getStringCellValue());
                    pst.setString(9, row.getCell(8).getStringCellValue());
                    pst.setString(10, row.getCell(9).getStringCellValue());
                     pst.setString(11, row.getCell(10).getStringCellValue());
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                   // Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      public void importData6() {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO KiribTeteriTable(IDNO,FirstName,MiddleName,LastName,Ketema,Kefitegna,Kebele,HouNo,HouPhone,MobileNum)VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setString(4, row.getCell(3).getStringCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                   pst.setInt(6, (int) row.getCell(5).getNumericCellValue());
                   pst.setInt(7, (int) row.getCell(6).getNumericCellValue());
                   pst.setString(8, row.getCell(7).getStringCellValue());
                    pst.setString(9, row.getCell(8).getStringCellValue());
                    pst.setString(10, row.getCell(9).getStringCellValue());
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                   // Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      public void importDataA(String yearTable) {
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.XLSX");

        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        file = fileChooser.showOpenDialog(null);
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

            String query = "INSERT INTO ATablee" + yearTable + "(መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትቀን,የገቡበትወር,የገቡበትዓመት,ስልክቁጥር)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            boolean bol=false;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                try {
                    pst.setInt(1, (int) row.getCell(0).getNumericCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setString(4, row.getCell(3).getStringCellValue());
                    pst.setString(5, row.getCell(4).getStringCellValue());
                    pst.setString(6, row.getCell(5).getStringCellValue());
                    pst.setString(7, row.getCell(6).getStringCellValue());
                   pst.setInt(8, (int) row.getCell(7).getNumericCellValue());
                    pst.setString(9, row.getCell(8).getStringCellValue());
                    pst.setInt(10, (int) row.getCell(9).getNumericCellValue());
                    pst.setString(11, row.getCell(10).getStringCellValue());
              
                   pst.execute();
                   
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" succssfully saved");
                        alert.setHeaderText(null);
                        alert.showAndWait();  
                    

                } catch (SQLException ex) {
                   // Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
                     Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("መረጃ መንገድ");
                        alert.setContentText("Line "+i+" not saved, Please check it again");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }
                  

            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);

        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(JavaFxApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
