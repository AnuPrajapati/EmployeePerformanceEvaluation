/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Kmeantest.KMeans;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EmployeeDAO;

/**
 *
 * @author hasil
 */
public class Algorithm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] valueofeval = new String[4];
//

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        HashMap<Integer, Double> hashTableObj = (HashMap<Integer, Double>) session.getAttribute("map");

        Object[] o = hashTableObj.values().toArray();
        double[] d = new double[o.length];
        for (int j = 0; j < o.length; j++) {

            d[j] = (double) o[j];

        }

        double centroid[][] = new double[][]{
            {0, 0, 0, 0},
            {1, 2, 3.5, 4}
        };
//         double[][] result = KMeans.getCentroid(d, Double.parseDouble(max), centroid, hashTableObj);
        double[][] result = KMeans.getCentroid(d, 4, centroid, hashTableObj);
        String evalresult = null;
//        double[][] result = KMeans.getCentroid(d, Double.parseDouble(max));

        double aarayhold[] = new double[4];
        for (int i = 0; i < 4; i++) {
            aarayhold[i] = KMeans.holdcentroid[i];
        }
        double temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4 - 1; j++) {
                if (aarayhold[j - 1] > aarayhold[j]) {
                    temp = aarayhold[j - 1];
                    aarayhold[j - 1] = aarayhold[j];
                    aarayhold[j] = temp;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (KMeans.holdcentroid[i] == aarayhold[j]) {
                    valueofeval[i] = EvalResultSet(j);
                    System.out.println(KMeans.holdcentroid[i] + "=" + EvalResultSet(j));
                }
            }
        }

        for (int ii = 0;
                ii < 4; ii++) {
            for (int j = 0; j < d.length; j++) {

                double a = result[ii][j];
                if (a > 0) {

//
                    evalresult = EmployeeDAO.PerformanceResult((int) result[ii][j], valueofeval[ii]);

                } else {
                    continue;
                }

            }
//

        }
//        session.setAttribute("FromAlgo", evalresult);

        request.getRequestDispatcher(
                "AllUserRecordDetailsssss.jsp").forward(request, response);

    }

    public static String EvalResultSet(int a) {
        String result = null;
        switch (a) {
            case 0:
                result = "Poor";
                break;
            case 1:
                result = "Fair";
                break;
            case 2:
                result = "Good";
                break;
            case 3:
                result = "Great";
                break;

        }
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
