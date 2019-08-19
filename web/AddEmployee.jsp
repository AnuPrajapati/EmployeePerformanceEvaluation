<%-- 
    Document   : AddEmployee
    Created on : Aug 8, 2019, 1:00:14 PM
    Author     : User
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
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"  crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Contents/js/jquery.validate.js" type="text/javascript"></script>
        <style>
            i.Namefa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 5px;
            }             
            #Namefasuccess{
                color:green;
                display: none;
            }
            #Namefaerror{
                color:red;
                display:none;
            }
            
             i.Addressfa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 5px;
            }             
            #Addressfasuccess{
                color:green;
                display: none;
            }
            #Addressfaerror{
                color:red;
                display:none;
            }
            
             i.Phonefa{
                position: absolute;
                left: 380px;
                font-size: 25px;
                top: 5px;
            }             
            #Phonefasuccess{
                color:green;
                display: none;
            }
            #Phonefaerror{
                color:red;
                display:none;
            }
            
            .emplyee_table{
                position: relative;
                width: 100%;                
                margin-right: auto;
                margin-left: auto;
                padding-top:180px;
                left:600px;
                padding-bottom: 100px;
            }
            .table-box{                
                width: 620px;
                height: 420px;               
                padding-right: 20px;
                padding-left: 20px;
                padding-top: 40px;
                background: #fff;
                border-radius: 8px;
                box-shadow: 0 10px 100px rgba(255, 0, 0, 0.5);
            }
        </style>
    </head>
    <body>
        <%
             int id = (int) session.getAttribute("id");
            request.getAttribute("su");
//            response.sendRedirect("http://localhost:8080/EPEvaluation_backupforfinal/EmployeeServlet");

        %>
        <jsp:include page="HomeHeader.jsp"/>
        <div class="emplyee_table">

            <form action="AddEmp" method="post" class="table-box">  
               
               
                <div class="form-group">
                    <h6>Name</h6>
                    <input type="text" class="form-control" placeholder="Name *" name="Name" id="Name"/>
                    <span id="Namecheck"></span><i id="Namefasuccess" class="Namefa fa fa-check"></i><i id="Namefaerror" class="Namefa fa fa-times"></i>
                </div>
                <div class="form-group">
                    <h6>Address</h6>
                    <input type="text" class="form-control" placeholder="Address *" name="Address" id="Address"/>
                    <span id="Addresscheck"></span><i id="Addressfasuccess" class="Addressfa fa fa-check"></i><i id="Addressfaerror" class="Addressfa fa fa-times"></i>
                    
                </div>
                <div class="form-group">
                    <h6>Phone</h6>
                    <input type="text" class="form-control" placeholder="Phone *" name="Phone" id="Phone"/>
                    <span id="Phonecheck"></span><i id="Phonefasuccess" class="Phonefa fa fa-check"></i><i id="Phonefaerror" class="Phonefa fa fa-times"></i>
                    
                </div>
                <div class="col text-center">
                   
                    <input type="submit" class="btnRegister" id="submitbtn" value="Insert"/>
                </div>
        </div>
        <jsp:include page="footer.jsp"/>
        
        
        <script type="text/javascript">
       $(document).ready(function(){           
           $('#Namecheck').hide(); 
           $('#Addresscheck').hide();
           $('#Phonecheck').hide();           
                      
           var Name_err = true;
           var Address_err = true;
           var Phone_err = true;
                      
           $('#Name').keyup(function(){
              Name_check();              
           });
           function Name_check(){
               var Name_val = $('#Name').val();
               
               if(Name_val.length==''){
                   $('#Namecheck').show();                   
                   $('#Namecheck').html("**Please fill the Name");
                   $('#Name').css("border","1.5px solid red");
                   $('#Namecheck').focus();
                   $('#Namecheck').css("color","red");
                   $('#Namefaerror').css("display","block");
                   $('#Namefasuccess').css("display","none");
                   
                   Name_err = false;
                   return false;
               }else{
                   $('#Name').css("border","1.5px solid green");
                   $('#Namefasuccess').css("display","block");
                   $('#Namefaerror').css("display","none");
                   $('#Namecheck').hide();
               }
               
               if((company_val.length < 3)){
                   $('#Namecheck').show();
                   $('Namefaerror').show();
                   $('#Namecheck').html("**Nname must be atleat 3 charcter");
                   $('#Namecheck').focus();
                   $('#Namecheck').css("color","red");
                   $('#Name').css("border","1.5px solid red");
                   $('#Namefaerror').css("display","block");
                   $('#Namefasuccess').css("display","none");
                   Name_err = false;
                   return false;
               }else{
                   $('#Namecheck').hide();
                   $('#Name').css("border","1.5px solid green");
                   $('#Namefasuccess').css("display","block");
                   $('#Namefaerror').css("display","none");
               }               
           }
           
           
           $('#Address').keyup(function(){
              Address_check();              
           });
           function Address_check(){
               var Address_val = $('#Address').val();
               
               if(Address_val.length==''){
                   $('#Addresscheck').show();                   
                   $('#Addresscheck').html("**Please fill the Address");
                   $('#Address').css("border","1.5px solid red");
                   $('#Addresscheck').focus();
                   $('#Addresscheck').css("color","red");
                   $('#Adressfaerror').css("display","block");
                   $('#Addressfasuccess').css("display","none");
                   
                   Address_err = false;
                   return false;
               }else{
                   $('#Address').css("border","1.5px solid green");
                   $('#Addressfasuccess').css("display","block");
                   $('#Addressfaerror').css("display","none");
                   $('#Addresscheck').hide();
               }
               
               if((Address_val.length < 3)){
                   $('#Addresscheck').show();
                   $('cmpnyerror').show();
                   $('#Addresscheck').html("**Address must be atleat 3 charcter");
                   $('#Addresscheck').focus();
                   $('#Namecheck').css("color","red");
                   $('#Address').css("border","1.5px solid red");
                   $('#Addressfaerror').css("display","block");
                   $('#Addressfasuccess').css("display","none");
                   Address_err = false;
                   return false;
               }else{
                   $('#Addresscheck').hide();
                   $('#Address').css("border","1.5px solid green");
                   $('#Addressfasuccess').css("display","block");
                   $('#Addressfaerror').css("display","none");
               }               
           }
           
           
           $('#Phone').keyup(function(){
              Phone_check();              
           });
           function Phone_check(){
               var Phone_val = $('#Phone').val();
               var Check_Phone_Val = /^\98([0-9]{8})$/;      
               
               if(!Phone_val.match(Check_Phone_Val)){
                   $('#Phonecheck').show();
                   $('cmpnyerror').show();
                   $('#Phonecheck').html("**Number invalid");
                   $('#Phonecheck').focus();
                   $('#Phonecheck').css("color","red");
                   $('#Phone').css("border","1.5px solid red");
                   $('#Phonefaerror').css("display","block");
                   $('#Phonefasuccess').css("display","none");
                   Phone_err = false;
                   return false;
               }else{
                   $('#Phonecheck').hide();
                   $('#Phone').css("border","1.5px solid green");
                   $('#Phonefasuccess').css("display","block");
                   $('#Phonefaerror').css("display","none");
               }               
           }
          
           $('#submitbtn').click(function(){
            Name_err = true;
            Phone_err = true;
            Address_err = true;
            
            Name_check(); 
            Address_check(); 
            Phone_check(); 
            
            if((Name_err == true) && (Phone_err == true) && (Address_err == true) ){
                return true;
            }else{
                return false;
            }
           });
           
       });
            </script>

    </body>
</html>
