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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        int a = Integer.parseInt(request.getParameter("count"));
        for (int i = 0; i < 102; i++) {
            String eid = request.getParameter("eeid");
            String jja = request.getParameter("communication1" + eid);
            out.print("<br>" + eid + "=" + jja + "<br>");
        }

//        Connection con = DBConnection.createConnection();
//        PreparedStatement stmt = null;
//
//        ResultSet rs = null;
//
//        String sql = "select * from employee  WHERE id=1 order bye_id e_id";
//
//        stmt = conn.prepareStatement(sql);
//        int count = 0;
//        rs = stmt.executeQuery(sql);
//        int statuscount = EmployeeDAO.countStatus(1);
//        while (rs.next()) {
//            int i = rs.getInt("e_id");
//            String jja = request.getParameter("communication1" + i);
//            out.print(i + "=" + jja + "<br>");
//            double com = Double.parseDouble(request.getParameter('communication<%=rs.getInt("e_id")%>'));
//            double att = Double.parseDouble(request.getParameter("attendence"));
//            double attitude = Double.parseDouble(request.getParameter("attitude"));
//            double rel = Double.parseDouble(request.getParameter("reliability"));
//            double work = Double.parseDouble(request.getParameter("work_product"));
//            double adap = Double.parseDouble(request.getParameter("adaptability"));
//            int e_id = Integer.parseInt(request.getParameter("e_id"));
//            RecordModel model = new RecordModel(com, work, adap, rel, attitude, att, e_id);
//            String in = EmployeeDAO.InsertRecord(model);
//    }
//
//        if (in.equals("SUCCESS")) {
//
//        }
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
