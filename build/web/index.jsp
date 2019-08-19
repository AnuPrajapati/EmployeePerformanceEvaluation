<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  
  <link href="Contents/css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link href="Contents/fonts/all.css" rel="stylesheet" type="text/css"/>
  <link href="Contents/css/style.css" rel="stylesheet" type="text/css"/>

  <title>Employee Performance Evaluation System</title>
</head>
<body>

       <%
           response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
Cookie[] cookies = null;
       String cookie = null;  
         // Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
        
          if( cookies != null ) {
              for (int i = 0; i < cookies.length; i++) {
                  if(cookies[i].getName().equals("username")){
               cookie = cookies[i].getValue();
                  }
             
            }
//    String username=(String) session.getAttribute("username");
			if (cookie != null) {
				response.sendRedirect("homepage.jsp");
			} else {
				
		
	%>

    <jsp:include page="header.jsp" />

  <div id="myslideshow" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myslideshow" data-slide-to="0" class="active"></li>
      <li data-target="#myslideshow" data-slide-to="1"></li>
      <li data-target="#myslideshow" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
          <img class="d-block w-100 back-image" src="Contents/images/1.jpg" alt="First slide" height="900"/>
        <div class="carousel-caption d-none d-md-block text-center" style="">
          <h3 class="center-text">Employee's Performance  <br> Evaluation System</h3>
        </div>
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="Contents/images/3.jpg" alt="Second slide" height="900"/>
        <div class="carousel-caption d-none d-md-block text-center" style="">
          <h3 class="center-text">Employee's Performance <br>Evaluation System</h3>
        </div>
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="Contents/images/1.jpg" alt="Third slide" height="900"/>
        <div class="carousel-caption d-none d-md-block text-center" style="">
          <h3 class="center-text">Employee's Performance <br>Evaluation System</h3>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#myslideshow" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myslideshow" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

  <div class="container text-center" id="aboutus" style="margin-top:50px;">
    <h2 class="font-weight-bold">ABOUT US</h2><hr>
    <p>Employee is the key element of the organization.
      The success or failure of an organization depends on the employee performance.
      An employee evaluation is hence done to review the workerâ??s job performance.
      Hence, our system basically works on reducing problems and still maximizing results.
      This system also predicts the number of employees those are selected for promotion or designation and training according to their performance.</p>
  </div>

    <div class="container" id="objectives" style="margin-top:80px;">
    <h2 class=" text-center font-weight-bold">OBJECTIVES</h2><hr>
    <p><ul>
            <li>To create and maintain a satisfactory level of performance</li>
            <li>To maintain records in order to determine compensation packages wage structure, salaries raises, training, etc.</li>
            <li>To provide feedback to employees regarding their performance and related status</li>
            <li>To improve current performance</li>
            <li>To assist in career planning decisions</li>
    </ul> 
       
   
  </div>



      <jsp:include page="footer.jsp"/>






  <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
  <script src="Contents/js/popper.min.js" type="text/javascript"></script>
  <script src="Contents/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="Contents/js/script.js" type="text/javascript"></script>
<% 
	}}
		
%>

</body>
</html>