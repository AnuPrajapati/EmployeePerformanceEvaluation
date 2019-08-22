

<%@page import="java.util.HashMap"%>
<%@page import="model.RecordModel"%>
<%@page import="model.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.EmplyeeModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


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

            }
            #search {
                background-image: url('Contents/images/iconfinder_Search_858732.png');
                background-position: 10px 10px;
                background-repeat: no-repeat;                
                width: 30%;  
                border-radius: 25px;
                background-size: 30px; 
                float: right;
                font-size: 16px;
                padding: 12px 20px 12px 40px;
                border: 1px solid #ddd;
                margin-bottom: 12px;
            }
            #MyForm{
                display: none;
                width: 400px;
                border: 1px solid #ccc;
                padding: 14px;
                background: #ececec;
            }	
            .table-box{
                top: 10;
                width: 1120px;
                height: 600px;
                overflow-y: scroll;
                background: #fff;
                box-shadow: 0 10px 100px rgba(255, 0, 0, 0.5);
            }
            th{
                position: sticky;
                top: 0;
                background: #00bcd4;
                color: #fff;
            }
            tr th:nth-child(1){
                width: 100px;
                text-align: center;
                background: #FA8072;
            }
            tr td:nth-child(1){
                background: #00bcd4;
                color: #fff;
                width: 60px;;
            }

        </style>
    </head>

    <body>
        <jsp:include page="HomeHeader.jsp"/>



        <%
            Cookie[] cookies = null;
            String sid = null;
            cookies = request.getCookies();

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("id")) {
                    sid = cookies[i].getValue();
                }

            }
            int id = Integer.parseInt(sid);
            System.out.println("id============================" + id);
            String query = request.getParameter("search");
String status=session.getAttribute("status").toString();
            out.println(status+"ssdetails");

            try {
                List<EmplyeeModel> model = EmployeeDAO.ShowAllUserRecord(id, Integer.parseInt(status), 1, query);
                request.setAttribute("Employee_Record", model);
            } catch (Exception x) {
      x.printStackTrace();
                 System.out.println("Error in AllUserRecordDetailssss.jsp");
            }


        %>





        <div class="container emplyee_table">
            <form method="GET"><input type="text" id="search" name="search"  placeholder="Search for names.." title="Type in a name">
                <div class="table-box">
            </form>



            <table class="table table-bordered">
                <tr>
                    <th>S.N</th>
                    <th> Name</th>
                    <th> Communication</th>
                    <th>Attendance</th>
                    <th>Attitude</th>
                    <th>Adaptability</th>
                    <th>Work Product</th>
                    <th>Reliability</th>
                    <th>Result</th>
                    <th>Action</th>

                </tr>
                <c:set  var="ino" value="0" scope="page"/>
                <c:forEach var="tempuser" items="${Employee_Record}" >         

                    <c:set var="ino" value="${ino + 1}" scope="page"/>
                    <tr>

                        <td>${ino}</td>
                        <td>${tempuser.name}</td>
                        <td>${tempuser.recordmodel.communication}</td>
                        <td>${tempuser.recordmodel.attendance}</td>
                        <td>${tempuser.recordmodel.attitude}</td>
                        <td>${tempuser.recordmodel.adaptability}</td>
                        <td>${tempuser.recordmodel.work_product}</td>
                        <td>${tempuser.recordmodel.reliablity}</td>
                        <td> ${tempuser.recordmodel.final_result}</td>

                        <td><form action="ViewReport.jsp" method="post" > 
                                <input type="hidden" value="${tempuser.name}" name="name"/> 
                                <input type="hidden" value="${tempuser.address}" name="address"/> 
                                <input type="hidden" value="${tempuser.phone}" name="phone"/> 
                                <input type="hidden" value="${tempuser.e_id}" name="eid"/> 
                                <input type="submit" value="View"/></form>
                        </td>
                    </tr>


                </c:forEach>


            </table>                 
        </div>             

    </div>
    <jsp:include page="PieChart.jsp"/>


    <%--<jsp:forward page = "PerformEpes.jsp" />--%>
    <jsp:include page="footer.jsp"/>

    <script src="Contents/js/jquery-3.4.0.js" type="text/javascript"></script>
    <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
    <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>

</body>
</html>