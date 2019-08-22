/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmployeeDAO;
import model.EmplyeeModel;

/**
 *
 * @author hasil
 */
public class AddEmp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        int id = Integer.parseInt(request.getParameter("id"));
        Cookie[] cookies = null;
        String sid = null;
        cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("id")) {
                sid = cookies[i].getValue();
            }

        }
        int id = Integer.parseInt(sid);
        String name = request.getParameter("Name");
        String add = request.getParameter("Address");
        String phone = request.getParameter("Phone");

        EmplyeeModel model = new EmplyeeModel(name, add, phone, id);
        EmployeeDAO dao = new EmployeeDAO();
        String result = dao.UserDetail(model);

        request.setAttribute("su", result);
        RequestDispatcher re = request.getRequestDispatcher("/EmployeeServlet");
        re.forward(request, response);

    }

}
