/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DBConnect.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EmployeeDAO;
import model.RecordModel;

/**
 *
 * @author hasil
 */
public class RecordInsertServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
//        int id = (int) session.getAttribute("id");
        Cookie[] cookies = null;
        String sid = null;
        cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("id")) {
                sid = cookies[i].getValue();
            }

        }
        int id = Integer.parseInt(sid);
        int statuscount = EmployeeDAO.getCountForStatus(id);

        Connection conn = DBConnection.createConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        String sql = "select * from employee   WHERE id=" + id + " order by e_id";

        stmt = conn.prepareStatement(sql);

        rs = stmt.executeQuery(sql);

        String in = null;
        while (rs.next()) {

            int eid = rs.getInt("e_id");
            double com = Double.parseDouble(request.getParameter("communication" + eid));

            double att = Double.parseDouble(request.getParameter("attendance" + eid));
            double attitude = Double.parseDouble(request.getParameter("attitude" + eid));
            double rel = Double.parseDouble(request.getParameter("reliability" + eid));
            double work = Double.parseDouble(request.getParameter("work_product" + eid));
            double adap = Double.parseDouble(request.getParameter("adaptability" + eid));

            RecordModel model = new RecordModel(com, work, adap, rel, attitude, att, eid, id, statuscount + 1);
            in = EmployeeDAO.InsertRecord(model);

        }

        if (in.equals("SUCCESS")) {
            String incstatus = EmployeeDAO.UpdatecountStatus(id, statuscount + 1);
            RequestDispatcher req = request.getRequestDispatcher("AllUserRecordDetail.jsp");
            req.forward(request, response);

        } else {
            RequestDispatcher req = request.getRequestDispatcher("AllUserRecordDetail.jsp");
            req.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Errir in record insert");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Errir in record insert");
        }
    }

}
