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
        <link href="Contents/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Contents/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            int id = (int) session.getAttribute("id");
            try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement stmt=null;
          
        ResultSet rs = null;
      
          
            String sql = "select * from employee WHERE id="+ id+" order by e_id";

            stmt = conn.prepareStatement(sql);
int count=0;
            rs = stmt.executeQuery(sql);
            %>
           
      
            <form method="post" action="RecordInsertServlet">
                <%
            while (rs.next()) {
               count++;
%>
      
                <%=rs.getString("name")%>
               
                <div class="container border border-primary">
                   
 <div class="form-group row">
                    <label class="col-sm-5">Communication</label>
                    <div class="col-sm-7">                        
                        <input type="number" class="form-control" name='communication<%= rs.getInt("e_id") %>'  min="1" max="5" value="1" step="any">
                    </div>
 </div>
                    <div class="form-group row">
                    <label class="col-sm-5">Attendance</label>
                    <div class="col-sm-7">                        
                        <input type="number" class="form-control" name='attendance<%= rs.getInt("e_id") %>'  min="1" max="5" value="1" step="any">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5">Attitude </label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" name='attitude<%= rs.getInt("e_id") %>'  min="1" max="5" value="1" step="any">                        
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5">Adaptability</label>
                    <div class="col-sm-7">   
                        <input type="number" class="form-control" name='adaptability<%= rs.getInt("e_id") %>'  min="1" max="5" value="1" step="any">
                    </div>
                </div>
                  <div class="form-group row">
                    <label class="col-sm-5">Work Product </label>
                    <div class="col-sm-7"> 
                        <input type="number" class="form-control" name='work_product<%= rs.getInt("e_id") %>'  min="1" max="5" value="1" step="any">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5">Reliability</label>
                    <div class="col-sm-7">                        
                        <input type="number" class="form-control" name='reliability<%= rs.getInt("e_id") %>'  min="1" max="5" value="1" step="any">
                    </div>
                </div>

                </div>
                  

           <%  } %>
        
  <input type="hidden" name="count" value="<%=count%>">
 <button type="submit" class="btn btn-primary btn-block">Insert</button>

                
            </form>
        
                <%
            }catch(SQLException x){
                
            }
            %>
    </body>
</html>
