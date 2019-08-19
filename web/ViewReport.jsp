<%-- 
    Document   : ViewReport
    Created on : Aug 11, 2019, 10:45:19 PM
    Author     : hasil
--%>
<%
   
 String name = request.getParameter("name").toString();
                String address = request.getParameter("address").toString();
                String phone = request.getParameter("phone").toString();
                 String id = request.getParameter("eid").toString();
                 List<RecordModel> model = EmployeeDAO.ShowIndividualUser(id);

                request.setAttribute("Employee_Record", model);
               
                %>
<%@page import="model.RecordModel"%>
<%@page import="model.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.EmplyeeModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        
        <link href="Contents/css/style.css" rel="stylesheet" type="text/css"/>          
        <link href="Contents/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Contents/fonts/all.css" rel="stylesheet" type="text/css"/>  
        <link href="Contents/css/popup.css" rel="stylesheet" type="text/css"/>
        <style>
            .emplyee_table{
                position: relative;
                
            }

            #MyForm{
                display: none;
                width: 400px;
                border: 1px solid #ccc;
                padding: 14px;
                background: #ececec;
                margin-left: auto;
                margin-right: auto;
                
            }
            
  

        </style>
    </head>

    <body>
        <jsp:include page="HomeHeader.jsp"/>
     

         
         <div class="container">   
            <table style="border-radius: 5px;
    width: 50%;
  margin: auto;
    float: none;">
               
                <tr>
                    <td><img src="Contents/images/Avatar-image.png" style="border-radius: 8px"/></td>
                    <td>
                        <h4><%=name%> </h4>
                        <br/>
                    <%=address%> <br/>
                    <%=phone%><br/>
                           
                    </td>
                </tr>
            </table>
         </div>
            
            
            <div class="container">
            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                <tr>
                    <th> Communication</th>
                    <th>Attendance</th>
                    <th>Attitude</th>
                    <th>Adaptability</th>
                    <th>Work Product</th>
                    <th>Reliability</th>
                    <th> Result</th>
                </tr>
                </thead>
                
                <c:forEach var="tempuser" items="${Employee_Record}" varStatus="loop" >         
                    <c:set var="rid" value="${tempuser.r_id}" scope="request"/>
                    <%
                     
                    %>


                    <tr>
                        <td>${tempuser.communication}</td>
                        <td>${tempuser.attendance}</td>
                        <td>${tempuser.attitude}</td>
                        <td>${tempuser.adaptability}</td>
                        <td>${tempuser.work_product}</td>
                        <td>${tempuser.reliablity}</td>
                        <td>

                   ${tempuser.final_result}
           </td>     
         </tr>             
                   
                </c:forEach>

            
                  
                

            </table>
            </div>

           
        
        <jsp:include page="footer.jsp"/>
        <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {

                $("#Mybtn").on('click', function () {
                    $("#MyForm").toggle();
                });
            });
        </script>
    </body>
</html>