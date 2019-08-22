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

            .home_image{
                position: relative;
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
//                String id = session.getAttribute("id").toString();

            Cookie[] cookies = null;
            String sid = null;
            cookies = request.getCookies();

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("id")) {
                    sid = cookies[i].getValue();
                }

            }
            int id = Integer.parseInt(sid);
                int result = RegisterDAO.existsEmployeeIDofManager(id);

              

                // to disable caching on the back button of the browser
                response.setHeader("Cache-Control", "no-store");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Expires", "0"); //prevents caching at the proxy server 


            %>
            <jsp:include page="HomeHeader.jsp"/>
            <div class="container home_image">
                <img class="d-block w-100" src="Contents/images/imghome.jpg" alt="First slide" height="600"/>
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
                                    <input type="file" class="form-control-file" name="filetoupload" id="fileUpload">
                                </div>
                                <!--<button type="submit" id="upload" class="btn btn-secondary text-white mb-3" onclick="Upload()">Upload File</button>-->
                                <input type="submit" id="btnUpload" class="btn btn-secondary text-white mb-3" value="Upload File"/>
                                    <span id="lblError" style="color: red;"></span>

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
                                $(window).on('load', function () {
                                    $('#thanksModal').modal('show');
                                });

                                $("body").on("click", "#btnUpload", function () {
                                    var allowedFiles = [".xls"];
                                    var fileUpload = $("#fileUpload");
                                    var lblError = $("#lblError");
                                    var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
                                    if (!regex.test(fileUpload.val().toLowerCase())) {
                                        lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
                                        return false;
                                    }
                                    lblError.html('');
                                    return true;
                                });


            </script>

        </body>
    </html>