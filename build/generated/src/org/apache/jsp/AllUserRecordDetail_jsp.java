package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.HashMap;
import model.RecordModel;
import model.EmployeeDAO;
import java.util.List;
import model.EmplyeeModel;

public final class AllUserRecordDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


 HashMap<Integer, Double> number = new HashMap<Integer, Double>();

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
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
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("       <style>\n");
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
      out.write("                height: 591px;\n");
      out.write("                overflow-y: scroll;\n");
      out.write("                background: #fff;\n");
      out.write("                box-shadow: 4px 4px 10px 20px #ddd;\n");
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
      out.write("        <script language=\"javascript\" type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("        function test() {\n");
      out.write("            var listVal = document.getElementById(\"searchstatus\").value;\n");
      out.write("            if (! listVal) {\n");
      out.write("               alert(listVal);\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("      }\n");
      out.write("   \n");
      out.write("\n");
      out.write("</script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("                 ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "HomeHeader.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

 String id = session.getAttribute("id").toString();
  String status = request.getParameter("searchstatus");
  System.out.println("staus"+ status);
  

 //getsearch
             try{
                 
                 List<EmplyeeModel> model  = EmployeeDAO.ShowAllUserRecord(Integer.parseInt(id),Integer.parseInt(status),0,null);
                  
                      request.setAttribute("Employee_Record", model);
                    
             }catch(Exception x){
                 
             }

          

            
      out.write('\n');
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container emplyee_table\">\n");
      out.write("    <div id=\"form-wrapper\" style=\"max-width:210px;margin:auto;\">\n");
      out.write("       <form method=\"Post\" class=\"form-inline\">\n");
      out.write("        <div class=\"form-group mb-2\">    \n");
      out.write("        <select id=\"searchstatus\" class=\"form-control\" name=\"searchstatus\" onchange=\"test()\">\n");
      out.write("            ");
    int name = EmployeeDAO.countStatus(Integer.parseInt(id));
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(name);
      out.write("\" selected=\"selected\">Record");
      out.print(name);
      out.write("</option>\n");
      out.write("            ");

                for (int i = name; i > 0; i--) {
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write(" \" >Record ");
      out.print(i);
      out.write("</option>\n");
      out.write("            ");

              }
      out.write("\n");
      out.write("\n");
      out.write("        </select>\n");
      out.write("        </div>\n");
      out.write("              \n");
      out.write("              <input type=\"submit\" class=\"btn btn-info mx-sm-3 mb-2\" value=\"ok\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </form>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"table-box\">\n");
      out.write("    <table class=\"table table-bordered\">\n");
      out.write("        <tr>\n");
      out.write("            <th>S.N</th>\n");
      out.write("                    <th> Name</th>\n");
      out.write("                    <th> Communication</th>\n");
      out.write("                    <th>Attendance</th>\n");
      out.write("                    <th>Attitude</th>\n");
      out.write("                    <th>Adaptability</th>\n");
      out.write("                    <th>Work Product</th>\n");
      out.write("                    <th>Reliability</th>\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("              ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
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
            if (_jspx_meth_c_set_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write('\n');
            if (_jspx_meth_c_set_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("                   ");
            if (_jspx_meth_c_set_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("\n");
            out.write("                        <tr>\n");
            out.write("                            \n");
            out.write("                            <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ino}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                        \n");
            out.write("                          <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>   \n");
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
            out.write("\n");
            out.write("                      \n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("             \n");
            out.write("                    \n");
            out.write("\n");
            out.write("                    </tr>\n");
            out.write("             \n");
            out.write("                  \n");
            out.write("\n");
            out.write("                    ");

      
//
            number.put((Integer)request.getAttribute("eid"), (Double)request.getAttribute("mean"));


            out.write("\n");
            out.write("  \n");
            out.write("       \n");
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
      out.write("                 \n");
      out.write("                ");

                    session.setAttribute("map", number);
                    
      out.write("\n");
      out.write(" \n");
      out.write("            </table>\n");
      out.write("            </div>\n");
      out.write("     \n");
      out.write("        </div>\n");
      out.write("             \n");
      out.write("           <div class=\"container\">       \n");
      out.write("        <button type=\"submit\" class=\"btn btn-lg\" onclick=\"window.location.href='Algorithm'\" >Show Rating Data</button>\n");
      out.write("          <button type=\"submit\" class=\"btn btn-lg\" onclick=\"window.location.href='AddEmpRecord.jsp'\" >Add Employee</button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("              \n");
      out.write("          \n");
      out.write("                        ");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <script src=\"Contents/js/jquery-3.4.0.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("   \n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ino");
    _jspx_th_c_set_0.setValue(new String("0"));
    _jspx_th_c_set_0.setScope("page");
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_1.setVar("mean");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.recordmodel.mean}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_1.setScope("request");
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_2.setVar("eid");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tempuser.e_id}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_2.setScope("request");
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_3.setVar("ino");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ino + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_3.setScope("page");
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }
}
