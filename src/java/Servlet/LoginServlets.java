/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import model.RegisterDAO;
import model.RegisterModel;

/**
 *
 * @author User
 */
public class LoginServlets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        HttpSession session = request.getSession();
//
//        int a = (int) session.getAttribute("random");
//        out.print(a);
//        String b = request.getParameter("checkrandom");
//        if (Integer.parseInt(b) == a) {
//            out.println("Same");
//        } else {
//            out.println("Different a=" + a + "b=" + b);
//        }

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        RegisterDAO reg = new RegisterDAO();
        RegisterModel individual = reg.ShowIndividual(name, pass);
//        out.println(individual);
        if (individual == null) {

            RequestDispatcher res = request.getRequestDispatcher("Login_Error.jsp");
//            out.println("<font color=red>Either user name or password is wrong.</font>");
            res.include(request, response);
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {

            HttpSession session = request.getSession(true); // reuse existing
            // session if exist
            // or create one

            Cookie username = new Cookie("username", name);

            session.setAttribute("id", individual.getId());

            session.setAttribute("username", name);

            response.addCookie(username);
            // 30 seconds

            response.sendRedirect("homepage.jsp");

        }
    }

}
