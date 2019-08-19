<%-- 
    Document   : header
    Created on : Apr 17, 2019, 8:12:42 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Employee's Performance Evaluation System Register Form</title>
        <link href="Contents/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Contents/css/register.css" rel="stylesheet" type="text/css"/> 
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"  crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Contents/js/jquery.validate.js" type="text/javascript"></script>
        <style type="text/css">
           
            i.userfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 5px;
            }             
            #userfasuccess{
                color:green;
                display: none;
            }
            #userfaerror{
                color:red;
                display:none;
            }
            
            i.passwordfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 60px;
            }             
            #passwordfasuccess{
                color:green;
                display: none;
                
            }
            #passwordfaerror{
                color:red;
                display:none;
            }
            
           
            #warning{
                color:orange;
                display: none;
            }
        </style>
        
    </head>
    <%
           response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
Cookie[] cookies = null;
String cookie=null;
         
//          Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
          if( cookies != null ) {
              for(int i=0;i<cookies.length;i++){
                    if(cookies[i].getName().equals("username")){
                  cookie=cookies[i].getValue();
                    }
              }
//              String username=cookie.getValue();
//    String username=(String) session.getAttribute("username");
			if (cookie != null) {
				response.sendRedirect("homepage.jsp");
			} else {
				
		
	%>
    <jsp:include page="header.jsp"/>
    <body style="background-color: #b1dfbb; text-align: center;">
        
        <div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="Contents/images/logo_white.png" alt=""/>
				<h3>Welcome</h3>
				<p>You are 30 seconds away from creating your own account</p>
				<input type="submit" name=" " value="Register" onclick="location.href='addEmail.jsp';"/><br/>
			</div>
			<div class="col-md-9 register-right">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
						<h3 class="register-heading">Login to Access EPES</h3>
                                                <form method="post" action="LoginServlets">
							<div class="row register-form justify-content-md-center">
								<div class="col-md-8">
									<div class="form-group">
										<input type="email" class="form-control" placeholder="UserName *" name="username" id="username"/>
                                                                                <span id="usercheck"></span><i id="userfasuccess" class="userfa fa fa-check"></i><i id="userfaerror" class="userfa fa fa-times"></i>
									</div>
									
									
									<div class="form-group">
										<input type="password" class="form-control"  placeholder=" Password *" name="password" id="password" />
                                                                                <span id="passwordcheck"></span><i id="passwordfasuccess" class="passwordfa fa fa-check"></i><i id="passwordfaerror" class="passwordfa fa fa-times"></i>
									</div>
                                                                   
								</div>
                                                            <input type="submit" class="btnRegister" id="submitbtn" value="Login"/>
							</div>
						</form>
					</div>      


				</div>
			</div>
            </div>

	</div>
     
        
  
       <script type="text/javascript">
   
       $(document).ready(function(){           
           $('#usercheck').hide();  
           $('#passwordcheck').hide();  
                      
           var user_err = true;
      
           var password_err = true;
           
           $('#username').keyup(function(){
              user_check();              
           });
           function user_check(){
               var user_val = $('#username').val();
               
               if(user_val.length==''){
                   $('#usercheck').show();                   
                   $('#usercheck').html("**Please fill the username/email");
                   $('#username').css("border","1.5px solid red");
                   $('#usercheck').focus();
                   $('#usercheck').css("color","red");
                   $('#userfaerror').css("display","block");
                   $('#userfasuccess').css("display","none");
                   
                   user_err = false;
                   return false;
               }else{
                   $('#username').css("border","1.5px solid green");
                   $('#userfasuccess').css("display","block");
                   $('#userfaerror').css("display","none");
                   $('#usercheck').hide();
               }
               
              
           }
           
      
           
           function password_check(){
               var passwordstr =  $('#password').val();
               if(passwordstr.length==''){
                   $('#passwordcheck').show();                   
                   $('#passwordcheck').html("**Please fill the password");
                   $('#passwordcheck').focus();
                   $('#passwordcheck').css("color","red");
                    $('#password').css("border","1.5px solid red");
                   $('#compnyfaerror').css("display","block");
                   $('#passwordfasuccess').css("display","none");
                   
                   password_err = false;
                   return false;
               }else{
                   $('#passwordcheck').hide();
                    $('#password').css("border","1.5px solid green");
                   $('#passwordfaerror').css("display","none");
                   $('#passwordfasuccess').css("display","block");
               }
               
               if((passwordstr.length < 3)||(passwordstr.length > 10)){
                   $('#passwordcheck').show();                   
                   $('#passwordcheck').html("**Passworde must be between 3-10");
                   $('#passwordcheck').focus();
                   $('#passwordcheck').css("color","red");
                    $('#password').css("border","1.5px solid red");
                   $('#passwordfaerror').css("display","block");
                   $('#passwordfasuccess').css("display","none");
                   password_err = false;
                   return false;
               }else{
                   $('#passwordcheck').hide();
                    $('#password').css("border","1.5px solid green");
                   $('#passwordfaerror').css("display","none");
                   $('#passwordfasuccess').css("display","block");
               }
           }
           
           $('#repassword').keyup(function(){
              re_password_check(); 
           });
           function re_password_check(){
                var passwordstr =  $('#password').val();
                var repasswordstr = $('#repassword').val();
                if(passwordstr != repasswordstr){
                   $('#repasswordcheck').show();                   
                   $('#repasswordcheck').html("**Password are not Matching");
                   $('#repasswordcheck').focus();
                   $('#repasswordcheck').css("color","red");
                    $('#repassword').css("border","1.5px solid red");
                   $('#repasswordfaerror').css("display","block");
                   $('#repasswordfasuccess').css("display","none");                   
                   repassword_err = false;
                   return false;
               }else{
                   $('#repasswordcheck').hide();
                    $('#repassword').css("border","1.5px solid green");
                   $('#repasswordfaerror').css("display","none");
                   $('#repasswordfasuccess').css("display","block");
               }
           }
           
           $('#submitbtn').click(function(){
            company_err = true;
            password_err = true;
            repassword_err = true;
            
            company_check(); 
            password_check(); 
            re_password_check(); 
            
            if((company_err == true) && (password_err == true) && (password_err == true) ){
                return true;
            }else{
                return false;
            }
           });
           
       });
            </script>
            <%
                }
}%>
    </body>
</html>


