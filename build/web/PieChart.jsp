<%@page import="model.EmployeeDAO"%>
<%@page import="DBConnect.DBConnection"%>
<%@page import="java.sql.Connection"%>

<div class="container">
<script type="text/javascript">
window.onload = function() {
<% 
     Cookie[] cookies = null;
     String sid=null;
                    cookies = request.getCookies();
                    
        
              for (int i = 0; i < cookies.length; i++) {
                  if(cookies[i].getName().equals("id"))
                  {
             sid= cookies[i].getValue();
                  }
             
            }
//              int status=EmployeeDAO.getCountForStatus(mid)
              String status=session.getAttribute("status").toString();
              System.out.println("shhh"+status);
              int s=Integer.parseInt(status);
              int id=Integer.parseInt(sid);
      String companyname=EmployeeDAO.getCompany(id) ;
    int good=EmployeeDAO.getCountGood(id,s);
        int great=EmployeeDAO.getCountGreat(id,s);
            int poor=EmployeeDAO.getCountPoor(id,s);
                int fair=EmployeeDAO.getCountFair(id,s);
  
 

%>
       
var options = {
	exportEnabled: true,
	animationEnabled: true,
	title:{
		text: "Evaluated Result of <%=companyname %> Company"
	},
	legend:{
		horizontalAlign: "right",
		verticalAlign: "center"
	},
	data: [{
		type: "pie",
		showInLegend: true,
		toolTipContent: "<b>{name}</b>: ${y} (#percent%) : {y}",
		indexLabel: "{name}",
		legendText: "{name} (#percent%)",
		indexLabelPlacement: "inside",
		dataPoints: [
			{ y: <%=great%>, name: "Great" },
			{ y:  <%=good%>, name: "Good" },
			{ y: <%=fair%>, name: "Fair" },
			{ y:  <%=poor%>, name: "Poor" }
		]
	}]
};
$("#chartContainer").CanvasJSChart(options);

}
</script>
      <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
    <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>

    
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
</div>