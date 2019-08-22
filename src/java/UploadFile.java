
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmplyeeModel;

import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author hasil
 */
public class UploadFile extends HttpServlet {

    String savefile = "D:/Anu/";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            boolean ismultipart = ServletFileUpload.isMultipartContent(request);
            if (!ismultipart) {

            } else {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadException ex) {
                    RequestDispatcher re = request.getRequestDispatcher("/Excel.jsp");
                    re.forward(request, response);

                }
                Iterator itr = items.iterator();
                while (itr.hasNext()) {
                    FileItem item = (FileItem) itr.next();
                    if (item.isFormField()) {

                    } else {
                        String itemname = item.getName();
                        if (itemname == null || itemname.equals("")) {
                            continue;
                        }
                        String filename = FilenameUtils.getName(itemname);

                        if (!filename.endsWith("xls")) {
                            out.print("Please import .xls file");
                        } else {
                            File f = new File(savefile + "/" + filename);
                            if (!f.exists()) {
                                item.write(f);
                            } else {

                            }
//                            File f = checkExist(filename);
                            request.setAttribute("filename", f.getAbsolutePath());

                            RequestDispatcher re = request.getRequestDispatcher("/Excel.jsp");
                            re.forward(request, response);

                        }
//

                    }

                }

            }
        } catch (Exception x) {
            System.out.println("Error in uploadFile");
        }

    }

}
