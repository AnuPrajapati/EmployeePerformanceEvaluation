<%-- 
    Document   : AddEmpRecord
    Created on : Aug 19, 2019, 12:25:43 PM
    Author     : hasil
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DBConnect.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Contents/css/bootstrap.css" rel="stylesheet" type="text/css">
        <style>
              .home_image{
                position: relative;
                  
            }
        </style>
    </head>
    <body>

        <jsp:include page="HomeHeader.jsp"/>
        <%
             Cookie[] cookies = null;
     String sid=null;
                    cookies = request.getCookies();
                    
       
              for (int i = 0; i < cookies.length; i++) {
                  if(cookies[i].getName().equals("id"))
                  {
             sid= cookies[i].getValue();
                  }
             
            }
              int id=Integer.parseInt(sid);
            try {
                Connection conn = DBConnection.createConnection();
                PreparedStatement stmt = null;

                ResultSet rs = null;

                String sql = "select * from employee WHERE id=" + id + " order by e_id";

                stmt = conn.prepareStatement(sql);
                int count = 0;
                rs = stmt.executeQuery(sql);
        %>

        <form method="post" action="RecordInsertServlet">
            <div class="container" style="height:520px; overflow-y:auto; width:760px; padding-top: 100px;box-shadow: 0 10px 100px rgba(255, 0, 0, 0.5);">
            <%
                while (rs.next()) {
                    count++;
            %>



                <div class="card border border-info rounded mb-0">
                    <div class="card-body">
                        <h5 class="card-title"><%=rs.getString("name")%></h5>
                        <h6 class="card-subtitle mb-2 text-muted"></h6>
                        <p class="card-text"><div class="form-group row justify-content-md-center">
                            <label class="col-sm-5">Communication</label>
                            <div class="col-sm-3">                        
                                <input type="number" class="form-control" name='communication<%= rs.getInt("e_id")%>'  min="1" max="5" value="1" step="any">
                            </div>
                        </div>
                        <div class="form-group row justify-content-md-center">
                            <label class="col-sm-5">Attendance</label>
                            <div class="col-sm-3">                        
                                <input type="number" class="form-control" name='attendance<%= rs.getInt("e_id")%>'  min="1" max="5" value="1" step="any">
                            </div>
                        </div>
                        <div class="form-group row justify-content-md-center">
                            <label class="col-sm-5">Attitude </label>
                            <div class="col-sm-3">
                                <input type="number" class="form-control" name='attitude<%= rs.getInt("e_id")%>'  min="1" max="5" value="1" step="any">                        
                            </div>
                        </div>
                        <div class="form-group row justify-content-md-center">
                            <label class="col-sm-5">Adaptability</label>
                            <div class="col-sm-3">   
                                <input type="number" class="form-control" name='adaptability<%= rs.getInt("e_id")%>'  min="1" max="5" value="1" step="any">
                            </div>
                        </div>
                        <div class="form-group row justify-content-md-center">
                            <label class="col-sm-5">Work Product </label>
                            <div class="col-sm-3"> 
                                <input type="number" class="form-control" name='work_product<%= rs.getInt("e_id")%>'  min="1" max="5" value="1" step="any">
                            </div>
                        </div>
                        <div class="form-group row justify-content-md-center">
                            <label class="col-sm-5">Reliability</label>
                            <div class="col-sm-3">                        
                                <input type="number" class="form-control" name='reliability<%= rs.getInt("e_id")%>'  min="1" max="5" value="1" step="any">
                            </div>
                        </div>

                    </div>
                </div>
            
            </br>   

            <%  }%>
            </div>

            
            
            <div class="container">
  <div class="row">
    <div class="col text-center">
        <input type="hidden" name="count" value="<%=count%>">
            <button type="submit" class="btn btn-outline-info btn-lg">Insert</button>
            
    </div>
  </div>
</div>


        </form>

        <%
            } catch (SQLException x) {

             out.println("<script type=\"text/javascript\">");
   out.println("alert('Oops Something went wrong!');");
   out.println("location='AllUserRecordDetail.jsp';");
   out.println("</script>");
            }
        %>
         <jsp:include page="footer.jsp"/>
        
    </body>
</html>