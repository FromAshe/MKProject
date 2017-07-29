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

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JOptionPane;
import org.h2.jdbcx.*;

/**
 *
 * @author ASTU
 */
public class DatabaseClass {

    private static JdbcConnectionPool cp = null;
    private static Connection con = null;
    private static Statement stmt = null;
    private static byte[] imgData = null;
    private static Blob img;
    //  private static int count;
    private static byte[] soundData = null;
    private static Blob sound;
    private static String wrd = null;
    private static PreparedStatement selectMember = null;
    private static PreparedStatement selectMember1 = null;
    private static PreparedStatement selectMember2 = null;
    private static PreparedStatement selectMember3 = null;
    private static PreparedStatement selectMember4 = null;
    private static PreparedStatement selectMember5 = null;
    private static PreparedStatement selectMember6 = null;
    private static PreparedStatement selectMember7 = null;
    private static PreparedStatement selectMember8 = null;
    private static PreparedStatement selectMember9 = null;
    private static PreparedStatement selectMemberN = null;
    private static PreparedStatement selectMemberU = null;
    private static PreparedStatement selectMemberUN = null;
    private static PreparedStatement selectMemberUK = null;
    private static PreparedStatement selectMemberUK1 = null;
    private static PreparedStatement selectMemberUKI = null;
    private static PreparedStatement selectMemberUS = null;
    private static PreparedStatement selectMemberA = null;
    private static PreparedStatement selectMemberD = null;
    private static PreparedStatement selectMemberUY = null;
    private static PreparedStatement selectMemberUJ = null;
    private static PreparedStatement selectMemberUL = null;
    private static PreparedStatement selectMemberUC = null;
    private static PreparedStatement selectMemberAC = null;
    private static PreparedStatement selectMemberUAC = null;
    private static PreparedStatement selectMemberIDNO = null;
    private static PreparedStatement updateAccount = null;
    private static PreparedStatement selectAccount = null;
    private static String yearTable = null;
    private static String yearTable1 = null;

    public static void openConnection(String str) {
        try {
            Class.forName("org.h2.Driver");
            try {
                try {
                    cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                } catch (Exception y) {
                }
                con = cp.getConnection();
                stmt = con.createStatement();
                yearTable1 = str;

                selectMemberA = con.prepareStatement("SELECT የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትቀን,የገቡበትወር,የገቡበትዓመት,ስልክቁጥር FROM ATablee" + yearTable1 + " WHERE መለያቁጥር = ?");

                selectMemberAC = con.prepareStatement("SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትቀን,የገቡበትወር,የገቡበትዓመት,ስልክቁጥር FROM ATablee" + yearTable1 + " WHERE መለያቁጥር = ?");
                selectMemberIDNO = con.prepareStatement("SELECT መለያቁጥር FROM ATablee" + yearTable1 + " WHERE መለያቁጥር = ?");
                selectMemberUAC = con.prepareStatement("UPDATE ATablee" + str + " SET መለያቁጥር=?,የመጀመሪያስም=?,የአባትስም=?,የአያትስም=?,ፆታ=?,አገልግሎትክፍል=?,ኃላፊነት=?,የገቡበትቀን=?,የገቡበትወር=?,የገቡበትዓመት=?,ስልክቁጥር=? WHERE መለያቁጥር = ?");

                selectMemberD = con.prepareStatement("DELETE FROM ATablee" + str + " WHERE መለያቁጥር=?");
                // photoTable();
                aTable3();

            } catch (Exception l) {
            }
        } catch (Exception l) {
        }
    }

