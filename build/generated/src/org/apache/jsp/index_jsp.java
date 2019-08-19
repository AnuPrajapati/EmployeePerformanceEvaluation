package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  \n");
      out.write("  <link href=\"Contents/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("  <link href=\"Contents/fonts/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("  <link href=\"Contents/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("  <title>Employee Performance Evaluation System</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("       ");

           response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
Cookie[] cookies = null;
       String cookie = null;  
         // Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
        
          if( cookies != null ) {
              for (int i = 0; i < cookies.length; i++) {
                  if(cookies[i].getName().equals("username")){
               cookie = cookies[i].getValue();
                  }
             
            }
//    String username=(String) session.getAttribute("username");
			if (cookie != null) {
				response.sendRedirect("homepage.jsp");
			} else {
				
		
	
      out.write("\n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("  <div id=\"myslideshow\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("    <ol class=\"carousel-indicators\">\n");
      out.write("      <li data-target=\"#myslideshow\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("      <li data-target=\"#myslideshow\" data-slide-to=\"1\"></li>\n");
      out.write("      <li data-target=\"#myslideshow\" data-slide-to=\"2\"></li>\n");
      out.write("    </ol>\n");
      out.write("    <div class=\"carousel-inner\">\n");
      out.write("      <div class=\"carousel-item active\">\n");
      out.write("          <img class=\"d-block w-100 back-image\" src=\"Contents/images/1.jpg\" alt=\"First slide\" height=\"900\"/>\n");
      out.write("        <div class=\"carousel-caption d-none d-md-block text-center\" style=\"\">\n");
      out.write("          <h3 class=\"center-text\">Employee's Performance  <br> Evaluation System</h3>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"carousel-item\">\n");
      out.write("        <img class=\"d-block w-100\" src=\"Contents/images/3.jpg\" alt=\"Second slide\" height=\"900\"/>\n");
      out.write("        <div class=\"carousel-caption d-none d-md-block text-center\" style=\"\">\n");
      out.write("          <h3 class=\"center-text\">Employee's Performance <br>Evaluation System</h3>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"carousel-item\">\n");
      out.write("        <img class=\"d-block w-100\" src=\"Contents/images/1.jpg\" alt=\"Third slide\" height=\"900\"/>\n");
      out.write("        <div class=\"carousel-caption d-none d-md-block text-center\" style=\"\">\n");
      out.write("          <h3 class=\"center-text\">Employee's Performance <br>Evaluation System</h3>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <a class=\"carousel-control-prev\" href=\"#myslideshow\" role=\"button\" data-slide=\"prev\">\n");
      out.write("      <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("      <span class=\"sr-only\">Previous</span>\n");
      out.write("    </a>\n");
      out.write("    <a class=\"carousel-control-next\" href=\"#myslideshow\" role=\"button\" data-slide=\"next\">\n");
      out.write("      <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("      <span class=\"sr-only\">Next</span>\n");
      out.write("    </a>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"container text-center\" id=\"aboutus\" style=\"margin-top:50px;\">\n");
      out.write("    <h2 class=\"font-weight-bold\">ABOUT US</h2><hr>\n");
      out.write("    <p>Employee is the key element of the organization.\n");
      out.write("      The success or failure of an organization depends on the employee performance.\n");
      out.write("      An employee evaluation is hence done to review the workerâ??s job performance.\n");
      out.write("      Hence, our system basically works on reducing problems and still maximizing results.\n");
      out.write("      This system also predicts the number of employees those are selected for promotion or designation and training according to their performance.</p>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("    <div class=\"container\" id=\"objectives\" style=\"margin-top:80px;\">\n");
      out.write("    <h2 class=\" text-center font-weight-bold\">OBJECTIVES</h2><hr>\n");
      out.write("    <p><ul>\n");
      out.write("            <li>To create and maintain a satisfactory level of performance</li>\n");
      out.write("            <li>To maintain records in order to determine compensation packages wage structure, salaries raises, training, etc.</li>\n");
      out.write("            <li>To provide feedback to employees regarding their performance and related status</li>\n");
      out.write("            <li>To improve current performance</li>\n");
      out.write("            <li>To assist in career planning decisions</li>\n");
      out.write("    </ul> \n");
      out.write("       \n");
      out.write("   \n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <script src=\"Contents/js/jquery-3.4.0.js\" type=\"text/javascript\"></script>\n");
      out.write("  <script src=\"Contents/js/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("  <script src=\"Contents/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("  <script src=\"Contents/js/script.js\" type=\"text/javascript\"></script>\n");
 
	}}
		

      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
