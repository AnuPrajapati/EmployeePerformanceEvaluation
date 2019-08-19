
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="homepage.jsp"><img src="Contents/images/imageedit_6_5743435733.png" width="350" height="60" class="d-inline-block align-top" alt=""></a>    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">      

       <span class="navbar-text">
        <ul class="navbar-nav" >
            <li class="nav-item">
                <%
                   Cookie[] cookies = null;
      String na=null;
                    cookies = request.getCookies();
                    
          if( cookies != null ) {
              for (int i = 0; i < cookies.length; i++) {
                  if(cookies[i].getName().equals("username"))
                  {
             na= cookies[i].getValue();
                  }
             
            }
          
                    
                    String name= (String) session.getAttribute("username");
                    %>
                <%=na%>
            
          </li>
            <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/EPEvaluation_backupforfinal/homepage.jsp">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/EPEvaluation_backupforfinal/EmployeeServlet">Employee</a>
 <!--<a class="nav-link" href="http://localhost:8080/EPEvaluation/ListEmployee.jsp">Employee</a>-->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/EPEvaluation_backupforfinal/LogOut.jsp">Logout</a>
          </li>
        </ul>
      </span>
     
      
    </div>
  </nav>
                <%
                    }%>