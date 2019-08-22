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

            #warning{
                color:orange;
                display: none;
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
                    <input type="email" class="form-control" name="email" id="email"/>
                    <span id="usercheck"></span><i id="userfasuccess" class="userfa fa fa-check"></i><i id="userfaerror" class="userfa fa fa-times"></i>
                </div>
                <div class="col text-center">
                    <!--<button type="submit"  class="btn btn-default">Send Verification Code-->
                    <input type="submit" class="btn btn-default" id="submitbtn" value="Send Verification Code"/>
                </div>

            </form>


        </div>
        <jsp:include page="footer.jsp"/>


        <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Contents/js/jquery.validate.js" type="text/javascript"></script>  

        <script type="text/javascript">

            $(document).ready(function () {
                $('#usercheck').hide();
                var email_err = true;

                $('#email').keyup(function () {
                    user_check();
                });
                function user_check() {
                    var email_val = $('#email').val();
                    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

                    if (email_val.length == '') {
                        $('#usercheck').show();
                        $('#usercheck').html("**Please fill the email");
                        $('#email').css("border", "1.5px solid red");
                        $('#usercheck').focus();
                        $('#usercheck').css("color", "red");
                        $('#userfaerror').css("display", "block");
                        $('#userfasuccess').css("display", "none");
                        email_err = false;
                        return false;
                    } else
                    if (!mailformat.test(email_val)) {
                        $('#usercheck').show();
                        $('#usercheck').html("**Please fill valid the email");
                        $('#email').css("border", "1.5px solid red");
                        $('#usercheck').focus();
                        $('#usercheck').css("color", "red");
                        $('#userfaerror').css("display", "block");
                        $('#userfasuccess').css("display", "none");
                        email_err = false;
                        return false;
                    } else {
                        $('#email').css("border", "1.5px solid green");
                        $('#userfasuccess').css("display", "block");
                        $('#userfaerror').css("display", "none");
                        $('#usercheck').hide();
                    }

                }

                $('#submitbtn').click(function () {
                    email_err = true;
                    user_check();

                    if (email_err == true) {
                        return true;
                    } else {
                        return false;
                    }
                });

            });
        </script>


    </body>
</html>