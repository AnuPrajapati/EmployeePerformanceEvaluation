






<%-- 
    Document   : homepage
    Created on : Apr 28, 2019, 5:52:20 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            .home_image{
                position: relative;
            }
           
          
        </style>
        
    </head>
    <body>
          <%
              // to disable caching on the back button of the browser
           
          response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
Cookie[] cookies = null;
String cookie=null;
         // Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
          if( cookies != null ) {
              
          for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("username")){
                          cookie=cookies[i].getValue();
                          
         

       
                }
              }
              
                if (cookie== null) {
                    response.sendRedirect("LoginAccess.jsp");
                }
                else{
            %>

        <jsp:include page="HomeHeader.jsp"/>
<!--          <input type="button" value="Evaluate" name="evaluate" onclick="window.location.href='EvaluateEmployee.jsp'; return false;"/>-->
        
         <div class="container home_image">
        <img class="d-block w-100" src="Contents/images/imghome.jpg" alt="First slide" height="600"/>
        
            
<!--  <button class="btn">Evaluate</button>-->
      <div class="popup">
        <span id="close">&times</span>
        <span class="oopsdata">Oops, No Data Found !!
        <button id="fimbtn">Import   File</button></span>
        <input id="file_input" type="file" name="name" style="display: none;" />
      </div>
    </div>
        
        
        
    


        
<jsp:include page="footer.jsp"/>

<script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>

       
        
      
<% }
}else{
 response.sendRedirect("LoginAccess.jsp");
}%>
       
    </body>
</html>
