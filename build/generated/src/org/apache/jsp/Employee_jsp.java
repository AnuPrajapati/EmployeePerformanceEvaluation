package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.RegisterDAO;
import java.util.List;
import model.EmplyeeModel;

public final class Employee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("        <link href=\"Contents/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>          \n");
      out.write("        <link href=\"Contents/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Contents/fonts/all.css\" rel=\"stylesheet\" type=\"text/css\"/>  \n");
      out.write("        <link href=\"Contents/css/popup.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <style>\n");
      out.write("            .emplyee_table{\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            #search {\n");
      out.write("                background-image: url('Contents/images/iconfinder_Search_858732.png');\n");
      out.write("                background-position: 10px 10px;\n");
      out.write("                background-repeat: no-repeat;                \n");
      out.write("                width: 30%;  \n");
      out.write("                border-radius: 25px;\n");
      out.write("                background-size: 30px; \n");
      out.write("                float: right;\n");
      out.write("                font-size: 16px;\n");
      out.write("                padding: 12px 20px 12px 40px;\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                margin-bottom: 12px;\n");
      out.write("            }\n");
      out.write("            .table-box{\n");
      out.write("                top: 10;\n");
      out.write("                width: 1120px;\n");
      out.write("                height: 591px;\n");
      out.write("                overflow-y: scroll;\n");
      out.write("                background: #fff;\n");
      out.write("                box-shadow: 0 10px 100px rgba(255, 0, 0, 0.5);\n");
      out.write("            }\n");
      out.write("            th{\n");
      out.write("                position: sticky;\n");
      out.write("                top: 0;\n");
      out.write("                background: #00bcd4;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("            tr th:nth-child(1){\n");
      out.write("                width: 100px;\n");
      out.write("                text-align: center;\n");
      out.write("                background: #FA8072;\n");
      out.write("            }\n");
      out.write("            tr td:nth-child(1){\n");
      out.write("                background: #00bcd4;\n");
      out.write("                color: #fff;\n");
      out.write("                width: 60px;;\n");
      out.write("            }\n");
      out.write("            .modal-img{\n");
      out.write("                margin-top: -85px;\n");
      out.write("                width: 33%;\n");
      out.write("                border: 5px solid white;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                padding: 5px;\n");
      out.write("                background: #6c757d;\n");
      out.write("            }\n");
      out.write("            @media (max-width: 767px) {\n");
      out.write("                #hero{\n");
      out.write("                    padding:20px 20px 40px\n");
      out.write("                }\n");
      out.write("                #hero .hero-heading h1{\n");
      out.write("                    font-size:30px;\n");
      out.write("                }\n");
      out.write("             \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

             int id = (int) session.getAttribute("id");
             int result = RegisterDAO.existsEmployeeIDofManager(2);
           
              // to disable caching on the back button of the browser
          
            response.setHeader("Cache-Control","no-store");   
            response.setHeader("Pragma","no-cache");   
            response.setHeader ("Expires", "0"); //prevents caching at the proxy server 

                
            
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "HomeHeader.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container emplyee_table\">\n");
      out.write("            <form method=\"GET\"><input type=\"text\" id=\"search\" name=\"search\"  placeholder=\"Search for names..\" title=\"Type in a name\">\n");
      out.write("      <div class=\"table-box\">\n");
      out.write("            </form>\n");
      out.write("       <table class=\"table table-bordered\">\n");
      out.write("           \n");
      out.write("           <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th>S.N</th>\n");
      out.write("                <th> Name</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>Phone</th>                \n");
      out.write("            </tr>\n");
      out.write("           </thead>\n");
      out.write("          \n");
      out.write("                \n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </table>\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"container\">       \n");
      out.write("        <button type=\"submit\" class=\"btn btn-lg\" onclick=\"window.location.href='AllUserRecordDetail.jsp'\" >Show Rating Data</button>\n");
      out.write("          <button type=\"submit\" class=\"btn btn-lg\" onclick=\"window.location.href='AddEmployee.jsp'\" >Add Employee</button>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"modal fade text-center py-5\" style=\"top:30px\" id=\"thanksModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-dialog modal-md\" role=\"document\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <img src=\"https://sunlimetech.com/portfolio/sunlimeuikit/imgs/s.png\" class=\"modal-img\">\n");
      out.write("                            <h3 class=\"pt-5 mb-0 text-secondary\">Welcome to Our EPES Systemt!</h3>\n");
      out.write("                            <p class=\"pb-3 text-muted\"><small>Hope that you enjoy it well! Check also our site</small></p>\n");
      out.write("                            <h3>1. Import from the Computer</h3>\n");
      out.write("                            <form class=\"form-inline\" action=\"UploadFile\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                                <div class=\"form-group mx-sm-3 mb-2\">    \n");
      out.write("                                    <input type=\"file\" class=\"form-control-file\" name=\"filetoupload\">\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-secondary text-white mb-3\">Upload File</button>\n");
      out.write("                            </form>\n");
      out.write("                            <h3>2. Manual Add </h3>\n");
      out.write("                            <a role=\"button\" class=\"btn btn-secondary text-white mb-3\" onclick=\"window.location.href = 'AddEmployee.jsp'\">Manual Add</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write(" <script src=\"Contents/js/jquery-3.4.0.js\" type=\"text/javascript\"></script>\n");
      out.write(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write(" <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("          \n");
      out.write("                \n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("       $(document).ready(function(){           \n");
      out.write("           \n");
      out.write("           $(window).onload(function(){\n");
      out.write("              Popup_check();              \n");
      out.write("           });\n");
      out.write("           \n");
      out.write("           function Popup_check(){\n");
      out.write("               var result = ");
      out.print(result);
      out.write("               \n");
      out.write("               if(result == ''){\n");
      out.write("                   $('#thanksModal').modal(show);  \n");
      out.write("           }\n");
      out.write("           \n");
      out.write("          \n");
      out.write("           \n");
      out.write("       }\n");
      out.write("       });\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("tempuser");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Employee_list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("               \n");
          out.write("              <tr>\n");
          out.write("                  <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.e_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                  <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                  <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                  <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("              </tr>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