    public static void openConnection() {
        try {
            Class.forName("org.h2.Driver");
            try {
                try {
                    cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
                } catch (Exception y) {
                }
                con = cp.getConnection();
                stmt = con.createStatement();

                updateAccount = con.prepareStatement("UPDATE AccountTablee SET FirstName=?,FatherName=?,UserName=?,UserCode=?,PassWord=? WHERE IDNO=?");

                selectMember = con.prepareStatement("SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,የትውልድጊዜ,ወረዳ,ከተማ,ቀበሌ FROM NameBirthB WHERE መለያቁጥር = ?");
                selectMember1 = con.prepareStatement("SELECT KirstinaName,KirstinaBK,KihinetName,KihinetZemen FROM KirstinaTable WHERE IDNO=?");
                selectMember2 = con.prepareStatement("SELECT LangSkill1,LangSkill2,LangSkill3 FROM CurrentServiceTablet WHERE IDNO=?");
                selectMember3 = con.prepareStatement("SELECT LiveMobile FROM LiveAddressTable WHERE IDNO = ?");

                selectMember4 = con.prepareStatement("SELECT KihinetHager,KihinetKebele,KihinetAwraja,KihinetBK From KirstinaTable WHERE IDNO=?");
                selectMember5 = con.prepareStatement("SELECT FirstStay,SecondStay,CollegeName,StayTime,StayHSibket,StayBK,StaySundayName,GraduatedField FROM SenbetBKTable WHERE IDNO=?");
                selectMember6 = con.prepareStatement("SELECT JobHS,JobZone,JobWereda,JobKetema,JobKebele,JobGebere,JobType,JobHouse,JobPhone FROM CurrentJobTable WHERE IDNO = ?");
                selectMember7 = con.prepareStatement("SELECT FirstName,MiddleName,LastName,Ketema,Kefitegna,Kebele,HouNo,HouPhone,MobileNum FROM KiribTeteriTable WHERE IDNO = ?");
                selectMember8 = con.prepareStatement("SELECT LiveKetema,LiveKefitegna,LiveKebele,LiveHNo,LivePhone,LiveMobile,LiveAdmin,LiveEduStatus FROM LiveAddressTable WHERE IDNO = ?");

                selectMember9 = con.prepareStatement("SELECT BkName,KihinetMahireg,SundaySchool,SebekaGubae,IdDSebeka,HollyFather,Ageligilot FROM CurrentServiceTable WHERE IDNO = ?");
                selectMemberN = con.prepareStatement("SELECT Title,Contents FROM Note1 WHERE Day = ?");
                selectAccount = con.prepareStatement("SELECT UserName,PassWord FROM AccountTablee WHERE IDNO = 1");
                selectMemberU = con.prepareStatement("UPDATE Note1 SET Title=?, Contents=? WHERE Day=?");
                selectMemberUN = con.prepareStatement("UPDATE NameBirthB SET የመጀመሪያስም=?,የአባትስም=?,የአያትስም=?,የትውልድጊዜ=?,ወረዳ=?,ከተማ=?,ቀበሌ=? WHERE መለያቁጥር=?");
                selectMemberUK = con.prepareStatement("UPDATE KirstinaTable SET KirstinaName=?,KirstinaBK=?,KihinetName=?,KihinetZemen=? WHERE IDNO=?");
                // selectMemberA = con.prepareStatement("SELECT የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትቀን,የገቡበትወር,የገቡበትዓመት,ስልክቁጥር FROM ATablee"+str+" WHERE መለያቁጥር = ?");

                // selectMemberAC = con.prepareStatement("SELECT FirstName,FatherName,GFatherName,Sex,AgeligilotKifil,Halafinet,Day,Month,Year,PhoneNumber FROM ATable4 WHERE IDNO = ?");
                selectMemberUK1 = con.prepareStatement("UPDATE KirstinaTable SET KihinetHager=?,KihinetKebele=?,KihinetAwraja=?,KihinetBK=? WHERE IDNO=?");
                selectMemberUS = con.prepareStatement("UPDATE SenbetBKTable SET FirstStay=?,SecondStay=?,CollegeName=?,StayTime=?,StayHSibket=?,StayBK=?,StaySundayName=?,GraduatedField=? WHERE IDNO=?");
                selectMemberUJ = con.prepareStatement("UPDATE  CurrentJobTable SET JobHS=?,JobZone=?,JobWereda=?,JobKetema=?,JobKebele=?,JobGebere=?,JobType=?,JobHouse=?,JobPhone=? WHERE IDNO=?");
                selectMemberUL = con.prepareStatement("UPDATE LiveAddressTable SET LiveKetema=?,LiveKefitegna=?,LiveKebele=?,LiveHNo=?,LivePhone=?,LiveMobile=?,LiveAdmin=?,LiveEduStatus=? WHERE IDNO=?");
                selectMemberUC = con.prepareStatement("UPDATE CurrentServiceTable SET BkName=?,KihinetMahireg=?,SundaySchool=?,SebekaGubae=?,IdDSebeka=?,HollyFather=?,Ageligilot=? WHERE IDNO=?");
                selectMemberUKI = con.prepareStatement("UPDATE KiribTeteriTable SET FirstName=?,MiddleName=?,LastName=?,Ketema=?,Kefitegna=?,Kebele=?,HouNo=?,HouPhone=?,MobileNum=? WHERE IDNO=?");
                //  selectMemberUAC = con.prepareStatement("UPDATE ATablee"+str+" SET የመጀመሪያስም=?,የአባትስም=?,የአያትስም=?,ፆታ=?,አገልግሎትክፍል=?,ኃላፊነት=?,የገቡበትቀን=?,የገቡበትወር=?,የገቡበትዓመት=?,ስልክቁጥር=? WHERE መለያቁጥር = ?");
////

                accountTable();
                photoTable();
                //  aTable3();
                leaveTable1();
                reportNote();

                nameBirth();
                kirstinaTable();
                senbetBKTable();
                currentJobTable();
                liveAddressTable();
                currentServiceTablet();
                kiribTeteriTable();

            } catch (Exception l) {
            }
        } catch (Exception l) {
        }
    }

