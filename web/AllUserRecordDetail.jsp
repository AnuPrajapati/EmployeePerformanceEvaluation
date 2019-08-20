<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.HashMap"%>
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
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
       <style>
           .emplyee_table{
                position: relative;

            }
            #search {
                background-image: url('Contents/images/iconfinder_Search_858732.png');
                background-position: 10px 10px;
                background-repeat: no-repeat;                
                width: 30%;  
                border-radius: 25px;
                background-size: 30px; 
                float: right;
                font-size: 16px;
                padding: 12px 20px 12px 40px;
                border: 1px solid #ddd;
                margin-bottom: 12px;
            }
            #MyForm{
                display: none;
                width: 400px;
                border: 1px solid #ccc;
                padding: 14px;
                background: #ececec;
            }	
            .table-box{
                top: 10;
                width: 1120px;
                height: 591px;
                overflow-y: scroll;
                background: #fff;
                box-shadow: 4px 4px 10px 20px #ddd;
            }
            th{
                position: sticky;
                top: 0;
                background: #00bcd4;
                color: #fff;
            }
            tr th:nth-child(1){
                width: 100px;
                text-align: center;
                background: #FA8072;
            }
            tr td:nth-child(1){
                background: #00bcd4;
                color: #fff;
                width: 60px;;
            }

        </style>
        <script language="javascript" type="text/javascript">
            
        function test() {
            var listVal = document.getElementById("searchstatus").value;
            if (! listVal) {
               alert(listVal);
            }
           
      }
   

</script>
    </head>

    <body>
                 <jsp:include page="HomeHeader.jsp"/>


            <%
 String id = session.getAttribute("id").toString();
  String status = request.getParameter("searchstatus");
  System.out.println("staus"+ status);
  

 //getsearch
             try{
                 
                 List<EmplyeeModel> model  = EmployeeDAO.ShowAllUserRecord(Integer.parseInt(id),Integer.parseInt(status),0,null);
                  
                      request.setAttribute("Employee_Record", model);
                    
             }catch(Exception x){
                 
             }

          

            %>
<%!
 HashMap<Integer, Double> number = new HashMap<Integer, Double>();
%>
 


<div class="container emplyee_table">
    <div id="form-wrapper" style="max-width:210px;margin:auto;">
       <form method="get" class="form-inline">
        <div class="form-group mb-2">    
        <select id="searchstatus" class="form-control" name="searchstatus" >
            <%    int name = EmployeeDAO.getCountForStatus(Integer.parseInt(id));
            %>
           
            <%
                for (int i = name; i > 0; i--) {
            %>
            <option value="<%=i%>" >Record <%=i%></option>
            <%
              }%>

        </select>
        </div>
              
              <input type="submit" class="btn btn-info mx-sm-3 mb-2" value="ok">
        
        
    </form>
              </div>
              <div class="table-box">
    <table class="table table-bordered">
        <tr>
            <th>S.N</th>
                    <th> Name</th>
                    <th> Communication</th>
                    <th>Attendance</th>
                    <th>Attitude</th>
                    <th>Adaptability</th>
                    <th>Work Product</th>
                    <th>Reliability</th>

                    
                    
                </tr>
              <c:set  var="ino" value="0" scope="page"/>
                <c:forEach var="tempuser" items="${Employee_Record}" >         

<c:set var="mean" value="${tempuser.recordmodel.mean}" scope="request"/>
<c:set var="eid" value="${tempuser.e_id}" scope="request"/>


                   <c:set var="ino" value="${ino + 1}" scope="page"/>
                        <tr>
                            
                            <td>${ino}</td>
                        
                          <td>${tempuser.name}</td>   
                        <td>${tempuser.recordmodel.communication}</td>
                        <td>${tempuser.recordmodel.attendance}</td>
                        <td>${tempuser.recordmodel.attitude}</td>
                        <td>${tempuser.recordmodel.adaptability}</td>
                        <td>${tempuser.recordmodel.work_product}</td>
                        <td>${tempuser.recordmodel.reliablity}</td>

                      



             
                    

                    </tr>
             
                  

                    <%
      
//
            number.put((Integer)request.getAttribute("eid"), (Double)request.getAttribute("mean"));

%>
  
       
                </c:forEach>
                 
                <%
                    session.setAttribute("map", number);
                    %>
 
            </table>
            </div>
     
        </div>
             
           <div class="container">       
        <button type="submit" class="btn btn-lg" onclick="window.location.href='Algorithm'" >Perform</button>
          <button type="submit" class="btn btn-lg" onclick="window.location.href='AddEmpRecord.jsp'" >Add Employee Record</button>
        </div>

              
          
                        <%--<jsp:forward page = "PerformEpes.jsp" />--%>
        <jsp:include page="footer.jsp"/>
        <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
   
    </body>
</html>