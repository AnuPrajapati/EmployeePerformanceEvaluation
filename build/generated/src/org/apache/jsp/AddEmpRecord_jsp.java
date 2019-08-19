package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import DBConnect.DBConnection;
import java.sql.Connection;

public final class AddEmpRecord_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"Contents/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Contents/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement stmt=null;
          
        ResultSet rs = null;
      
          
            String sql = "select * from employee   WHERE id=1 order by e_id";

            stmt = conn.prepareStatement(sql);
int count=0;
            rs = stmt.executeQuery(sql);
            
      out.write("\n");
      out.write("           \n");
      out.write("      \n");
      out.write("            <form method=\"post\" action=\"RecordInsertServlet\">\n");
      out.write("                ");

            while (rs.next()) {
               count++;

      out.write("\n");
      out.write("      \n");
      out.write("                ");
      out.print(rs.getString("name"));
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"container border border-primary\">\n");
      out.write("                   \n");
      out.write(" <div class=\"form-group row\">\n");
      out.write("                    <label class=\"col-sm-5\">Communication</label>\n");
      out.write("                    <div class=\"col-sm-7\">                        \n");
      out.write("                        <input type=\"number\" class=\"form-control\" name='communication");
      out.print( rs.getInt("e_id") );
      out.write("'  min=\"1\" max=\"5\" value=\"1\" step=\"any\">\n");
      out.write("                    </div>\n");
      out.write(" </div>\n");
      out.write("                    <div class=\"form-group row\">\n");
      out.write("                    <label class=\"col-sm-5\">Attendance</label>\n");
      out.write("                    <div class=\"col-sm-7\">                        \n");
      out.write("                        <input type=\"number\" class=\"form-control\" name='attendance");
      out.print( rs.getInt("e_id") );
      out.write("'  min=\"1\" max=\"5\" value=\"1\" step=\"any\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label class=\"col-sm-5\">Attitude </label>\n");
      out.write("                    <div class=\"col-sm-7\">\n");
      out.write("                        <input type=\"number\" class=\"form-control\" name='attitude");
      out.print( rs.getInt("e_id") );
      out.write("'  min=\"1\" max=\"5\" value=\"1\" step=\"any\">                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label class=\"col-sm-5\">Adaptability</label>\n");
      out.write("                    <div class=\"col-sm-7\">   \n");
      out.write("                        <input type=\"number\" class=\"form-control\" name='adaptability");
      out.print( rs.getInt("e_id") );
      out.write("'  min=\"1\" max=\"5\" value=\"1\" step=\"any\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                  <div class=\"form-group row\">\n");
      out.write("                    <label class=\"col-sm-5\">Work Product </label>\n");
      out.write("                    <div class=\"col-sm-7\"> \n");
      out.write("                        <input type=\"number\" class=\"form-control\" name='work_product");
      out.print( rs.getInt("e_id") );
      out.write("'  min=\"1\" max=\"5\" value=\"1\" step=\"any\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label class=\"col-sm-5\">Reliability</label>\n");
      out.write("                    <div class=\"col-sm-7\">                        \n");
      out.write("                        <input type=\"number\" class=\"form-control\" name='reliability");
      out.print( rs.getInt("e_id") );
      out.write("'  min=\"1\" max=\"5\" value=\"1\" step=\"any\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                  \n");
      out.write("\n");
      out.write("           ");
  } 
      out.write("\n");
      out.write("        \n");
      out.write("  <input type=\"hidden\" name=\"count\" value=\"");
      out.print(count);
      out.write("\">\n");
      out.write(" <button type=\"submit\" class=\"btn btn-primary btn-block\">Insert</button>\n");
      out.write("\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("        \n");
      out.write("                ");

            }catch(SQLException x){
                
            }
            
      out.write("\n");
      out.write("    </body>\n");
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
