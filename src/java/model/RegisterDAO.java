/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DBConnect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hasil
 */
public class RegisterDAO {

    public String registerUser(RegisterModel registerBean) {
        String companyname = registerBean.getCompanyname();
        String managername = registerBean.getManagername();
        String userName = registerBean.getUsername();
        String password = registerBean.getPassword();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBConnection.createConnection();
            String query = "insert into manager(managername,companyname,username,password) values (?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, managername);
            preparedStatement.setString(2, companyname);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);

            int i = preparedStatement.executeUpdate();

            if (i != 0) //Just to ensure data has been inserted into the database
            {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close JDBC objects
            close(con, preparedStatement, null);
        }

        return "Oops.. Something went wrong there..!";
        // On failure, send a message from here.
    }

    public String ShowManagerIfExit(String username) {
        RegisterModel reg = null;
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = DBConnection.createConnection();
            // create sql statement
            String sql = "select * from manager where username=? ";

            myStmt = myConn.prepareStatement(sql);
            //set param
            myStmt.setString(1, username);

            //execute statement
            myRs = myStmt.executeQuery();
            //retrieve data from rs
            if (myRs.next()) {
                return "Success";

            } else {
                return "Fail";
            }

        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return "Fail";

    }

    public List<RegisterModel> getAll() throws Exception {

        List<RegisterModel> students = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = DBConnection.createConnection();
            // create sql statement
            String sql = "select * from manager";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String companyname = myRs.getString("companyname");
                String managername = myRs.getString("managername");
                String email = myRs.getString("username");

                String password = myRs.getString("password");

                // create new student object
                // Student tempStudent = new Student(id, name, add);
                RegisterModel tempStudent = new RegisterModel(id, email, password, companyname, managername);

                // add it to the list of students
                students.add(tempStudent);
            }

            return students;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public RegisterModel ShowIndividual(String username, String password) {
        RegisterModel reg = null;
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = DBConnection.createConnection();
            // create sql statement
            String sql = "select * from manager where username=? AND password=?";

            myStmt = myConn.prepareStatement(sql);
            //set param
            myStmt.setString(1, username);
            myStmt.setString(2, password);

            //execute statement
            myRs = myStmt.executeQuery();
            //retrieve data from rs
            if (myRs.next()) {
                int eid = myRs.getInt("id");
                String managername = myRs.getString("managername");
                String companyname = myRs.getString("companyname");
                String email = myRs.getString("username");

                String pass = myRs.getString("password");
                //use studenrId during construction
                reg = new RegisterModel(eid, email, pass, companyname, managername);

            } else {
                reg = null;
            }

        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return reg;

    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    //modified Date 8.17.2019
    public static int existsEmployeeIDofManager(int mng_id) {
        int a = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ;
            conn = DBConnection.createConnection();
            String sql = "SELECT id FROM employee WHERE id = " + mng_id + " LIMIT 1";

            stmt = conn.createStatement();
            System.out.println("MAnager" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                a = rs.getInt("id");
            }

        } catch (SQLException ex) {
            System.out.println("Error in controller.Setting of viewdata");
        }
        return a;
    }

}
