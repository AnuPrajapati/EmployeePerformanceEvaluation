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

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        RegisterDAO reg = new RegisterDAO();
        RegisterModel individual = reg.ShowIndividual(name, pass);
//        out.println(individual);
        if (individual == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid username or password');");
            out.println("location='index.jsp';");
            out.println("</script>");

        } else {

            HttpSession session = request.getSession(true); // reuse existing
            // session if exist
            // or create one

            Cookie username = new Cookie("username", name);
            Cookie id = new Cookie("id", String.valueOf(individual.getId()));

            session.setAttribute("id", individual.getId());

            session.setAttribute("username", name);

            response.addCookie(username);
            response.addCookie(id);
            // 30 seconds

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Login Successful');");
            out.println("location='homepage.jsp';");
            out.println("</script>");

//            response.sendRedirect("homepage.jsp");
        }
    }

}
