package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import model.RecordModel;
import model.EmployeeDAO;
import java.util.List;
import model.EmplyeeModel;

public final class AllUserRecordDetailsssss_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

int i=1;
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
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("        <link href=\"Contents/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>          \n");
      out.write("        <link href=\"Contents/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Contents/fonts/all.css\" rel=\"stylesheet\" type=\"text/css\"/>  \n");
      out.write("        <link href=\"Contents/css/popup.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("           .emplyee_table{\n");
      out.write("                position: relative;\n");
      out.write("\n");
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
      out.write("            #MyForm{\n");
      out.write("                display: none;\n");
      out.write("                width: 400px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                padding: 14px;\n");
      out.write("                background: #ececec;\n");
      out.write("            }\t\n");
      out.write("            .table-box{\n");
      out.write("                top: 10;\n");
      out.write("                width: 1120px;\n");
      out.write("                height: 600px;\n");
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
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "HomeHeader.jsp", out, false);
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                 int id = (int) session.getAttribute("id");
                 System.out.println("id============================"+id);
                 String query = request.getParameter("search");
                 
 
    
             try{
                List<EmplyeeModel> model = EmployeeDAO.ShowAllUserRecord(id,1,1,query);
                      request.setAttribute("Employee_Record", model);
             }catch(Exception x){
                 
             }

          

            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   \n");
      out.write("             <div class=\"container emplyee_table\">\n");
      out.write("            <form method=\"GET\"><input type=\"text\" id=\"search\" name=\"search\"  placeholder=\"Search for names..\" title=\"Type in a name\">\n");
      out.write("      <div class=\"table-box\">\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>S.N</th>\n");
      out.write("                    <th> Name</th>\n");
      out.write("                    <th> Communication</th>\n");
      out.write("                    <th>Attendance</th>\n");
      out.write("                    <th>Attitude</th>\n");
      out.write("                    <th>Adaptability</th>\n");
      out.write("                    <th>Work Product</th>\n");
      out.write("                    <th>Reliability</th>\n");
      out.write("                    <th>Result</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setVar("tempuser");
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Employee_Record}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("         \n");
            out.write("\n");
            out.write("                  \n");
            out.write("                    \n");
            out.write("\n");
            out.write("\n");
            out.write("                    <tr>\n");
            out.write("                        <td>");
            out.print(i++);
            out.write("</td>\n");
            out.write("                          <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.communication}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.attendance}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.attitude}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.adaptability}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.work_product}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.reliablity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        <td> ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.final_result}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    \n");
            out.write("                        <td><form action=\"ViewReport.jsp\" method=\"post\" > \n");
            out.write("                                <input type=\"hidden\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" name=\"name\"/> \n");
            out.write("                                  <input type=\"hidden\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" name=\"address\"/> \n");
            out.write("                                    <input type=\"hidden\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" name=\"phone\"/> \n");
            out.write("                                      <input type=\"hidden\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.e_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" name=\"eid\"/> \n");
            out.write("                                <input type=\"submit\" value=\"View\"/></form>\n");
            out.write("                        </td>\n");
            out.write("                    </tr>\n");
            out.write("\n");
            out.write("                   \n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("               \n");
      out.write("                 \n");
      out.write("            </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "PieChart.jsp", out, false);
      out.write("\n");
      out.write("           \n");
      out.write("                        ");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <script src=\"Contents/js/jquery-3.4.0.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
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
