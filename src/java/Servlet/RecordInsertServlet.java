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
        int id = (int) session.getAttribute("id");
        int statuscount = EmployeeDAO.getCountForStatus(1);

        int inn = statuscount + 1;
        String incstatus = EmployeeDAO.UpdatecountStatus(1, inn);
        out.print(incstatus);
        if (incstatus.equals("SUCCESS")) {
            Connection conn = DBConnection.createConnection();
            PreparedStatement stmt = null;

            ResultSet rs = null;

            String sql = "select * from employee   WHERE id=" + id + " order by e_id";

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            out.println("inn=" + inn);
            String in = null;
            while (rs.next()) {

                int eid = rs.getInt("e_id");
                double com = Double.parseDouble(request.getParameter("communication" + eid));

                double att = Double.parseDouble(request.getParameter("attendance" + eid));
                double attitude = Double.parseDouble(request.getParameter("attitude" + eid));
                double rel = Double.parseDouble(request.getParameter("reliability" + eid));
                double work = Double.parseDouble(request.getParameter("work_product" + eid));
                double adap = Double.parseDouble(request.getParameter("adaptability" + eid));

                RecordModel model = new RecordModel(com, work, adap, rel, attitude, att, eid, id, inn);
                in = EmployeeDAO.InsertRecord(model);

            }
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
            Logger.getLogger(RecordInsertServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(RecordInsertServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
