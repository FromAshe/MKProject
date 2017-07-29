/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.databaseTableModule;

import mkproject.applicationBeanModule.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mkproject.ConnectionManager;
import mkproject.Members;

/**
 *
 * @author Ashenafi
 */
public class AdminManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();
    private static PreparedStatement updateAccount = null;

    public static Admin getUserA() {
        //DatabaseClass stuQueries;
        AdminManager stuQueries = new AdminManager();
        List<Members> results;
        int numberOfEntries = 0;
        int currentEntryIndex;
        Members studata;

        results = stuQueries.getUserAccount();
        numberOfEntries = results.size();
        System.out.println("number of entries are: " + numberOfEntries);

        if (numberOfEntries != 0) {
            currentEntryIndex = 0;
            Admin userAccount = new Admin();
            studata = results.get(currentEntryIndex);

            userAccount.setUserName(studata.getNote());
            userAccount.setPassword(studata.getTitle());

            return userAccount;

        } else {
            return null;
        }
    }

    private List<Members> getUserAccount() {
        String sql = "SELECT UserName,PassWord FROM AccountTablee WHERE IDNO = 1";
        List<Members> results = null;
        ResultSet resultSet = null;

        try {
            PreparedStatement selectAccount;
            selectAccount = conn.prepareStatement(sql);

            resultSet = selectAccount.executeQuery();
            results = new ArrayList<>();

            while (resultSet.next()) {
                results.add(new Members(resultSet.getString("UserName"), resultSet.getString("PassWord")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        } // end catch
        finally {
            //ConnectionManager.getInstance().closeConnection();
        }

        return results;
    }

    public int updateAccount(String fname, String mname, String uname, String cname, String password, int idno) {
        int results = 0;

        try {
            updateAccount = conn.prepareStatement("UPDATE AccountTablee SET FirstName=?,FatherName=?,UserName=?,UserCode=?,PassWord=? WHERE IDNO=?");
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

}