    public static void leaveTable1() {
        try {
            String stid = "መለያቁጥር";
            String str = "የመጀመሪያስም";
            String str1 = "የአባትስም";
            String str2 = "የአያትስም";
            String str4 = "አገልግሎትክፍል";
            String str3 = "ፆታ";
            String str5 = "ኃላፊነት";
            String str6 = "የገቡበትጊዜ";
            String str7 = "ስልክቁጥር";
            String str9 = "የለቀቁበትጊዜ";
            String str8 = "የለቀቁበትምክንያት";

            stmt.execute("CREATE TABLE LeaveTableA(" + stid + " varchar(10) primary key," + str + " varchar(1500), " + str1 + " varchar(1500)," + str2 + " varchar(100)," + str3 + " varchar(10)," + str4 + " varchar(100)," + str5 + " varchar(100)," + str6 + " varchar(100)," + str7 + " varchar(13)," + str8 + " varchar(1000)," + str9 + " varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void example(String str) {
        try {
            String str2 = "የመጀመሪያስም";
            String str3, str4, str5;
            str3 = "መለያቁጥር";
            str4 = "የአባትስም";
            str5 = "የአያትስም";
            stmt.execute("CREATE TABLE " + str + "(" + str3 + " varchar(10) primary key," + str2 + " varchar(1500), " + str4 + " varchar(1500)," + str5 + "varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void photoTable() {
        try {

            String str3 = "መለያቁጥር";
            String str4 = "ፎቶግራፍ";
            stmt.execute("CREATE TABLE Pic1(" + str3 + " varchar(1000) primary key," + str4 + " BLOB)");

        } catch (Exception l) {
        }
    }

    public static void reportNote() {
        try {
            stmt.execute("CREATE TABLE Note1(IDNO primary key,Title varchar(1500), Contents varchar(1500))");

        } catch (Exception l) {
        }
    }

    public static void aTable3() {
        try {
            //String st=" ";
            String stid = "መለያቁጥር";
            String str = "የመጀመሪያስም";
            String str1 = "የአባትስም";
            String str2 = "የአያትስም";
            String str4 = "አገልግሎትክፍል";
            String str3 = "ፆታ";
            String str5 = "ኃላፊነት";
            String str6 = "የገቡበትቀን";
            String str7 = "የገቡበትወር";
            String str8 = "የገቡበትዓመት";
            String str9 = "ስልክቁጥር";

            stmt.execute("CREATE TABLE ATablee2007(" + stid + " int IDENTITY(1,1) primary key," + str + " varchar(1500), " + str1 + " varchar(1500)," + str2 + " varchar(100)," + str3 + " varchar(10)," + str4 + " varchar(100)," + str5 + " varchar(100)," + str6 + " varchar(100)," + str7 + " varchar(13)," + str8 + " varchar(13)," + str9 + " varchar(13))");

        } catch (Exception l) {
        }
    }

    public static void notee() {
        try {
            stmt.execute("CREATE TABLE RegisterNote(Day varchar(13) primary key,Title varchar(1000),Content varchar(2000))");

        } catch (Exception l) {
        }
    }

    public static void nameBirth() {
        try {
            String stid = "መለያቁጥር";
            String str = "የመጀመሪያስም";
            String str1 = "የአባትስም";
            String str2 = "የአያትስም";
            String str3 = "የትውልድጊዜ";
            String str4 = "ወረዳ";
            String str5 = "ከተማ";
            String str6 = "ቀበሌ";
            stmt.execute("CREATE TABLE NameBirthB(" + stid + " int primary key," + str + " varchar(1500), " + str1 + " varchar(1500)," + str2 + " varchar(1500)," + str3 + " varchar(100)," + str4 + " varchar(100)," + str5 + " varchar(100)," + str6 + " varchar (100))");

        } catch (Exception l) {
        }
    }

    public static void kirstinaTable() {
        try {
            stmt.execute("CREATE TABLE KirstinaTable(IDNO int primary key,KirstinaName varchar(1500), KirstinaBK varchar(1500),KihinetName varchar(1500),KihinetZemen varchar(100),KihinetHager varchar(100),KihinetKebele varchar(100),KihinetAwraja varchar (100),KihinetBK varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void accountTable() {
        try {
            stmt.execute("CREATE TABLE AccountTablee(IDNO int primary key,FirstName varchar(1500),FatherName varchar(1500),UserName varchar(100),UserCode varchar(100),PassWord varchar(100))");
            //stmt.executeUpdate("INSERT INTO AccountTablee(IDNO,FirstName,FatherName,UserName,UserCode,PassWord)VALUES( 1,'Yoni','Mog','gibi','yohy','2006')");
        } catch (Exception l) {
        }
    }

    public static void senbetBKTable() {
        try {
            stmt.execute("CREATE TABLE SenbetBKTable(IDNO int primary key,FirstStay varchar(1500), SecondStay varchar(1500),CollegeName varchar(1500),StayTime varchar(100),StayHSibket varchar(100),StayBK varchar(100),StaySundayName varchar (100),GraduatedField varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void currentJobTable() {
        try {
            stmt.execute("CREATE TABLE CurrentJobTable(IDNO int primary key,JobHS varchar(1500), JobZone varchar(1500),JobWereda varchar(1500),JobKetema varchar(100),JobKebele varchar(100),JobGebere varchar(100),JobType varchar (100),JobHouse varchar(100),JobPhone varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void liveAddressTable() {
        try {
            stmt.execute("CREATE TABLE LiveAddressTable(IDNO int primary key,LiveKetema varchar(1500), LiveKefitegna varchar(1500),LiveKebele varchar(1500),LiveHNo varchar(100),LivePhone varchar(100),LiveMobile varchar(100),LiveAdmin varchar (100),LiveEduStatus varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void currentServiceTablet() {
        try {
            stmt.execute("CREATE TABLE CurrentServiceTable(IDNO int primary key,BkName varchar(1500),KihinetMahireg varchar(1500), SundaySchool varchar(1500),SebekaGubae varchar(1500),IdDSebeka varchar(100),HollyFather varchar(100),LangSkill1 varchar(100),LangSkill2 varchar (100),LangSkill3 varchar (100),Ageligilot varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void kiribTeteriTable() {
        try {
            stmt.execute("CREATE TABLE KiribTeteriTable(IDNO int primary key,FirstName varchar(1000),MiddleName varchar(1000),LastName varchar(1000),Ketema varchar(1500),Kefitegna varchar(1500),Kebele varchar(1500),HouNo varchar(100),HouPhone varchar(100),MobileNum varchar(100))");

        } catch (Exception l) {
        }
    }

    public static void addNameBirth(int idno, String fname, String mname, String lname, String bdate, String wereda, String ketema, String kebele) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO NameBirthB(መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,የትውልድጊዜ,ወረዳ,ከተማ,ቀበሌ)VALUES(  '" + idno + "','" + fname + "','" + mname + "','" + lname + "','" + bdate + "','" + wereda + "','" + ketema + "','" + kebele + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void addATable2(String str, String idno, String fname, String mname, String lname, String bdate, String wereda, String response, String day, String month, String year, String phone) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();
            yearTable = str;

            int count;
            count = stmt.executeUpdate("INSERT INTO ATablee" + yearTable + "(መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትቀን,የገቡበትወር,የገቡበትዓመት,ስልክቁጥር)VALUES(  '" + idno + "','" + fname + "','" + mname + "','" + lname + "','" + bdate + "','" + wereda + "','" + response + "','" + day + "','" + month + "','" + year + "','" + phone + "')");
            con.close();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("መረጃ መንገድ");
            alert.setContentText("1 rows were inserted");

            alert.showAndWait();

        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("መረጃ መንገድ");
            alert.setContentText("Duplicate Entry");

            alert.showAndWait();
        }
    }

    public static void updateTable(String str, String idno) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();
            yearTable = str;
            int count;

            count = stmt.executeUpdate("INSERT INTO ATablee" + idno + "(መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትቀን,የገቡበትወር,የገቡበትዓመት,ስልክቁጥር) SELECT መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትቀን,የገቡበትወር,የገቡበትዓመት,ስልክቁጥር from ATablee" + str + " ");
            con.close();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("መረጃ መንገድ");
            alert.setContentText("Data successfully transmitted");

            alert.showAndWait();
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("መረጃ መንገድ");
            alert.setContentText("Duplicate Entry");

            alert.showAndWait();

        }
    }

    public static void addLeaveTable(String idno, String fname, String mname, String lname, String bdate, String wereda, String day, String month, String year, String phone, String mm) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO LeaveTableA(መለያቁጥር,የመጀመሪያስም,የአባትስም,የአያትስም,ፆታ,አገልግሎትክፍል,ኃላፊነት,የገቡበትጊዜ,ስልክቁጥር,የለቀቁበትምክንያት,የለቀቁበትጊዜ)VALUES(  '" + idno + "','" + fname + "','" + mname + "','" + lname + "','" + bdate + "','" + wereda + "','" + day + "','" + month + "','" + year + "','" + phone + "','" + mm + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void addKirstinaTable(int idno, String kname, String kbk, String khname, String kzemen, String khager, String kkebele, String kawraja, String khbk) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO KirstinaTable(IDNO,KirstinaName,KirstinaBK,KihinetName,KihinetZemen,KihinetHager,KihinetKebele,KihinetAwraja,KihinetBK)VALUES(  '" + idno + "','" + kname + "','" + kbk + "','" + khname + "','" + kzemen + "','" + khager + "','" + kkebele + "','" + kawraja + "','" + khbk + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void addSenbetBKTable(int idno, String fstay, String sstay, String collegname, String staytime, String stayhs, String staybk, String staysunday, String gfield) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO SenbetBKTable(IDNO,FirstStay,SecondStay,CollegeName,StayTime,StayHSibket,StayBK,StaySundayName,GraduatedField)VALUES(  '" + idno + "','" + fstay + "','" + sstay + "','" + collegname + "','" + staytime + "','" + stayhs + "','" + staybk + "','" + staysunday + "','" + gfield + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void addCurrentJobTable(int idno, String jobhs, String jobzone, String jobwereda, String jobketema, String jobkebele, String jobgebere, String jobtype, String jobhouse, String jobphone) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO CurrentJobTable(IDNO,JobHS,JobZone,JobWereda,JobKetema,JobKebele,JobGebere,JobType,JobHouse,JobPhone)VALUES(  '" + idno + "','" + jobhs + "','" + jobzone + "','" + jobwereda + "','" + jobketema + "','" + jobkebele + "','" + jobgebere + "','" + jobtype + "','" + jobhouse + "','" + jobphone + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void addLiveAddressTable(int idno, String jobhs, String jobzone, String jobwereda, String jobketema, String jobkebele, String jobgebere, String jobtype, String jobhouse) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO LiveAddressTable(IDNO,LiveKetema,LiveKefitegna,LiveKebele,LiveHNo,LivePhone,LiveMobile,LiveAdmin,LiveEduStatus)VALUES(  '" + idno + "','" + jobhs + "','" + jobzone + "','" + jobwereda + "','" + jobketema + "','" + jobkebele + "','" + jobgebere + "','" + jobtype + "','" + jobhouse + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void addKiribTeteriTable(int idno, String jobhs, String jobzone, String jobwereda, String jobketema, String jobkebele, String jobgebere, String jobtype, String jobhouse, String last) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO KiribTeteriTable(IDNO,FirstName,MiddleName,LastName,Ketema,Kefitegna,Kebele,HouNo,HouPhone,MobileNum)VALUES(  '" + idno + "','" + jobhs + "','" + jobzone + "','" + jobwereda + "','" + jobketema + "','" + jobkebele + "','" + jobgebere + "','" + jobtype + "','" + jobhouse + "','" + last + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void addCurrentServiceTablet(int idno, String cbk, String jobhs, String jobzone, String jobwereda, String jobketema, String jobkebele, String jobgebere, String jobtype, String jobhouse, String service) {

        try {

            Class.forName("org.h2.Driver");

            cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");

            con = cp.getConnection();

            stmt = con.createStatement();

            int count;

            count = stmt.executeUpdate("INSERT INTO CurrentServiceTable(IDNO,BkName,KihinetMahireg,SundaySchool,SebekaGubae,IdDSebeka,HollyFather,LangSkill1,LangSkill2,LangSkill3,Ageligilot)VALUES(  '" + idno + "','" + cbk + "','" + jobhs + "','" + jobzone + "','" + jobwereda + "','" + jobketema + "','" + jobkebele + "','" + jobgebere + "','" + jobtype + "','" + jobhouse + "','" + service + "')");
            con.close();
            System.out.println(count + " 1 rows were inserted");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static int insert(String query) {
        try {
            stmt.execute(query);
            return 1;
        } catch (Exception l) {
            JOptionPane.showMessageDialog(null, "Wrong Action");
            return 0;
        }
    }

    public static int update(String query) {
        try {
            stmt.execute(query);
            return 1;
        } catch (Exception l) {
            JOptionPane.showMessageDialog(null, l.getMessage());
            return 0;
        }
    }

    public static int delete(String query) {
        try {
            stmt.execute(query);
            return 1;
        } catch (Exception l) {
            JOptionPane.showMessageDialog(null, l.getMessage());
            return 0;
        }
    }

    public static void display(int wordID) {
        try {
            String req = "Select * From Words Where AM_WORD_ID = " + wordID;
            ResultSet rset = stmt.executeQuery(req);

            while (rset.next()) {
                wrd = rset.getString("WORD");
                img = rset.getBlob("WORD_PICTURE");
                imgData = img.getBytes(1, (int) img.length());
                sound = rset.getBlob("WORD_SOUND");
                soundData = sound.getBytes(1, (int) sound.length());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public List<Members> getStatusByStuName(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember.setString(1, id);
            resultSet = selectMember.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("መለያቁጥር"), resultSet.getString("የመጀመሪያስም"), resultSet.getString("የአባትስም"), resultSet.getString("የአያትስም"), resultSet.getString("የትውልድጊዜ"), resultSet.getString("ወረዳ"), resultSet.getString("ከተማ"), resultSet.getString("ቀበሌ")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getCurrentService(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember9.setString(1, id);
            resultSet = selectMember9.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("BkName"), resultSet.getString("KihinetMahireg"), resultSet.getString("SundaySchool"), resultSet.getString("SebekaGubae"), resultSet.getString("IdDSebeka"), resultSet.getString("HollyFather"), resultSet.getString("Ageligilot")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getStatusByStuName1(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember1.setString(1, id);
            resultSet = selectMember1.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("KirstinaName"), resultSet.getString("KirstinaBK"), resultSet.getString("KihinetName"), resultSet.getString("KihinetZemen")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getStatusBackLife(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember4.setString(1, id);
            resultSet = selectMember4.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("KihinetHager"), resultSet.getString("KihinetKebele"), resultSet.getString("KihinetAwraja"), resultSet.getString("KihinetBK")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getStatusBackLife1(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember5.setString(1, id);
            resultSet = selectMember5.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("FirstStay"), resultSet.getString("SecondStay"), resultSet.getString("CollegeName"), resultSet.getString("StayTime"), resultSet.getString("StayHSibket"), resultSet.getString("StayBK"), resultSet.getString("StaySundayName"), resultSet.getString("GraduatedField")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getJobLife(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember6.setString(1, id);
            resultSet = selectMember6.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("JobHS"), resultSet.getString("JobZone"), resultSet.getString("JobWereda"), resultSet.getString("JobKetema"), resultSet.getString("JobKebele"), resultSet.getString("JobGebere"), resultSet.getString("Jobtype"), resultSet.getString("JobHouse"), resultSet.getString("JobPhone")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getLiveAddress(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember8.setString(1, id);
            resultSet = selectMember8.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("LiveKetema"), resultSet.getString("LiveKefitegna"), resultSet.getString("LiveKebele"), resultSet.getString("LiveHNo"), resultSet.getString("LivePhone"), resultSet.getString("LiveMobile"), resultSet.getString("LiveAdmin"), resultSet.getString("LiveEduStatus")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getKiribTeter(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember7.setString(1, id);
            resultSet = selectMember7.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("FirstName"), resultSet.getString("MiddleName"), resultSet.getString("LastName"), resultSet.getString("Ketema"), resultSet.getString("Kefitegna"), resultSet.getString("Kebele"), resultSet.getString("HouNo"), resultSet.getString("HouPhone"), resultSet.getString("MobileNum")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getLeave(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMemberA.setString(1, id);
            resultSet = selectMemberA.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("የመጀመሪያስም"), resultSet.getString("የአባትስም"), resultSet.getString("የአያትስም"), resultSet.getString("ፆታ"), resultSet.getString("አገልግሎትክፍል"), resultSet.getString("ኃላፊነት"), resultSet.getString("የገቡበትቀን"), resultSet.getString("የገቡበትወር"), resultSet.getString("የገቡበትዓመት"), resultSet.getString("ስልክቁጥር")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getAgeligilot(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {

            selectMemberAC.setString(1, id);
            resultSet = selectMemberAC.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("መለያቁጥር"), resultSet.getString("የመጀመሪያስም"), resultSet.getString("የአባትስም"), resultSet.getString("የአያትስም"), resultSet.getString("ፆታ"), resultSet.getString("አገልግሎትክፍል"), resultSet.getString("ኃላፊነት"), resultSet.getString("የገቡበትቀን"), resultSet.getString("የገቡበትወር"), resultSet.getString("የገቡበትዓመት"), resultSet.getString("ስልክቁጥር")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getID(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {

            selectMemberIDNO.setString(1, id);
            resultSet = selectMemberIDNO.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("መለያቁጥር")));

            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public List<Members> getStatusByStuName2(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMember2.setString(1, id);
            resultSet = selectMember2.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("LangSkill1"), resultSet.getString("LangSkill2"), resultSet.getString("LangSkill3")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch

        return results;
    }

    public int update(String title, String con, String day) {
        int results = 0;;
        try {
            selectMemberU.setString(1, title);
            selectMemberU.setString(2, con);

            selectMemberU.setString(3, day);

            results = selectMemberU.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateAccount(String fname, String mname, String uname, String cname, String password, int idno) {
        int results = 0;;
        try {
            updateAccount.setString(1, fname);
            updateAccount.setString(2, mname);

            updateAccount.setString(3, uname);
            updateAccount.setString(4, cname);
            updateAccount.setString(5, password);
            updateAccount.setInt(6, idno);

            results = updateAccount.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateN(String title, String con, String day, String title1, String con1, String day1, String keb, String id) {
        int results = 0;;
        try {
            selectMemberUN.setString(1, title);
            selectMemberUN.setString(2, con);

            selectMemberUN.setString(3, day);
            selectMemberUN.setString(4, title1);
            selectMemberUN.setString(5, con1);

            selectMemberUN.setString(6, day1);
            selectMemberUN.setString(7, keb);
            selectMemberUN.setString(8, id);

            results = selectMemberUN.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateUC(String title, String con, String day, String title1, String con1, String day1, String keb, String id) {
        int results = 0;;
        try {
            selectMemberUC.setString(1, title);
            selectMemberUC.setString(2, con);

            selectMemberUC.setString(3, day);
            selectMemberUC.setString(4, title1);
            selectMemberUC.setString(5, con1);

            selectMemberUC.setString(6, day1);
            selectMemberUC.setString(7, keb);
            selectMemberUC.setString(8, id);

            results = selectMemberUC.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateUS(String title, String con, String day, String title1, String con1, String day1, String keb, String fie, String id) {
        int results = 0;;
        try {
            selectMemberUS.setString(1, title);
            selectMemberUS.setString(2, con);

            selectMemberUS.setString(3, day);
            selectMemberUS.setString(4, title1);
            selectMemberUS.setString(5, con1);

            selectMemberUS.setString(6, day1);
            selectMemberUS.setString(7, keb);
            selectMemberUS.setString(8, fie);
            selectMemberUS.setString(9, id);

            results = selectMemberUS.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateUL(String title, String con, String day, String title1, String con1, String day1, String keb, String fie, String id) {
        int results = 0;;
        try {
            selectMemberUL.setString(1, title);
            selectMemberUL.setString(2, con);

            selectMemberUL.setString(3, day);
            selectMemberUL.setString(4, title1);
            selectMemberUL.setString(5, con1);

            selectMemberUL.setString(6, day1);
            selectMemberUL.setString(7, keb);
            selectMemberUL.setString(8, fie);
            selectMemberUL.setString(9, id);

            results = selectMemberUL.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateUJ(String title, String con, String day, String title1, String con1, String day1, String keb, String fie, String haha, String id) {
        int results = 0;;
        try {
            selectMemberUJ.setString(1, title);
            selectMemberUJ.setString(2, con);

            selectMemberUJ.setString(3, day);
            selectMemberUJ.setString(4, title1);
            selectMemberUJ.setString(5, con1);

            selectMemberUJ.setString(6, day1);
            selectMemberUJ.setString(7, keb);
            selectMemberUJ.setString(8, fie);
            selectMemberUJ.setString(9, haha);
            selectMemberUJ.setString(10, id);

            results = selectMemberUJ.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateUKI(String title, String con, String day, String title1, String con1, String day1, String keb, String fie, String haha, String id) {
        int results = 0;;
        try {
            selectMemberUKI.setString(1, title);
            selectMemberUKI.setString(2, con);

            selectMemberUKI.setString(3, day);
            selectMemberUKI.setString(4, title1);
            selectMemberUKI.setString(5, con1);

            selectMemberUKI.setString(6, day1);
            selectMemberUKI.setString(7, keb);
            selectMemberUKI.setString(8, fie);
            selectMemberUKI.setString(9, haha);
            selectMemberUKI.setString(10, id);

            results = selectMemberUKI.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateK(String title, String con, String day, String kb, String id) {
        int results = 0;;
        try {
            selectMemberUK.setString(1, title);
            selectMemberUK.setString(2, con);

            selectMemberUK.setString(3, day);
            selectMemberUK.setString(4, kb);

            selectMemberUK.setString(5, id);

            results = selectMemberUK.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateUK(String title, String con, String day, String kb, String id) {
        int results = 0;;
        try {
            selectMemberUK1.setString(1, title);
            selectMemberUK1.setString(2, con);

            selectMemberUK1.setString(3, day);
            selectMemberUK1.setString(4, kb);

            selectMemberUK1.setString(5, id);

            results = selectMemberUK1.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int deleteMem(String name) {
        int results = 0;;
        try {
            selectMemberD.setString(1, name);

            results = selectMemberD.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public int updateYear(String title, String id) {
        int results = 0;;
        try {
            selectMemberUY.setString(1, title);

            selectMemberUY.setString(2, id);

            results = selectMemberUY.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return results;
    }

    public List<Members> getNote(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            selectMemberN.setString(1, id);
            resultSet = selectMemberN.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("Title"), resultSet.getString("Contents")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch

        return results;
    }

    public List<Members> getUserAccount() {
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            // selectAccount.setInt(1, id);
            resultSet = selectAccount.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("UserName"), resultSet.getString("PassWord")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(Arrays.toString(sqlException.getStackTrace()));
        } // end catch

        return results;
    }

    public List<Members> getStatusByStuName3(String id) {
        List<Members> results = null;
        ResultSet resultSet = null;
        try {
            selectMember3.setString(1, id);
            resultSet = selectMember3.executeQuery();
            results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("LiveMobile")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } //

        return results;
    }

    public static ResultSet selectTable(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static void closeConnection() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException l) {
        }
    }
}
