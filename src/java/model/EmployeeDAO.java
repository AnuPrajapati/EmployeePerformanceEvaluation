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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasil
 */
public class EmployeeDAO {

    //insert employees data
    public static String InsertRecord(RecordModel registerBean) {

        double communication = registerBean.getCommunication();
        double work_product = registerBean.getWork_product();
        double adaptability = registerBean.getAdaptability();
        double reliablity = registerBean.getReliablity();
        double attitude = registerBean.getAttitude();
        double attendance = registerBean.getAttendance();

        int e_id = registerBean.getE_id();

        if (communication > 5 || work_product > 5 || adaptability > 5 || reliablity > 5 || attendance > 5 || attitude > 5) {
            return " Insert fail because of invalid value i.e greater than 5";
        }

        Connection con = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            con = DBConnection.createConnection();

            String query = "insert into record(work_product,communication,attendences,attitude,adaptability,reliability,e_id) values (?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setDouble(1, work_product);
            preparedStatement.setDouble(2, communication);
            preparedStatement.setDouble(3, attendance);
            preparedStatement.setDouble(4, attitude);
            preparedStatement.setDouble(5, adaptability);
            preparedStatement.setDouble(6, reliablity);
            preparedStatement.setInt(7, e_id);

            i = preparedStatement.executeUpdate();

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

    // count for status
    public static int countStatus(int mid) {
        int a = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ;
            conn = DBConnection.createConnection();
            String sql = "select r.status from record r inner join employee e on r.e_id=e.e_id inner join manager m on e.id=m.id WHERE m.id=" + mid + " ORDER BY r.status DESC LIMIT 1";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                a = rs.getInt("status");
            }

        } catch (SQLException ex) {
            System.out.println("Error in controller.Setting of viewdata");
        }
        return a;
    }

    //insert to evaluate table taking pid and rid
    public static String AddEvaluate(int pid, int rid) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean result = false;
        String sql = null;
        try {
            con = DBConnection.createConnection();

            String aa = "insert into evaluate(p_id,r_id) values (?,?)";
            preparedStatement = con.prepareStatement(aa); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setInt(1, pid);
            preparedStatement.setInt(2, rid);

            int s = preparedStatement.executeUpdate();

            if (s != 0) //Just to ensure data has been inserted into the database
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

    }
