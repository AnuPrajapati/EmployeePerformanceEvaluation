
<%@page import="org.apache.poi.hssf.usermodel.HSSFCell"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFRow"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFSheet"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="org.apache.poi.poifs.filesystem.POIFSFileSystem"%>
<%@page import="DBConnect.DBConnection"%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ page import ="java.util.Date" %>
 <%@ page import ="java.io.*" %>
  <%@ page import ="java.io.FileNotFoundException" %>
  <%@ page import ="java.io.IOException" %>
  <%@ page import ="java.util.Iterator" %>
   <%@ page import ="java.util.ArrayList" %>
   <%@ page import ="javax.servlet.http.HttpServletRequest"%>

 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
  </head>
  <body>
  <%!     
  Connection con;
  PreparedStatement ps=null;
  Statement stmt= null;
  ResultSet rs=null;
  public static ArrayList readExcelFile(String fileName) {
        /**
         * --Define a ArrayList --Holds ArrayList Of Cells
         */

        ArrayList cellArrayLisstHolder = new ArrayList();

        try {
            /**
             * Creating Input Stream*
             */
            FileInputStream myInput = new FileInputStream(fileName);

            /**
             * Create a POIFSFileSystem object*
             */
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            /**zsing the File System*
             */
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            /**
             * Get the first sheet from workbook*
             */
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);

            /**
             * We now need something to iterate through the cells.*
             */
            Iterator rowIter = mySheet.rowIterator();
            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                ArrayList cellStoreArrayList = new ArrayList();
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    cellStoreArrayList.add(myCell);
                }
                cellArrayLisstHolder.add(cellStoreArrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
System.out.println("Error in Excel.jsp");
        }
        return cellArrayLisstHolder;
    }
   
 %>
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
      String file=request.getAttribute("filename").toString();

    ArrayList cellStoreArrayList=null;
               ArrayList dataHolder =readExcelFile(file);
             
              cellStoreArrayList=(ArrayList)dataHolder.get(0);
//           String idd= cellStoreArrayList.get(0).toString();
                   String name= cellStoreArrayList.get(0).toString().toLowerCase();
                         String address= cellStoreArrayList.get(1).toString().toLowerCase();
                         String phone= cellStoreArrayList.get(2).toString().toLowerCase();
                         if(name.contains("'")|| address.contains("'") ){
                             name.replace('\'', ' ');
                              address.replace('\'', ' ');
                           
                         }
                              
                       
                         if(name.equals("name") && address.equals("address")&& phone.equals("phone"))
                         {
    
      con=DBConnection.createConnection();
                stmt =con.createStatement();
               int num=0;
               int num1=0;

              
                                for(int i=1;i<dataHolder.size();i++) {
                                
                                     ArrayList  cellList=null;
                                   cellList=(ArrayList)dataHolder.get(i);
                              
                                   String namee= cellList.get(0).toString();
                                
                         String add= cellList.get(1).toString();
                         String ph = cellList.get(2).toString();
                        System.out.println("Name="+ namee +"Address="+add+ "Phone="+ph+ "");
                                
            int result=0;
            
            try
            {
                    int random = (int) (Math.random() * 100000000) ; 
               
                 System.out.println("Name="+ namee +"Address="+add+ "Phone="+ph+ "id="+id);
         result=stmt.executeUpdate("insert into employee(name,address,phone,id) values('"+namee+"','"+add+"','98"+random+"','"+ id +"')");
         if(result>0){
             response.sendRedirect("/EmployeeServlet");
         }else{
             response.sendRedirect("/EmployeeServlet");
         }
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Error in Excel random"+ ex.getMessage());
                
            }
        
            
        }
             }     
                                
                                
                             
               
                      
  
            
}
else{
                             response.sendRedirect("EPEvaluation_backupforfinal/EmployeeServlet");
out.println("Incorrect file ....");
}
%>
         
                 </body>
                  </html>