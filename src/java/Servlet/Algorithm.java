/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Kmeantest.KMeans;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
            throws ServletException, IOException, Exception {
        String[] valueofeval = new String[4];
        String evalresult = null;

        Cookie[] cookies = null;
        String sid = null;
        cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("id")) {
                sid = cookies[i].getValue();
            }

        }
        int id = Integer.parseInt(sid);

        HttpSession session = request.getSession();
        String status = session.getAttribute("status").toString();
//        int id = (int) session.getAttribute("id");
        HashMap<Integer, Double> hashTableObj = (HashMap<Integer, Double>) session.getAttribute("map");
        String exits = EmployeeDAO.ShowResultExits(String.valueOf(id));
        System.out.println("----------" + exits);
        if (exits.equals("Fail")) {

            Object[] o = hashTableObj.values().toArray();
            double[] d = new double[o.length];

            for (int j = 0; j < o.length; j++) {

                d[j] = (double) o[j];

            }

            ArrayList<Double> centroidlist = new ArrayList<Double>();
            for (int i = 0; i < d.length; i++) {
                if (!(centroidlist.contains(d[i]))) {
                    centroidlist.add(d[i]);
                }

            }

            if (centroidlist.size() < 4) {
                for (int i = 0; i < centroidlist.size(); i++) {
                    if (centroidlist.get(i) < 1.6) {
                        valueofeval[i] = EvalResultSet(0);

                    } else if (centroidlist.get(i) < 2.7) {
                        valueofeval[i] = EvalResultSet(1);
                    } else if (centroidlist.get(i) < 4) {
                        valueofeval[i] = EvalResultSet(2);
                    } else {
                        valueofeval[i] = EvalResultSet(3);
                    }

                }
                for (int ii = 0;
                        ii < centroidlist.size(); ii++) {
                    for (int j = 0; j < hashTableObj.size(); j++) {

                        if (hashTableObj.values().toArray()[j].equals(centroidlist.get(ii))) {
                            System.out.println(hashTableObj.values().toArray()[j] + "===" + centroidlist.get(ii) + "===" + ForOtherCentroid(centroidlist.get(ii)));
                            evalresult = ForOtherCentroid(centroidlist.get(ii));

                        } else {
                            continue;
                        }
                        System.out.println((int) hashTableObj.keySet().toArray()[j] + "=" + evalresult);
                        String A = EmployeeDAO.PerformanceResult((int) hashTableObj.keySet().toArray()[j], evalresult);
                    }
//
                }

            } else {
                double centroid[][] = new double[][]{
                    {0, 0, 0, 0},
                    {(double) centroidlist.get(0), (double) centroidlist.get(1), (double) centroidlist.get(2), (double) centroidlist.get(3)}

                };
                //         double[][] result = KMeans.getCentroid(d, Double.parseDouble(max), centroid, hashTableObj);
                double[][] result = KMeans.getCentroid(d, 4, centroid, hashTableObj);

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
            }
            request.getRequestDispatcher(
                    "AllUserRecordDetailsssss.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher(
                    "AllUserRecordDetailsssss.jsp").forward(request, response);

        }

    }

    public static String ForOtherCentroid(double a) {
        String valueresult = null;
        if (a < 1.6) {
            valueresult = EvalResultSet(0);

        } else if (a < 2.7) {
            valueresult = EvalResultSet(1);
        } else if (a < 4) {
            valueresult = EvalResultSet(2);
        } else {
            valueresult = EvalResultSet(3);
        }
        return valueresult;
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
        try {
            processRequest(request, response);
        } catch (Exception x) {
            x.printStackTrace();
            System.out.println("Algo Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception x) {
            x.printStackTrace();
            System.out.println("Algo Error");
        }
    }

}
