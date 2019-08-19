

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
        <style>
            .emplyee_table{
                position: relative;
                width: 100%;                
                margin-right: auto;
                margin-left: auto;
                padding-top:120px;
                left:400px;
                padding-bottom: 40px;
                

            }
            .table-box{                
                width: 600px;
                height: 400px;               
                padding-right: 20px;
                padding-left: 20px;
                padding-top: 40px;
                background: #fff;
                box-shadow: 0 10px 100px rgba(255, 0, 0, 0.5);
            }




        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="emplyee_table">
            
                <form action="JavaMailJsp.jsp" method="post" class="table-box">  
                    <h4>Enter a gmail Address</h4><hr style="padding-top:20px">  
                    <div class="form-group">
                        <h6>Email address</h6>
                        <input type="email" name="email" class="form-control" id="email">
                    </div>
<div class="col text-center">
      <button type="submit"  class="btn btn-default">Send Verification Code</button>
    </div>
                    
                </form>
                
           
        </div>
                <jsp:include page="footer.jsp"/>

                </body>
                </html>
