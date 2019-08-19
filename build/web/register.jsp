  <%
     int a = (int) session.getAttribute("random");
      
        String b = request.getParameter("checkrandom");
        if (a!=Integer.parseInt(b)) {
            out.println("Invalid number");
        } else {
            
  String email=request.getParameter("email");
           

       
    %>
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
           
            i.compnyfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 5px;
            }             
            #compnyfasuccess{
                color:green;
                display: none;
            }
            #compnyfaerror{
                color:red;
                display:none;
            }
            
            i.managerfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 60px;
            }             
            #managerfasuccess{
                color:green;
                display: none;
                
            }
            #managerfaerror{
                color:red;
                display:none;
            }
            
            i.emailfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 115px;
            }             
            #emailfasuccess{
                color:green;
               display:none;
            }
            #emailfaerror{
                color:red;
                display:none;
            }
            
            i.passwordfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 170px;
            }             
            #passwordfasuccess{
                color:green;
                display:none;
              
                
            }
            #passwordfaerror{
                color:red;
                display:none;
            }
            i.repasswordfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 225px;
            }             
            #repasswordfasuccess{
                color:green;
                display:none;
                
                
            }
            #repasswordfaerror{
                color:red;
                display:none;
            }
            #warning{
                color:orange;
                display: none;
            }
        </style>
        
    </head>
    <jsp:include page="header.jsp"/>
    <body style="background-color: #b1dfbb; text-align: center;">
      

        <div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="Contents/images/logo_white.png" alt=""/>
				<h3>Welcome</h3>
				<p>You are 30 seconds away from creating your own account</p>
				<input type="submit" name=" " value="Login" onclick="location.href='LoginAccess.jsp';"/><br/>
			</div>
			<div class="col-md-9 register-right">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
						<h3 class="register-heading">Register to Access EPES</h3>
                                                <form method="post" action="RegisterServlets">
							<div class="row register-form justify-content-md-center">
								<div class="col-md-8">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Company Name *" name="companyname" id="companyname"/>
                                                                                <span id="companycheck"></span><i id="compnyfasuccess" class="compnyfa fa fa-check"></i><i id="compnyfaerror" class="compnyfa fa fa-times"></i>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Manager Name *" name="managername" id="managername"/>
                                                                                <span id="managercheck"></span><i id="managerfasuccess" class="managerfa fa fa-check"></i><i id="managerfaerror" class="managerfa fa fa-times"></i>
                                                                               <!-- <span id="famangname"><i id="success" class="fa fa-check"></i>
                                                                                <i id="error" class="fa fa-times"></i>
                                                                                <i id="warning" class="fa fa-exclamation"></i></span>-->
									</div>
                                                                        <div class="form-group">
                                                                            <input type="email" class="form-control" readonly name="emailid" value="<%=email%>" id="emailid"/> 
                                                                                <span id="emailcheck"></span><i id="emailfasuccess" class="emailfa fa fa-check"></i><i id="emailfaerror" class="emailfa fa fa-times"></i>
                                                                        </div>
									<div class="form-group">
										<input type="password" class="form-control" placeholder="Password *" name="password" id="password" />
                                                                                <span id="passwordcheck"></span><i id="passwordfasuccess" class="passwordfa fa fa-check"></i><i id="passwordfaerror" class="passwordfa fa fa-times"></i>
									</div>
									<div class="form-group">
										<input type="password" class="form-control"  placeholder="Confirm Password *" name="repassword" id="repassword" />
                                                                                <span id="repasswordcheck"></span><i id="repasswordfasuccess" class="repasswordfa fa fa-check"></i><i id="repasswordfaerror" class="repasswordfa fa fa-times"></i>
									</div>
                                                                    
                                                                    <input type="hidden" class="" value="Either username or Password Error"/>
                                                                  
								</div>
                                                            <input type="submit" class="btnRegister" id="submitbtn" value="Register"/>
							</div>
						</form>
					</div>      


				</div>
			</div>
            </div>

	</div>
     
        
  
       <script type="text/javascript">
   
       $(document).ready(function(){           
           $('#companycheck').hide(); 
           $('#managercheck').hide();
           $('#emailcheck').hide();           
           $('#passwordcheck').hide();  
           $('#repasswordcheck').hide();  
                      
           var company_err = true;
           var mang_err = true;
           var email_err = true;
           var password_err = true;
           var repassword_err = true;
           
           $('#companyname').keyup(function(){
              company_check();              
           });
           function company_check(){
               var company_val = $('#companyname').val();
               
               if(company_val.length==''){
                   $('#companycheck').show();                   
                   $('#companycheck').html("**Please fill the username");
                   $('#companyname').css("border","1.5px solid red");
                   $('#companycheck').focus();
                   $('#companycheck').css("color","red");
                   $('#compnyfaerror').css("display","block");
                   $('#compnyfasuccess').css("display","none");
                   
                   company_err = false;
                   return false;
               }else{
                   $('#companyname').css("border","1.5px solid green");
                   $('#compnyfasuccess').css("display","block");
                   $('#compnyfaerror').css("display","none");
                   $('#companycheck').hide();
               }
               
               if((company_val.length < 3)){
                   $('#companycheck').show();
                   $('cmpnyerror').show();
                   $('#companycheck').html("**Company name must be atleat 3 charcter");
                   $('#companycheck').focus();
                   $('#companycheck').css("color","red");
                   $('#companyname').css("border","1.5px solid red");
                   $('#compnyfaerror').css("display","block");
                   $('#compnyfasuccess').css("display","none");
                   company_err = false;
                   return false;
               }else{
                   $('#companycheck').hide();
                   $('#companyname').css("border","1.5px solid green");
                    $('#compnyfasuccess').css("display","block");
                   $('#compnyfaerror').css("display","none");
               }               
           }
           
           $('#managername').keyup(function(){
              manager_check(); 
           });
           function manager_check(){
               var manager_val = $('#managername').val();
               var alphaExp = /^[a-zA-Z]+$/;
               if(manager_val.length==''){
                   $('#managercheck').show();                   
                   $('#managercheck').html("**Please fill the Manager Name");
                   $('#managercheck').focus();
                   $('#managercheck').css("color","red");   
                   $('#managername').css("border","1.5px solid red");
                   $('#managerfaerror').css("display","block");
                   $('#managerfasuccess').css("display","none");                   
                   company_err = false;
                   return false;
               }else{
                   if(alphaExp.test(manager_val)){
                    $('#managercheck').hide();
                    $('#managername').css("border","1.5px solid green");
                    $('#managerfaerror').css("display","none");
                   $('#managerfasuccess').css("display","block");
                   }else{
                   $('#managercheck').show();
                   $('#managercheck').html("**Symbol and Number are not allowed");
                   $('#managercheck').focus();
                   $('#managercheck').css("color","red");
                   $('#managername').css("border","1.5px solid red");
                   $('#managerfaerror').css("display","block");
                   $('#managerfasuccess').css("display","none");
                   company_err = false;
                   return false;                   
                   }                  
               }               
               if((manager_val.length < 3)){
                   $('#managercheck').show();
                   $('#managercheck').html("**Manager name must be between 3-10");
                   $('#managercheck').focus();
                   $('#managercheck').css("color","red");
                   $('#managername').css("border","1.5px solid red");
                    $('#managerfaerror').css("display","block");
                   $('#managerfasuccess').css("display","none");
                   company_err = false;
                   return false;
               }else{
                   $('#managercheck').hide();
                   $('#managername').css("border","1.5px solid green");
                    $('#managerfaerror').css("display","none");
                   $('#managerfasuccess').css("display","block");
               }
               
               
           }
           
           $('#emailid').keyup(function(){
              email_check(); 
           });
           
           function email_check(){
               var email_val =  $('#emailid').val();
              
               if(email_val.length==''){
                   $('#emailcheck').show();                   
                   $('#emailcheck').html("**Please fill the Email Address");
                   $('#emailcheck').focus();
                   $('#emailcheck').css("color","red");
                   $('#emailid').css("border","1.5px solid red");
                   $('#emailfaerror').css("display","block");
                   $('#emailfasuccess').css("display","none");
                   
                   email_err = false;
                   return false;
               }else{
                   $('#emailcheck').hide();
                    $('#emailid').css("border","1.5px solid green");
                   $('#emailfaerror').css("display","none");
                   $('#emailfasuccess').css("display","block");
               }
               
              
           }
           
           
           
           
           $('#password').keyup(function(){
              password_check(); 
           });
           
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
        
            
            
    </body>
</html>


<%
    }
    %>