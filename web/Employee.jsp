
<%@page import="model.RegisterDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.EmplyeeModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="Contents/css/style.css" rel="stylesheet" type="text/css"/>          
        <link href="Contents/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Contents/fonts/all.css" rel="stylesheet" type="text/css"/>  
        <link href="Contents/css/popup.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
            .table-box{
                top: 10;
                width: 1120px;
                height: 591px;
                overflow-y: scroll;
                background: #fff;
                box-shadow: 0 10px 100px rgba(255, 0, 0, 0.5);
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
            .modal-img{
                margin-top: -85px;
                width: 33%;
                border: 5px solid white;
                border-radius: 50%;
                padding: 5px;
                background: #6c757d;
            }
            @media (max-width: 767px) {
                #hero{
                    padding:20px 20px 40px
                }
                #hero .hero-heading h1{
                    font-size:30px;
                }
             
        </style>
    </head>
    <body>
        <%
             int id = (int) session.getAttribute("id");
             int result = RegisterDAO.existsEmployeeIDofManager(2);
           
              // to disable caching on the back button of the browser
          
            response.setHeader("Cache-Control","no-store");   
            response.setHeader("Pragma","no-cache");   
            response.setHeader ("Expires", "0"); //prevents caching at the proxy server 

                
            %>
        <jsp:include page="HomeHeader.jsp"/>
        <div class="container emplyee_table">
            <form method="GET"><input type="text" id="search" name="search"  placeholder="Search for names.." title="Type in a name">
          
      <div class="table-box">
            </form>
       <table class="table table-bordered">
           
           <thead>
            <tr>
                <th>S.N</th>
                <th> Name</th>
                <th>Address</th>
                <th>Phone</th>                
            </tr>
           </thead>
          
                 <c:set  var="ino" value="0" scope="page"/>
        <c:forEach var="tempuser" items="${Employee_list}">
        <c:set var="ino" value="${ino + 1}" scope="page"/>
                        <tr>
                             <td>${ino}</td>
              
                  <td>${tempuser.name}</td>
                  <td>${tempuser.address}</td>
                  <td>${tempuser.phone}</td>
              </tr>
        </c:forEach>
        </table>
      </div>
      </div>
        <div class="container">       
        <button type="submit" class="btn btn-lg" onclick="window.location.href='AllUserRecordDetail.jsp'" >Show Rating Data</button>
          <button type="submit" class="btn btn-lg" onclick="window.location.href='AddEmployee.jsp'" >Add Employee</button>
        </div>
        
        <div class="modal fade text-center py-5" style="top:30px" id="thanksModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-md" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <img src="https://sunlimetech.com/portfolio/sunlimeuikit/imgs/s.png" class="modal-img">
                            <h3 class="pt-5 mb-0 text-secondary">Welcome to Our EPES Systemt!</h3>
                            <p class="pb-3 text-muted"><small>Hope that you enjoy it well! Check also our site</small></p>
                            <h3>1. Import from the Computer</h3>
                            <form class="form-inline" action="UploadFile" method="post" enctype="multipart/form-data">
                                <div class="form-group mx-sm-3 mb-2">    
                                    <input type="file" class="form-control-file" name="filetoupload">
                                </div>
                                <button type="submit" class="btn btn-secondary text-white mb-3">Upload File</button>
                            </form>
                            <h3>2. Manual Add </h3>
                            <a role="button" class="btn btn-secondary text-white mb-3" onclick="window.location.href = 'AddEmployee.jsp'">Manual Add</a>
                        </div>
                    </div>
                </div>
        </div>
        
        
        <jsp:include page="footer.jsp"/>
 <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          
                
 <script type="text/javascript">
       $(document).ready(function(){           
           
           $(window).onload(function(){
              Popup_check();              
           });
           
           function Popup_check(){
               var result = <%=result%>               
               if(result == ''){
                   $('#thanksModal').modal(show);  
           }
           
          
           
       }
       });
            </script>



 
    </body>
</html>
