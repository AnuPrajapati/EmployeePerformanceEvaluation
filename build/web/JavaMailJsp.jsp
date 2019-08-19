<%@page import="model.RegisterDAO"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>

<%
     

      String host = "smtp.gmail.com";
      String from="epescomp@gmail.com";//Your E-mail-Id
      String pass="Gift4You";      //your e-mail account password

String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
String to = request.getParameter("email"); 
//recipient E-mail-Id
RegisterDAO reg= new RegisterDAO();
String emailexit=reg.ShowManagerIfExit(to);
if(emailexit.equals("Fail")){

String subject ="test mail";
  int random = (int) (Math.random() * ((9999 - 1000) + 1)) + 1000;
           
session.setAttribute("random", random);
String messageText = "Hello dear,"
        + "Your code for EPES is "+ random;
boolean sessionDebug = true;


Properties props = System.getProperties();
props.put("mail.host", host);
props.put("mail.transport.protocol.", "smtp");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.", "true");
props.put("mail.smtp.port", "465");//port number 465 for Secure (SSL) and we can also            use port no 587 for Secure (TLS)
props.put("mail.smtp.socketFactory.fallback", "false");
props.put("mail.smtp.socketFactory.class", SSL_FACTORY);


Session mailSession = Session.getDefaultInstance(props, null);
mailSession.setDebug(sessionDebug);


Message msg = new MimeMessage(mailSession);
msg.setFrom(new InternetAddress(from));
InternetAddress[] address = {new InternetAddress(to)};
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(subject);
msg.setContent(messageText, "text/html");


Transport transport = mailSession.getTransport("smtp");
transport.connect(host, from, pass);


 try {
      transport.sendMessage(msg, msg.getAllRecipients());
      out.println("Send Success");
      boolean WasEmailSent = true;
      
      %>
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
            
                <form action="register.jsp" method="post" class="table-box">  
                       <input type="hidden" name="email" value="<%=to%>"/>
                    <h4>Enter the verification code</h4><hr style="padding-top:20px">
                    <div class="form-group">
                        <h6>Verification Code</h6>
                        <input type="text" name="checkrandom"   class="form-control" placeholder="Enter code"/>
                    </div>
<div class="col text-center">
      <button type="submit"  class="btn btn-default">Verify Code</button>
    </div>
                    
                </form>
                
           
        </div>
                <jsp:include page="footer.jsp"/>

     
      <%
      
      // assume it was sent
     }

catch (Exception err) {
                       boolean WasEmailSent = false; 
                      }
                  transport.close();
}
                  
      %>
      
