package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.EmployeeDAO;
import DBConnect.DBConnection;
import java.sql.Connection;

public final class PieChart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("window.onload = function() {\n");
 
//     int id = (int) session.getAttribute("id");
   
//    int good=EmployeeDAO.getCountGood(id);
//        int great=EmployeeDAO.getCountGreat(id);
//            int poor=EmployeeDAO.getCountPoor(id);
//                int fair=EmployeeDAO.getCountFair(id);
   int good=EmployeeDAO.getCountGood(1);
        int great=EmployeeDAO.getCountGreat(1);
            int poor=EmployeeDAO.getCountPoor(1);
                int fair=EmployeeDAO.getCountFair(1);
 


      out.write("\n");
      out.write("       \n");
      out.write("var options = {\n");
      out.write("\texportEnabled: true,\n");
      out.write("\tanimationEnabled: true,\n");
      out.write("\ttitle:{\n");
      out.write("\t\ttext: \"Evaluated Result\"\n");
      out.write("\t},\n");
      out.write("\tlegend:{\n");
      out.write("\t\thorizontalAlign: \"right\",\n");
      out.write("\t\tverticalAlign: \"center\"\n");
      out.write("\t},\n");
      out.write("\tdata: [{\n");
      out.write("\t\ttype: \"pie\",\n");
      out.write("\t\tshowInLegend: true,\n");
      out.write("\t\ttoolTipContent: \"<b>{name}</b>: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${y}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" (#percent%): {y}\",\n");
      out.write("\t\tindexLabel: \"{name}\",\n");
      out.write("\t\tlegendText: \"{name} (#percent%)\",\n");
      out.write("\t\tindexLabelPlacement: \"inside\",\n");
      out.write("\t\tdataPoints: [\n");
      out.write("\t\t\t{ y: ");
      out.print(great);
      out.write(", name: \"Great\" },\n");
      out.write("\t\t\t{ y:  ");
      out.print(good);
      out.write(", name: \"Good\" },\n");
      out.write("\t\t\t{ y: ");
      out.print(fair);
      out.write(", name: \"Fair\" },\n");
      out.write("\t\t\t{ y:  ");
      out.print(poor);
      out.write(", name: \"Poor\" }\n");
      out.write("\t\t]\n");
      out.write("\t}]\n");
      out.write("};\n");
      out.write("$(\"#chartContainer\").CanvasJSChart(options);\n");
      out.write("\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("<div id=\"chartContainer\" style=\"height: 300px; width: 100%;\"></div>\n");
      out.write("<script type=\"text/javascript\" src=\"https://canvasjs.com/assets/script/jquery-1.11.1.min.js\"></script>  \n");
      out.write("<script type=\"text/javascript\" src=\"https://canvasjs.com/assets/script/jquery.canvasjs.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
