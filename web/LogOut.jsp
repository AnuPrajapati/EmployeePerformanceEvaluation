<%-- 
    Document   : LogOut
    Created on : Aug 12, 2019, 11:36:34 AM
    Author     : hasil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% 

Cookie[] array= request.getCookies(); 
for(int i=0; i<array.length; i++)
{
if(array[i].getName().equals("username"))
{
out.println("<br/>");
out.println("Name of the cookie : " + array[i].getName() + "<br/>");
out.println("Value in cookie : " + array[i].getValue());

//Deleting the cookie
array[i].setMaxAge(0);
response.addCookie(array[i]);
session.invalidate();
response.sendRedirect("index.jsp");
}
       }


           %>
    </body>
</html>