//insert final_result in performance table

    public static String AddResultPerform(String cluster, int rid) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean result = false;
        String sql = null;
        try {
            con = DBConnection.createConnection();

            String query = "insert into performance(final_result,r_id) values (?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, cluster);
            preparedStatement.setInt(2, rid);

            int s = preparedStatement.executeUpdate();

            if (s != 0) //Just to ensure data has been inserted into the database
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

    }

    //final perfoamance method to insert
    public static String PerformanceResult(int eid, String cluster) {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            con = DBConnection.createConnection();
            ArrayList<Integer> id = getRIDIfExit(con, eid);
            System.out.println("ss" + id.get(0));
            for (int o = 0; o < id.size(); o++) {
                int pid;
                String rid = String.valueOf(id.get(o));

                System.out.println("I am in DAO here");
                boolean r = CheckIfAgain(con, rid);

                if (r == false) {
                    //call to insert finalresult
                    AddResultPerform(cluster, (int) id.get(o));
//call to find the pid
                    pid = viewPerformanceid();

                    System.out.println("pid.........." + pid);
                    //call to insert in evaluate table
                    AddEvaluate(pid, (int) id.get(o));

                }
            }

            if (i != 0) //Just to ensure data has been inserted into the database
            {

                return "SUCCESS";
            }
        } finally {
            // close JDBC objects
            close(con, preparedStatement, null);
        }

        return "Oops.. Something went wrong there..!";
        // On failure, send a message from here.
    }

    //to get the just inserted performance id
    public static int viewPerformanceid() {
        int a = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ;
            conn = DBConnection.createConnection();
            String sql = "Select p_id from performance  order by p_id DESC LIMIT 1";

            stmt = conn.createStatement();
            System.out.println("Record1" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                a = rs.getInt("p_id");
            }

        } catch (SQLException ex) {
            System.out.println("Error in controller.Setting of viewdata");
        }
        return a;
    }

    //to check if the record exists or not
    private static ArrayList getRIDIfExit(Connection con, int eid) {
        ArrayList<Integer> result = new ArrayList();
        String sql = null;
        try {
            PreparedStatement preparedStatement = null;
            sql = "select r.r_id from record r  inner join  employee e on r.e_id=e.e_id where e.e_id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, eid);

            ResultSet i = preparedStatement.executeQuery();

            while (i.next()) {
                result.add(i.getInt("r_id"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //check if the record has final result or not
    private static boolean CheckIfAgain(Connection con, String rid) {
        boolean result = false;
        String sql = null;
        try {
            PreparedStatement preparedStatement = null;
            sql = " select r.r_id, p.final_result from performance p inner join record r on p.r_id=r.r_id where r.r_id=? ";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(rid));
            ResultSet i = preparedStatement.executeQuery();
            int count = 0;
            while (i.next()) {

                count++;
            }
            if (count > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    //insert employees data
    public String UserDetail(EmplyeeModel registerBean) {
        String name = registerBean.getName();
        String address = registerBean.getAddress();
        String phone = registerBean.getPhone();
        int id = registerBean.getId();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            con = DBConnection.createConnection();
            String p = "phone";
            boolean r = CheckIfExits(con, phone);
            if (r == false) {
                String query = "insert into employee(name,address,phone,id) values (?,?,?,?)"; //Insert user details into the table 'USERS'
                preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, phone);
                preparedStatement.setInt(4, id);

                i = preparedStatement.executeUpdate();
            }

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

    //check if the same phone no. user exists or not
    public static boolean CheckIfExits(Connection con, String a) {
        boolean result = false;
        String sql = null;
        try {
            PreparedStatement preparedStatement = null;

            sql = "select * from employee where phone=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, a);

            ResultSet i = preparedStatement.executeQuery();
            int count = 0;
            while (i.next()) {

                count++;
            }
            if (count > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String UpdateUserDetail(EmplyeeModel registerBean) {
        String name = registerBean.getName();
        String address = registerBean.getAddress();
        String phone = registerBean.getPhone();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBConnection.createConnection();
            String query = "Update employee set name=?,address=?,phone=?"; //update user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);

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

    public String UpdatecountStatus(int mid, int count) {

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBConnection.createConnection();
            String query = "Update countrecord set count=" + count + "where mid=" + mid + ""; //update user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

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

    public static int delete(EmplyeeModel u) {
        int status = 0;
        try {
            Connection con = DBConnection.createConnection();
            PreparedStatement ps = con.prepareStatement("delete from employee where e_id=?");
            ps.setInt(1, u.getE_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    //get all userdata of specified manger id
    public static List<EmplyeeModel> getAllUser(String id, String search) throws Exception {

        List<EmplyeeModel> students = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = DBConnection.createConnection();
            // create sql statement
            myStmt = myConn.createStatement();
            String data;
            String query = search;
            if (query != null) {
                data = "select * from employee WHERE name LIKE '%" + query + "%'";
            } else {
                data = "SELECT * FROM employee WHERE id=" + Integer.parseInt(id);
            }
            myRs = myStmt.executeQuery(data);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int eid = myRs.getInt("e_id");
                String name = myRs.getString("name");
                String address = myRs.getString("address");
                String phone = myRs.getString("phone");
                int mid = Integer.parseInt(id);
                // Student tempStudent = new Student(id, name, add);
                EmplyeeModel tempStudent = new EmplyeeModel(eid, name, phone, address, mid);

                // add it to the list of students
                students.add(tempStudent);
            }

            return students;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    //show individual record of specied employee id
    public static List<RecordModel> ShowIndividualUser(String id) throws Exception {
        List<RecordModel> students = new ArrayList<>();

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int check = 0;

        try {
            // get a connection
            myConn = DBConnection.createConnection();
            // create sql statement
            String sql = "select p.final_result,r.* from performance p inner join record r on p.r_id=r.r_id where r.e_id=?";

            myStmt = myConn.prepareStatement(sql);
            //set param
            myStmt.setInt(1, Integer.parseInt(id));

            //execute statement
            myRs = myStmt.executeQuery();
            //retrieve data from rs
            while (myRs.next()) {
                int e_id = myRs.getInt("e_id");

                int status = myRs.getInt("status");
                int r_id = myRs.getInt("r_id");
                double com = myRs.getDouble("communication");
                double w = myRs.getDouble("work_product");
                double atten = myRs.getDouble("attendences");
                double attitude = myRs.getDouble("attitude");
                double reliability = myRs.getDouble("reliability");
                double adap = myRs.getDouble("adapatability");
                String final_result = myRs.getString("final_result");
//                check = check + 1;
//                System.out.println("check=" + check);

                RecordModel rmodel = new RecordModel(com, w, adap, reliability, attitude, atten, e_id, r_id, status, final_result);

                students.add(rmodel);

            }
            return students;

        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }

    }

    //show all user record
    public static List<EmplyeeModel> ShowAllUserRecord(int id, int status, int a, String search) throws Exception {
        List<EmplyeeModel> students = new ArrayList<>();
        System.out.println("Here I am here");
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        RecordModel rmodel;

        try {
            // get a connection
            myConn = DBConnection.createConnection();
            String sql = null;
            String query = search;
            if (query != null) {
                if (a == 1) {
                    sql = "SELECT p.* ,e.*, r.*  ,(r.work_product+r.communication+r.attendences+r.attitude+r.adapatability+r.reliability)/6 AS mean FROM employee e INNER JOIN record r on e.e_id=r.r_id INNER JOIN performance p on r.r_id=p.r_id WHERE e.id=? And r.status=? AND e.name LIKE '%" + query + "%' ";
                }
            } else {
                // create sql statement
                if (a == 1) {
                    sql = "SELECT p.*, e.*, r.*,(r.work_product+r.communication+r.attendences+r.attitude+r.adapatability+r.reliability)/6 AS mean FROM employee e INNER JOIN record r on e.e_id=r.r_id INNER JOIN performance p on r.r_id=p.r_id WHERE e.id=? And r.status=? ORDER BY e.e_id";

                } else {
                    sql = "SELECT e.*, r.*,(r.work_product+r.communication+r.attendences+r.attitude+r.adapatability+r.reliability)/6 AS mean FROM employee e INNER JOIN record r on e.e_id=r.r_id WHERE e.id=? And r.status=? ORDER BY e.e_id";
                }
            }
            myStmt = myConn.prepareStatement(sql);
            //set param
            myStmt.setInt(1, id);
            myStmt.setInt(2, status);

            //execute statement
            myRs = myStmt.executeQuery();

            //retrieve data from rs
            while (myRs.next()) {

                EmplyeeModel model = null;

                String name = myRs.getString("name");
                double com = myRs.getDouble("communication");
                double w = myRs.getDouble("work_product");
                double atten = myRs.getDouble("attendences");
                double attitude = myRs.getDouble("attitude");
                double reliability = myRs.getDouble("reliability");
                double adap = myRs.getDouble("adapatability");
                double mean = myRs.getDouble("mean");
                int eid = myRs.getInt("e_id");
                String address = myRs.getString("address");
                String phone = myRs.getString("phone");
                if (a == 1) {
                    String result = myRs.getString("final_result");
                    rmodel = new RecordModel(com, w, adap, reliability, attitude, atten, mean, result);
                } else {
                    rmodel = new RecordModel(com, w, adap, reliability, attitude, atten, mean);
                }
                model = new EmplyeeModel(eid, name, phone, address, id, rmodel);

                students.add(model);

            }

            return students;

        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }

    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {

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

    //count the  mo. of good
    public static int getCountGood(int mid, int status, String result) {
        Connection con = null;
        java.sql.Statement s = null;
        java.sql.ResultSet rs = null;
        int good = 0;
        con = DBConnection.createConnection();

        String sql = " SELECT count(p.final_result) as Good from performance p inner join record r  on p.r_id=r.r_id INNER join employee e on r.e_id=e.e_id inner join manager m on e.id=m.id where m.id=" + mid + " AND status=" + status + "  AND p.final_result=" + result + "";

        try {
            s = con.createStatement();
            rs = s.executeQuery(sql);

            if (rs.next()) { //while start
                good = rs.getInt("Good");
            }
        } catch (Exception x) {
            x.printStackTrace();
            System.out.println("Error:" + x.getMessage());
        } finally {
            // close JDBC objects
            close(con, s, rs);
        }

        return good;
    }

    //for company
    public static String getCompany(int mid) {
        Connection con = null;
        java.sql.Statement s = null;
        java.sql.ResultSet rs = null;
        String fair = null;
        con = DBConnection.createConnection();

        String sql = " SELECT companyname from manager where id=" + mid + "";

        try {
            s = con.createStatement();
            rs = s.executeQuery(sql);

            if (rs.next()) { //while start
                fair = rs.getString("companyname");
            }
        } catch (Exception x) {
            x.printStackTrace();
            System.out.println("Error:" + x.getMessage());
        } finally {
            // close JDBC objects
            close(con, s, rs);
        }

        return fair;
    }
    //for company

    public static int getCountForStatus(int mid) {
        Connection con = null;
        java.sql.Statement s = null;
        java.sql.ResultSet rs = null;
        int fair = 0;
        con = DBConnection.createConnection();

        String sql = " SELECT count from recordcount where mid=" + mid + "";

        try {
            s = con.createStatement();
            rs = s.executeQuery(sql);

            if (rs.next()) { //while start
                fair = rs.getInt("count");
            }
        } catch (Exception x) {
            x.printStackTrace();
            System.out.println("Error:" + x.getMessage());
        } finally {
            // close JDBC objects
            close(con, s, rs);
        }

        return fair;
    }

}
