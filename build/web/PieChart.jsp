<%@page import="model.EmployeeDAO"%>
<%@page import="DBConnect.DBConnection"%>
<%@page import="java.sql.Connection"%>

<div class="container">
<script type="text/javascript">
window.onload = function() {
<% 
     int id = (int) session.getAttribute("id");
      String companyname=EmployeeDAO.getCompany(id) ;
    int good=EmployeeDAO.getCountGood(id,1,"Good");
        int great=EmployeeDAO.getCountGood(id,1,"Great");
            int poor=EmployeeDAO.getCountGood(id,1,"Poor");
                int fair=EmployeeDAO.getCountGood(id,1,"Fair");
  
 

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
   
    
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
</div>