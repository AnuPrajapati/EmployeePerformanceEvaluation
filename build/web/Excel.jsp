
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
        }
        return cellArrayLisstHolder;
    }
   
 %>
      <%
      String file=request.getAttribute("filename").toString();
  
    ArrayList cellStoreArrayList=null;
               ArrayList dataHolder =readExcelFile(file);
              cellStoreArrayList=(ArrayList)dataHolder.get(0);
           String idd= cellStoreArrayList.get(0).toString();
                   String name= cellStoreArrayList.get(1).toString();
                         String address= cellStoreArrayList.get(2).toString();
                         String phone= cellStoreArrayList.get(3).toString();
                         if(name.contains("'")|| address.contains("'") ){
                             name.replace('\'', ' ');
                              address.replace('\'', ' ');
                           
                         }
                       
                         if(idd.equals("id") && name.equals("name") && address.equals("address")&& phone.equals("phone"))
                         {
    
      con=DBConnection.createConnection();
                stmt =con.createStatement();
               int num=0;
               int num1=0;
               out.print(dataHolder.size());
              
                                for(int i=1;i<dataHolder.size();i++) {
                                     ArrayList  cellList=null;
                                   cellList=(ArrayList)dataHolder.get(i);
                                  
                                   String namee= cellList.get(1).toString();
                         String add= cellList.get(2).toString();
                         String ph = cellList.get(3).toString();
                         out.print("Name="+ namee +"Address="+add+ "Phone="+ph+ "<br>");
                                 int count=0;
          rs=stmt.executeQuery("select * from employee where phone='"+ ph+"'");
                               
        while(rs.next()){
           
        count++;
        }
        if(count>0){
           num1++;  
        continue;

        }
        else{
            int result;
            num++;
            try
            {
         result=stmt.executeUpdate("insert into employee(name,address,phone,id) values('"+namee+"','"+add+"','"+ph+"','1')");
            }catch(Exception ex){
                
            }
         System.out.println("hdhhdhdh");
        }
             }     
                                
                                
                          out.println("<font color=green>Data is successfully inserted!</font> and You have inserted"+ num+"data and dubicated ="+num1);      
                       
                      
  
            
}
else{
out.println("Incorrect file ....");
}
%>

//         
                 </body>
                  </html>